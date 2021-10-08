package br.com.rafaelmattos.desafioglobo.controller;

import static io.restassured.module.mockmvc.RestAssuredMockMvc.given;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.util.Optional;

import org.junit.jupiter.api.Test;
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
import br.com.rafaelmattos.desafioglobo.service.SubscriptionService;
import io.restassured.http.ContentType;

@SpringBootTest(classes = DesafioGloboApplication.class)
@ActiveProfiles(value = {"test"})
class SubscriptionControllerTest {

	@MockBean
	private SubscriptionService subscriptionService;

	@Test
	public void returnSuccess_whenFindById_AndSubscriptionExists() throws JsonProcessingException {

		Optional<Subscription> subscription = Optional.of(new Subscription());
		subscription.get().setId(1);
		subscription.get().setStatusId(null);
		subscription.get().setCreatedAt(LocalDateTime.now());
		subscription.get().setUpdatedAt(LocalDateTime.now());

		when(this.subscriptionService.findSubscriptionById(1)).thenReturn(null);

		given().accept(ContentType.JSON)
		.when().get("/desafioglobo/subscription/1").then().statusCode(HttpStatus.OK.value());
	}

	@Test
	public void returnNotFound__whenFindById_AndSubscriptionNotExist() throws JsonProcessingException {

		when(this.subscriptionService.findSubscriptionById(1)).thenReturn(null);

		given().accept(ContentType.JSON)
		.when().get("/desafioglobo/subscription/1").then().statusCode(HttpStatus.NOT_FOUND.value());
	}
	
	@Test
	public void returnSuccess_whenCreateSubscription() throws JsonProcessingException {
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

		ObjectMapper mapper = new ObjectMapper();
		String body = mapper.writeValueAsString(eventHistory);

		given().accept(ContentType.JSON).contentType(ContentType.JSON).body(body).when()
		.post("/desafioglobo/subscription").then().statusCode(HttpStatus.CREATED.value());

	}
	
	@Test
	public void returnSuccess_whenUpdateSubscription() throws JsonProcessingException {

		Optional<Subscription> subscription = Optional.of(new Subscription());
		subscription.get().setUpdatedAt(LocalDateTime.now());
		
		//when(this.subscriptionService.updateSubscription());

		given().accept(ContentType.JSON).contentType(ContentType.JSON).when()
		.patch("/desafioglobo/subscription/1").then().statusCode(HttpStatus.NO_CONTENT.value());

	}
	
}
