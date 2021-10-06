package br.com.rafaelmattos.desafioglobo.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.rafaelmattos.desafioglobo.domain.EventHistory;
import br.com.rafaelmattos.desafioglobo.domain.Status;
import br.com.rafaelmattos.desafioglobo.domain.Subscription;
import br.com.rafaelmattos.desafioglobo.domain.enums.SubscriptionType;
import br.com.rafaelmattos.desafioglobo.repository.EventHistoryRepository;
import br.com.rafaelmattos.desafioglobo.repository.SubscriptionRepository;

@Service
public class SubscriptionService {

	@Autowired
	SubscriptionRepository subscriptionRepository;
	
	@Autowired
	EventHistoryRepository eventHistoryRepository;
	
	public Subscription createSubscription() {
		LocalDateTime date = LocalDateTime.now();
		Subscription subscription = new Subscription();
		Status status = new Status();
		SubscriptionType subscriptionPurchased = SubscriptionType.SUBSCRIPTION_PURCHASED;
		status.setName(subscriptionPurchased.getDescription());
		status.setId(subscriptionPurchased.getCod());
		subscription.setStatusId(status);
		subscription.setCreatedAt(date);
		subscription.setUpdatedAt(date);
		subscription = subscriptionRepository.save(subscription);
		
		EventHistory eventHistory = new EventHistory();
		eventHistory.setType(subscriptionPurchased.getDescription());
		eventHistory.setSubscriptionId(subscription);
		eventHistory.setCreatedAt(date);
		eventHistoryRepository.save(eventHistory);
				
		return subscription;
		
	}	
	
}
