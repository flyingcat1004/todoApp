package com.example.demo;

import org.apache.catalina.core.ApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.model.Content;
import com.example.demo.service.ContentService;

@SpringBootApplication
public class TodoappApplication /*implements CommandLineRunner*/ {
	
	@Autowired
	ContentService contentService;
	
	public static void main(String[] args) {
		SpringApplication.run(TodoappApplication.class, args);
	}

	/*@Override
	public void run(String... args) throws Exception {
		Content content = new Content();
		content.setTodo("go to apple store");
		contentService.create(content);
		
	}*/
	
	
}
