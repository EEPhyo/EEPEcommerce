package com.ai.persistant.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.ai.model.Shopping_cart;
import com.ai.model.Transition;
import com.ai.model.User;




@Entity
@Table(name="shop_order")
public class Shop_orderDto implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private String order_date;
	@Column
	private double order_total;
	@Column
	private String order_status;
	@Column
	private double total_price;
	
	
	@OneToOne
	@JoinColumn(name="id",nullable = false)
	private User user;
	
	@OneToOne
	@JoinColumn(name="id",nullable = false)
	private Transition transition;
	
	@OneToOne
	@JoinColumn(name="id",nullable = false)
	private Shopping_cart shopping_cart;
	
	public Shop_orderDto() {
		order_date=LocalDate.now().format(DateTimeFormatter.ISO_DATE);

		
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getOrder_date() {
		return order_date;
	}
	public void setOrder_date(String order_date) {
		this.order_date = order_date;
	}
	public double getOrder_total() {
		return order_total;
	}
	public void setOrder_total(double order_total) {
		this.order_total = order_total;
	}
	public String getOrder_status() {
		return order_status;
	}
	public void setOrder_status(String order_status) {
		this.order_status = order_status;
	}
	public double getTotal_price() {
		return total_price;
	}
	public void setTotal_price(double total_price) {
		this.total_price = total_price;
	}
}
