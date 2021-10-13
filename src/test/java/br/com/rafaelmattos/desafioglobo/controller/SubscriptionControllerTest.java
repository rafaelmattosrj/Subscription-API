package br.com.rafaelmattos.desafioglobo.controller;

import static io.restassured.module.mockmvc.RestAssuredMockMvc.given;
import static io.restassured.module.mockmvc.RestAssuredMockMvc.standaloneSetup;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.ActiveProfiles;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.rafaelmattos.desafioglobo.DesafioGloboApplication;
import br.com.rafaelmattos.desafioglobo.domain.Status;
import br.com.rafaelmattos.desafioglobo.domain.Subscription;
import br.com.rafaelmattos.desafioglobo.domain.enums.SubscriptionType;
import br.com.rafaelmattos.desafioglobo.service.SubscriptionService;
import io.restassured.http.ContentType;

@SpringBootTest(classes = DesafioGloboApplication.class)
@ActiveProfiles(value = {"test"})
class SubscriptionControllerTest {

	@MockBean
	private SubscriptionService subscriptionService;

	@BeforeEach
	public void setup() {
		standaloneSetup(this.subscriptionService);
	}
	
	@Test
	public void returnSuccess_whenFindById_AndSubscriptionExists() throws JsonProcessingException {
		//FAIL
		LocalDateTime date = LocalDateTime.now();
		Status status = new Status(SubscriptionType.SUBSCRIPTION_PURCHASED);

		Subscription subscription = new Subscription(
				"402880937c74dc45017c7506ad910004",
				status,
				date,
				date
		);

		when(this.subscriptionService.findSubscriptionById("402880937c74dc45017c7506ad910004"))
		.thenReturn(subscription);

		given().accept(ContentType.JSON)
		.when().get("/desafioglobo/subscription/402880937c74dc45017c7506ad910004").then().statusCode(HttpStatus.OK.value());
	}

	@Test
	public void returnNotFound__whenFindById_AndSubscriptionNotExist() throws JsonProcessingException {
		//OK
		LocalDateTime date = LocalDateTime.now();
		Status status = new Status(SubscriptionType.SUBSCRIPTION_PURCHASED);

		Subscription subscription = new Subscription(
				"402880937c74dc45017c7506ad910004",
				status,
				date,
				date
		);
		
		when(this.subscriptionService.findSubscriptionById("402880937c74dc45017c7506ad910004")).thenReturn(subscription);

		given().accept(ContentType.JSON)
		.when().get("/desafioglobo/subscription/402880937c74dc45017c7506ad910004").then().statusCode(HttpStatus.NOT_FOUND.value());
	}
	
	@Test
	public void returnSuccess_whenCreateSubscription() throws JsonProcessingException {
		//FAIL
		LocalDateTime date = LocalDateTime.now();
		Status status = new Status(SubscriptionType.SUBSCRIPTION_PURCHASED);

		Subscription subscription = new Subscription(
				status,
				date,
				date
		);
		
		when(this.subscriptionService.createSubscription()).thenReturn(subscription);

		ObjectMapper mapper = new ObjectMapper();
		String body = mapper.writeValueAsString(status);

		given().accept(ContentType.JSON).contentType(ContentType.JSON).body(body)
		.when().post("/desafioglobo/subscription").then().statusCode(HttpStatus.CREATED.value());

	}
	
	@Test
	public void returnSuccess_whenUpdateSubscription() throws JsonProcessingException {
		//FAIL
		LocalDateTime date = LocalDateTime.now();
		Status status = new Status(SubscriptionType.SUBSCRIPTION_PURCHASED);

		Subscription subscription = new Subscription(
				"402880937c74dc45017c7506ad910004",
				status,
				date,
				date
		);
				
		when(this.subscriptionService.updateSubscription("402880937c74dc45017c7506ad910004")).thenReturn(subscription);

		given().accept(ContentType.JSON).contentType(ContentType.JSON).when()
		.patch("/desafioglobo/subscription/402880937c74dc45017c7506ad910004").then().statusCode(HttpStatus.NO_CONTENT.value());

	}
	
}
