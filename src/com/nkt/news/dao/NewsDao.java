/**
 * 
 */
package com.nkt.news.dao;

import java.sql.SQLException;
import java.util.List;

import com.nkt.news.bean.News;
import com.nkt.news.bean.PageBean;
import com.nkt.news.bean.Topic;

/**
 * Description:
 * Program Name: NewsDao.java
 * Date: 2020年4月12日
 * 
 * @author WangXing
 */
public interface NewsDao {

	/**
	 * 查询用户发布的所有信息
	 * @param uid
	 * @return
	 * @throws SQLException 
	 */
	List<News> selectUserAllNews(int uid) throws SQLException;

	/**
	 * 查询数据库中所有信息
	 * @return
	 * @throws SQLException 
	 */
	List<News> selectAllNews() throws SQLException;

	/**
	 * 插入新闻
	 * @param news
	 * @throws SQLException 
	 */
	void insertNews(News news) throws SQLException;

	/**
	 * 预修改新闻
	 * @param nid
	 * @return
	 * @throws SQLException 
	 */
	News selectNewsByNid(int nid) throws SQLException;

	/**
	 * 修改新闻
	 * @param news
	 * @return
	 * @throws SQLException 
	 */
	void updateNews(News news) throws SQLException;

	/**
	 * 查询所有审核通过的信息，并按时间降序排序
	 * @param pageSize 
	 * @param startIndex 
	 * @return
	 * @throws SQLException 
	 */
	List<News> selectAllCheckedNews(int startIndex, int pageSize) throws SQLException;

	/**
	 * 查询所有待审核的信息，并按时间升序排序
	 * @return
	 * @throws SQLException 
	 */
	List<News> selectAllCheckPendingNews() throws SQLException;

	/**
	 * 修改审核状态
	 * @param nid
	 * @param checkStatus 
	 * @return
	 * @throws SQLException 
	 */
	boolean updateNewsCheckStatus(int nid, int checkStatus) throws SQLException;

	/**
	 * 通过编号查询新闻主题
	 * @param nid
	 * @return
	 * @throws SQLException 
	 */
	Topic selectNewsTopicByNid(int nid) throws SQLException;

	/**
	 * 获取总记录数
	 * @return
	 * @throws SQLException 
	 */
	int selectTotalRecords() throws SQLException;

	/**
	 * 查询最近发布的新闻信息
	 * @return
	 * @throws SQLException 
	 */
	List<News> selectCurrentNews() throws SQLException;

	/**
	 * 查询某一主题下的所有新闻信息
	 * @param startIndex
	 * @param pageSize
	 * @param topicid
	 * @return
	 * @throws SQLException 
	 */
	List<News> selectNewsByTopic(int startIndex, int pageSize, int topicid) throws SQLException;

	/**
	 * 查询某一主题下新闻信息的记录数
	 * @param topicid
	 * @return
	 * @throws SQLException 
	 */
	int selectTotalRecordsByTopic(int topicid) throws SQLException;

	/**
	 * 删除新闻信息
	 * @param nid
	 * @return
	 * @throws SQLException 
	 */
	boolean deleteNews(int nid) throws SQLException;

	/**
	 * 按关键词查询信息
	 * @param startIndex
	 * @param pageSize
	 * @param keywords
	 * @return
	 * @throws SQLException 
	 */
	List<News> selectSimilarNews(String keywords,int startIndex, int pageSize) throws SQLException;

	/**
	 * 查询与某个关键词相似的信息的记录数
	 * @return
	 * @throws SQLException 
	 */
	int selectTotalRecordsByKeywords(String keywords) throws SQLException;

	/**
	 * 按条件查询信息
	 * @param searchCondition
	 * @param startIndex
	 * @param pageSize
	 * @return
	 * @throws SQLException 
	 */
	List<News> selectNewsByConditions(News searchCondition, int startIndex, int pageSize) throws SQLException;

	/**
	 * 查询按条件搜索结果记录数
	 * @param searchCondition
	 * @return
	 * @throws SQLException 
	 */
	int selectTotalRecordsByConditions(News searchCondition) throws SQLException;

}
