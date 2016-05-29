package com.ac.pojo;

public class LoginPagePojo {

	private String title;
	private String shopName;
	private String loginby;
	private String admin;
	private String user;
	private String username;
	private String pswd;
	private String submitbutton;
	private String clearbutton;
	private String welcome;
	private String customer;
	private String addUser;
	private String getUserDetails;
	private String deleteUser;

	public String getAddUser() {
		return addUser;
	}

	public void setAddUser(String addUser) {
		this.addUser = addUser;
	}

	public String getGetUserDetails() {
		return getUserDetails;
	}

	public void setGetUserDetails(String getUserDetails) {
		this.getUserDetails = getUserDetails;
	}

	public String getDeleteUser() {
		return deleteUser;
	}

	public void setDeleteUser(String deleteUser) {
		this.deleteUser = deleteUser;
	}

	public String getCustomer() {
		return customer;
	}

	public void setCustomer(String customer) {
		this.customer = customer;
	}

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

	public LoginPagePojo() {
	}

	public String getWelcome() {
		return welcome;
	}

	public void setWelcome(String welcome) {
		this.welcome = welcome;
	}

	public LoginPagePojo(LoginPagePojo readEnglishProperties) {
		this.title = readEnglishProperties.getTitle();
		this.shopName = readEnglishProperties.getShopName();
		this.loginby = readEnglishProperties.getLoginby();
		this.admin = readEnglishProperties.getAdmin();
		this.user = readEnglishProperties.getUser();
		this.username = readEnglishProperties.getUsername();
		this.pswd = readEnglishProperties.getPswd();
		this.submitbutton = readEnglishProperties.getSubmitbutton();
		this.clearbutton = readEnglishProperties.getClearbutton();
		this.welcome = readEnglishProperties.getWelcome();
		this.customer = readEnglishProperties.getCustomer();
		this.addUser = readEnglishProperties.getAddUser();
		this.getUserDetails = readEnglishProperties.getGetUserDetails();
		this.deleteUser = readEnglishProperties.getDeleteUser();
	}

}
