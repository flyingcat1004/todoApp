package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Component
public class SearchContentM {
	@Id
	@GeneratedValue
	private Long idLong;
	
	@Size(max=100)
	private String todo;
	
	@Size(max=10)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private String deadlineDate;
	
	@Size(max=20)
	private String siteUserName;
}
