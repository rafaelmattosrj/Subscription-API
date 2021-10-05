package br.com.rafaelmattos.desafioglobo.dto;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.rafaelmattos.desafioglobo.domain.EventHistory;
import br.com.rafaelmattos.desafioglobo.domain.Subscription;

public class EventHistoryResponse implements Serializable {
		private static final long serialVersionUID = 1L;

		private Integer id;
		private String type;
		private Subscription subscriptionId;
		
		@JsonFormat(pattern="dd/MM/yyyy HH:mm")
		private Date createdAt;
		
		public EventHistoryResponse() {
		}

		public EventHistoryResponse(EventHistory eventHistory) {
			id = eventHistory.getId();
			type = eventHistory.getType().getDescription();
			subscriptionId = eventHistory.getSubscriptionId();
			createdAt = eventHistory.getCreatedAt();
		}

		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}

		public Subscription getSubscriptionId() {
			return subscriptionId;
		}

		public void setSubscriptionId(Subscription subscriptionId) {
			this.subscriptionId = subscriptionId;
		}

		public Date getCreatedAt() {
			return createdAt;
		}

		public void setCreatedAt(Date createdAt) {
			this.createdAt = createdAt;
		}
			
}
