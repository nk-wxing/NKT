/**
 * 
 */
package com.nkt.news.dao.impl;

import java.sql.SQLException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.nkt.news.bean.News;
import com.nkt.news.bean.PageBean;
import com.nkt.news.bean.Topic;
import com.nkt.news.dao.NewsDao;
import com.nkt.news.utils.TxQueryRunner;

/**
 * Description:
 * Program Name: NewsDaoImpl.java
 * Date: 2020年4月12日
 * 
 * @author WangXing
 */
public class NewsDaoImpl implements NewsDao{
	private QueryRunner qr = new TxQueryRunner();
	@Override
	public List<News> selectUserAllNews(int uid) throws SQLException {
		return qr.query("select n.*,t.tname from tb_news n,tb_topic t where uid=? and n.tid=t.tid order by createDate desc", new BeanListHandler<>(News.class), uid);
	}
	@Override
	public List<News> selectAllNews() throws SQLException {
		return qr.query("select n.*,u.uname,t.tname from tb_news n,tb_user u,tb_topic t "
				+ "where n.uid=u.uid and n.tid=t.tid order by createDate desc", new BeanListHandler<>(News.class));
	}
	@Override
	public void insertNews(News news) throws SQLException {
		qr.update("insert into tb_news(ntitle,uid,nsummary,ncontent,file,tid,checkStatus) values(?,?,?,?,?,?,?)",
				news.getNtitle(),news.getNauthor().getUid(),news.getNsummary(),news.getNcontent(),news.getFile(),news.getTopic().getTid(),news.getCheckStatus());
	}
	@Override
	public News selectNewsByNid(int nid) throws SQLException {
		News news = qr.query("select n.*,u.uname from tb_news n,tb_user u where nid=? and n.uid=u.uid",new BeanHandler<>(News.class),nid);
		//注意：下述实例只封装了tid
		Topic topic = qr.query("select * from tb_news where nid=?",new BeanHandler<>(Topic.class),nid);
		//建立新闻实例与主题的关系
		news.setTopic(topic);
		return news;
	}
	@Override
	public void updateNews(News news) throws SQLException {
		//用容器存放占位符的值
		List<Object> values = new LinkedList<>();
		String sql = "";
		if(news.getFile()==null) {
			sql="update tb_news set ntitle=?,nsummary=?,ncontent=?,tid=?,checkStatus=? where nid=?";
			Collections.addAll(values, news.getNtitle(),news.getNsummary(),
					news.getNcontent(),news.getTopic().getTid(),news.getCheckStatus(),news.getNid());
		} else {
			sql="update tb_news set ntitle=?,nsummary=?,ncontent=?,file=?,tid=?,checkStatus=? where nid=?";
			Collections.addAll(values, news.getNtitle(),news.getNsummary(),
					news.getNcontent(),news.getFile(),news.getTopic().getTid(),news.getCheckStatus(),news.getNid());
		}
		qr.update(sql,values.toArray());
	}
	@Override
	public List<News> selectAllCheckedNews(int startIndex, int pageSize) throws SQLException {
		return qr.query(
				"select n.*,u.uname from tb_news n,tb_user u where n.uid=u.uid and checkStatus=1 order by createDate desc limit ?,?",
				new BeanListHandler<>(News.class), startIndex, pageSize);
	}
	@Override
	public List<News> selectAllCheckPendingNews() throws SQLException {
		return qr.query("select n.*,u.uname,t.tname from tb_news n,tb_user u,tb_topic t"
				+ " where n.uid=u.uid and n.tid=t.tid and checkStatus=0 order by createDate",new BeanListHandler<>(News.class));
	}
	@Override
	public boolean updateNewsCheckStatus(int nid, int checkStatus) throws SQLException {
		int cnt = qr.update("update tb_news set checkStatus=? where nid=?",checkStatus,nid);
		return cnt > 0 ? true : false;
	}
	@Override
	public Topic selectNewsTopicByNid(int nid) throws SQLException {
		return qr.query("select tname from tb_news n,tb_topic t where n.tid=t.tid and nid=?",new BeanHandler<>(Topic.class),nid);
	}
	@Override
	public int selectTotalRecords() throws SQLException {
		Long cnt = (Long)qr.query("select count(1) cnt from tb_news where checkStatus=3", new ScalarHandler("cnt"));
		return cnt.intValue();
	}
	@Override
	public List<News> selectCurrentNews() throws SQLException {
		return qr.query("select n.ntitle,n.createDate,u.uname from tb_news n,tb_user u where n.uid=u.uid and checkStatus=3 order by createDate desc limit 0,10",new BeanListHandler<>(News.class));
	}
	@Override
	public List<News> selectNewsByTopic(int startIndex, int pageSize, int topicid) throws SQLException {
		return qr.query(
				"select n.*,u.uname from tb_news n,tb_user u where n.uid=u.uid and checkStatus=3 and tid=? order by createDate desc limit ?,?",
				new BeanListHandler<>(News.class), topicid,startIndex, pageSize);
	}
	@Override
	public int selectTotalRecordsByTopic(int topicid) throws SQLException {
		Long cnt = (Long)qr.query("select count(1) cnt from tb_news where checkStatus=3 and tid=?", new ScalarHandler("cnt"),topicid);
		return cnt.intValue();
	}
	@Override
	public boolean deleteNews(int nid) throws SQLException {
		int cnt = qr.update("delete from tb_news where nid=?",nid);
		return cnt > 0 ? true : false;
	}
	
