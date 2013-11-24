package com.candybasket.app;

import com.candybasket.R;
import com.candybasket.model.adapter.G_01_Depth_ImageAdapter;
import com.candybasket.wiget.InfinitePagerAdapter;
import com.candybasket.wiget.InfiniteViewPager;
import com.google.analytics.tracking.android.EasyTracker;

import android.app.Activity;
import android.os.Bundle;

public class G_01_Depth extends Activity {

	private InfiniteViewPager  mPager;
	
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.g_01_depth);
        
        int pagerPosition = getIntent().getIntExtra("position", 0);
		String[] imageUrls = getIntent().getStringArrayExtra("images");
        
        setLayout();
        
        mPager.setAdapter(new InfinitePagerAdapter(
        		new G_01_Depth_ImageAdapter(G_01_Depth.this, imageUrls)
				)
		  );
        
        mPager.setCurrentItem(pagerPosition);
	}
	
	@Override
	public void onStart(){
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
	public void onStop(){
	    super.onPause();
	    EasyTracker.getInstance(this).activityStop(this);
	}
	
	private void setLayout(){ 
		mPager = (InfiniteViewPager) findViewById(R.id.depth_pager);
	}
	
}

