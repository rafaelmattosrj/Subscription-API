package br.com.rafaelmattos.desafioglobo.controller;

import static io.restassured.module.mockmvc.RestAssuredMockMvc.given;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.ActiveProfiles;

import com.fasterxml.jackson.core.JsonProcessingException;

import br.com.rafaelmattos.desafioglobo.DesafioGloboApplication;
import br.com.rafaelmattos.desafioglobo.domain.EventHistory;
import br.com.rafaelmattos.desafioglobo.service.EventHistoryService;

@SpringBootTest(classes = DesafioGloboApplication.class)
@ActiveProfiles(value = {"test"})
class EventHistoryControllerTest {
	
	@MockBean
	private EventHistoryService eventHistoryService;
			
	@Test
	public void returnSuccess_whenFindAllHistories_andExist() throws JsonProcessingException {

		Optional<EventHistory> eventHistory = Optional.of(new EventHistory());
		eventHistory.get().setId(1);
		eventHistory.get().setType("SUBSCRIPTION_PURCHASED");
		eventHistory.get().setSubscriptionId(null);
		eventHistory.get().setCreatedAt(LocalDateTime.now());

		List<EventHistory> eventHistories = Arrays.asList(eventHistory.get());

		when(this.eventHistoryService.findAllBySubscriptionId(1)).thenReturn(eventHistories);

		given().accept(io.restassured.http.ContentType.JSON)
		.when().get("/desafioglobo/eventhistory/subscription/1").then().statusCode(HttpStatus.OK.value());
	}

	@Test
	public void returnSuccess_whenFindAllHistories_ButNotExists() throws JsonProcessingException {

		Optional<EventHistory> eventHistory = Optional.of(new EventHistory());
		eventHistory.get().setId(1);
		eventHistory.get().setType("SUBSCRIPTION_PURCHASED");
		eventHistory.get().setSubscriptionId(null);
		eventHistory.get().setCreatedAt(LocalDateTime.now());

		List<EventHistory> eventHistories = Arrays.asList();

		when(this.eventHistoryService.findAllBySubscriptionId(1)).thenReturn(eventHistories);

		given().accept(io.restassured.http.ContentType.JSON)
		.when().get("/desafioglobo/eventhistory/subscription/1").then().statusCode(HttpStatus.NOT_FOUND.value());
	}
	
	@Test
	public void returnSuccess_whenFindById_AndEventHistoryExists() throws JsonProcessingException {

		Optional<EventHistory> eventHistory = Optional.of(new EventHistory());
		eventHistory.get().setId(1);
		eventHistory.get().setType("SUBSCRIPTION_PURCHASED");
		eventHistory.get().setSubscriptionId(null);
		eventHistory.get().setCreatedAt(LocalDateTime.now());

		when(this.eventHistoryService.findEventHistoryById(1)).thenReturn(null);

		given().accept(io.restassured.http.ContentType.JSON)
		.when().get("/desafioglobo/eventhistory/1").then().statusCode(HttpStatus.OK.value());
	}

	@Test
	public void returnNotFound__whenFindById_AndEventHistoryNotExist() throws JsonProcessingException {

		when(this.eventHistoryService.findEventHistoryById(1)).thenReturn(null);

		given().accept(io.restassured.http.ContentType.JSON)
		.when().get("/desafioglobo/eventhistory/1").then().statusCode(HttpStatus.NOT_FOUND.value());
	}
}
