const loginRouter =
{
        path: '/login',
        name: 'login',
    component: () => import('@/views/login/Login.vue')
}
export default loginRouter