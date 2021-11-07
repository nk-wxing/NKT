/**
 * 
 */
package com.nkt.news.biz;

import java.util.List;

import com.nkt.news.bean.News;
import com.nkt.news.bean.PageBean;
import com.nkt.news.bean.Topic;

/**
 * Description:
 * Program Name: NewsBiz.java
 * Date: 2020年4月12日
 * 
 * @author WangXing
 */
public interface NewsBiz {

	/**
	 * 查询用户发布的所有信息
	 * @param uid
	 * @return
	 */
	List<News> findUserAllNews(int uid);

	/**
	 * 查询所有信息
	 * @return
	 */
	List<News> findAllNews();

	/**
	 * 新增信息
	 * @param news
	 */
	void newAddNews(News news);

	/**
	 * 预修改信息
	 * @param nid
	 * @return
	 */
	News preEditNews(int nid);

	/**
	 * 编辑信息
	 * @param news
	 */
	void editNews(News news);

//	/**
//	 * 查询所有审核通过的信息，并按时间降序排序
//	 * @return
//	 */
//	PageBean findAllCheckedNews(PageBean searchCondition);

	/**
	 * 查询所有待审核信息，并按时间升序排序
	 * @return
	 */
	List<News> findAllCheckPendingNews();

	/**
	 * 修改信息的审核状态
	 * @param nid
	 * @param checkStatus 
	 * @return
	 */
	boolean editCheckStatus(int nid, int checkStatus);

	/**
	 * 根据新闻编号查找新闻详情
	 * @param nid
	 * @return
	 */
	News findNewsByNid(int nid);

	/**
	 * 根据新闻编号查找新闻主题
	 * @param nid
	 * @return
	 */
	Topic findNewsTopicByNid(int nid);

	/**
	 * 查询最近发布的信息标题
	 * @return
	 */
	List<News> findCurrentNews();

	/**
	 * 删除当前新闻信息
	 * @param nid
	 * @return
	 */
	boolean removeNowNews(int nid);

	/**
	 * 按条件查询信息并分页显示
	 * @param searchCondition
	 * @param currentPage
	 * @param pageSize
	 * @return
	 */
	PageBean<News> findNewsByConditions(News searchCondition, int currentPage, int pageSize);

}
