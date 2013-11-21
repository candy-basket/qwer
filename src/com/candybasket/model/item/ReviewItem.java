package com.candybasket.model.item;

/**
 * @author ilsung
 * <pre>
 * type = 0 | 다른사람들의 생각은? 이미지 
 * type = 1 | 리뷰 더보기 이미지
 * type = 2 | 아직입력된 리뷰가 없어요... 이미지 (null)일때
 * type = 3 | 비액티비티 리뷰
 * type = 4 | 액티비티 리뷰
 * </pre>
 * @see Double 혹은 Int형의 데이터는 String으로 변환해서 받아준다.
 */
public class ReviewItem {
	
	/**
	 * type = 0 | 다른사람들의 생각은? 이미지 
	 */
	public static int firstImage = 0;
	/**
	 * type = 1 | 리뷰 더보기 이미지
	 */
	public static int moreReviewImage = 1;
	/**
	 * type = 2 | 아직입력된 리뷰가 없어요... 이미지 (null)일때
	 */
	public static int nothingReviewImage = 2;
	/**
	 * type = 3 | 비액티비티 리뷰
	 */
	public static int beActivityReview = 3;
	/**
	 * type = 4 | 액티비티 리뷰
	 */
	public static int activityReview = 4;
	
    int type = 0;
	private String imageURL = "";
	private String email = "";
	private String date = "";
	private String comment = "";
	/**
	 * JSON data에서 파싱할떄는 double -> string 으로 받아야한다. 
	 */
	private String avg;
	/**
	 * JSON data에서 파싱할떄는 int -> string 으로 받아야한다.
	 */
	private String interest; // 0 or 1
	/**
	 * JSON data에서 파싱할떄는 int -> string 으로 받아야한다.
	 */
	private String satisfy; // 0 or 1
	
	//type = 0, 1, 2
	public ReviewItem(int type){
		this.type = type;
	}
	
	//type = 3 비액티비티 리뷰
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
		this.date = date.substring(0,10); //2013-10-25 변경
		this.comment = comment;
		this.avg = avg;
	}
	
	//type = 4 액티비티 리뷰
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
		this.date = date.substring(0,10); //2013-10-25 변경
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
