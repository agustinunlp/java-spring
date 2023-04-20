package com.example.demoaspects.serviceImpl;

import com.example.demoaspects.annotation.AnotherCustomMethodAnnotation;
import com.example.demoaspects.annotation.CustomAnnotation;
import com.example.demoaspects.annotation.CustomMethodAnnotation;
import com.example.demoaspects.service.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
@CustomAnnotation
public class BookServiceImpl implements BookService {
    private Logger log = LoggerFactory.getLogger(BookServiceImpl.class);

    @Override
    public void search() {
        log.info("Execute functionality INSIDE Search method");
    }

    @Override
    public void share() {
        log.info("Execute functionality INSIDE Share method");
    }

    @Override
    public void count() {
        log.info("Execute functionality INSIDE Count method");
    }

    @Override
    @CustomMethodAnnotation
    public void markAsRead() {
        log.info("Execute functionality INSIDE markAsRead method");
    }

    @Override
    public void deprecate() {
        log.info("Execute functionality INSIDE deprecate method");
        throw new RuntimeException();
    }

    @Override
    @AnotherCustomMethodAnnotation
    public void findByName(String name) {
        log.info("Execute functionality INSIDE findByName method");
    }
}
