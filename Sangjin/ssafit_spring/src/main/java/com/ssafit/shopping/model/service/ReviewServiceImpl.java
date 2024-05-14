package com.ssafit.shopping.model.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafit.shopping.model.dao.ReviewDao;
import com.ssafit.shopping.model.dto.Review;

@Service
public class ReviewServiceImpl implements ReviewService {

	private final ReviewDao reviewDao;
	
	@Autowired
	public ReviewServiceImpl(ReviewDao reviewDao) {
		this.reviewDao = reviewDao;
	}

	@Override
	public List<Review> getReviewList() {
		return reviewDao.selectAll();
	}

	@Override
	public Review readReview(int id) {
		System.out.println(id + "번 게시글을 읽어옵니다.");
		reviewDao.updateViewCnt(id);
		return reviewDao.selectOne(id);
	}

	@Override
	public void writeReview(Review review) {
		System.out.println("게시글 작성합니다.");
		reviewDao.insertReview(review);
	}

	@Override
	public void removeReview(int id) {
		System.out.println(id+"번 게시글을 삭제하겠습니다.");
		reviewDao.deleteReview(id);
	}

	@Override
	public void modifyReview(Review review) {
		System.out.println("게시글 수정");
		reviewDao.updateReview(review);
	}

//	@Override
//	public List<Board> search(SearchCondition searchCondition) {
//		return reviewDao.search(searchCondition);
//	}

}
