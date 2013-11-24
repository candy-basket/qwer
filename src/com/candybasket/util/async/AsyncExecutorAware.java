package com.candybasket.util.async;

public interface AsyncExecutorAware<T> {
	
	public void setAsyncExecutor(AsyncExecutor<T> asyncExecutor);

}