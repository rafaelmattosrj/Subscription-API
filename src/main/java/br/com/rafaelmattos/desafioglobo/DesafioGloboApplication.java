package br.com.rafaelmattos.desafioglobo;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.rafaelmattos.desafioglobo.domain.EventHistory;
import br.com.rafaelmattos.desafioglobo.repository.EventHistoryRepository;

@SpringBootApplication
public class DesafioGloboApplication implements CommandLineRunner{

	@Autowired
	private EventHistoryRepository eventHistoryRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(DesafioGloboApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		EventHistory eventHistory1 = new EventHistory(null, "SUBSCRIPTION_PURCHASED", "5793cf6b3fd833521db8c420955e6f01", null);
		EventHistory eventHistory2 = new EventHistory(null, "SUBSCRIPTION_PURCHASED", "5793cf6b3fd833521db8c420955e6f02", null);
		EventHistory eventHistory3 = new EventHistory(null, "SUBSCRIPTION_PURCHASED", "5793cf6b3fd833521db8c420955e6f03", null);
		EventHistory eventHistory4 = new EventHistory(null, "SUBSCRIPTION_PURCHASED", "5793cf6b3fd833521db8c420955e6f04", null);
		EventHistory eventHistory5 = new EventHistory(null, "SUBSCRIPTION_PURCHASED", "5793cf6b3fd833521db8c420955e6f05", null);
		EventHistory eventHistory6 = new EventHistory(null, "SUBSCRIPTION_PURCHASED", "5793cf6b3fd833521db8c420955e6f06", null);
		EventHistory eventHistory7 = new EventHistory(null, "SUBSCRIPTION_PURCHASED", "5793cf6b3fd833521db8c420955e6f07", null);
		EventHistory eventHistory8 = new EventHistory(null, "SUBSCRIPTION_PURCHASED", "5793cf6b3fd833521db8c420955e6f08", null);
		EventHistory eventHistory9 = new EventHistory(null, "SUBSCRIPTION_PURCHASED", "5793cf6b3fd833521db8c420955e6f09", null);
		EventHistory eventHistory10 = new EventHistory(null, "SUBSCRIPTION_PURCHASED", "5793cf6b3fd833521db8c420955e6f00", null);

		EventHistory eventHistory11 = new EventHistory(null, "SUBSCRIPTION_CANCELED", "5793cf6b3fd833521db8c420955e6f06", null);
		EventHistory eventHistory12 = new EventHistory(null, "SUBSCRIPTION_CANCELED", "5793cf6b3fd833521db8c420955e6f03", null);
		EventHistory eventHistory13 = new EventHistory(null, "SUBSCRIPTION_CANCELED", "5793cf6b3fd833521db8c420955e6f08", null);
		EventHistory eventHistory14 = new EventHistory(null, "SUBSCRIPTION_CANCELED", "5793cf6b3fd833521db8c420955e6f00", null);

		EventHistory eventHistory15 = new EventHistory(null, "SUBSCRIPTION_RESTARTED", "5793cf6b3fd833521db8c420955e6f06", null);
		EventHistory eventHistory16 = new EventHistory(null, "SUBSCRIPTION_RESTARTED", "5793cf6b3fd833521db8c420955e6f00", null);

		eventHistoryRepository.saveAll(Arrays.asList(eventHistory1, eventHistory2, eventHistory3, eventHistory4, 
				eventHistory5, eventHistory6, eventHistory7, eventHistory8, eventHistory9, eventHistory10, 
				eventHistory11, eventHistory12, eventHistory13, eventHistory14, eventHistory15, eventHistory16));
	}
}
