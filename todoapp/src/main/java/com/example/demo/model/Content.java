package com.example.demo.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

import org.springframework.format.annotation.DateTimeFormat;

import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Content {
	@Id
	@GeneratedValue
	private Long id;
	
	@NotBlank
	private String todo;
	
	
	@NotNull
	private LocalDateTime date = LocalDateTime.now();
	
	private boolean finished = false;
	
	
	@NotNull
	private LocalDateTime deadline;
	
}
