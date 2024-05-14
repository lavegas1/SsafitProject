<template>
  <div class="product-list-container">
    <h4>SSAFIT 상품 목록</h4>
    <hr>
    <ProductSearchInput />
      <hr>
      <table class="product-table">
        <thead>
          <tr>
            <th>상품 번호</th>
            <th>상품 이름</th>
            <th>상품 사진</th>
            <th>상품 가격</th>
            <th>상품 재고</th>
            <th>리뷰</th>
            <th>좋아요</th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="product in store.productList" :key="product.id">
            <td>{{ product.id }}</td>
            <td>
              <RouterLink :to="`/product/${product.id}`">{{ product.name }}</RouterLink>
            </td>
            <td>{{ product.id }}</td>
            <td>{{ product.name }}</td>
            <td>{{ product.img }}</td>
            <td>{{ product.price }}</td>
            <td>{{ product.stock }}</td>
            <td>{{ product.reviewCnt }}</td>
            <td>{{ product.likeCnt }}</td>
          </tr>
        </tbody>
      </table>
      <hr>
    </div>
  </template>
  
  <script setup>
  import { useProductStore } from '@/stores/product';
  import { onMounted } from 'vue';
  import ProductSearchInput from './ProductSearchInput.vue';
  
  const store = useProductStore()
  
  onMounted(() => {
    store.getProductList()
  })
  </script>
  
  <style scoped>
  .product-list-container {
    max-width: 800px;
    margin: 0 auto;
  }
  
  .product-table {
    width: 100%;
    border-collapse: collapse;
  }
  
  .product-table th, .product-table td {
    border: 1px solid #ddd;
    padding: 8px;
    text-align: left;
  }
  
  .product-table th {
    background-color: #f2f2f2;
  }
  </style>
  