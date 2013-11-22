package com.candybasket.app;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.Window;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.candybasket.R;
import com.candybasket.util.etc.FontUtil;
import com.candybasket.wiget.PagerSlidingTabStrip;
import com.candybasket.wiget.PagerSlidingTabStrip.TabSwipeSelector;
import com.google.analytics.tracking.android.EasyTracker;

public class CBMain extends Activity {

	private static String TAG = ActivityTemplet.class.getSimpleName();
	
	private PagerSlidingTabStrip tabs;
	private ViewPager pager;
	public TextView navText;
	private TabSwipeSelector mCallback;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        Window window = getWindow();
		boolean useTitleFeature = false;
		// If the window has a container, then we are not free
		// to request window features.
		if (window.getContainer() == null) {
		    useTitleFeature = window.requestFeature(Window.FEATURE_CUSTOM_TITLE);
		}
        
        setContentView(R.layout.cb_main);
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
    
    void setLayout(boolean useTitleFeature, Window window){
		
		if (useTitleFeature) {
		    window.setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.navi_cb);
		    // Set up the custom title

		    navText = (TextView) findViewById(R.id.navText);
		    navText.setTypeface(FontUtil.loadTypeface(CBMain.this));
		    navText.setText("바스켓");
		}
		
		tabs = (PagerSlidingTabStrip) findViewById(R.id.tabs);
		
		//TODO 맨처음 바스켓 아이콘 온으로 표시 하기
		
		pager = (ViewPager) findViewById(R.id.pager);
		
		mCallback = new TabSwipeSelector() {
			
			@Override
			public void setAction(int position, LinearLayout tabsContainer) {
				
				RelativeLayout[] tabView = new RelativeLayout[4]; 
				ImageView[] tabImageView = new ImageView[4];
				for(int i = 0 ; i < 4 ; i ++){
					tabView[i] = (RelativeLayout) tabsContainer.getChildAt(i);
					tabImageView[i] = (ImageView)tabView[i].findViewById(R.id.tab_img);
					tabImageView[i].setFocusable(true);
				}
				
				switch (position) {
				case 0 : 
					navText.setText("바스켓");
					tabImageView[0].setImageResource(R.drawable.tab_basket_on);
					tabImageView[1].setImageResource(R.drawable.tab_history_off);
					tabImageView[2].setImageResource(R.drawable.tab_couple_off);
					tabImageView[3].setImageResource(R.drawable.tab_more_off);
				break;
				case 1 : 
					navText.setText("데이트 히스토리");
					tabImageView[0].setImageResource(R.drawable.tab_basket_off);
					tabImageView[1].setImageResource(R.drawable.tab_history_on);
					tabImageView[2].setImageResource(R.drawable.tab_couple_off);
					tabImageView[3].setImageResource(R.drawable.tab_more_off);
				break;
				case 2 : 
					navText.setText("우리");
					tabImageView[0].setImageResource(R.drawable.tab_basket_off);
					tabImageView[1].setImageResource(R.drawable.tab_history_off);
					tabImageView[2].setImageResource(R.drawable.tab_couple_on);
					tabImageView[3].setImageResource(R.drawable.tab_more_off);
				break;
				case 3 : 
					navText.setText("더보기");
					tabImageView[0].setImageResource(R.drawable.tab_basket_off);
					tabImageView[1].setImageResource(R.drawable.tab_history_off);
					tabImageView[2].setImageResource(R.drawable.tab_couple_off);
					tabImageView[3].setImageResource(R.drawable.tab_more_on);
				break;
				}
			}
	    };
	}
}

