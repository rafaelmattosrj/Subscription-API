package br.com.rafaelmattos.desafioglobo.controller;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.rafaelmattos.desafioglobo.domain.Subscription;
import br.com.rafaelmattos.desafioglobo.dto.SubscriptionRequest;
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
	private Converter converter;

	@ApiOperation(value = "Search subscription by id.")
	@RequestMapping(value = "/subscription/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		Subscription subscription = subscriptionService.findSubscriptionById(id);
		SubscriptionResponse subscriptionResponse = converter.toSubscriptionResponse(subscription);
		return ResponseEntity.ok().body(subscriptionResponse);
	}	
	
	@ApiOperation(value = "Create subscription")
	@RequestMapping(path = "/subscription", method = RequestMethod.POST)
	public ResponseEntity<SubscriptionResponse> createSubscrisption() {
		Subscription subscription = subscriptionService.createSubscription();
		SubscriptionResponse subscriptionResponse = converter.toSubscriptionResponse(subscription);
	      URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
	              .path("/{id}").buildAndExpand(subscriptionResponse.getId()).toUri();
		return ResponseEntity.created(uri).body(subscriptionResponse);
	}
	
	  @ApiOperation(value = "Update subscription")
	  @RequestMapping(path = "/subscription/{id}", method = RequestMethod.PATCH)
	  public ResponseEntity<Void> updateSubscription(
			  @Valid @RequestBody SubscriptionRequest subscriptionRequest, @PathVariable Integer id) {
		  subscriptionService.updateSubscription(id);
	      return ResponseEntity.noContent().build();
	  }

}
