import { ref, computed } from 'vue'
import { defineStore } from 'pinia'
import axios from 'axios'

export const useYoutubeStore = defineStore('youtube', () => {
  const videos = ref(null)


  const youtubeSearch = function(keyword){
    const URL = 'https://www.googleapis.com/youtube/v3/search'
    const API_KEY ='AIzaSyAlvV-xRK5nKa1yZ5o0nqUv398_Ok-fVec'
    const defaultKeyword = '운동';
    const searchKeyword = keyword ? `${keyword} ${defaultKeyword}` : defaultKeyword;
    axios({
      url: URL,
      method: 'GET',
      params: {
        key: API_KEY,
        part: 'snippet',
        maxResults: 10,
        q: searchKeyword,
        type: 'video',
        orderby: 'viewCount'
      }
    })
    .then((response)=>{
      videos.value = response.data.items
      console.log(response.data)
    })
    .catch(()=>{})

  }

  return { youtubeSearch, videos }
})
