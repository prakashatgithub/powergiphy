package com.sofi.test.power.giphy.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.sofi.test.power.giphy.domain.GifResult;
import com.sofi.test.power.giphy.domain.SearchResult;
import com.sofi.test.power.giphy.dto.generated.Datum;
import com.sofi.test.power.giphy.dto.generated.MainSearchResult;
import com.sofi.test.power.giphy.enums.AppConstants;
import com.sofi.test.power.giphy.service.client.GiphyClientService;

import lombok.extern.slf4j.Slf4j;

/**
 * Service layer for processing search queries.
 * 
 * @author psathiyamoorthy
 */
@Service
@Slf4j
public class SearchService {

	/** CACHE REFRESH DURATION. */
	private static final int ONE_DAY_IN_MILLISECS = 24 * 60 * 60 * 1000;

	/** CACHE NAME. */
	private static final String SEARCH_RESULTS_CACHE = "SearchResultsCache";

	@Autowired
	private GiphyClientService clientService;

	@Autowired
	private CacheManager cacheManager;
	
	/**
	 * Looks for the results in cache first based on search query. If not in cache
	 * fetches from giphy external api and caches it. This cache clears up every 24
	 * hours.
	 * 
	 * @param query The search query.
	 * @return The results in a list.
	 */
	@Cacheable(SEARCH_RESULTS_CACHE)
	public SearchResult getSearchResults(String query) {

		SearchResult result = null;
		
		MainSearchResult mainResult = clientService.searchForQuery(query, AppConstants.SEARCH_LIMIT,
				AppConstants.SEARCH_OFFSET);

		// Check if the number of results are less than threshold.
		if (mainResult.getPagination().getCount() < AppConstants.SEARCH_THRESHOLD) {

			// return empty payload.
			result = SearchResult.builder().data(null).build();
			log.info("Returning empty payload as results were less than threshold for query: " + query);
		} else {

			result = generateReturnPayload(mainResult);
		}

		return result;
	}

	/**
	 * Iterate through the payload from giphy to extract the info we need and build
	 * it.
	 * 
	 * @param mainResult
	 * @return SearchResult
	 */
	private SearchResult generateReturnPayload(MainSearchResult mainResult) {

		SearchResult result;
		List<GifResult> gifResults = new ArrayList<>();

		for (Datum d : mainResult.getData()) {
			gifResults.add(GifResult.builder().gif_id(d.getId()).url(d.getImages().getOriginal().getUrl()).build());
		}

		result = SearchResult.builder().data(gifResults).build();
		return result;
	}

	/**
	 * Clear the cache every 24 hours.
	 */
	@Scheduled(fixedRate = ONE_DAY_IN_MILLISECS)
	public void clearCache() {

		log.info("Clearing up cache");
		cacheManager.getCache(SEARCH_RESULTS_CACHE).clear();
	}

}
