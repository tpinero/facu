package models;

import java.io.Serializable;

public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private Long identifier;
	private String email;
	private Integer phonenumber;

	public User() {
		super();
	}

	public User(String name, Long identifier, String email, Integer phonenumber) {
		this.name = name;
		this.identifier = identifier;
		this.email = email;
		this.phonenumber = phonenumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getIdentifier() {
		return identifier;
	}

	public void setIdentifier(Long identifier) {
		this.identifier = identifier;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(Integer phonenumber) {
		this.phonenumber = phonenumber;
	}

	public String toString() {
		return "User [email=" + email + ", identifier=" + identifier
				+ ", name=" + name + ", phonenumber=" + phonenumber + "]";
	}

}
