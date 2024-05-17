// stores/useVideosStore.js
import { defineStore } from 'pinia';

export const useVideosStore = defineStore('videos', {
  state: () => ({
    videos: [
      { id: 1, title: 'Video 1', url: 'https://www.youtube.com/watch?v=3wXPGc2lI8Q&t=344s'},
      { id: 2, title: 'Video 2', url: 'https://www.youtube.com/watch?v=vlRd3f34dgU'},
      { id: 3, title: 'Video 3', url: 'https://www.youtube.com/watch?v=qhpdU8L4Uo8'},
      { id: 4, title: 'Video 4', url: 'https://www.youtube.com/watch?v=dNEIS0ygx44'},
      { id: 5, title: 'Video 5', url: 'https://www.youtube.com/watch?v=nz5qsvRgK24'},
      { id: 6, title: 'Video 6', url: 'https://www.youtube.com/watch?v=irZIl5mx6GA'}
    ],
    selectedVideo: null
  }),
  actions: {
    selectVideo(video) {
      this.selectedVideo = video;
    },
    clearSelectedVideo() {
      this.selectedVideo = null;
    }
  }
});
