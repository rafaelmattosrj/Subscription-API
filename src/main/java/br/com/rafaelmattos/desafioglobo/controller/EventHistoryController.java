package br.com.rafaelmattos.desafioglobo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.rafaelmattos.desafioglobo.domain.EventHistory;
import br.com.rafaelmattos.desafioglobo.dto.EventHistoryResponse;
import br.com.rafaelmattos.desafioglobo.service.EventHistoryService;
import br.com.rafaelmattos.desafioglobo.util.Converter;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/desafioglobo")
public class EventHistoryController {

	@Autowired
	private EventHistoryService eventHistoryService;
	
	@Autowired
	private Converter converter;

	@ApiOperation(value = "Return all histories by subscription id.")
	@RequestMapping(path = "/eventhistory/subscription/{id}",method = RequestMethod.GET)
	public ResponseEntity<List<EventHistoryResponse>> findAllHistoriesBySubscriptionId(@PathVariable String id) {
		List<EventHistory> listEventHistory = eventHistoryService.findAllBySubscriptionId(id);
		List<EventHistoryResponse> listEventHistoryResponse = converter.toEventHistoriesResponse(listEventHistory);
		return ResponseEntity.ok().body(listEventHistoryResponse);
	}
	
	@ApiOperation(value = "Search event history by id.")
	@RequestMapping(value = "/eventhistory/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> findEventHistoryById(@PathVariable Integer id) {
		EventHistory eventHistory = eventHistoryService.findEventHistoryById(id);
		EventHistoryResponse eventHistoryResponse = converter.toEventHistoryResponse(eventHistory);
		return ResponseEntity.ok().body(eventHistoryResponse);
	}
	
}
