<template>
    <div class="review-detail-container">
      <h4>리뷰 상세</h4>
      <hr>
      <div class="review-detail-item">
        <label>영상 제목:</label>
        <span>{{ store.review.videoName }}</span>
      </div>
      <div class="review-detail-item">
        <label>제목:</label>
        <span>{{ store.review.title }}</span>
      </div>
      <div class="review-detail-item">
        <label>작성자:</label>
        <span>{{ store.review.writer }}</span>
      </div>
      <div class="review-detail-item">
        <label>내용:</label>
        <span>{{ store.review.content }}</span>
      </div>
      <div class="review-detail-item">
        <label>등록일:</label>
        <span>{{ store.review.regDate }}</span>
      </div>
      <div class="review-detail-item">
        <label>조회수:</label>
        <span>{{ store.review.viewCnt }}</span>
      </div>
  
      <div class="button-container">
        <button class="delete-button" @click="deleteReview">삭제</button>
        <button class="update-button" @click="updateReview">수정</button>
      </div>
    </div>
  </template>
  
  <script setup>
  import { useReviewStore } from '@/stores/review';
  import { onMounted } from 'vue';
  import { useRoute, useRouter } from 'vue-router';
  import axios from 'axios'
  
  const store = useReviewStore()
  const route = useRoute();
  const router = useRouter();
  
  onMounted(() => {
      store.getReview(route.params.id)
  })
  
  const deleteReview = function () {
      axios.delete(`http://localhost:8080/api-review/review/${route.params.id}`)
          .then(() => {
              router.push({ name: 'reviewList' })
          })
  }
  
  const updateReview = function () {
      router.push({ name: 'reviewUpdate' })
  }
  
  </script>
  
  <style scoped>
  .review-detail-container {
    width: 100%;
    padding: 20px;
  }
  
  .review-detail-item {
    margin-bottom: 10px;
  }
  
  .review-detail-item label {
    font-weight: bold;
    margin-right: 10px;
  }
  
  .button-container {
    margin-top: 20px;
  }
  
  .delete-button {
    background-color: #f44336;
    color: white;
    border: none;
    padding: 10px 20px;
    border-radius: 5px;
    cursor: pointer;
  }
  
  .update-button {
    background-color: #4caf50;
    color: white;
    border: none;
    padding: 10px 20px;
    border-radius: 5px;
    cursor: pointer;
  }
  </style>
  