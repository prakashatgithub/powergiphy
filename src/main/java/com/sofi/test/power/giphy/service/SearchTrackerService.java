package com.sofi.test.power.giphy.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class SearchTrackerService {

	private static Map<String, Integer> numberOfGifSharesById = new HashMap<String, Integer>();

	public void trackSharing(String gifId, int count) {

		if (numberOfGifSharesById.containsKey(gifId)) {

			numberOfGifSharesById.put(gifId, numberOfGifSharesById.get(gifId) + 1);
		} else {

			numberOfGifSharesById.put(gifId, 1);
		}
	}
	
}
