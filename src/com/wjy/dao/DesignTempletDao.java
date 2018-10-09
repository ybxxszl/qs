package com.wjy.dao;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.wjy.log.LOG;
import com.wjy.thread.ThreadLocalEnv;
import com.wjy.util.JDBCUtil;
import com.wjy.vo.DesignTemplet;

public class DesignTempletDao {

	private static final Logger LOGGER = Logger.getLogger(DesignTempletDao.class);

	public List<DesignTemplet> getDesignTemplet(DesignTemplet designTemplet) throws ClassNotFoundException,
			SQLException, InstantiationException, IllegalAccessException, InvocationTargetException {

		String sql = "SELECT design_templet.design_templet_id, design_templet.design_templet_name, "
				+ "design_templet.finish_time, design_templet.start_recovery_time, design_templet.end_recovery_time, "
				+ "design_templet.state, design_templet.link, design_templet.author_id "
				+ "FROM design_templet WHERE design_templet.design_templet_id = ? AND design_templet.author_id = ?";

		// Object[] objects = new Object[] {
		// designTemplet.getDesign_templet_id(), designTemplet.getAuthor_id() };
		//
		// getConnect();
		//
		// List<DesignTemplet> list = Query(sql, objects, DesignTemplet.class);
		//
		// getClose();

		List<DesignTemplet> list = new ArrayList<DesignTemplet>();

		Connection conn = ThreadLocalEnv.getENV().getConn();

		PreparedStatement pstmt = conn.prepareStatement(sql);

		pstmt.setString(1, designTemplet.getDesign_templet_id());
		pstmt.setString(2, designTemplet.getAuthor_id());

		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			System.out.println(rs.getString(1));
		}

		LOGGER.error(list);

		LOG.pInfo(list);

		return list;

	}

}
