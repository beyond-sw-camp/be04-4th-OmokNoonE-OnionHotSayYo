<template>
    <!--    <Loading v-if="loadingState" />-->
    <!--    <div v-if="!loadingState">-->
    <!--        <ProfileHeader :memberProps="memberProps" />-->
    <!--        <ProfileContents :memberId="memberProps.memberId" />-->
    <!--    </div>-->
    <ProfileHeader />
    <ProfileContents />
    <!-- <ProfileContents /> -->

</template>

<script setup>

import ProfileHeader from '@/components/Section/PersonalPage/Profile/ProfileHeader.vue';
import ProfileContents from '@/components/Section/PersonalPage/Profile/ProfileContents/ProfileContentsUnion.vue';


</script>

<style scoped>
* {
    font-family: 'NanumBarunGothic' !important;

}
</style>