<template>
    <div id="container">
        <header>
            <nav>
                <RouterLink to="/">Home</RouterLink> |
                <RouterLink to="/youtube">Youtube</RouterLink> |
                <RouterLink :to="{ name: 'reviewList' }">ReviewList</RouterLink> |
                <RouterLink :to="{ name: 'reviewCreate' }">ReviewCreate</RouterLink> |
                <RouterLink :to="{ name: 'login' }" v-if="!$store.state.account.id">로그인 | </RouterLink> 
                <RouterLink :to="{ name: 'logout' }" @click="logout" v-if="$store.state.account.id">로그아웃 | </RouterLink> 
                <RouterLink :to="{ name: 'regist' }">회원가입</RouterLink> |
            </nav>
        </header>
    </div>
</template>

<script setup>
import router from '@/router';
import store from '@/stores/store';

const logout = ()=>{
    store.commit('setAccount',0);
    sessionStorage.removeItem("id")
    router.push({path:"/"});
}
</script>

<style scoped>
#container {
    text-align: center;
}

nav a {
    font-weight: bold;
    text-decoration: none;
    color: black;
}

nav a.router-link-exact-active {
    color: #42b983
}
</style>