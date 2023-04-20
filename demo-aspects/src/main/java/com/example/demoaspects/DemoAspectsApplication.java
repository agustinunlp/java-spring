package com.example.demoaspects;

import com.example.demoaspects.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
public class DemoAspectsApplication implements CommandLineRunner {

	@Autowired
	private ApplicationContext applicationContext;

	public static void main(String[] args) {
		SpringApplication.run(DemoAspectsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		BookService bookService = (BookService) applicationContext.getBean("bookServiceImpl");
//
//		bookService.count();
//		bookService.search();
//		bookService.share();
	}
}
