package com.selfproject.fxratesapp.fxratesfetchservice.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name="email-alert-service", url="localhost:8081")
public interface FxRateFetchSchedulerProxy {
	
	@PostMapping("/sendemail")
	public void sendEmailAlert(@RequestBody String message);
}
