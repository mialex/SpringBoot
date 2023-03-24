package com.spring.app.springapp2;

import com.spring.app.springapp2.controller.MyController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringApp2Application {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringApp2Application.class, args);

		MyController controller = context.getBean(MyController.class);

		System.out.println("In the Main Method");

		System.out.println(controller.sayHello());
	}

}
