<template>
    <div class="review-form-container">
      <h4>리뷰 작성</h4>
      <fieldset>
        <legend>등록</legend>
        <div class="form-group">
          <label for="videoTitle">영상 제목:</label>
          <input type="text" id="videoTitle" v-model="review.videoName" class="form-control">
        </div>
        <div class="form-group">
          <label for="title">리뷰 제목:</label>
          <input type="text" id="title" v-model="review.title" class="form-control">
        </div>
        <div class="form-group">
          <label for="writer">작성자:</label>
          <input type="text" id="writer" v-model="review.writer" class="form-control">
        </div>
        <div class="form-group">
          <label for="content">내용:</label>
          <textarea id="content" cols="30" rows="10" v-model="review.content" class="form-control"></textarea>
        </div>
        <div class="button-container">
          <button @click="createReview" class="btn btn-primary">등록</button>
        </div>
      </fieldset>
    </div>
  </template>
  
  <script setup>
  import { useReviewStore } from '@/stores/review';
  import { ref } from 'vue';
  
  const store = useReviewStore()
  
  const review = ref({
    videoName: '',
    title: '',
    writer: '',
    content: ''
  })
  
  const createReview = function () {
    store.createReview(review.value)
  }
  
  </script>
  
  <style scoped>
  .review-form-container {
    max-width: 500px;
    margin: 0 auto;
  }
  
  .form-group {
    margin-bottom: 15px;
  }
  
  label {
    font-weight: bold;
    margin-right: 10px;
  }
  
  .form-control {
    width: 100%;
    padding: 8px;
    border: 1px solid #ccc;
    border-radius: 5px;
    box-sizing: border-box;
  }
  
  textarea {
    resize: vertical;
  }
  
  .button-container {
    text-align: right;
  }
  
  .btn {
    padding: 10px 20px;
    border: none;
    border-radius: 5px;
    cursor: pointer;
    background-color: #007bff;
    color: #fff;
  }
  
  .btn:hover {
    background-color: #0056b3;
  }
  </style>
  