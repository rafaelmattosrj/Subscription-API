package br.com.rafaelmattos.desafioglobo.util;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import br.com.rafaelmattos.desafioglobo.domain.EventHistory;
import br.com.rafaelmattos.desafioglobo.domain.Subscription;
import br.com.rafaelmattos.desafioglobo.dto.EventHistoryResponse;
import br.com.rafaelmattos.desafioglobo.dto.SubscriptionRequest;
import br.com.rafaelmattos.desafioglobo.dto.SubscriptionResponse;

@Component
public class Converter {

	public List<EventHistoryResponse> toEventHistoryResponse(List<EventHistory> listEventHistory) {

		if (!(listEventHistory == null)) {

			List<EventHistoryResponse> eventHistoryResponse = listEventHistory.stream()
					.map(obj -> new EventHistoryResponse(obj)).collect(Collectors.toList());

			return eventHistoryResponse;
		}
		return null;
	}

	public EventHistoryResponse toEventHistoryResponse(EventHistory eventHistory) {

		if (!(eventHistory == null)) {
			EventHistoryResponse eventHistoryResponse = new EventHistoryResponse();

			eventHistoryResponse.setId(eventHistory.getId());
			eventHistoryResponse.setType(eventHistory.getType().getDescription());
			eventHistoryResponse.setSubscriptionId(eventHistory.getSubscriptionId());
			eventHistoryResponse.setCreatedAt(eventHistory.getCreatedAt());

			return eventHistoryResponse;
		}
		return null;
	}

	public SubscriptionResponse toSubscriptionResponse(Subscription subscription) {

		if (!(subscription == null)) {
			SubscriptionResponse subscriptionResponse = new SubscriptionResponse();

			subscriptionResponse.setId(subscription.getId());
			subscriptionResponse.setStatusId(subscription.getStatusId());
			subscriptionResponse.setCreatedAt(subscription.getCreatedAt());
			subscriptionResponse.setUpdatedAt(subscription.getUpdatedAt());

			return subscriptionResponse;
		}
		return null;
	}

	public Subscription requestToSubscription(SubscriptionRequest subscriptionRequest) {
		if (!(subscriptionRequest == null)) {
			Subscription subscription = new Subscription();

			subscription.setStatusId(subscriptionRequest.getStatusId());
			subscription.setUpdatedAt(subscriptionRequest.getUpdatedAt());

			return subscription;
		}
		return null;
	}
}