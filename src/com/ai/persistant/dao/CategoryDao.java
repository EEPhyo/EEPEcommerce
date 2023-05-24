package com.ai.persistant.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.ai.persistant.dto.CategoryDto;

@Service("categoryDao")
public class CategoryDao {
    public static Connection con=null;
	
	static {
		con = MyConnection.getConnection();
	}
	
	
	//insert
	public int insertData(CategoryDto category) {
		int result =0;
		String sql = "INSERT INTO category(id,name VALUES (?,?)";
		
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1,category.getId());
			ps.setString(2,category.getName());
			result=ps.executeUpdate();			
		}catch (SQLException e) {
			System.out.println("Database error");
			e.printStackTrace();
		}
		return result;
		
	}
	
	//update
	public int updateData(CategoryDto category) {
		int result =0;
		String sql = "UPDATE category SET name=? WHERE id=?";
		
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setString(1,category.getName());
			result=ps.executeUpdate();			
		}catch (SQLException e) {
			System.out.println("Database error");
		}
		return result;
		
	}
	
	//delete
	public int deleteData(CategoryDto category) {
		int result=0;
		String sql = "DELETE FROM category where id=?";		
		
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1,category.getId());
			result=ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Database error");
		}
		return result;
	}
	//select single book
	public CategoryDto selectOne(CategoryDto category) {
		CategoryDto res = new CategoryDto();
		String sql = "SELECT * from category where id=?";
		
		PreparedStatement ps;
		try {
			ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				rs.getInt("id");
				res.setName(rs.getString("name"));				
			}
		} catch (SQLException e) {
			System.out.println("Database error");
		}
		return res;			
	}
	
	//selectAll
	public ArrayList<CategoryDto> selectAll() {
		ArrayList<CategoryDto> list = new ArrayList<>();
		String sql = "SELECT * FROM category";
		
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				CategoryDto res = new CategoryDto();
				rs.getInt("id");
				res.setName(rs.getString("name"));
			}
			
		} catch (SQLException e) {
			System.out.println("Database error");
		}
		return list;
	}
		
	}


