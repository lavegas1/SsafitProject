import { createApp } from 'vue'
import { createPinia } from 'pinia'
import 'bootstrap/dist/css/bootstrap.min.css'
import App from './App.vue'
import router from './router'
import { useStore } from 'vuex'

const app = createApp(App)

app.use(createPinia())
app.use(router)
app.use(useStore)

app.mount('#app')
