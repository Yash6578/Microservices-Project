package com.ashokit.rest_api_2.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "ABOUT-US-API")
public interface AboutsClient {
    @GetMapping("/about-us")
    String aboutUs();
}
