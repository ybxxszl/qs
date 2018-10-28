package com.wjy.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;

import com.wjy.exception.BusinessException;
import com.wjy.jdbc.SQLUtil;
import com.wjy.thread.ThreadLocalEnv;
import com.wjy.vo.DesignTemplet;

public class DesignTempletDao extends SQLUtil {

	private static final Logger LOGGER = Logger.getLogger(DesignTempletDao.class);

	@Test
	public DesignTemplet getDesignTemplet(String designTempletId) throws Exception {

		String sql = "SELECT design_templet.design_templet_id, design_templet.design_templet_name, "
				+ "design_templet.finish_time, design_templet.start_recovery_time, design_templet.end_recovery_time, "
				+ "design_templet.state, design_templet.link, design_templet.author_id "
				+ "FROM design_templet WHERE design_templet.design_templet_id = ? AND design_templet.author_id = ?";

		Object[] objects = new Object[] { designTempletId, ThreadLocalEnv.getENV().getAuthor_id() };

		List<DesignTemplet> designTempletList = Query(sql, objects, DesignTemplet.class);

		if (designTempletList.size() == 0) {

			throw new BusinessException("调查问卷不存在");

		}

		DesignTemplet dt = designTempletList.get(0);

		LOGGER.info(dt.toString());

		return dt;

	}

}
