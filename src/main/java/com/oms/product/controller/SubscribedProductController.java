package com.oms.product.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.oms.product.dto.SubscribedProductDTO;
import com.oms.product.service.SubscribedProductService;

@RestController
@CrossOrigin
@RequestMapping(value = "/api")
public class SubscribedProductController {

	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	SubscribedProductService subProductService;
	
	@Autowired
	Environment environment;
	
	//Fetching Subscription with Primary Key SubID
	@GetMapping(value = "/subscriptions/{subId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<SubscribedProductDTO> getSubscriptionById(@PathVariable Long subId) {
		logger.info("===SubscribedProductController : Fetching details of subscription with subId {}", subId);
		try {
			SubscribedProductDTO subProductDTO =  subProductService.getSubscriptionById(subId);
			return new ResponseEntity<SubscribedProductDTO>(subProductDTO, HttpStatus.OK);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, environment.getProperty(e.getMessage()), e);
		}
	}
	
	//Add Subscription without primary key (auto-generated) 
	@PostMapping(value = "/subscriptions/add",  consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> addSubscription(@RequestBody SubscribedProductDTO subProductDTO) {
		logger.info("====Subscription Creation Request with data {}", subProductDTO);
		String msg = environment.getProperty("SUBSCRIPTION.SUCCESS")+ " " +subProductService.addSubscription(subProductDTO);
		return new ResponseEntity<String>(msg, HttpStatus.OK);
		
	}
	
}
