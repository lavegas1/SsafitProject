import { createRouter, createWebHistory } from 'vue-router'

import HomeView from '../views/HomeView.vue'
import YoutubeView from '@/views/YoutubeView.vue'
import ProductView from '@/views/ProductView.vue'
import LoginView from '@/views/LoginView.vue'
import RegistView from '@/views/RegistView.vue'

import UserView from "@/views/RegistView.vue";
import UserList from "@/components/user/UserList.vue";
import UserCreate from "@/components/user/UserCreate.vue";
import UserDetail from "@/components/user/UserDetail.vue";
import ProductDetail from '@/components/product/ProductDetail.vue'


const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'home',
      component: HomeView
    },
    {
      path: '/youtube',
      name: 'youtube',
      component: YoutubeView
    },
    {
      path: '/product',
      name: 'product',
      component: ProductView,
      children: [
        {
          path: ":id",
          name: 'productDetail',
          component: ProductDetail
        },
      ]
    },
    {
      path: "/login",
      name: "login",
      component: LoginView
    },
    {
      path: "/",
      name: "logout",
      component:HomeView
    },   
    {
      path: "/regist",
      name: "regist",
      component: RegistView
    },
    // {
    //   path: "/review:id"
    //   name: "reviewCreate"
    //   component: ReviewCreate
    // } 
  ]
})

export default router
