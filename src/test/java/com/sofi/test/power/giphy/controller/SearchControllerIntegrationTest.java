package com.sofi.test.power.giphy.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.sofi.test.power.giphy.service.SearchService;

@RunWith(SpringRunner.class)
@WebMvcTest(SearchController.class)
@AutoConfigureMockMvc
public class SearchControllerIntegrationTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private SearchService searchService;

	@Test
	public void shouldReturnStatus200() throws Exception {

		this.mockMvc.perform(get("/api/v1/search/test")).andExpect(status().isOk());
	}

}
