package com.candybasket.util.constant;

/**
 * com.candybasket.util.constant
 * CBCODE.java
 * Desc:
 * @Company : Candy-basket
 * @author     : ilsung
 * @Date        : 2013. 11. 24. 오후 8:13:19
 * @Version    : 1.0.4
 * @See         : 서버 리턴 코드 
 * @Todo       
 */
public class CBCODE {
	/**
	 * 네트워크 에러 (디바이스 문제)
	 *  네트워크를 확인해 주세요\n(Wifi나 3G/LTE 연결 필요)
	 *  <pre>
	 *  0
	 *  </pre>
	 */
	public static String NETWORK_ERROR = "0";
	
	/**
	 * 서버에러
	 * "서버가 응답하지 않습니다. 공지사항을 확인해 주세요"
	 *  <pre>
	 *  50
	 *  </pre>
	 */
	public static String SERVER_ERROR = "50";
	
	/**
	 * 허위 토큰 혹은 잘못된 주소 접근
	 * "무조건 로그인 화면으로 강제 이동시킨다"
	 *  <pre>
	 *  55
	 *  </pre>
	 */
	public static String FALSE_ACCESS = "55";
	
	/**
	 * 서버 DB 오류
	 * "서버에 문제가 있으니 동일 증상이 반복되면 신고해주세요"
	 *  <pre>
	 *  60
	 *  </pre>
	 */
	public static String SERVER_DB_ERROR = "60";

	/**
	 * 응답성공
	 *  <pre>
	 *  200
	 *  </pre>
	 */
	public static String ResultSuccess = "200";
	
	/**
	 * parameter 오류
	 *  <pre>
	 *  300
	 *  </pre>
	 */
	public static String ParameterError = "300";
	
	/**
	 * No valid Google Play Services APK found
	 *  <pre>
	 *  20
	 *  </pre>
	 */
	public static String NOT_SUPPORT_GooglePlayServices = "20";
}
