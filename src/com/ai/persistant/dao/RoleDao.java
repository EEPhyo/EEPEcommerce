package com.ai.persistant.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.ai.persistant.dto.RoleDto;
import com.ai.persistant.dto.UserDto;

@Service("roleDao")
public class RoleDao {
	
	

	public static Connection con=null;
	
	static {
		con = MyConnection.getConnection();
	}
	
	//insert
		public int insertData(RoleDto role) {
			int result =0;
			String sql = "INSERT INTO role(id,role_name) VALUES (?,?)";
			
			
			try {
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setInt(1,role.getId());
				ps.setString(2,role.getRole_name());
				
				result=ps.executeUpdate();			
			}catch (SQLException e) {
				System.out.println("Database error");
				e.printStackTrace();
			}
			return result;
			
		}
		
		
		//edit
		public int updateData(RoleDto role) {
			int result =0;
			String sql = "UPDATE role SET role_name=? WHERE id=?";
			
			
			try {
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setInt(1,role.getId());
				ps.setString(2,role.getRole_name());
				
				result=ps.executeUpdate();			
			}catch (SQLException e) {
				System.out.println("Database error");
				e.printStackTrace();
			}
			return result;
			
		}
		
		//delete
		public int deleteData(RoleDto role) {
			int result=0;
			String sql = "DELETE FROM role where id=?";		
			
			try {
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setInt(1,role.getId());
				result=ps.executeUpdate();
			} catch (SQLException e) {
				System.out.println("Database error");
			}
			return result;
		}

		
		public ArrayList<RoleDto> selectRole() {
			ArrayList<RoleDto> list1 =new ArrayList<RoleDto>();
			String sql = "SELECT * FROM role";
			
			try {
				PreparedStatement ps = con.prepareStatement(sql);
			    ResultSet rs = ps.executeQuery();
			    while (rs.next()) {
			    	 RoleDto role = new RoleDto();
				     role.setId(rs.getInt("role_id"));
			         role.setRole_name(rs.getString("role_name"));
			        
			         list1.add(role);
			         
			    }
			   }catch (SQLException e) {
					e.printStackTrace();
		  
				}
			
			return list1;
		}
	
	
}
