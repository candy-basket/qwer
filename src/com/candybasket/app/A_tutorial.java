package com.candybasket.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.Button;

import com.candybasket.R;
import com.candybasket.model.adapter.TutorialAdapter;
import com.google.analytics.tracking.android.EasyTracker;

/**
 * com.candybasket.app
 * A_tutorial.java
 * Desc:
 * @Company : Candy-basket
 * @author     : ilsung
 * @Date        : 2013. 11. 22. 오후 12:36:43
 * @Version    : 1.0.4
 * @See         : 튜토리얼 페이지
 * @Todo       
 */
public class A_tutorial extends Activity {

	private static String TAG = A_tutorial.class.getSimpleName();

	private ViewPager mPager = null;
	private TutorialAdapter mAdapter = null;
	private Button btnGoA01 = null;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a_tutorial);
        
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
    	mPager = (ViewPager)findViewById(R.id.tutorial_pager);
    	mAdapter = new TutorialAdapter(A_tutorial.this);
    	mPager.setAdapter(mAdapter); 
    	btnGoA01 = (Button)findViewById(R.id.btn_go_a01);
    	btnGoA01.setOnClickListener( new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				Intent intent = new Intent(A_tutorial.this, A_01.class);
		        startActivity(intent);
		        finish();
			}
		});
    }
}

