package com.candybasket.model.adapter;

import com.candybasket.R;
import com.candybasket.app.fragment.BasketFragment;
import com.candybasket.app.fragment.CoupleFragment;
import com.candybasket.app.fragment.HistoryFragment;
import com.candybasket.app.fragment.SettingFragment;
import com.candybasket.wiget.PagerSlidingTabStrip.IconTabProvider;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class CBMain_Adapter extends FragmentPagerAdapter implements IconTabProvider  {

	private static String TAG = CBMain_Adapter.class.getSimpleName();
	
	private Context mContext;
	
	private FragmentManager fm;
	
	public static final int[] ICONS = new int[] {
        R.drawable.select_tab_basket,
        R.drawable.select_tab_history,
        R.drawable.select_tab_couple,
        R.drawable.select_tab_more
	};
	
	public CBMain_Adapter(FragmentManager fm, Context mContext) {
		super(fm);
		this.fm = fm;
		this.mContext = mContext;
	}

	@Override
	public int getPageIconResId(int position) {
		return ICONS[position % ICONS.length];
	}

	@Override
	public Fragment getItem(int position) {
		if(position == 0){
			BasketFragment mBasket =  new BasketFragment(mContext);
			return mBasket;
		}else if(position == 1){
			HistoryFragment mHistory =  new HistoryFragment(mContext);         
			return mHistory;
		}else if(position == 2){
			CoupleFragment mCouple =  new CoupleFragment(mContext);
			return mCouple;
		}else if(position == 3){
			SettingFragment mSetting =  new SettingFragment(mContext);
			return mSetting;
		}
		return null;
	}

	@Override
	public int getCount() {
		return ICONS.length;
	}

}
