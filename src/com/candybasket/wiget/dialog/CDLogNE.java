package com.candybasket.wiget.dialog;

import com.candybasket.R;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * @author ilsung
 * @date 20130930
 * @param Context mContext
 * <pre>
 * Network에러 다이얼로그
 * 네트워크를 확인해 주세요\n(Wifi나 3G/LTE 연결 필요)
 * </pre>
 */
public class CDLogNE extends Dialog{
	
	private Button cdlgText;
	private ImageView cdlgButton;
	private TextView cdlgTextYes, cdlgTextNo;
	private boolean isCheckYes = false;
	private boolean isCheckNo = false;
	
	public CDLogNE(final Context mContext) {
        super(mContext);
        
        requestWindowFeature(Window.FEATURE_NO_TITLE);  
        this.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT)); //주위 테두리 하얗게
        setContentView(R.layout.cdialog_2);

        cdlgText = (Button)findViewById(R.id.cdlgText);
        cdlgButton = (ImageView)findViewById(R.id.cdlgButton);
        cdlgTextYes = (TextView)findViewById(R.id.cdlgTextYes);
        cdlgTextNo = (TextView)findViewById(R.id.cdlgTextNo);
        
        cdlgText.setText("네트워크를 확인해 주세요\n(Wifi나 3G/LTE 연결 필요)");
        cdlgTextYes.setText("네트워크 설정");
        cdlgTextNo.setText("확인");
        
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
						
						Intent intent = new Intent("android.settings.SETTINGS");
				    	intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
				    	mContext.startActivity(intent);
						
						dismiss();
					}
					if(isCheckNo == true){
						isCheckNo = false;
	
						cdlgButton.setBackgroundResource(R.drawable.dialog_button_02_9);

						dismiss();
					}
					
					break;
			}
			return true;
        }});
    }
}


