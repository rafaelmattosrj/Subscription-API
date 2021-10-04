package br.com.rafaelmattos.desafioglobo.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.rafaelmattos.desafioglobo.domain.Subscription;

@Repository
public interface SubscriptionRepository extends JpaRepository<Subscription, UUID> {
		
}
