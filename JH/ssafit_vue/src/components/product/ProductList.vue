<template>
  <div class="container">
    <h4>SSAFIT 상품 목록</h4>
    <hr>
    <ProductSearchInput />
      <hr>
      <table class="table table-hover text-center">
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
          <tr v-for="product in currentPageProductList" :key="product.id">
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
      <nav aria-label="page navigation">
  <ul class="pagination d-flex justify-content-center">
    <li class="page-item">
      <a class="page-link" @click.prevent="currentPage--" :class="{disabled: currentPage <= 1}" href="#">&lt;</a>
    </li>

    <li class="page-item" :class="{active: currentPage === page}" v-for="page in pageCount" :key="page">
      <a class="page-link" href="#" @click.prevent="clickPage(page)">{{ page }}</a>
    </li>

    <li class="page-item">
      <a class="page-link" @click.prevent="currentPage++" :class="{disabled: currentPage >= pageCount}" href="#">&gt;</a>
    </li>
  </ul>
</nav>
      <hr>
    </div>
  </template>
  
  <script setup>
  import { useProductStore } from '@/stores/product';
  import { onMounted , ref , computed } from 'vue';
  import ProductSearchInput from './ProductSearchInput.vue';
  

  const perPage = 5;
  const currentPage = ref(1)

  const pageCount = computed(() => {
    return Math.ceil(store.productList.length / perPage)
  })

 const clickPage = function(page) {
    currentPage.value = page
 } 

 const currentPageProductList = computed(() => {
   return store.productList.slice((currentPage.value-1) * perPage , currentPage.value*perPage)
 })

  const store = useProductStore()
  
  onMounted(() => {
    store.getProductList()
  })
  </script>
  
  <style scoped>
  .container {
    max-width: 800px;
    margin: 0 auto;
  }
  
  .table {
    width: 100%;
    border-collapse: collapse;
  }
  
  .table th, .table td {
    border: 1px solid #ddd;
    padding: 8px;
    text-align: left;
  }
  
  .table th {
    background-color: #f2f2f2;
  }
  </style>
  