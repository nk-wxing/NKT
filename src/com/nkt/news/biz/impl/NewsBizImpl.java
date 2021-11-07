/**
 * 
 */
package com.nkt.news.biz.impl;

import java.util.List;

import com.nkt.news.bean.News;
import com.nkt.news.bean.PageBean;
import com.nkt.news.bean.Topic;
import com.nkt.news.biz.NewsBiz;
import com.nkt.news.dao.NewsDao;
import com.nkt.news.dao.impl.NewsDaoImpl;

/**
 * Description: Program Name: NewsBizImpl.java Date: 2020年4月12日
 * 
 * @author WangXing
 */
public class NewsBizImpl implements NewsBiz {
	private NewsDao dao = new NewsDaoImpl();

	@Override
	public List<News> findUserAllNews(int uid) {
		try {
			return dao.selectUserAllNews(uid);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new RuntimeException("系统繁忙，请稍后再试！");
		}
	}

	@Override
	public List<News> findAllNews() {
		try {
			return dao.selectAllNews();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new RuntimeException("系统繁忙，请稍后再试！");
		}
	}

	@Override
	public void newAddNews(News news) {
		try {
			dao.insertNews(news);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new RuntimeException("系统繁忙，请稍后再试！(标题，摘要，内容不能重复）");
		}
	}

	@Override
	public News preEditNews(int nid) {
		try {
			return dao.selectNewsByNid(nid);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new RuntimeException("系统繁忙，请稍后再试！");
		}
	}

	@Override
	public void editNews(News news) {
		try {
			dao.updateNews(news);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new RuntimeException("系统繁忙，请稍后再试！(标题，摘要，内容不能重复）");
		}
	}

//	@Override
//	public PageBean findAllCheckedNews(PageBean searchCondition) {
//		// 构建PageBean的实例
//		PageBean result = new PageBean();
//
//		// 设置该实例的属性值
//		// 1.从条件中获取
//		int currentPage = searchCondition.getCurrentPage();
//		result.setCurrentPage(currentPage);
//		// 2.查询db
//		try {
//			// 查询当前页的数据
//			int pageSize = PageBean.PAGE_SIZE;
//			int startIndex = (currentPage - 1) * pageSize;
//			int topicid = searchCondition.getTid();
//			result.setTid(topicid);
//			int totalRecords = 0;
//			String keywords = searchCondition.getKeywords();
//			if (keywords != null && !keywords.trim().isEmpty()) {
//				List<News> newses = dao.selectSimilarNews(keywords,startIndex, pageSize);
//				result.setNews(newses);
//				// 查询总记录数
//				totalRecords = dao.selectTotalRecordsByKeywords(keywords);
//			} else {
//				if (topicid==0) {
//					List<News> newses = dao.selectAllCheckedNews(startIndex, pageSize);
//					result.setNews(newses);
//					// 查询总记录数
//					totalRecords = dao.selectTotalRecords();
//				} else {
//					List<News> newses = dao.selectNewsByTopic(startIndex, pageSize,topicid);
//					result.setNews(newses);
//					totalRecords = dao.selectTotalRecordsByTopic(topicid);
//				}
//			}
//			//System.out.println(result.getTotalPages());
//			// 返回
//			result.setTotalRecords(totalRecords);
//			return result;
//		} catch (SQLException e) {
//			e.printStackTrace();
//			throw new RuntimeException("系统繁忙，请稍后再试！");
//		}
//	}

	@Override
	public List<News> findAllCheckPendingNews() {
		try {
			return dao.selectAllCheckPendingNews();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new RuntimeException("系统繁忙，请稍后再试！");
		}
	}

	@Override
	public boolean editCheckStatus(int nid, int checkStatus) {
		try {
			return dao.updateNewsCheckStatus(nid,checkStatus);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("系统繁忙，请稍后再试！");
		}
	}

	@Override
	public News findNewsByNid(int nid) {
		try {
			return dao.selectNewsByNid(nid);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("系统繁忙，请稍后再试！");
		}
	}

	@Override
	public Topic findNewsTopicByNid(int nid) {
		try {
			return dao.selectNewsTopicByNid(nid);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("系统繁忙，请稍后再试！");
		}
	}

	@Override
	public List<News> findCurrentNews() {
		try {
			return dao.selectCurrentNews();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("系统繁忙，请稍后再试！");
		}
	}

	@Override
	public boolean removeNowNews(int nid) {
		try {
			return dao.deleteNews(nid);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("系统繁忙，请稍后再试！");
		}
	}

	@Override
	public PageBean<News> findNewsByConditions(News searchCondition, int currentPage, int pageSize) {
		// 构建PageBean的实例
		PageBean<News> result = new PageBean<News>();

		// 设置该实例的属性值
		// 1.从条件中获取
		result.setCurrentPage(currentPage);
		result.setPageSize(pageSize);
		// 2.查询db
		try {
			int startIndex = (currentPage - 1) * pageSize;
			List<News> newses = dao.selectNewsByConditions(searchCondition,startIndex, pageSize);
			int totalRecords = dao.selectTotalRecordsByConditions(searchCondition);
			result.setBeanList(newses);
			result.setTotalRecords(totalRecords);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("系统繁忙，请稍后再试！");
		}
	}

}
