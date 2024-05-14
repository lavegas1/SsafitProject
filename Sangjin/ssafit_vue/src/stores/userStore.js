import { ref, computed } from 'vue'
import { defineStore } from 'pinia'
import axios from 'axios'
import router from '@/router'
const REST_USER_API = `http://localhost:8080/api-user/user`

export const useUserStore = defineStore('user', () => {
 
  const createUser = function(user){
    axios({
      url : REST_USER_API,
      method : 'POST',
      data : user
    })
    .then(()=>{
      window.alert("회원가입 성공!");
      router.push("/login")
    })
    .catch((err)=>{
      console.log(err)
      window.alert("이미 사용중인 ID입니다.");
      window.location.reload()
    })
  }
  const userList = ref([])
  const getUserList = function(){
    axios.get(REST_USER_API)
    .then((response)=>{
      userList.value = response.data
    })
  }

  const user = ref({})

  const getUser = function(id){
    axios.get(`${REST_USER_API}/${id}`)
    .then((response)=>{
      user.value = response.data
    })
  }

  const submit = (credentials) => {
    axios.post(`${REST_USER_API}/login`, credentials)
      .then((res) => {
        console.log(res);
        window.alert("로그인하였습니다.");
        router.push("/")
      })
      .catch((err) => {
        console.error(err);
        window.alert("로그인에 실패하였습니다.");
      });
  }

  return { getUser, getUserList, user,createUser,userList,submit }
})
