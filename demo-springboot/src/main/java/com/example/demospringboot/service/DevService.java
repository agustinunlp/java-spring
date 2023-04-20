package com.example.demospringboot.service;

import javax.annotation.PostConstruct;

public class DevService {

    @PostConstruct
    public void postConstruct() {
        System.out.println("postConstruct in DevService");
    }
}
