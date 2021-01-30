package com.sofi.test.power.giphy.enums;

public final class AppConstants {

	private AppConstants() {

	}

	/** URLs. */
	public static final String APP_BASE_V1_URL = "/api/v1";
	public static final String SEARCH_BASE_URL = APP_BASE_V1_URL + "/search";

	/** Search constants. */
	public static final int SEARCH_OFFSET = 0;
	public static final int SEARCH_LIMIT = 5;
	public static final int SEARCH_THRESHOLD = 5;
}
