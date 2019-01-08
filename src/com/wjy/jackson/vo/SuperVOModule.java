package com.wjy.jackson.vo;

import com.fasterxml.jackson.databind.module.SimpleModule;

public class SuperVOModule extends SimpleModule {

	private static final long serialVersionUID = -4926012419549061732L;

	public SuperVOModule() {
		super("SuperVOModule");
	}

	@Override
	public void setupModule(SetupContext context) {
		context.setMixInAnnotations(SuperVO.class, MixInSuperVO.class);
	}

}
