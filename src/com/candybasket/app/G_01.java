package com.candybasket.app;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.candybasket.R;
import com.candybasket.wiget.CTextView;
import com.candybasket.wiget.CustomStoreAnimation;
import com.candybasket.wiget.InfiniteViewPager;
import com.nhn.android.maps.NMapActivity;
import com.nhn.android.maps.NMapView;
import com.nhn.android.mapviewer.overlay.NMapOverlayManager;

public class G_01 extends NMapActivity {

	private static String TAG = G_01.class.getSimpleName();
	
	private LinearLayout reviewLayout, evaluationLayout, storeInfoLayout;
	private TextView mPlaceName, mPlaceAdress, mPlacePhoneNumber, mPlaceOpenHour, mPlaceCloseHour, mPlaceParking;
	private CTextView mPlacePrice, mPlaceDetail;
	private ImageView btnCall, btnBack, btnPagerLeft, btnPagerRight;
	private InfiniteViewPager mPager;
	
	private NMapView mMapView;
	//private NMapViewerResourceProvider mMapViewerResourceProvider;
	private NMapOverlayManager mOverlayManager; 
	
	private G_01_LodingTask task = null;
	
	private ImageView imageView1, imageView2, imageView3, imageView4;
	private CustomStoreAnimation animation;
	private boolean toggle = true;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.g_01);
        /*
        Intent intent = new Intent(A_00.this, G_01.class);
        startActivity(intent);
        finish();
        */

    }
    
    @Override
	public void onResume(){
	    super.onResume();
	}
	
	@Override
	public void onPause(){
	    super.onPause();
	}

}

