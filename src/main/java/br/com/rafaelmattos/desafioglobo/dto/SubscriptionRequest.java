package br.com.rafaelmattos.desafioglobo.dto;

import java.time.LocalDateTime;

import br.com.rafaelmattos.desafioglobo.domain.Status;

public class SubscriptionRequest {

	private Status statusId;
	private LocalDateTime updatedAt;
		
	public SubscriptionRequest() {
	}
	
	public Status getStatusId() {
		return statusId;
	}
	public void setStatusId(Status statusId) {
		this.statusId = statusId;
	}
	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}
}
