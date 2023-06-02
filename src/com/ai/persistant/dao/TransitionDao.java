package com.ai.persistant.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ai.model.Transition;
import com.ai.persistant.dto.TransitionDto;
import com.ai.persistant.dto.UserDto;



public class TransitionDao {
public static Connection con=null;
	
	static {
		con = MyConnection.getConnection();
	}
	
	
	//insert
	public int insertData(TransitionDto transition) {
		int result =0;
		String sql = "INSERT INTO user(id,created_date,receive_account,transition_proof,) VALUES (?,?,?,?)";
		
		
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1,transition.getId());
			ps.setString(2,transition.getCreated_date());
			ps.setString(3, transition.getReceive_account());
			ps.setString(4, transition.getTransition_proof());
			result=ps.executeUpdate();			
		}catch (SQLException e) {
			System.out.println("Database error");
			e.printStackTrace();
		}
		return result;
		
	}
	
	//update
	public int updateData(TransitionDto transition) {
		int result =0;
		String sql = "UPDATE user SET name=?,created_date=?,receive_account=?,transition_proof=? WHERE id=?";
		
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1,transition.getCreated_date());
			ps.setString(2, transition.getReceive_account());
			ps.setString(3, transition.getTransition_proof());
			result=ps.executeUpdate();
		}catch (SQLException e) {
			System.out.println("Database error");
		}
		return result;
		
	}
	
	//delete
	public int deleteData(TransitionDto transition) {
		int result=0;
		String sql = "DELETE FROM user where id=?";		
		
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1,transition.getId());
			result=ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Database error");
		}
		return result;
	}
	//select single 
	public TransitionDto selectOne(TransitionDto user) {
		TransitionDto res = new TransitionDto();
		String sql = "SELECT * from user where id=?";
		
		PreparedStatement ps;
		try {
			ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				rs.getInt("id");
				res.setCreated_date(rs.getString("created_date"));
				res.setReceive_account(rs.getString("receive_account"));
				res.setTransition_proof(rs.getString("transition_proof"));
				
			}
		} catch (SQLException e) {
			System.out.println("Database error");
		}
		return res;			
	}
	
	//selectAll
	public ArrayList<TransitionDto> selectAll() {
		ArrayList<TransitionDto> list =new ArrayList<TransitionDto>();
		String sql = "SELECT * FROM user";
		
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				TransitionDto res = new TransitionDto();
				rs.getInt("id");
				res.setCreated_date(rs.getString("created_date"));
				res.setReceive_account(rs.getString("receive_account"));
				res.setTransition_proof(rs.getString("transition_proof"));
				list.add(res);
			}
			
		} catch (SQLException e) {
			System.out.println("Database error");
		}
		return list;
	}
	
	//getLogin
	public TransitionDto getLogin(Transition transition) {
		TransitionDto res = new TransitionDto();
		String sql = "SELECT * FROM user WHERE email='user.getEmail()' AND password='user.getPassword()'";
		
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				rs.getInt("id");
				res.setCreated_date(rs.getString("created_date"));
				res.setReceive_account(rs.getString("receive_account"));
				res.setTransition_proof(rs.getString("transition_proof"));
				}
			
		} catch (SQLException e) {
			System.out.println("Database error");
		}
		return res;
	}
}
