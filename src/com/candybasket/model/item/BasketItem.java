package com.candybasket.model.item;

public class BasketItem {
	/**
	 * type
	 */
	private int type = 0;
	/**
	 * basket visit date
	 */
	private String visitDate = "";
	/**
	 *  sugar value
	 */
	private int sugar = 0;
	/**
	 * store image http path
	 */
	private String imagePath = "";
	/**
	 * store name
	 */
	private String storeName = "";
	/**
	 * store address
	 */
	private String storeAddress = "";
	/**
	 *  store explain
	 */
	private String storeExplain = "";
	/**
	 *  have scrap?
	 */
	private boolean isScrap = false;
	/**
	 *  have visit?
	 */
	private boolean isVisit = false;
	/**
	 *  have evaluation?
	 */
	private boolean isEvaluation = false;
	/**
	 *  상세 정보로 갈떄 필요한 값
	 */
	private String storeID = "";
	public int getType() {
		return type;
	}
	public String getVisitDate() {
		return visitDate;
	}
	public int getSugar() {
		return sugar;
	}
	public String getImagePath() {
		return imagePath;
	}
	public String getStoreName() {
		return storeName;
	}
	public String getStoreAddress() {
		return storeAddress;
	}
	public String getStoreExplain() {
		return storeExplain;
	}
	public boolean isScrap() {
		return isScrap;
	}
	public boolean isVisit() {
		return isVisit;
	}
	public boolean isEvaluation() {
		return isEvaluation;
	}
	public String getStoreID() {
		return storeID;
	}
	public void setType(int type) {
		this.type = type;
	}
	public void setVisitDate(String visitDate) {
		this.visitDate = visitDate;
	}
	public void setSugar(int sugar) {
		this.sugar = sugar;
	}
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}
	public void setStoreAddress(String storeAddress) {
		this.storeAddress = storeAddress;
	}
	public void setStoreExplain(String storeExplain) {
		this.storeExplain = storeExplain;
	}
	public void setScrap(boolean isScrap) {
		this.isScrap = isScrap;
	}
	public void setVisit(boolean isVisit) {
		this.isVisit = isVisit;
	}
	public void setEvaluation(boolean isEvaluation) {
		this.isEvaluation = isEvaluation;
	}
	public void setStoreID(String storeID) {
		this.storeID = storeID;
	}
}
