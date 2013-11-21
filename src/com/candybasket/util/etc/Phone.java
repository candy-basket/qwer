package com.candybasket.util.etc;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * com.candybasket.util.etc
 * Phone.java
 * Desc:
 * @Company : Candy-basket
 * @author     : ilsung
 * @Date        : 2013. 11. 21. 오후 7:37:27
 * @Version    : 1.0.4
 * @See         : 폰번호에 대한 유틸리티 class
 * @Todo       
 */
public class Phone {

	/**
     * @param phoneNumber
     * @return 010번호가 맞는지 유무
     */
    public static boolean isValidatePhone(String phoneNumber){
    	//하이픈 제거
    	phoneNumber = phoneNumber.replaceAll("-", "");

    	String regex = "^(010)(\\d{4})(\\d{4})$";
        Pattern pattern = Pattern.compile(regex);
        Matcher match = pattern.matcher(phoneNumber);
        
        if ( !match.find() ) {
            return false;
        }else if(match.group(1).equals("010")){
        	return true;
        }
        return false;
    }
    
    /**
     * @param phoneNumber
     * @return 핸드폰 처음 자릿수 반환 예: 010
     */
    public static String getFirstNo(String phoneNumber) {
    	
    	//하이픈 제거
    	phoneNumber = phoneNumber.replaceAll("-", "");
    	
        String regex = "^(01[0123456789])(\\d{4})(\\d{4})$";
        Pattern pattern = Pattern.compile(regex);
        Matcher match = pattern.matcher(phoneNumber);
         
        // 일치하는 값을 찾을 경우 true 반환        
        if ( !match.find() ) {
           return "";
        }
         
        // match.find() 메소드를 호출한 후에 값을 추출할 수 있음.
        // match.find() 메소드를 호출하지 않을 경우 group() 메소드를 통해 값을 추출할 수 없음.
        // match.group(), match.group(0)는 최초 값 전체가 반환된다. 
        // 따라서 ()에 해당하는 값만 추출하려면 1부터 추출할 수 있다.
        return match.group(1);
    }
}
