package com.bet.me.config;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;

import com.bet.me.model.Sport;
import com.bet.me.service.SportsService;

public class GetAllSportsCommandLineRunner  implements CommandLineRunner{
	Logger logger = LoggerFactory.getLogger(GetAllSportsCommandLineRunner.class);
	
	private final SportsService sportsService;
	public GetAllSportsCommandLineRunner(final SportsService sportsService) {
		this.sportsService = sportsService;
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("Populating the sports database");
		final List<Sport> sports = sportsService.getAllSports();
		//TODO: need to save this data to DB
		
	}

}
