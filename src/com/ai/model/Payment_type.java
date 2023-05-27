package com.ai.model;

import java.io.Serializable;

public class Payment_type implements Serializable{
	private int id;
	private String value;
	
	public Payment_type() {}
	
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
