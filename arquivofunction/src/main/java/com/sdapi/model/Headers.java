package com.sdapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Headers {
	
    @JsonProperty("Content-Type") 
    public String contentType;

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

}
