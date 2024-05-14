<template>
    <div>
        <h4>리뷰 수정</h4>
        <fieldset>
            <legend>수정</legend>
            <div>
                <label for="title">영상 제목 : </label>
                <input type="text" id="title" readonly v-model="store.review.videoName">
            </div>
            <div>
                <label for="reviewTitle"> 제목 : </label>
                <input type="text" id="title" v-model="store.review.title">
            </div>
            <div>
                <label for="writer">작성자 : </label>
                <input type="text" id="writer" readonly v-model="store.review.writer">
            </div>
            <div>
                <label for="content">내용 : </label>
                <textarea id="content" cols="30" rows="10" v-model="store.review.content"></textarea>
            </div>
            <div>
                <button @click="updateReview">수정</button>
            </div>
        </fieldset>
    </div>
</template>

<script setup>
import { useReviewStore } from "@/stores/review";
const store = useReviewStore();

const updateReview = function () {
    store.updateReview()
}
</script>

<style scoped></style>