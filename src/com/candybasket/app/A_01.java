package com.candybasket.app;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.candybasket.R;
import com.candybasket.util.etc.FontUtil;
import com.google.analytics.tracking.android.EasyTracker;

public class A_01 extends Activity {

	private static String TAG = A_01.class.getSimpleName();
	
	private Button btnLoginView, btnSignup, btnLogin;
	private TextView findEmail, findPassword, titleFindEmail;
	private RelativeLayout loginView, findEmailView;
	private ImageView btnCloseLogin, btnCloseFindEmail;
	private EditText editMail, editPassword;
	
	private boolean isLoginView = false, isFindEmailView = false;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a_01);
        
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
    	
    	btnLoginView = (Button) findViewById(R.id.btn_login_view); 
    	btnSignup = (Button) findViewById(R.id.btn_signup); 
    	btnLogin = (Button) findViewById(R.id.btn_login);
    	findEmail = (TextView) findViewById(R.id.find_imail); 
    	findPassword = (TextView) findViewById(R.id.find_password); 
    	loginView = (RelativeLayout) findViewById(R.id.login_view); 
    	btnCloseLogin = (ImageView) findViewById(R.id.btn_close_login);
    	editMail = (EditText) findViewById(R.id.editEmail);
    	editPassword = (EditText) findViewById(R.id.editPassword);
    	findEmailView = (RelativeLayout) findViewById(R.id.find_email_view); 
    	btnCloseFindEmail = (ImageView) findViewById(R.id.btn_close_find_email);
    	titleFindEmail = (TextView) findViewById(R.id.title_find_email); 
    	
    	setLayoutStyle();
    	setLayoutAction();
    }
    
    private void setLayoutStyle(){

    	btnLoginView.setText("로그인");
    	btnLoginView.setTextColor(Color.WHITE);
    	btnLoginView.setTypeface(FontUtil.loadTypeface(A_01.this));
    	
    	btnSignup.setText("회원가입");
    	btnSignup.setTextColor(Color.WHITE);
    	btnSignup.setTypeface(FontUtil.loadTypeface(A_01.this));
    	
    	btnLogin.setText("로그인");
    	btnLogin.setTextColor(Color.WHITE);
    	btnLogin.setTypeface(FontUtil.loadTypeface(A_01.this));
    	
    	findEmail.setText("이메일 찾기");
    	findEmail.setTextColor(Color.WHITE);
    	findEmail.setTypeface(FontUtil.loadTypeface(A_01.this));
    	
    	findPassword.setText("비밀번호 찾기");
    	findPassword.setTextColor(Color.WHITE);
    	findPassword.setTypeface(FontUtil.loadTypeface(A_01.this));
    	
    	loginView.setVisibility(View.INVISIBLE);
    	
    	editMail.setHint("이메일");
    	editMail.setHintTextColor(0xffc6c6c6);
    	editPassword.setHint("패스워드");
    	editPassword.setHintTextColor(0xffc6c6c6);
    	
    	findEmailView.setVisibility(View.INVISIBLE);
    	
    	titleFindEmail.setText("이메일찾기");
    	titleFindEmail.setTextColor(Color.WHITE);
    	titleFindEmail.setTypeface(FontUtil.loadTypeface(A_01.this));
    }
    
    private void setLayoutAction(){
    	
    	btnLoginView.setOnClickListener( new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				if(isLoginView == false){
					loginView.setVisibility(View.VISIBLE);
					closeFindEmailView();
				}else{
					loginView.setVisibility(View.INVISIBLE);
				}
				isLoginView = !isLoginView;
			}
		});
    	
    	btnSignup.setOnClickListener( new View.OnClickListener() {
			@Override
			public void onClick(View view) {

		        Intent intent = new Intent(A_01.this, A_02.class);
		        startActivity(intent);
		        finish();
		        
			}
		});

    	btnLogin.setOnClickListener( new View.OnClickListener() {
			@Override
			public void onClick(View view) {

			}
		});
    	
    	btnCloseLogin.setOnClickListener( new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				closeLoginView();
			}
		});
    	
    	findEmail.setOnClickListener( new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				if(isFindEmailView == false){
					findEmailView.setVisibility(View.VISIBLE);
					closeLoginView();
				}else{
					findEmailView.setVisibility(View.INVISIBLE);
				}
				isFindEmailView = !isFindEmailView;
			}
		});
    	
    	btnCloseFindEmail.setOnClickListener( new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				closeFindEmailView();
			}
		});
    	
    }
    
    private void closeLoginView(){
    	if(loginView.getVisibility() == View.VISIBLE){
			loginView.setVisibility(View.INVISIBLE);
			isLoginView = !isLoginView;
		}
    }
    
    private void closeFindEmailView(){
    	if(findEmailView.getVisibility() == View.VISIBLE){
			findEmailView.setVisibility(View.INVISIBLE);
			isFindEmailView = !isFindEmailView;
		}
    }
}

