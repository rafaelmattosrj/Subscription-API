package br.com.rafaelmattos.desafioglobo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.rafaelmattos.desafioglobo.domain.EventHistory;
import br.com.rafaelmattos.desafioglobo.domain.Subscription;
import br.com.rafaelmattos.desafioglobo.repository.EventHistoryRepository;
import br.com.rafaelmattos.desafioglobo.repository.SubscriptionRepository;
import br.com.rafaelmattos.desafioglobo.service.exception.ObjectNotFoundException;

@Service
public class EventHistoryService {

	@Autowired
	private EventHistoryRepository eventHistoryRepository;
	
	@Autowired
	private SubscriptionRepository subscriptionRepository;

	public List<EventHistory> findAllBySubscriptionId(Integer subscriptionId) {
		Subscription subscription = subscriptionRepository.findById(subscriptionId)
				.orElseThrow(() -> new ObjectNotFoundException(
						"Object not found! Id: " + subscriptionId + ", Type: " + Subscription.class.getName()));
		
		List<EventHistory> events = eventHistoryRepository.findAllBySubscriptionId(subscription);
		return events;
	}
	
	public EventHistory find(Integer id) {
		Optional<EventHistory> eventHistory = eventHistoryRepository.findById(id);
		return eventHistory.orElseThrow(() -> new ObjectNotFoundException(
				"Object not found! Id: " + id + ", Type: " + EventHistory.class.getName()));
	}
	
	public EventHistory insert(EventHistory eventHistory) {
		eventHistory.setId(null);
		return eventHistoryRepository.save(eventHistory);
	}
	
}
