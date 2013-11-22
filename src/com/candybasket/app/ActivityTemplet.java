package com.candybasket.app;

import android.app.Activity;
import android.os.Bundle;

import com.candybasket.R;
import com.google.analytics.tracking.android.EasyTracker;

public class ActivityTemplet extends Activity {

	private static String TAG = ActivityTemplet.class.getSimpleName();
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a_00);
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
}

