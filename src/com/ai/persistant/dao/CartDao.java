package com.ai.persistant.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.ai.persistant.dto.CartDto;
import com.ai.persistant.dto.CategoryDto;
import com.mysql.cj.protocol.Resultset;

@Service("cartDao")
public class CartDao {
public static Connection con=null;
	
	static {
		con = MyConnection.getConnection();
	}
	
	public int insertData(CartDto cart_dto) {
		int result = 0;
		String sql = "insert into shopping_cart (sc_id,p_id,user_id,price,quantity,total_price) " + "values (?,?,?,?,?,?)";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, cart_dto.getSc_id());
			ps.setInt(2, cart_dto.getP_id());
			ps.setInt(3, cart_dto.getUser_id());
			ps.setDouble(4, cart_dto.getPrice());
			ps.setInt(5, cart_dto.getQuantity());
			ps.setDouble(6, cart_dto.getTotal_price());
			result = ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Data base error Insert" + e);
			e.printStackTrace();
		}
		return result;
	}
	
	public int updateData (CartDto cart_dto) {
		int result=0;
		String sql = "update into shopping_cart (p_id=?,user_id=?,price=?,quantiy=?,total+price=?) " + "where sc_id=?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, cart_dto.getP_id());
			ps.setInt(2, cart_dto.getUser_id());
			ps.setDouble(3, cart_dto.getPrice());
			ps.setInt(4, cart_dto.getQuantity());
			ps.setDouble(5, cart_dto.getTotal_price());
			
			result = ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Data base error update");
			e.printStackTrace();
		}

		return result;
		
	}

	public int deleteData(int id) {
		int result = 0;
		String sql = "update shopping_cart set remove=? where sc_id=?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, "TRUE");
			ps.setInt(2, id);
			result = ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Data base delete error " + e);
		}
		return result;
	}
	
	public CartDto selectOne(CartDto cart_dto) {
		CartDto res = new CartDto();
		String sql = "SELECT * from shopping_cart where sc_id=?";
		
		PreparedStatement ps;
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, cart_dto.getSc_id());
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				res.setSc_id(rs.getInt("sc_id"));
				res.setP_id(rs.getInt("p_id"));
				res.setUser_id(rs.getInt("user_id"));
				res.setPrice(rs.getDouble("price"));
				res.setQuantity(rs.getInt("quantity"));
				res.setTotal_price(rs.getDouble("total_price"));
			}
		} catch (SQLException e) {
			System.out.println("Database select error ");
			e.printStackTrace();
		}
		return res;			
	}
	
	public ArrayList<CartDto>selectAll(int Id){
		ArrayList<CartDto>list=new ArrayList<>();
		String sql="SELECT * from shopping_cart";
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1, Id);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				CartDto res = new CartDto();
				res.setSc_id(rs.getInt("sc_id"));
				res.setP_id(rs.getInt("p_id"));
				res.setUser_id(rs.getInt("user_id"));
				res.setPrice(rs.getDouble("price"));
				res.setQuantity(rs.getInt("quantity"));
				res.setTotal_price(rs.getDouble("total_price"));
				list.add(res);
		  	}
			
	    	}catch (SQLException e) {
	    		System.out.println("Database error");
				e.printStackTrace();
			}
			return list;
		}
	
	public ArrayList<Double> selectAllPrice(int Id) {
		ArrayList<Double> list = new ArrayList<>();
		String sql = "select * from shopping_cart where user_id=? AND remove IS NULL";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, Id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				double price =  rs.getDouble("price");
				list.add(price);
				
			}
		} catch (SQLException e) {
			System.out.println("Database Error new " + e);
		}
		return list;
	}
	
	
	


	
}