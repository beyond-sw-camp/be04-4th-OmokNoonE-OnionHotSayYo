<script setup>
import HeaderAll from "./components/Header/HeaderAll.vue";

import SectionAll from "./components/Section/SectionAll.vue";

import FooterAll from "./components/Footer/FooterAll.vue";

</script>

<template>
  <div class="container">
    <HeaderAll />
    <SectionAll />
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
</style>./components/Section/carousel.vue./components/Section/table.vue