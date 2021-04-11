package com.bet.me.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;

import com.bet.me.service.SportsService;

public class GetUpcomingFixturesCommandLineRunner implements CommandLineRunner{Logger logger = LoggerFactory.getLogger(GetAllSportsCommandLineRunner.class);

private final SportsService sportsService;
public GetUpcomingFixturesCommandLineRunner(final SportsService sportsService) {
	this.sportsService = sportsService;
}
	

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
