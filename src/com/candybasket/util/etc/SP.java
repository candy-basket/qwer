package com.candybasket.util.etc;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

/**
 * @author ilsung
 * <pre>
 * SharedPreference ��ƿ��Ƽ class
 * </pre>
 */
public class SP 
{
	
	/**
	 * SharedPreferences �����
	 */
	public static String CBStore = "CBStore";
	
    /**
     * <pre>
     * String �����͸� �����մϴ�.
     * </pre>
     * 
     * @param context ���ؽ�Ʈ
     * @param key Ű
     * @param value ��
     */
    public static void putSharedPreference
    (Context context, String key, String value)
    {
            SharedPreferences prefs = context.getSharedPreferences(CBStore, Activity.MODE_PRIVATE);

            SharedPreferences.Editor editor = prefs.edit();
            
            editor.putString(key, value);
            editor.commit();
    }
    
    /**
     * <pre>
     * Boolean �����͸� �����մϴ�.
     * </pre>
     * 
     * @param context ���ؽ�Ʈ
     * @param key Ű
     * @param value ��
     */
    public static void putSharedPreference
    (Context context, String key, boolean value)
    {
    		SharedPreferences prefs = context.getSharedPreferences(CBStore, Activity.MODE_PRIVATE);
            
            SharedPreferences.Editor editor = prefs.edit();
            
            editor.putBoolean(key, value);
            editor.commit();
    }
    
    /**
     * <pre>
     * Integer �����͸� �����մϴ�.
     * </pre>
     * 
     * @param context ���ؽ�Ʈ
     * @param key Ű
     * @param value ��
     */
    public static void putSharedPreference
    (Context context, String key, int value)
    {
    		SharedPreferences prefs = context.getSharedPreferences(CBStore, Activity.MODE_PRIVATE);
            
            SharedPreferences.Editor editor = prefs.edit();
            
            editor.putInt(key, value);
            editor.commit();
    }
    
    /**
     * <pre>
     * String �����͸� �о�ɴϴ�.
     * </pre>
     * 
     * @param context ���ؽ�Ʈ
     * @param key Ű
     * @return �о�� ��, ���� ���� ��� null�� ��ȯ�ȴ�.
     */
    public static String getSharedPreference
    (Context context, String key)
    {
    	SharedPreferences prefs = context.getSharedPreferences(CBStore, Activity.MODE_PRIVATE);

        return prefs.getString(key, null);
    }

    /**
     * <pre>
     * Boolean �����͸� �о�ɴϴ�.
     * </pre>
     * 
     * @param context ���ؽ�Ʈ
     * @param key Ű
     * @return �о�� ��, ���� ���� ��� false�� ��ȯ�ȴ�.
     */
    public static boolean getBooleanSharedPreference
    (Context context, String key)
    {
    	SharedPreferences prefs = context.getSharedPreferences(CBStore, Activity.MODE_PRIVATE);

        return prefs.getBoolean(key, false);
    }
    
    /**
     * <pre>
     * Int �����͸� �о�ɴϴ�.
     * </pre>
     * 
     * @param context ���ؽ�Ʈ
     * @param key Ű
     * @return �о�� ��, ���� ���� ��� 0�� ��ȯ�ȴ�.
     */
    public static int getIntSharedPreference
    (Context context, String key)
    {
    	SharedPreferences prefs = context.getSharedPreferences(CBStore, Activity.MODE_PRIVATE);

        return prefs.getInt(key, 0);
    }
}


