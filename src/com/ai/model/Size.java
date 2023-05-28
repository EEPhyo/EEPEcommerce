package com.ai.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Size implements Serializable {
			
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int size_id;
	
	
	@Column(name="value")
    private String value;

    public Size(){}
    
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
