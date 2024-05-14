<template>
    <div class="review-list-container">
      <h4>리뷰 목록</h4>
      <hr>
      <table class="review-table">
        <thead>
          <tr>
            <th>번호</th>
            <th>영상 제목</th>
            <th>제목</th>
            <th>작성자</th>
            <th>등록일</th>
            <th>조회수</th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="review in store.reviewList" :key="review.id">
            <td>{{ review.id }}</td>
            <td>
              <RouterLink :to="`/review/${review.id}`">{{ review.videoName }}</RouterLink>
            </td>
            <td>{{ review.title }}</td>
            <td>{{ review.writer }}</td>
            <td>{{ review.regDate }}</td>
            <td>{{ review.viewCnt }}</td>
          </tr>
        </tbody>
      </table>
      <ReviewSearchInput />
    </div>
  </template>
  
  <script setup>
  import { useReviewStore } from '@/stores/review';
  import { onMounted } from 'vue';
  import ReviewSearchInput from './ReviewSearchInput.vue';
  
  const store = useReviewStore()
  
  onMounted(() => {
    store.getReviewList()
  })
  </script>
  
  <style scoped>
  .review-list-container {
    max-width: 800px;
    margin: 0 auto;
  }
  
  .review-table {
    width: 100%;
    border-collapse: collapse;
  }
  
  .review-table th, .review-table td {
    border: 1px solid #ddd;
    padding: 8px;
    text-align: left;
  }
  
  .review-table th {
    background-color: #f2f2f2;
  }
  </style>
  