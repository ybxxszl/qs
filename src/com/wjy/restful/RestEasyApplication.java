package com.wjy.restful;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import com.wjy.exception.business.BusinessExceptionHandle;
import com.wjy.exception.system.SystemExceptionHandle;
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

		// 请求过滤
		singletons.add(new RequestFilter());

		// 系统异常处理
		singletons.add(new SystemExceptionHandle());
		// 业务异常处理
		singletons.add(new BusinessExceptionHandle());

		// 微信
		singletons.add(new com.wjy.api.wechat.AuthorAPI());
		singletons.add(new com.wjy.api.wechat.DesignTempletAPI());
		// 网站
		singletons.add(new com.wjy.api.website.AuthorAPI());
		singletons.add(new com.wjy.api.website.DesignTempletAPI());

	}

	@Override
	public Set<Object> getSingletons() {

		return singletons;

	}

}
