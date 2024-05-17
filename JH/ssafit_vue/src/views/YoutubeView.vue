<template>
  <div class="container">
    <mainPageHeader/>
    <hr>
    <h2 class="text-center">SSAFIT Project</h2>
    <YoutubeVideoSearch/>
    <YoutubeVideoDetail/>
    <hr>
    <YoutubeVideoList/>
  </div>
</template>

<script setup>
import YoutubeVideoSearch from '@/components/youtube/YoutubeVideoSearch.vue'
import YoutubeVideoList from '@/components/youtube/YoutubeVideoList.vue'
import YoutubeVideoDetail from '@/components/youtube/YoutubeVideoDetail.vue'
import mainPageHeader from '@/components/mainPage/mainPageHeader.vue';


</script>

<style scoped></style>
