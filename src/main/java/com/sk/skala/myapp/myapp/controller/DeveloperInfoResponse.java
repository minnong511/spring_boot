package com.sk.skala.myapp.myapp.controller;

import com.sk.skala.myapp.myapp.config.DeveloperProperties;

public record DeveloperInfoResponse(
        DeveloperProperties.Owner owner,
        DeveloperProperties.Team team,
        String activeProfiles
) {
}