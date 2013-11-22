package com.candybasket.app;

import com.candybasket.R;
import com.google.analytics.tracking.android.EasyTracker;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;

/**
 * com.candybasket
 * A_00.java
 * Desc:
 * @Company : Candy-basket
 * @author     : ilsung
 * @Date        : 2013. 11. 4. 오전 10:51:23
 * @Version    : 1.0.4
 * @See          : 스플래시 스크린
 * @Todo       
 */
public class A_00 extends Activity {

	//private A_00_LodingTask task = null;
	
	private static String TAG = A_00.class.getSimpleName();
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a_00);
        //A_01
        Intent intent = new Intent(A_00.this, A_tutorial.class);
        startActivity(intent);
        finish();
        

    }
    
    @Override
    public void onStart() {
    	super.onStart();
    	EasyTracker.getInstance(this).activityStart(this);
    }
    
    @Override
	public void onResume(){
	    super.onResume();
	    //task = new A_00_LodingTask(A_00.this, false);
        //task.execute();
	    
	}
	
	@Override
	public void onPause(){
	    super.onPause();
	    //task.cancel();
	}
    
    @Override
    public void onStop() {
    	super.onStop();
    	EasyTracker.getInstance(this).activityStop(this);
    }
}
