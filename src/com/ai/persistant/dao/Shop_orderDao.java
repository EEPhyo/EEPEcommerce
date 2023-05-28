package com.ai.persistant.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.ai.persistant.dto.Shop_orderDto;


@Service("shop_orderDao")
public class Shop_orderDao {
public static Connection con=null;
	
	static {
		con = MyConnection.getConnection();
	}
	
	
	//insert
	public int insertData(Shop_orderDto order) {
		int result =0;
		String sql = "INSERT INTO user(id,order_date,order_total,order_status,total_price) VALUES (?,?,?,?,?)";
		
		
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1,order.getId());
			ps.setString(2,order.getOrder_date());
			ps.setDouble(3, order.getOrder_total());
			ps.setString(4, order.getOrder_status());
			ps.setDouble(5, order.getTotal_price());
			result=ps.executeUpdate();			
		}catch (SQLException e) {
			System.out.println("Database error");
			e.printStackTrace();
		}
		return result;
		
	}
	
	//update
	public int updateData(Shop_orderDto order) {
		int result =0;
		String sql = "UPDATE user SET name=?,order_date=?,order_total=?,order_status=?,total_price=? WHERE id=?";
		
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1,order.getId());
			ps.setString(2,order.getOrder_date());
			ps.setDouble(3, order.getOrder_total());
			ps.setString(4, order.getOrder_status());
			ps.setDouble(5, order.getTotal_price());
			result=ps.executeUpdate();
		}catch (SQLException e) {
			System.out.println("Database error");
		}
		return result;
		
	}
	
	//delete
	public int deleteData(Shop_orderDto order) {
		int result=0;
		String sql = "DELETE FROM user where id=?";		
		
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1,order.getId());
			result=ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Database error");
		}
		return result;
	}
	//select single 
	public Shop_orderDto selectOne(Shop_orderDto order) {
		Shop_orderDto res = new Shop_orderDto();
		String sql = "SELECT * from user where id=?";
		
		PreparedStatement ps;
		try {
			ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				rs.getInt("id");
				res.setOrder_date(rs.getString("order_date"));
				res.setOrder_total(rs.getDouble("order_total"));
				res.setOrder_status(rs.getString("order_status"));
				res.setTotal_price(rs.getDouble("total_price"));
			}
		} catch (SQLException e) {
			System.out.println("Database error");
		}
		return res;			
	}
	
	//selectAll
	public ArrayList<Shop_orderDto> selectAll() {
		ArrayList<Shop_orderDto> list =new ArrayList<Shop_orderDto>();
		String sql = "SELECT * FROM shop_order";
		
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				Shop_orderDto res = new Shop_orderDto();
				rs.getInt("id");
				res.setOrder_date(rs.getString("order_date"));
				res.setOrder_total(rs.getDouble("order_total"));
				res.setOrder_status(rs.getString("order_status"));
				res.setTotal_price(rs.getDouble("total_price"));
				list.add(res);
			}
			
		} catch (SQLException e) {
			System.out.println("Database error");
		}
		return list;
	}
	
}
	
