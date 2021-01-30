package com.sofi.test.power.giphy.service;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.cache.CacheManager;

import com.sofi.test.power.giphy.domain.SearchResult;
import com.sofi.test.power.giphy.dto.generated.MainSearchResult;
import com.sofi.test.power.giphy.exception.PowerGiphyException;
import com.sofi.test.power.giphy.service.client.GiphyClientService;
import com.sofi.test.power.giphy.util.TestUtil;

@RunWith(MockitoJUnitRunner.class)
public class SearchServiceUnitTest {

	@InjectMocks
	SearchService searchService;

	@Mock
	private GiphyClientService clientService;

	@Mock
	private CacheManager cacheManager;

	/**
	 * Happy path - return 5 results.
	 */
	@Test
	public void testGetSearchResults_success() {

		BDDMockito.given(clientService.searchForQuery(Mockito.anyString(), Mockito.anyInt(), Mockito.anyInt()))
				.willReturn(TestUtil.getMainSearchResults(5));

		SearchResult searchResults = searchService.getSearchResults("test");

		assertEquals(5, searchResults.getData().size());
		Mockito.verify(clientService, times(1)).searchForQuery(Mockito.anyString(), Mockito.anyInt(), Mockito.anyInt());
		Mockito.verifyNoMoreInteractions(clientService);
	}

	/**
	 * Since api returns 4 results we should get none.
	 */
	@Test
	public void testGetSearchResults_zeroResultsLessThan5() {

		MainSearchResult mainSearchResult = TestUtil.getMainSearchResults(4);
		mainSearchResult.getPagination().setCount(4);
		BDDMockito.given(clientService.searchForQuery(Mockito.anyString(), Mockito.anyInt(), Mockito.anyInt()))
				.willReturn(mainSearchResult);

		SearchResult searchResults = searchService.getSearchResults("test");

		assertNull(searchResults.getData());
		Mockito.verify(clientService, times(1)).searchForQuery(Mockito.anyString(), Mockito.anyInt(), Mockito.anyInt());
		Mockito.verifyNoMoreInteractions(clientService);
	}

	/**
	 * API throws exception.
	 */
	@Test(expected = PowerGiphyException.class)
	public void testGetSearchResults_clientApiDown() {

		BDDMockito.given(clientService.searchForQuery(Mockito.anyString(), Mockito.anyInt(), Mockito.anyInt()))
				.willThrow(new PowerGiphyException("Unable to get result from Giphy API"));

		searchService.getSearchResults("test");

	}
}
