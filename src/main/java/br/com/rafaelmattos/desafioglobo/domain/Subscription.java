package br.com.rafaelmattos.desafioglobo.domain;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Table(name = "Subscription")
@Entity
public class Subscription implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@JoinColumn(name = "subscription_id")
	private UUID subscription_id = UUID.randomUUID();

	@OneToOne
	@JoinColumn(name = "status_id")
	@MapsId
	private Status status_id;

	@JsonFormat(pattern="dd/MM/yyyy HH:mm")
	private LocalDateTime created_at = LocalDateTime.now();
	@JsonFormat(pattern="dd/MM/yyyy HH:mm")
	private LocalDateTime updated_at = LocalDateTime.now();

	public Subscription(UUID subscription_id, Status status_id, LocalDateTime created_at, LocalDateTime updated_at) {
		this.subscription_id = subscription_id;
		this.status_id = status_id;
		this.created_at = created_at;
		this.updated_at = updated_at;
	}

	public UUID getSubscription_id() {
		return subscription_id;
	}
	
	public void setSubscription_id(UUID subscription_id) {
		this.subscription_id = subscription_id;
	}
		
	public Status getStatus_id() {
		return status_id;
	}

	public void setStatus_id(Status status_id) {
		this.status_id = status_id;
	}

	public LocalDateTime getCreated_at() {
		return created_at;
	}
	
	public void setCreated_at(LocalDateTime created_at) {
		this.created_at = created_at;
	}
	
	public LocalDateTime getUpdated_at() {
		return updated_at;
	}
	
	public void setUpdated_at(LocalDateTime updated_at) {
		this.updated_at = updated_at;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((subscription_id == null) ? 0 : subscription_id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Subscription other = (Subscription) obj;
		if (subscription_id == null) {
			if (other.subscription_id != null)
				return false;
		} else if (!subscription_id.equals(other.subscription_id))
			return false;
		return true;
	}
	
}

