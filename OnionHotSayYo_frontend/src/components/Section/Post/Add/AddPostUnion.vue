<template>
    <div>
        <AddPostDetail />

    </div>
</template>

<script setup>
    import AddPostDetail from '@/components/Section/Post/Add/AddPostDetail.vue';

</script>

<style scoped>
@media screen and (max-width: 1040px) {
  .section {
    width: 90%; /* 화면 너비의 90%로 조정 */
    max-width: 600px; /* 최대 너비를 600px로 제한 */
  }
}

.section {
    display: flex;
    flex-direction: column;
    align-items: center;
    gap: 20px;
    position: relative;
    align-self: center;
    width: fit-content;
    margin: 50px;
    padding: 30px;
    min-height: 700px;
    background-color: white;
    border-radius: 30px;
}
</style>