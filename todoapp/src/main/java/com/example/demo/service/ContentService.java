package com.example.demo.service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Content;
import com.example.demo.repository.ContentRepository;

@Service
public class ContentService {
	@Autowired
	ContentRepository contentRepository;
	
	public List<Content> findAll() {
        return contentRepository.findAll();
    }

    public Content findOne(Long id) {
    	Optional<Content> content = contentRepository.findById(id);
        return content.get();
    }

    public Content create(Content content) {
        return contentRepository.save(content);
    }

    public Content update(Content content) {
        return contentRepository.save(content);
    }

    public void delete(Long id) {
        contentRepository.deleteById(id);
    }
    
    public List<Content> search(String todo) {
    	List<Content> contents = contentRepository.findByTodoLike("%" + todo + "%");
    	return contents;
    }
}
