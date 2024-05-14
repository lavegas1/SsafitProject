import { createRouter, createWebHistory } from 'vue-router'

import HomeView from '../views/HomeView.vue'
import YoutubeView from '@/views/YoutubeView.vue'
import ReviewView from '@/views/ReviewView.vue'
import LoginView from '@/views/LoginView.vue'
import RegistView from '@/views/RegistView.vue'


import ReviewCreate from '@/components/review/ReviewCreate.vue'
import ReviewList from '@/components/review/ReviewList.vue'
import ReviewUpdate from '@/components/review/ReviewUpdate.vue'
import ReviewDetail from '@/components/review/ReviewDetail.vue'



import UserView from "@/views/RegistView.vue";
import UserList from "@/components/user/UserList.vue";
import UserCreate from "@/components/user/UserCreate.vue";
import UserDetail from "@/components/user/UserDetail.vue";


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
      path: '/review',
      name: 'review',
      component: ReviewView,
      children: [
        {
          path: '',
          name: 'reviewList',
          component: ReviewList
        },
        {
          path: 'create',
          name: 'reviewCreate',
          component: ReviewCreate
        },
        {
          path: 'update',
          name: 'reviewUpdate',
          component: ReviewUpdate
        },
        {
          path: ':id',
          name: 'reviewDetail',
          component: ReviewDetail
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
    {
      path: "/user",
      name: "user",
      component: UserView,
      children: [
        {
          path: "",
          name: "userList",
          component: UserList
        },
        {
          path: "create",
          name: "userCreate",
          component: UserCreate
        },
        {
          path: ":id",
          name: "userDetail",
          component: UserDetail
        },
      ] 
    }
  ]
})

export default router
