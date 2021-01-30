package com.sofi.test.power.giphy.enums;

public enum GiphyUrlConstants {

	V1_SEARCH("v1/gifs/search?api_key=%s&q=%s&limit=%d&offset=%d");

	private String url;

	GiphyUrlConstants(String url) {
		this.url = url;
	}

	public String getUrl() {
		return this.url;
	}
}
