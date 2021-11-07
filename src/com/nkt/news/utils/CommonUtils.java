/**
 * 
 */
package com.nkt.news.utils;

import java.util.Map;
import java.util.UUID;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.DateConverter;


/**
 * Description:
 * Program Name: CommonUtils.java
 * Date: 2020年4月9日
 * 
 * @author WangXing
 */
public class CommonUtils {
	/**
     * 1.生成随机的32位长的字符串
     */
    public static String uuid() {
		return UUID.randomUUID().toString().replace("-", "").toUpperCase();
	}
    
    /**
     * 2.将Map中的数据封装到Bean中
     * @param map
     * @param clazz
     * @return
     */
    @SuppressWarnings({ "rawtypes" })
	public static <T> T toBean(Map map, Class<T> clazz) {
		try {
			/*
			 * 1. 创建指定类型的javabean对象
			 */
			T bean = clazz.newInstance();
			ConvertUtils.register(new DateConverter(),  java.util.Date.class);
			/*
			 * 2. 把数据封装到javabean中
			 */
			BeanUtils.populate(bean, map);
			/*
			 * 3. 返回javabean对象
			 */
			return bean;
		} catch(Exception e) {
			throw new RuntimeException(e);		//如果想让用户调用时不用try-catch，使用throw new RuntimeException(e)来抛出运行异常
		}
	}

}