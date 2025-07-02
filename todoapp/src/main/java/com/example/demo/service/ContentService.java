package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Content;
import com.example.demo.model.SiteUser;
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
    
    public List<Content> search(String todo, String deadlineDate, SiteUser siteUser) {
    	
    	List<Content> contents = new ArrayList<Content>();
    	if (todo.equals("") && deadlineDate.equals("") && siteUser==null) {
    		contents = contentRepository.findAll();
    	}else if(todo.equals("") && deadlineDate.length()>0 && siteUser!=null) {
    		contents = contentRepository.findBySiteUserAndDeadlineDate(siteUser, deadlineDate);
        	
       	}else if(todo.length()>0 && siteUser!=null && deadlineDate.equals("")) {
       		contents = contentRepository.findByTodoLikeAndSiteUser("%" + todo + "%", siteUser);
       		
       	}else if(todo.length()>0 && siteUser==null && deadlineDate.length()>0) {
       		contents = contentRepository.findByTodoLikeAndDeadlineDate("%" + todo + "%", deadlineDate);
       		
       	}else if(todo.equals("") && siteUser!=null && deadlineDate.equals("")) {
       		contents = contentRepository.findBySiteUser(siteUser);
       		
       	}else if(todo.equals("") && siteUser==null && deadlineDate.length()>0) {
       		contents = contentRepository.findByDeadlineDate(deadlineDate);
       		
        }else if(todo.length()>0 && siteUser==null && deadlineDate.equals("")) {
                contents = contentRepository.findByTodoLike("%" + todo + "%");

        }else if(todo.length()>0 && siteUser!=null && deadlineDate.length()>0) {
                contents = contentRepository
                                .findByTodoLikeAndDeadlineDateAndSiteUser("%" + todo + "%", deadlineDate, siteUser);
        }
    	
    		
    	return contents;
    }
    
    public List<Content> search1(String todo, SiteUser siteUser){
    	List<Content> contents = contentRepository.findByTodoLikeAndSiteUser("%" + todo + "%", siteUser);
    	return contents;
    }
}
