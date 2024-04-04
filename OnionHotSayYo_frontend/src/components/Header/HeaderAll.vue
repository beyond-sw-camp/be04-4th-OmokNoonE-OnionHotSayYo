<template>
    <div id="header-all">
        <HeaderUpper />
        <HeaderNavigationBar />
    </div>
</template>

<script setup>
import HeaderUpper from './HeaderUpper/HeaderUpper.vue';
import HeaderNavigationBar from './HeaderNavigationBar/HeaderNavigationBar.vue';
</script>

<style scoped>
#header-all {
    margin: 0% 10%;
}
.container[data-v-1d6c2acb] {
    --bs-gutter-x: 1.5rem;
    --bs-gutter-y: 0;
    width: 100%;
    padding-right: calc(var(--bs-gutter-x) * .5);
    padding-left: calc(var(--bs-gutter-x) * .5);
    margin-right: auto;
    margin-left: auto;
}
.container[data-v-1d6c2acb] {
    max-width: 1140px;
}
</style>