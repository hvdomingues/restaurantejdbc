package com.hvdomingues.DinnerApp.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hvdomingues.DinnerApp.entities.Bill;
import com.hvdomingues.DinnerApp.services.servicesInterfaces.IBillService;

@RestController
@RequestMapping(value = "/bills")
public class BillResource {

	@Autowired
	private IBillService service;

	@GetMapping
	public ResponseEntity<List<Bill>> findAll() {
		List<Bill> list = service.getAll();

		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Bill> findById(@PathVariable Integer id) {
		Bill obj = service.getByID(id);
		return ResponseEntity.ok().body(obj);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = "application/json")
	public Bill saveBill(@RequestBody Bill request) {
		
		
		return service.saveOne(request);
	}

}
