package com.example.demo.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

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
	@Size(max = 100)
	private String todo;
	
	
	@NotNull
	private LocalDateTime date = LocalDateTime.now();
	
	private boolean finished = false;
	
	
	
        // Stores the deadline date in yyyy-MM-dd format
        private String deadlineDate;
	
	
	private String deadTime;
	
	@ManyToOne
	private SiteUser siteUser;
}
