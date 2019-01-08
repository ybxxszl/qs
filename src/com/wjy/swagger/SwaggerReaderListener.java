package com.wjy.swagger;

import io.swagger.annotations.ApiKeyAuthDefinition;
import io.swagger.annotations.SecurityDefinition;
import io.swagger.annotations.SwaggerDefinition;
import io.swagger.jaxrs.Reader;
import io.swagger.jaxrs.config.ReaderListener;
import io.swagger.models.SecurityRequirement;
import io.swagger.models.Swagger;

@SwaggerDefinition(securityDefinition = @SecurityDefinition(apiKeyAuthDefinitions = {
		@ApiKeyAuthDefinition(in = ApiKeyAuthDefinition.ApiKeyLocation.HEADER, key = "authorId", name = "H-AuthorId"),
		@ApiKeyAuthDefinition(in = ApiKeyAuthDefinition.ApiKeyLocation.HEADER, key = "token", name = "H-Token") }))
public class SwaggerReaderListener implements ReaderListener {

	@Override
	public void beforeScan(Reader reader, Swagger swagger) {

	}

	@Override
	public void afterScan(Reader reader, Swagger swagger) {

		swagger.addSecurity(new SecurityRequirement().requirement("authorId"));
		swagger.addSecurity(new SecurityRequirement().requirement("token"));

	}

}
