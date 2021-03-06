package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.Content;
import com.example.demo.model.SiteUser;
import com.example.demo.service.ContentService;
import com.example.demo.service.SiteUserService;



@Controller
@RequestMapping("/todo")
public class HomeController {
	@Autowired
	SiteUserService siteUserService;
	
	@Autowired
	ContentService contentService;
	
	@GetMapping("/test")
	public String test() {
		return "mainContent";
	}
	
	@GetMapping("/")
	public String main(@ModelAttribute Content content, Authentication loginUser, Model model) {
		
		model.addAttribute("username", loginUser.getName());
		model.addAttribute("role", loginUser.getAuthorities());
		//model.addAttribute("contents", contentService.findAll());
		SiteUser siteUser = siteUserService.findOneByName(loginUser.getName());
		model.addAttribute("contents", siteUser.getContents());
		return "mainContent";
	}
	
	@PostMapping("/delete")
	public String delete(@RequestParam Long id) {
		contentService.delete(id);
		return "redirect:/todo/";
	}
	
	@PostMapping("/create")
	public String create(@Validated @ModelAttribute Content content, BindingResult result, Authentication loginUser, Model model) {
		model.addAttribute("contents", contentService.findAll());
		
		if(result.hasErrors()) {
			System.out.println(result.getFieldErrors());
		

			return "mainContent";
		}
		
		content.setSiteUser(siteUserService.findOneByName(loginUser.getName()));
		contentService.create(content);
		return "redirect:/todo/";
	}
	
	@PostMapping("/editF")
	public String boolEdit(@RequestParam("bbb") String bbb, @RequestParam("id") Long id) {
		Content content = contentService.findOne(id);
		boolean bool1 = false;
		if (bbb.equals("0")) {
			bool1=false;
		}else if(bbb.equals("1")) {
			bool1=true;
		}
		content.setFinished(bool1);
		contentService.update(content);
		return "redirect:/todo/";
	}
	
	@GetMapping("/edit")
	public String editodo(@RequestParam Long id, Model model) {
		Content content = contentService.findOne(id);
		model.addAttribute(content);
		return "todoedit";
	}
	
	@PostMapping("/edit")
	public String editsave(@Validated @ModelAttribute Content content) {
		Content contentmain = contentService.findOne(content.getId());
		contentmain.setTodo(content.getTodo());
		contentmain.setDeadlineDate(content.getDeadlineDate());
		contentmain.setDeadTime(content.getDeadTime());
		contentService.update(contentmain);
		return "redirect:/todo/";
	}
	
	
	
}
