package com.sedeso.dig.controllers.restclient;

import org.springframework.util.MultiValueMap;

public interface IRestClient {
	public  <T> T executeRestService(String url, String httpMetodo, MultiValueMap<String, String> headers , Object objectRequest, 
			Class<T> objetcResponse) throws Exception;
	
}
