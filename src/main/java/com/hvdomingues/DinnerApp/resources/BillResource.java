package com.hvdomingues.DinnerApp.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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

	@CrossOrigin
	@GetMapping
	public ResponseEntity<List<Bill>> findAll() {
		List<Bill> list = service.getAll();

		return ResponseEntity.ok().body(list);
	}
	
	@CrossOrigin
	@GetMapping(value = "/inactive")
	public ResponseEntity<List<Bill>> findAllInactive() {
		List<Bill> list = service.getInactiveBills();

		return ResponseEntity.ok().body(list);
	}
	
	@CrossOrigin
	@GetMapping(value = "/active")
	public ResponseEntity<List<Bill>> findAllActive() {
		List<Bill> list = service.getActiveBills();

		return ResponseEntity.ok().body(list);
	}

	@CrossOrigin
	@GetMapping(value = "/{id}")
	public ResponseEntity<Bill> findById(@PathVariable Integer id) {
		Bill obj = service.getByID(id);
		return ResponseEntity.ok().body(obj);
	}

	/*
	 * @RequestMapping(method = RequestMethod.POST, consumes = "application/json")
	 * public Bill saveBill(@RequestBody Bill request) {
	 * 
	 * 
	 * return service.saveOne(request); }
	 */
	
	@CrossOrigin
	@RequestMapping(method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<Bill> addBill(@RequestBody Integer tableNumber) {
		
		Bill obj = service.saveOne(new Bill(tableNumber));
		return ResponseEntity.ok().body(obj);
	}

}
