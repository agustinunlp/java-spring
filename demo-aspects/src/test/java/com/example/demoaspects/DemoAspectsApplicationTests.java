package com.example.demoaspects;

import com.example.demoaspects.service.BookService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
class DemoAspectsApplicationTests {

	@Autowired
	private BookService bookService;

	@Test
	void methodCount() {
		bookService.count();
	}

	@Test
	void methodSearch() {
		bookService.search();
	}

	@Test
	void methodShare() {
		bookService.share();
	}

	@Test
	void markAsRead() {
		bookService.markAsRead();
	}

	@Test
	void deprecate() {
		bookService.deprecate();
	}

	@Test
	void findByName() {
		bookService.findByName("Harry");
	}
}
