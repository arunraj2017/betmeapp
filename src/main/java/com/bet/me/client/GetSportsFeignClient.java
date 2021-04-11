package com.bet.me.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bet.me.model.ApiResponse;
import com.bet.me.model.OddsData;
import com.bet.me.model.Sport;

@FeignClient(name="sportsClient",url = "${betmeapp.host.url}")
public interface GetSportsFeignClient {

	@GetMapping(value = "${betmeapp.sports.url}&all=true")
	public ApiResponse<Sport> getSportsResponse();
	
	@GetMapping(value="${betmeapp.odds.url}")
	public ApiResponse<OddsData> getOddsData(@RequestParam(value = "sport") final String sport, 
			@RequestParam(value = "region") final String region,
			@RequestParam(value = "mkt")final String mkt);
}
