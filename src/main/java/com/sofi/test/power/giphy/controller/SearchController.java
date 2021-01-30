package com.sofi.test.power.giphy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sofi.test.power.giphy.domain.SearchResult;
import com.sofi.test.power.giphy.service.SearchService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

/**
 * Controller for all search operations.
 * 
 * @author psathiyamoorthy
 */
@RestController
@RequestMapping("/api/v1/search")
@Slf4j
@Api
public class SearchController {

	@Autowired
	private SearchService searchService;

	@GetMapping("/{searchTerm}")
	@ApiOperation("Search for GIFs")
	public SearchResult searchForGifs(@PathVariable("searchTerm") String searchTerm) {
		
		log.info("Inside searchForGifs method of SearchController.");
		return searchService.getSearchResults(searchTerm);
	}

}
