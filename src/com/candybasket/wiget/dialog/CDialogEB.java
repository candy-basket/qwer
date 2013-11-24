package com.candybasket.wiget.dialog;

import com.candybasket.R;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;

/**
 * @author ilsung
 * @date 20130930
 * @param Context mContext
 * @param String message
 * <pre>
 * 버튼이 없고 프로그레스바 다이얼로그(이미지로테이션애니메이션)
 * </pre>
 */
public class CDialogEB extends Dialog{
	
	private Context mContext;
	private Button cdlgText;
	private ImageView progressBar;
	
	public CDialogEB(final Context mContext, String message) {
        super(mContext);
        
        this.mContext = mContext;
        requestWindowFeature(Window.FEATURE_NO_TITLE);  
        this.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT)); //주위 테두리 하얗게
        setContentView(R.layout.cdialog_0);

        cdlgText = (Button)findViewById(R.id.cdlgText);
        
        cdlgText.setText(message);

        progressBar = (ImageView)findViewById(R.id.dialog_progressbar);
        
        RotateAnimation rotateAnimation = new RotateAnimation(0, 360, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);

        rotateAnimation.setRepeatCount(RotateAnimation.INFINITE);

        rotateAnimation.setDuration(1200);

        rotateAnimation.setInterpolator(this.mContext, android.R.anim.linear_interpolator);
        
        progressBar.startAnimation(rotateAnimation);
        
    }
}
