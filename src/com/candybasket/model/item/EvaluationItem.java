package com.candybasket.model.item;

/**
 * @author ilsung
 * <pre>
 * type = 0 | 다른사람들의 평가는? 이미지 
 * type = 1 | 평가 더보기 이미지
 * type = 2 | 아직입력된 평가가 없어요... 이미지 (null)일때
 * type = 3 | 비액티비티 평가
 * type = 4 | 액티비티 평가
 * </pre>
 * @see Double 혹은 Int형의 데이터는 String으로 변환해서 받아준다.
 */
public class EvaluationItem {

	/**
	 * type = 0 | 다른사람들의 평가는? 이미지 
	 */
	public static int firstImage = 0;
	/**
	 * type = 1 | 평가 더보기 이미지
	 */
	public static int moreEvaluationImage = 1;
	/**
	 * type = 2 | 아직입력된 평가가 없어요... 이미지 (null)일때
	 */
	public static int nothingEvaluationImage = 2;
	/**
	 * type = 3 | 비액티비티 평가
	 */
	public static int beActivityEvaluation = 3;
	/**
	 * type = 4 | 액티비티 평가
	 */
	public static int activityEvaluation = 4;
	
	private int type = 0;
	private String date = "";
	/**
	 * JSON data에서 파싱할떄는 int -> string 으로 받아야한다.
	 */
	private String funScore = "";
	/**
	 * JSON data에서 파싱할떄는 int -> string 으로 받아야한다.
	 */
	private String satistyScore = "";
	/**
	 * JSON data에서 파싱할떄는 double -> string 으로 받아야한다. 
	 */
	private String total = "";
	/**
	 * JSON data에서 파싱할떄는 int -> string 으로 받아야한다.
	 */
	private String taste = "";
	/**
	 * JSON data에서 파싱할떄는 int -> string 으로 받아야한다.
	 */
	private String mood = "";
	/**
	 * JSON data에서 파싱할떄는 int -> string 으로 받아야한다.
	 */
	private String service = "";
	
	//type = 0, 1, 2
	public EvaluationItem(int type){
		this.type = type;
	}
	
	//type = 3 비액티비티 평가
	/**
	 * @param type
	 * @param date
	 * @param total
	 * @param taste
	 * @param mood
	 * @param service
	 */
	public EvaluationItem(int type, String date, String total, String taste, String mood, String service){
		this.type = type;
		this.date = date;
		this.total = total;
		this.taste = taste;
		this.mood = mood;
		this.service = service;
	}
	
	//type = 4 액티비티 평가
	/**
	 * @param type
	 * @param date
	 * @param funScore
	 * @param satistyScore
	 */
	public EvaluationItem(int type, String date, String funScore, String satistyScore){
		this.type = type;
		this.date = date;
		this.funScore = funScore;
		this.satistyScore = satistyScore;
	}
	
	public int getType() {
		return type;
	}
	public String getDate() {
		return date;
	}
	public String getFunScore() {
		return funScore;
	}
	public String getSatistyScore() {
		return satistyScore;
	}
	public String getTotal() {
		return total;
	}
	public String getTaste() {
		return taste;
	}
	public String getMood() {
		return mood;
	}
	public String getService() {
		return service;
	}
	public void setType(int type) {
		this.type = type;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public void setFunScore(String funScore) {
		this.funScore = funScore;
	}
	public void setSatistyScore(String satistyScore) {
		this.satistyScore = satistyScore;
	}
	public void setTotal(String total) {
		this.total = total;
	}
	public void setTaste(String taste) {
		this.taste = taste;
	}
	public void setMood(String mood) {
		this.mood = mood;
	}
	public void setService(String service) {
		this.service = service;
	}
}
