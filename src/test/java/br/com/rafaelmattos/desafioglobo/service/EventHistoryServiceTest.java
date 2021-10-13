package br.com.rafaelmattos.desafioglobo.service;

import static io.restassured.module.mockmvc.RestAssuredMockMvc.standaloneSetup;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import br.com.rafaelmattos.desafioglobo.DesafioGloboApplication;
import br.com.rafaelmattos.desafioglobo.domain.EventHistory;
import br.com.rafaelmattos.desafioglobo.domain.Status;
import br.com.rafaelmattos.desafioglobo.domain.Subscription;
import br.com.rafaelmattos.desafioglobo.domain.enums.SubscriptionType;
import br.com.rafaelmattos.desafioglobo.repository.EventHistoryRepository;

@SpringBootTest(classes = DesafioGloboApplication.class)
class EventHistoryServiceTest {

	@Autowired
	EventHistoryService eventHistoryService;

	@MockBean
	EventHistoryRepository eventHistoryRepository;

	@BeforeEach
	public void setup() {
		standaloneSetup(this.eventHistoryRepository);
	}
	
	@Test
	public void returnSucess_testFindAllEventSubscription() {
		//ERRO
		LocalDateTime date = LocalDateTime.now();
		Status status = new Status(SubscriptionType.SUBSCRIPTION_PURCHASED);

		Subscription subscription = new Subscription(
				"402880937c74dc45017c7506ad910004",
				status,
				date,
				date
		);

		EventHistory eventHistory = new EventHistory(
				1,
				SubscriptionType.SUBSCRIPTION_PURCHASED.getType(),
				subscription,
				date
		);
				
		List<EventHistory> eventHistories = Arrays.asList(eventHistory);
		when(eventHistoryRepository.findAll()).thenReturn(eventHistories);
		List<EventHistory> eventHistoryReturn = eventHistoryService
				.findAllBySubscriptionId("402880937c74dc45017c7506ad910004");
		assertEquals(eventHistories, eventHistoryReturn);	
	}
	
	@Test
	public void returnSucess_testFindbyId() {
		//FAIL
		LocalDateTime date = LocalDateTime.now();
		Status status = new Status(SubscriptionType.SUBSCRIPTION_PURCHASED);

		Subscription subscription = new Subscription(
				"402880937c74dc45017c7506ad910004",
				status,
				date,
				date
		);

		EventHistory eventHistory = new EventHistory(
				1,
				SubscriptionType.SUBSCRIPTION_PURCHASED.getType(),
				subscription,
				date
		);

		Optional<EventHistory> optionalEventHistory = Optional.of(eventHistory);
		when(eventHistoryRepository.findById(1)).thenReturn(optionalEventHistory);
		EventHistory eventHistoryReturn = eventHistoryService.findEventHistoryById(1);
		assertEquals(optionalEventHistory, eventHistoryReturn);
	}

}
