package com.example.demo.repository;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Content;
import com.example.demo.model.SiteUser;

public interface ContentRepository extends JpaRepository<Content, Long> {
	
	List<Content> findByTodoLike(String todo);
	
	List<Content> findByDeadlineDate(String deadlineDate);
	
	List<Content> findBySiteUser(SiteUser siteUser);
	
	List<Content> findByTodoLikeAndDeadlineDate(String todo, String deadlineDate);
	
	List<Content> findByTodoLikeAndSiteUser(String todo, SiteUser siteUser);
	
	List<Content> findBySiteUserAndDeadlineDate(SiteUser siteUser, String deadlineDate); 
	
	List<Content> findByTodoLikeAndDeadlineDateAndSiteUser(String todo, String deadlinedate, SiteUser siteUser); 
}

