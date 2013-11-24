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
 * @see 통신규격 Json오브젝트와 주소를 받아 얻어온 제이슨을 반환해 준다.
 * <pre>
 * 공통 resultCode
 * Constant.NETWORK_ERROR 클라이언트 문제
 * Constant.SERVER_ERROR 서버 문제
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
			conn.setConnectTimeout(CONN_TIMEOUT  * 1000); // TimeOut 시간 (서버 접속시 연결 시간)
			conn.setReadTimeout(READ_TIMEOUT * 1000); // TimeOut 시간 (Read시 연결 시간)
			conn.setRequestProperty("Content-Type", "application/json");
			conn.setRequestProperty( "Content-Length", Integer.toString(inputJson.toString().length()) );
			
			os = conn.getOutputStream();
			CBLog.e(TAG, "inputJson ->" + inputJson.toString());
			os.write( inputJson.toString().getBytes() );
			os.flush();
            os.close();
            
            // 실제 서버로 Request 요청 하는 부분. (응답 코드를 받는다. 200 성공, 나머지 에러)
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
			else if(responseCode == HttpURLConnection.HTTP_FORBIDDEN) // 403 허위 토큰 시도 혹은 api 주소 틀림
			{ 
				responseJSON.put("resultCode", CBCODE.FALSE_ACCESS);
				return responseJSON;
			}
			else if(responseCode == HttpURLConnection.HTTP_INTERNAL_ERROR) // 서버 DB 접속 오류
			{
				responseJSON.put("resultCode", CBCODE.SERVER_DB_ERROR);
	    		return responseJSON;
			}
			else //그외의 특이 사항일 경우
			{
				responseJSON.put("resultCode", CBCODE.SERVER_ERROR);
	    		return responseJSON;
			}
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			//URL
			//URL이 잘못됫을경우 이경우는 앱에서 잘못처리할떄일뿐?? 거의 일어나지 않을듯
			e.printStackTrace();
		} catch(SocketException e){
			//인터넷이 연결 안됫을때 connection을 시도하는 경우
			e.printStackTrace();
			responseJSON.put("resultCode", CBCODE.NETWORK_ERROR);
    		return responseJSON;
		} catch (SocketTimeoutException e) {
			//사용자의 인터넷이 끊겼을 경우
			e.printStackTrace();
			responseJSON.put("resultCode", CBCODE.NETWORK_ERROR);
    		return responseJSON;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			//HttpURLConnection
			//존재하는 주소지만, 응답을 보내주는 웹서버가 없거나 비활성화인 경우,
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			//JSONParser p = new JSONParser();
			//JSON으로 파싱할떄 오류
			e.printStackTrace();
		} finally {
			if(conn != null){
				conn.disconnect();
			}
		}
		
		return null;
	}
}
