package com.nkt.news.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nkt.news.bean.*;
import com.nkt.news.biz.UserBiz;
import com.nkt.news.biz.impl.UserBizImpl;
import com.nkt.news.utils.BaseServlet;
import com.nkt.news.utils.CommonUtils;

@WebServlet("/UserServlet")
public class UserServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	private UserBiz biz = new UserBizImpl();

	/**
	 * 登录（管理员，网站编辑）
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String gotoMyCenter(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		User user = (User) request.getSession().getAttribute("user");
		try {
			if (user != null) {
				if (user.getIsAdmin() == 1) {
					// System.out.println("用户是管理员");
					// i)成功，跳转到后台管理页面admin.jsp
					return "r:/NewsServlet?method=searchNews&checkStatus=2"; // r:转发信息 f:跳转页面
				} else {
					// System.out.println("用户不是管理员");
					// i)成功，跳转到用户页面user.jsp
					return "r:/NewsServlet?method=searchNews&uid=" + user.getUid();
				}
			} else {
				// ii)否则，弹出提示信息
				request.setAttribute("msg", "尚未登录，请重新登录！");
			}
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("msg", "系统繁忙，请稍后再试！");
		}
		return "f:/msg.jsp";
	}
	
	/**
	 * 登录（管理员，网站编辑）
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String login(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		//1.将表单数据封装到User实体类中
		User user = CommonUtils.toBean(request.getParameterMap(), User.class);
		
		//2.调用biz实例的登陆方法
		try {
			User userFromDB = biz.login(user);
			
			//3.根据反馈值进行操作
			if (userFromDB != null) {
				//将用户信息保存到Session域中
				request.getSession().setAttribute("user" , userFromDB);
				//i)成功，跳转
				return "r:/NewsServlet?method=gotoFirstPage";
			} else {
				//ii)否则，弹出提示信息
				request.setAttribute("msg", "用户名或密码输入错误！");
			}
						
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			request.setAttribute("msg", "系统繁忙，请稍后再试！");
		}
		
		return "f:/msg.jsp";
	}
	
	/**
	 * 注销（管理员，网站编辑）
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String logout(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		//1.让session失效
		request.getSession().invalidate();
		//2.返回主页
		return "r:/NewsServlet?method=gotoFirstPage";
	}

}