/**
 * 
 */
package com.nkt.news.dao.impl;

import java.sql.SQLException;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.nkt.news.bean.User;
import com.nkt.news.dao.UserDao;
import com.nkt.news.utils.TxQueryRunner;


/**
 * Description:
 * Program Name: UserDaoImpl.java
 * Date: 2020年4月12日
 * 
 * @author WangXing
 */
public class UserDaoImpl implements UserDao {
	private QueryRunner qr = new TxQueryRunner();

	@Override
	public User select(User user) throws SQLException {
		User u = qr.query("select * from tb_user where uname = ? and upwd = ?" , 
				new BeanHandler<>(User.class) , new Object[] {user.getUname(),user.getUpwd()});
		return u;
	}
}
