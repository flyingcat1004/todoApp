package com.example.demo.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Component;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Component
public class Content {
	@Id
	@GeneratedValue
	private Long id;
	
	@NotBlank
	private String todo;
	
	
	@NotNull
	private LocalDateTime date = LocalDateTime.now();
	
	private boolean finished = false;
	
	
	
	private String deadlineDate;// = LocalDateTime.now();
	
	
	private String deadTime;
	
	@ManyToOne
	private SiteUser siteUser;
}
