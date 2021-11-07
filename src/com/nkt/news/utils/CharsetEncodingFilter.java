/**
 * 
 */
package com.nkt.news.utils;


import java.io.IOException;
 
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * Description:
 * Program Name: CharsetEncodingFilter.java
 * Date: 2020年4月13日
 * 
 * @author WangXing
 */
public class CharsetEncodingFilter implements Filter {
	//定义成员变量.
	private String encoding;
	//销毁.
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
 
	}
	
	/**
	 * 过滤器真正执行的处理功能.
	 */
	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		
		//System.out.println("CharacterEncodingFilter--begin");
		//设置字符集.
		request.setCharacterEncoding(encoding);
		
		//拿到链条继续向下调用.
		 chain.doFilter(request, response);
		 //返回了.
		 //System.out.println("CharacterEncodingFilter--end");
 
	}
	
	/**
	 * 过滤器初始化时候调用.
	 * 我们在初始化的时候调用
	 * 从web.xml中读取配置文件 读取encoding数据.
	 */
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		this.encoding = filterConfig.getInitParameter("encoding");
		
	
	}

}
