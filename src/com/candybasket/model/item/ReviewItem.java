package com.candybasket.model.item;

/**
 * @author ilsung
 * <pre>
 * type = 0 | �ٸ�������� ������? �̹��� 
 * type = 1 | ���� ������ �̹���
 * type = 2 | �����Էµ� ���䰡 �����... �̹��� (null)�϶�
 * type = 3 | ���Ƽ��Ƽ ����
 * type = 4 | ��Ƽ��Ƽ ����
 * </pre>
 * @see Double Ȥ�� Int���� �����ʹ� String���� ��ȯ�ؼ� �޾��ش�.
 */
public class ReviewItem {
	
	/**
	 * type = 0 | �ٸ�������� ������? �̹��� 
	 */
	public static int firstImage = 0;
	/**
	 * type = 1 | ���� ������ �̹���
	 */
	public static int moreReviewImage = 1;
	/**
	 * type = 2 | �����Էµ� ���䰡 �����... �̹��� (null)�϶�
	 */
	public static int nothingReviewImage = 2;
	/**
	 * type = 3 | ���Ƽ��Ƽ ����
	 */
	public static int beActivityReview = 3;
	/**
	 * type = 4 | ��Ƽ��Ƽ ����
	 */
	public static int activityReview = 4;
	
    int type = 0;
	private String imageURL = "";
	private String email = "";
	private String date = "";
	private String comment = "";
	/**
	 * JSON data���� �Ľ��ҋ��� double -> string ���� �޾ƾ��Ѵ�. 
	 */
	private String avg;
	/**
	 * JSON data���� �Ľ��ҋ��� int -> string ���� �޾ƾ��Ѵ�.
	 */
	private String interest; // 0 or 1
	/**
	 * JSON data���� �Ľ��ҋ��� int -> string ���� �޾ƾ��Ѵ�.
	 */
	private String satisfy; // 0 or 1
	
	//type = 0, 1, 2
	public ReviewItem(int type){
		this.type = type;
	}
	
	//type = 3 ���Ƽ��Ƽ ����
	/**
	 * @param type
	 * @param imageURL
	 * @param email
	 * @param date
	 * @param comment
	 * @param avg
	 */
	public ReviewItem(int type, String imageURL, String email, String date, String comment, String avg){
		this.type = type;
		this.imageURL = imageURL;
		this.email = email;
		//this.date = date;
		this.date = date.substring(0,10); //2013-10-25 ����
		this.comment = comment;
		this.avg = avg;
	}
	
	//type = 4 ��Ƽ��Ƽ ����
	/**
	 * @param type
	 * @param imageURL
	 * @param email
	 * @param date
	 * @param comment
	 * @param interest
	 * @param satisfy
	 */
	public ReviewItem(int type, String imageURL, String email, String date, String comment, String interest, String satisfy){
		this.type = type;
		this.imageURL = imageURL;
		this.email = email;
		//this.date = date;
		this.date = date.substring(0,10); //2013-10-25 ����
		this.comment = comment;
		this.interest = interest;
		this.satisfy = satisfy;
	}

	public int getType() {
		return type;
	}

	public String getImageURL() {
		return imageURL;
	}

	public String getEmail() {
		return email;
	}

	public String getDate() {
		return date;
	}

	public String getComment() {
		return comment;
	}

	public String getAvg() {
		return avg;
	}

	public String getInterest() {
		return interest;
	}

	public String getSatisfy() {
		return satisfy;
	}

	public void setType(int type) {
		this.type = type;
	}

	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public void setAvg(String avg) {
		this.avg = avg;
	}

	public void setInterest(String interest) {
		this.interest = interest;
	}

	public void setSatisfy(String satisfy) {
		this.satisfy = satisfy;
	}
}
