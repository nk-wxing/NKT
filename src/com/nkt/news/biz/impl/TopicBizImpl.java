/**
 * 
 */
package com.nkt.news.biz.impl;

import java.util.List;

import com.nkt.news.bean.Topic;
import com.nkt.news.biz.TopicBiz;
import com.nkt.news.dao.TopicDao;
import com.nkt.news.dao.impl.TopicDaoImpl;

/**
 * Description:
 * Program Name: TopicBizImpl.java
 * Date: 2020年4月13日
 * 
 * @author WangXing
 */
public class TopicBizImpl implements TopicBiz{
	private TopicDao dao = new TopicDaoImpl();

	@Override
	public List<Topic> findAllTopics() {
		// TODO Auto-generated method stub
		try {
			return dao.selectAllTopics();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("系统繁忙，请稍后再试！");
		}
	}

	@Override
	public boolean addTopic(Topic topic) {
		try {
			return dao.insertTopic(topic);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("系统繁忙，请稍后再试！");
		}
	}

	@Override
	public Topic findTopicByTid(int tid) {
		try {
			return dao.selectTopicByTid(tid);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("系统繁忙，请稍后再试！");
		}
	}

	@Override
	public boolean editTopic(Topic topic) {
		try {
			return dao.updateTopic(topic);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("系统繁忙，请稍后再试！");
		}
	}

	@Override
	public boolean removeTopic(int tid) {
		try {
			return dao.deleteTopic(tid);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("系统繁忙，请稍后再试！");
		}
	}

}
