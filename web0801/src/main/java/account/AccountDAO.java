package account;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import util.JDBCUtil;

public class AccountDAO {
	// JDBC 관련 변수 
	private Connection conn = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;
	
	private String BOARD_LIST = "select * from board";
	private String BOARD_ONE = "select * from board where num = ?";
	private String BOARD_INSERT = "insert into board(writer, title, content, regtime, hits) values(?,?,?,now(),0)";
	private String BOARD_DELETE = "delete from board where num = ?";
	private String BOARD_UPDATE = "update board set writer = ?, title = ?, content = ?, regtime = now() where num = ?";
	
	//게시판 등록
	public void insertBoard(AccountDTO dto) {
		conn = JDBCUtil.getConnection();
		try {
			stmt = conn.prepareStatement(BOARD_INSERT);
			stmt.setString(1, dto.getName());
			stmt.setString(2, dto.getSsn());
			stmt.setString(3, dto.getTel());
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(stmt, conn);
		}
	}
	
	//게시판 삭제
	public void deleteBoard(int num) {
        conn = JDBCUtil.getConnection();
        try {
            stmt = conn.prepareStatement(BOARD_DELETE);
            stmt.setInt(1, num);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(stmt, conn);
        }
    }
	
	// 게시글 수정
    public void updateBoard(AccountDTO dto) {
        conn = JDBCUtil.getConnection();
        try {
            stmt = conn.prepareStatement(BOARD_UPDATE);
            stmt.setString(1, dto.getName());
            stmt.setString(2, dto.getSsn());
            stmt.setString(3, dto.getTel());
            stmt.setInt(4, dto.getBalance());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(stmt, conn);
        }
    }
	
	// view.jsp를 위한 게시판 1건 조회
	public AccountDTO getOne(int num) {
		AccountDTO dto = null;
		conn = JDBCUtil.getConnection();
		try {
			stmt = conn.prepareStatement(BOARD_ONE);
			stmt.setInt(1, num);
			rs = stmt.executeQuery();
			if (rs.next()) {
				dto = new AccountDTO(rs.getInt("num"), rs.getString("writer"),
						rs.getString("title"), rs.getString("content"),
						rs.getInt("hits"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, stmt, conn);
		}
		return dto;
	}
	
	//게시판 목록 조회
	public List<AccountDTO> getBoardList() {
		List<AccountDTO> list = new ArrayList<>();
		
		conn = JDBCUtil.getConnection();
		try {
			stmt = conn.prepareStatement(BOARD_LIST);
			rs = stmt.executeQuery();
			while (rs.next()) {
				AccountDTO dto = new AccountDTO(rs.getInt("num"), rs.getString("writer"),
						rs.getString("title"), rs.getString("content"),
						rs.getInt("hits"));
				list.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, stmt, conn);
		}
		
		return list;
	}
}