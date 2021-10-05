package br.com.rafaelmattos.desafioglobo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.rafaelmattos.desafioglobo.domain.EventHistory;
import br.com.rafaelmattos.desafioglobo.domain.Subscription;

@Repository
public interface EventHistoryRepository extends JpaRepository<EventHistory, Integer> {

	List<EventHistory> findAllBySubscriptionId(Subscription subscriptionId);
	
}
