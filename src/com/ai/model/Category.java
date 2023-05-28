package com.ai.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;

import com.ai.persistant.dto.CategoryDto;

public class Category implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int category_id;
	
	
	@Column(name="name")
    private String name;
	
	@Column
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private String created_date;

    
	public Category(){
		created_date=LocalDate.now().format(DateTimeFormatter.ISO_DATE);
	}
	
	public int getCategory_id() {
		return category_id;
	}


	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}
	
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    
    public String getCreated_date() {
		return created_date;
	}
	public void setCreated_date(String created_date) {
		this.created_date = created_date;
	}
}
