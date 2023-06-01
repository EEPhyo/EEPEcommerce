package com.ai.persistant.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service("searchProductDao")
public class SearchProductDao {

	
	private JdbcTemplate jdbcTemplate;
	
	public static Connection con=null;
	
	static {
		con = MyConnection.getConnection();
	}
	
	
	public int searchByCategories(int category_id) {
		int result=0;
		
		String str="SELECT * FROM product WHERE category_id=?";
		
		  try {
		      PreparedStatement ps = con.prepareStatement(str);
		      ps.setInt(1,category_id);
		      ResultSet res = ps.executeQuery();
		      
		      while(res.next()) {
		      result =res.getInt(1);
		      }
		    } catch (SQLException e) {
		      System.out.print(e);
		    }
		  return result;
	}
	
	public int searchByColors(int color_id) {
		int result=0;
		
		String str="SELECT * FROM product WHERE color_id=?";
		
		  try {
		      PreparedStatement ps = con.prepareStatement(str);
		      ps.setInt(1,color_id);
		      ResultSet res = ps.executeQuery();
		      
		      while(res.next()) {
		      result =res.getInt(1);
		      }
		    } catch (SQLException e) {
		      System.out.print(e);
		    }
		  return result;
	}
	
	public int searchBySizes(int size_id) {
		int result=0;
		
		String str="SELECT * FROM product WHERE size_id=?";
		
		  try {
		      PreparedStatement ps = con.prepareStatement(str);
		      ps.setInt(1,size_id);
		      ResultSet res = ps.executeQuery();
		      
		      while(res.next()) {
		      result =res.getInt(1);
		      }
		    } catch (SQLException e) {
		      System.out.print(e);
		    }
		  return result;
	}
	
//	public int getCount() {
//		String sql = "SELECT count(*) FROM employee";
//		return jdbcTemplate.queryForObject(sql, Integer.class);
//	}
//	
	
	
	
}
