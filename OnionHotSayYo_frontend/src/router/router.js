import { createRouter, createWebHistory } from "vue-router";

const routes = [
    {
        path: '/',
        alias: ['/main', '/index', '/home'],
        component: () => import("../views/MainPageView.vue")
    },
    {
        path: '/mypage/:memberid',
        component: () => import("../views/PersonalPageView.vue")
    },
    {
        path: '/list/my/:memberid',
        component: () => import("../views/PersonalListView.vue")
    },
    {
        path: '/view/:postid',
        component: () => import("../views/PostDetailView.vue")
    },
    {
        path: '/list/:categoryid',
        component: () => import("../views/PostListView.vue")
    },
    {
        path: '/signup',
        component: () => import("../views/SignUpView.vue")
    }
    // 추가 라우트를 여기에 정의할 수 있습니다.
];

const router = createRouter({
    history: createWebHistory(),
    routes
});

export default router;
