package com.sk.skala.myapp.myapp.controller;

import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sk.skala.myapp.myapp.config.DeveloperProperties;

@RestController
@RequestMapping("/api")

public class DeveloperInfoController {

    private final DeveloperProperties developerProperties;
    private final Environment environment;

    public DeveloperInfoController(
            DeveloperProperties developerProperties,
            Environment environment
    ) {
        this.developerProperties = developerProperties;
        this.environment = environment;
    }

    @GetMapping("/developer-info")
    public DeveloperInfoResponse getDeveloperInfo() {
        String activeProfiles = String.join(", ", environment.getActiveProfiles());

        return new DeveloperInfoResponse(
                developerProperties.getOwner(),
                developerProperties.getTeam(),
                activeProfiles
        );
    }
}