package com.ai.persistant.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import com.ai.model.Login;
import com.ai.model.Role;
import com.ai.model.User;
import com.ai.persistant.dto.RoleDto;
import com.ai.persistant.dto.UserDto;

@Service("userDao")
public class UserDao {
	

	public static Connection con=null;
	
	static {
		con = MyConnection.getConnection();
	}
	
	
	//insert
	public int insertData(UserDto user) {
		int result =0;
		String sql = "INSERT INTO user(uid,name,email,password,phone_number,address,role_id,created_date,updated_date,created_user,updated_user,enabled,locked) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
		
		
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1,user.getUid());
			ps.setString(2,user.getName());
			ps.setString(3, user.getEmail());
			ps.setString(4, user.getPassword());
			ps.setString(5, user.getPhone_number());
			ps.setString(6, user.getAddress());
			ps.setInt(7, user.getRole_id());
			ps.setString(8, user.getCreated_date());
			ps.setString(9, user.getUpdated_date());
			ps.setString(10, user.getCreated_user());
			ps.setString(11, user.getUpdated_user());
			ps.setBoolean(12,user.isEnabled());
			ps.setBoolean(13, user.isLocked());
			result=ps.executeUpdate();			
		}catch (SQLException e) {
			System.out.println("Database error");
			e.printStackTrace();
		}
		return result;
		
	}
	
	//update
	public int updateData(UserDto user) {
		int result =0;
		String sql = "UPDATE user SET name=?,email=?,password=?,phone_number=?,address=?,role_id=?,created_date=?,updated_date=?updated_user=?,enabled=?,locked=? WHERE uid=?";
		
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1,user.getUid());
			ps.setString(2,user.getName());
			ps.setString(3, user.getEmail());
			ps.setString(4, user.getPassword());
			ps.setString(5, user.getPhone_number());
			ps.setString(6, user.getAddress());
			ps.setInt(7, user.getRole_id());
			ps.setString(8, user.getCreated_date());
			ps.setString(9, user.getUpdated_date());
			ps.setString(10, user.getCreated_user());
			ps.setString(11, user.getUpdated_user());
			ps.setBoolean(12,user.isEnabled());
			ps.setBoolean(13, user.isLocked());
			result=ps.executeUpdate();
		}catch (SQLException e) {
			System.out.println("Database error");
		}
		return result;
		
	}
	
	//delete
	public int deleteData(UserDto user) {
		int result=0;
		String sql = "DELETE FROM user where uid=?";		
		
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1,user.getUid());
			result=ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Database error");
		}
		return result;
	}
	//select single 
	public UserDto selectOne(UserDto user) {
		UserDto res = new UserDto();
		String sql = "SELECT * from user where uid=?";
		
		PreparedStatement ps;
		try {
			ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				rs.getInt("uid");
				res.setName(rs.getString("name"));
				res.setEmail(rs.getString("email"));
				res.setPassword(rs.getString("password"));
				res.setPhone_number(rs.getString("phone_number"));
				res.setAddress(rs.getString("address"));
				res.setRole_id(rs.getInt("role_id"));
				res.setCreated_date(rs.getString("created_date"));
				res.setUpdated_date(rs.getString("updated_date"));
				res.setCreated_user(rs.getString("created_user"));
				res.setUpdated_user(rs.getString("updated_user"));
				res.setEnabled(rs.getBoolean("enabled"));
				res.setLocked(rs.getBoolean("locked"));
				
			}
		} catch (SQLException e) {
			System.out.println("Database error");
		}
		return res;			
	}
	
	//selectAll
	public ArrayList<UserDto> selectAll() {
		ArrayList<UserDto> list =new ArrayList<UserDto>();
		String sql = "SELECT * FROM user";
		
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				UserDto res = new UserDto();
				rs.getInt("uid");
				res.setName(rs.getString("name"));
				res.setEmail(rs.getString("email"));
				res.setPassword(rs.getString("password"));
				res.setPhone_number(rs.getString("phone_number"));
				res.setAddress(rs.getString("address"));
				res.setRole_id(rs.getInt("role_id"));
			res.setCreated_date(rs.getString("created_date"));
				res.setUpdated_date(rs.getString("updated_date"));
				res.setCreated_user(rs.getString("created_user"));
				res.setUpdated_user(rs.getString("updated_user"));
				res.setEnabled(rs.getBoolean("enabled"));
				res.setLocked(rs.getBoolean("locked"));
				list.add(res);
			}
	} catch (SQLException e) {
			System.out.println("Database error");
		}
		return list;
	}
	
	//getLogin
	public UserDto getLogin(User user) {
		UserDto res = new UserDto();
		String sql = "SELECT * FROM user WHERE email='user.getEmail()' AND password='user.getPassword()'";
		
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				rs.getInt("uid");
				res.setName(rs.getString("name"));
				res.setEmail(rs.getString("email"));
				res.setPassword(rs.getString("password"));
				res.setPhone_number(rs.getString("phone_number"));
				res.setAddress(rs.getString("address"));
				res.setRole_id(rs.getInt("role_id"));
				res.setCreated_date(rs.getString("created_date"));
				res.setUpdated_date(rs.getString("updated_date"));
				res.setCreated_user(rs.getString("created_user"));
				res.setUpdated_user(rs.getString("updated_user"));
				res.setEnabled(rs.getBoolean("enabled"));
				res.setLocked(rs.getBoolean("locked"));
				}
			
		} catch (SQLException e) {
			System.out.println("Database error");
		}
		return res;
	}


//show list
	public ArrayList<UserDto> User_List() {
		ArrayList<UserDto> list =new ArrayList<UserDto>();
		
		String sql="SELECT u.*,r.role_name AS role_name FROM user u JOIN role r ON u.role_id = r.role_id ORDER BY u.uid DESC";		
		
		 	try {
				PreparedStatement ps = con.prepareStatement(sql);
			    ResultSet rs = ps.executeQuery();
			    while (rs.next()) {
			        UserDto user = new UserDto();
			        user.setUid(rs.getInt("uid"));
			        user.setName(rs.getString("name"));
			        user.setEmail(rs.getString("email"));
			        user.setPhone_number(rs.getString("phone_number"));
			        user.setAddress(rs.getString("address"));
			        user.setRole_id(rs.getInt("role_id"));
			        user.setCreated_date(rs.getString("created_date"));
			        user.setUpdated_date(rs.getString("updated_date"));
			        user.setCreated_user(rs.getString("created_user"));
			        user.setUpdated_user(rs.getString("updated_user"));
			        user.setRole_name(rs.getString("role_name"));
			        list.add(user);
			    }			    
			}catch (SQLException e) {
						e.printStackTrace();
			  
			}			
					return list;
		}

	
	
	
	
	
}
	
	


	

	

