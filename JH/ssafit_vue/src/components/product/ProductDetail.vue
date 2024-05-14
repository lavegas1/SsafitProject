<template>
    <div class="product-detail-container">
      <h4>상품 상세 보기</h4>
      <hr>
      <div class="product-detail-item">
        <label>상품 번호 :</label>
        <span>{{ store.product.id }}</span>
      </div>
      <div class="product-detail-item">
        <label>상품 이름 :</label>
        <span>{{ store.product.name }}</span>
      </div>
      <div class="product-detail-item">
        <label>상품 사진</label>
        <span>{{ store.product.img }}</span>
      </div>
      <div class="product-detail-item">
        <label>상품 가격 :</label>
        <span>{{ store.product.price }}</span>
      </div>
      <div class="product-detail-item">
        <label>상품 재고 :</label>
        <span>{{ store.product.stock }}</span>
      </div>
      <div class="product-detail-item">
        <label>리뷰 :</label>
        <span>{{ store.product.reviewCnt }}</span>
      </div>
      <div class="product-detail-item">
        <label>좋아요 :</label>
        <span>{{ store.product.likeCnt }}</span>
      </div>
    </div>
  </template>
  
  <script setup>
  import { useProductStore } from '@/stores/product';
  import { onMounted } from 'vue';
  
  const store = useProductStore()
  
  onMounted(() => {
      store.getProduct(route.params.id)
  })
  </script>
  
  <style scoped>
  .product-detail-container {
    width: 100%;
    padding: 20px;
  }
  
  .product-detail-item {
    margin-bottom: 10px;
  }
  
  .product-detail-item label {
    font-weight: bold;
    margin-right: 10px;
  }
  </style>
  