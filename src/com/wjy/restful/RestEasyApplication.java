package com.wjy.restful;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import com.wjy.api.AuthorAPI;
import com.wjy.api.DesignTempletAPI;
import com.wjy.filter.RequestFilter;

/**
 * @date 2018年10月10日
 * @author ybxxszl
 * @description 自动扫描模式
 */
@ApplicationPath(value = "/api")
public class RestEasyApplication extends Application {

	private Set<Object> singletons = new HashSet<Object>();

	/*
	 * 添加需要扫描的类
	 */
	public RestEasyApplication() {

		// 业务异常处理
		singletons.add(new com.wjy.exception.BusinessExceptionHandle());

		// 请求过滤
		singletons.add(new RequestFilter());

		// 普通
		singletons.add(new AuthorAPI());
		singletons.add(new DesignTempletAPI());

	}

	@Override
	public Set<Object> getSingletons() {

		return singletons;

	}

}
