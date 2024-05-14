<template>
  <div class="form-signin w-100 m-auto">
    <img class="mb-4" src="../../assets/ssafyLogo.png" alt="" width="72" height="57">
    <h1 class="h3 mb-3 fw-normal">Login</h1>

    <div class="form-floating">
      <input type="id" class="form-control" id="floatingInput" placeholder="name@example.com" v-model="user.id">
      <label for="floatingInput">ID</label>
    </div>
    <div class="form-floating">
      <input type="password" class="form-control" id="floatingPassword" placeholder="Password" v-model="user.password">
      <label for="floatingPassword">Password</label>
    </div>

    <div class="form-check text-start my-3">
      <input class="form-check-input" type="checkbox" value="remember-me" id="flexCheckDefault">
      <label class="form-check-label" for="flexCheckDefault">
        로그인 정보 저장
      </label>
    </div>
    <button class="btn btn-primary w-100 py-2" @click="submit">Sign in</button>
    <p class="mt-5 mb-3 text-body-secondary">&copy; SSAFIT Project/대전3반/김준혁,하상진</p>
</div>
</template>

<script setup>
import { useUserStore } from '@/stores/userStore';
import {ref} from 'vue';
import router from '@/router';

const store = useUserStore()

const user = ref({
  id:'',
  password:''
})

const submit = function(){
  store.submit(user.value)
}


</script>

<style scoped>
.form-signin {
  max-width: 330px;
  padding: 1rem;
}

.form-signin .form-floating:focus-within {
  z-index: 2;
}

.form-signin input[type="email"] {
  margin-bottom: -1px;
  border-bottom-right-radius: 0;
  border-bottom-left-radius: 0;
}

.form-signin input[type="password"] {
  margin-bottom: 10px;
  border-top-left-radius: 0;
  border-top-right-radius: 0;
}
</style>