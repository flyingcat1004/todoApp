package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Content;

public interface ContentRepository extends JpaRepository<Content, Long> {

}
