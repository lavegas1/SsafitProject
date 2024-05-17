<template>
  <div>
  <div class="card shadow-sm">
    <img 
      src="https://img.youtube.com/vi/3wXPGc2lI8Q/0.jpg" 
      class="card-img-top" 
      alt="Video Thumbnail" 
      @click="openModal"
      style="cursor: pointer;"
    />

    <div class="card-body">
      <p class="card-text">영상 설명이 들어갈 부분</p>
      <div class="d-flex justify-content-between align-items-center">
        <div class="btn-group">
          <button type="button" class="btn btn-sm btn-outline-secondary">리뷰</button>
          <button type="button" class="btn btn-sm btn-outline-secondary">관련 상품</button>
        </div>
        <small class="text-body-secondary">9 mins</small>
      </div>
    </div>
  </div>

  <!-- Modal -->
  <div 
    class="modal fade" 
    id="videoModal" 
    tabindex="-1" 
    aria-labelledby="videoModalLabel" 
    aria-hidden="true"
    ref="modal"
  >
    <div class="modal-dialog modal-lg">
      <div class="modal-content">
        <div class="modal-header">
          <h5 class="modal-title" id="videoModalLabel">동영상 재생</h5>
          <button 
            type="button" 
            class="btn-close" 
            @click="closeModal" 
            aria-label="Close"
          ></button>
        </div>
        <div class="modal-body">
          <div class="ratio ratio-16x9" ref="iframeContainer"></div>
        </div>
      </div>
    </div>
  </div>
  </div>
</template>

<script setup>
import { ref } from 'vue'
import 'bootstrap/dist/css/bootstrap.min.css'
import 'bootstrap'

const showModal = ref(false)
const videoUrl = 'https://www.youtube.com/embed/3wXPGc2lI8Q?autoplay=1'

const openModal = () => {
  showModal.value = true
  const modal = new bootstrap.Modal(document.getElementById('videoModal'))
  modal.show()

  // 동적으로 iframe 생성
  const iframe = document.createElement('iframe')
  iframe.src = videoUrl
  iframe.width = '100%'
  iframe.height = '100%'
  iframe.frameBorder = '0'
  iframe.allow = 'accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture'
  iframe.allowFullscreen = true

  const container = document.querySelector('#videoModal .ratio')
  container.innerHTML = ''
  container.appendChild(iframe)
}

const closeModal = () => {
  showModal.value = false
  const modal = bootstrap.Modal.getInstance(document.getElementById('videoModal'))
  modal.hide()

  // iframe 제거
  const container = document.querySelector('#videoModal .ratio')
  container.innerHTML = ''
}
</script>

<style scoped>
/* 추가적인 스타일링이 필요하다면 여기에 작성하세요 */
</style>
