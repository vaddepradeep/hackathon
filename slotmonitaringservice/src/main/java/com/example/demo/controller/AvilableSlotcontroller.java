package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.ResStatus;
import com.example.demo.service.parkingServiceImpl;

@RestController
public class AvilableSlotcontroller {
	@Autowired
	private  parkingServiceImpl  pimpl;
	@GetMapping("/check/{vtype}")
	ResStatus checkAvilabulity(@PathVariable("vtype") String type)
	{
		ResStatus resStatus =pimpl.checkSlotAvilableService(type);
		return resStatus;
	}

}
