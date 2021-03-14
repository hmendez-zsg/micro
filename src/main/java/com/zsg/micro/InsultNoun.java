package com.zsg.micro;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "noun")
public class InsultNoun {

	@Id
	private String id;
	
	@Column(name = "string")
	private String noun;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNoun() {
		return noun;
	}

	public void setNoun(String noun) {
		this.noun = noun;
	}
}
