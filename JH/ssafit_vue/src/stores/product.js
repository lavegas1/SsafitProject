import { ref } from 'vue'
import { defineStore } from 'pinia'
import axios from 'axios'
import router from '@/router'

const REST_PRODUCT_API = `http://localhost:8080/api-product/product`
axios.defaults.baseURL = 'http://localhost:8080'

export const useProductStore = defineStore('product', () => {


  const createProduct = function (product) {
    axios({
      url: REST_REVIEW_API,
      method: 'POST',
      data: product
    })
      .then(() => {
        router.push({name: 'productList'})
      })
      .catch((err) => {
      console.log(err)
    })
  }

  const productList = ref([])

  const getProductList = function () {
    axios.get(REST_PRODUCT_API)
      .then((response) => {
      productList.value = response.data
    })
  }

  const product = ref({})

  const getProduct = function (id) {
    axios.get(`${REST_PRODUCT_API}/${id}`)
      .then((response) => {
      product.value = response.data
    })
  }

  const updateProduct = function () {
    axios.put(REST_PRODUCT_API, product.value)
      .then(() => {
      router.push({name: 'product'})
    })
  }
  const searchProductList = function (searchCondition) {
    axios.get(REST_PRODUCT_API, {
      params: searchCondition
    })
      .then((res) => {
        productList.value = res.data
      })
  }


  return { createProduct, productList, getProductList, product, getProduct, updateProduct, searchProductList}
})