<template>
    <div class="container">
      <h4>게시글 목록</h4>
      <hr />
      <ReviewSearchInput />
      <table class="table table-hover text-center">
        <tr>
          <th>번호</th>
          <th>제목</th>
          <th>쓰니</th>
          <th>조회수</th>
          <th>등록일</th>
        </tr>
        <tr v-for="review in currentPageReviewList" :key="review.id">
          <td>{{ review.id }}</td>
          <td>
            <RouterLink :to="`/review/${review.id}`">{{ review.title }}</RouterLink>
          </td>
          <td>{{ review.writer }}</td>
          <td>{{ review.viewCnt }}</td>
          <td>{{ review.regDate }}</td>
        </tr>
      </table>
      <nav aria-label="Page navigation">
        <ul class="pagination d-flex justify-content-center">
          <li class="page-item">
            <a
              class="page-link"
              @click.prevent="currentPage--"
              :class="{ disabled: currentPage <= 1 }"
              href="#"
              >&lt;</a
            >
          </li>
          <li
            class="page-item"
            :class="{ active: currentPage === page }"
            v-for="page in pageCount"
            :key="page"
          >
            <a class="page-link" href="#" @click.prevent="clickPage(page)">{{
              page
            }}</a>
          </li>
          <li class="page-item">
            <a
              class="page-link"
              @click.prevent="currentPage++"
              :class="{ disabled: currentPage >= pageCount }"
              href="#"
              >&gt;</a
            >
          </li>
        </ul>
      </nav>
    </div>
  </template>
  
  <script setup>
  import { useReviewStore } from '@/stores/review';
  import { computed, onMounted, ref } from 'vue';
  import ReviewSearchInput from './ReviewSearchInput.vue';
  
  const store = useReviewStore();
  onMounted(() => {
    store.getReviewList();
  });
  
  const perPage = 5;
  const currentPage = ref(1);
  
  const pageCount = computed(() => {
    return Math.ceil(store.reviewList.length / perPage);
  });
  
  const clickPage = function (page) {
    currentPage.value = page;
  };
  
  const currentPageReviewList = computed(() => {
    return store.reviewList.slice(
      (currentPage.value - 1) * perPage,
      currentPage.value * perPage
    );
  });
  </script>
  
  <style scoped></style>
  