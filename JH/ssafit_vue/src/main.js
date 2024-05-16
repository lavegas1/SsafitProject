import { createApp } from 'vue'
import { createPinia } from 'pinia'
import store from './stores/store'

import 'bootstrap/dist/css/bootstrap.min.css'
import App from './App.vue'
import router from './router'

const app = createApp(App)

app.use(createPinia())
app.use(router).use(store)

app.mount('#app')