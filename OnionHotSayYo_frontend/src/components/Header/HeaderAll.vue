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
    margin: 0% 2%;
}
</style>