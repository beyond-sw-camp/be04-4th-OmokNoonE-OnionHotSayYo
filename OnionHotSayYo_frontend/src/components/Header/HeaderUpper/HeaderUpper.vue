<template>
    <header class="border-bottom lh-1 py-3">
        <div class="row flex-nowrap justify-content-between align-items-center">
            <div class="col-4">
                <a class="title" href="https://www.naver.com">
                    <img class="title-image" src="@/assets/image/OnionHotSayYo.png" width="60" height="50">
                    <span class="text">OnionHotSayYo</span>
                </a>
            </div>
            <div class="col-4 d-flex justify-content-end align-items-center">
                <!-- <a class="link-secondary" href="#" aria-label="Search">
                    <svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" fill="none" stroke="currentColor"
                        stroke-linecap="round" stroke-linejoin="round" stroke-width="2" class="mx-3" role="img"
                        viewBox="0 0 24 24">
                        <title>Search</title>
                        <circle cx="10.5" cy="10.5" r="7.5"></circle>
                        <path d="M21 21l-5.2-5.2"></path>
                    </svg>
                </a> -->
                <SearchBar />
                <a class="btn btn-sm btn-outline-secondary" href="#">Sign up</a>
            </div>
        </div>
    </header>
</template>

<script setup>
import SearchBar from "./SearchBar.vue";

</script>

<style scoped>
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
    color: #000000;
    text-decoration: none;
    

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