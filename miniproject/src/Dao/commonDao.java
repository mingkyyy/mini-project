package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Dto.commonDto;

public class commonDao {
	
	private static commonDao instance;
	private commonDao() {
		try {
			Class.forName(JDBC_DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	public static commonDao getInstance() {
		if(instance == null) {
			instance = new commonDao();
		}
		return instance;
	}
	
	private static final String JDBC_DRIVER = "org.mariadb.jdbc.Driver";
	private static final String DB_URL = "jdbc:mysql://localhost:3306/common?" + "useUnicode=true" + "&characterEncoding=utf8";
	
	private static final String USERNAME = "root";
	private static final String PASSWORD = "kmk62616261";
	
	private Connection conn;
	private ResultSet rs;
	private PreparedStatement ps;
	
	
	public commonDto findByNo(int no){ //회원번호 기준으로 회원들 정보 조회
		String sql = "SELECT * FROM common WHERE no = ?";
		commonDto dto = null;
		try {
			conn = getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, no);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				dto = new commonDto();
				dto.setNo(rs.getInt(1));
				dto.setName(rs.getString(2));
				dto.setId(rs.getString(3));
				dto.setPassword(rs.getString(4));
				dto.setPhonenumber(rs.getString(5));
				dto.setZip(rs.getString(6));
				dto.setAdress(rs.getString(7));
				dto.setAdress_detail(rs.getString(8));
				dto.setType(rs.getInt(9));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(conn, ps, rs);
		}
		return dto;
	}
	
	int insert(commonDto dto){ //삽입 
		String sql = "INSERT INTO common(name, id, password, Phonenumber, zip, adress,adress_detail,type) "
				+ "VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
		int no = -1;
		try {
			conn = getConnection();
			ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, dto.getName());
			ps.setString(2, dto.getId());
			ps.setString(3, dto.getPassword());
			ps.setString(4, dto.getPhonenumber());
			ps.setString(5, dto.getZip());
			ps.setString(6, dto.getAdress());
			ps.setString(7, dto.getAdress_detail());
			ps.setInt(8, dto.getType());
			
			ps.execute();
			rs = ps.getGeneratedKeys();
			if(rs.next())
				no = rs.getInt(1);
			System.out.println("방금 생성된 새 row의 no : " + no);
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close(conn, ps, rs); 
		}
		return no;
	}
	
	public int delete(int no){
		String sql = "DELETE FROM common WHERE no = ?"; 
		int deletedRow = 0;
		try {
			conn = getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, no);
			deletedRow = ps.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close(conn, ps); 
		}
		return deletedRow;
	}
	
	List<commonDto> findAll(){ //모든 정보 찾기
		String sql = "SELECT * FROM common";
		List<commonDto> list = new ArrayList<>();
		commonDto dto = null;
		
		try {
			conn = getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				dto = new commonDto();
				dto.setNo(rs.getInt(1));
				dto.setName(rs.getString(2));
				dto.setId(rs.getString(3));
				dto.setPassword(rs.getString(4));
				dto.setPhonenumber(rs.getString(5));
				dto.setZip(rs.getString(6));
				dto.setAdress(rs.getString(7));
				dto.setAdress_detail(rs.getString(8));
				dto.setType(rs.getInt(9));
				list.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(conn, ps, rs);
		}
		return list.isEmpty() ? null : list;
	}
	
	public int update(commonDto dto){ 
		// dto의 no번 현재 dto에 담겨있는 모든 정보로 레코드를 수정
		String sql = "UPDATE common SET name=?, Id=?, password=?, Phonenumber=?, Zip=?, Adress=? ,Adress_detail=?, Type=? WHERE no = ?";
		int updatedRow = -1;
		try {
			conn = getConnection();
			ps.setString(1, dto.getName());
			ps.setString(2, dto.getId());
			ps.setString(3, dto.getPassword());
			ps.setString(4, dto.getPhonenumber());
			ps.setString(5, dto.getZip());
			ps.setString(6, dto.getAdress());
			ps.setString(7, dto.getAdress_detail());
			ps.setInt(8, dto.getType());
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
		commonDao dao = commonDao.getInstance();
		commonDto dto = new commonDto();
		dto.setName("홍길동");
		dto.setId("88");
		dto.setPassword("78");
		dto.setPhonenumber("010-5319-9999");
		dto.setZip("우편번호");
		dto.setAdress("어쩌구저저구 아파트");
		dto.setAdress_detail("101동 101호");
		dto.setType(1);
		dao.insert(dto);
		
	}
	

}
