package com.candybasket.model.adapter;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import com.android.volley.toolbox.Volley;
import com.candybasket.R;
import com.candybasket.app.G_01_Depth;
import com.candybasket.util.volley.DiskBitmapCache;

import android.content.Context;
import android.content.Intent;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;

public class G_01_ImageAdapter extends PagerAdapter{

	private static String TAG = G_01_ImageAdapter.class.getSimpleName();
	
	private String[] images;
	private Context mContext;
	private LayoutInflater inflater;
	private NetworkImageView imageView;
	
	private RequestQueue mRequestQueue;
    private ImageLoader imageLoader;

	public G_01_ImageAdapter(Context mContext, String[] images){
		this.mContext = mContext;
		this.images = images;
		this.inflater = (LayoutInflater)this.mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		this.mRequestQueue = Volley.newRequestQueue(mContext);
		//this.imageLoader = new ImageLoader(mRequestQueue, new BitmapLruCache(BitmapLruCache.getDefaultLruCacheSize()));
		this.imageLoader = new ImageLoader(mRequestQueue, new DiskBitmapCache(mContext.getExternalCacheDir()));
	}

	@Override
	public Object instantiateItem(ViewGroup view, int position) {
		
		View convertView = null;
		convertView = inflater.inflate(R.layout.g_01_image_row, view, false);
		imageView = (NetworkImageView) convertView.findViewById(R.id.store_image);
		
		//imageLoader.get(images[position], ImageLoader.getImageListener(imageView,R.drawable.ic_launcher, R.drawable.ic_error));
		imageView.setImageUrl(images[position], imageLoader);
		((ViewPager) view).addView(convertView, 0);
		
		final int tempPosition = position;
		
		imageView.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				//Log.e("StoreImagePagerAdapter","position -> " + tempPosition);
				
				Intent i = new Intent(mContext, G_01_Depth.class);
				i.putExtra("images", images);
				i.putExtra("position", tempPosition);
				mContext.startActivity(i);
				
			}
		});
		
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
}
