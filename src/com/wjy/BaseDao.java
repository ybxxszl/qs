package com.wjy;

import java.lang.reflect.InvocationTargetException;
import java.sql.ParameterMetaData;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.commons.beanutils.BeanUtils;

import com.wjy.util.JDBCUtil;

public class BaseDao extends JDBCUtil {

	public <T> ArrayList<T> Query(String sql, Object[] paramters, Class<T> clazz) throws ClassNotFoundException,
			SQLException, InstantiationException, IllegalAccessException, InvocationTargetException {

		ArrayList<T> list = new ArrayList<T>();
		pstmt = conn.prepareStatement(sql);
		ParameterMetaData pmd = pstmt.getParameterMetaData();
		int count = pmd.getParameterCount();
		if (paramters.length < count || paramters.length > count) {
			return null;
		}
		for (int i = 0; i < paramters.length; i++) {
			Object obj = paramters[i];
			pstmt.setObject(i + 1, obj);
		}
		rs = pstmt.executeQuery();
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
		return list;

	}

	public int Update(String sql, Object... paramters) throws ClassNotFoundException, SQLException {

		pstmt = conn.prepareStatement(sql);
		ParameterMetaData pmd = pstmt.getParameterMetaData();
		int count = pmd.getParameterCount();
		if (paramters.length < count || paramters.length > count) {
			return -1;
		}
		for (int i = 0; i < paramters.length; i++) {
			pstmt.setObject(i + 1, paramters[i]);
		}
		int num = pstmt.executeUpdate();
		return num;

	}

}
