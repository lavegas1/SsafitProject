<template>
    <div class="container">
      <h2>Regist Form</h2>    
         <div class="input-form">
              <label for="id">ID :</label>
              <input type="text" id="id" v-model="user.id" required>
         </div>
  
         <div class="input-form">
              <label for="pw">PW :</label>
              <input type="password" id="password" v-model="user.password" required>
        </div>
  
        <div class="input-form">
          <label for="name">Name :</label>
          <input type="text" id="name" v-model="user.name" required>
        </div>
  
        <div class="input-form">
          <label for="email">e-mail :</label>
          <input type="email" id="email" v-model="user.email" required>
        </div>
        
        <div class="input-form">
          <label for="age">age :</label>
          <input type="number" id="age" v-model="user.age" required>
        </div>
  
        <div class="input-form">
          <label for="phoneNumber">Phone Number :</label>
          <input type="text" id="phoneNumber" v-model="user.phoneNumber" required>
        </div>
  
        <div class="input-form">
          <label for="height">height :</label>
          <input type="number" id="height" v-model="user.height" required>
        </div>
  
        <div class="input-form">
          <label for="weight">weight :</label>
          <input type="number" id="weight" v-model="user.weight" required>
        </div>
  
        <div class="input-form">
          <label for="address">address :</label>
          <input type="text" id="address" v-model="user.address" required>
        </div>
        <button @click="createUser">Regist</button>
    </div>
  
  </template>
  
  <script setup>
 import { useUserStore } from '@/stores/userStore';
import {ref} from 'vue';
  
const store = useUserStore()

  const user = ref({
    id :'',
    pw :'',
    name :'',
    email :'',
    age :'',
    phoneNumber :'',
    height :'',
    weight :'',
    address :''
  })

  const createUser = function(){
  store.createUser(user.value)
}
 
  
//   const userInfo = reactive({
//     name, id, pw, email,
//     phoneNumber, age, height, weight, address
//   });
  
//   const infoSubmit = async () => {
//     try {
//       console.log('이름:', userInfo.name);
//       console.log('아이디:', userInfo.id);
//       console.log('비밀번호:', userInfo.pw);
//       console.log('이메일:', userInfo.email);
//       console.log('전화번호:', userInfo.phoneNumber);
//       console.log('나이:', userInfo.age);
//       console.log('키:', userInfo.height);
//       console.log('몸무게:', userInfo.weight);
//       console.log('주소:', userInfo.address);
  
//       const response = await axios({
//         method: 'POST',
//         url: 'https://example.com/api/register',
//         data: {
//           name: userInfo.name,
//           id: userInfo.id,
//           pw: userInfo.pw,
//           email: userInfo.email,
//           phoneNumber: userInfo.phoneNumber,
//           age: userInfo.age,
//           height: userInfo.height,
//           weight: userInfo.weight,
//           address: userInfo.address
//         }
//       });
//       console.log('성공', response.data);
      
//     } catch (error) {
//       console.error('실패:', error);
      
//     }
//   }
  </script>
  
  <style scoped>
  .container {
    max-width: 400px;
    margin: 0 auto;
    padding: 20px;
    background-color: #f8f8f8;
    border-radius: 8px;
  }
  
  .input-form {
    margin-bottom: 15px;
  }
  
  label {
    display: block;
    margin-bottom: 5px;
    color: #555;
  }
  
  input[type="text"],
  input[type="password"],
  input[type="email"],
  input[type="tel"],
  input[type="number"] {
    width: 100%;
    padding: 10px;
    border: 1px solid #ddd;
    border-radius: 5px;
    box-sizing: border-box;
  }
  
  button {
    width: 100%;
    padding: 10px;
    background-color: #007bff;
    color: #fff;
    border: none;
    border-radius: 5px;
    cursor: pointer;
    transition: background-color 0.3s ease;
  }
  
  button:hover {
    background-color: #0056b3;
  }
  </style>