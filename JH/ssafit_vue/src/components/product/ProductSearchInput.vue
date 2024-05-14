<template>
    <div class="search">
        <div>
            <label>검색 기준 :</label>
            <select v-model="searchInfo.key">
                <option value='none'>없음</option>
                <option value="productName">이름</option>
                <option value="productPrice">가격</option>
                <option value="likeCnt">좋아요</option>
            </select>
        </div>
        <div>
            <label>검색 내용 :</label>
            <input type="text" v-model="searchInfo.word" />
        </div>

        <div>
            <label>정렬 기준 :</label>
            <select v-model="searchInfo.orderBy">
                <option value='none'>없음</option>
                <option value="productName">이름</option>
                <option value="productPrice">가격</option>
                <option value="likeCnt">좋아요</option>
            </select>
        </div>
        <div>
            <label>정렬 방향 :</label>
            <select v-model="searchInfo.orderByDir">
                <option value="asc">오름차순</option>
                <option value="desc">내림차순</option>
            </select>
        </div>
        <div>
            <button @click="searchProductList">검색</button>
        </div>
    </div>
</template>

<script setup>
import { useProductStore } from '@/stores/product';
import { ref } from 'vue';


const searchInfo = ref({
    key: 'none',
    word: '',
    orderBy: 'none',
    orderByDir: 'asc'
})

const store = useProductStore()

const searchProductList = function () {
    store.searchProductList(searchInfo.value)
}
</script>

<style scoped>
.search {
    display: flex;
}
</style>