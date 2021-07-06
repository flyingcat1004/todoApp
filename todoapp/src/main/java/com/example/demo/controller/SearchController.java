package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.SearchContentM;
import com.example.demo.model.SiteUser;
import com.example.demo.repository.SiteUserRepository;
import com.example.demo.service.ContentService;
import com.example.demo.service.SiteUserService;


@Controller
@RequestMapping("/search")
public class SearchController {
	@Autowired
	ContentService contentService;
	
	@Autowired
	SiteUserService siteUserService;
	@GetMapping("/")
	public String searchHome(@ModelAttribute SearchContentM searchContentM, Model model) {
		
		return "searchHome";
	}
	
	@PostMapping("/")
	public String searchContent(@Validated @ModelAttribute SearchContentM searchContentM, Model model) {
		
		SiteUser siteUser = siteUserService.findOneByName(searchContentM.getSiteUserName());
		model.addAttribute("contents", contentService.search(searchContentM.getTodo(), searchContentM.getDeadlineDate(), siteUser));
		
		return "searchHome";
	}
	
}
