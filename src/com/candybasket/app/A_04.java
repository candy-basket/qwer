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

public class A_04 extends Activity {

	private static String TAG = A_04.class.getSimpleName();
	
	private TextView mTitle;
	private ImageView btnGoA01;
	
	private EditText mInputMyNumber, mInputPartnerNumber;
	
	private Button btnNext;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a_04);
        /*
        Intent intent = new Intent(A_00.this, G_01.class);
        startActivity(intent);
        finish();
        */
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
    	
    	mTitle = (TextView) findViewById(R.id.title_a04);
    	btnGoA01 = (ImageView) findViewById(R.id.btn_go_a01);
    	//mInputMyNumber = (EditText) findViewById(R.id.input_mynumber);
    	//mInputPartnerNumber = (EditText) findViewById(R.id.input_partnernumber);
    	//btnNext = (Button) findViewById(R.id.btn_next);
    	
    	setLayoutStyle();
    	setLayoutAction();
    }
    
    private void setLayoutStyle(){
    	mTitle.setText("상대방과 연동");
    	mTitle.setTextColor(Color.WHITE);
    	mTitle.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 30);
    	mTitle.setTypeface(FontUtil.loadTypeface(A_04.this)); 
    	/*
    	mInputMyNumber.setHint("내 전화번호");
    	mInputMyNumber.setHintTextColor(0xffc6c6c6);
    	
    	mInputPartnerNumber.setHint("상대방 전화번호");
    	mInputPartnerNumber.setHintTextColor(0xffc6c6c6);
    	
    	btnNext.setText("연 동 !");
    	btnNext.setTextColor(Color.WHITE);
    	btnNext.setTypeface(FontUtil.loadTypeface(A_04.this)); 
    	*/
    }
    
    private void setLayoutAction(){
    	
    	btnGoA01.setOnClickListener( new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				Intent intent = new Intent(A_04.this, A_01.class);
				startActivity(intent);
				finish();
			}
		});
    	/*
    	btnNext.setOnClickListener( new View.OnClickListener() {
			@Override
			public void onClick(View view) {

			}
		});
    	*/
    }
}

