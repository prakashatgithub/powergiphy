package com.sofi.test.power.giphy.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class GifResult {
	
	private String gif_id;
	
	private String url;

}
