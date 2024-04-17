<template>
    <div id="darkmode">
        <svg xmlns="http://www.w3.org/2000/svg" class="d-none">
            <symbol id="check2" viewBox="0 0 16 16">
                <path
                    d="M13.854 3.646a.5.5 0 0 1 0 .708l-7 7a.5.5 0 0 1-.708 0l-3.5-3.5a.5.5 0 1 1 .708-.708L6.5 10.293l6.646-6.647a.5.5 0 0 1 .708 0z" />
            </symbol>
            <symbol id="circle-half" viewBox="0 0 16 16">
                <path d="M8 15A7 7 0 1 0 8 1v14zm0 1A8 8 0 1 1 8 0a8 8 0 0 1 0 16z" />
            </symbol>
            <symbol id="moon-stars-fill" viewBox="0 0 16 16">
                <path
                    d="M6 .278a.768.768 0 0 1 .08.858 7.208 7.208 0 0 0-.878 3.46c0 4.021 3.278 7.277 7.318 7.277.527 0 1.04-.055 1.533-.16a.787.787 0 0 1 .81.316.733.733 0 0 1-.031.893A8.349 8.349 0 0 1 8.344 16C3.734 16 0 12.286 0 7.71 0 4.266 2.114 1.312 5.124.06A.752.752 0 0 1 6 .278z" />
                <path
                    d="M10.794 3.148a.217.217 0 0r 1 .412 0l.387 1.162c.173.518.579.924 1.097 1.097l1.162.387a.217.217 0 0 1 0 .412l-1.162.387a1.734 1.734 0 0 0-1.097 1.097l-.387 1.162a.217.217 0 0 1-.412 0l-.387-1.162A1.734 1.734 0 0 0 9.31 6.593l-1.162-.387a.217.217 0 0 1 0-.412l1.162-.387a1.734 1.734 0 0 0 1.097-1.097l.387-1.162zM13.863.099a.145.145 0 0 1 .274 0l.258.774c.115.346.386.617.732.732l.774.258a.145.145 0 0 1 0 .274l-.774.258a1.156 1.156 0 0 0-.732.732l-.258.774a.145.145 0 0 1-.274 0l-.258-.774a1.156 1.156 0 0 0-.732-.732l-.774-.258a.145.145 0 0 1 0-.274l.774-.258c.346-.115.617-.386.732-.732L13.863.1z" />
            </symbol>
            <symbol id="sun-fill" viewBox="0 0 16 16">
                <path
                    d="M8 12a4 4 0 1 0 0-8 4 4 0 0 0 0 8zM8 0a.5.5 0 0 1 .5.5v2a.5.5 0 0 1-1 0v-2A.5.5 0 0 1 8 0zm0 13a.5.5 0 0 1 .5.5v2a.5.5 0 0 1-1 0v-2A.5.5 0 0 1 8 13zm8-5a.5.5 0 0 1-.5.5h-2a.5.5 0 0 1 0-1h2a.5.5 0 0 1 .5.5zM3 8a.5.5 0 0 1-.5.5h-2a.5.5 0 0 1 0-1h2A.5.5 0 0 1 3 8zm10.657-5.657a.5.5 0 0 1 0 .707l-1.414 1.415a.5.5 0 1 1-.707-.708l1.414-1.414a.5.5 0 0 1 .707 0zm-9.193 9.193a.5.5 0 0 1 0 .707L3.05 13.657a.5.5 0 0 1-.707-.707l1.414-1.414a.5.5 0 0 1 .707 0zm9.193 2.121a.5.5 0 0 1-.707 0l-1.414-1.414a.5.5 0 0 1 .707-.707l1.414 1.414a.5.5 0 0 1 0 .707zM4.464 4.465a.5.5 0 0 1-.707 0L2.343 3.05a.5.5 0 1 1 .707-.707l1.414 1.414a.5.5 0 0 1 0 .708z" />
            </symbol>
        </svg>

        <div class="dropdown position-fixed bottom-0 end-0 mb-3 me-3 bd-mode-toggle">
            <button class="btn btn-bd-primary py-2 dropdown-toggle d-flex align-items-center" id="bd-theme"
                type="button" aria-expanded="false" data-bs-toggle="dropdown" aria-label="Toggle theme (auto)">
                <svg class="bi my-1 theme-icon-active" width="1em" height="1em">
                    <use href="#circle-half"></use>
                </svg>
                <span class="visually-hidden" id="bd-theme-text">Toggle theme</span>
            </button>
            <ul class="dropdown-menu dropdown-menu-end shadow" aria-labelledby="bd-theme-text">
                <li>
                    <button type="button" class="dropdown-item d-flex align-items-center" data-bs-theme-value="light"
                        aria-pressed="false">
                        <svg class="bi me-2 opacity-50" width="1em" height="1em">
                            <use href="#sun-fill"></use>
                        </svg>
                        Light
                        <svg class="bi ms-auto d-none" width="1em" height="1em">
                            <use href="#check2"></use>
                        </svg>
                    </button>
                </li>
                <li>
                    <button type="button" class="dropdown-item d-flex align-items-center" data-bs-theme-value="dark"
                        aria-pressed="false">
                        <svg class="bi me-2 opacity-50" width="1em" height="1em">
                            <use href="#moon-stars-fill"></use>
                        </svg>
                        Dark
                        <svg class="bi ms-auto d-none" width="1em" height="1em">
                            <use href="#check2"></use>
                        </svg>
                    </button>
                </li>
                <li>
                    <button type="button" class="dropdown-item d-flex align-items-center active"
                        data-bs-theme-value="auto" aria-pressed="true">
                        <svg class="bi me-2 opacity-50" width="1em" height="1em">
                            <use href="#circle-half"></use>
                        </svg>
                        Auto
                        <svg class="bi ms-auto d-none" width="1em" height="1em">
                            <use href="#check2"></use>
                        </svg>
                    </button>
                </li>
            </ul>
        </div>


        <svg xmlns="http://www.w3.org/2000/svg" class="d-none">
            <symbol id="aperture" fill="none" stroke="currentColor" stroke-linecap="round" stroke-linejoin="round"
                stroke-width="2" viewBox="0 0 24 24">
                <circle cx="12" cy="12" r="10" />
                <path
                    d="M14.31 8l5.74 9.94M9.69 8h11.48M7.38 12l5.74-9.94M9.69 16L3.95 6.06M14.31 16H2.83m13.79-4l-5.74 9.94" />
            </symbol>
            <symbol id="cart" viewBox="0 0 16 16">
                <path
                    d="M0 1.5A.5.5 0 0 1 .5 1H2a.5.5 0 0 1 .485.379L2.89 3H14.5a.5.5 0 0 1 .49.598l-1 5a.5.5 0 0 1-.465.401l-9.397.472L4.415 11H13a.5.5 0 0 1 0 1H4a.5.5 0 0 1-.491-.408L2.01 3.607 1.61 2H.5a.5.5 0 0 1-.5-.5zM3.102 4l.84 4.479 9.144-.459L13.89 4H3.102zM5 12a2 2 0 1 0 0 4 2 2 0 0 0 0-4zm7 0a2 2 0 1 0 0 4 2 2 0 0 0 0-4zm-7 1a1 1 0 1 1 0 2 1 1 0 0 1 0-2zm7 0a1 1 0 1 1 0 2 1 1 0 0 1 0-2z" />
            </symbol>
            <symbol id="chevron-right" viewBox="0 0 16 16">
                <path fill-rule="evenodd"
                    d="M4.646 1.646a.5.5 0 0 1 .708 0l6 6a.5.5 0 0 1 0 .708l-6 6a.5.5 0 0 1-.708-.708L10.293 8 4.646 2.354a.5.5 0 0 1 0-.708z" />
            </symbol>
        </svg>
    </div>

    <div class="container">
        <Carousel :banners="banners" />
        <div class="row" v-for="categoryId in ['1', '2', '3', '4', '5', '6', '7', '8', '9']" :key="categoryId">
            <BestPost :categoryId="categoryId"/>
        </div>

        
    </div>

