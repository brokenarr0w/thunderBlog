
import {createRouter, createWebHashHistory} from 'vue-router'
import getPageTitle from "@/utils/getPageTitle";
import backendRouter from "@/router/backend";
import frontendRouter from "@/router/frontend";
import loginRouter from "@/router/login";
import vuex from "@/store/index";
import {getWebSetting} from '@/api/admin'
const routes = [
    backendRouter,
    frontendRouter,
    loginRouter
]
const router = createRouter({
    history:createWebHashHistory(),
    routes,
})
router.beforeEach(async (to, from, next) => {
    const res = await getWebSetting()
    vuex.commit('saveSiteInfo',res.data)
    document.title =await getPageTitle(to.meta.title)
    next()
})
export default router

