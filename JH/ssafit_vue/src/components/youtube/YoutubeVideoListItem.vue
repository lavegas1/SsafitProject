<template>
  <div>
    <li @click="clickVideo">
      <img :src="video.snippet.thumbnails.default.url" alt="Thumbnail">
      <span>{{ video.snippet.title }}</span>
    </li>
  </div>
</template>

<script setup>
import { useYoutubeStore } from '@/stores/youtube';

const store = useYoutubeStore();

const props = defineProps({
  video: {
    type: Object,
    required: true
  }
});

const clickVideo = () => {
  store.selectedVideo = props.video;
};

</script>

<style scoped>
body {
  margin: 0;
}
div {
  box-sizing: border-box;
}
/* 추가적인 스타일링이 필요하다면 여기에 작성하세요 */
</style>
