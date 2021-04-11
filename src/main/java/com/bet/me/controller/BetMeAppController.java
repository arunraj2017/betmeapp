package com.bet.me.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bet.me.model.OddsData;
import com.bet.me.model.Sport;
import com.bet.me.service.SportsService;

@RestController
public class BetMeAppController {
	
	public BetMeAppController(final SportsService sportsService) {
		this.sportsService = sportsService;
	}
	
	private final SportsService sportsService;

	@GetMapping("/v1/getallsports")
	public List<Sport> getAllSports() {
		final List<Sport> response = sportsService.getAllSports();
		return response;
	}
	
	@GetMapping("/v1/getodds")
	public List<OddsData> getOdds(
			@RequestParam(required = true, name = "sport") String sport,
			@RequestParam(required = true, name = "region") String region,
			@RequestParam(required = true, name = "mkt") String mkt
			) {
		final List<OddsData> response = sportsService.getOddsData(sport, region, mkt);
		return response;
	}
	
	@GetMapping("/v1/getcache")
	public List<OddsData> getOdds() {
		final List<OddsData> response = sportsService.getCachedOddsData();
		return response;
	}
	@GetMapping("/v1/getodds")
	public List<OddsData> getOdds(
			@RequestParam(required = true, name = "sport") String sportKey
			) {
		final List<OddsData> response = sportsService.getCachedSportOddsData(sportKey);
		return response;
	}
}
