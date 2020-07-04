package com.hvdomingues.DinnerApp.resources;

import java.time.Instant;
import java.time.ZoneId;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hvdomingues.DinnerApp.entities.IndividualBill;
import com.hvdomingues.DinnerApp.entities.Order;
import com.hvdomingues.DinnerApp.services.servicesInterfaces.IOrderService;

@RestController
@RequestMapping(value = "orders")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class OrderResource {

	/*
	 * @Autowired private IIndividualBillService indBillService;
	 */

	@Autowired
	private IOrderService service;

	@GetMapping(value = "/{indbillid}")
	public ResponseEntity<List<Order>> findAll(@PathVariable Integer indbillid) {
		List<Order> results = service.getAll(indbillid);
		return ResponseEntity.ok().body(results);
	}

	
	  @RequestMapping(method = RequestMethod.POST, consumes =
	  MediaType.APPLICATION_FORM_URLENCODED_VALUE, produces =
	  {MediaType.APPLICATION_ATOM_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
	  public Order saveOrder(Integer individualBillID) {
	  
		  IndividualBill indBill = new IndividualBill();
		  indBill.setId(individualBillID);
		  Order toSave = new Order(Instant.now(), indBill);
		  return service.saveOne(toSave);
		  
	  }
	 

}
