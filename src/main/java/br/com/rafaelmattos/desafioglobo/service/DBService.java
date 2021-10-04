package br.com.rafaelmattos.desafioglobo.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.rafaelmattos.desafioglobo.domain.EventHistory;
import br.com.rafaelmattos.desafioglobo.domain.Status;
import br.com.rafaelmattos.desafioglobo.domain.Subscription;
import br.com.rafaelmattos.desafioglobo.domain.enums.SubscriptionType;
import br.com.rafaelmattos.desafioglobo.repository.EventHistoryRepository;
import br.com.rafaelmattos.desafioglobo.repository.StatusRepository;
import br.com.rafaelmattos.desafioglobo.repository.SubscriptionRepository;

@Service
public class DBService {

	@Autowired
	private StatusRepository statusRepository;
	
	@Autowired
	private SubscriptionRepository subscriptionRepository;
	
	@Autowired
	private EventHistoryRepository eventHistoryRepository;

	public void instantiateTestDatabase () throws ParseException {
		
		Status status1 = new Status(1, "SUBSCRIPTION_PURCHASED");
		Status status2 = new Status(2, "SUBSCRIPTION_CANCELED");
		Status status3 = new Status(3, "SUBSCRIPTION_RESTARTED");
		
		SimpleDateFormat sdf  = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		
		Subscription subscription1 = new Subscription(null, status1, sdf.parse("04/10/2021 12:00"), sdf.parse("04/10/2021 12:00"));
		Subscription subscription2 = new Subscription(null, status1, sdf.parse("04/10/2021 12:00"), sdf.parse("04/10/2021 12:00"));
		Subscription subscription3 = new Subscription(null, status2, sdf.parse("04/10/2021 12:00"), sdf.parse("04/10/2021 12:00"));
		
		EventHistory eventHistory1 = new EventHistory(null, SubscriptionType.SUBSCRIPTION_PURCHASED, subscription1, sdf.parse("04/10/2021 12:00"));
		EventHistory eventHistory2 = new EventHistory(null, SubscriptionType.SUBSCRIPTION_PURCHASED, subscription2, sdf.parse("04/10/2021 12:00"));
		EventHistory eventHistory3 = new EventHistory(null, SubscriptionType.SUBSCRIPTION_PURCHASED, subscription3, sdf.parse("04/10/2021 12:00"));
		
		statusRepository.saveAll(Arrays.asList(status1, status2, status3));
		subscriptionRepository.saveAll(Arrays.asList(subscription1, subscription2, subscription3));
		eventHistoryRepository.saveAll(Arrays.asList(eventHistory1, eventHistory2, eventHistory3));
		
	}
}

