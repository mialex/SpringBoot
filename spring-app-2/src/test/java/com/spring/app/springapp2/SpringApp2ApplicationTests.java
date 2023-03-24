package com.spring.app.springapp2;

import com.spring.app.springapp2.controller.MyController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

@SpringBootTest
class SpringApp2ApplicationTests {

	@Autowired
	MyController myController;

	@Autowired
	ApplicationContext applicationContext;

	@Test
	void testAutowireOfController() {
		System.out.println(myController.sayHello());
	}

	@Test
	void testGetMyControllerFromContext() {
		MyController controller = applicationContext.getBean(MyController.class);

		System.out.println(controller.sayHello());
	}

	@Test
	void contextLoads() {

	}

}
