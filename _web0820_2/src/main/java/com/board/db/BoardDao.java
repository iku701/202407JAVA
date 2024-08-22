package com.board.db;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import mybatis.SqlMapConfig;

public class BoardDao {

    // SqlSessionFactory를 SqlMapConfig를 통하여 생성한다.
    SqlSessionFactory sqlsession_f = SqlMapConfig.getSqlMapInstance();
    SqlSession session;

    public BoardDao() {
        // SqlSessionFactory에서 session을 할당받는다.
        // 이 때 openSession에 true를 주어야 자동 커밋이 된다.
        session = sqlsession_f.openSession(true);
    }

    public int getNumRecords() {
        // SQL 쿼리를 실행하여 레코드 수를 반환한다.
        return session.selectOne("com.board.db.BoardDao.getNumRecords");
    }

    public List<BoardDto> selectList(int start, int listSize) {
		// session을 통해 쿼리를 실행하고 값을 받아온다.
		Map<String, Object> map = new HashMap<>();
		map.put("start", start);
		map.put("listSize", start + listSize - 1);
		return session.selectList("com.board.db.BoardDao.selectList", map);
	}


    private void updateHits(int num) {
        // 조회수를 업데이트한다.
        session.update("com.board.db.BoardDao.updateHits", num);
    }

    public BoardDto selectOne(int num, boolean hitsIncreased) {
        if (hitsIncreased) {
            updateHits(num);  // 조회수 증가
        }
        return session.selectOne("com.board.db.BoardDao.selectOne", num);
    }

    public void insertOne(BoardDto dto) {
        // 새 게시글을 삽입한다.
        session.insert("com.board.db.BoardDao.insertBoard", dto);
    }

    public void updateOne(BoardDto dto) {
        // 게시글을 업데이트한다.
        session.update("com.board.db.BoardDao.updateBoard", dto);
    }

    public boolean deleteOne(int num) {
        // 게시글을 삭제한다.
        try {
            session.delete("com.board.db.BoardDao.deleteBoard", num);
        } catch(Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
