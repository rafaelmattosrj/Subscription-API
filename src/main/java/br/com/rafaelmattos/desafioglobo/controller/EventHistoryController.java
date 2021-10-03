package br.com.rafaelmattos.desafioglobo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.rafaelmattos.desafioglobo.domain.EventHistory;

@RestController
@RequestMapping(value="/eventhistory")
public class EventHistoryController {
	
	@RequestMapping(method = RequestMethod.GET)
	public List<EventHistory> list() {
		
		EventHistory eventHistory1 = new EventHistory(1, "SUBSCRIPTION_PURCHASED", "5793cf6b3fd833521db8c420955e6f01", null);
		EventHistory eventHistory2 = new EventHistory(2, "SUBSCRIPTION_PURCHASED", "5793cf6b3fd833521db8c420955e6f02", null);

		List<EventHistory> list = new ArrayList<>();
		list.add(eventHistory1);
		list.add(eventHistory2);

		return list;
	}
}
