<script setup>
import HeaderAll from "./components/Header/HeaderAll.vue";

import SectionAll from "./components/Section/SectionAll.vue";

import FooterAll from "./components/Footer/FooterAll.vue";

import signup from "./components/SignUp/signup.vue";

import Login from "@/components/Login/Login.vue";

import detailUnion from "@/components/Section/post/detail/detailUnion.vue";
</script>

<template>
  <div class="container">
    <signup />
    <!-- <Login /> -->
    <HeaderAll />
    <!-- <SectionAll /> -->
    <detailUnion />
    <FooterAll />
    </div>
</template>


<style scoped>

.container {
  --bs-gutter-x: 1.5rem;
  --bs-gutter-y: 0;
  width: 100%;
  padding-right: calc(var(--bs-gutter-x) * .5);
  padding-left: calc(var(--bs-gutter-x) * .5);
  margin-right: auto;
  margin-left: auto;
}

.container {
  max-width: 1140px;
}

* {
  font-family: 'NanumBarunGothic', sans-serif !important;
}
@font-face {
  font-family:'NanumBarunGothic';
  src: url('assets/fonts/NanumBarunGothic.ttf') format('truetype');
  font-weight: 400;
}
@font-face {
  font-family:'NanumBarunGothic';
  src: url('assets/fonts/NanumBarunGothicLight.ttf') format('truetype');
  font-weight: 300;
}
@font-face {
  font-family:'NanumBarunGothic';
  src: url('assets/fonts/NanumBarunGothicBold.ttf') format('truetype');
  font-weight: 700;
}



</style>