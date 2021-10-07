package br.com.rafaelmattos.desafioglobo.dto;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.rafaelmattos.desafioglobo.domain.Status;
import br.com.rafaelmattos.desafioglobo.domain.Subscription;

public class SubscriptionResponse {
	
	private Integer id;
	private Status statusId;
	
	@JsonFormat(pattern="dd/MM/yyyy HH:mm:ss")
	private LocalDateTime createdAt;
	@JsonFormat(pattern="dd/MM/yyyy HH:mm:ss")
	private LocalDateTime updatedAt;
	
	public SubscriptionResponse() {
	}

	public SubscriptionResponse(Subscription subscription) {
		id = subscription.getId();
		statusId = subscription.getStatusId();
		createdAt = subscription.getCreatedAt();
		updatedAt = subscription.getUpdatedAt();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Status getStatusId() {
		return statusId;
	}

	public void setStatusId(Status statusId) {
		this.statusId = statusId;
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

}
