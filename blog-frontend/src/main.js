
import { createApp } from 'vue';
import App from './App.vue';
// 基础样式
import './assets/css/base.css';
// typo
import './assets/css/typo.css';
import { House } from "@element-plus/icons-vue";
import 'element-plus/es/components/message/style/css';
import VueMarkdownEditor from '@kangc/v-md-editor';
import '@kangc/v-md-editor/lib/style/base-editor.css';
import githubTheme from '@kangc/v-md-editor/lib/theme/github.js';
import '@kangc/v-md-editor/lib/theme/style/github.css';
import hljs from 'highlight.js';
VueMarkdownEditor.use(githubTheme, {
    Hljs: hljs,
  });

import 'viewerjs/dist/viewer.css';
import './assets/css/icon.css';
import { responseSuccess } from '@/utils/interceptors';
import Viewer from 'v-viewer';
import router from "@/router";
import vuex from '@/store/index';
import axios from "axios";

const app = createApp(App)
app.component(House.__name,House)
axios.defaults.baseURL='http://47.115.205.26/api/'
axios.interceptors.response.use(responseSuccess)

app.use(VueMarkdownEditor)
app.use(Viewer)
app.use(router)
app.use(vuex)
app.mount("#app")
