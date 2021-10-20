package br.com.rafaelmattos.desafioglobo.domain;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.rafaelmattos.desafioglobo.domain.enums.SubscriptionType;

@Entity
public class EventHistory implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "event_history_id")
	private Integer id;
	private String type;
	
	@ManyToOne
	@JoinColumn(name="subscription_id")
	private Subscription subscription;
	
	@JsonFormat(pattern="dd/MM/yyyy HH:mm:ss")
	@Column(name="created_at")
	private LocalDateTime createdAt;
	
	public EventHistory() {
	}

	public EventHistory(String type, Subscription subscription, LocalDateTime createdAt) {
		this.type = type;
		this.subscription = subscription;
		this.createdAt = createdAt;
	}

	public EventHistory(Integer id, String type, Subscription subscription, LocalDateTime createdAt) {
		this.id = id;
		this.type = type;
		this.subscription = subscription;
		this.createdAt = createdAt;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public SubscriptionType getType() {
		return SubscriptionType.toEnum(type);
	}

	public void setType(String type) {
		this.type = type;
	}

	public Subscription getSubscription() {
		return subscription;
	}

	public void setSubscription(Subscription subscription) {
		this.subscription = subscription;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		EventHistory other = (EventHistory) obj;
		if (id == null) {
			return other.id == null;
		} else return id.equals(other.id);
	}
	
}
