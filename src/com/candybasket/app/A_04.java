package com.candybasket.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.candybasket.R;
import com.candybasket.util.etc.FontUtil;
import com.google.analytics.tracking.android.EasyTracker;

public class A_04 extends Activity {

	private static String TAG = A_04.class.getSimpleName();
	
	private TextView mTitle, mSubTitle,mMyNumber, mPartnerNumber, mLinkTime ,mLinkExplain;
	private ImageView btnGoA01, mStatusImage;
	
	private EditText mInputMyNumber, mInputPartnerNumber;
	
	private Button btnLink, btnReInput, btnDownLink;
	
	RelativeLayout contentView, waitView, reInputView;
	RelativeLayout.LayoutParams params  = 
			new RelativeLayout.LayoutParams(LayoutParams.MATCH_PARENT, 
														 LayoutParams.MATCH_PARENT);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a_04);
       
        setLayout();
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
    
    private void setLayout(){
    	
    	contentView = (RelativeLayout) findViewById(R.id.content_view);
    	
    	LayoutInflater inflater =  (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    	waitView = (RelativeLayout) inflater.inflate(R.layout.a_04_link,null);
    	reInputView = (RelativeLayout) inflater.inflate(R.layout.a_04_reinput,null);
        contentView.addView(waitView, params);
        
    	mTitle = (TextView) findViewById(R.id.title_a04);
    	btnGoA01 = (ImageView) findViewById(R.id.btn_go_a01);
    	mStatusImage = (ImageView) findViewById(R.id.status_image);
    	
    	if(waitView != null){
    		mSubTitle = (TextView) waitView.findViewById(R.id.sub_title_a04);
    		mLinkTime = (TextView) waitView.findViewById(R.id.link_time);	
    		mMyNumber = (TextView) waitView.findViewById(R.id.mynumber);
    		mPartnerNumber = (TextView) waitView.findViewById(R.id.partnernumber);
    		btnReInput = (Button) waitView.findViewById(R.id.btn_re_input);
    		btnDownLink = (Button) waitView.findViewById(R.id.btn_down_link);
    		mLinkExplain = (TextView) waitView.findViewById(R.id.link_explain);	
    	}
    	
    	if(reInputView != null){
    		mInputMyNumber = (EditText) reInputView.findViewById(R.id.input_mynumber);
        	mInputPartnerNumber = (EditText) reInputView.findViewById(R.id.input_partnernumber);
        	btnLink = (Button) reInputView.findViewById(R.id.btn_link);
    	}
    	
    	setLayoutStyle();
    	setLayoutAction();
    }
    
    private void setLayoutStyle(){
    	
    	mTitle.setText("����� ����");
    	mTitle.setTextColor(Color.WHITE);
    	mTitle.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 30);
    	mTitle.setTypeface(FontUtil.loadTypeface(A_04.this)); 
    	
    	mSubTitle.setText("���� �����");
    	mSubTitle.setTextColor(Color.WHITE);
    	mSubTitle.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 20);
    	mSubTitle.setTypeface(FontUtil.loadTypeface(A_04.this));
    	
    	mLinkTime.setText("���ѽð�");
    	mLinkTime.setTextColor(Color.WHITE);
    	mLinkTime.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 20);
    	mLinkTime.setTypeface(FontUtil.loadTypeface(A_04.this));
    	
    	mMyNumber.setText("�� ��ȣ 010-1111-1111");
    	mMyNumber.setTextColor(Color.WHITE);
    	mMyNumber.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 20);
    	mMyNumber.setTypeface(FontUtil.loadTypeface(A_04.this));
    	
    	mPartnerNumber.setText("�� ��ȣ 010-2222-2222");
    	mPartnerNumber.setTextColor(Color.WHITE);
    	mPartnerNumber.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 20);
    	mPartnerNumber.setTypeface(FontUtil.loadTypeface(A_04.this));
    	
    	btnReInput.setText("��ȣ ���Է�");
    	btnReInput.setTextColor(Color.WHITE);
    	btnReInput.setTypeface(FontUtil.loadTypeface(A_04.this)); 

		btnDownLink.setText("�ٿ�ε帵ũ ������");
		btnDownLink.setTextColor(Color.WHITE);
		btnDownLink.setTypeface(FontUtil.loadTypeface(A_04.this)); 
    	
		mLinkExplain.setText("24�ð� ���� ������ �����ϸ� �ڵ����� �����ǰ�,\n" +
								   "������ ���� ���� ĵ��ٽ����� �̿��� �� �־��.\n" +
								   "(24�ð��� ���� ������ ������ ���������� ó������" +
								   "ȸ�������� �ٽ� �����ؾ� �մϴ�)\n\n" +
								   "���ø����̼��� �����ϼŵ� ������ �Ǹ� �˶��� �︮��\n" +
								   "ĵ��ٽ����� ��÷�� �ý���!\n\n" +
								   "�츮���� ���� ����Ʈ ������̼�, ĵ��ٽ����� �����\n" +
								   "������ �ʴ��ϼ��� :)");
		
		mLinkExplain.setTextColor(Color.WHITE);
		mLinkExplain.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 15);
		mLinkExplain.setTypeface(FontUtil.loadTypeface(A_04.this));
		
		mInputMyNumber.setHint("�� ��ȭ��ȣ");
		mInputMyNumber.setHintTextColor(0xffc6c6c6);
		
		mInputPartnerNumber.setHint("���� ��ȭ��ȣ");
		mInputPartnerNumber.setHintTextColor(0xffc6c6c6);
		
    	btnLink.setText("�� �� !");
    	btnLink.setTextColor(Color.WHITE);
    	btnLink.setTypeface(FontUtil.loadTypeface(A_04.this)); 
    }
    
    private void setLayoutAction(){
    	
    	btnGoA01.setOnClickListener( new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				Intent intent = new Intent(A_04.this, A_01.class);
				startActivity(intent);
				finish();
			}
		});
		
    	btnReInput.setOnClickListener( new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				contentView.removeAllViews();
				contentView.addView(reInputView, params);	
				
				mStatusImage.setImageResource(R.drawable.a04_01_icon_nav);
			}
		});
    	
    	
    	btnLink.setOnClickListener( new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				contentView.removeAllViews();
				contentView.addView(waitView, params);	
				
				mStatusImage.setImageResource(R.drawable.a04_02_icon_nav);
			}
		});
    	
    }
}

