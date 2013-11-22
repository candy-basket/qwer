package com.candybasket.util.etc;

import android.content.Context;
import android.graphics.Typeface;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;

/**
 * com.candybasket.util.etc
 * FontUtil.java
 * Desc:
 * @Company : Candy-basket
 * @author     : ilsung
 * @Date        : 2013. 11. 21. 오후 7:39:53
 * @Version    : 1.0.4
 * @See         : 나눔고딕 regular, bold, extrabold의 글씨체, TextView의 밑줄
 * @Todo       
 */
public class FontUtil {
	
	public static int REGULAR = 0;
	public static int BOLD = 1;
	public static int EXTRA_BOLD = 2;
	
	public static String REGULAR_FONT = "NanumGothic.otf";
	public static String BOLD_FONT = "NanumGothicBold.otf";
	public static String EXTRA_BOLD_FONT = "NanumGothicExtraBold.otf";
	
	public static Typeface loadTypeface(Context mContext){
		return Typeface.createFromAsset(mContext.getAssets(), REGULAR_FONT);
	}

	public static Typeface loadTypeface(Context mContext, int type){
		
		if( type == REGULAR ){
			return Typeface.createFromAsset(mContext.getAssets(), REGULAR_FONT);
		}else if( type == BOLD ){
			return Typeface.createFromAsset(mContext.getAssets(), BOLD_FONT);
		}else if( type == EXTRA_BOLD ){
			return Typeface.createFromAsset(mContext.getAssets(), EXTRA_BOLD_FONT);
		}
		return Typeface.createFromAsset(mContext.getAssets(), REGULAR_FONT);
	}
	
	/**
	 * @param str
	 * @return 밑줄쳐진 스트링을 반환해준다
	 */
	public static SpannableString getUnderLineString(String str){
	
    	SpannableString contentUnderline = new SpannableString(str);
    	contentUnderline.setSpan(new UnderlineSpan(), 0, contentUnderline.length(), 0);
		
		return contentUnderline;
	}
	
}
