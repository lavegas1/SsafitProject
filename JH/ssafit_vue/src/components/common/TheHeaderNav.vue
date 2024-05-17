<template>
    <div id="container">
        <header>
            <nav>
                <RouterLink to="/">Home</RouterLink> |
                <RouterLink to="/youtube">Youtube</RouterLink> |
                <RouterLink :to="{ name: 'product' }">ProductList</RouterLink> |
                <RouterLink :to="{ name: 'login' }" v-if="!store.account.id">로그인</RouterLink> |
                <RouterLink :to="{ name: 'logout' }" @click="logout" v-if="store.account.id">| 로그아웃</RouterLink>
                <RouterLink :to="{ name: 'regist' }">회원가입</RouterLink> 
            </nav>
        </header>
    </div>
</template>

<script setup>
// 여기에 필요한 스크립트를 추가하세요
import router from '@/router';
import { useStore } from '@/stores/store';

const store = useStore();

const isSessionStorageAvailable = () => {
    return typeof sessionStorage !== 'undefined' && sessionStorage.getItem('id') !== null;
}

const logout = () => {
    store.account.id = 0; // 로그아웃 시 id를 0으로 설정
    sessionStorage.removeItem("id")
    router.push({ path: "/" });
}
</script>

<style scoped>
#container {
    text-align: center;
    display: flex;
    align-items: center;
    justify-content: center;
    height: 10vh; /* 필요에 따라 높이를 조정하세요 */
}

nav {
    display: flex;
    gap: 30px; /* 링크 간격을 조정할 수 있습니다 */
    font-size: 30px;
}

nav a {
    font-weight: bold;
    text-decoration: none;
    color: white;
    line-height: 1.5; /* 텍스트의 상하 간격을 동일하게 맞춥니다 */
}

nav a.router-link-exact-active {
    color: rgb(23, 230, 23);
}
</style>
