package br.com.rafaelmattos.desafioglobo.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import br.com.rafaelmattos.desafioglobo.domain.enums.SubscriptionType;

@Entity
public class Status implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "status_id")
	private Integer id;
	private String type;

	public Status() {
	}

	public Status(Integer id, String type) {
		this.id = id;
		this.type = type;
	}
	
	public Status(SubscriptionType type) {
		this.id = type.getCod();
		this.type = type.getType();
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

}
