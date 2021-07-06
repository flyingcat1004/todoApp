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
import com.example.demo.service.ContentService;


@Controller
@RequestMapping("/search")
public class SearchController {
	@Autowired
	ContentService contentService;
	
	@GetMapping("/")
	public String searchHome(@ModelAttribute SearchContentM searchContentM, Model model) {
		
		return "searchHome";
	}
	
	@PostMapping("/")
	public String searchContent(@Validated @ModelAttribute SearchContentM searchContentM, BindingResult result, Model model) {
		if(result.hasErrors()) {
			System.out.println(result.getFieldErrors());
			return "searchHome";
		}
		model.addAttribute("contents", contentService.search(searchContentM.getTodo()));
		
		return "searchHome";
	}
	
}
