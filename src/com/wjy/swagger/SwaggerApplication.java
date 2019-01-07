package com.wjy.swagger;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import com.wjy.exception.business.BusinessExceptionHandle;
import com.wjy.exception.system.SystemExceptionHandle;
import com.wjy.filter.RequestFilter;
import com.wjy.util.PropertiesUtil;

import io.swagger.jaxrs.config.BeanConfig;

@ApplicationPath(value = "/api")
public class SwaggerApplication extends Application {

	private Set<Object> singletons = new HashSet<Object>();

	/*
	 * 添加需要扫描的类
	 */
	public SwaggerApplication() {

		// 请求过滤
		singletons.add(new RequestFilter());

		// 业务异常处理
		singletons.add(new BusinessExceptionHandle());
		// 系统异常处理
		singletons.add(new SystemExceptionHandle());

		// 微信
		singletons.add(new com.wjy.api.wechat.AuthorAPI());
		singletons.add(new com.wjy.api.wechat.DesignTempletAPI());
		// 网站
		singletons.add(new com.wjy.api.website.AuthorAPI());
		singletons.add(new com.wjy.api.website.DesignTempletAPI());

		// singletons.add(new com.wjy.queue.TestQueue());

		/*
		 * Swagger配置
		 */
		boolean isSwagger = Boolean.parseBoolean(PropertiesUtil.getValueOrDefault("swagger.is", "true"));

		if (isSwagger) {

			BeanConfig beanConfig = new BeanConfig();

			beanConfig.setScan(Boolean.parseBoolean(PropertiesUtil.getValueOrDefault("swagger.scan", "true")));
			beanConfig.setVersion(PropertiesUtil.getValueOrDefault("swagger.version", "1.0"));
			beanConfig.setDescription(PropertiesUtil.getValueOrDefault("swagger.description", "Swagger API"));
			beanConfig.setResourcePackage(PropertiesUtil.getValueOrDefault("swagger.resourcePackage", "com"));
			beanConfig.setBasePath(PropertiesUtil.getValueOrDefault("swagger.basePath", "/api"));
			beanConfig.setSchemes(new String[] { "http" });

		}

	}

	@Override
	public Set<Object> getSingletons() {

		return singletons;

	}

}
