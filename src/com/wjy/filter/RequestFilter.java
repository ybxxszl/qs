package com.wjy.filter;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;

import com.wjy.thread.ThreadLocalEnv;
import com.wjy.thread.ThreadLocalVar;
import com.wjy.util.ResponseUtil;

/**
 * @date 2018年10月9日
 * @author ybxxszl
 * @description 请求过滤
 */
public class RequestFilter implements ContainerRequestFilter {

	private static Set<String> ignore = new HashSet<String>();

	// 忽略验证
	static {

		ignore.add("/testPath");

	}

	// 添加忽略验证
	public static void add(String p) {

		ignore.add(p);

	}

	@Override
	public void filter(ContainerRequestContext requestContext) throws IOException {

		String path = requestContext.getUriInfo().getPath();

		System.out.println("请求路径：" + path);

		Boolean verify = true;

		for (String str : ignore) {

			if (path.contains(str)) {

				verify = false;

			}

		}

		if (verify) {

			String authorId = requestContext.getHeaderString("H-authorId");
			String authorName = requestContext.getHeaderString("H-authorName");

			String token = requestContext.getHeaderString("H-token");

			System.out.println(("authorId：" + authorId + " authorName：" + authorName + " token：" + token));

			if (authorId == null && authorName == null && token == null) {

				requestContext.abortWith(ResponseUtil.response("请重新登录", 401));

			} else {

				ThreadLocalVar threadLocalVar = new ThreadLocalVar(authorId, authorName, token);

				ThreadLocalEnv.setENV(threadLocalVar);

			}

		} else {

			ThreadLocalVar threadLocalVar = new ThreadLocalVar("testAuthorId", "testAuthorName", "testToken");

			ThreadLocalEnv.setENV(threadLocalVar);

		}

	}

}
