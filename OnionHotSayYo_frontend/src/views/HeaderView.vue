<template>
    <div id="header-all">
        <HeaderUpper />
        <HeaderNavigationBar />
    </div>
</template>

<script setup>
import HeaderUpper from '@/components/Header/HeaderUpper/HeaderUpper.vue';
import HeaderNavigationBar from '@/components/Header/HeaderNavigationBar/HeaderNavigationBar.vue';
</script>

<style scoped>
#header-all {
    margin: 0% 2%;
}
</style>