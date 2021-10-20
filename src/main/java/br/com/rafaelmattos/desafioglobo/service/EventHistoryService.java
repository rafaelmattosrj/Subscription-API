package br.com.rafaelmattos.desafioglobo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.rafaelmattos.desafioglobo.domain.EventHistory;
import br.com.rafaelmattos.desafioglobo.domain.Subscription;
import br.com.rafaelmattos.desafioglobo.exception.ObjectNotFoundException;
import br.com.rafaelmattos.desafioglobo.repository.EventHistoryRepository;
import br.com.rafaelmattos.desafioglobo.repository.SubscriptionRepository;

@Service
public class EventHistoryService {

	@Autowired
	private EventHistoryRepository eventHistoryRepository;
	@Autowired
	private SubscriptionRepository subscriptionRepository;

	public EventHistoryService() {
	}

	public List<EventHistory> findAllBySubscriptionId(String subscriptionId) {
		Subscription subscription = subscriptionRepository.findById(subscriptionId).orElseThrow(() -> new ObjectNotFoundException(
				"Object not found! Id: " + subscriptionId + ", Type: " + EventHistory.class.getName()));
				
		List<EventHistory> eventHistory = eventHistoryRepository.findAllBySubscription(subscription);
		return eventHistory;
	}
	
	public EventHistory findEventHistoryById(Integer id) {
		return eventHistoryRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException(
				"Object not found! Id: " + id + ", Type: " + EventHistory.class.getName()));
	}
}
