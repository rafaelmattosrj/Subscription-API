package br.com.rafaelmattos.desafioglobo.domain;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Subscription implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(
			name = "UUID",
			strategy = "org.hibernate.id.UUIDHexGenerator"
	)
	@Column(name = "subscription_id")
	private String id;

	@OneToOne
	@JoinColumn(name = "status_id")
	private Status status;

	@JsonFormat(pattern="dd/MM/yyyy HH:mm:ss")
	@Column(name="created_at")
	private LocalDateTime createdAt;
	@JsonFormat(pattern="dd/MM/yyyy HH:mm:ss")
	@Column(name="updated_at")
	private LocalDateTime updatedAt;
		
	public Subscription() {
	}

	public Subscription(Status statusId, LocalDateTime createdAt, LocalDateTime updatedAt) {
		this.status = statusId;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	public Subscription(String id, Status statusId, LocalDateTime createdAt, LocalDateTime updatedAt) {
		this.id = id;
		this.status = statusId;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
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
		Subscription other = (Subscription) obj;
		if (id == null) {
			return other.id == null;
		} else return id.equals(other.id);
	}
		
}

