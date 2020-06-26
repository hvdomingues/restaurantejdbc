import Vue from 'vue'
import BootstrapVue from 'bootstrap-vue/dist/bootstrap-vue.esm';


// Import the styles directly. (Or you could add them via script tags.)
import 'bootstrap/dist/css/bootstrap.css';
import 'bootstrap-vue/dist/bootstrap-vue.css';
import $ from 'jquery';

import App from './App.vue'

Vue.config.productionTip = false
Vue.use(BootstrapVue);
Vue.use($);

new Vue({
  render: h => h(App),
}).$mount('#app')
