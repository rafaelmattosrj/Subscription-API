package br.com.rafaelmattos.desafioglobo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.rafaelmattos.desafioglobo.domain.EventHistory;

@Repository
public interface EventHistoryRepository extends JpaRepository<EventHistory, Integer> {
	
}
