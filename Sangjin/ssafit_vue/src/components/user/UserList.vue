<template>
    <div>
        <h4>사용자 목록</h4>
        <hr>
        <table class="user-table">
            <tr>
                <th>ID</th>
                <th>PW</th>
                <th>이름</th>
                <th>이메일</th>
                <th>나이</th>
            </tr>
  
            <tr v-for="user in store.userList" :key="user.id">
                <th>
                  <RouterLink :to="`/user/${user.id}`">{{user.id}}</RouterLink>
                </th>
                <th>{{user.password }}</th>
                <th>{{user.name}}</th>
                <th>{{ user.email }}</th>
                <th>{{ user.age }}</th>
            </tr>
        </table>
    </div>
  </template>
  
  <script setup>
  import {useUserStore} from '@/stores/userStore';
  import {onMounted} from 'vue';
  
  const store = useUserStore()
  onMounted(()=>{
    store.getUserList()
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
  