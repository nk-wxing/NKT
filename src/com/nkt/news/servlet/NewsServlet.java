package com.nkt.news.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nkt.news.bean.News;
import com.nkt.news.bean.PageBean;
import com.nkt.news.bean.Topic;
import com.nkt.news.bean.User;
import com.nkt.news.biz.NewsBiz;
import com.nkt.news.biz.TopicBiz;
import com.nkt.news.biz.impl.NewsBizImpl;
import com.nkt.news.biz.impl.TopicBizImpl;
import com.nkt.news.utils.BaseServlet;
import com.nkt.news.utils.CommonUtils;
import com.nkt.news.utils.StringUtils;

@WebServlet("/NewsServlet")
public class NewsServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	private NewsBiz biz = new NewsBizImpl();
	private TopicBiz topicBiz = new TopicBizImpl();
	private StringUtils text = new StringUtils();
	/**
	 * 预发布信息
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String preAddNews(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//思路：
		//1.从db中查询到所有的主题信息，并置于request域中
		//3.录入信息，提交
		List<Topic> topics = null;
		try {
			topics = topicBiz.findAllTopics();
			if (topics!=null && topics.size()==0) {
				request.setAttribute("msg", "您尚未添加主题，请先添加主题！");
				return "f:/msg.jsp";
			}
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("msg", e.getMessage());
			return "f:/msg.jsp";
		}
		request.setAttribute("topics", topics);
		//System.out.println(topics.size());
		//2.转发到新闻添加页面
		return "f:/news_add.jsp";

	}
	
	/**
	 * 用户查询自己发布的所有信息
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String findUserAllNews(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//思路：
		//1.将参数直接取出来
		int uid = Integer.parseInt(request.getParameter("uid"));
		//2.调用biz实例的查询新闻的方法
		try {
			List<Topic> topics = topicBiz.findAllTopics();
			List<News> newses = biz.findUserAllNews(uid);
			request.setAttribute("topics", topics);
			
			if(newses != null && newses.size() >= 0) {
				//将查询出来的所有信息都保存在Request域中
				request.setAttribute("newses", newses);
				if(newses.size() == 0) {
					request.setAttribute("msg", "暂时没有信息，赶快去添加吧");
				}
				return "f:/user.jsp";
			} else {
				request.setAttribute("msg", "查询失败");
			}
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("msg", e.getMessage());
		}
		return "f:/msg.jsp";
	}
	
	/**
	 * 根据新闻编号Nid查询信息详情
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String findNewsByNid(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//思路：
		//1.将参数直接取出来
		int nid = Integer.parseInt(request.getParameter("nid"));
		//2.调用biz实例的查询新闻的方法
		try {
			News news = biz.findNewsByNid(nid);
			Topic topic = biz.findNewsTopicByNid(nid);
			news.setNcontent(text.toHtml(news.getNcontent()));
			request.setAttribute("news", news);
			request.setAttribute("topic", topic);
			return "f:/news_details.jsp";
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("msg", e.getMessage());
			return "f:/msg.jsp";
		}
	}
	
	/**
	 * 审核信息
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String checkNews(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//思路：
		//1.将参数直接取出来
		int nid = Integer.parseInt(request.getParameter("nid"));
		//2.调用biz实例的查询新闻的方法
		try {
			News news = biz.findNewsByNid(nid);
			Topic topic = biz.findNewsTopicByNid(nid);
			request.setAttribute("news", news);
			request.setAttribute("topic", topic);
			return "f:/news_check.jsp";
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("msg", e.getMessage());
			return "f:/msg.jsp";
		}
	}
	
	/**
	 * 根据新闻编号Nid删除信息
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String removeNews(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//思路：
		//1.将参数直接取出来
		int nid = Integer.parseInt(request.getParameter("nid"));
		User user = (User) request.getSession().getAttribute("user");
		//2.调用biz实例的查询新闻的方法
		try {
			boolean isSuccess = biz.removeNowNews(nid);
			if (isSuccess) {
				request.getSession().setAttribute("message", "删除成功！");
				if (user.getIsAdmin() == 1) {
					// System.out.println("用户是管理员");
					// i)成功，跳转到后台管理页面admin.jsp
					return "r:/NewsServlet?method=searchNews"; // r:转发信息 f:跳转页面
				} else {
					// System.out.println("用户不是管理员");
					// i)成功，跳转到用户页面user.jsp
					return "r:/NewsServlet?method=searchNews&uid=" + user.getUid();
				}
			} else {
				request.setAttribute("msg", "抱歉，删除信息失败！");
			}
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("msg", e.getMessage());
		}
		return "f:/msg.jsp";
	}
	
	/**
	 * 管理员查询所有信息
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String findAllNews(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//思路：
		//1.调用biz实例的查询新闻的方法
		try {
			List<Topic> topics = topicBiz.findAllTopics();
			List<News> newses = biz.findAllNews();
			request.setAttribute("topics", topics);
			if(newses != null && newses.size() >= 0) {
				//将查询出来的所有信息都保存在Request域中
				request.setAttribute("newses", newses);
				if(newses.size() == 0) {
					request.setAttribute("msg", "暂时没有信息，赶快去添加吧");
				}				
				return "f:/admin.jsp";
			} else {
				request.setAttribute("msg", "查询失败");
			}
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("msg", e.getMessage());
		}
		return "f:/msg.jsp";
	}
	
	/**
	 * 管理员查询所有待审核信息
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String findAllCheckPendingNews(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//思路：
		//1.调用biz实例的查询新闻的方法
		try {
			List<News> newses = biz.findAllCheckPendingNews();
			
			if(newses != null && newses.size() >= 0) {
				//将查询出来的所有信息都保存在Request域中
				request.setAttribute("newses", newses);
				if(newses.size() == 0) {
					request.setAttribute("msg", "暂时没有待审核信息哦！");
				}				
				return "f:/admin_check.jsp";
			} else {
				request.setAttribute("msg", "查询失败");
			}
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("msg", e.getMessage());
		}
		return "f:/msg.jsp";
	}
	
	/**
	 * 预修改新闻
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String preEditNews(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//思路：
		//1.获取参数nid
		int nid = Integer.parseInt(request.getParameter("nid"));
		//2.调用biz中的方法
		try {
			News news = biz.preEditNews(nid);
			List<Topic> topics = topicBiz.findAllTopics();
			//3.分析结果
			//将news实例保存到request域中，转发到新闻修改页面，回显旧的新闻信息
			request .setAttribute("news", news);
			//将主题转发到request域中
			request .setAttribute("topics", topics);
			return "f:/news_edit.jsp";
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("msg", e.getMessage());
			return "f:/msg.jsp";
		}
	}
	
	/**
	 * 更改审核状态为不通过
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String noPassCheck(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//思路：
		//1.获取参数nid
		int nid = Integer.parseInt(request.getParameter("nid"));
		try {
			//2.调用biz中的修改方法
			biz.editCheckStatus(nid,1);
			//System.out.println(isSuccess);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("msg", e.getMessage());
			return "f:/msg.jsp";
		}
		return "r:/NewsServlet?method=searchNews";
	}
	
	/**
	 * 更改审核状态
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String changeCheckStatus(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//思路：
		//1.获取参数nid
		int nid = Integer.parseInt(request.getParameter("nid"));
		int checkStatus = Integer.parseInt(request.getParameter("checkStatus"));
		try {
			//2.调用biz中的修改方法
			biz.editCheckStatus(nid,checkStatus);
			//System.out.println(isSuccess);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("msg", e.getMessage());
			return "f:/msg.jsp";
		}
		return "r:/NewsServlet?method=searchNews&checkStatus=2";
	}
	
	/**
	 * 修改新闻信息
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String editNews(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.将表单数据封装到news实体中
		News news = CommonUtils.toBean(request.getParameterMap(), News.class);
		Topic topic = CommonUtils.toBean(request.getParameterMap(), Topic.class);
		User user = (User)request.getSession().getAttribute("user");
		//建立主题与新闻之间的联系
		news.setTopic(topic);
		//2.调用biz更新
		if (user.getIsAdmin()==1){//如果是管理员，审核状态设为1
			news.setCheckStatus(3);
		} else {
			news.setCheckStatus(2);
		}
		try {
			//3.分析结果
			biz.editNews(news);
			if (user.getIsAdmin()==1) {
				request.getSession().setAttribute("message", "修改成功！");
				return "r:/NewsServlet?method=searchNews";
			} else {
				request.getSession().setAttribute("message", "修改成功，管理员会重新审核哦！");
				return "r:/NewsServlet?method=searchNews&uid=" + user.getUid();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("msg", e.getMessage());
			return "f:/msg.jsp";
		}
	}
	
	/**
	 * 跳转到网站真实首页
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String gotoFirstPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cp = request.getParameter("currentPage");
		int currentPage = 0;
		if (cp==null) {
			currentPage = 1;
		} else {
			currentPage = Integer.parseInt(cp);
		}
		//System.out.println(currentPage);
		int pageSize = 5;
		try {
			//1.查询所有主题
			List<Topic> allTopics = topicBiz.findAllTopics(); 
			//2.查询所有审核通过的带图片的新闻
			News searchCondition = CommonUtils.toBean(request.getParameterMap(), News.class); //封装查询条件
			searchCondition.setCheckStatus(3);
			PageBean<News> pageBean = biz.findNewsByConditions(searchCondition,currentPage,pageSize); //封装查询结果
			pageBean.setUrl(getUrl(request));
			//3.查询最近发布新闻的标题
			List<News> newses = biz.findCurrentNews();
			//4.按主题显示所有新闻
			//将查询到的所有信息保存到request域中
			request.setAttribute("allTopics", allTopics);
			request.setAttribute("pageBean", pageBean);
			request.setAttribute("newses", newses);
			return "f:/news.jsp";
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("msg", e.getMessage());
			return "f:/msg.jsp";
		}
	}
	
	/**
	 * 按条件搜索信息
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String searchNews(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cp = request.getParameter("currentPage");
		int currentPage = 0;
		if (cp==null) {
			currentPage = 1;
		} else {
			currentPage = Integer.parseInt(cp);
		}
		int pageSize = 8;
		User user = (User) request.getSession().getAttribute("user");
		//思路：
		try {
			List<Topic> topics = topicBiz.findAllTopics();
			News searchCondition = CommonUtils.toBean(request.getParameterMap(), News.class); //封装查询条件
			PageBean<News> pageBean = biz.findNewsByConditions(searchCondition,currentPage,pageSize); //封装查询结果
			// 得到url，保存到pb中
			pageBean.setUrl(getUrl(request));
			request.setAttribute("topics", topics);
			if(pageBean.getBeanList() != null && pageBean.getBeanList().size() >= 0) {
				//将查询出来的所有信息都保存在Request域中
				//System.out.println(pageBean.getNews().size());
				request.setAttribute("pageBean", pageBean);
				if(pageBean.getBeanList().size() == 0) {
					request.setAttribute("msg", "没有搜索到符合条件的信息！");
				}
				if (user.getIsAdmin() == 1) {
					if (searchCondition.getCheckStatus()==2) {
						return "f:/admin_check.jsp";
					} else {
						return "f:/admin.jsp";
					}
				} else {
					return "f:/user.jsp";
				}
			} else {
				request.setAttribute("msg", "查询失败");
			}
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("msg", e.getMessage());
		}
		return "f:/msg.jsp";
	}
	
	/**
	 * 截取URL：/项目名/servlet路径?参数字符串
	 * 
	 * @param request
	 * @return
	 */
	private String getUrl(HttpServletRequest request) {

		// 获取项目名
		String contextPath = request.getContextPath();
		// 获取servletPath，即/CustomerServlet
		String servletPath = request.getServletPath();
		// 获取问号之后的参数部分
		String queryString = request.getQueryString();

		// 判断参数部分中是否包含pc这个参数，如果包含，需要截取下去，不要这一部分。
		if (queryString.contains("&currentPage=")) {
			int index = queryString.lastIndexOf("&currentPage=");
			queryString = queryString.substring(0, index);
		}

		return contextPath + servletPath + "?" + queryString;
	}
}
