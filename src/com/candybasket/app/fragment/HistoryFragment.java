package com.candybasket.app.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.candybasket.util.etc.CBLog;

public class HistoryFragment extends BaseFragment{

	public static final String TAG = CoupleFragment.class.getSimpleName();
	
	private Context mContext;
	
	public HistoryFragment(Context mContext) {
		super(TAG);
		this.mContext = mContext;
	}
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		CBLog.d(TAG, "onCreateView()");
		TextView view = new TextView(mContext);
		view.setText(TAG);
        return view;
    }
}
