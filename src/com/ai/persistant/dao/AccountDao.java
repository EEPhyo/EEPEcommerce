package com.ai.persistant.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.ai.model.User;
import com.ai.persistant.dto.UserDto;

@Service("accountDao")
public class AccountDao {
	public static Connection con = null;
	static {
		con=MyConnection.getConnection();
	}
	
	public int searchUserIdbyEmail(String email) {
	    int userId=0;
	    String str = "SELECT * FROM user WHERE email=?";
	    try {
	      PreparedStatement ps = con.prepareStatement(str);
	      ps.setString(1,email);
	      ResultSet res = ps.executeQuery();
	      
	      while(res.next()) {
	        userId=res.getInt(1);
	      }
	    } catch (SQLException e) {
	      System.out.print(e);
	    }
	    return userId;
	  }

	
	
	//selectAllAdmin
	public ArrayList<UserDto> selectAllAdmin() {
	    ArrayList<UserDto> list = new ArrayList<UserDto>();
	    String sql = "SELECT * FROM user WHERE email LIKE ? AND password LIKE ?";
	    
	    try {
	        UserDto user = new UserDto();
	        PreparedStatement ps = con.prepareStatement(sql);
	        ps.setString(1, "%johndoe@gmail.com%");
	        ps.setString(2, "%admin123%");
	        ResultSet rs = ps.executeQuery();
	        
	        while (rs.next()) {
	            UserDto res = new UserDto();
	            res.setId(rs.getInt("id"));
	            res.setName(rs.getString("name"));
	            res.setEmail(rs.getString("email"));
	            res.setPassword(rs.getString("password"));
	            res.setPhone_number(rs.getString("phone_number"));
	            res.setAddress(rs.getString("address"));
	            res.setRole_id(1);
	            res.setCreated_date(rs.getString("created_date"));
	            res.setUpdated_date(rs.getString("updated_date"));
	            res.setCreated_user(rs.getString("created_user"));
	            res.setUpdated_user(rs.getString("updated_user"));
	            res.setEnabled(rs.getBoolean("enabled"));
	            res.setLocked(rs.getBoolean("locked"));
	            list.add(res);
	        }
	        
	    } catch (SQLException e) {
	        System.out.println("Database error: " + e.getMessage());
	    }
	    
	    return list;
	}

	
	//selectAllUser
	public ArrayList<UserDto> selectAllUser() {
	    ArrayList<UserDto> list = new ArrayList<UserDto>();
	    String sql = "SELECT * FROM user WHERE email LIKE ? AND password LIKE ?";
	    
	    try {
	        UserDto user = new UserDto();
	        PreparedStatement ps = con.prepareStatement(sql);
	        ps.setString(1, user.getEmail());
	        ps.setString(2,user.getPassword());
	        ResultSet rs = ps.executeQuery();
	        
	        while (rs.next()) {
	            UserDto res = new UserDto();
	            res.setId(rs.getInt("id"));
	            res.setName(rs.getString("name"));
	            res.setEmail(rs.getString("email"));
	            res.setPassword(rs.getString("password"));
	            res.setPhone_number(rs.getString("phone_number"));
	            res.setAddress(rs.getString("address"));
	            res.setRole_id(2);
	            res.setCreated_date(rs.getString("created_date"));
	            res.setUpdated_date(rs.getString("updated_date"));
	            res.setCreated_user(rs.getString("created_user"));
	            res.setUpdated_user(rs.getString("updated_user"));
	            res.setEnabled(rs.getBoolean("enabled"));
	            res.setLocked(rs.getBoolean("locked"));
	            list.add(res);
	        }
	        
	    } catch (SQLException e) {
	        System.out.println("Database error: " + e.getMessage());
	    }
	    
	    return list;
	}


	
	
}
