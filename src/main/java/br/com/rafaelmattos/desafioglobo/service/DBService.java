package br.com.rafaelmattos.desafioglobo.service;

import java.text.ParseException;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.rafaelmattos.desafioglobo.domain.Status;
import br.com.rafaelmattos.desafioglobo.repository.StatusRepository;

@Service
public class DBService {

	@Autowired
	private StatusRepository statusRepository;
	
	public void instantiateTestDatabase () throws ParseException {

		Status status1 = new Status(1, "SUBSCRIPTION_PURCHASED");
		Status status2 = new Status(2, "SUBSCRIPTION_CANCELED");
		Status status3 = new Status(3, "SUBSCRIPTION_RESTARTED");

		statusRepository.saveAll(Arrays.asList(status1, status2, status3));
	}
}

