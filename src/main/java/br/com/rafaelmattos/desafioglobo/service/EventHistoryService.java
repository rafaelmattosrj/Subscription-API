package br.com.rafaelmattos.desafioglobo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.rafaelmattos.desafioglobo.domain.EventHistory;
import br.com.rafaelmattos.desafioglobo.repository.EventHistoryRepository;
import br.com.rafaelmattos.desafioglobo.service.exception.ObjectNotFoundException;

@Service
public class EventHistoryService {

	@Autowired
	private EventHistoryRepository eventHistoryRepository;

	public EventHistory find(Integer id) {
		Optional<EventHistory> eventHistory = eventHistoryRepository.findById(id);
		return eventHistory.orElseThrow(() -> new ObjectNotFoundException(
				"Object not found! Id: " + id + ", Tipo: " + EventHistory.class.getName()));
	}
	
	public EventHistory insert(EventHistory eventHistory) {
		eventHistory.setId(null);
		return eventHistoryRepository.save(eventHistory);
	}
	
}
