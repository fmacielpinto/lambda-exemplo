package com.sdapi.model;

import com.sdapi.model.Headers;

public class Retorno {

	public int statusCode;
	public Headers headers;
	public Object multiValueHeaders;
	public String body;
	public boolean isBase64Encoded;
	
	
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	public Headers getHeaders() {
		return headers;
	}
	public void setHeaders(Headers headers) {
		this.headers = headers;
	}
	public Object getMultiValueHeaders() {
		return multiValueHeaders;
	}
	public void setMultiValueHeaders(Object multiValueHeaders) {
		this.multiValueHeaders = multiValueHeaders;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public boolean isBase64Encoded() {
		return isBase64Encoded;
	}
	public void setBase64Encoded(boolean isBase64Encoded) {
		this.isBase64Encoded = isBase64Encoded;
	}
	
	

}
