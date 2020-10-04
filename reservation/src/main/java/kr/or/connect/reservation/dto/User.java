package kr.or.connect.reservation.dto;

import java.util.Date;

public class User {
	
	private Long id;
	private String name;
	private String password;
	private String email;
	private String phone;
	private Date create_date;
	private Date modify_date;
	
	public User() {
		create_date = new Date();
		modify_date = new Date();
	}
	
	public User(Long id, String name, String password, String email) {
		this();
		this.id = id;
		this.name = name;
		this.password = password;
		this.email = email;
	}
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
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
	public Date getCreate_date() {
		return create_date;
	}
	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}
	public Date getModify_date() {
		return modify_date;
	}
	public void setModify_date(Date modify_date) {
		this.modify_date = modify_date;
	}

}
