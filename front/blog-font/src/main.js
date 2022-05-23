import Vue from 'vue'
import './plugins/axios'
import App from './App.vue'
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';
import router from './router'
import store from './store'
import Cookie from "js-cookie";
// import axios from 'axios'

// Vue.prototype.$axios = axios;
Vue.use(ElementUI);
Vue.use(Cookie);
Vue.config.productionTip = false

new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app')
