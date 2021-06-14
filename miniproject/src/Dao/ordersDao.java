package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Dto.ordersDto;

public class ordersDao {
	private static ordersDao instance;
	private ordersDao() {
		try {
			Class.forName(JDBC_DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	public static ordersDao getInstance() {
		if(instance == null) {
			instance = new ordersDao();
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
	
	public ordersDto findByOrderno(int orderno){
		String sql = "SELECT * FROM orders WHERE orderno = ?";
		ordersDto dto = null;
		try {
			conn = getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, orderno);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				dto = new ordersDto();
				dto.setFoodno(rs.getInt(1));
				dto.setNo(rs.getInt(1));
				dto.setOrderdata(rs.getString(3));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(conn, ps, rs);
		}
		return dto;
}
	public int insert(ordersDto dto){

		String sql = "INSERT INTO orders (orderdata) VALUES (?)";
				
		int orderno = -1;
		try {
			conn = getConnection();
			ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, dto.getOrderdata());
			ps.execute();
			rs = ps.getGeneratedKeys();
			if(rs.next())
				orderno = rs.getInt(1);
			System.out.println("방금 생성된 새 row의 orderno : " + orderno);
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close(conn, ps, rs); 
		}
		return orderno;
	}
	
	public int delete(int orderno){
		String sql = "DELETE FROM orderno WHERE orderno = ?"; 
		int deletedRow = 0;
		try {
			conn = getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, orderno);
			deletedRow = ps.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close(conn, ps); 
		}
		return deletedRow;}


		List<ordersDto> findAll(){
			String sql = "SELECT * FROM orders";
			List<ordersDto> list = new ArrayList<>();
			ordersDto dto = null;
			
			try {
				conn = getConnection();
				ps = conn.prepareStatement(sql);
				rs = ps.executeQuery();
				
				while(rs.next()) {
					dto = new ordersDto();
					dto.setOrderno(rs.getInt(1));
					dto.setFoodno(rs.getInt(2));
					dto.setNo(rs.getInt(3));
					dto.setOrderdata(rs.getString(4));
					
					list.add(dto);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				close(conn, ps, rs);
			}
			return list.isEmpty() ? null : list;
		}
		
		public int update(ordersDto dto){ 
		
			String sql = "UPDATE orders SET orderdata=? WHERE orderno = ?";
			int updatedRow = -1;
			try {
				conn = getConnection();
				ps = conn.prepareStatement(sql);
				ps.setString(1, dto.getOrderdata());
				
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
			ordersDao dao = ordersDao.getInstance();
			ordersDto dto = new ordersDto();
			dto.setOrderdata("주문날짜");
			
			dao.insert(dto); 
			
		}
	}

	
