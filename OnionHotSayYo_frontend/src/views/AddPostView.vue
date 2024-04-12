<template>
    <div class="frame-wrapper">
        <AddPostUnion/>
    </div>
</template>

<script setup>
import AddPostUnion from '@/components/Section/Post/Add/AddPostUnion.vue';

</script>

<style scoped>
.frame-wrapper {
    display: inline-flex;
    position: relative;
    justify-content: center;
    width: 100%;
    height: fit-content;
    background-color: white;
}
</style>