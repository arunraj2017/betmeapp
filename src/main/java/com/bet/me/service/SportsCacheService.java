package com.bet.me.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachePut;
import org.springframework.stereotype.Service;

import com.bet.me.model.OddsData;

@Service
public class SportsCacheService {
	private final CacheManager cacheManager;
	
	public SportsCacheService(final CacheManager cacheManager) {
		this.cacheManager = cacheManager;
	}
	
	@CachePut(value = "odds-data", key = "#oddsData.id")
	public OddsData cacheOddsData(final OddsData oddsData) {
		return oddsData;
	}
	
	public List<OddsData> getCachedOddsData() {
		final Map<Object, Object> cache = (Map<Object, Object>) this.cacheManager
				.getCache("odds-data").getNativeCache();
		List<OddsData> oddsList = new ArrayList<>();
		
		cache.forEach((k,v) -> oddsList.add((OddsData) v));
		return oddsList;
	}

}
