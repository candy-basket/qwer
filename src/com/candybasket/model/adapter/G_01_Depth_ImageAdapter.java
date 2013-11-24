package com.candybasket.model.adapter;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.Volley;
import com.candybasket.R;
import com.candybasket.util.volley.DiskBitmapCache;
import com.candybasket.wiget.ViewTouchImage;

import android.content.Context;
import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class G_01_Depth_ImageAdapter extends PagerAdapter {
	
	private String[] images;
	private LayoutInflater inflater;
	private Context mContext;
	
	private RequestQueue mRequestQueue;
    private ImageLoader imageLoader;
	
	public G_01_Depth_ImageAdapter(Context mContext, String[] images){
		this.mContext = mContext;
		this.images = images;
		this.inflater = (LayoutInflater)this.mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		this.mRequestQueue = Volley.newRequestQueue(mContext);
		//this.imageLoader = new ImageLoader(mRequestQueue, new BitmapLruCache(BitmapLruCache.getDefaultLruCacheSize()));
		this.imageLoader = new ImageLoader(mRequestQueue, new DiskBitmapCache(mContext.getExternalCacheDir()));
	}
	
	@Override
	public Object instantiateItem(ViewGroup view, int position) {
		
		View convertView = inflater.inflate(R.layout.g_01_depth_image_row, view, false);
		ViewTouchImage imageView = (ViewTouchImage) convertView.findViewById(R.id.depth_store_image);
		
		imageLoader.get(images[position], ImageLoader.getImageListener(imageView,R.drawable.ic_launcher, R.drawable.ic_error));
		imageView.setImageUrl(images[position], imageLoader);
		
		((ViewPager) view).addView(convertView, 0);
		
		return convertView;
	}
	
	@Override
	public int getCount() {
		return images.length;
	}
	@Override
	public boolean isViewFromObject(View view, Object object) {
		return view.equals(object);
	}
	
	@Override
	public void destroyItem(ViewGroup container, int position, Object object) {
		((ViewPager) container).removeView((View) object);
	}
	
	//TODO 밑의 3개의 오버라이드는 추후 성능 향상에 사용될것이라 생각됨
	//TODO 예를들면 onResume onPause 상태의 저장값? 지금은 onResume 될 당시의 이미지를 다시 받아오는것같다.
	@Override
	public void restoreState(Parcelable state, ClassLoader loader) {
	}

	@Override
	public Parcelable saveState() {
		return null;
	}
	@Override
	public void startUpdate(View container) {
	}
	
}
