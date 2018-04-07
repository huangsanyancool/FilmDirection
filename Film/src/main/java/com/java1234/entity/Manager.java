package com.java1234.entity;

/**
 * 管理员实体
 * @author Administrator
 *
 */
public class Manager {
	
	private Integer id;//编号
	private String name;//用户名
	private String password;//密码
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
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
	
	
}
