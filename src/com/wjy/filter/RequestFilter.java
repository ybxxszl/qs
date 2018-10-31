package com.wjy.filter;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;

import org.apache.log4j.Logger;

import com.wjy.response.ResponseBuilder;
import com.wjy.thread.ThreadLocalEnv;
import com.wjy.thread.ThreadLocalVar;

/**
 * @date 2018年10月9日
 * @author ybxxszl
 * @description 请求过滤
 */
public class RequestFilter implements ContainerRequestFilter {

	private static final Logger LOGGER = Logger.getLogger(RequestFilter.class);

	private static Set<String> ignore = new HashSet<String>();

	// 忽略验证
	static {

		ignore.add("/wechat/author/getAuthor");
		ignore.add("/wechat/author/sendVerifyCode");

	}

	// 添加忽略验证
	public static void add(String p) {

		ignore.add(p);

	}

	@Override
	public void filter(ContainerRequestContext requestContext) throws IOException {

		String path = requestContext.getUriInfo().getPath();

		LOGGER.warn("请求路径：" + path);

		String authorId = requestContext.getHeaderString("H-AuthorId");

		String token = requestContext.getHeaderString("H-Token");

		LOGGER.warn("H-AuthorId: " + authorId + " H-Token: " + token);

		Boolean verify = true;

		for (String str : ignore) {

			if (path.contains(str)) {

				verify = false;

			}

		}

		if (verify) {

			if (token == null) {

				requestContext.abortWith(ResponseBuilder.error("请重新登录"));

			} else {

				ThreadLocalVar threadLocalVar = new ThreadLocalVar();

				threadLocalVar.setToken(token);

				if (authorId != null) {

					threadLocalVar.setAuthor_id(authorId);

				}

				ThreadLocalEnv.setENV(threadLocalVar);

			}

		} else {

			ThreadLocalVar threadLocalVar = new ThreadLocalVar("unAuthorId", "unToken");

			ThreadLocalEnv.setENV(threadLocalVar);

		}

	}

}
