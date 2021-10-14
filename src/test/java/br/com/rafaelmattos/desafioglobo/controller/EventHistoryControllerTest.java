package br.com.rafaelmattos.desafioglobo.controller;

import static io.restassured.module.mockmvc.RestAssuredMockMvc.given;
import static io.restassured.module.mockmvc.RestAssuredMockMvc.standaloneSetup;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.ActiveProfiles;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.rafaelmattos.desafioglobo.DesafioGloboApplication;
import br.com.rafaelmattos.desafioglobo.domain.EventHistory;
import br.com.rafaelmattos.desafioglobo.domain.Status;
import br.com.rafaelmattos.desafioglobo.domain.Subscription;
import br.com.rafaelmattos.desafioglobo.domain.enums.SubscriptionType;
import br.com.rafaelmattos.desafioglobo.service.EventHistoryService;
import io.restassured.http.ContentType;


@SpringBootTest(classes = DesafioGloboApplication.class)
@ActiveProfiles(value = {"test"})
class EventHistoryControllerTest {
	
	@MockBean
	private EventHistoryService eventHistoryService;

	@Autowired
	EventHistoryController eventHistoryController;

	@BeforeEach
	public void setup() {
		standaloneSetup(this.eventHistoryController);
	}
			
	@Test
	public void returnSuccess_whenFindAllHistories_andExist() throws JsonProcessingException {
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

		List<EventHistory> eventHistories = List.of(eventHistory);

		ObjectMapper mapper = new ObjectMapper();
		mapper.findAndRegisterModules();
		String body = mapper.writeValueAsString(eventHistories);

		when(this.eventHistoryService.findAllBySubscriptionId("402880937c74dc45017c7506ad910004"))
		.thenReturn(eventHistories);

		given().accept(ContentType.JSON).body(body)
		.when().get("/desafioglobo/eventhistory/subscription/402880937c74dc45017c7506ad910004").then().statusCode(HttpStatus.OK.value());
	}

	@Test
	public void returnSuccess_whenFindById_AndEventHistoryExists() throws JsonProcessingException {
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

		when(this.eventHistoryService.findEventHistoryById(1)).thenReturn(eventHistory);

		ObjectMapper mapper = new ObjectMapper();
		mapper.findAndRegisterModules();
		String body = mapper.writeValueAsString(eventHistory);

		given().accept(io.restassured.http.ContentType.JSON).body(body)
		.when().get("/desafioglobo/eventhistory/1").then().statusCode(HttpStatus.OK.value());
	
	}
}
