package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Dto.storeDto;

public class storeDao {
	private static storeDao instance;
	private storeDao() {
		try {
			Class.forName(JDBC_DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	public static storeDao getInstance() {
		if(instance == null) {
			instance = new storeDao();
		}
		return instance;
	}
	
	private static final String JDBC_DRIVER = "org.mariadb.jdbc.Driver"; 
	private static final String DB_URL = "jdbc:mysql://localhost:3306/ming?" + "useUnicode=true" + "&characterEncoding=utf8";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "kmk62616261";
	
	private Connection conn;
	private ResultSet rs;
	private PreparedStatement ps;
	
	public storeDto findByStoreno(int storeno){
		String sql = "SELECT * FROM store WHERE storeno = ?";
		storeDto dto = null;
		try {
			conn = getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, storeno);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				dto = new storeDto();
				dto.setNo(rs.getInt(1));
				dto.setStoreadress(rs.getString(2));
				dto.setStorename(rs.getString(3));
				dto.setStorenumber(rs.getString(4));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(conn, ps, rs);
		}
		return dto;
	}
	
	int insert(storeDto dto){
		String sql = "INSERT INTO store(storeadress, storename, storenumber) "
				+ "VALUES(?, ?, ?)";
		int storeno = -1;
		try {
			conn = getConnection();
			ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			
			ps.setString(1, dto.getStoreadress());
			ps.setString(2, dto.getStorename());
			ps.setString(3, dto.getStorenumber());
			
			
			ps.execute();
			rs = ps.getGeneratedKeys();
			if(rs.next())
				storeno = rs.getInt(1);
			System.out.println("방금 생성된 새 row의 storeno : " + storeno);
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close(conn, ps, rs); 
		}
		return storeno;
	}
	
	public int delete(int storeno){
		String sql = "DELETE FROM store WHERE storeno = ?"; 
		int deletedRow = 0;
		try {
			conn = getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, storeno);
			deletedRow = ps.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close(conn, ps); 
		}
		return deletedRow;
	}
	
	List<storeDto> findAll(){
		String sql = "SELECT * FROM store";
		List<storeDto> list = new ArrayList<>();
		storeDto dto = null;
		
		try {
			conn = getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				dto = new storeDto();
				dto.setStoreadress(rs.getString(2));
				dto.setStorename(rs.getString(3));
				dto.setStorenumber(rs.getString(4));
				list.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(conn, ps, rs);
		}
		return list.isEmpty() ? null : list;
	}
	
	public int update(storeDto dto){ 
		
		String sql = "UPDATE store SET  storeadress=?, storename=?, storenumber=? WHERE storeno = ?";
		int updatedRow = -1;
		try {
			conn = getConnection();
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, dto.getStoreadress());
			ps.setString(2, dto.getStorename());
			ps.setString(3, dto.getStorenumber());
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
		storeDao dao = storeDao.getInstance();
		storeDto dto = new storeDto();
		dto.setStoreadress("신촌");
		dto.setStorename("반찬가게");
		dto.setStorenumber("02-55-555");
		dao.insert(dto); 
		
	}
}



	



