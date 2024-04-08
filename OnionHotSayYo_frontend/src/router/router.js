import { createRouter, createWebHistory } from 'vue-router';

const routes = [
    {
        path: '/',
        alias: ['/main', '/index'],
        component: () => import("../views/GuestMainView.vue")
    },
    {
        path: '/seekingpost',
        component: () => import("../views/SeekingPostListView.vue")
    },
    {
        path: '/seekingpost/:id',
        component: () => import("../views/SeekingPostDetailView.vue")
    },
    {
        path: '/seekingpost/addseekingpost',
        component: () => import("../views/AddSeekingPostView.vue")
    }
    // 추가 라우트를 여기에 정의할 수 있습니다.
];

const router = createRouter({
    history: createWebHistory(),
    routes
});

export default router;
