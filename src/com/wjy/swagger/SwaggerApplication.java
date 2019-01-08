package com.wjy.swagger;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import com.wjy.util.PropertiesUtil;

import io.swagger.jaxrs.config.BeanConfig;

/**
 * 使用Swagger暴露接口，需要使用@Provider注解需要扫描的工具类，例如请求过滤和异常处理，不需要使用singletons
 * 
 * @author wjy
 * @date 2019年1月8日
 */
@ApplicationPath(value = "/api")
public class SwaggerApplication extends Application {

	private static final boolean IS = Boolean.parseBoolean(PropertiesUtil.getValue("swagger.is"));
	private static final String DESCRIPTION = PropertiesUtil.getValue("swagger.description");
	private static final boolean SCAN = Boolean.parseBoolean(PropertiesUtil.getValue("swagger.scan"));
	private static final String RESOURCEPACKAGE = PropertiesUtil.getValue("swagger.resourcePackage");
	private static final String BASEPATH = PropertiesUtil.getValue("swagger.basePath");
	private static final String[] SCHEMES = new String[] { PropertiesUtil.getValue("swagger.schemes") };

	public SwaggerApplication() {

		/*
		 * Swagger配置
		 */
		if (IS) {

			BeanConfig beanConfig = new BeanConfig();

			beanConfig.setDescription(DESCRIPTION);
			beanConfig.setScan(SCAN);
			beanConfig.setResourcePackage(RESOURCEPACKAGE);
			beanConfig.setBasePath(BASEPATH);
			beanConfig.setSchemes(SCHEMES);

		}

	}

}
