package com.hvdomingues.DinnerApp.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hvdomingues.DinnerApp.entities.Category;
import com.hvdomingues.DinnerApp.services.servicesInterfaces.ICategoryService;

@RestController
@RequestMapping(value = "menu")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CategoryResource {

	@Autowired
	private ICategoryService service;

	@GetMapping
	public ResponseEntity<List<Category>> findAll() {
		List<Category> results = service.getAll();
		return ResponseEntity.ok().body(results);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE, produces = {
			MediaType.APPLICATION_ATOM_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public Category saveCategory(String categoryName) {

		return service.saveOne(new Category(null, categoryName));

	}

}
