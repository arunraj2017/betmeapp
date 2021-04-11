package com.bet.me.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CachePut;
import org.springframework.stereotype.Service;

import com.bet.me.client.RetrieveApiDataFeignClient;
import com.bet.me.model.OddsData;
import com.bet.me.model.Sport;

@Service
public class SportsService {
	private Logger logger = LoggerFactory.getLogger(SportsService.class);
	
	private final RetrieveApiDataFeignClient sportsClient;
	
	public SportsService(final RetrieveApiDataFeignClient sportsClient) {
		this.sportsClient = sportsClient;
	}
	
	/*
	 * This function will return all sports
	 * */
	public List<Sport> getAllSports() {
		logger.info("calling the api to get sports data");
		return sportsClient.getSportsResponse().data;
	}

	/*
	 * this function will return all odds given sport, region and mkt
	 * */
	public List<OddsData> getOddsData(final String sport, final String region, final String mkt) {
		return sportsClient.getOddsData(sport, region, mkt).getData();
	}
	
	public void putUpcomingMatchesToCache() {
		final List<OddsData> oddsData = this.getOddsData("upcoming", "uk", "h2h");
		oddsData.forEach(odds -> this.cacheOddsData(odds) );
	}
	
	@CachePut(value="odds-data", key = "oddsData.id")
	private OddsData cacheOddsData(final OddsData oddsData) {
		return oddsData;
	}
	
	
	
	
}
