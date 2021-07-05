package com.example.demo.model;

import java.util.List;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.example.demo.validator.UniqueLogin;

import lombok.Data;

@Data
@Entity
public class SiteUser {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Size(min = 2, max = 20)
	@UniqueLogin
	private String username;
	
	@Size(min = 4, max = 255)
	private String password;
	
	@NotBlank
	@Email
	private String email;
	
	private int gender;
	private boolean admin;
	private boolean root;
	private String role;
	private boolean active = true;
	
	@OneToMany(mappedBy = "siteUser")
	private List<Content> contents;
	
}
