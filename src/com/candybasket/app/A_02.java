package com.candybasket.app;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.candybasket.R;
import com.candybasket.util.etc.FontUtil;
import com.google.analytics.tracking.android.EasyTracker;

public class A_02 extends Activity {

	private static String TAG = A_02.class.getSimpleName();
	
	private TextView mTitle, mServiceTerm, mPrivacyTerm, mEtcAnd, mEtcAgree;
	private EditText mInputEmail, mInputPassword, mCheckPassword;
	
	private Button mBtnGoA03;
	
	private ImageView btnGoA01;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a_02);
        
        setLayout();
        
        /*
        Intent intent = new Intent(A_00.this, G_01.class);
        startActivity(intent);
        finish();
        */

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
    	mTitle = (TextView) findViewById(R.id.title_a02);
    	mInputEmail = (EditText) findViewById(R.id.input_email);
    	mInputPassword = (EditText) findViewById(R.id.input_password);
    	mCheckPassword = (EditText) findViewById(R.id.check_password);
    	mServiceTerm = (TextView) findViewById(R.id.term_service); 
    	mPrivacyTerm = (TextView) findViewById(R.id.term_privacy); 
    	mEtcAnd = (TextView) findViewById(R.id.etc_and); 
    	mEtcAgree = (TextView) findViewById(R.id.etc_agree); 
    	mBtnGoA03 = (Button) findViewById(R.id.btn_go_a03); 
    	btnGoA01 = (ImageView) findViewById(R.id.btn_go_a01); 
    	setLayoutStyle();
    	setLayoutAction();
    }
    
    private void setLayoutStyle(){
    	mTitle.setText("계정정보입력");
    	mTitle.setTextColor(Color.WHITE);
    	mTitle.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 30);
    	mTitle.setTypeface(FontUtil.loadTypeface(A_02.this));
    	
    	mInputEmail.setHint("이메일");
    	mInputEmail.setHintTextColor(0xffc6c6c6);
    	
    	mInputPassword.setHint("비밀번호(6글자 이상)");
    	mInputPassword.setHintTextColor(0xffc6c6c6);
    	
    	mCheckPassword.setHint("비밀번호 확인");
    	mCheckPassword.setHintTextColor(0xffc6c6c6);
    	
    	mServiceTerm.setText(FontUtil.getUnderLineString("서비스약관"));
    	mServiceTerm.setTextColor(Color.WHITE);
    	mServiceTerm.setTypeface(FontUtil.loadTypeface(A_02.this));
    	
    	mPrivacyTerm.setText(FontUtil.getUnderLineString("개인정보취급방침"));
    	mPrivacyTerm.setTextColor(Color.WHITE);
    	mPrivacyTerm.setTypeface(FontUtil.loadTypeface(A_02.this));
    	
    	mEtcAnd.setText("및");
    	mEtcAnd.setTextColor(Color.WHITE);
    	mEtcAnd.setTypeface(FontUtil.loadTypeface(A_02.this));
    	
    	mEtcAgree.setText("동의");
    	mEtcAgree.setTextColor(Color.WHITE);
    	mEtcAgree.setTypeface(FontUtil.loadTypeface(A_02.this));
    }
    
    private void setLayoutAction(){
    	mBtnGoA03.setOnClickListener( new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				Intent intent = new Intent(A_02.this, A_03.class);
				startActivity(intent);
				finish();
			}
		});
    	
    	btnGoA01.setOnClickListener( new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				Intent intent = new Intent(A_02.this, A_01.class);
				startActivity(intent);
				finish();
			}
		});
    }
}

