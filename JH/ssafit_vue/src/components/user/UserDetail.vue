<template>
    <div>
        <h1>사용자 상세 정보</h1>
        <table class="user-table">
            <tr>
                <th>ID</th>
                <th>PW</th>
                <th>이름</th>
                <th>이메일</th>
                <th>나이</th>
            </tr>
  
            <tr>
                <th>{{store.user.id}}</th>
                <th>{{store.user.password }}</th>
                <th>{{store.user.name}}</th>
                <th>{{ store.user.email }}</th>
                <th>{{ store.user.age }}</th>
            </tr>
        </table>
    </div>
  </template>
  
  <script setup>
  
  import { onMounted } from 'vue';
  import { useRoute } from 'vue-router';
  import { useUserStore } from '@/stores/userStore';
  
  const store = useUserStore()
  const route = useRoute()
  
  
  
  
  onMounted(()=>{
    store.getUser(route.params.id)
  })
  </script>
  
  <style scoped>
  
  .user-table {
    width: 100%;
    border-collapse: collapse;
  }
  
  .user-table th, .user-table td {
    border: 1px solid #dddddd;
    text-align: left;
    padding: 8px;
  }
  
  .user-table th {
    background-color: #f2f2f2;
  }
  
  .user-table tr:nth-child(even) {
    background-color: #f2f2f2;
  }
  
  .user-table tr:hover {
    background-color: #dddddd;
  }
  </style>
  