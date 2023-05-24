package com.ai.persistant.dto;

import java.io.Serializable;

public class SizeDto implements Serializable{
	
	
	private int id;
	private String value;
	
	public SizeDto() {}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}	
	
}
