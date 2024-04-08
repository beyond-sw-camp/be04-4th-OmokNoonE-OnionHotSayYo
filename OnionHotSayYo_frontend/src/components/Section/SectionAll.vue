<script setup>
import Banner from "@/components/Section/carousel.vue";

import Table from "@/components/Section/table.vue";

import Sample from "@/components/Section/sample.vue";

import PersonalPage from "./PersonalPage/PersonalPage.vue";

</script>
<template>
    <div class="container">
        <!-- <Banner /> -->
        <!-- <Table /> -->
        <!-- <Sample /> -->
        <PersonalPage />
    </div>
</template>

<style scoped>
* {
  font-family: 'NanumBarunGothic' !important;

}
.container {
    max-width: 1000px !important;
}
</style>