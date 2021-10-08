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
import br.com.rafaelmattos.desafioglobo.repository.EventHistoryRepository;

@SpringBootTest(classes = DesafioGloboApplication.class)
class EventHistoryServiceTest {

	@Autowired
	EventHistoryService eventHistoryService;

	@MockBean
	EventHistoryRepository eventHistoryRepository;

	@BeforeEach
	public void setup() {
		standaloneSetup(this.eventHistoryService);
	}
	
	@Test
	public void returnSucess_testFindAllEventSubscription() {

		EventHistory eventHistory = new EventHistory();
		eventHistory.setId(1);
		eventHistory.setType("SUBSCRIPTION_PURCHASED");
		eventHistory.setSubscriptionId(null);
		eventHistory.setCreatedAt(LocalDateTime.now());
		
		Optional<List<EventHistory>> optionalEventHistory = Optional.of(Arrays.asList(eventHistory));
		when(eventHistoryRepository.findById(1)).thenReturn(null);
		List<EventHistory> eventHistoryReturn = eventHistoryService.findAllBySubscriptionId(1);
		assertEquals(optionalEventHistory, eventHistoryReturn);	
	}
	
	@Test
	public void returnSucess_testFindbyId() {

		EventHistory eventHistory = new EventHistory();
		eventHistory.setId(1);
		eventHistory.setType("SUBSCRIPTION_PURCHASED");
		eventHistory.setSubscriptionId(null);
		eventHistory.setCreatedAt(LocalDateTime.now());

		Optional<EventHistory> optionalEventHistory = Optional.of(eventHistory);
		when(eventHistoryRepository.findById(1)).thenReturn(optionalEventHistory);
		EventHistory eventHistoryReturn = eventHistoryService.findEventHistoryById(1);
		assertEquals(optionalEventHistory, eventHistoryReturn);
	}

}
