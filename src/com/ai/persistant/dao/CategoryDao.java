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
		String sql = "INSERT INTO category (category_id,name,created_date) VALUES (?,?,?)";
		
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1,category.getCategory_id());
			ps.setString(2,category.getName());
			ps.setString(3, category.getCreated_date());
			result=ps.executeUpdate();			
		}catch (SQLException e) {
			System.out.println("Database error");
			e.printStackTrace();
		}
		return result;
		
	}
	
	//update
	public int updateData(CategoryDto dto) {
	    int result = 0;
	    String sql = "UPDATE category SET name=?,created_date=? WHERE category_id=?";

	    try {
	        PreparedStatement ps = con.prepareStatement(sql);
	        ps.setString(1, dto.getName());
	        ps.setString(2, dto.getCreated_date());
	        ps.setInt(3, dto.getCategory_id());
	        result = ps.executeUpdate();
	    } catch (SQLException e) {
	        System.out.println("Database error");
	        e.printStackTrace();
	    }

	    return result;
	}

	
	//delete
	public int deleteData(CategoryDto category) {
		int result=0;
		String sql = "DELETE FROM category where category_id=?";		
		
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1,category.getCategory_id());
			result=ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Database error");
			e.printStackTrace();
		}
		return result;
	}
	//select single book
	public CategoryDto selectOne(CategoryDto category) {
		CategoryDto res = new CategoryDto();
		String sql = "SELECT * from category where category_id=?";
		
		PreparedStatement ps;
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, category.getCategory_id());
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				res.setCategory_id(rs.getInt("category_id"));
				res.setName(rs.getString("name"));	
				res.setCreated_date(rs.getString("created_date"));
			}
		} catch (SQLException e) {
			System.out.println("Database error");
			e.printStackTrace();
		}
		return res;			
	}
	
	//selectAll
	public ArrayList<CategoryDto> selectAll() {
		ArrayList<CategoryDto> list1 = new ArrayList<>();
		String sql = "SELECT * FROM category";
		
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				CategoryDto res = new CategoryDto();
				res.setCategory_id(rs.getInt("category_id"));
				res.setName(rs.getString("name"));
				res.setCreated_date(rs.getString("created_date"));
				list1.add(res);
			}
			
			
		} catch (SQLException e) {
			System.out.println("Database error");
			e.printStackTrace();
		}
		return list1;
	}

	public ArrayList<CategoryDto> selectOne() {
		// TODO Auto-generated method stub
		return null;
	}
		
	}


