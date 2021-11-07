package com.nkt.news.servlet;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.nkt.news.bean.News;
import com.nkt.news.bean.Topic;
import com.nkt.news.bean.User;
import com.nkt.news.biz.NewsBiz;
import com.nkt.news.biz.impl.NewsBizImpl;

/**
 * 修改带图片的新闻Servlet
 * Servlet implementation class NewsUpdateServlet
 */
@WebServlet("/NewsUpdateServlet")
public class NewsUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;     
	private NewsBiz biz = new NewsBizImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.图片上传
		//a.构建ServletFileUpload的实例
		FileItemFactory fileItemFactory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(fileItemFactory);
		//b.解析请求
		News news = null;//准备封装表单数据
		File destFile = null;
		User user = (User)request.getSession().getAttribute("user");
		//Topic topic = (Topic)request.getSession().getAttribute("topic");
		try {
			List<FileItem> items = upload.parseRequest(request);
			news = new News();
			Topic topic = new Topic();
			
			for (FileItem item : items) {
				//判断是否是普通表单项
				if (item.isFormField()) {
					String paramName = item.getFieldName();
					String paramValue = item.getString("UTF-8");
					switch (paramName) {
					case "tid": { //主题编号
						topic.setTid(Integer.parseInt(paramValue));
						//建立该主题与新闻的关联关系
						//System.out.println(Integer.parseInt(paramValue));
						news.setTopic(topic);
						break;
					}
					case "nid": {
						news.setNid(Integer.parseInt(paramValue));
						break;
					}
					case "ntitle": {
						news.setNtitle(paramValue);
						break;
					}
					case "nsummary": {
						news.setNsummary(paramValue);
						break;
					}
					case "ncontent": {
						news.setNcontent(paramValue);
						break;
					}
					default:
						break;
					}

				} else {
					String dir = request.getServletContext().getRealPath("photos");
					String fileName = item.getName();
					String suffix = fileName.substring(fileName.lastIndexOf('.'));
					String photoName = System.nanoTime() + suffix;
					destFile = new File(dir ,photoName );
					item.write(destFile );
					//将上传到服务器端的图片路径保存到news实例中
					news.setFile("/photos/"+photoName);
					news.setNauthor(user);
					if (user.getIsAdmin()==1){//如果是管理员，审核状态设为3
						news.setCheckStatus(3);
					} else {
						news.setCheckStatus(2);
					}
				} 
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("msg", "抱歉，文件上传失败！");
			request.getRequestDispatcher("/msg.jsp").forward(request, response);
			return;
		}
		//c.分析结果
		//System.out.println(news.getCheckStatus());
		//System.out.println(news.getFile());
		//System.out.println(news.getNauthor().getUid());
		
		//2.保存到db中
		try {
			biz.editNews(news);
			//3.成功之后，查询，转发到新闻列表页面
			if (user.getIsAdmin()==1){
				request.getSession().setAttribute("message", "修改成功！");
				response.sendRedirect(request.getContextPath()+"/NewsServlet?method=searchNews");
			} else {
				request.getSession().setAttribute("message", "修改成功，管理员会重新审核哦！");
				response.sendRedirect(request.getContextPath()+"/NewsServlet?method=searchNews&uid=" + user.getUid());
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("msg", "抱歉，修改信息失败！");
			request.getRequestDispatcher("/msg.jsp").forward(request, response);
			//将上传的图片删除掉
			destFile.delete();
		}
	}

}
