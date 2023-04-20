package com.example.demoaspects.service;

public interface BookService {

    void search();

    void share();

    void count();

    void markAsRead();

    void deprecate();

    void findByName(String name);
}
