/**
 * 
 */
package com.nkt.news.dao;

import java.sql.SQLException;
import java.util.List;

import com.nkt.news.bean.Topic;

/**
 * Description:
 * Program Name: TopicDao.java
 * Date: 2020年4月13日
 * 
 * @author WangXing
 */
public interface TopicDao {

	/**
	 * 查询所有主题
	 * @return
	 * @throws SQLException 
	 */
	List<Topic> selectAllTopics() throws SQLException;

	/**
	 * 插入主题
	 * @param topic
	 * @return
	 * @throws SQLException 
	 */
	boolean insertTopic(Topic topic) throws SQLException;

	/**
	 * 根据id查询主题
	 * @param tid
	 * @return
	 * @throws SQLException 
	 */
	Topic selectTopicByTid(int tid) throws SQLException;

	/**
	 * 更新主题
	 * @param topic
	 * @return
	 * @throws SQLException 
	 */
	boolean updateTopic(Topic topic) throws SQLException;

	/**
	 * 删除主题
	 * @param tid
	 * @return
	 * @throws SQLException 
	 */
	boolean deleteTopic(int tid) throws SQLException;

}
