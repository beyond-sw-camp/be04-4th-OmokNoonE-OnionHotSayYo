<template>
    <div class="nav-scroller py-1 mb-3 border-bottom">
        <nav class="nav nav-underline justify-content-between">
            <a class="nav-item nav-link link-body-emphasis" href="#">질문글</a>
            <a class="nav-item nav-link link-body-emphasis" href="#">정보글</a>
            <a class="nav-item nav-link link-body-emphasis" href="#">여행글</a>
            <a class="nav-item nav-link link-body-emphasis" href="#">맛집글</a>
            <a class="nav-item nav-link link-body-emphasis" href="#">동호회글</a>
            <a class="nav-item nav-link link-body-emphasis" href="#">일상글</a>
            <a class="nav-item nav-link link-body-emphasis" href="#">직장글</a>
            <a class="nav-item nav-link link-body-emphasis" href="#">구인구직글</a>
            <a class="nav-item nav-link link-body-emphasis" href="#">중고거래글</a>
        </nav>
    </div>
</template>

<script setup>

</script>

<style scoped>
.nav-scroller {
    position: relative;
    z-index: 2;
    height: 2.75rem;
    overflow-y: hidden;
}

.nav {
    margin: 0% 10%;
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
}
</style>