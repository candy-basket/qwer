package com.candybasket.app;

import android.app.Activity;
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
	private TextView findEmail, findPassword;
	private RelativeLayout loginView;
	private ImageView btnCloseLogin;
	private EditText editMail, editPassword;
	
	private boolean isLoginView = false;
	
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
    }
    
    private void setLayoutAction(){
    	
    	btnLoginView.setOnClickListener( new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				if(isLoginView == false){
					loginView.setVisibility(View.VISIBLE);
				}else{
					loginView.setVisibility(View.INVISIBLE);
				}
				isLoginView = !isLoginView;
			}
		});
    	
    	btnSignup.setOnClickListener( new View.OnClickListener() {
			@Override
			public void onClick(View view) {

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
				if(loginView.getVisibility() == View.VISIBLE){
					loginView.setVisibility(View.INVISIBLE);
					isLoginView = !isLoginView;
				}
			}
		});
    	
    }
}

