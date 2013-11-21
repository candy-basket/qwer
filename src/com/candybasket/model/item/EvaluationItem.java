package com.candybasket.model.item;

/**
 * @author ilsung
 * <pre>
 * type = 0 | �ٸ�������� �򰡴�? �̹��� 
 * type = 1 | �� ������ �̹���
 * type = 2 | �����Էµ� �򰡰� �����... �̹��� (null)�϶�
 * type = 3 | ���Ƽ��Ƽ ��
 * type = 4 | ��Ƽ��Ƽ ��
 * </pre>
 * @see Double Ȥ�� Int���� �����ʹ� String���� ��ȯ�ؼ� �޾��ش�.
 */
public class EvaluationItem {

	/**
	 * type = 0 | �ٸ�������� �򰡴�? �̹��� 
	 */
	public static int firstImage = 0;
	/**
	 * type = 1 | �� ������ �̹���
	 */
	public static int moreEvaluationImage = 1;
	/**
	 * type = 2 | �����Էµ� �򰡰� �����... �̹��� (null)�϶�
	 */
	public static int nothingEvaluationImage = 2;
	/**
	 * type = 3 | ���Ƽ��Ƽ ��
	 */
	public static int beActivityEvaluation = 3;
	/**
	 * type = 4 | ��Ƽ��Ƽ ��
	 */
	public static int activityEvaluation = 4;
	
	private int type = 0;
	private String date = "";
	/**
	 * JSON data���� �Ľ��ҋ��� int -> string ���� �޾ƾ��Ѵ�.
	 */
	private String funScore = "";
	/**
	 * JSON data���� �Ľ��ҋ��� int -> string ���� �޾ƾ��Ѵ�.
	 */
	private String satistyScore = "";
	/**
	 * JSON data���� �Ľ��ҋ��� double -> string ���� �޾ƾ��Ѵ�. 
	 */
	private String total = "";
	/**
	 * JSON data���� �Ľ��ҋ��� int -> string ���� �޾ƾ��Ѵ�.
	 */
	private String taste = "";
	/**
	 * JSON data���� �Ľ��ҋ��� int -> string ���� �޾ƾ��Ѵ�.
	 */
	private String mood = "";
	/**
	 * JSON data���� �Ľ��ҋ��� int -> string ���� �޾ƾ��Ѵ�.
	 */
	private String service = "";
	
	//type = 0, 1, 2
	public EvaluationItem(int type){
		this.type = type;
	}
	
	//type = 3 ���Ƽ��Ƽ ��
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
	
	//type = 4 ��Ƽ��Ƽ ��
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
