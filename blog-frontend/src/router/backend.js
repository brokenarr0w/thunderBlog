import {
    Edit,
    House,
    Operation,
    Document,
    Folder,
    List,
    Files,
    Management,
    Memo,
    Setting, ChatSquare, ChatRound
} from "@element-plus/icons-vue";


const backendRouter =
    {
        path: '/admin',
        beforeEnter: (to, from, next) => {
            if (localStorage.getItem("token")) {
                next()
            } else {
                next({
                    name: 'login'
                })
            }
        },
        name: 'admin',
        redirect: "/backendhome",
        component: () => import('@/views/admin/Admin.vue'),
        children: [
            {
                path: '/backendhome',
                name: 'backHome',
                icon: House,
                component: () => import('@/views/admin/Home.vue'),
                meta: {title: '首页'}
            },
            {
            path: '/blog',
            name:'blog',
            icon: Document,
            meta: {title: '博客'},
            children: [
                {
                path:'blogList',
                name:'blogList',
                component: () => import('@/views/admin/blog/blogList.vue'),
                meta:{title:'博客管理'},
                icon: Folder,
                hidden: false,
                },
            ]
            },
            {
                path: '/tag',
                name: 'tag',
                meta: {title: '标签'},
                icon:List,
                children: [
                    {
                        path: 'tagManagement',
                        name: 'tagManagement',
                        meta: {title: '标签管理'},
                        component: () => import('@/views/admin/tag/TagManagement.vue'),
                        icon:Files,
                        hidden: false,
                    },
                    
                ]
            },
            {
            path: '/category',
            name: 'category',
            meta: {title: '类别'},
            icon: Management,
            children: [
                {
                    path: 'categoryManagement',
                    name: 'categoryManagement',
                    meta: {title: '类别管理'},
                    icon: Memo,
                    component: () => import('@/views/admin/category/CategoryManagement.vue'),
                    hidden: false,
                },
            
            ]
            },
            {
                path: "/moment",
                name:'moment',
                meta: {title: '动态管理'},
                icon: ChatSquare,
                children: [
                    {
                        path: 'management',
                        name: 'manage',
                        component: () => import('@/views/admin/moments/MomentManagement.vue'),
                        meta: {title: '动态列表'},
                        icon: ChatRound,
                        hidden: false,
                    },
                ]
            },
            {
                path: '/webSetting',
                name:'webSetting',
                meta: {title: '网站设置'},
                icon: Setting,
                component: () => import('@/views/admin/Setting.vue'),
                hidden: false,
            },
            {
                path: '/aboutMe',
                name:'aboutMe',
                meta: {title: '个人信息'},
                icon: Setting,
                component: () => import('@/views/admin/AboutMe.vue'),
                hidden: false,
            },

        ],

    }

export default backendRouter