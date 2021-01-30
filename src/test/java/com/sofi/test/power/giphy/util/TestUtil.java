package com.sofi.test.power.giphy.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.sofi.test.power.giphy.dto.generated.Datum;
import com.sofi.test.power.giphy.dto.generated.Images;
import com.sofi.test.power.giphy.dto.generated.MainSearchResult;
import com.sofi.test.power.giphy.dto.generated.Original;
import com.sofi.test.power.giphy.dto.generated.Pagination;

public class TestUtil {

	public static final MainSearchResult getMainSearchResults(int no) {

		List<Datum> data = new ArrayList<>();
		for (int i = 1; i <= no; i++) {
			Datum datum = getDatum();
			datum.setId(Integer.toString(i));
			data.add(datum);
		}

		return MainSearchResult.builder().data(data).pagination(getPagination()).build();
	}

	public static final MainSearchResult getMainSearchResult() {

		return MainSearchResult.builder().data(Arrays.asList(getDatum())).pagination(getPagination()).build();
	}

	public static final Datum getDatum() {

		return Datum.builder().images(getImages()).type("test").id("1").url("http://dummy.me")
				.trendingDatetime("01-01-2020").build();
	}

	public static final Images getImages() {

		return Images.builder().original(getOriginal()).build();
	}

	public static final Original getOriginal() {

		return Original.builder().height("100").size("100").url("http://dummy.url").width("100").build();
	}

	public static final Pagination getPagination() {

		return Pagination.builder().count(5).totalCount(50).offset(0).build();
	}

}
