package com.board.dao;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.board.domain.BoardVO;

@Repository
public class BoardDAOImpl implements BoardDAO {

	@Inject
	private SqlSession sql;
	
	private static String namespace = "com.board.mappers.board";
	
	// 게시물 목록
	public List<BoardVO> list() throws Exception {

		return sql.selectList(namespace + ".list");
	}

	// 게시물 작성
	public void write(BoardVO vo) throws Exception {
		
		sql.insert(namespace + ".write", vo);

	}

	//게시물 조회
	public BoardVO view(int bno) throws Exception {
		
		return sql.selectOne(namespace + ".view", bno);
	}
	
	//게시물 수정
	public void modify(BoardVO vo) throws Exception {
		
		sql.update(namespace + ".modify", vo);
	}

	//게시물 삭제
	public void delete(int bno) throws Exception {
		sql.delete(namespace + ".delete", bno);
		
	}

	//게시물 총 개수
	public int count() throws Exception {
		return sql.selectOne(namespace + ".count");
	}

	@Override
	public List listPage(int displayPost, int postNum) throws Exception {

		HashMap data = new HashMap();
		
		data.put("displayPost", displayPost);
		data.put("postNum", postNum);
		
		return sql.selectList(namespace + ".listPage", data);
	}

	@Override
	public List<BoardVO> listPageSearch(int displayPost, int postNum, String searchType, String keyword)
			throws Exception {
		
		HashMap<String, Object> data = new HashMap<String, Object>();
		
		data.put("displayPost", displayPost);
		data.put("postNum", postNum);
		
		data.put("searchType", searchType);
		data.put("keyword", keyword);
		
		return sql.selectList(namespace + ".listPageSearch", data);
	}

	@Override
	public int searchCount(String searchType, String keyword) throws Exception {
		
		HashMap data = new HashMap();
		
		data.put("searchType", searchType);
		data.put("keyword", keyword);
		
		return sql.selectOne(namespace + ".searchCount", data); 
	}
	
}
