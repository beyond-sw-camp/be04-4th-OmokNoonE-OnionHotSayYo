<script setup>
import Sample from "./components/sample.vue";

import Banner from "./components/carousel.vue";

import Table from "./components/table.vue";

import Sample from "./components/Section/sample.vue";
import HeaderUpper from "./components/Header/HeaderUpper/HeaderUpper.vue";
import HeaderNavigation from "./components/Header/HeaderNavigationBar/HeaderNavigationBar.vue";
import HeaderAll from "./components/Header/HeaderAll.vue";
import FooterAll from "./components/Footer/FooterAll.vue";

</script>

<template>
  <Banner />
  <Table />
  <Sample/>
  <HeaderAll/>
  <FooterAll/>
</template>


<style scoped>

.container[data-v-1d6c2acb]{
--bs-gutter-x: 1.5rem;
--bs-gutter-y: 0;
width: 100%;
padding-right: calc(var(--bs-gutter-x) * .5);
padding-left: calc(var(--bs-gutter-x) * .5);
margin-right: auto;
margin-left: auto;
}

.container[data-v-1d6c2acb]{
max-width: 1140px;
}
</style>