<template>
    <div v-if="!loadingState" class="loading-container">
        <div class="spinner-grow" role="status">
            <span class="visually-hidden">Loading...</span>
        </div>
        <div class="spinner-grow" role="status">
            <span class="visually-hidden">Loading...</span>
        </div>
        <div class="spinner-grow" role="status">
            <span class="visually-hidden">Loading...</span>
        </div>
    </div>
</template>

<script setup>
import { ref, watch } from 'vue';

const loadingState = defineProps({
    loadingState: Boolean
});

watch(loadingState);
</script>

<style scoped>
.loading-container {
    display: flex;
    align-items: center;
    justify-content: center;
    gap: 10px;
    position: relative;
    margin: 300px;

}
</style>