package com.stq.realm.service;

import java.io.Serializable;

/**
 * password & salt
 * @author kimmking (kimmking.cn@gmail.com)
 * @date 2013-12-5
 */
public class SaltedPassword implements Serializable {
	
	private static final long serialVersionUID = -7146067941756038985L;
	Long id;
	String password;
	String salt;
	
	public SaltedPassword(){}
	
	public SaltedPassword(String password, String salt) {
		super();
		this.password = password;
		this.salt = salt;
	}
	
	public SaltedPassword(Long id, String password, String salt) {
		super();
		this.id = id;
		this.password = password;
		this.salt = salt;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSalt() {
		return salt;
	}
	public void setSalt(String salt) {
		this.salt = salt;
	}
	
}
