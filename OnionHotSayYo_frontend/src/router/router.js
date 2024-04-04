import { createRouter, createWebHistory } from 'vue-router';

const routes = [
    {
        // path: '/',
        // alias: ['/eventdetail'],
        // component: () => import("../views/EventDetailAll.vue")
    },
];

const router = createRouter({
    history: createWebHistory(),
    routes
});

export default router;