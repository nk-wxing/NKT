/**
 * 
 */
package com.nkt.news.bean;

import java.util.LinkedList;
import java.util.List;

/**
 * Description: 用户实体类
 * Program Name: UserBean.java
 * Date: 2020年4月12日
 * 
 * @author WangXing
 */
public class User {
	/*
	 * -- 用户id 	是否为管理员    用户名    密码
	-- drop table tb_user;
	create table tb_user(
	uid int primary key auto_increment,
	isAdmin boolean not null,
	uname varchar(20) not null unique,
	upwd varchar(20) not null
	);
	 */
	private int uid;
	private int isAdmin;
	private String uname;
	private String upwd;
	private List<News> newses = new LinkedList<>(); //表示用户所编辑的多条新闻
	/**
	 * @return the uid
	 */
	public int getUid() {
		return uid;
	}
	/**
	 * @param uid the uid to set
	 */
	public void setUid(int uid) {
		this.uid = uid;
	}
	/**
	 * @return the isAdmin
	 */
	public int getIsAdmin() {
		return isAdmin;
	}
	/**
	 * @param isAdmin the isAdmin to set
	 */
	public void setIsAdmin(int isAdmin) {
		this.isAdmin = isAdmin;
	}
	/**
	 * @return the uname
	 */
	public String getUname() {
		return uname;
	}
	/**
	 * @param uname the uname to set
	 */
	public void setUname(String uname) {
		this.uname = uname;
	}
	/**
	 * @return the upwd
	 */
	public String getUpwd() {
		return upwd;
	}
	/**
	 * @param upwd the upwd to set
	 */
	public void setUpwd(String upwd) {
		this.upwd = upwd;
	}
	/**
	 * @return the newses
	 */
	public List<News> getNewses() {
		return newses;
	}
	/**
	 * @param newses the newses to set
	 */
	public void setNewses(List<News> newses) {
		this.newses = newses;
	}
	
}
