package com.ai.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;
import com.ai.model.Role;



@Entity
@Table(name="user")
public class User implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column
	@NotEmpty
	private String name;
	
	@Email(message="Enter valid Email Id.")
	@Column(unique = true)
	@NotEmpty
	private String email;
	
	
	@Column(name="password")
	private String password;
	
	@Column(name="confirmPassword")
	private String confirmPassword;	
	
	
	@Column(name="phone_number")
	@NotNull
	@NotEmpty
	private String phone_number;
	 
	@Column
	@NotEmpty
	private String address;
	
	private int role_id;
	
	
	
	public int getRole_id() {
		return role_id;
	}
	public void setRole_id(int role_id) {
		this.role_id = role_id;
	}
	
	@Column
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private String created_date;
	
	@Column
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private String updated_date;
	
	@Column
	private String created_user;
	 
	 @Column
	private String updated_user;
	 
	 @Column
	private boolean enabled;
	
	@Column
	private boolean locked;
	
	@ManyToOne
	@JoinColumn(name="id",nullable = false)
	private Role role;
	

	
	public User() {
		created_date=LocalDate.now().format(DateTimeFormatter.ISO_DATE);
		updated_date=LocalDate.now().format(DateTimeFormatter.ISO_DATE);
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		 return password != null ? password : "";
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	public String getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCreated_date() {
		return created_date;
	}

	public void setCreated_date(String created_date) {
		this.created_date = created_date;
	}

	public String getUpdated_date() {
		return updated_date;
	}

	public void setUpdated_date(String updated_date) {
		this.updated_date = updated_date;
	}

	public String getCreated_user() {
		return created_user;
	}

	public void setCreated_user(String created_user) {
		this.created_user = created_user;
	}

	public String getUpdated_user() {
		return updated_user;
	}

	public void setUpdated_user(String updated_user) {
		this.updated_user = updated_user;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public boolean isLocked() {
		return locked;
	}

	public void setLocked(boolean locked) {
		this.locked = locked;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	

	

}
