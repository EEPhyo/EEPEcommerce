package com.ai.persistant.dto;

import java.io.Serializable;

public class SizeDto implements Serializable{
	
	
	private int size_id;	

	private String value;
	
	public SizeDto() {}	

	public int getSize_id() {
		return size_id;
	}
	
	public void setSize_id(int size_id) {
		this.size_id = size_id;
	}
	
	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}	
	
}
