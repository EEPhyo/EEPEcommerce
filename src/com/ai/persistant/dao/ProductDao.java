package com.ai.persistant.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.ai.model.Product;
import com.ai.persistant.dto.ProductDto;

@Service("productDao")
public class ProductDao {
public static Connection con=null;
	
	static {
		con = MyConnection.getConnection();
	}
	
	
	//insert
	public int insertData(ProductDto product) {
		int result =0;
		String sql = "INSERT INTO user(id,name,description,image,quantity,price,is_stock,is_deleted) VALUES (?,?,?,?,?,?,?,?)";
		
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1,product.getId());
			ps.setString(2,product.getName());
			ps.setString(3, product.getDescription());
			ps.setString(4, product.getImage());
			ps.setString(5, product.getQuantity());
			ps.setDouble(6, product.getPrice());
			ps.setBoolean(7,product.isIs_stock());
			ps.setBoolean(8, product.isIs_deleted());
			result=ps.executeUpdate();			
		}catch (SQLException e) {
			System.out.println("Database error");
			e.printStackTrace();
		}
		return result;
		
	}
	
	//update
	public int updateData(ProductDto product) {
		int result =0;
		String sql = "UPDATE user SET name=?,email=?,description=?,image=?,quantity=?,price=?,is_stock=?,is_deleted=? WHERE id=?";
		
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setString(1,product.getName());
			ps.setString(2, product.getDescription());
			ps.setString(3, product.getImage());
			ps.setString(4, product.getQuantity());
			ps.setDouble(5, product.getPrice());
			ps.setBoolean(6,product.isIs_stock());
			ps.setBoolean(7, product.isIs_deleted());
			result=ps.executeUpdate();			
		}catch (SQLException e) {
			System.out.println("Database error");
		}
		return result;
		
	}
	
	//delete
	public int deleteData(ProductDto product) {
		int result=0;
		String sql = "DELETE FROM user where id=?";		
		
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1,product.getId());
			result=ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Database error");
		}
		return result;
	}
	//select single book
	public ProductDto selectOne(ProductDto user) {
		ProductDto res = new ProductDto();
		String sql = "SELECT * from user where id=?";
		
		PreparedStatement ps;
		try {
			ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				rs.getInt("id");
				res.setName(rs.getString("name"));
				res.setDescription(rs.getString("description"));
				res.setImage(rs.getString("image"));	
				res.setQuantity(rs.getString("quantity"));
				res.setPrice(rs.getDouble("price"));
				res.setIs_stock(rs.getBoolean("is_stock"));
				res.setIs_deleted(rs.getBoolean("is_deleted"));
				
			}
		} catch (SQLException e) {
			System.out.println("Database error");
		}
		return res;			
	}
	
	//selectAll
	public ArrayList<ProductDto> selectAll() {
		ArrayList<ProductDto> list = new ArrayList<>();
		String sql = "SELECT * FROM user";
		
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				ProductDto res = new ProductDto();
				rs.getInt("id");
				res.setName(rs.getString("name"));
				res.setDescription(rs.getString("description"));
				res.setImage(rs.getString("image"));	
				res.setQuantity(rs.getString("quantity"));
				res.setPrice(rs.getDouble("price"));
				res.setIs_stock(rs.getBoolean("is_stock"));
				res.setIs_deleted(rs.getBoolean("is_deleted"));
			}
			
		} catch (SQLException e) {
			System.out.println("Database error");
		}
		return list;
	}

	public void addProduct(Product product) {
		// TODO Auto-generated method stub
		
	}
		
	}
