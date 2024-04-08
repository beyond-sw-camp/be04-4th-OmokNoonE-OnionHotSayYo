<script setup>
import MainPage from "@/components/Section/Main/MainPage.vue";

import PersonalPage from "@/components/Section/PersonalPage/PersonalPage.vue";

import PostList from "@/components/Section/Post/PostList.vue";

import PostDetail from "@/components/Section/Post/PostDetail.vue";


</script>
<template>
    <div class="container">
        <MainPage />
        <!-- <PersonalPage /> -->
        <!-- <PostList /> -->
        <!-- <PostDetail/> -->
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