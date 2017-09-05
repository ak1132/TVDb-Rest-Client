package com.tvdbRestClient.models.response;

public class ErrorResponse extends JsonErrors {

	private JsonErrors errors;

	public JsonErrors getErrors() {
		return errors;
	}

	public void setErrors(JsonErrors errors) {
		this.errors = errors;
	}

}