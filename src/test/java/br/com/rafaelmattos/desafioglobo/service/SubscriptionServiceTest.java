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

import com.fasterxml.jackson.core.JsonProcessingException;

import br.com.rafaelmattos.desafioglobo.DesafioGloboApplication;
import br.com.rafaelmattos.desafioglobo.domain.EventHistory;
import br.com.rafaelmattos.desafioglobo.domain.Status;
import br.com.rafaelmattos.desafioglobo.domain.Subscription;
import br.com.rafaelmattos.desafioglobo.repository.SubscriptionRepository;

@SpringBootTest(classes = DesafioGloboApplication.class)
class SubscriptionServiceTest {

	@Autowired
	SubscriptionService subscriptionService;

	@MockBean
	SubscriptionRepository subscriptionRepository;

	@BeforeEach
	public void setup() {
		standaloneSetup(this.subscriptionService);
	}
	
	@Test
	public void returnSucess_testFindbyId() {

		Subscription subscription = new Subscription();
		subscription.setId(1);
		subscription.setStatusId(null);
		subscription.setCreatedAt(LocalDateTime.now());
		subscription.setUpdatedAt(LocalDateTime.now());

		Optional<Subscription> optionalSubscription = Optional.of(subscription);
		when(subscriptionRepository.findById(1)).thenReturn(optionalSubscription);
		Subscription subscriptionReturn = subscriptionService.findSubscriptionById(1);
		assertEquals(optionalSubscription, subscriptionReturn);
	}
	
	@Test
	public void returnSucess_testCreateSubscription() {
		LocalDateTime date = LocalDateTime.now();
		Status status = new Status();
		status.setId(1);
		status.setName("SUBSCRIPTION_PURCHASED");
		
		Optional<EventHistory> eventHistory = Optional.of(new EventHistory());
		eventHistory.get().setType("SUBSCRIPTION_PURCHASED");
		eventHistory.get().setSubscriptionId(null);
		eventHistory.get().setCreatedAt(date);
		
		Optional<Subscription> subscription = Optional.of(new Subscription());
		subscription.get().setId(1);
		subscription.get().setStatusId(null);
		subscription.get().setCreatedAt(date);
		subscription.get().setUpdatedAt(date);

		when(this.subscriptionService.createSubscription()).thenReturn(null);
		when(subscriptionRepository.save(subscription.get())).thenReturn(subscription.get());
		Subscription subscriptionCreated = subscriptionService.createSubscription();
		assertEquals(subscription, subscriptionCreated);
	}
	
	@Test
	public void returnSuccess_UpdateSubscription() throws JsonProcessingException {

		Optional<Subscription> subscription = Optional.of(new Subscription());
		subscription.get().setUpdatedAt(LocalDateTime.now());
		
		when(this.subscriptionService.createSubscription()).thenReturn(null);
		when(subscriptionRepository.save(subscription.get())).thenReturn(subscription.get());
		Subscription subscriptionUpdate = subscriptionService.createSubscription();
		assertEquals(subscription, subscriptionUpdate);
	}
}

