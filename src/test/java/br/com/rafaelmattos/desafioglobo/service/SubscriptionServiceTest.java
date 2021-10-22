package br.com.rafaelmattos.desafioglobo.service;

import static io.restassured.module.mockmvc.RestAssuredMockMvc.standaloneSetup;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import br.com.rafaelmattos.desafioglobo.DesafioGloboApplication;
import br.com.rafaelmattos.desafioglobo.domain.Status;
import br.com.rafaelmattos.desafioglobo.domain.Subscription;
import br.com.rafaelmattos.desafioglobo.domain.enums.SubscriptionType;
import br.com.rafaelmattos.desafioglobo.repository.EventHistoryRepository;
import br.com.rafaelmattos.desafioglobo.repository.SubscriptionRepository;

@SpringBootTest(classes = DesafioGloboApplication.class)
class SubscriptionServiceTest {

	@Autowired
	SubscriptionService subscriptionService;

	@MockBean
	SubscriptionRepository subscriptionRepository;
	
	@MockBean
	EventHistoryRepository eventHistoryRepository;

	@BeforeEach
	public void setup() {
		standaloneSetup(this.subscriptionService);
	}

	@Test
	public void returnSubscription_whenFindSubscriptionById() {
		LocalDateTime date = LocalDateTime.now();
		Status status = new Status(SubscriptionType.SUBSCRIPTION_PURCHASED);

		Subscription subscription = new Subscription(
				"402880937c74dc45017c7506ad910004",
				status,
				date,
				date
		);

		Optional<Subscription> optionalSubscription = Optional.of(subscription);
		when(subscriptionRepository.findById("402880937c74dc45017c7506ad910004"))
				.thenReturn(optionalSubscription);
		Subscription subscriptionReturn = subscriptionService
				.findSubscriptionById("402880937c74dc45017c7506ad910004");
		assertEquals(subscription, subscriptionReturn);
	}
	
	@Test
	public void returnSubscription_whenCreateSubscription() {
		LocalDateTime date = LocalDateTime.now();
		Status status = new Status(SubscriptionType.SUBSCRIPTION_PURCHASED);

		Subscription subscription = new Subscription(
				status,
				date,
				date
		);

		when(subscriptionRepository.save(subscription)).thenReturn(subscription);
		Subscription subscriptionCreated = subscriptionService.createSubscription(); 
		assertEquals(subscription, subscriptionCreated);
	}
	
	@Test
	public void returnrCanceled_WhenUpdateSubscriptionPurchased() {
		LocalDateTime date = LocalDateTime.now();
		Status status = new Status(SubscriptionType.SUBSCRIPTION_PURCHASED);
		String expected = new Status(SubscriptionType.SUBSCRIPTION_CANCELED).getType();

		Subscription subscription = new Subscription(
				"402880937c74dc45017c7506ad910004",
				status,
				date,
				date
		);
		
		Subscription updateStatus = subscriptionService.updateStatus(subscription);
		String actual = updateStatus.getStatus().getType();
		assertEquals(actual, expected);
	}
	
	@Test
	public void returnRestart_WhenUpdateSubscriptionCanceled() {
		LocalDateTime date = LocalDateTime.now();
		Status status = new Status(SubscriptionType.SUBSCRIPTION_CANCELED);
		String expected = new Status(SubscriptionType.SUBSCRIPTION_RESTARTED).getType();

		Subscription subscription = new Subscription(
				"402880937c74dc45017c7506ad910004",
				status,
				date,
				date
		);
		
		Subscription updateStatus = subscriptionService.updateStatus(subscription);
		String actual = updateStatus.getStatus().getType();
		assertEquals(actual, expected);
	}
	
	@Test
	public void returnCanceled_WhenUpdateSubscriptionRestart() {
		LocalDateTime date = LocalDateTime.now();
		Status status = new Status(SubscriptionType.SUBSCRIPTION_RESTARTED);
		String expected = new Status(SubscriptionType.SUBSCRIPTION_CANCELED).getType();

		Subscription subscription = new Subscription(
				"402880937c74dc45017c7506ad910004",
				status,
				date,
				date
		);
		
		Subscription updateStatus = subscriptionService.updateStatus(subscription);
		String actual = updateStatus.getStatus().getType();
		assertEquals(actual, expected);
	}	
}
