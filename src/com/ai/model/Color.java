package com.ai.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name="color")
public class Color implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)		
	private int color_id;
	
	
	@Column(name="name")
	private String name;
	
	@Column(name="code")
	private String code;
	
	@OneToMany(mappedBy = "color",fetch=FetchType.LAZY,
    		cascade = CascadeType.ALL)
    private Set<Color> color;
	
	public Color() {}
	
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
