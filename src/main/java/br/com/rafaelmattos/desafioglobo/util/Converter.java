package br.com.rafaelmattos.desafioglobo.util;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import br.com.rafaelmattos.desafioglobo.domain.EventHistory;
import br.com.rafaelmattos.desafioglobo.domain.Subscription;
import br.com.rafaelmattos.desafioglobo.dto.EventHistoryResponse;
import br.com.rafaelmattos.desafioglobo.dto.SubscriptionResponse;

@Component
public class Converter {

	public List<EventHistoryResponse> toEventHistoriesResponse(List<EventHistory> listEventHistory) {

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
			eventHistoryResponse.setType(eventHistory.getType().getType());
			eventHistoryResponse.setSubscriptionId(eventHistory.getSubscription());
			eventHistoryResponse.setCreatedAt(eventHistory.getCreatedAt());

			return eventHistoryResponse;
		}
		return null;
	}

	public SubscriptionResponse toSubscriptionResponse(Subscription subscription) {
	
		if (Objects.nonNull(subscription)) {
			return new SubscriptionResponse(subscription);
		}
		return null;
	}

	public Subscription responseToSubscription(SubscriptionResponse subscriptionResponse) {
		if (!(subscriptionResponse == null)) {
			Subscription subscription = new Subscription();

			subscription.setStatus(subscriptionResponse.getStatusId());
			subscription.setUpdatedAt(subscriptionResponse.getUpdatedAt());

			return subscription;
		}
		return null;
	}
}