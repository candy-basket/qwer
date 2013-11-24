package com.candybasket.util.async;

import java.util.concurrent.Callable;

import net.minidev.json.JSONObject;

import com.candybasket.util.constant.CBCODE;
import com.candybasket.util.constant.JSON;
import com.candybasket.util.etc.CBLog;
import com.candybasket.wiget.dialog.CDialogEB;

import android.content.Context;
import android.os.AsyncTask;

public class AsyncExecutor<T> extends AsyncTask<Void, Void, T> {
	
	private static final String TAG = AsyncExecutor.class.getSimpleName();

	private AsyncCallback<T> callback;
	private Callable<T> callable;
	private Exception occuredException;
	
	private Context mContext;

	private CDialogEB dialog = null;
	private boolean hasProgress;
	
	public AsyncExecutor<T> setCallable(Callable<T> callable) {
		this.callable = callable;
		return this;
	}

	public AsyncExecutor<T> setCallback(AsyncCallback<T> callback) {
		this.callback = callback;
		processAsyncExecutorAware(callback);
		return this;
	}

	@SuppressWarnings("unchecked")
	private void processAsyncExecutorAware(AsyncCallback<T> callback) {
		if (callback instanceof AsyncExecutorAware) {
			((AsyncExecutorAware<T>) callback).setAsyncExecutor(this);
		}
	}

	public AsyncExecutor(Context mContext, boolean hasProgress){
		this.mContext = mContext;
		this.hasProgress = hasProgress;
		
		if(hasProgress){
			CBLog.d(TAG, "new CDialogEB");
			dialog = new CDialogEB(this.mContext,"잠시만 기다려주세요...");
			dialog.setCancelable(false);
		}
	}
	
	@Override
    protected void onPreExecute() {
		if(hasProgress){
			CBLog.d(TAG, "dialog show");
			dialog.show();
		}
	}
	
	@Override 
	protected T doInBackground(Void... params) {
		try {
			return callable.call();
		} catch (Exception ex) {
			CBLog.e(TAG,"exception occured while doing in background: "+ ex.getMessage());
			//적절한 처리
			this.occuredException = ex;
			return null;
		}
	}

	@Override
	protected void onPostExecute(T result) {
		
		if(dialog != null && hasProgress){
			if(dialog.isShowing()){
				dialog.dismiss();
			}
		}
		
		
		if (isCancelled()) {
			notifyCanceled();
		}
		if (isExceptionOccured()) {
			notifyException();
			return;
		}
		
		JSONObject convertJson = (JSONObject) result;
		if(convertJson instanceof JSONObject){
			String resultCode = "";
			if(convertJson.get(JSON.resultCode) instanceof Integer){
				resultCode = Integer.toString( (Integer)convertJson.get(JSON.resultCode) );
			}else if(convertJson.get(JSON.resultCode) instanceof String){
				resultCode = (String) convertJson.get(JSON.resultCode);
			}
			
			if(resultCode.equals(CBCODE.SERVER_DB_ERROR)){
				//TODO:: 적절한 처리
			}
			if(resultCode.equals(CBCODE.SERVER_ERROR)){
				//TODO:: 적절한 처리
			}
			if(resultCode.equals(CBCODE.FALSE_ACCESS)){
				//TODO:: 적절한 처리
			}
			if(resultCode.equals(CBCODE.NETWORK_ERROR)){
				//TODO:: 적절한 처리
			}
			
			//OK 된것 이것외의 나머지는 적절한 예외 처리
			notifyResult(result);
			
		}else{
			//TODO:: 적절한 처리 데이터 파싱에서 JSONObject로 인식을 하지 못했기 때문에
		}

	}

	private void notifyCanceled() {
		if (callback != null)
			callback.cancelled();
	}

	private boolean isExceptionOccured() {
		return occuredException != null;
	}

	private void notifyException() {
		if (callback != null)
			callback.exceptionOccured(occuredException);
	}

	private void notifyResult(T result) {
		if (callback != null)
			callback.onResult(result);
	}

}