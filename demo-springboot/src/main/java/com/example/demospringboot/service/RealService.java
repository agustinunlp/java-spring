package com.example.demospringboot.service;

import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

public class RealService {

    @PostConstruct
    public void postConstruct() {
        System.out.println("postConstruct in RealService");
    }
}
