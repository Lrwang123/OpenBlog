package com.openlab.domain;

import java.io.Serializable;

public class UserBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private int id;
	private String username;
	private String password;
	private String nickname;
	private String sign;
	private String sex;
	public UserBean(int id, String username, String password, String nickname,
			String sign, String sex, String email, String phone,
			String address, int status) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.nickname = nickname;
		this.sign = sign;
		this.sex = sex;
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.status = status;
	}
	private String email;
	private String phone;
	private String address;
	private int status;
	
	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public void setId(int id) {
		this.id = id;
	}

	public UserBean(String username, String password, String nickname,
			String sign, String sex, String email, String phone, String address) {
		super();
		this.username = username;
		this.password = password;
		this.nickname = nickname;
		this.sign = sign;
		this.sex = sex;
		this.email = email;
		this.phone = phone;
		this.address = address;
	}
	
	public UserBean() {
		// TODO Auto-generated constructor stub
	}

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getSign() {
		return sign;
	}
	public void setSign(String sign) {
		this.sign = sign;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getId() {
		return id;
	}
	@Override
	public String toString() {
		return "UserBean [id=" + id + ", username=" + username + ", password="
				+ password + ", nickname=" + nickname + ", sign=" + sign
				+ ", sex=" + sex + ", email=" + email + ", phone=" + phone
				+ ", address=" + address + "]";
	}
}
