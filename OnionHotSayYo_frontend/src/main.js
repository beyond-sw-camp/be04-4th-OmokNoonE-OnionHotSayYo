import './assets/dist/css/bootstrap.min.css'
import './assets/blog.css'
import './assets/sign-in.css'
import './assets/checkout.css'
import CKEditor from '@ckeditor/ckeditor5-vue';

import { createApp } from 'vue'
import App from './App.vue'
import store from './store';
import vueCookie from 'vue3-cookies';
import axios from './js/axios-instance';
import router from './router/router.js';
import 'bootstrap/dist/css/bootstrap.min.css';
import 'bootstrap';

import * as ColorModes from "./assets/js/color-modes.js";
import * as BundleMin from "./assets/dist/js/bootstrap.bundle.min.js";


const EmbedDirective = {
    mounted(el, binding) {
        el.innerHTML = `<figure class="media">${binding.value}</figure>`;
    }
};
const app = createApp(App);
app.config.globalProperties.axios = axios;


app.directive('embed', EmbedDirective)
app.use(CKEditor).mount( /* DOM element */ );
app.use(vueCookie);
app.use(store);
app.use(router).mount('#app');