<template>
    <div v-if="store.selectedVideo" class="modal-container">
      <button class="close-button" @click="closeVideo">닫기</button>
      <iframe
        class="container"
        width="560"
        height="560"
        :src="videoURL"
        title="YouTube video player"
        frameborder="0"
        allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share"
        referrerpolicy="strict-origin-when-cross-origin"
        allowfullscreen
      ></iframe>
      <RouterLink :to="{ name: 'Review', params: { videoId: store.selectedVideo.id.videoId } }">리뷰 작성하기</RouterLink>
    </div>
  </template>
  
  <script setup>
  import { useYoutubeStore } from '@/stores/youtube';
  import { computed } from 'vue';
  
  const store = useYoutubeStore();
  
  const videoURL = computed(() => {
    const videoId = store.selectedVideo.id.videoId;
    return `https://www.youtube.com/embed/${videoId}`;
  });
  
  const closeVideo = () => {
    store.selectedVideo = null;
  };
  </script>
  
  <style scoped>
  /* 추가적인 스타일링이 필요하다면 여기에 작성하세요 */
  .close-button {
    position: absolute;
    top: 10px;
    right: 10px;
    padding: 5px 10px;
    background-color: #ccc;
    border: none;
    border-radius: 5px;
    cursor: pointer;
  }
  </style>
  