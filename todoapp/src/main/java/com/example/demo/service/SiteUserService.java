package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.SiteUser;
import com.example.demo.repository.SiteUserRepository;

@Service
public class SiteUserService {
	@Autowired
	SiteUserRepository siteUserRepository;
	
	public List<SiteUser> findAll() {
        return siteUserRepository.findAll();
    }

    public SiteUser findOne(Long id) {
    	Optional<SiteUser> siteUser = siteUserRepository.findById(id);
        return siteUser.get();
    }

    public SiteUser create(SiteUser siteUser) {
        return siteUserRepository.save(siteUser);
    }

    public SiteUser update(SiteUser siteUser) {
        return siteUserRepository.save(siteUser);
    }

    public void delete(Long id) {
        siteUserRepository.deleteById(id);;
    }
}
