package com.candybasket.util.async.task;

import java.util.concurrent.Callable;

import net.minidev.json.JSONObject;
import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.candybasket.model.adapter.G_01_ImageAdapter;
import com.candybasket.util.async.AsyncCallback;
import com.candybasket.util.async.AsyncExecutor;
import com.candybasket.util.async.BaseTask;
import com.candybasket.util.constant.CBCODE;
import com.candybasket.util.constant.CBURL;
import com.candybasket.util.constant.JSON;
import com.candybasket.util.etc.SP;
import com.candybasket.util.http.HttpRequest;
import com.candybasket.wiget.CTextView;
import com.candybasket.wiget.InfinitePagerAdapter;
import com.candybasket.wiget.InfiniteViewPager;
import com.candybasket.wiget.nmap.NMapViewerResourceProvider;
import com.nhn.android.maps.NMapView;
import com.nhn.android.mapviewer.overlay.NMapOverlayManager;

public class G_01_LodingTask  extends BaseTask {
	
	private static String TAG = G_01_LodingTask.class.getSimpleName();
	
	private NMapViewerResourceProvider mMapViewerResourceProvider;
	private NMapOverlayManager mOverlayManager;
	
	public G_01_LodingTask(final Context mContext, 
									  boolean hasProgress,
									  final TextView mPlaceName,
									  final TextView mPlaceAdress,
									  final TextView mPlacePhoneNumber,
									  ImageView btnCall,
									  final TextView mPlaceOpenHour,
									  final TextView mPlaceCloseHour,
									  final TextView mPlaceParking,
									  final CTextView mPlacePrice,
									  final CTextView mPlaceDetail,
									  final InfiniteViewPager mPager,
									  LinearLayout reviewLayout,
									  LinearLayout evaluationLayout,
									  final LinearLayout storeInfoLayout,
									  NMapView mMapView){
	
		mMapViewerResourceProvider = new NMapViewerResourceProvider(mContext);
		mOverlayManager = new NMapOverlayManager(mContext, mMapView, mMapViewerResourceProvider);
		
		callable = new Callable<JSONObject>() {
			@Override
    		public JSONObject call() throws Exception {

				JSONObject jsonObject = new JSONObject();
				jsonObject.put("storeIdx", (long) 6);
    			return HttpRequest.getResponseJson(CBURL.store, jsonObject);     
    			
    		}
    	};
    	
    	callback = new AsyncCallback<JSONObject>() {
    		@Override
    		public void onResult(JSONObject result) {
    			Log.e(TAG, "onResult()"); 
    			
    			String resultCode = "";
    			                 
    			if(result.get(JSON.resultCode) instanceof Integer){
    				resultCode = Integer.toString( (Integer)result.get(JSON.resultCode) );
    			}else if(result.get(JSON.resultCode) instanceof String){
    				resultCode = (String) result.get(JSON.resultCode);
    			}
    			
    			if(result.containsKey(JSON.token)){
    				SP.putSharedPreference(mContext, JSON.token, result.get(JSON.token).toString());
    			}
    			if(resultCode.equals(CBCODE.ResultSuccess))
    			{
    				JSONObject jsonStore = (JSONObject) result.get("store");
    				
    				mPlaceName.setText(jsonStore.get("name").toString());
    				
    				mPlaceAdress.setText(jsonStore.get("addr").toString());
    				mPlacePhoneNumber.setText(jsonStore.get("tel").toString());
    				mPlaceOpenHour.setText(jsonStore.get("open").toString());
    				mPlaceCloseHour.setText(jsonStore.get("close").toString());
    				mPlaceParking.setText(jsonStore.get("parking").toString());
    				mPlacePrice.setText(jsonStore.get("pricing").toString());
    				mPlaceDetail.setText(jsonStore.get("desc").toString());


    				mPager.setAdapter(new InfinitePagerAdapter(
    												new G_01_ImageAdapter(mContext, jsonStore.get("picture").toString().split("[|]"))
    												)
    										  );

    				storeInfoLayout.setVisibility(View.VISIBLE);
    			}
    		}
    		
    		@Override
    		public void exceptionOccured(Exception e) {
    			
    		}
    		
    		@Override
    		public void cancelled() {
    			
    		}
    	};
    	
    	task = (AsyncExecutor<JSONObject>) new AsyncExecutor<JSONObject>(mContext, hasProgress)
    			.setCallable(callable)
    			.setCallback(callback);
	}
}
