package br.com.rafaelmattos.desafioglobo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.rafaelmattos.desafioglobo.domain.EventHistory;
import br.com.rafaelmattos.desafioglobo.service.EventHistoryService;

@RestController
@RequestMapping(value = "/eventhistory")
public class EventHistoryController {

	@Autowired
	private EventHistoryService eventHistoryService;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		EventHistory eventHistory = eventHistoryService.find(id);
		return ResponseEntity.ok().body(eventHistory);
	}
}
