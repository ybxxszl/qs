package com.wjy.api;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;

import com.wjy.dao.AuthorDao;
import com.wjy.response.ResponseBuilder;
import com.wjy.vo.Author;

@Path(value = "/author")
@Produces(value = "application/json;charset=utf-8")
public class AuthorAPI {

	private static final Logger LOGGER = Logger.getLogger(AuthorAPI.class);

	private AuthorDao authorDao = new AuthorDao();

	@POST
	@Path(value = "/login")
	public Response login(@QueryParam(value = "authorAccount") String authorAccount,
			@QueryParam(value = "authorPassword") String authorPassword) throws Exception {

		Author author = new Author(authorAccount, authorPassword);

		System.out.println("Author:" + author.toString());

		LOGGER.info("Author:" + author.toString());

		return ResponseBuilder.success(authorDao.login(author));

	}

	@GET
	@Path(value = "/verify")
	public Response verify(@QueryParam(value = "authorAccount") String authorAccount) throws Exception {

		System.out.println("authorAccount:" + authorAccount);

		LOGGER.info("authorAccount:" + authorAccount);

		return ResponseBuilder.success(authorDao.verify(authorAccount));

	}

	@PUT
	@Path(value = "/register")
	public Response verify(Author author) throws Exception {

		System.out.println("Author:" + author.toString());

		LOGGER.info("Author:" + author.toString());

		return ResponseBuilder.success(authorDao.register(author));

	}

}
