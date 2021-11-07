/**
 * 
 */
package com.nkt.news.bean;

import java.util.Date;

/**
 * Description: 信息实体类
 * Program Name: NewsBean.java
 * Date: 2020年4月12日
 * 
 * @author WangXing
 */
public class News {
//	-- 创建新闻表
//	-- 新闻id	标题    作者    摘要    内容    图片   主题id   发布时间      审核状态
	private int nid;
	private String ntitle;
	private User nauthor; //作者,用户就是作者
	private String nsummary; //摘要
	private String ncontent; //内容
	private String file; //图片
	private Topic topic; //主题
	private Date createDate; //发布时间
	private int checkStatus; //审核状态：1 未通过；2 待审核；3 审核通过
	//增加映射类
	private int tid;//主题编号
	private int uid;//用户编号
	private String keywords; //标题关键词
	private String uname; //用户名
	private String tname; //主题名
	/**
	 * @return the nid
	 */
	public int getNid() {
		return nid;
	}
	/**
	 * @param nid the nid to set
	 */
	public void setNid(int nid) {
		this.nid = nid;
	}
	/**
	 * @return the ntitle
	 */
	public String getNtitle() {
		return ntitle;
	}
	/**
	 * @param ntitle the ntitle to set
	 */
	public void setNtitle(String ntitle) {
		this.ntitle = ntitle;
	}
	
	/**
	 * @return the nauthor
	 */
	public User getNauthor() {
		return nauthor;
	}
	/**
	 * @param nauthor the nauthor to set
	 */
	public void setNauthor(User nauthor) {
		this.nauthor = nauthor;
	}
	/**
	 * @return the nsummary
	 */
	public String getNsummary() {
		return nsummary;
	}
	/**
	 * @param nsummary the nsummary to set
	 */
	public void setNsummary(String nsummary) {
		this.nsummary = nsummary;
	}
	/**
	 * @return the ncontent
	 */
	public String getNcontent() {
		return ncontent;
	}
	/**
	 * @param ncontent the ncontent to set
	 */
	public void setNcontent(String ncontent) {
		this.ncontent = ncontent;
	}
	/**
	 * @return the file
	 */
	public String getFile() {
		return file;
	}
	/**
	 * @param file the file to set
	 */
	public void setFile(String file) {
		this.file = file;
	}
	/**
	 * @return the topic
	 */
	public Topic getTopic() {
		return topic;
	}
	/**
	 * @param topic the topic to set
	 */
	public void setTopic(Topic topic) {
		this.topic = topic;
	}
	/**
	 * @return the createDate
	 */
	public Date getCreateDate() {
		return createDate;
	}
	/**
	 * @param createDate the createDate to set
	 */
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	/**
	 * @return the checkStatus
	 */
	public int getCheckStatus() {
		return checkStatus;
	}
	/**
	 * @param checkStatus the checkStatus to set
	 */
	public void setCheckStatus(int checkStatus) {
		this.checkStatus = checkStatus;
	}
	
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
	 * @return the keywords
	 */
	public String getKeywords() {
		return keywords;
	}
	/**
	 * @param keywords the keywords to set
	 */
	public void setKeywords(String keywords) {
		this.keywords = keywords;
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

}
