package com.demo.spring;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.spring.entity.Emp;

@RestController
public class MyRestController {

	@Autowired
	EmpRepository repo;

	// @RequestMapping(path="/greet",method=RequestMethod.GET)
	@GetMapping(path = "/greet/{name}")
	public String greet(@PathVariable("name") String name) {
		return "Hi," + name + " This is REST Response";
	}

	@GetMapping(path = "/app/emp", produces = { MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE })
	// http://localhost:8080/emp-rest-app/emp?empid=102
	public ResponseEntity getEmployee(@RequestParam("empid") int id) {
		Optional<Emp> o = repo.findById(id);
		if (o.isPresent()) {
			return ResponseEntity.ok(o.get());
		} else {
			return ResponseEntity.ok("No Employee Found");
		}
	}
	@GetMapping(path = "/app/emplist", produces = { MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity getEMpList(){
		
		return ResponseEntity.ok(repo.findAll());
	}
}
