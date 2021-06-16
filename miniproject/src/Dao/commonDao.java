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
import util.DatabaseUtil;

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
		if (instance == null) {
			instance = new commonDao();
		}
		return instance;
	}

	private static final String JDBC_DRIVER = "org.mariadb.jdbc.Driver";
	private static final String DB_URL = "jdbc:mysql://localhost:3306/ming?" + "useUnicode=true"
			+ "&characterEncoding=utf8";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "kmk62616261";

	private Connection conn = null;
	private ResultSet rs = null;
	private PreparedStatement ps =null;

	public commonDto findById(String id) {
		String sql = "SELECT * FROM common WHERE id = ?";
		commonDto dto = null;
		try {
			conn = getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();

			if (rs.next()) {
				dto = new commonDto();
				dto.setNo(rs.getInt(1));
				dto.setName(rs.getString(2));
				dto.setId(rs.getString(3));
				dto.setPassword(rs.getString(4));
				dto.setPhone(rs.getString(5));
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
	
	public commonDto findByNo(int no) {
		String sql = "SELECT * FROM common WHERE no = ?";
		commonDto dto = null;
		try {
			conn = getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, no);
			rs = ps.executeQuery();

			if (rs.next()) {
				dto = new commonDto();
				dto.setNo(rs.getInt(1));
				dto.setName(rs.getString(2));
				dto.setId(rs.getString(3));
				dto.setPassword(rs.getString(4));
				dto.setPhone(rs.getString(5));
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

	public int insert(commonDto dto) {
		String sql = "INSERT INTO common(name,id, password,phone, zip,adress, adress_detail, type) "
				+ "VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
		int no = -1;
		try {
			conn = DatabaseUtil.getConnection();
			ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, dto.getName());
			ps.setString(2, dto.getId());
			ps.setString(3, dto.getPassword());
			ps.setString(4, dto.getPhone());
			ps.setString(5, dto.getZip());
			ps.setString(6, dto.getAdress());
			ps.setString(7, dto.getAdress_detail());
			ps.setInt(8, dto.getType());

			ps.execute();
			rs = ps.getGeneratedKeys();
			if (rs.next())
				no = rs.getInt(1);
			System.out.println("방금 생성된 새 row의 no : " + no);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(conn, ps, rs);
		}
		return no;
	}

	List<commonDto> findAll() {
		String sql = "SELECT * FROM common";
		List<commonDto> list = new ArrayList<>();
		commonDto dto = null;

		try {
			conn = getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				dto = new commonDto();
				dto.setNo(rs.getInt(1));
				dto.setName(rs.getString(2));
				dto.setId(rs.getString(3));
				dto.setPassword(rs.getString(4));
				dto.setPhone(rs.getString(5));
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

	public int update(commonDto dto) {

		String sql = "UPDATE common SET no=?, name=?, id=?, password=?, phone=?, zip=?, adress=?, adress_detail=?. type=? WHERE id = ?";
		int updatedRow = -1;
		try {
			conn =DatabaseUtil.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, dto.getNo());
			ps.setString(2, dto.getName());
			ps.setString(3, dto.getId());
			ps.setString(4, dto.getPassword());
			ps.setString(5, dto.getPhone());
			ps.setString(6, dto.getZip());
			ps.setString(7, dto.getAdress());
			ps.setString(8, dto.getAdress_detail());
			ps.setInt(9, dto.getType());

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
			if (rs != null) {
				rs.close();
			}
			if (ps != null) {
				ps.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

	public int loginCheck(String userID, String userPassword) {
		try {
			conn = DatabaseUtil.getConnection();
			ps = conn.prepareStatement("SELECT * FROM COMMON WHERE id = ?");
			ps.setString(1, userID);
			rs = ps.executeQuery();
			if (rs.next()) {
				if (rs.getString("password").contentEquals(userPassword)) {
					return 1; // 로그인 성공
				}
				else {
					return 0; // 비밀번호 불일치
				}
			} else {
				return -1;// 아이디 불일치
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return -2; //db오류

	}

	public int delete(String id) {
		String sql = "DELETE FROM common WHERE id = ?";
		int deletedRow = 0;
		try {
			conn = getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			deletedRow = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(conn, ps);
		}
		return deletedRow;
	}

	

	public static void main(String[] args) {
//		CommonDao dao = CommonDao.getInstance();
//		CommonDto dto = new CommonDto();
//		dto.setName("김김김");
//		dto.setId("kimkimkim");
//		dto.setPassword("12df456");
//		dto.setPhoneNumber("010-555-555");
//		dto.setZip("우편번호");
//		dto.setAdress("서울 특별시");
//		dto.setAdress_detail("무슨무슨 아파트");
//		dto.setType(0);
//		dao.insert(dto);

	}

}