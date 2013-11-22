package com.candybasket.model.adapter;

import com.candybasket.R;
import com.candybasket.app.A_01;
import com.candybasket.app.A_02;
import com.candybasket.app.A_03;
import com.candybasket.util.etc.FontUtil;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * com.candybasket.model.adapter
 * A_03_Adapter.java
 * Desc:
 * @Company : Candy-basket
 * @author     : ilsung
 * @Date        : 2013. 11. 22. 오후 2:47:04
 * @Version    : 1.0.4
 * @See         : 기본정보입력 페이지 ViewPager Adapter
 * @Todo       
 */
public class A_03_Adapter extends PagerAdapter{

	/**
	 * 페이지의 갯수
	 */
	public static int PAGE_COUNT = 8;
	
	private static String TAG = A_03_Adapter.class.getSimpleName();
	
	private LayoutInflater mInflater;

	private Context mContext;
	private TextView mTitle, mTextLeft, mTextRight;
	private Button btnLeft, btnRight;
	
	public A_03_Adapter(Context mContext){
		this.mContext = mContext;
		mInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}
	
	@Override
	public Object instantiateItem(View pager, int position) {
		
		View mView = mInflater.inflate(R.layout.a_03_item, null,false);
		
		setLayout(mView);
		
		setLayoutStyle();
		
		if(position==0){
			mTitle.setText("나는");
			btnLeft.setBackgroundResource(R.drawable.select_a03_01_btn_student);
			btnRight.setBackgroundResource(R.drawable.select_a03_01_btn_work);
			mTextLeft.setText("학생");
			mTextRight.setText("직장인");
		}else if(position==1){
			mTitle.setText("나는 걷는게");
			btnLeft.setBackgroundResource(R.drawable.select_a03_02_btn_walk);
			btnRight.setBackgroundResource(R.drawable.select_a03_02_btn_walkno);
			mTextLeft.setText("좋아요");
			mTextRight.setText("싫어요");
		}else if(position==2){
			mTitle.setText("나는 동물이");
			btnLeft.setBackgroundResource(R.drawable.select_a03_03_btn_animal);
			btnRight.setBackgroundResource(R.drawable.select_a03_03_btn_animalno);
			mTextLeft.setText("좋아요");
			mTextRight.setText("싫어요");
		}else if(position==3){
			mTitle.setText("나는 새로운 것에 도전하는게");
			btnLeft.setBackgroundResource(R.drawable.select_a03_04_btn_new);
			btnRight.setBackgroundResource(R.drawable.select_a03_04_btn_newno);
			mTextLeft.setText("좋아요");
			mTextRight.setText("싫어요");
		}else if(position==4){
			mTitle.setText("우리는 데이트할 때 주로");
			btnLeft.setBackgroundResource(R.drawable.select_a03_05_btn_car);
			btnRight.setBackgroundResource(R.drawable.select_a03_05_btn_bus);
			mTextLeft.setText("자가용을\n이용해요");
			mTextRight.setText("대중교통을\n이용해요");
		}else if(position==5){
			mTitle.setText("우리는 보통");
			btnLeft.setBackgroundResource(R.drawable.select_a03_06_btn_wday);
			btnRight.setBackgroundResource(R.drawable.select_a03_06_btn_wend);
			mTextLeft.setText("주중에\n만나요");
			mTextRight.setText("주말에\n만나요");
		}else if(position==6){
			mTitle.setText("우리는 데이트하고 헤어질 때");
			btnLeft.setBackgroundResource(R.drawable.select_a03_07_btn_alone);
			btnRight.setBackgroundResource(R.drawable.select_a03_07_btn_with);
			mTextLeft.setText("각자 알아서\n집으로 가요");
			mTextRight.setText("한명이 먼저\n데려다줘요");
		}else if(position==7){
			mTitle.setText("우리는 데이트 할 때");
			btnLeft.setBackgroundResource(R.drawable.select_a03_08_btn_drink);
			btnRight.setBackgroundResource(R.drawable.select_a03_08_btn_drinkno);
			mTextLeft.setText("가끔 술도\n마셔요");
			mTextRight.setText("술은 절대\n마시지 않아요");
		}
		
		final int tempPosition = position;
		
		btnLeft.setOnClickListener( new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				if(tempPosition != 7){
					A_03.move(tempPosition+1);
				}else{
					
				}
			}
		});
		
		btnRight.setOnClickListener( new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				if(tempPosition != 7){
					A_03.move(tempPosition+1);
				}else{
					
				}
			}
		});
		
		
		((ViewPager)pager).addView(mView, 0);
		
		return mView;
	}
	
	private void setLayout(View mView){
		mTitle = (TextView) mView.findViewById(R.id.item_title);
		btnLeft = (Button) mView.findViewById(R.id.btn_left);
		btnRight = (Button) mView.findViewById(R.id.btn_right);
		mTextLeft = (TextView) mView.findViewById(R.id.text_left);
		mTextRight = (TextView) mView.findViewById(R.id.text_right);
	}
	
	private void setLayoutStyle(){
		mTitle.setTextColor(Color.WHITE);
		mTitle.setTypeface(FontUtil.loadTypeface(mContext));
		mTitle.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 20);
		
		mTextLeft.setTextColor(Color.WHITE);
		mTextLeft.setTypeface(FontUtil.loadTypeface(mContext));
		mTextLeft.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 20);

		mTextRight.setTextColor(Color.WHITE);
		mTextRight.setTypeface(FontUtil.loadTypeface(mContext));
		mTextRight.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 20);
	}
	
	@Override
	public int getCount() {
		return PAGE_COUNT;
	}

	@Override
	public boolean isViewFromObject(View pager, Object obj) {
		return pager == obj; 
	}

	@Override
	public void destroyItem(View pager, int position, Object view) {	
		((ViewPager)pager).removeView((View)view);
	}
}
