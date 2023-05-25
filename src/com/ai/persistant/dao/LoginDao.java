package com.ai.persistant.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.ai.model.User;

public class LoginDao {


	public static Connection con=null;
	
	static {
		con = MyConnection.getConnection();
	}
	
	public String authenticateUser(User user) {
		String email = user.getEmail();
		String password = user.getPassword();
		String emailDB = "";
		String passwordDB = "";
		String roleDB = "";
		String sql = "SELECT email,password,role from user";
		
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				emailDB = rs.getString("email");
				passwordDB = rs.getString("password");
				roleDB=rs.getString("role");
				if(email.equals("jondoe@gmail.com") && password.equals("admin123") && roleDB.equals("Admin")) {
					return "Admin_Role";
					
				}else if(email.equals(emailDB) && password.equals(passwordDB) && roleDB.equals("Customer")) {
					return "Customer_Role";
					
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return "Invalid user credentials";
		
	
	}
}
