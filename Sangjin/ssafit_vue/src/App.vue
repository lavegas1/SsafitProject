<template>
  <div>
    <TheHeaderNav/>
    <RouterView/>
  </div>
</template>

<script setup>
import TheHeaderNav from '@/components/common/TheHeaderNav.vue';
import { useStore } from './stores/store';

const store = useStore();
const id = sessionStorage.getItem("id");

if (id) {
  store.account.id = id; // store의 account.id를 직접 설정
}

</script>

<style scoped>
/* 필요한 스타일 지정 */
</style>
