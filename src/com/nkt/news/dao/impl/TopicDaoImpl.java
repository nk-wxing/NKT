/**
 * 
 */
package com.nkt.news.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.nkt.news.bean.Topic;
import com.nkt.news.dao.TopicDao;
import com.nkt.news.utils.TxQueryRunner;

/**
 * Description:
 * Program Name: TopicDaoImpl.java
 * Date: 2020年4月13日
 * 
 * @author WangXing
 */
public class TopicDaoImpl implements TopicDao{
	private QueryRunner qr = new TxQueryRunner();

	@Override
	public List<Topic> selectAllTopics() throws SQLException {	
		return qr.query("select * from tb_topic", new BeanListHandler<>(Topic.class));
	}

	@Override
	public boolean insertTopic(Topic topic) throws SQLException {
		int cnt = qr.update("insert into tb_topic(tname) values(?)",topic.getTname());
		return cnt > 0 ? true : false;
	}

	@Override
	public Topic selectTopicByTid(int tid) throws SQLException {
		return qr.query("select * from tb_topic where tid = ?", new BeanHandler<>(Topic.class), tid);
	}

	@Override
	public boolean updateTopic(Topic topic) throws SQLException {
		int cnt = qr.update("update tb_topic set tname=? where tid=?",topic.getTname(),topic.getTid());
		return cnt > 0 ? true : false;
	}

	@Override
	public boolean deleteTopic(int tid) throws SQLException {
		int cnt = qr.update("delete from tb_topic where tid=?",tid);
		return cnt > 0 ? true : false;
	}

}
