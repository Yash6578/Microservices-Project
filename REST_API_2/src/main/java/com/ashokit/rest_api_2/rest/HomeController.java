package com.ashokit.rest_api_2.rest;

import com.ashokit.rest_api_2.bean.Location;
import com.ashokit.rest_api_2.client.AboutsClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class HomeController {

    final AboutsClient aboutsClient;

    final Environment environment;

    Logger log = LoggerFactory.getLogger(HomeController.class);

    public HomeController(AboutsClient aboutsClient, Environment environment) {
        this.environment = environment;
        this.aboutsClient = aboutsClient;
    }

    @GetMapping("/home")
    ResponseEntity<String> home() {
        String port = "Executing home from port: " + environment.getProperty("server.port");
        String msg = port + " Welcome to home page " + aboutsClient.aboutUs();
        return ResponseEntity.ok(msg);
    }

    @GetMapping("/home/pincode/{pinCode}")
    ResponseEntity<Location> getLocationDetails(@PathVariable Integer pinCode) {
        RestTemplate rt = new RestTemplate();
        String endPointUrl = "https://api.zippopotam.us/in/" + pinCode;
        System.out.println(endPointUrl);
        return rt.getForEntity(endPointUrl, Location.class);
    }

    @GetMapping("/home/logs")
    ResponseEntity<String> printLogs() {
        String port = "Executing home from port: " + environment.getProperty("server.port");
        System.out.println(port);
        log.trace("TRACE-LOG" );
        log.debug("DEBUG-LOG");
        log.info("INFO-LOG");
        log.warn("WARN-LOG");
        log.error("ERROR-LOG");

        return ResponseEntity.ok("Log printed on console" + port);
    }
}
