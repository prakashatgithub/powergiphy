package com.sofi.test.power.giphy.service.client;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriTemplate;

import com.sofi.test.power.giphy.dto.generated.MainSearchResult;
import com.sofi.test.power.giphy.enums.GiphyUrlConstants;
import com.sofi.test.power.giphy.exception.PowerGiphyException;

import lombok.extern.slf4j.Slf4j;

/**
 * Service to interact with the external Giphy API.
 * 
 * @author psathiyamoorthy
 */
@Service
@Slf4j
public class GiphyClientService {

	@Value("${giphy.api.host}")
	String host;

	@Value("${giphy.api.key}")
	String apiKey;

	@Autowired
	private RestTemplate restTemplate;

	public MainSearchResult searchForQuery(String query, int limit, int offset) {

		log.debug("Querying giphy for : " + query);
		try {
			URI uri = new UriTemplate(
					host + String.format(GiphyUrlConstants.V1_SEARCH.getUrl(), apiKey, query, limit, offset)).expand();

			MainSearchResult result = restTemplate.getForObject(uri.toString(), MainSearchResult.class);
			return result;
		} catch (Exception e) {
			log.error("Unable to get result from Giphy API." + e);
			throw new PowerGiphyException("Unable to get result from Giphy API", e);
		}

	}

}
