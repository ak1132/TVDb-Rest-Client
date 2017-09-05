package com.tvdbRestClient.models.response;

import java.util.List;

public class JsonErrors {

	private List<String> invalidFilters;
	/**
	 * Non-null if some translations were not available in the specified language.
	 */
	private String invalidLanguage;
	private List<String> invalidQueryParams;

	public List<String> getInvalidFilters() {
		return invalidFilters;
	}

	public void setInvalidFilters(List<String> invalidFilters) {
		this.invalidFilters = invalidFilters;
	}

	public String getInvalidLanguage() {
		return invalidLanguage;
	}

	public void setInvalidLanguage(String invalidLanguage) {
		this.invalidLanguage = invalidLanguage;
	}

	public List<String> getInvalidQueryParams() {
		return invalidQueryParams;
	}

	public void setInvalidQueryParams(List<String> invalidQueryParams) {
		this.invalidQueryParams = invalidQueryParams;
	}

}