</template>

<script setup>
import Carousel from "@/components/Section/Main/Carousel.vue";
import BestPost from "@/components/Section/Main/BestPost.vue";

import { ref, onMounted } from 'vue';
import { useRouter } from "vue-router";
import axios from 'axios';

const router = useRouter();

const banners = ref(
    [
        {
            BANNER_ID : 1,
            TITLE : "신대방삼거리역 초밥집 OPEN",
            IMAGE: "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQLzn-YBcNzbzAqrLx4lytHASvzjNg_uL9Yyg&s"
        },
        {
            BANNER_ID : 2,
            TITLE : "신대방삼거리역 순대국밥집 OPEN",
            IMAGE: "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTpTLjlntcxMm9OXP-s_amAVAox1o_tOQ0Qmg&s"
        },
        {
            BANNER_ID : 3,
            TITLE : "신대방삼거리역 런닝 동호회 회원 모집!",
            IMAGE: "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQmOJGSKZ9EInFXfiZamEkn80DDVjmNiiU4GA&s"
        },
        {
            BANNER_ID : 4,
            TITLE : "신대방삼거리역 카페 OPEN",
            IMAGE: "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTsjrEEi-B1392jrulH6dWPX23RyzkP_iVfXQ&s"
        }, 
        {
            BANNER_ID : 5,
            TITLE : "신대방삼거리역 CU편의점 직원 모집",
            IMAGE: "data:image/jpeg;base64,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"
        }
]
);

