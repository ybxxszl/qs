package com.wjy.jdbc;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.ParameterMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.commons.beanutils.BeanUtils;

/**
 * @date 2018年10月9日
 * @author ybxxszl
 * @description SQLUtil工具类
 */
public class SQLUtil {

	/**
	 * @date 2018年10月9日
	 * @author ybxxszl
	 * @description 查询
	 */
	public <T> ArrayList<T> Query(String sql, Object[] paramters, Class<T> clazz) throws ClassNotFoundException,
			SQLException, InstantiationException, IllegalAccessException, InvocationTargetException {

		Connection conn = JDBCUtil.getConnect();
		ArrayList<T> list = new ArrayList<T>();
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ParameterMetaData pmd = pstmt.getParameterMetaData();
		int count = pmd.getParameterCount();
		if (paramters.length < count || paramters.length > count) {
			return null;
		}
		for (int i = 0; i < paramters.length; i++) {
			Object obj = paramters[i];
			pstmt.setObject(i + 1, obj);
		}
		ResultSet rs = pstmt.executeQuery();
		ResultSetMetaData rsm = pstmt.getMetaData();
		while (rs.next()) {
			T t = clazz.newInstance();
			for (int i = 0; i < rsm.getColumnCount(); i++) {
				String key = rsm.getColumnName(i + 1);
				Object value = rs.getObject(i + 1);
				BeanUtils.copyProperty(t, key, value);
			}
			list.add(t);
		}
		rs.close();
		pstmt.close();
		conn.close();
		return list;

	}

	/**
	 * @date 2018年10月9日
	 * @author ybxxszl
	 * @description 增加、删除、修改
	 */
	public int Update(String sql, Object... paramters) throws ClassNotFoundException, SQLException {

		Connection conn = JDBCUtil.getConnect();
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ParameterMetaData pmd = pstmt.getParameterMetaData();
		int count = pmd.getParameterCount();
		if (paramters.length < count || paramters.length > count) {
			return -1;
		}
		for (int i = 0; i < paramters.length; i++) {
			pstmt.setObject(i + 1, paramters[i]);
		}
		int num = pstmt.executeUpdate();
		pstmt.close();
		conn.close();
		return num;

	}

}
