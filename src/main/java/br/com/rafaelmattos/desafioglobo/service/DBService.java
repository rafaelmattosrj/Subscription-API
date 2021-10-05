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
		
		Subscription subscription1 = new Subscription(null, status1, sdf.parse("01/10/2021 12:01"), sdf.parse("01/10/2021 12:01"));
		Subscription subscription2 = new Subscription(null, status1, sdf.parse("01/10/2021 12:02"), sdf.parse("01/10/2021 12:02"));
		Subscription subscription3 = new Subscription(null, status2, sdf.parse("01/10/2021 12:03"), sdf.parse("02/10/2021 12:23"));
		Subscription subscription4 = new Subscription(null, status1, sdf.parse("01/10/2021 12:04"), sdf.parse("01/10/2021 12:04"));
		Subscription subscription5 = new Subscription(null, status1, sdf.parse("01/10/2021 12:05"), sdf.parse("01/10/2021 12:05"));
		Subscription subscription6 = new Subscription(null, status3, sdf.parse("01/10/2021 12:06"), sdf.parse("03/10/2021 12:36"));
		Subscription subscription7 = new Subscription(null, status1, sdf.parse("01/10/2021 12:07"), sdf.parse("01/10/2021 12:07"));
		Subscription subscription8 = new Subscription(null, status2, sdf.parse("01/10/2021 12:08"), sdf.parse("02/10/2021 12:28"));
		Subscription subscription9 = new Subscription(null, status1, sdf.parse("01/10/2021 12:09"), sdf.parse("01/10/2021 12:09"));
		Subscription subscription10 = new Subscription(null, status3, sdf.parse("01/10/2021 12:00"), sdf.parse("03/10/2021 12:30"));
		
		EventHistory eventHistory1 = new EventHistory(null, SubscriptionType.SUBSCRIPTION_PURCHASED, subscription1, sdf.parse("01/10/2021 12:01"));
		EventHistory eventHistory2 = new EventHistory(null, SubscriptionType.SUBSCRIPTION_PURCHASED, subscription2, sdf.parse("01/10/2021 12:02"));
		EventHistory eventHistory3 = new EventHistory(null, SubscriptionType.SUBSCRIPTION_PURCHASED, subscription3, sdf.parse("01/10/2021 12:03"));
		EventHistory eventHistory4 = new EventHistory(null, SubscriptionType.SUBSCRIPTION_PURCHASED, subscription4, sdf.parse("01/10/2021 12:04"));
		EventHistory eventHistory5 = new EventHistory(null, SubscriptionType.SUBSCRIPTION_PURCHASED, subscription5, sdf.parse("01/10/2021 12:05"));
		EventHistory eventHistory6 = new EventHistory(null, SubscriptionType.SUBSCRIPTION_PURCHASED, subscription6, sdf.parse("01/10/2021 12:06"));
		EventHistory eventHistory7 = new EventHistory(null, SubscriptionType.SUBSCRIPTION_PURCHASED, subscription7, sdf.parse("01/10/2021 12:07"));
		EventHistory eventHistory8 = new EventHistory(null, SubscriptionType.SUBSCRIPTION_PURCHASED, subscription8, sdf.parse("01/10/2021 12:08"));
		EventHistory eventHistory9 = new EventHistory(null, SubscriptionType.SUBSCRIPTION_PURCHASED, subscription9, sdf.parse("01/10/2021 12:09"));
		EventHistory eventHistory10 = new EventHistory(null, SubscriptionType.SUBSCRIPTION_PURCHASED, subscription10, sdf.parse("01/10/2021 12:00"));

		EventHistory eventHistory11 = new EventHistory(null, SubscriptionType.SUBSCRIPTION_CANCELED, subscription3, sdf.parse("02/10/2021 12:23"));
		EventHistory eventHistory12 = new EventHistory(null, SubscriptionType.SUBSCRIPTION_CANCELED, subscription6, sdf.parse("02/10/2021 12:26"));
		EventHistory eventHistory13 = new EventHistory(null, SubscriptionType.SUBSCRIPTION_CANCELED, subscription9, sdf.parse("02/10/2021 12:28"));
		EventHistory eventHistory14 = new EventHistory(null, SubscriptionType.SUBSCRIPTION_CANCELED, subscription10, sdf.parse("02/10/2021 12:20"));

		EventHistory eventHistory15 = new EventHistory(null, SubscriptionType.SUBSCRIPTION_RESTARTED, subscription6, sdf.parse("03/10/2021 12:36"));
		EventHistory eventHistory16 = new EventHistory(null, SubscriptionType.SUBSCRIPTION_RESTARTED, subscription10, sdf.parse("03/10/2021 12:30"));
		
		statusRepository.saveAll(Arrays.asList(status1, status2, status3));
		subscriptionRepository.saveAll(Arrays.asList(subscription1, subscription2, subscription3, subscription4, subscription5, subscription6, 
				subscription7, subscription8, subscription9, subscription10));
		eventHistoryRepository.saveAll(Arrays.asList(eventHistory1, eventHistory2, eventHistory3, eventHistory4, eventHistory5, eventHistory6, 
				eventHistory7, eventHistory8, eventHistory9, eventHistory10, eventHistory11, eventHistory12, eventHistory13, eventHistory14, 
				eventHistory15, eventHistory16));
		
	}
	
}


