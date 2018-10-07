package com.wjy.restful;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import com.wjy.api.AuthorAPI;
import com.wjy.api.DesignTempletAPI;

// 自动扫描模式
@ApplicationPath(value = "/api")
public class RestEasyApplication extends Application {

	private Set<Object> singletons = new HashSet<Object>();

	public RestEasyApplication() {

		singletons.add(new AuthorAPI());
		singletons.add(new DesignTempletAPI());

	}

	@Override
	public Set<Object> getSingletons() {

		return singletons;

	}

}
