package com.hvdomingues.DinnerApp.resources;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hvdomingues.DinnerApp.entities.Bill;
import com.hvdomingues.DinnerApp.entities.IndividualBill;
import com.hvdomingues.DinnerApp.services.servicesInterfaces.IBillService;
import com.hvdomingues.DinnerApp.services.servicesInterfaces.IIndividualBillService;

@RestController
@RequestMapping(value = "individualbills")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class IndividualBillResource {

	@Autowired
	private IIndividualBillService service;

	@Autowired IBillService billService;

	@GetMapping(value = "/{billid}")
	public ResponseEntity<List<IndividualBill>> findAll(@PathVariable Integer billid) {
		List<IndividualBill> results = service.getAll(billid);
		return ResponseEntity.ok().body(results);
	}

	@RequestMapping(method = RequestMethod.POST,
	        consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE, 
	        produces = {MediaType.APPLICATION_ATOM_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
	public IndividualBill saveIndividualBill(String observation, Integer tabPosition, Integer billID) {
		
		System.out.println(observation);
		System.out.println(tabPosition);
		System.out.println(billID);
		
		Bill bill = billService.getByID(billID);
				IndividualBill request = new IndividualBill(bill, observation, tabPosition);
		return service.saveOne(request);
	}

}
