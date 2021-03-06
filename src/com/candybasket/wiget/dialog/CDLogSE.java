package com.candybasket.wiget.dialog;

import com.candybasket.R;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.Button;

/**
 * @author ilsung
 * @date 20131018
 * @param Context mContext
 * <pre>
 * Server에러 다이얼로그
 * 서버가 응답하지 않습니다
 * </pre>
 */
public class CDLogSE extends Dialog{

	private Button cdlgText;
	private Button cdlgButton;
	private boolean isCheck = false;
	private SetActionButton mCallback = null;
	
	public interface SetActionButton{
		void setButton();
	}
	
	public void setCallback(SetActionButton mCallback){
		this.mCallback = mCallback;
	}
	
	public CDLogSE(Context mContext){
		
		super(mContext);
		requestWindowFeature(Window.FEATURE_NO_TITLE);  
		this.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT)); //주위 테두리 하얗게
		setContentView(R.layout.cdialog_1);
		
		cdlgText = (Button)findViewById(R.id.cdlgText);
		cdlgButton = (Button)findViewById(R.id.cdlgButton);
    
		cdlgText.setText("서버가 응답하지 않습니다.");
		cdlgButton.setText("확인");
		
		cdlgButton.setOnTouchListener(new View.OnTouchListener(){
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				switch (event.getAction()) {
				case MotionEvent.ACTION_DOWN:
					
					cdlgButton.setBackgroundResource(R.drawable.dialog_button_01_pushed_9);
					
					if(isCheck == false){
						isCheck = true;
					}
			
					break;
		
				case MotionEvent.ACTION_UP:
					
					if(isCheck == true){
						isCheck = false;
						cdlgButton.setBackgroundResource(R.drawable.dialog_button_01_9);
					
						if(mCallback != null){
							mCallback.setButton();
						}
							
						dismiss();
					}
				
					break;
				}
		return true;
    }});
	}
}
