package com.ssafit.shopping.model.dao;

import java.util.List;

import com.ssafit.shopping.model.dto.Review;

public interface ReviewDao {
	// 전체 게시글을 조회
	public List<Review> selectAll();

	// ID에 해당하는 게시글 하나 가져오기
	public Review selectOne(int id);

	// 게시글 등록
	public void insertReview(Review review);

	// 게시글 삭제
	public void deleteReview(int id);

	// 게시글 수정
	public void updateReview(Review review);

	// 조회수 증가
	public void updateViewCnt(int id);
	
	// 검색 기능
//	public List<Review> search(SearchCondition searchCondition);


}
