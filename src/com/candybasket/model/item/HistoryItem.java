package com.candybasket.model.item;

public class HistoryItem {
	/**
	 * ���� ��
	 */
	private String taste = "";
	/**
	 * ���� ������
	 */
	private String mood = "";
	/**
	 * ���� ����
	 */
	private String service = ""; 
	/**
	 * ���� ����Ʈ
	 */
	private String point = "";
	/**
	 * �湮 ��¥
	 */
	private String visitDate = "";
	/**
	 * ���� �̸�
	 */
	private String name = "";
	/**
	 * ���� �ּ�
	 */
	private String address = "";
	/**
	 * ���� �̹��� http �ּ�
	 */
	private String imagePath = "";
	/**
	 *  �� ������ ���� �ʿ��� ��
	 */
	private String storeID = "";
	
	
	/**
	 * @param storeID
	 * @param visitDate
	 * @param imagePath
	 * @param name
	 * @param address
	 * @param taste
	 * @param mood
	 * @param service
	 * @param point
	 */
	public HistoryItem(String storeID, 
							   String visitDate,
							   String imagePath, 
							   String name,
							   String address,
							   String taste,
							   String mood,
							   String service,
							   String point){
		this.storeID = storeID;
		this.visitDate = visitDate;
		this.imagePath = imagePath;
		this.name = name;
		this.address = address;
		this.taste = taste;
		this.mood = mood;
		this.service = service;
		this.point = point;
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
	public String getPoint() {
		return point;
	}
	public String getVisitDate() {
		return visitDate;
	}
	public String getName() {
		return name;
	}
	public String getAddress() {
		return address;
	}
	public String getImagePath() {
		return imagePath;
	}
	public String getStoreID() {
		return storeID;
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
	public void setPoint(String point) {
		this.point = point;
	}
	public void setVisitDate(String visitDate) {
		this.visitDate = visitDate;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	public void setStoreID(String storeID) {
		this.storeID = storeID;
	}
}
