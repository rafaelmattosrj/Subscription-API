package br.com.rafaelmattos.desafioglobo.service;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Optional;

import javax.transaction.Transactional;

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

	public Subscription findSubscriptionById(String id) {
		Optional<Subscription> subscription = subscriptionRepository.findById(id);
		return subscription.orElseThrow(() -> new ObjectNotFoundException(
				"Object not found! Id: " + id + ", Type: " + Subscription.class.getName()));
	}

	@Transactional
	public Subscription createSubscription() {

		LocalDateTime date = LocalDateTime.now();
		SubscriptionType subscriptionPurchased = SubscriptionType.SUBSCRIPTION_PURCHASED;
		Subscription subscription =
				new Subscription(new Status(subscriptionPurchased),
						date,
						date);

		subscription = subscriptionRepository.save(subscription);
		eventHistoryRepository.save(new EventHistory(subscriptionPurchased.getType(),
				subscription,
				date));

		return subscription;
	}

	public Subscription updateSubscription(String id) {
		Subscription updateSubscription = subscriptionRepository.findById(id)
				.orElseThrow(() -> new ObjectNotFoundException(
						"Object not found! Id: " + id + ", Type: " + Subscription.class.getName()));

		updateSubscription = updateStatus(updateSubscription);
		updateSubscription.setUpdatedAt(LocalDateTime.now());
		updateSubscription = subscriptionRepository.save(updateSubscription);
		EventHistory eventHistory = new EventHistory(updateSubscription.getStatus().getType()
				,updateSubscription,updateSubscription.getUpdatedAt());
		eventHistoryRepository.save(eventHistory);
		return updateSubscription;
	}

	public Subscription updateStatus(Subscription updateSubscription) {

		if (Objects.equals(updateSubscription.getStatus().getType(), SubscriptionType.SUBSCRIPTION_PURCHASED.getType())) {
			Status status = new Status(SubscriptionType.SUBSCRIPTION_CANCELED);
			updateSubscription.setStatus(status);
			return updateSubscription;
		}
		if (Objects.equals(updateSubscription.getStatus().getType(), SubscriptionType.SUBSCRIPTION_CANCELED.getType())) {
			Status status = new Status(SubscriptionType.SUBSCRIPTION_RESTARTED);
			updateSubscription.setStatus(status);
			return updateSubscription;
		}
		if (Objects.equals(updateSubscription.getStatus().getType(), SubscriptionType.SUBSCRIPTION_RESTARTED.getType())) {
			Status status = new Status(SubscriptionType.SUBSCRIPTION_CANCELED);
			updateSubscription.setStatus(status);
			return updateSubscription;
		}
		return null;
	}
}