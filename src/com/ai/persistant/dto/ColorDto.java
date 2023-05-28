package com.ai.persistant.dto;

import java.io.Serializable;

public class ColorDto implements Serializable{
	
	private int color_id;
	
	private String name;
	private String code;
	
	public ColorDto() {}
	
	public int getColor_id() {
		return color_id;
	}

	public void setColor_id(int color_id) {
		this.color_id = color_id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	

}
