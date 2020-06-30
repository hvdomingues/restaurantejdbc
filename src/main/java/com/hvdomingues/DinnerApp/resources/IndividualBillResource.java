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

import com.hvdomingues.DinnerApp.entities.IndividualBill;
import com.hvdomingues.DinnerApp.services.servicesInterfaces.IIndividualBillService;

@RestController
@RequestMapping(value = "individualbills")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class IndividualBillResource {

	@Autowired
	private IIndividualBillService service;


	@GetMapping(value = "/{billid}")
	public ResponseEntity<List<IndividualBill>> findAll(@PathVariable Integer billid) {
		List<IndividualBill> results = service.getAll(billid);
		return ResponseEntity.ok().body(results);
	}
	

	

	@RequestMapping(method = RequestMethod.POST, consumes = "application/json")
	public IndividualBill saveIndividualBill(@RequestBody IndividualBill request) {
		
		
		return service.saveOne(request);
	}

}
