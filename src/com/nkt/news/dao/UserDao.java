/**
 * 
 */
package com.nkt.news.dao;

import java.sql.SQLException;
import java.util.List;

import com.nkt.news.bean.User;

/**
 * Description:
 * Program Name: UserDao.java
 * Date: 2020年4月12日
 * 
 * @author WangXing
 */
public interface UserDao {

	/**
	 * @param user
	 * @return
	 * @throws SQLException
	 */
	User select(User user) throws SQLException;

}
