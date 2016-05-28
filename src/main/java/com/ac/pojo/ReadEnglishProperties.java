package com.ac.pojo;

public class ReadEnglishProperties {

	private String title;
	private String shopName;
	private String loginby;
	private String admin;
	private String user;
	private String username;
	private String pswd;
	private String submitbutton;
	private String clearbutton;

	public String getClearbutton() {
		return clearbutton;
	}

	public void setClearbutton(String clearbutton) {
		this.clearbutton = clearbutton;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	public String getLoginby() {
		return loginby;
	}

	public void setLoginby(String loginby) {
		this.loginby = loginby;
	}

	public String getAdmin() {
		return admin;
	}

	public void setAdmin(String admin) {
		this.admin = admin;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPswd() {
		return pswd;
	}

	public void setPswd(String pswd) {
		this.pswd = pswd;
	}

	public String getSubmitbutton() {
		return submitbutton;
	}

	public void setSubmitbutton(String submitbutton) {
		this.submitbutton = submitbutton;
	}

	public ReadEnglishProperties() {
	}

	public ReadEnglishProperties(ReadEnglishProperties readEnglishProperties) {
		this.title = readEnglishProperties.getTitle();
		this.shopName = readEnglishProperties.getShopName();
		this.loginby = readEnglishProperties.getLoginby();
		this.admin = readEnglishProperties.getAdmin();
		this.user = readEnglishProperties.getUser();
		this.username = readEnglishProperties.getUsername();
		this.pswd = readEnglishProperties.getPswd();
		this.submitbutton = readEnglishProperties.getSubmitbutton();
		this.clearbutton = readEnglishProperties.getClearbutton();
	}

}