// onMounted(async () => {
//     try {
//         const response = await axios.get('http://localhost:8082/bannerImage?_sort=BANNER_ID');
//         banners.value = response.data; // posts 반응형 참조에 데이터 할당
//         console.log(banners.value); // 데이터 확인
//     } catch (error) {
//         console.error("Error fetching posts:", error);
//     }
// });

</script>

<style scoped>
* {
    font-family: 'NanumBarunGothic' !important;

}


.bd-placeholder-img {
    font-size: 1.125rem;
    text-anchor: middle;
    -webkit-user-select: none;
    -moz-user-select: none;
    user-select: none;
}

@media (min-width: 768px) {
    .bd-placeholder-img-lg {
        font-size: 3.5rem;
    }
}

.b-example-divider {
    width: 100%;
    height: 3rem;
    background-color: rgba(0, 0, 0, .1);
    border: solid rgba(0, 0, 0, .15);
    border-width: 1px 0;
    box-shadow: inset 0 .5em 1.5em rgba(0, 0, 0, .1), inset 0 .125em .5em rgba(0, 0, 0, .15);
}

.b-example-vr {
    flex-shrink: 0;
    width: 1.5rem;
    height: 100vh;
}

.bi {
    vertical-align: -.125em;
    fill: currentColor;
}

.nav-scroller {
    position: relative;
    z-index: 2;
    height: 2.75rem;
    overflow-y: hidden;
}

.nav-scroller .nav {
    display: flex;
    flex-wrap: nowrap;
    padding-bottom: 1rem;
    margin-top: -1px;
    overflow-x: auto;
    text-align: center;
    white-space: nowrap;
    -webkit-overflow-scrolling: touch;
}

.btn-bd-primary {
    --bd-violet-bg: #712cf9;
    --bd-violet-rgb: 112.520718, 44.062154, 249.437846;

    --bs-btn-font-weight: 600;
    --bs-btn-color: var(--bs-white);
    --bs-btn-bg: var(--bd-violet-bg);
    --bs-btn-border-color: var(--bd-violet-bg);
    --bs-btn-hover-color: var(--bs-white);
    --bs-btn-hover-bg: #6528e0;
    --bs-btn-hover-border-color: #6528e0;
    --bs-btn-focus-shadow-rgb: var(--bd-violet-rgb);
    --bs-btn-active-color: var(--bs-btn-hover-color);
    --bs-btn-active-bg: #5a23c8;
    --bs-btn-active-border-color: #5a23c8;
}

.best_mq1 {
    background-color: rgb(255, 255, 255);
}

.popu_li {
    margin-bottom: 10px;
}

.de_num {
    display: inline-block;
    width: 20px;
    text-align: center;
    margin-right: 10px;
}

.bd-mode-toggle {
    z-index: 1500;
}

.bd-mode-toggle .dropdown-menu .active .bi {
    display: block !important;
}

a {
    color: blue;
    /* 링크 색상 설정 */
}

.card {
    margin: 5px 5px;
    width: 18rem;
}

.category-title {
    margin: 10px;
    font-size: 20px;
}

.card-link {
    align-items: right;
    box-sizing: border-box;
    margin: 0;
    text-decoration: none;
    transition: all .4s;
    font-weight: 800;
    position: absolute;
    display: block;
    right: 15px;
    top: 23px;
    padding: 2px 8px;
    border: 1px solid #e0e0e0;
    line-height: 22px;
    font-size: 13px;
    color: #777;
    border-radius: 15px;
}

[data-bs-theme=dark] .card-link {
    color: white !important;
}



.col-number {
    width: 5%;
    text-align: center;
}

.col-title {
    width: 20%;
    text-align: center;
}

.col-link {
    text-decoration: none;
    color: black;
}

[data-bs-theme=dark] .col-link {
    color: white;
}

.col-date {
    width: 15%;
    text-align: center;
}

.col-hits {
    background-color: red;
    color: white;
    border: 1px #777;
    border-radius: 45%;
}
</style>