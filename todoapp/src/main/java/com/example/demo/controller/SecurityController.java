package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.model.SiteUser;
import com.example.demo.service.SiteUserService;
import com.example.demo.util.Role;

@Controller
public class SecurityController {
	@Autowired
	SiteUserService siteUserService;
	@Autowired
	BCryptPasswordEncoder passwordEncoder;
	
		
	@GetMapping("/register")
	public String register(@ModelAttribute("user") SiteUser user) {
		return "register";
	}
	
	@PostMapping("/register")
	public String process(@Validated @ModelAttribute("user") SiteUser user, BindingResult result) {
		
		if(result.hasErrors()) {
			return "register";
		}
	
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		user.setRole(Role.USER.name());
		
        siteUserService.create(user);

        return "redirect:/login";
	}
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	
	
	@GetMapping("/error")
	public String errorrr() {
		return "redirect:/login";
	}
	
	
	
	
}
