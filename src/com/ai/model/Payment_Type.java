package com.ai.model;

import java.io.Serializable;

public class Payment_Type implements Serializable{
	private int id;
	private String value;
	
	public Payment_Type() {}
	
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
