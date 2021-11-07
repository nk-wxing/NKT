/**
 * 
 */
package com.nkt.news.biz.impl;

import com.nkt.news.bean.User;
import com.nkt.news.biz.UserBiz;
import com.nkt.news.dao.UserDao;
import com.nkt.news.dao.impl.UserDaoImpl;

/**
 * Description:
 * Program Name: UserBizImpl.java
 * Date: 2020年4月12日
 * 
 * @author WangXing
 */
public class UserBizImpl implements UserBiz{
	private UserDao dao = new UserDaoImpl();
	
	@Override
	public User login(User user) {
		// TODO Auto-generated method stub
		try {
			return dao.select(user);			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new RuntimeException("系统繁忙，请稍后再试！");
		}

	}
}
