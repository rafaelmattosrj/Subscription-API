package br.com.rafaelmattos.desafioglobo.service;

import java.text.ParseException;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.rafaelmattos.desafioglobo.domain.Status;
import br.com.rafaelmattos.desafioglobo.repository.StatusRepository;

@Service
public class DBService {

	@Autowired
	private StatusRepository statusRepository;
	
//	@Autowired
//	private SubscriptionRepository subscriptionRepository;
//	
//	@Autowired
//	private EventHistoryRepository eventHistoryRepository;

	public void instantiateTestDatabase () throws ParseException {
		
		Status status1 = new Status(1, "SUBSCRIPTION_PURCHASED");
		Status status2 = new Status(2, "SUBSCRIPTION_CANCELED");
		Status status3 = new Status(3, "SUBSCRIPTION_RESTARTED");
		
//		SimpleDateFormat sdf  = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
//		
//		Subscription subscription1 = new Subscription(null, status1, sdf.parse("01/10/2021 12:01:00"), sdf.parse("01/10/2021 12:01:00"));
//		Subscription subscription2 = new Subscription(null, status1, sdf.parse("01/10/2021 12:02:00"), sdf.parse("01/10/2021 12:02:00"));
//		Subscription subscription3 = new Subscription(null, status2, sdf.parse("01/10/2021 12:03:00"), sdf.parse("02/10/2021 12:23:00"));
//		Subscription subscription4 = new Subscription(null, status1, sdf.parse("01/10/2021 12:04:00"), sdf.parse("01/10/2021 12:04:00"));
//		Subscription subscription5 = new Subscription(null, status1, sdf.parse("01/10/2021 12:05:00"), sdf.parse("01/10/2021 12:05:00"));
//		Subscription subscription6 = new Subscription(null, status3, sdf.parse("01/10/2021 12:06:00"), sdf.parse("03/10/2021 12:36:00"));
//		Subscription subscription7 = new Subscription(null, status1, sdf.parse("01/10/2021 12:07:00"), sdf.parse("01/10/2021 12:07:00"));
//		Subscription subscription8 = new Subscription(null, status2, sdf.parse("01/10/2021 12:08:00"), sdf.parse("02/10/2021 12:28:00"));
//		Subscription subscription9 = new Subscription(null, status1, sdf.parse("01/10/2021 12:09:00"), sdf.parse("01/10/2021 12:09:00"));
//		Subscription subscription10 = new Subscription(null, status3, sdf.parse("01/10/2021 12:00:00"), sdf.parse("03/10/2021 12:30:00"));
//		
//		EventHistory eventHistory1 = new EventHistory(null, SubscriptionType.SUBSCRIPTION_PURCHASED, subscription1, sdf.parse("01/10/2021 12:01:00"));
//		EventHistory eventHistory2 = new EventHistory(null, SubscriptionType.SUBSCRIPTION_PURCHASED, subscription2, sdf.parse("01/10/2021 12:02:00"));
//		EventHistory eventHistory3 = new EventHistory(null, SubscriptionType.SUBSCRIPTION_PURCHASED, subscription3, sdf.parse("01/10/2021 12:03:00"));
//		EventHistory eventHistory4 = new EventHistory(null, SubscriptionType.SUBSCRIPTION_PURCHASED, subscription4, sdf.parse("01/10/2021 12:04:00"));
//		EventHistory eventHistory5 = new EventHistory(null, SubscriptionType.SUBSCRIPTION_PURCHASED, subscription5, sdf.parse("01/10/2021 12:05:00"));
//		EventHistory eventHistory6 = new EventHistory(null, SubscriptionType.SUBSCRIPTION_PURCHASED, subscription6, sdf.parse("01/10/2021 12:06:00"));
//		EventHistory eventHistory7 = new EventHistory(null, SubscriptionType.SUBSCRIPTION_PURCHASED, subscription7, sdf.parse("01/10/2021 12:07:00"));
//		EventHistory eventHistory8 = new EventHistory(null, SubscriptionType.SUBSCRIPTION_PURCHASED, subscription8, sdf.parse("01/10/2021 12:08:00"));
//		EventHistory eventHistory9 = new EventHistory(null, SubscriptionType.SUBSCRIPTION_PURCHASED, subscription9, sdf.parse("01/10/2021 12:09:00"));
//		EventHistory eventHistory10 = new EventHistory(null, SubscriptionType.SUBSCRIPTION_PURCHASED, subscription10, sdf.parse("01/10/2021 12:00:00"));
//
//		EventHistory eventHistory11 = new EventHistory(null, SubscriptionType.SUBSCRIPTION_CANCELED, subscription3, sdf.parse("02/10/2021 12:23:00"));
//		EventHistory eventHistory12 = new EventHistory(null, SubscriptionType.SUBSCRIPTION_CANCELED, subscription6, sdf.parse("02/10/2021 12:26:00"));
//		EventHistory eventHistory13 = new EventHistory(null, SubscriptionType.SUBSCRIPTION_CANCELED, subscription9, sdf.parse("02/10/2021 12:28:00"));
//		EventHistory eventHistory14 = new EventHistory(null, SubscriptionType.SUBSCRIPTION_CANCELED, subscription10, sdf.parse("02/10/2021 12:20:00"));
//
//		EventHistory eventHistory15 = new EventHistory(null, SubscriptionType.SUBSCRIPTION_RESTARTED, subscription6, sdf.parse("03/10/2021 12:36:00"));
//		EventHistory eventHistory16 = new EventHistory(null, SubscriptionType.SUBSCRIPTION_RESTARTED, subscription10, sdf.parse("03/10/2021 12:30:00"));
//		
		statusRepository.saveAll(Arrays.asList(status1, status2, status3));
//		subscriptionRepository.saveAll(Arrays.asList(subscription1, subscription2, subscription3, subscription4, subscription5, subscription6, 
//				subscription7, subscription8, subscription9, subscription10));
//		eventHistoryRepository.saveAll(Arrays.asList(eventHistory1, eventHistory2, eventHistory3, eventHistory4, eventHistory5, eventHistory6, 
//				eventHistory7, eventHistory8, eventHistory9, eventHistory10, eventHistory11, eventHistory12, eventHistory13, eventHistory14, 
//				eventHistory15, eventHistory16));
		
	}
	
}


