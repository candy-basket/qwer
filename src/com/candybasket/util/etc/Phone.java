package com.candybasket.util.etc;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * com.candybasket.util.etc
 * Phone.java
 * Desc:
 * @Company : Candy-basket
 * @author     : ilsung
 * @Date        : 2013. 11. 21. ���� 7:37:27
 * @Version    : 1.0.4
 * @See         : ����ȣ�� ���� ��ƿ��Ƽ class
 * @Todo       
 */
public class Phone {

	/**
     * @param phoneNumber
     * @return 010��ȣ�� �´��� ����
     */
    public static boolean isValidatePhone(String phoneNumber){
    	//������ ����
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
     * @return �ڵ��� ó�� �ڸ��� ��ȯ ��: 010
     */
    public static String getFirstNo(String phoneNumber) {
    	
    	//������ ����
    	phoneNumber = phoneNumber.replaceAll("-", "");
    	
        String regex = "^(01[0123456789])(\\d{4})(\\d{4})$";
        Pattern pattern = Pattern.compile(regex);
        Matcher match = pattern.matcher(phoneNumber);
         
        // ��ġ�ϴ� ���� ã�� ��� true ��ȯ        
        if ( !match.find() ) {
           return "";
        }
         
        // match.find() �޼ҵ带 ȣ���� �Ŀ� ���� ������ �� ����.
        // match.find() �޼ҵ带 ȣ������ ���� ��� group() �޼ҵ带 ���� ���� ������ �� ����.
        // match.group(), match.group(0)�� ���� �� ��ü�� ��ȯ�ȴ�. 
        // ���� ()�� �ش��ϴ� ���� �����Ϸ��� 1���� ������ �� �ִ�.
        return match.group(1);
    }
}
