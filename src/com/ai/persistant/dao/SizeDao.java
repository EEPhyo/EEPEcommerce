package com.ai.persistant.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.ai.persistant.dto.SizeDto;


@Service("sizeDao")
public class SizeDao {
	public static Connection con=null;
	
	static {
		con = MyConnection.getConnection();
	}
	
	
	//insert
	public int insertData(SizeDto size) {
		int result =0;
		String sql = "INSERT INTO size (size_id,value) VALUES (?,?)";
		
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1,size.getSize_id());
			ps.setString(2,size.getValue());
			result=ps.executeUpdate();			
		}catch (SQLException e) {
			System.out.println("Database error");
			e.printStackTrace();
		}
		return result;
		
	}
	
	//update
	public int updateData(SizeDto size) {
		int result =0;
		String sql = "UPDATE size SET value=? WHERE size_id=?";
		
		try {
			PreparedStatement ps = con.prepareStatement(sql);			
			ps.setString(1,size.getValue());
			result=ps.executeUpdate();			
		}catch (SQLException e) {
			System.out.println("Database error");
		}
		return result;
		
	}
	
	//delete
	public int deleteData(SizeDto size) {
		int result=0;
		String sql = "DELETE FROM size where size_id=?";		
		
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1,size.getSize_id());
			result=ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Database error");
		}
		return result;
	}
	//select single book
	public SizeDto selectOne(SizeDto size) {
		SizeDto res = new SizeDto();
		String sql = "SELECT * from size where size_id=?";
		
		PreparedStatement ps;
		try {
			ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				res.setSize_id(rs.getInt("size_id"));
				res.setValue(rs.getString("value"));
			}
		} catch (SQLException e) {
			System.out.println("Database error");
		}
		return res;			
	}
	
	//selectAll
	public ArrayList<SizeDto> selectAll() {
		ArrayList<SizeDto> list = new ArrayList<>();
		String sql = "SELECT * FROM size";
		
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				SizeDto res = new SizeDto();
				res.setSize_id(rs.getInt("size_id"));
				res.setValue(rs.getString("value"));
				list.add(res);
			}
			
		} catch (SQLException e) {
			System.out.println("Database error");
		}
		    
		return list;
		
	
	
	
	}
		
}

