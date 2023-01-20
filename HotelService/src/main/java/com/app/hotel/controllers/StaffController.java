package com.app.hotel.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/staffs")
public class StaffController {

	@GetMapping
	public List<String> getStaffs(){
		List<String> list = Arrays.asList("chetan","kamlesh","ravin");
		return list;
	}
}
