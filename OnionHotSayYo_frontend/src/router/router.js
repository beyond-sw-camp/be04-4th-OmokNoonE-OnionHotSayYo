import {createRouter, createWebHistory} from "vue-router";
import {useCookies} from "vue3-cookies";
import store from "@/store";

const routes = [
    {
        path: '/',
        alias: ['/main', '/index', '/home'],
        component: () => import("../views/MainPageView.vue")
    },
    {
        path: '/mypage/:memberid',
        component: () => import("../views/MyPageView.vue")
    },
    {
        path: '/list/:type/:memberid',
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
        path: '/search/:title&:language?',
        // alias: ['/search/:title&:language'],
        component: () => import("../views/SearchListView.vue")
    },
    {
        path: '/signup',
        component: () => import("../views/SignUpView.vue")
    },
    {
        path: '/letter/:memberid',
        component: () => import("../views/LetterView.vue")
    },
    {
        path: '/notfound',
        component: () => import("../views/NotFound.vue")
    },
    {
        path: '/reportsView',
        component: () => import("../views/ReportsView.vue")
    },
    {
        path: '/posts/creates',
        component: () => import("../views/AddPostView.vue")
    }
    // 추가 라우트를 여기에 정의할 수 있습니다.
];

const router = createRouter({
    history: createWebHistory(),
    routes
});
router.beforeEach((to, from, next) => {
    const { cookies } = useCookies();
    const accessToken = JSON.parse(localStorage.getItem('accessToken'));
    const refreshToken = cookies.get('refreshTokenId');

    if (accessToken) {
        localStorage.setItem("accessToken", JSON.stringify(accessToken));
    }

    // refreshToken이 없을 경우 로그인 창 띄우기
    if (refreshToken === null) {
        console.warn('need login...');
        store.commit('needLogin', true);
    } else {
        store.commit('needLogin', false);
        cookies.set('refreshTokenId', refreshToken);
        return next();
    }
    return next('/');
});

export default router;