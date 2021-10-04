package br.com.rafaelmattos.desafioglobo.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody EventHistory eventHistory) {
		eventHistory = eventHistoryService.insert(eventHistory);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(eventHistory.getId())
				.toUri();
		return ResponseEntity.created(uri).build();
	}
}
