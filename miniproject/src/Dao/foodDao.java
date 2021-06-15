package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Dto.foodDto;

public class foodDao {
	private static foodDao instance;
	public foodDao() {
		try {
			Class.forName(JDBC_DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static foodDao getInstance() {
		if(instance == null) {
			instance = new foodDao();
		}
		return instance;
	}
	
	private static final String JDBC_DRIVER = "org.mariadb.jdbc.Driver"; // Driver 클래스 풀네임 (JQFN)
	private static final String DB_URL = "jdbc:mysql://localhost:3306/ming?" + "useUnicode=true" + "&characterEncoding=utf8";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "kmk62616261";
	
	private Connection conn;
	private ResultSet rs;
	private PreparedStatement ps;
	
	public foodDto findByfoodname(String foodname){
		String sql = "SELECT * FROM food WHERE foodname = ?";
		foodDto dto = null;
		try {
			conn = getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, foodname);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				dto = new foodDto();
				dto.setFoodno(rs.getInt(1));
				dto.setFoodname(rs.getString(2));
				dto.setStoreno(rs.getInt(3));
				dto.setFoodprice(rs.getInt(4));
				dto.setFoodpicture(rs.getString(5));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(conn, ps, rs);
		}
		return dto;
	}
	public foodDto findByfoodNo(int foodno){
		String sql = "SELECT * FROM food WHERE foodno = ?";
		foodDto dto = null;
		try {
			conn = getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, foodno);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				dto = new foodDto();
				dto.setFoodname(rs.getString(1));
				dto.setStoreno(rs.getInt(2));
				dto.setFoodprice(rs.getInt(3));
				dto.setFoodpicture(rs.getString(4));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(conn, ps, rs);
		}
		return dto;
	}
	
	public int insert(foodDto dto){
		String sql = "INSERT INTO food(foodname, foodprice, foodpicture) "
				+ "VALUES(?, ?, ?)";
		
		int foodno = -1;
		
		try {
			conn = getConnection();
			ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, dto.getFoodname());
			ps.setInt(2, dto.getFoodprice());
			ps.setString(3, dto.getFoodpicture());
			
			
			ps.execute();
			rs = ps.getGeneratedKeys();
			if(rs.next())
				foodno = rs.getInt(1);
			System.out.println("방금 생성된 새 row의 foodno : " + foodno);
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close(conn, ps, rs); 
		}
		return foodno;
	}
	
	public int delete(int foodno){
		String sql = "DELETE FROM food WHERE foodno = ?"; 
		int deletedRow = 0;
		try {
			conn = getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, foodno);
			deletedRow = ps.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close(conn, ps); 
		}
		return deletedRow;
	}
	
	List<foodDto> findAll(){
		String sql = "SELECT * FROM food";
		List<foodDto> list = new ArrayList<>();
		foodDto dto = null;
		
		try {
			conn = getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				dto = new foodDto();
				dto.setFoodno(rs.getInt(1));
				dto.setFoodname(rs.getString(2));
				dto.setStoreno(rs.getInt(3));
				dto.setFoodprice(rs.getInt(4));
				dto.setFoodpicture(rs.getString(5));
				
				list.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(conn, ps, rs);
		}
		return list.isEmpty() ? null : list;
	}
	
	public int update(foodDto dto){ 
		String sql = "UPDATE food SET foodname=?, foodprice=?,foodpicture=?  WHERE foodno = ?";
		int updatedRow = -1;
		try {
			conn = getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, dto.getFoodname());
			ps.setInt(2, dto.getFoodprice());
			ps.setString(3, dto.getFoodpicture());
			
			updatedRow = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(conn, ps);
		}
		return updatedRow;
	}
	
	
	private Connection getConnection() throws SQLException {
		return DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
	}
	
	private void close(Connection conn, PreparedStatement ps) {
		close(conn, ps, null); 
	}
	
	private void close(Connection conn, PreparedStatement ps, ResultSet rs) {
		try {
			if(rs != null) { rs.close(); }
			if(ps != null) { ps.close(); }
			if(conn != null) { conn.close(); }
		} catch(Throwable e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		foodDao dao = foodDao.getInstance();
		foodDto dto = new foodDto();
		dto.setFoodname("음식이름");
		dto.setFoodprice(88);
		dto.setFoodpicture("사진 경로");
		
		dao.insert(dto); 
		
	}


}
