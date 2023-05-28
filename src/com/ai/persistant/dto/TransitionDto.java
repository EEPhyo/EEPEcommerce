package com.ai.persistant.dto;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import com.ai.model.Payment_type;
import com.ai.model.Role;
import com.ai.model.User;


@Entity
@Table(name="transition")
public class TransitionDto {
			
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
			private int id;
	
	@Column
	@DateTimeFormat(pattern = "dd/MM/yyyy")
			private String created_date;
	
	@Column
	@NotEmpty
			private String receive_account;
	
	@Column
	@NotEmpty
			private String transition_proof;
	
	
	public TransitionDto() {
		created_date=LocalDate.now().format(DateTimeFormatter.ISO_DATE);
	}
	
	@ManyToOne
	@JoinColumn(name="id",nullable = false)
	private Payment_type type;
	
	@ManyToOne
	@JoinColumn(name="id",nullable = false)
	private User sender_account;
	
	
			public int getId() {
				return id;
			}
			public void setId(int id) {
				this.id = id;
			}
			public String getCreated_date() {
				return created_date;
			}
			public void setCreated_date(String created_date) {
				this.created_date = created_date;
			}
			public String getReceive_account() {
				return receive_account;
			}
			public void setReceive_account(String receive_account) {
				this.receive_account = receive_account;
			}
			public String getTransition_proof() {
				return transition_proof;
			}
			public void setTransition_proof(String transition_proof) {
				this.transition_proof = transition_proof;
			}
			
}
