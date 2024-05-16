<template>
    <div class="container">
        <h4>리뷰 상세</h4>
        <hr />
        <div class="d-flex justify-content-center">
            <div class="card" style="width: 30rem">
                <div class="card-body">
                    <div class="mb-3 d-flex justify-content-between align-items-center">
                        <h4 class="card-title">{{ store.review.title }} <span class="badge bg-danger">{{ store.review.viewCnt
                        }}</span></h4>
                        <div class="d-flex justify-content-end">
                            <h6 class="card-subtitle mx-3 text-body-secondary">{{ store.review.writer }}</h6>
                            <h6 class="card-subtitle text-body-secondary">{{ store.review.regDate }}</h6>
                        </div>
                    </div>
                    <p class="card-text ">
                        {{ store.review.content }}
                    </p>
                    <div class="d-flex justify-content-center">
                        <button class="mx-3 btn btn-outline-success" @click="moveUpdate">수정</button>
                        <button class="mx-3 btn btn-outline-danger" @click="deleteReview">삭제</button>
                    </div>
                </div>
            </div>
        </div>
    </div>
</template>
  
<script setup>
import { useRoute, useRouter } from "vue-router";
import { ref, onMounted } from "vue";
import { useReviewStore } from "@/stores/review";
import axios from "axios";
const route = useRoute();
const router = useRouter();
const store = useReviewStore();

onMounted(() => {
    store.getReview(route.params.id);
});

const moveUpdate = function () {
    router.push({ name: "reviewUpdate" });
};

const deleteReview = function () {
    axios
        .delete(`http://localhost:8080/api/review/${route.params.id}`)
        .then(() => {
            router.push({ name: "reviewList" });
        })
        .catch(() => { });
};
</script>
  
<style scoped></style>
  