import Vue from 'vue'
import App from './App.vue'
import router from './router'
import Axios from "axios";

import VueSimpleAlert from "vue-simple-alert";

Vue.use(VueSimpleAlert);

Vue.config.productionTip = false

Vue.prototype.$http = Axios.create({
   baseURL: 'http://192.168.0.195:8081'
});

new Vue({
  router,
  render: h => h(App)
}).$mount('#app')
