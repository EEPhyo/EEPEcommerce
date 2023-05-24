package com.ai.persistant.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.ai.persistant.dto.ColorDto;

@Service("colorDao")
public class ColorDao {
	 public static Connection con=null;
		
		static {
			con = MyConnection.getConnection();
		}
		
		
		//insert
		public int insertData(ColorDto color) {
			int result =0;
			String sql = "INSERT INTO color(id,name,code VALUES (?,?,?)";
			
			try {
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setInt(1,color.getId());
				ps.setString(2,color.getName());
				ps.setString(3,color.getCode() );
				result=ps.executeUpdate();			
			}catch (SQLException e) {
				System.out.println("Database error");
				e.printStackTrace();
			}
			return result;
			
		}
		
		//update
		public int updateData(ColorDto color) {
			int result =0;
			String sql = "UPDATE color SET name=?,code=? WHERE id=?";
			
			try {
				PreparedStatement ps = con.prepareStatement(sql);
				
				ps.setString(1,color.getName());
				ps.setString(2, color.getCode());
				result=ps.executeUpdate();			
			}catch (SQLException e) {
				System.out.println("Database error");
			}
			return result;
			
		}
		
		//delete
		public int deleteData(ColorDto color) {
			int result=0;
			String sql = "DELETE FROM color where id=?";		
			
			try {
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setInt(1,color.getId());
				result=ps.executeUpdate();
			} catch (SQLException e) {
				System.out.println("Database error");
			}
			return result;
		}
		//select single book
		public ColorDto selectOne(ColorDto color) {
			ColorDto res = new ColorDto();
			String sql = "SELECT * from color where id=?";
			
			PreparedStatement ps;
			try {
				ps = con.prepareStatement(sql);
				ResultSet rs = ps.executeQuery();
				while(rs.next()) {
					rs.getInt("id");
					res.setName(rs.getString("name"));
					res.setCode(rs.getString("code"));
				}
			} catch (SQLException e) {
				System.out.println("Database error");
			}
			return res;			
		}
		
		//selectAll
		public ArrayList<ColorDto> selectAll() {
			ArrayList<ColorDto> list = new ArrayList();
			String sql = "SELECT * FROM color";
			
			try {
				PreparedStatement ps = con.prepareStatement(sql);
				ResultSet rs=ps.executeQuery();
				while(rs.next()) {
					ColorDto res = new ColorDto();
					rs.getInt("id");
					res.setName(rs.getString("name"));
					res.setCode(rs.getString("code"));
				}
				
			} catch (SQLException e) {
				System.out.println("Database error");
			}
			return list;
		}
			
		}

