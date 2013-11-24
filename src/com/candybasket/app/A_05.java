package com.candybasket.app;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.candybasket.R;
import com.candybasket.util.etc.FontUtil;
import com.google.analytics.tracking.android.EasyTracker;

/**
 * com.candybasket.app
 * A_05.java
 * Desc:
 * @Company : Candy-basket
 * @author     : ilsung
 * @Date        : 2013. 11. 24. ���� 7:24:41
 * @Version    : 1.0.4
 * @See         : ��й�ȣ ���� â ����â 3���� ����
 * @Todo       
 */
public class A_05 extends Activity {

	private static String TAG =  A_05.class.getSimpleName();
	
	private TextView mTitle;
	
	private EditText mInputEmail, mInputCode, mInputNewPassword, mInputReNewPassword;
	
	private Button btnSendCode, btnReSendCode, btnConfirmCode, btnChangePassword;
	
	private RelativeLayout contentView, stepView_1, stepView_2, stepView_3;
	
	private ImageView mStatusImage;
	
	RelativeLayout.LayoutParams params  = 
			new RelativeLayout.LayoutParams(LayoutParams.MATCH_PARENT, 
														 LayoutParams.MATCH_PARENT);
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a_05);

        setLayout();
        
    }
    
    @Override
    public void onStart() {
    	super.onStart();
    	EasyTracker.getInstance(this).activityStart(this);
    }
    
    @Override
	public void onResume(){
	    super.onResume();
	}
	
	@Override
	public void onPause(){
	    super.onPause();
	}
    
    @Override
    public void onStop() {
    	super.onStop();
    	EasyTracker.getInstance(this).activityStop(this);
    }
    
    private void setLayout(){
    	
    	contentView = (RelativeLayout) findViewById(R.id.content_view);
    	mTitle = (TextView) findViewById(R.id.title_a05);
    	mStatusImage = (ImageView) findViewById(R.id.status_image);
    	
    	LayoutInflater inflater =  (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    
    	stepView_1 = (RelativeLayout) inflater.inflate(R.layout.a_05_step_1,null);
    	stepView_2 = (RelativeLayout) inflater.inflate(R.layout.a_05_step_2,null);
    	stepView_3 = (RelativeLayout) inflater.inflate(R.layout.a_05_step_3,null);
    	
    	contentView.addView(stepView_1, params);
    	
    	if(stepView_1 != null){
    		
    		mInputEmail = (EditText) stepView_1.findViewById(R.id.input_email);
    		btnSendCode = (Button) stepView_1.findViewById(R.id.btn_send_code);
    	}
    	
    	if(stepView_2 != null){
    		btnReSendCode = (Button) stepView_2.findViewById(R.id.btn_re_send_code);
    		btnConfirmCode = (Button) stepView_2.findViewById(R.id.btn_confirm_code);
    		mInputCode = (EditText) stepView_2.findViewById(R.id.input_code);
    	}
    	
    	if(stepView_3 != null){
    		mInputNewPassword = (EditText) stepView_3.findViewById(R.id.input_new_password);
    		mInputReNewPassword = (EditText) stepView_3.findViewById(R.id.input_re_new_password);
    		btnChangePassword = (Button) stepView_3.findViewById(R.id.btn_change_password);
    	}
    	
    	setLayoutStyle();
    	setLayoutAction();
    }
    
    private void setLayoutStyle(){
    	
    	mTitle.setText("��й�ȣã��");
    	mTitle.setTextColor(Color.WHITE);
    	mTitle.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 30);
    	mTitle.setTypeface(FontUtil.loadTypeface(A_05.this)); 
    
    	mInputEmail.setHint("���Խ� ����ߴ� �̸����� �Է����ּ���.");
    	mInputEmail.setHintTextColor(0xffc6c6c6);
    	
    	btnSendCode.setText("�̸��Ϸ� �����ڵ� �߼�");
    	btnSendCode.setTextColor(Color.WHITE);
    	btnSendCode.setTypeface(FontUtil.loadTypeface(A_05.this)); 
    	
    	btnReSendCode.setText("�����ڵ� ��߼�");
    	btnReSendCode.setTextColor(Color.WHITE);
    	btnReSendCode.setTypeface(FontUtil.loadTypeface(A_05.this)); 
    	
    	btnConfirmCode.setText("Ȯ��");
    	btnConfirmCode.setTextColor(Color.WHITE);
    	btnConfirmCode.setTypeface(FontUtil.loadTypeface(A_05.this)); 

    	mInputCode.setHint("�����ڵ带 �Է��ϼ���.");
    	mInputCode.setHintTextColor(0xffc6c6c6);
    	
    	mInputNewPassword.setHint("���ο� ��й�ȣ�� �Է��ϼ���(6�����̻�)");
    	mInputNewPassword.setHintTextColor(0xffc6c6c6);
    	
    	mInputReNewPassword.setHint("���ο� ��й�ȣ�� �ѹ� �� �Է��ϼ���");
    	mInputReNewPassword.setHintTextColor(0xffc6c6c6);
    	
    	btnChangePassword.setText("�Ϸ�");
    	btnChangePassword.setTextColor(Color.WHITE);
    	btnChangePassword.setTypeface(FontUtil.loadTypeface(A_05.this)); 
    }
    
    private void setLayoutAction(){
    	
    	btnSendCode.setOnClickListener( new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				contentView.removeAllViews();
				contentView.addView(stepView_2, params);	
				
				mStatusImage.setImageResource(R.drawable.a05_02_icon_nav);
			}
		});
    	
    	btnConfirmCode.setOnClickListener( new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				contentView.removeAllViews();
				contentView.addView(stepView_3, params);	
				
				mStatusImage.setImageResource(R.drawable.a05_03_icon_nav);
			}
		});
    	
    }
}

