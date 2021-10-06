package br.com.rafaelmattos.desafioglobo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.rafaelmattos.desafioglobo.domain.Subscription;
import br.com.rafaelmattos.desafioglobo.service.SubscriptionService;

@RestController
@RequestMapping(value = "/subscription")
public class SubscriptionController {

	@Autowired
	SubscriptionService subscriptionService;

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Subscription> createSubscrisption() {
		Subscription subscription = subscriptionService.createSubscription();
		return ResponseEntity.created(null).body(subscription);
	}

}
