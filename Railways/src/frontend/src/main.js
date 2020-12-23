import Vue from 'vue'
import App from './App.vue'
import router from './router'
import Axios from "axios";

Vue.config.productionTip = false

Vue.prototype.$http = Axios.create({
  // baseURL: 'http://localhost:8081'
  baseURL: 'http://192.168.0.195:8081' // чтобы хотя бы в локальной сети можно было использовать
});

new Vue({
  router,
  render: h => h(App)
}).$mount('#app')
