package com.wjy.filter;

import java.io.IOException;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;

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
public class RequestFilter implements ContainerRequestFilter {

	@Override
	public void filter(ContainerRequestContext requestContext) throws IOException {

		String authorId = requestContext.getHeaderString("H-authorId");
		String authorName = requestContext.getHeaderString("H-authorName");

		System.out.println("请求过滤：H-authorId:" + authorId + " H-authorName:" + authorName);

		if (authorId != null && authorName != null) {

			ThreadLocalVar threadLocalVar = new ThreadLocalVar(authorId, authorName);

			ThreadLocalEnv.setENV(threadLocalVar);

		} else {

			requestContext.abortWith(ResponseBuilder.response("请重新登录", 401));

		}

	}

}
