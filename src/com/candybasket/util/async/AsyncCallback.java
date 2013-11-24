package com.candybasket.util.async;

/**
* com.candybasket.custom.async
* AsyncCallback.java
* Desc:
* @Company : Candy-basket
* @author     : ilsung
* @Date        : 2013. 11. 4. 오후 2:34:15
* @Version    : 1.0.4
* @See          : 비동기 처리 인터페이스
* @Todo       
* @param <T>
* <pre>
* 각 메서드는 결과를 받음 (onResult)
* 처리 도중 발생한 익셉션 (exceptionOccured)
* 작업을 취소했음을 받을(cancelled) 때 사용
* 필요에 따라 진행율을 받을 수 있는 콜백 메서드 추가
* </pre>
*/
public interface AsyncCallback<T> {
	
   public void onResult(T result);

   public void exceptionOccured(Exception e);

   public void cancelled();
   
}

