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
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.rafaelmattos.desafioglobo.domain.enums.SubscriptionType;

@Table(name = "EventHistory")
@Entity
public class EventHistory implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "event_history_id")
	private Integer id;
	private Integer type;
	
	@ManyToOne
	@JoinColumn(name="subscription_id")
	private Subscription subscription_id;
	
	@JsonFormat(pattern="dd/MM/yyyy HH:mm")
	private LocalDateTime created_at = LocalDateTime.now();
	
	public EventHistory() {
	}

	public EventHistory(Integer id, SubscriptionType type, Subscription subscription_id, LocalDateTime created_at) {
		this.id = id;
		this.type = type.getCod();
		this.subscription_id = subscription_id;
		this.created_at = created_at;
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

	public void setType(SubscriptionType type) {
		this.type = type.getCod();
	}

	public Subscription getSubscription_id() {
		return subscription_id;
	}

	public void setSubscription_id(Subscription subscription_id) {
		this.subscription_id = subscription_id;
	}

	public LocalDateTime getCreated_at() {
		return created_at;
	}

	public void setCreated_at(LocalDateTime created_at) {
		this.created_at = created_at;
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
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
