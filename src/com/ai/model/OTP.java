package com.ai.model;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="otp")

public class OTP implements Serializable{
	private static final long OTP_VALID_DURATION = 5 * 60 * 1000;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(name = "code")
	private String code;

	
	@Column
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private String created_date;
	
	@Column
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private String updated_date;
	
	@Column
	(name = "otp_requested_time")
    private String otpRequestedTime;
	
	public boolean isOTPRequired() {
        if (this.getOneTimePassword() == null) {
            return false;
        }
         
        long currentTimeInMillis = System.currentTimeMillis();
        long otpRequestedTimeinMillis = this.otpRequestedTime.getTime();
         
        if (otpRequestedTimeinMillis + OTP_VALID_DURATION < currentTimeInMillis) {
            // OTP expires
            return false;
        }
         
        return true;
    }


	private Object getOneTimePassword() {
		// TODO Auto-generated method stub
		return null;
	}


	public OTP(){}

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
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

	
}

