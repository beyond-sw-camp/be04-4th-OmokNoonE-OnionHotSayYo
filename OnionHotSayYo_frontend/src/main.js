import './assets/dist/css/bootstrap.min.css'
import './assets/blog.css'
import './assets/sign-in.css'
import './assets/checkout.css'
import CKEditor from '@ckeditor/ckeditor5-vue';

import { createApp } from 'vue'
import App from './App.vue'
import axios from 'axios'
import router from './router/router.js';
import 'bootstrap/dist/css/bootstrap.min.css';
import 'bootstrap';


import * as ColorModes from "./assets/js/color-modes.js";
import * as BundleMin from "./assets/dist/js/bootstrap.bundle.min.js";


const app = createApp(App);
// createApp( { /* options */ } ).use( CKEditor ).mount( /* DOM element */ );
app.use(CKEditor).mount( /* DOM element */ );
app.config.globalProperties.$axios = axios
app.use(router);
app.mount('#app');


