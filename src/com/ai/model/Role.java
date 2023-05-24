package com.ai.model;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="role")
public class Role<user> {
	

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	 @Column
    private String role_name;
    
//    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
//    @JoinColumn(name="user_id")		
//    private List <User> user=new  ArrayList<>();
//   

	public Role() {}
    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getRole_name() {
        return role_name;
    }
    public void setRole_name(String role_name) {
        this.role_name = role_name;
    }
    
//    public List<User> getUser() {
//  		return user;
//  	}
//
//  	public void setUser(List<User> user) {
//  		this.user = user;
//  	}
    

   

}
