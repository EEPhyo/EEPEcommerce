package com.ai.persistant.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ai.persistant.dto.Payment_typeDto;
import com.ai.persistant.dto.SizeDto;

public class Payment_typeDao {
public static Connection con=null;
	
	static {
		con = MyConnection.getConnection();
	}
	
	
	//insert
	public int insertData(Payment_typeDto type) {
		int result =0;
		String sql = "INSERT INTO payment_type(id,value VALUES (?,?)";
		
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1,type.getId());
			ps.setString(2,type.getValue());
			result=ps.executeUpdate();			
		}catch (SQLException e) {
			System.out.println("Database error");
			e.printStackTrace();
		}
		return result;
		
	}
	
	//update
	public int updateData(Payment_typeDto type) {
		int result =0;
		String sql = "UPDATE payment_type SET value=? WHERE id=?";
		
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setString(1,type.getValue());
			result=ps.executeUpdate();			
		}catch (SQLException e) {
			System.out.println("Database error");
		}
		return result;
		
	}
	
	//delete
	public int deleteData(Payment_typeDto type) {
		int result=0;
		String sql = "DELETE FROM payment_type where id=?";		
		
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1,type.getId());
			result=ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Database error");
		}
		return result;
	}
	//select single book
	public Payment_typeDto selectOne(Payment_typeDto type) {
		Payment_typeDto res = new Payment_typeDto();
		String sql = "SELECT * from payment_type where id=?";
		
		PreparedStatement ps;
		try {
			ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				rs.getInt("id");
				res.setValue(rs.getString("value"));
			}
		} catch (SQLException e) {
			System.out.println("Database error");
		}
		return res;			
	}
	
	//selectAll
	public ArrayList<Payment_typeDto> selectAll() {
		ArrayList<Payment_typeDto> list = new ArrayList();
		String sql = "SELECT * FROM payment_type";
		
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				Payment_typeDto res = new Payment_typeDto();
				rs.getInt("id");
				res.setValue(rs.getString("value"));
			}
			
		} catch (SQLException e) {
			System.out.println("Database error");
		}
		return list;
	}
		
	}

