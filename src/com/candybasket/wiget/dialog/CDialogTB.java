package com.candybasket.wiget.dialog;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.candybasket.R;

/**
 * @author ilsung
 * @date 20130930
 * @param Context mContext
 * @param String message
 * @param String yesMsg
 * @param String noMsg
 * <pre>
 * 2���� ��ư�� ���� ���̾�α�, callback �������̽� �߰�
 * </pre>
 */
public class CDialogTB extends Dialog{
	
	private Button cdlgText;
	private ImageView cdlgButton;
	private TextView cdlgTextYes, cdlgTextNo;
	private boolean isCheckYes = false;
	private boolean isCheckNo = false;
	private SetActionButton mCallback = null;
	
	public interface SetActionButton{
		void setYesButton();
		void setNoButton();
	}
	
	public void setCallback(SetActionButton mCallback){
		this.mCallback = mCallback;
	}

	
	public CDialogTB(final Context mContext, String message, String yesMsg, String noMsg) {
        super(mContext);
        
        requestWindowFeature(Window.FEATURE_NO_TITLE);  
        this.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT)); //���� �׵θ� �Ͼ��
        setContentView(R.layout.cdialog_2);

        cdlgText = (Button)findViewById(R.id.cdlgText);
        cdlgButton = (ImageView)findViewById(R.id.cdlgButton);
        cdlgTextYes = (TextView)findViewById(R.id.cdlgTextYes);
        cdlgTextNo = (TextView)findViewById(R.id.cdlgTextNo);
        
        cdlgText.setText(message);
        cdlgTextYes.setText(yesMsg);
        cdlgTextNo.setText(noMsg);
        
        cdlgButton.setOnTouchListener(new View.OnTouchListener(){
        	@Override
        	public boolean onTouch(View v, MotionEvent event) {
        		int x = (int) event.getX();  
        		//int y = (int) event.getY();

        		switch (event.getAction()) {
        		case MotionEvent.ACTION_DOWN:

					if(v.getWidth()/2 < x){
						if(isCheckNo == false){
							isCheckNo = true;
							
							cdlgButton.setBackgroundResource(R.drawable.dialog_button_02_pushed_02_9);
						}
					}else{
						if(isCheckYes == false){
							isCheckYes = true;
								
							cdlgButton.setBackgroundResource(R.drawable.dialog_button_02_pused_01_9);
						}
					}
					
				break;
			
				case MotionEvent.ACTION_UP:
					
					if(isCheckYes == true){
						isCheckYes = false;
						cdlgButton.setBackgroundResource(R.drawable.dialog_button_02_9);
						
						//Yes������ ��� �ݹ� ����
						//callbackYes
						if(mCallback != null){
							mCallback.setYesButton();
						}
						
						dismiss();
					}
					if(isCheckNo == true){
						isCheckNo = false;
						cdlgButton.setBackgroundResource(R.drawable.dialog_button_02_9);
							
						//No������ ��� �ݹ� ����
						//callbackNo
						if(mCallback != null){
							mCallback.setNoButton();
						}
						
						dismiss();
					}
					
					break;
			}
			return true;
        }});
    }
}


