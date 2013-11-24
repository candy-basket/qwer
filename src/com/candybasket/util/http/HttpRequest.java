package com.candybasket.util.http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.URL;

import com.candybasket.util.constant.CBCODE;
import com.candybasket.util.etc.CBLog;

import net.minidev.json.JSONObject;
import net.minidev.json.parser.JSONParser;
import net.minidev.json.parser.ParseException;

/**
 * @author ilsung
 * @date 2013-10-2
 * @see ��ű԰� Json������Ʈ�� �ּҸ� �޾� ���� ���̽��� ��ȯ�� �ش�.
 * <pre>
 * ���� resultCode
 * Constant.NETWORK_ERROR Ŭ���̾�Ʈ ����
 * Constant.SERVER_ERROR ���� ����
 * </pre>
 */
public class HttpRequest {
	
	private static String TAG = HttpRequest.class.getSimpleName();
	
	private static int CONN_TIMEOUT = 5;
	private static int READ_TIMEOUT = 5;
	
	public static JSONObject getResponseJson (String URL, JSONObject inputJson){
		
		JSONObject responseJSON = new JSONObject();
		
		HttpURLConnection conn = null;
		OutputStream os   = null;
		URL url = null;
		
		try {
			
			url = new URL( URL );

			conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("POST");
			conn.setDoInput(true);
			conn.setDoOutput(true);
			conn.setConnectTimeout(CONN_TIMEOUT  * 1000); // TimeOut �ð� (���� ���ӽ� ���� �ð�)
			conn.setReadTimeout(READ_TIMEOUT * 1000); // TimeOut �ð� (Read�� ���� �ð�)
			conn.setRequestProperty("Content-Type", "application/json");
			conn.setRequestProperty( "Content-Length", Integer.toString(inputJson.toString().length()) );
			
			os = conn.getOutputStream();
			CBLog.e(TAG, "inputJson ->" + inputJson.toString());
			os.write( inputJson.toString().getBytes() );
			os.flush();
            os.close();
            
            // ���� ������ Request ��û �ϴ� �κ�. (���� �ڵ带 �޴´�. 200 ����, ������ ����)
            int responseCode = conn.getResponseCode();
            CBLog.e(TAG, "responseCode ->" + responseCode);

			if(responseCode == HttpURLConnection.HTTP_OK)
			{
				BufferedReader in = new BufferedReader( new InputStreamReader(conn.getInputStream()));
				String line = null;
				String response = "";
				while ((line = in.readLine()) != null) {
					response += line;
		        }
				
				JSONParser p = new JSONParser();
				CBLog.e(TAG, "response ->" + response);
				return (JSONObject)p.parse(response);
			}
			else if(responseCode == HttpURLConnection.HTTP_FORBIDDEN) // 403 ���� ��ū �õ� Ȥ�� api �ּ� Ʋ��
			{ 
				responseJSON.put("resultCode", CBCODE.FALSE_ACCESS);
				return responseJSON;
			}
			else if(responseCode == HttpURLConnection.HTTP_INTERNAL_ERROR) // ���� DB ���� ����
			{
				responseJSON.put("resultCode", CBCODE.SERVER_DB_ERROR);
	    		return responseJSON;
			}
			else //�׿��� Ư�� ������ ���
			{
				responseJSON.put("resultCode", CBCODE.SERVER_ERROR);
	    		return responseJSON;
			}
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			//URL
			//URL�� �߸�������� �̰��� �ۿ��� �߸�ó���ҋ��ϻ�?? ���� �Ͼ�� ������
			e.printStackTrace();
		} catch(SocketException e){
			//���ͳ��� ���� �ȵ����� connection�� �õ��ϴ� ���
			e.printStackTrace();
			responseJSON.put("resultCode", CBCODE.NETWORK_ERROR);
    		return responseJSON;
		} catch (SocketTimeoutException e) {
			//������� ���ͳ��� ������ ���
			e.printStackTrace();
			responseJSON.put("resultCode", CBCODE.NETWORK_ERROR);
    		return responseJSON;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			//HttpURLConnection
			//�����ϴ� �ּ�����, ������ �����ִ� �������� ���ų� ��Ȱ��ȭ�� ���,
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			//JSONParser p = new JSONParser();
			//JSON���� �Ľ��ҋ� ����
			e.printStackTrace();
		} finally {
			if(conn != null){
				conn.disconnect();
			}
		}
		
		return null;
	}
}
