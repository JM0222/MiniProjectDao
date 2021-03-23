package pb_book;

// import
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PbookDaoOracleImpl implements PbookDao {
	
	// 접속 코드
	private Connection getConnection() throws SQLException {
		Connection conn = null;
		try {
			// 드라이버 코드
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String dburl = "jdbc:oracle:thin:@localhost:1521:xe";
			conn =DriverManager.getConnection(dburl,"C##JM","1234");
		}catch (ClassNotFoundException e) {
			System.err.println("드라이버 로드 실패");
		}
		return conn;
	}
	
	@Override
	public List<PbookVo> getList() {
		// SQL -> JAVA OBJECT
		List<PbookVo> list = new ArrayList<>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			stmt = conn.createStatement();
			
			String sql = "SELECT id, name, hp, tel FROM phone_book";
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				Long id = rs.getLong(1);
				String name = rs.getString(2);
				String hp = rs.getString(3);
				String tel = rs.getString(4);
				
				// VO Object
				PbookVo vo = new PbookVo(id, name, hp, tel);
				list.add(vo);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				// 자원정리
				rs.close();
				stmt.close();
				conn.close();
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		return list;
	}

	@Override
	public List<PbookVo> search(String keyword) {
		List<PbookVo> list = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			String sql = "SELECT id, name, hp, tel FROM phone_book WHERE name LIKE ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+ keyword +"%");
			rs = pstmt.executeQuery();
			while (rs.next()) {
				PbookVo vo = new PbookVo();
				vo.setId(rs.getLong(1));
				vo.setName(rs.getString(2));
				vo.setHp(rs.getString(3));
				vo.setTel(rs.getString(4));
				
				list.add(vo);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				pstmt.close();
				conn.close();
				
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		return list;
	}

	@Override
	public boolean insert(PbookVo vo) {
		Connection conn = null;
		String sql = "INSERT INTO phone_book VALUES((select max(id) from phone_book)+1,?,?,?)";
		PreparedStatement pstmt= null;
		int insertCnt = 0;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getHp());
			pstmt.setString(3, vo.getTel());
			insertCnt = pstmt.executeUpdate();
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				pstmt.close();
				conn.close();
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		return insertCnt == 1;
	}

	@Override
	public boolean delete(Long id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int deletedCnt = 0;
		try {
			conn = getConnection();
			String sql = "DELETE FROM phone_book WHERE id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setLong(1, id);
			deletedCnt = pstmt.executeUpdate();
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				pstmt.close();
				conn.close();	
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		return deletedCnt == 1;
	}
	
}
