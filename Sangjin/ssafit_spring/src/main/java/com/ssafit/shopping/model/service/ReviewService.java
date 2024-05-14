package com.ssafit.shopping.model.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.ssafit.shopping.model.dto.Review;
import com.ssafit.shopping.model.dto.SearchCondition;

public interface ReviewService {
	//게시글 전체 조회
	public List<Review> getReviewList();
	//게시글 상세조회
	public Review readReview(int id); //Dao -> 뷰카운트 +1 / 게시글 조회 
	//게시글 작성
	public void writeReview(Review review);
	///게시글 삭제
	public void removeReview(int id);
	//게시글 수정
	public void modifyReview(Review review);
	//게시글 검색
//	public List<Board> search(SearchCondition searchCondition);
	
}
