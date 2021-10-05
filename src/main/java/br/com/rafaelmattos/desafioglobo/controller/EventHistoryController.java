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

@RestController
@RequestMapping(value = "/eventhistory")
public class EventHistoryController {

	@Autowired
	private EventHistoryService eventHistoryService;
	
	@Autowired
	private Converter converter;

	@RequestMapping(path = "/subscription/{id}",method = RequestMethod.GET)
	public ResponseEntity<List<EventHistoryResponse>> findAllHistoriesBySubscriptionId(@PathVariable Integer id) {
		List<EventHistory> listEventHistory = eventHistoryService.findAllBySubscriptionId(id);
		List<EventHistoryResponse> listEventHistoryResponse = converter.toEventHistoryResponse(listEventHistory);
		return ResponseEntity.ok().body(listEventHistoryResponse);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		EventHistory eventHistory = eventHistoryService.find(id);
		EventHistoryResponse eventHistoryResponse = converter.toEventHistoryResponse(eventHistory);
		return ResponseEntity.ok().body(eventHistoryResponse);
	}
	
}
