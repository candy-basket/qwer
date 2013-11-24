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
		 *  가입 취소 성공
		 */
		public final static String deleteUser = "A601";
	}
	
	public class ResultCode_A_00{
		/**
		 *  가입 또는 로그인 필요
		 */
		public final static String requireLoginOrJoin = "V101";
		/**
		 *  설문 필요
		 */
		public final static String requireSurvey = "V012";
		/**
		 *  새로운 연동 필요
		 */
		public final static String requireLinkage = "V103";
		/**
		 *  연동 대기 상태
		 */
		public final static String waitLinkage = "V014";
	}
		
	public class ResultCode_A_01{
		/**
		 *  로그인 실패 - 이메일 or 패스워드
		 */
		public final static String failEmailorPasswd = "A101";
		/**
		 * 설문 필요
		 */
		public final static String requireSurvey = "A102";
		/**
		 *  신규연동필요
		 */
		public final static String requireLinkage = "A103";
		/**
		 *  커플연동 대기상태
		 */
		public final static String waitLinkage = "A104";
		/**
		 *  로그인 성공
		 */
		public final static String successLogin = "A105";
	}
	
	public class ResultCode_A_02{
		/**
		 *  가입 성공
		 */
		public final static String successJoin = "A201";
		/**
		 *  이메일 중복
		 */
		public final static String duplicateEmail = "A202";
	}
	
	public class ResultCode_A_03{
		/**
		 *  설문 조사 성공(신규)
		 */
		public final static String successInfoUpdateNew = "A301";
		/**
		 *  설문 조사 성공(갱신)
		 */
		public final static String successInfoUpdateRevision = "A302";
	}
	
	public class ResultCode_A_04_1{
		/**
		 * 연동 대기 상태
		 */
		public final static String waitCoupleLink = "A401";
		/**
		 *  연동 중 오류
		 */
		public final static String errorCoupleLink = "A402";
		/**
		 *  연동 완료
		 */
		public final static String completeCoupleLink = "A403";
	}
	
	public class ResultCode_A_05_1{
		/**
		 * 없는 이메일
		 */
		public final static String nonExistEmail = "A511";
		/**
		 * 메일 발송 성공
		 */
		public final static String sucessSendEmail = "A512";
		/**
		 * 메일 발송 실패
		 */
		public final static String failSendEmail = "A513";
	}
	
	public class ResultCode_A_05_2{
		/**
		 * 틀린 인증 번호
		 */
		public final static String errorCode = "A521";
		/**
		 * 인증 번호 통과
		 */
		public final static String passCode = "A522";
	}
	
	public class ResultCode_A_05_3{
		/**
		 * 틀린 인증 번호
		 */
		public final static String errorCode = "A531";
		/**
		 * 비밀번호 설정 성공
		 */
		public final static String sucessChangePassword = "A532";
	}
	
	public class ResultCode_A_06{
		/**
		 * 가입 취소
		 */
		public final static String cancleJoin = "A601";
	}
}

