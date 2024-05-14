<template>
  <div>
    <TheHeaderNav/>
    <RouterView/>
  </div>
</template>

<script setup>
import TheHeaderNav from '@/components/common/TheHeaderNav.vue';
import { useStore } from 'vuex'; // useStore 함수를 import

const store = useStore(); // Vuex 스토어 가져오기

// setup 함수 내에서 Vuex 스토어를 사용하여 id 값을 가져오고, 필요한 경우 store.commit을 통해 상태를 변경할 수 있습니다.
const id = sessionStorage.getItem("id");

if (id) {
  store.commit("setAccount", id);
}
</script>

<style scoped>
/* 필요한 스타일 지정 */
</style>
