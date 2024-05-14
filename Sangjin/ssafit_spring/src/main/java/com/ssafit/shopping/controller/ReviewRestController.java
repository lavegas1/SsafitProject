package com.ssafit.shopping.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafit.shopping.model.dto.Review;
import com.ssafit.shopping.model.service.ReviewService;

@RestController
@RequestMapping("/api-review")
@CrossOrigin(origins = "*")
public class ReviewRestController {
	private final ReviewService reviewService;

	@Autowired
	public ReviewRestController(ReviewService reviewService) {
		this.reviewService = reviewService;
	}

	// 리뷰 전체 조회
	@GetMapping("/review")
	public ResponseEntity<?> list(){
		List<Review> list = reviewService.getReviewList(); //전체조회
		return new ResponseEntity<List<Review>>(list, HttpStatus.OK);
	}

	// 리뷰 상세 보기
	@GetMapping("/review/{id}")
	public ResponseEntity<Review> detail(@PathVariable("id") int id) {
		Review review = reviewService.readReview(id);

		return new ResponseEntity<Review>(review,HttpStatus.OK);
	}

	// 리뷰 등록 (Form 형식으로 넘어왔을 때)
	@PostMapping("/review")
	public ResponseEntity<?> write(@RequestBody Review review) {
		System.out.println(review);
		reviewService.writeReview(review);
		return new ResponseEntity<Review>(review, HttpStatus.CREATED);
	}

	// 리뷰 수정 (JSON형태로 보낸다)
	@PutMapping("/review/{id}")
	public ResponseEntity<Void> update(@PathVariable("id") int id, @RequestBody Review review) {
		review.setId(id);
		reviewService.modifyReview(review); // id를 따로 보내왔다면 바구니(DTO)에 넣어놓고 보내자
		return new ResponseEntity<Void>(HttpStatus.OK); // 조금 더 세밀하게 컨트롤 할 수도 있다.
	}

	// 리뷰 삭제
	@DeleteMapping("/review/{id}")
	public ResponseEntity<Void> delete(@PathVariable("id") int id) {
		reviewService.removeReview(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

}
