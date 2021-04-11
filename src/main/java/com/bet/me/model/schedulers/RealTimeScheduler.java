package com.bet.me.model.schedulers;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
public class RealTimeScheduler  {
	
	@Scheduled(fixedRateString  = "${betmeapp.realtime.delayms}")
	public void runRealTimeCache() {
		
		
		
	}
	
	
	
}
