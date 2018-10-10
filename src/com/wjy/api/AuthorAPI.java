package com.wjy.api;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import com.wjy.dao.AuthorDao;
import com.wjy.response.ResponseBuilder;
import com.wjy.vo.Author;

@Path(value = "/author")
@Produces(value = "application/json;charset=utf-8")
public class AuthorAPI {

	private AuthorDao authorDao = new AuthorDao();

	@POST
	@Path(value = "/login")
	public Response login(@QueryParam(value = "authorAccount") String authorAccount,
			@QueryParam(value = "authorPassword") String authorPassword) {

		Author author = new Author(authorAccount, authorPassword);

		try {

			return ResponseBuilder.success(authorDao.login(author));

		} catch (Exception e) {

			return ResponseBuilder.exception(e);

		}

	}

	@GET
	@Path(value = "/verify")
	public Response verify(@QueryParam(value = "authorAccount") String authorAccount) {

		Author author = new Author(authorAccount);

		try {

			return ResponseBuilder.success(authorDao.verify(author));

		} catch (Exception e) {

			return ResponseBuilder.exception(e);

		}

	}

	@PUT
	@Path(value = "/register")
	public Response verify(Author author) {

		try {

			return ResponseBuilder.success(authorDao.register(author));

		} catch (Exception e) {

			return ResponseBuilder.exception(e);

		}

	}

}
