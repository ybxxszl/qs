package com.wjy.dao;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.wjy.log.LOG;
import com.wjy.vo.Author;

public class AuthorDao {

	private static final Logger LOGGER = Logger.getLogger(Author.class);

	public List<Author> login(Author author) throws ClassNotFoundException, SQLException, InstantiationException,
			IllegalAccessException, InvocationTargetException {

		String sql = "SELECT author.author_id, author.author_account, author.author_password, author.author_name, author.author_sex, "
				+ "author.author_birthday, author.author_phone, author.author_email, author.author_photo, author.author_state "
				+ "FROM author WHERE author.author_account = ? AND author.author_password = ?";

		// Object[] objects = new Object[] { author.getAuthor_account(),
		// author.getAuthor_password() };
		//
		// getConnect();
		//
		// List<Author> list = Query(sql, objects, Author.class);
		//
		// getClose();

		List<Author> list = new ArrayList<Author>();

		LOGGER.info(list);

		LOG.pInfo(list);

		return list;

	}

	public int verify(Author author) throws ClassNotFoundException, SQLException, InstantiationException,
			IllegalAccessException, InvocationTargetException {

		String sql = "SELECT author.author_id, author.author_account, author.author_password, author.author_name, author.author_sex, "
				+ "author.author_birthday, author.author_phone, author.author_email, author.author_photo, author.author_state "
				+ "FROM author WHERE author.author_account = ?";

		// Object[] objects = new Object[] { author.getAuthor_account() };
		//
		// getConnect();
		//
		// List<Author> list = Query(sql, objects, Author.class);
		//
		// getClose();

		List<Author> list = new ArrayList<Author>();

		LOGGER.info(list);

		LOG.pInfo(list);

		return list.size();

	}

	public int register(Author author) throws ClassNotFoundException, SQLException {

		String sql = "INSERT INTO AUTHOR(author.author_id, author.author_account, author.author_password, author.author_name, author.author_sex, "
				+ "author.author_birthday, author.author_phone, author.author_email, author.author_photo, author.author_state) "
				+ "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

		// getConnect();
		//
		// int num = Update(sql, UUIDUtil.getUUID(), author.getAuthor_account(),
		// author.getAuthor_password(),
		// author.getAuthor_name(), author.getAuthor_sex(),
		// author.getAuthor_birthday(), author.getAuthor_phone(),
		// author.getAuthor_email(), "logo.jpg", 1);
		//
		// getClose();

		int num = 0;

		LOGGER.info(num);

		LOG.pInfo(num);

		return num;

	}

}
