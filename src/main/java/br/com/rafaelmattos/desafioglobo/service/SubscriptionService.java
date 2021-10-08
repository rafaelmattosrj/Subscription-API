package br.com.rafaelmattos.desafioglobo.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.rafaelmattos.desafioglobo.domain.EventHistory;
import br.com.rafaelmattos.desafioglobo.domain.Status;
import br.com.rafaelmattos.desafioglobo.domain.Subscription;
import br.com.rafaelmattos.desafioglobo.domain.enums.SubscriptionType;
import br.com.rafaelmattos.desafioglobo.exception.ObjectNotFoundException;
import br.com.rafaelmattos.desafioglobo.repository.EventHistoryRepository;
import br.com.rafaelmattos.desafioglobo.repository.SubscriptionRepository;

@Service
public class SubscriptionService {

	@Autowired
	SubscriptionRepository subscriptionRepository;

	@Autowired
	EventHistoryRepository eventHistoryRepository;

	public Subscription findSubscriptionById(Integer id) {
		Optional<Subscription> subscription = subscriptionRepository.findById(id);
		System.out.print(subscription);
		return subscription.orElseThrow(() -> new ObjectNotFoundException(
				"Object not found! Id: " + id + ", Type: " + Subscription.class.getName()));
	}

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

	public Subscription updateSubscription(Integer id) {
		Subscription updateSubscription = subscriptionRepository.findById(id).get();
		System.out.print(updateSubscription);
		LocalDateTime date = LocalDateTime.now();
		updateSubscription.setUpdatedAt(date);
		if (updateSubscription.getStatusId().getName() == "SUBSCRIPTION_PURCHASED") {
			Status status = new Status();
			status.setId(2);
			status.setName("SUBSCRIPTION_CANCELED");
			updateSubscription.setStatusId(status);
		}
		if (updateSubscription.getStatusId().getName() == "SUBSCRIPTION_CANCELED") {
			Status status = new Status();
			status.setId(3);
			status.setName("SUBSCRIPTION_RESTARTED");
			updateSubscription.setStatusId(status);
		}
		if (updateSubscription.getStatusId().getName() == "SUBSCRIPTION_RESTARTED") {
			Status status = new Status();
			status.setId(2);
			status.setName("SUBSCRIPTION_CANCELED");
			updateSubscription.setStatusId(status);
		}
		return subscriptionRepository.save(updateSubscription);
	}

}
