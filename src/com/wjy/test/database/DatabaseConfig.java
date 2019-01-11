package com.wjy.test.database;

import java.util.Hashtable;

import org.enhydra.jdbc.pool.StandardXAPoolDataSource;
import org.enhydra.jdbc.standard.StandardXADataSource;
import org.objectweb.jotm.Current;
import org.objectweb.jotm.Jotm;

public class DatabaseConfig {

	private static final String DRIVERNAME = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://127.0.0.1:3306/qs?useSSL=true&rewriteBatchedStatements=true";
	private static final String USER = "root";
	private static final String PASSWORD = "root";

	private static final int MINSIZE = 10;
	private static final int MAXSIZE = 20;
	private static final int DEADLOCKMAXWAIT = 10000;
	private static final int CHECKLEVELOBJECT = 2;
	private static final String JDBCTESTSTMT = "select 1";

	private static Jotm jotm;
	private static Hashtable<StandardXADataSource, StandardXAPoolDataSource> hashtable = new Hashtable<StandardXADataSource, StandardXAPoolDataSource>();

	static {

		try {
			jotm = new Jotm(true, false);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public StandardXAPoolDataSource getDataSource() {

		StandardXADataSource ds = null;
		StandardXAPoolDataSource pds = null;

		try {

			ds = new StandardXADataSource();
			pds = new StandardXAPoolDataSource(ds);

			ds.setDriverName(DRIVERNAME);
			ds.setUrl(URL);
			ds.setUser(USER);
			ds.setPassword(PASSWORD);

			pds.user = USER;
			pds.password = PASSWORD;
			pds.setMinSize(MINSIZE);
			pds.setMaxSize(MAXSIZE);
			pds.setDeadLockMaxWait(DEADLOCKMAXWAIT);
			pds.setCheckLevelObject(CHECKLEVELOBJECT);
			pds.setJdbcTestStmt(JDBCTESTSTMT);

			pds.setTransactionManager(jotm.getTransactionManager());

			pds.setDataSource(ds);

		} catch (Exception e) {
			e.printStackTrace();
		}

		if (hashtable.containsKey(ds)) {
			return hashtable.get(ds);
		} else {
			hashtable.put(ds, pds);
			return pds;
		}

	}

	public Current getCurrent() {

		Current current = Current.getCurrent();

		return current;

	}

}
