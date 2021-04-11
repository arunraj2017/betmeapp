package com.bet.me.model.schedulers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.util.CollectionUtils;

import com.bet.me.model.Sport;
import com.bet.me.service.SportsService;

@Configuration
public class HourlyScheduler {
	private final Logger log = LoggerFactory.getLogger(HourlyScheduler.class);
	private final SportsService sportsService;
	public HourlyScheduler(final SportsService sportsService) {
		this.sportsService = sportsService;
	}
	
	@Scheduled(fixedDelay = 60*60*1000)
	public void runHourlyScheduler() {
		final List<Sport> sports = null; //get from database
		if(!CollectionUtils.isEmpty(sports)) {
			
			  sports.forEach(sprt -> { final List<OddsData> oddsData =
			  this.sportsService.getOddsData(sprt.getKey(), "uk", "h2h"); 
			  //TODO: need to save this to DB 
			  });
			 
		}
	}

}
