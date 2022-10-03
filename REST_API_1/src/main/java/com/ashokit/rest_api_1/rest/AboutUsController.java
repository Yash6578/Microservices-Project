package com.ashokit.rest_api_1.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AboutUsController {

    @GetMapping("/about-us")
    ResponseEntity<String> welcome() {
        String msg = "About Us Page";
        return ResponseEntity.ok().body(msg);
    }
}
