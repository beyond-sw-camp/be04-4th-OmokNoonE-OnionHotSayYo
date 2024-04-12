<template>
    <div>
        <AddPostDetail />
        <!-- <AddPostDetail @newPost="addNewPost"/> -->
    </div>
</template>

<script setup>
    import AddPostDetail from '@/components/Section/Post/Add/AddPostDetail.vue';
    // import axios from 'axios';
    // import { useRouter } from "vue-router";

    // const router = useRouter();

    // async function addNewPost(newPost) {
    //   console.log("Union에서 값 받음");
    //   console.log(newPost.value);

    //   const detailPost = {
    //     ID: newPost.value.ID,
    //     TITLE: newPost.value.TITLE,
    //     CONTENT: newPost.value.CONTENT,
    //     TECH_STACK: newPost.value.TECH_STACK,
    //     IS_SEEKING: newPost.value.IS_SEEKING,
    //     NICKNAME: newPost.value.NICKNAME,
    //     LAST_MODIFIED_DATE: newPost.value.LAST_MODIFIED_DATE
    //   }

    //   const listPost = {
    //     SEEKING_MEMBER_POST_ID: newPost.value.SEEKING_MEMBER_POST_ID,
    //     TITLE: newPost.value.TITLE,
    //     TECH_STACK: newPost.value.TECH_STACK,
    //     IS_SEEKING: newPost.value.IS_SEEKING,
    //     IS_BOOKMARK: newPost.value.IS_BOOKMARK
    //   }

    //   try {
    //     const responseDetail = await axios.post("http://localhost:8081/Post", detailPost, {
    //       header: {
    //         "Context-Type": "multipart/form-data",
    //       }
    //     });

    //     const responseList = await axios.post("http://localhost:8081/seekingPostList", listPost, {
    //       header: {
    //         "Context-Type": "multipart/form-data",
    //       }
    //     });
        
    //     await router.push(`/seekingpost/${responseDetail.data.ID}`);
    //   } catch(error) {
    //     console.error("Error add new posts:",error);
    //   }
    // }
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