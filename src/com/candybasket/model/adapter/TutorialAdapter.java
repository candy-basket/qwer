package com.candybasket.model.adapter;

import com.candybasket.R;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

/**
 * com.candybasket.model.adapter
 * TutorialAdapter.java
 * Desc:
 * @Company : Candy-basket
 * @author     : ilsung
 * @Date        : 2013. 11. 22. 오후 12:16:44
 * @Version    : 1.0.4
 * @See         : 튜토리얼 이미지 4장 
 * @Todo       : 추가로 프리퍼런스를 사용하여 본지 않본지 체크 Root -> tutorial -> A_01
 */
public class TutorialAdapter extends PagerAdapter{

	private Context mContext;
	private LayoutInflater inflater;
	private View mLayout;
	private ImageView mImage;
	
	private int[] imageResource = {R.drawable.a01_landing1,
											 R.drawable.a01_landing2,
											 R.drawable.a01_landing3,
											 R.drawable.a01_landing4};
	
	public TutorialAdapter(Context mContext){
		this.mContext = mContext;
		this.inflater = (LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}
	
	@Override
	public Object instantiateItem(View collection, int position) {
		
		mLayout = inflater.inflate(R.layout.a_tutorial_item, null);
		
		switch (position) {
		case 0:
			mImage = (ImageView)mLayout.findViewById(R.id.tutorial_page_image);
			mImage.setImageResource(imageResource[0]);
			break;
		case 1:
			mImage = (ImageView)mLayout.findViewById(R.id.tutorial_page_image);
			mImage.setImageResource(imageResource[1]);
			break;
		case 2:
			mImage = (ImageView)mLayout.findViewById(R.id.tutorial_page_image);
			mImage.setImageResource(imageResource[2]);
			break;
		case 3:
			mImage = (ImageView)mLayout.findViewById(R.id.tutorial_page_image);
			mImage.setImageResource(imageResource[3]);
			break;
		}
		
		((ViewPager) collection).addView(mLayout,0);
		
		return mLayout;
	}
	
	@Override
	public int getCount() {
		return imageResource.length;
	}

	@Override
	public boolean isViewFromObject(View view, Object object) {
		View mView = (View)object;
		return view == mView;
	}
	
	@Override
	public void destroyItem(View view, int position, Object object) {
		ViewPager viewPager = (ViewPager)view;
		View mView = (View)object;			
		viewPager.removeView(mView);
	}
}
