package com.nkt.news.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nkt.news.bean.Topic;
import com.nkt.news.bean.User;
import com.nkt.news.biz.TopicBiz;
import com.nkt.news.biz.impl.TopicBizImpl;
import com.nkt.news.utils.BaseServlet;
import com.nkt.news.utils.CommonUtils;

/**
 * Servlet implementation class TopicServlet
 */
@WebServlet("/TopicServlet")
public class TopicServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	private TopicBiz biz = new TopicBizImpl();
	
	/**
	 * 新增主题
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String addTopic(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.获得表单中的主题信息
		Topic topic = CommonUtils.toBean(request.getParameterMap(), Topic.class);
		boolean isSuccess = true;
		//2.调用biz层实例的addTopic方法
		try {
			isSuccess = biz.addTopic(topic);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("msg", e.getMessage());
			return "f:/msg.jsp";
		}
		if (isSuccess) {
			//a.成功，通过当前servlet中的方法findAllTopics查询db,并将查询到的所有主题信息保存到request域中，转发主题
			return "r:/TopicServlet?method=showAllTopics";
		} else {
			//b.失败，显示错误信息
			request.setAttribute("msg", "新增主题失败！");
			return "f:/msg.jsp";
		}
	}
	/**
	 * 查询所有主题
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String showAllTopics(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.调用biz层实例的addTopic方法
		List<Topic> allTopics;
		try {
			allTopics = biz.findAllTopics();
			//2.并将查询到的所有主题信息保存到request域中，转发主题
			request.setAttribute("allTopics", allTopics);
			return "f:/topic_list.jsp";
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("msg", e.getMessage());
			return "f:/msg.jsp";
		}
	}  
	
	/**
	 * 预修改主题
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String preEditTopic(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.获得参数tid
		int tid = Integer.parseInt(request.getParameter("tid"));
		//2.调用biz中的查询指定主题id的方法
		Topic topic = null;
		try {
			topic = biz.findTopicByTid(tid);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("msg", e.getMessage());
			return "f:/msg.jsp";
		}
		//3.将Topic保存到request域中
		request.setAttribute("topic", topic);
		//4.转发到主题修改页面
		return "f:/topic_edit.jsp";

	}     
	
	/**
	 * 正式修改主题
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String editTopic(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.封装表单到实例Topic中
		Topic topic = CommonUtils.toBean(request.getParameterMap(), Topic.class );
		try {
			//2.调用biz中的修改方法
			biz.editTopic(topic);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("msg", e.getMessage());
			return "f:/msg.jsp";
		}
		return "r:/TopicServlet?method=showAllTopics";		
	}
	
	/**
	 * 根据主题编号tid删除主题
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String removeTopic(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//思路：
		//1.将参数直接取出来
		int tid = Integer.parseInt(request.getParameter("tid"));
		//2.调用biz实例的查询新闻的方法
		try {
			boolean isSuccess = biz.removeTopic(tid);
			if (isSuccess) {
				request.getSession().setAttribute("message", "删除成功！");
				return "r:/TopicServlet?method=showAllTopics"; // r:转发信息 f:跳转页面
			} else {
				request.setAttribute("msg", "抱歉，该主题下有新闻信息，不允许删除，删除主题失败！");
			}
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("msg", e.getMessage());
		}
		return "f:/msg.jsp";
	}
}
