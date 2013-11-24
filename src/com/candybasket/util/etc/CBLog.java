package com.candybasket.util.etc;

import android.util.Log;

import com.candybasket.BuildConfig;

/**
 * com.candybasket.util.etc
 * CBLog.java
 * Desc:
 * @Company : Candy-basket
 * @author     : ilsung
 * @Date        : 2013. 11. 22. 오후 9:15:33
 * @Version    : 1.0.4
 * @See          로그 wrapper 클래스 BuildConfig.DEBUG 값에따라 사용가능
 * @Todo       
 */
public class CBLog {
	
	public static void d(String tag, String msg) {
		if (BuildConfig.DEBUG && tag != null && msg != null)
            Log.d(tag, msg);
    }
	
	public static void e(String tag, String msg) {
		if (BuildConfig.DEBUG && tag != null && msg != null)
            Log.e(tag, msg);
    }
	
	public static void w(String tag, String msg) {
		if (BuildConfig.DEBUG && tag != null && msg != null)
            Log.w(tag, msg);
    }
	
	public static void v(String tag, String msg) {
		if (BuildConfig.DEBUG && tag != null && msg != null)
            Log.v(tag, msg);
    }
	
	public static void i(String tag, String msg) {
		if (BuildConfig.DEBUG && tag != null && msg != null)
            Log.i(tag, msg);
    }
	
	/*
	public static void d(Activity activity, String msg) {
        if (D && activity != null && msg != null)
            Log.d(activity.getLocalClassName(), msg);
    }
	*/
}













