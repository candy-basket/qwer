package com.candybasket.util.async;

/**
* com.candybasket.custom.async
* AsyncCallback.java
* Desc:
* @Company : Candy-basket
* @author     : ilsung
* @Date        : 2013. 11. 4. ���� 2:34:15
* @Version    : 1.0.4
* @See          : �񵿱� ó�� �������̽�
* @Todo       
* @param <T>
* <pre>
* �� �޼���� ����� ���� (onResult)
* ó�� ���� �߻��� �ͼ��� (exceptionOccured)
* �۾��� ��������� ����(cancelled) �� ���
* �ʿ信 ���� �������� ���� �� �ִ� �ݹ� �޼��� �߰�
* </pre>
*/
public interface AsyncCallback<T> {
	
   public void onResult(T result);

   public void exceptionOccured(Exception e);

   public void cancelled();
   
}

