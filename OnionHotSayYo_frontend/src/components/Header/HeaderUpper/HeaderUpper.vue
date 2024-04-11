<template>
    <header class="border-bottom lh-1 py-3">
        <div class="row flex-nowrap justify-content-between align-items-center">
            <div class="col-4">
                <a class="title">
                    <img class="title-image" src="@/assets/image/OnionHotSayYo.png" width="60" height="50">
                    <span @click="goMainPageMain" class="text">OnionHotSayYo</span>
                </a>
            </div>
            <div class="col-4 d-flex justify-content-end align-items-center">
                <SearchBar />
                <!-- <a class="btn btn-sm btn-outline-secondary sign-up" href="#"><span id="sign-up">Sign up</span></a> -->
                <HeaderProfile/>
                <!-- <HeaderLogin/> -->
            </div>
        </div>
    </header>
</template>

<script setup>
import SearchBar from "./SearchBar.vue";
import HeaderProfile from "./HeaderProfile.vue";
import HeaderLogin from "./HeaderLogin.vue";

import { useRouter } from "vue-router";
    
    const router = useRouter();

    function goMainPageMain(){
        router.push(`/`);
    }
</script>

<style scoped>
* {
    font-family: 'NanumBarunGothic' !important;

}

.container {
    --bs-gutter-x: 1.5rem;
    --bs-gutter-y: 0;
}


.title {
    display: flex;
    align-items: center;
    justify-content: center;
    font-size: 35px;
    font-weight: 600;
    text-align: center;
    color: black;
    text-decoration: none;
}

[data-bs-theme=dark] .title {
    color: white;
}

.sign-up {
    display: flex;
    align-items: center;
    justify-self: center;
    text-align: center;
    width: 65.5px !important;
    height: 37.6px;
}

#sign-up {
    display: flex;
    align-items: center;
    justify-self: center;
    text-align: center;
    width: 65.5px !important;
    height: 37.6px;
}

[data-bs-theme=dark] .sign-up {
    background-color: rgb(54, 56, 59) !important;
    color: white !important;
}

* {
    box-sizing: border-box;
}

.title-image {
    left: 20px;
}

.border-bottom {
    border-bottom: var(--bs-border-width) var(--bs-border-style) var(--bs-border-color) !important;
}

.py-3 {
    padding-top: 1rem !important;
    padding-bottom: 1rem !important;
}

.lh-1 {
    line-height: 1 !important;
}
</style>