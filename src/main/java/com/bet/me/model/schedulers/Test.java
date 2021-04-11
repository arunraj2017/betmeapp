package com.bet.me.model.schedulers;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.TimeZone;

import com.bet.me.model.Site;
import com.bet.me.service.SportsCacheService;

public class Test {

	public static void main(String[] args) {
		Long test_timestamp = 1618168162L;
		LocalDateTime triggerTime =
		        LocalDateTime.ofInstant(Instant.ofEpochSecond(test_timestamp), 
		                                TimeZone.getDefault().toZoneId());  

		System.out.println(triggerTime);
		
		SportsCacheService scs = new SportsCacheService(null);
		Site site1 = new Site();
		site1.setSite_key("1");
		site1.setLast_update(1111L);
		
		Site site2 = new Site();
		site2.setSite_key("2");
		site2.setLast_update(2222L);
		
		Site site3 = new Site();
		site3.setSite_key("3");
		site3.setLast_update(3333L);
		
		Site site4 = new Site();
		site4.setSite_key("4");
		site4.setLast_update(4444L);
		
		Site site5 = new Site();
		site5.setSite_key("5");
		site5.setLast_update(5555L);
		
		Site site6 = new Site();
		site6.setSite_key("6");
		site6.setLast_update(6666L);
		
		List<Site> siteA = Arrays.asList(site1, site4, site3);
		List<Site> siteB = Arrays.asList(site1, site2, site3);
		
		System.out.println(scs.isSitesSame(siteA, siteB));

	}

}
