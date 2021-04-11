package com.bet.me.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.bet.me.client.GetSportsFeignClient;
import com.bet.me.model.OddsData;
import com.bet.me.model.Sport;

@Service
public class SportsService {
	private Logger logger = LoggerFactory.getLogger(SportsService.class);
	
	private final GetSportsFeignClient sportsClient;
	
	public SportsService(final GetSportsFeignClient sportsClient) {
		this.sportsClient = sportsClient;
	}
	
	public List<Sport> getAllSports() {
		logger.info("calling the api to get sports data");
		return sportsClient.getSportsResponse().data;
	}

	public List<Sport> getAllSportsFromDB() {
		//TODO: get from DB
		return null;
	}
	
	public List<OddsData> getOddsData(final String sport, final String region, final String mkt) {
		return sportsClient.getOddsData(sport, region, mkt).getData();
	}
	
}
