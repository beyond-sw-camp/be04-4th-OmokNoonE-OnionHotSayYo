<template>
    <div class="nav-scroller py-1 mb-3 border-bottom">
        <nav class="nav nav-underline justify-content-between">
            <div @click="questionPost" class="question-post" style="cursor: pointer;">질문글</div>
            <div @click="informationPost" class="information-post" style="cursor: pointer;">정보글</div>
            <div @click="tripPost" class="trip-post" style="cursor: pointer;">여행글</div>
            <div @click="restaurantPost" class="restaurant-post" style="cursor: pointer;">맛집글</div>
            <div @click="hobbyPost" class="hobby-post" style="cursor: pointer;">동호회글</div>
            <div @click="lifePost" class="life-post" style="cursor: pointer;">일상글</div>
            <div @click="companyPost" class="company-post" style="cursor: pointer;">직장글</div>
            <div @click="recruitmentPost" class="recruitment-post" style="cursor: pointer;">구인구직글</div>
            <div @click="secondhandtradingPost" class="secondhandtrading-post" style="cursor: pointer;">중고거래글</div>
        </nav>
    </div>
</template>

<script setup>
    import { useRouter } from "vue-router";

    const router = useRouter();

    function questionPost(){
        router.push('/list/1');
    }

    function informationPost(){
        router.push('/list/2');
    }

    function tripPost(){
        router.push('/list/3');
    }

    function restaurantPost(){
        router.push('/list/4');
    }

    function hobbyPost(){
        router.push('/list/5');
    }

    function lifePost(){
        router.push('/list/6');
    }

    function companyPost(){
        router.push('/list/7');
    }

    function recruitmentPost(){
        router.push('/list/8');
    }

    function secondhandtradingPost(){
        router.push('/list/9');
    }
</script>

<style scoped>
.nav-scroller {
    position: relative;
    z-index: 2;
    height: 2.75rem;
    overflow-y: hidden;
    margin-top: 10px;
}

.nav {
    margin: 2% 10%;
}

.py-1 {
    padding-top: .25rem !important;
    padding-bottom: .25rem !important;
}

.mb-3 {
    margin-bottom: 1rem !important;
}

.border-bottom {
    border-bottom: var(--bs-border-width) var(--bs-border-style) var(--bs-border-color) !important;
}

* {
    box-sizing: border-box;
}

.div {
    display: block;
    unicode-bidi: isolate;
}

.container {
    --bs-gutter-x: 1.5rem;
    --bs-gutter-y: 0;
}

.nav-link.link-body-emphasis:hover {
    /* text-decoration: underline; */
    /* background-color: lightgray; */
    /* text-shadow: 50%; */
    /* border-radius: 30%; */
    /* width: fit-content; */
    /* margin: 2px 2px; */
    font-weight: 600;
    cursor: pointer;
}
</style>