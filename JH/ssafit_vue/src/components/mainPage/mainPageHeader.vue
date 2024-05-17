<template>
  <div>
    <header data-bs-theme="dark">
      <div class="collapse text-bg-dark" id="navbarHeader">
        <TheHeaderNav />
      </div>
      <div class="navbar navbar-dark bg-dark shadow-sm">
        <div class="container">
          <a href="#" class="navbar-brand d-flex">
            <strong>Home</strong>
          </a>
          <button
            class="navbar-toggler"
            type="button"
            data-bs-toggle="collapse"
            data-bs-target="#navbarHeader"
            aria-controls="navbarHeader"
            aria-expanded="false"
            aria-label="Toggle navigation"
          >
            <span class="navbar-toggler-icon"></span>
          </button>
        </div>
      </div>
    </header>
  </div>
</template>

<script setup>
import TheHeaderNav from '../common/TheHeaderNav.vue';
</script>

<style scoped>
  /* .container {
    display: flex;
    justify-content: space-between;
  } */
</style>
