package com.name.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.name.service.NameService;

@RestController
public class NameController {
	
	@Autowired
	private NameService service;
	
	@RequestMapping(method = RequestMethod.GET, value = "/getName/{nameType}")
	public String getName(@PathVariable(name = "nameType") String nameType) {
		return service.getNameByParam(nameType);
	}
  
}
