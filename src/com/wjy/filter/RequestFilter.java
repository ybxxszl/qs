package com.wjy.filter;

import java.io.IOException;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.ext.Provider;

import com.wjy.restful.ResponseBuilder;
import com.wjy.thread.ThreadLocalEnv;
import com.wjy.thread.ThreadLocalVar;

/**
 * 请求过滤
 * 
 * @date 2018年10月7日
 * @author ybxxszl
 * @description TODO
 */
@Provider
public class RequestFilter implements ContainerRequestFilter {

	@Override
	public void filter(ContainerRequestContext requestContext) throws IOException {

		String authorId = requestContext.getHeaderString("H-authorId");
		String authorName = requestContext.getHeaderString("H-authorName");

		if (authorId != null && authorName != null) {

			requestContext.abortWith(ResponseBuilder.response("请重新登陆", 401));

		} else {

			ThreadLocalVar threadLocalVar = new ThreadLocalVar(authorId, authorName);

			ThreadLocalEnv.setENV(threadLocalVar);

		}

	}

}
