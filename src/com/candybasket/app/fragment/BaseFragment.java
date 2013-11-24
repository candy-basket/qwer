package com.candybasket.app.fragment;

import com.candybasket.util.etc.CBLog;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

public abstract class BaseFragment extends Fragment {
	 
    public String TAG = "";

    public BaseFragment(String TAG){
    	this.TAG = TAG;
    }
    
    @Override
    public void onAttach(Activity activity) {
    	CBLog.e(TAG, "onAttach()");
        super.onAttach(activity);
    }
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
    	CBLog.e(TAG, "onCreate()");
        super.onCreate(savedInstanceState);
    }
    
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
    	CBLog.e(TAG, "onViewCreated()");
        super.onViewCreated(view, savedInstanceState);
    }
     
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
    	Log.e(TAG, "onActivityCreated()");
        super.onActivityCreated(savedInstanceState);
    }
 
    @Override
    public void onStart() {
    	Log.e(TAG, "onStart()");
        super.onStart();
    }
 
    @Override
    public void onResume() {
        Log.e(TAG, "onResume()");   
        super.onResume();
    }
     
    @Override
    public void onPause() {
    	Log.e(TAG, "onPause()");    
        super.onPause();
    }
     
    @Override
    public void onStop() {
    	Log.e(TAG, "onStop()");
        super.onStop();
    }
     
    @Override
    public void onDestroyView() {
    	Log.e(TAG, "onDestroyView()"); 
        super.onDestroyView();
    }
     
    @Override
    public void onDestroy() {
    	Log.e(TAG, "onDestroy()");  
        super.onDestroy();
    }
 
    @Override
    public void onDetach() {
    	Log.e(TAG, "onDetach()");
        super.onDetach();
    }
 
    @Override
    public void onSaveInstanceState(Bundle outState) {
    	Log.e(TAG, "onSaveInstanceState()");
        super.onSaveInstanceState(outState);
    }	
 
    @Override
    public void onInflate(Activity activity, AttributeSet attrs, Bundle savedInstanceState) {
    	Log.e(TAG, "onInflate()");  
        super.onInflate(activity, attrs, savedInstanceState);
    }
}

