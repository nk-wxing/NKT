/**
 * 
 */
package com.nkt.news.bean;

import java.util.LinkedList;
import java.util.List;

/**
 * Description: 主题实体类
 * Program Name: TopicBean.java
 * Date: 2020年4月12日
 * 
 * @author WangXing
 */
public class Topic {
//	-- 创建主题表
//	create table tb_topic(
//		tid int primary key auto_increment,
//		tname varchar(50) not null unique
//	);
	private int tid; //主题编号
	private String tname; //主题名称
	private List<News> newses = new LinkedList<>(); //若一个类的属性是集合的话，建议手动初始化
	/**
	 * @return the tid
	 */
	public int getTid() {
		return tid;
	}
	/**
	 * @param tid the tid to set
	 */
	public void setTid(int tid) {
		this.tid = tid;
	}
	/**
	 * @return the tname
	 */
	public String getTname() {
		return tname;
	}
	/**
	 * @param tname the tname to set
	 */
	public void setTname(String tname) {
		this.tname = tname;
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
