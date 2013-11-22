package com.candybasket.app;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.util.TypedValue;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.MotionEvent;
import android.widget.ImageView;
import android.widget.TextView;

import com.candybasket.R;
import com.candybasket.model.adapter.A_03_Adapter;
import com.candybasket.util.etc.FontUtil;
import com.google.analytics.tracking.android.EasyTracker;

public class A_03 extends Activity {

	private static String TAG = A_03.class.getSimpleName();
	
	private static ViewPager mPager;
	
	private TextView mTitle;
	
	private ImageView btnGoA01, btnBack;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a_03);
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
    
    public static  void move(int item){
		if(mPager != null){
			//mPager.setCurrentItem(item);
			mPager.setCurrentItem(item, true);
		}
	}
    
    private void setLayout(){
    	
    	btnGoA01 = (ImageView)findViewById(R.id.btn_go_a01); 
    	btnBack = (ImageView)findViewById(R.id.btn_back); 
    	
    	mPager = (ViewPager)findViewById(R.id.pager);
    	mTitle = (TextView)findViewById(R.id.title_a03);
    	
    	mPager.setAdapter(new A_03_Adapter(A_03.this));
    	mPager.setOffscreenPageLimit(A_03_Adapter.PAGE_COUNT);
    	
    	setLayoutStyle();
    	setLayoutAction();
    }
    
    private void setLayoutStyle(){
    
    	mTitle.setText("기본정보입력");
    	mTitle.setTextColor(Color.WHITE);
    	mTitle.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 30);
    	mTitle.setTypeface(FontUtil.loadTypeface(A_03.this));
    }
    
    private void setLayoutAction(){
    	
    	mPager.setOnTouchListener(new OnTouchListener(){           
			@Override
			public boolean onTouch(View arg0, MotionEvent arg1) {
				//리턴값이 원래는 false인데 true로 줘서 viewpager의 이벤트를 먹통으로 만듬
				return true;
			}
        });
    	
    	btnGoA01.setOnClickListener( new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				Intent intent = new Intent(A_03.this, A_01.class);
				startActivity(intent);
				finish();
			}
		});
    	
    	btnBack.setOnClickListener( new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				if(mPager.getCurrentItem() != 0){
					move(mPager.getCurrentItem() - 1);
				}
			}
		});
    	
    }
}

