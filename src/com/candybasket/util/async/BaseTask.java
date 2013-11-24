package com.candybasket.util.async;

import java.util.concurrent.Callable;

import com.candybasket.util.etc.CBLog;

import android.os.AsyncTask;
import android.os.Build;

import net.minidev.json.JSONObject;

public class BaseTask {

	private static String TAG = BaseTask.class.getSimpleName();
	
	protected Callable<JSONObject> callable;
	protected AsyncCallback<JSONObject> callback;
	protected AsyncExecutor<JSONObject> task;

	public void execute(){
		if(task != null){
			if(task.getStatus() != AsyncTask.Status.RUNNING){
				if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB)
				{
					CBLog.e(TAG,"executeOnExecutor()");
					task.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, (Void[]) null);
				}
			    else
			    {
			    	CBLog.e(TAG,"execute()");
			    	task.execute((Void[]) null);
			    }
			}
		}
	}
	
	public void cancel(){
		if(task != null){
			CBLog.e(TAG,"cancel()");
			task.cancel(true);
		}
	}
	
	public class ResultCode_A{
		/**
		 *  ���� ��� ����
		 */
		public final static String deleteUser = "A601";
	}
	
	public class ResultCode_A_00{
		/**
		 *  ���� �Ǵ� �α��� �ʿ�
		 */
		public final static String requireLoginOrJoin = "V101";
		/**
		 *  ���� �ʿ�
		 */
		public final static String requireSurvey = "V012";
		/**
		 *  ���ο� ���� �ʿ�
		 */
		public final static String requireLinkage = "V103";
		/**
		 *  ���� ��� ����
		 */
		public final static String waitLinkage = "V014";
	}
		
	public class ResultCode_A_01{
		/**
		 *  �α��� ���� - �̸��� or �н�����
		 */
		public final static String failEmailorPasswd = "A101";
		/**
		 * ���� �ʿ�
		 */
		public final static String requireSurvey = "A102";
		/**
		 *  �űԿ����ʿ�
		 */
		public final static String requireLinkage = "A103";
		/**
		 *  Ŀ�ÿ��� ������
		 */
		public final static String waitLinkage = "A104";
		/**
		 *  �α��� ����
		 */
		public final static String successLogin = "A105";
	}
	
	public class ResultCode_A_02{
		/**
		 *  ���� ����
		 */
		public final static String successJoin = "A201";
		/**
		 *  �̸��� �ߺ�
		 */
		public final static String duplicateEmail = "A202";
	}
	
	public class ResultCode_A_03{
		/**
		 *  ���� ���� ����(�ű�)
		 */
		public final static String successInfoUpdateNew = "A301";
		/**
		 *  ���� ���� ����(����)
		 */
		public final static String successInfoUpdateRevision = "A302";
	}
	
	public class ResultCode_A_04_1{
		/**
		 * ���� ��� ����
		 */
		public final static String waitCoupleLink = "A401";
		/**
		 *  ���� �� ����
		 */
		public final static String errorCoupleLink = "A402";
		/**
		 *  ���� �Ϸ�
		 */
		public final static String completeCoupleLink = "A403";
	}
	
	public class ResultCode_A_05_1{
		/**
		 * ���� �̸���
		 */
		public final static String nonExistEmail = "A511";
		/**
		 * ���� �߼� ����
		 */
		public final static String sucessSendEmail = "A512";
		/**
		 * ���� �߼� ����
		 */
		public final static String failSendEmail = "A513";
	}
	
	public class ResultCode_A_05_2{
		/**
		 * Ʋ�� ���� ��ȣ
		 */
		public final static String errorCode = "A521";
		/**
		 * ���� ��ȣ ���
		 */
		public final static String passCode = "A522";
	}
	
	public class ResultCode_A_05_3{
		/**
		 * Ʋ�� ���� ��ȣ
		 */
		public final static String errorCode = "A531";
		/**
		 * ��й�ȣ ���� ����
		 */
		public final static String sucessChangePassword = "A532";
	}
	
	public class ResultCode_A_06{
		/**
		 * ���� ���
		 */
		public final static String cancleJoin = "A601";
	}
}

