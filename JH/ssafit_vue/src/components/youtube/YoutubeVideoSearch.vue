<template>
  <div class="container">

    <div class="input-group mb-3">

      <span class="input-group-text">Exercise Search</span>

      <input
        type="text" 
        class="form-control"
        placeholder="운동 영상 검색" 
        v-model="keyword"
        @keyup.enter="search"
        />

      <button class="btn btn-outline-primary" @click="search">검색</button>
      
    </div>
  </div>
</template>

<script setup>
import { ref } from 'vue';
import { useYoutubeStore } from '@/stores/youtube';

const store = useYoutubeStore();

const keyword = ref('');

const search = function () {
  store.youtubeSearch(keyword.value);
};
</script>

<style scoped></style>
