package br.com.rafaelmattos.desafioglobo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.rafaelmattos.desafioglobo.domain.Subscription;
import br.com.rafaelmattos.desafioglobo.dto.SubscriptionResponse;
import br.com.rafaelmattos.desafioglobo.service.SubscriptionService;
import br.com.rafaelmattos.desafioglobo.util.Converter;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/desafioglobo")
public class SubscriptionController {

	@Autowired
	SubscriptionService subscriptionService;
	
	@Autowired
	private final Converter converter;

	public SubscriptionController(Converter converter) {
		this.converter = converter;
	}

	@ApiOperation(value = "Search subscription by id.")
	@RequestMapping(value = "/subscription/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable String id) {
		Subscription subscription = subscriptionService.findSubscriptionById(id);
		SubscriptionResponse subscriptionResponse = converter.toSubscriptionResponse(subscription);
		return ResponseEntity.ok().body(subscriptionResponse);
	}	
	
	@ApiOperation(value = "Create subscription")
	@RequestMapping(path = "/subscription", method = RequestMethod.POST)
	public ResponseEntity<SubscriptionResponse> createSubscrisption() {
		Subscription subscription = subscriptionService.createSubscription();
		return ResponseEntity.created(null).body(converter.toSubscriptionResponse(subscription));
	}
	
	  @ApiOperation(value = "Update subscription")
	  @RequestMapping(path = "/subscription/{id}", method = RequestMethod.PATCH)
	  public ResponseEntity<Void> updateSubscription(@PathVariable String id) {
		  subscriptionService.updateSubscription(id);
	      return ResponseEntity.noContent().build();
	  }

}
