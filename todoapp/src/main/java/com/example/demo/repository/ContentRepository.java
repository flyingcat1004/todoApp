package com.example.demo.repository;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Content;

public interface ContentRepository extends JpaRepository<Content, Long> {
	
	List<Content> findByTodoLike(String todo);
	
}