	@Override
	public List<News> selectSimilarNews(String keywords,int startIndex, int pageSize) throws SQLException {
		return qr.query(
				"select n.*,u.uname from tb_news n,tb_user u where n.uid=u.uid and checkStatus=3 and ntitle like ? order by createDate desc limit ?,?",
				new BeanListHandler<>(News.class), "%"+keywords+"%",startIndex, pageSize);
	}
	@Override
	public int selectTotalRecordsByKeywords(String keywords) throws SQLException {
		Long cnt = (Long)qr.query("select count(1) cnt from tb_news where checkStatus=3 and ntitle like ?", new ScalarHandler("cnt"),"%"+keywords+"%");
		return cnt.intValue();
	}
	@Override
	public List<News> selectNewsByConditions(News searchCondition, int startIndex, int pageSize) throws SQLException {
		try{
		//给出sql模板,为了便于后面添加sql语句
		StringBuilder sql =new StringBuilder("select n.*,u.uname,t.tname from tb_news n,tb_user u,tb_topic t where n.uid=u.uid and n.tid=t.tid ");
		//给出parmas
		List<Object> parmas = new LinkedList<>();
		
		int uid= searchCondition.getUid();
		if(uid != 0){
			sql.append(" and n.uid=?");
			parmas.add(uid);
		}
		
		int tid= searchCondition.getTid();
		if(tid != 0){
			sql.append(" and n.tid=?");
			parmas.add(tid);
		}
		
		String keywords = searchCondition.getKeywords();
		if(keywords != null && !keywords.trim().isEmpty()){
			sql.append(" and ntitle like ?");
			parmas.add("%" +keywords+ "%");
		}
		
		String uname= searchCondition.getUname();
		if(uname != null && !uname.trim().isEmpty()){
			sql.append(" and uname=?");
			parmas.add(uname);
		}
 
		String tname= searchCondition.getTname();
		if(tname != null && !tname.trim().isEmpty()){
			sql.append(" and tname=?");
			parmas.add(tname);
		}
		
		int checkStatus= searchCondition.getCheckStatus();
		if(checkStatus != 0){
			sql.append(" and checkStatus=?");
			parmas.add(checkStatus);
		}
		
		sql.append(" order by createDate desc limit ?,?");
		parmas.add(startIndex);
		parmas.add(pageSize);
		
		return qr.query(sql.toString(),new BeanListHandler<>(News.class),parmas.toArray());
		
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}
	@Override
	public int selectTotalRecordsByConditions(News searchCondition) throws SQLException {
		try{
			//给出sql模板,为了便于后面添加sql语句
			StringBuilder sql =new StringBuilder("select count(1) cnt from tb_news n,tb_user u,tb_topic t where n.uid=u.uid and n.tid=t.tid ");
			//给出parmas
			List<Object> parmas = new LinkedList<>();
			
			int uid= searchCondition.getUid();
			if(uid != 0){
				sql.append(" and n.uid=?");
				parmas.add(uid);
			}
			
			int tid= searchCondition.getTid();
			if(tid != 0){
				sql.append(" and n.tid=?");
				parmas.add(tid);
			}
			
			String keywords = searchCondition.getKeywords();
			if(keywords != null && !keywords.trim().isEmpty()){
				sql.append(" and ntitle like ?");
				parmas.add("%" +keywords+ "%");
			}
			
			String uname= searchCondition.getUname();
			if(uname != null && !uname.trim().isEmpty()){
				sql.append(" and uname=?");
				parmas.add(uname);
			}
	 
			String tname= searchCondition.getTname();
			if(tname != null && !tname.trim().isEmpty()){
				sql.append(" and tname=?");
				parmas.add(tname);
			}
			
			int checkStatus= searchCondition.getCheckStatus();
			if(checkStatus != 0){
				sql.append(" and checkStatus=?");
				parmas.add(checkStatus);
			}
			
			Long cnt = (Long)qr.query(sql.toString(),new ScalarHandler("cnt"),parmas.toArray());
			return cnt.intValue();
			
			}catch(SQLException e){
				throw new RuntimeException(e);
			}
	}
}
