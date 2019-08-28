package com.selfproject.fxratesapp.fxratesfetchservice.services;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.selfproject.fxratesapp.fxratesfetchservice.model.FxRate;
import com.selfproject.fxratesapp.fxratesfetchservice.proxy.FxRateFetchSchedulerProxy;

@Component
public class fxRateFetchScheduler {
	
	@Autowired
	FxRateFetchSchedulerProxy fxRateFetchSchedulerProxy;
	
	
	@Scheduled(fixedDelay = 600000)
	public void fxScheduler() throws IOException {
		
		System.out.println("Scheduler is working yay!");
		RestTemplate restTemplate = new RestTemplate();
		String fxrateApiUrl = "";
		ResponseEntity<String> responseEntity = restTemplate.getForEntity(fxrateApiUrl, String.class);
		
//		FxRate fxRate = restTemplate.getForObject(fxrateApiUrl, FxRate.class);
		
		ObjectMapper objectMapper = new ObjectMapper();
		JsonNode rootNode = objectMapper.readTree(responseEntity.getBody());
		
		JsonNode EURUSDNode = rootNode.path("EURGBP");
		JsonNode rateNode = EURUSDNode.path("rate");
		JsonNode timestampNode = EURUSDNode.path("timestamp");
		
		
		FxRate fxRate = new FxRate(rateNode.asDouble(), timestampNode.asDouble());
		System.out.println(fxRate.getRate());
		if(fxRate.getRate()>0.90) {
			System.out.println("inside if");
			fxRateFetchSchedulerProxy.sendEmailAlert("Test - Good time to shop! yay!");
		}
	}

}
