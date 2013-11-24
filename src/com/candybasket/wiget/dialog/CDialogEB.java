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
 * ��ư�� ���� ���α׷����� ���̾�α�(�̹��������̼Ǿִϸ��̼�)
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
        this.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT)); //���� �׵θ� �Ͼ��
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
