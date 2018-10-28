package com.wjy.dao;

import java.util.List;

import org.apache.log4j.Logger;

import com.wjy.exception.BusinessException;
import com.wjy.jdbc.SQLUtil;
import com.wjy.util.UUIDUtil;
import com.wjy.vo.Author;

public class AuthorDao extends SQLUtil {

	private static final Logger LOGGER = Logger.getLogger(AuthorDao.class);

	public Author login(Author author) throws Exception {

		String sql = "SELECT author.author_id, author.author_account, author.author_password, author.author_name, author.author_sex, "
				+ "author.author_birthday, author.author_phone, author.author_email, author.author_photo, author.author_state "
				+ "FROM author WHERE author.author_account = ? AND author.author_password = ?";

		Object[] objects = new Object[] { author.getAuthor_account(), author.getAuthor_password() };

		List<Author> authorList = Query(sql, objects, Author.class);

		if (authorList.size() == 0) {

			throw new BusinessException("账号或密码错误，登录失败");

		}

		Author a = authorList.get(0);

		LOGGER.info("Author:" + a.toString());

		return a;

	}

	public int verify(String authorAccount) throws Exception {

		String sql = "SELECT author.author_id, author.author_account, author.author_password, author.author_name, author.author_sex, "
				+ "author.author_birthday, author.author_phone, author.author_email, author.author_photo, author.author_state "
				+ "FROM author WHERE author.author_account = ?";

		Object[] objects = new Object[] { authorAccount };

		List<Author> authorList = Query(sql, objects, Author.class);

		if (authorList.size() != 0) {

			throw new BusinessException("账号已存在，请重新输入");

		}

		int num = authorList.size();

		return num;

	}

	public int register(Author author) throws Exception {

		String sql = "INSERT INTO AUTHOR(author.author_id, author.author_account, author.author_password, author.author_name, author.author_sex, "
				+ "author.author_birthday, author.author_phone, author.author_email, author.author_photo, author.author_state) "
				+ "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

		int num = Update(sql, UUIDUtil.getUUID(), author.getAuthor_account(), author.getAuthor_password(),
				author.getAuthor_name(), author.getAuthor_sex(), author.getAuthor_birthday(), author.getAuthor_phone(),
				author.getAuthor_email(), "logo.jpg", 1);

		if (num == 0) {

			throw new BusinessException("注册失败，请重新注册");

		}

		return num;

	}

}
