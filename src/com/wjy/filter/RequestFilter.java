package com.wjy.filter;

import java.io.IOException;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;

import com.wjy.restful.ResponseBuilder;
import com.wjy.thread.ThreadLocalEnv;
import com.wjy.thread.ThreadLocalVar;

/**
 * @date 2018年10月9日
 * @author ybxxszl
 * @description 请求过滤
 */
public class RequestFilter implements ContainerRequestFilter {

	@Override
	public void filter(ContainerRequestContext requestContext) throws IOException {

		String authorId = requestContext.getHeaderString("H-authorId");
		String authorName = requestContext.getHeaderString("H-authorName");

		if (authorId == null && authorName == null) {

			requestContext.abortWith(ResponseBuilder.response("请重新登录", 401));

		} else {

			ThreadLocalVar threadLocalVar = new ThreadLocalVar(authorId, authorName);

			ThreadLocalEnv.setENV(threadLocalVar);

		}

	}

}
