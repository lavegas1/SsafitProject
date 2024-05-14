<template>
  <div>
    <h4>운동 영상 검색</h4>
    <input type="text" v-model="keyword" />
    <button @click="search">검색</button>
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
