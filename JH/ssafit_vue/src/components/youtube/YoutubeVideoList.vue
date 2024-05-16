<template>
  <div class="container">
    <h2 class="text-center" v-if="store.videos == null ">해당 검색결과가 없습니다.</h2>
    <p class="text-center">원하는 키워드를 검색하시면 관련된 운동 영상을 확인할 수 있습니다.</p>
    <ul>
      <YoutubeVideoListItem
        v-for="video in store.videos"
        :key="video.id.videoId"
        :video="video"
      ></YoutubeVideoListItem>
    </ul>
  </div>
</template>

<script setup>
import { useYoutubeStore } from '@/stores/youtube';
import YoutubeVideoListItem from './YoutubeVideoListItem.vue';

const store = useYoutubeStore();
</script>

<style scoped></style>
