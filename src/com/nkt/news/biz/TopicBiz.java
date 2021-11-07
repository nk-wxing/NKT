/**
 * 
 */
package com.nkt.news.biz;

import java.util.List;

import com.nkt.news.bean.Topic;

/**
 * Description:
 * Program Name: TopicBiz.java
 * Date: 2020年4月13日
 * 
 * @author WangXing
 */
public interface TopicBiz {

	/**
	 * 查询所有主题
	 * @return
	 */
	List<Topic> findAllTopics();

	/**
	 * 新增主题
	 * @param topic
	 * @return
	 */
	boolean addTopic(Topic topic);

	/**
	 * 根据id查询主题
	 * @param tid
	 * @return
	 */
	Topic findTopicByTid(int tid);

	/**
	 * 编辑主题
	 * @param topic
	 * @return
	 */
	boolean editTopic(Topic topic);

	/**
	 * 删除主题
	 * @param tid
	 * @return
	 */
	boolean removeTopic(int tid);

}
