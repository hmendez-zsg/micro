package com.zsg.micro;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="long_adjective")
public class InsultLongAdjective {

	@Id
	private String id;
	
	@Column(name="string")
	private String adjective;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAdjective() {
		return adjective;
	}

	public void setAdjective(String adjective) {
		this.adjective = adjective;
	}
}
