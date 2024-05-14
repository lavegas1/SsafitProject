import { ref } from 'vue'
import { defineStore } from 'pinia'
import axios from 'axios'
import router from '@/router'

const REST_REVIEW_API = `http://localhost:8080/api-review/review`
axios.defaults.baseURL = 'http://localhost:8080'; // 요청을 보낼 서버의 기본 URL 설정

export const useReviewStore = defineStore('review', () => {


  const createReview = function (review) {
    axios({
      url: REST_REVIEW_API,
      method: 'POST',
      data: review
    })
      .then(() => {
        router.push({name: 'reviewList'})
      })
      .catch((err) => {
      console.log(err)
    })
  }

  const reviewList = ref([])

  const getReviewList = function () {
    axios.get(REST_REVIEW_API)
      .then((response) => {
      reviewList.value = response.data
    })
  }

  const review = ref({})

  const getReview = function (id) {
    axios.get(`${REST_REVIEW_API}/${id}`)
      .then((response) => {
      review.value = response.data
    })
  }

  const updateReview = function () {
    axios.put(REST_REVIEW_API, review.value)
      .then(() => {
      router.push({name: 'reviewList'})
    })
  }
  const searchReviewList = function (searchCondition) {
    axios.get(REST_REVIEW_API, {
      params: searchCondition
    })
      .then((res) => {
        reviewList.value = res.data
      })
  }


  return { createReview, reviewList, getReviewList, review, getReview, updateReview, searchReviewList}
})