package com.example.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.example.demo.model.Content;
import com.example.demo.service.ContentService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@SpringBootApplication
public class TodoappApplication /*implements CommandLineRunner*/ {
	
	@Autowired
	ContentService contentService;
	
	private final ApplicationContext appContext;

	
	public static void main(String[] args) {
		SpringApplication.run(TodoappApplication.class, args);
	}

	/*@Override
	public void run(String... args) throws Exception {
		Content content = new Content();
		content.setTodo("go to apple store");
		contentService.create(content);
		
	}*/
	
	/*@Override
    public void run(String... args) throws Exception {
        String[] allBeanNames = appContext.getBeanDefinitionNames();
        for (String beanName: allBeanNames) {
            log.info("Bean名: {}", beanName);
        }
    }*/
	
	
}
