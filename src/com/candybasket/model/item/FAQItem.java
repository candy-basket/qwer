package com.candybasket.model.item;

public class FAQItem {
	String title = "";
	String URL = "";
	
	public FAQItem(String title, String URL){
		this.title = title;
		this.URL = URL;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getURL() {
		return URL;
	}
	public void setURL(String URL) {
		this.URL = URL;
	}
}
