package com.sedeso.dig.controllers.restclient;
import java.net.URI;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;


@Component
public class RestClient implements IRestClient{

    
	private final Logger logger = LoggerFactory.getLogger(RestClient.class);
	
	private final int HTTP_CONNECT_TIMEOUT = 45000;
	private final int HTTP_READ_TIMEOUT = 45000;
	
    @Override
    public <T> T executeRestService(String url, String httpMetodo, MultiValueMap<String, String> headers,
    		Object objectRequest, Class<T> objetcResponse) throws Exception {
    	
    	
    	logger.info("exec service url=" + url +" HttpMethod ="+ httpMetodo );
    	/*Rest template*/
    	RestTemplate restTemplate = new RestTemplate( getClientHttpRequestFactory());		
    	
        /**Obtenemos el HttpMethod [POST/GET/PUT/ETC...]*/
        HttpMethod httpMethod = this.generarHttpMetodo(httpMetodo);
        
        /*armamos objRequest & headers*/
        HttpEntity<Object> request = new HttpEntity<Object>(objectRequest, headers);
        
        ResponseEntity<String> response = restTemplate.exchange(
				new URI(url), httpMethod, request, String.class );
        
        ObjectMapper objectMapper = new ObjectMapper();
        
        return  objectMapper.readValue( (String)response.getBody(), objetcResponse);
    	
    }
    
    

    
    /*
     private ClientHttpRequestFactory getClientHttpRequestFactory() {
		    int timeout = 5000;
		    RequestConfig config = RequestConfig.custom()
		      .setConnectTimeout(timeout)
		      .setConnectionRequestTimeout(timeout)
		      .setSocketTimeout(timeout)
		      .build();
		    CloseableHttpClient client = HttpClientBuilder
		      .create()
		      .setDefaultRequestConfig(config)
		      .build();
		    return new HttpComponentsClientHttpRequestFactory(client);
	}
      */
    
    
    private ClientHttpRequestFactory getClientHttpRequestFactory() {
        HttpComponentsClientHttpRequestFactory clientHttpRequestFactory = new HttpComponentsClientHttpRequestFactory();
        clientHttpRequestFactory.setConnectTimeout(HTTP_CONNECT_TIMEOUT);
        clientHttpRequestFactory.setReadTimeout(HTTP_READ_TIMEOUT);
        return clientHttpRequestFactory;
    }

	private HttpMethod generarHttpMetodo(String httpMetodo){
		HttpMethod httpMethod;
		
		if(httpMetodo.equals("POST")){
			httpMethod = HttpMethod.POST;
		}else if(httpMetodo.equals("GET")){
			httpMethod = HttpMethod.GET;
		}else if(httpMetodo.equals("PUT")){
			httpMethod = HttpMethod.PUT;
		}else if(httpMetodo.equals("HEAD")){
			httpMethod = HttpMethod.HEAD;
		}else if(httpMetodo.equals("DELETE")){
			httpMethod = HttpMethod.DELETE;
		}else{
			httpMethod = HttpMethod.TRACE;
		}
		
		return httpMethod;
	}
}	
