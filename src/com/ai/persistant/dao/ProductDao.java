package com.ai.persistant.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import com.ai.model.Product;
import com.ai.persistant.dto.ProductDto;

@Service("productDao")
public class ProductDao {
	JdbcTemplate template;    
	 
public static Connection con=null;
	
	static {
		con = MyConnection.getConnection();
	}
	
	
	//insert
	public int insertData(ProductDto product) {
		int result =0;
		String sql = "INSERT INTO product (id,category_id,color_id,size_id,name,description,image,quantity,price,is_stock) VALUES (?,?,?,?,?,?,?,?,?,?)";
		
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1,product.getId());
			ps.setInt(2,product.getCategory_id() );
			ps.setInt(3, product.getColor_id());
			ps.setInt(4, product.getSize_id());
			ps.setString(5,product.getName());
			ps.setString(6, product.getDescription());
			ps.setString(7, product.getImage());
			ps.setLong(8, product.getQuantity());
			ps.setDouble(9, product.getPrice());
			ps.setInt(10,product.getIs_stock());
//			ps.setBoolean(11, product.getIs_deleted());
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
		String sql = "UPDATE product SET name=?,category_id=?,color_id=?,size_id=?,description=?,image=?,quantity=?,price=?,is_stock=? WHERE id=?";
		
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setString(1,product.getName());
			ps.setInt(2, product.getCategory_id());
			ps.setInt(3, product.getColor_id());
			ps.setInt(4, product.getSize_id());
			ps.setString(5, product.getDescription());
			ps.setString(6, product.getImage());
			ps.setInt(7, product.getQuantity());
			ps.setDouble(8, product.getPrice());
			ps.setInt(9,product.getIs_stock());
			ps.setInt(10, product.getId());
//			ps.setBoolean(10, product.getIs_deleted());
			result=ps.executeUpdate();			
		}catch (SQLException e) {
			System.out.println("Database error");
			e.printStackTrace();
		}
		return result;
		
	}
	
	//delete
	public int deleteData(ProductDto product) {
		int result=0;
		String sql = "DELETE FROM product where id=?";		
		
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1,product.getId());
			result=ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Database error");
			e.printStackTrace();
		}
		return result;
	}
	
	//select single book
	public ProductDto selectOne(ProductDto dto) {
		ProductDto res = new ProductDto();
		String sql = "SELECT * from product where id=?";
		
		PreparedStatement ps;
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, dto.getId());
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				res.setId(rs.getInt("id"));
				res.setName(rs.getString("name"));
				res.setCategory_id(rs.getInt("category_id"));
				res.setColor_id(rs.getInt("color_id"));
				res.setSize_id(rs.getInt("size_id"));				
				res.setDescription(rs.getString("description"));
				res.setImage(rs.getString("image"));	
				res.setQuantity(rs.getInt("quantity"));
				res.setPrice(rs.getDouble("price"));
				res.setIs_stock(rs.getInt("is_stock"));
//				res.setIs_deleted(rs.getBoolean("is_deleted"));
				
			}
		} catch (SQLException e) {
			System.out.println("Database error");
			e.printStackTrace();
		}
		return res;			
	}
	
	//selectAll
	public ArrayList<ProductDto> selectAll() {
	    ArrayList<ProductDto> list = new ArrayList<>();
	    String sql = "SELECT p.*, c.name AS color_name, s.value AS size_value, cat.name AS category_name " +
                "FROM product p " +
                "JOIN color c ON p.color_id = c.color_id " +
                "JOIN size s ON p.size_id = s.size_id " +
                "JOIN category cat ON p.category_id = cat.category_id " +
                "ORDER BY p.id DESC";

	    try {
	        PreparedStatement ps = con.prepareStatement(sql);
	        ResultSet rs = ps.executeQuery();
	        while (rs.next()) {
	            ProductDto res = new ProductDto();
	            res.setId(rs.getInt("id"));
	            res.setName(rs.getString("name"));
	            res.setCategory_id(rs.getInt("category_id"));
	            res.setColor_id(rs.getInt("color_id"));
	            res.setSize_id(rs.getInt("size_id"));
	            res.setDescription(rs.getString("description"));
	            res.setImage(rs.getString("image"));
	            res.setQuantity(rs.getInt("quantity"));
	            res.setPrice(rs.getDouble("price"));
	            res.setIs_stock(rs.getInt("is_stock"));
	            res.setColor_name(rs.getString("color_name"));
	            res.setSize_value(rs.getString("size_value"));
	            res.setCategory_name(rs.getString("category_name"));
	            list.add(res);
	        }
	    } catch (SQLException e) {
	        System.out.println("Database error: " + e.getMessage());
	    }
	    return list;
	}	
	
	
	public void setTemplate(JdbcTemplate template) {    
	    this.template = template;    
	}    
	    
	public List<ProductDto> getProductByPage(int pageid,int total){    
	    String sql="select * from emp limit "+(pageid-1)+","+total;    
	    return template.query(sql,new RowMapper<ProductDto>(){    
	        public ProductDto mapRow(ResultSet rs, int row) throws SQLException {    
	            ProductDto res=new ProductDto();    
	            res.setId(rs.getInt(1));    
	            res.setName(rs.getString(2));    
	            res.setCategory_id(rs.getInt(2));
	            res.setColor_id(rs.getInt(3));
	            res.setSize_id(rs.getInt(4));
	            res.setDescription(rs.getString(5));
	            res.setImage(rs.getString(6));
	            res.setQuantity(rs.getInt(7));
	            res.setPrice(rs.getDouble(8));
	            res.setIs_stock(rs.getInt(9));
	            res.setColor_name(rs.getString(10));
	            res.setSize_value(rs.getString(11));
	            res.setCategory_name(rs.getString(12));
	            return res;    
	        }    
	    });    
	}    
	
	
}

