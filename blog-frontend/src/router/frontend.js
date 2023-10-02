import {getBlogList} from '@/api/blog'
const frontendRouter =
        {
        path: '/',
        redirect: '/home',
        component: () => import('@/views/Index.vue'),
        meta:{
            title:'首页',
        },
        children:[
            {
                path: '/home',
                name: 'home',
                component: () => import('@/views/home/Home.vue'),
                meta:{
                    title:'首页',
                },

            },
            {
                path:'/about',
                name:'about',
                component : () => import('@/views/about/About.vue'),
                meta:{
                    title:'关于我',
                }
            },
            {
                path: '/moments',
                name:'moments',
                component:() => import('@/views/moment/moments.vue'),
                meta:{
                    title:'动态',
                }
            },
            {
                path: '/archives',
                name: 'archives',
                component:()=> import('@/views/archives/Archives.vue'),
                meta:{
                    title:'归档',

                }
            },
            {
                path: '/category/:name',
                name: 'categoryBlog',
                component: () => import('@/views/category/Category.vue'),
                meta: {
                    title: '分类'
                }
            },
            {
                path: '/tag/:name',
                name: 'tagBlog',
                component: () => import('@/views/tag/Tag.vue'),
                meta:{
                    title: '标签'
                }
            },
            {
                path: '/blog/:id',
                name: 'blogDetail',
                component: () => import('@/views/blog/Detail.vue'),
                meta:{
                    title:'文章详情'
                }
            }
        ]}
export default frontendRouter