package com.wjy.restful;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import com.wjy.api.AuthorAPI;
import com.wjy.api.DesignTempletAPI;
import com.wjy.exception.handle.BusinessExceptionHandle;
import com.wjy.exception.handle.SystemExceptionHandle;
import com.wjy.filter.RequestFilter;
import com.wjy.filter.ResponseFilter;

// 自动扫描模式
@ApplicationPath(value = "/api")
public class RestEasyApplication extends Application {

	private Set<Object> singletons = new HashSet<Object>();

	public RestEasyApplication() {

		// 异常处理
		singletons.add(new BusinessExceptionHandle());
		singletons.add(new SystemExceptionHandle());

		// 过滤
		singletons.add(new RequestFilter());
		singletons.add(new ResponseFilter());

		// 类
		singletons.add(new AuthorAPI());
		singletons.add(new DesignTempletAPI());

	}

	@Override
	public Set<Object> getSingletons() {

		return singletons;

	}

}
