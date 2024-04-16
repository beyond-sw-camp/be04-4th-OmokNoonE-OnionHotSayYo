<template>
    <div class="section">
        <PostListHeader :categoryId="categoryId"/>
        <PostListBody :posts="copyPosts" :categoryId="categoryId" />
    </div>
</template>

<script setup>
import PostListHeader from '@/components/Section/Post/List/PostListHeader.vue'
import PostListBody from '@/components/Section/Post/List/PostListBody.vue'

import { ref, onMounted } from 'vue';
import { useRoute } from 'vue-router';
import axios from 'axios';

const categoryId = useRoute().params.categoryid;

const posts = [];
const copyPosts = ref([{}]);
const loadingState = ref(true);

onMounted(async () => {
    try {
        const response = await axios.get(`/api/posts/list/${categoryId}`);
        loadingState.value = false;
        posts.value = response.data.categoryPosts;
        console.log(posts.value);
        for (let i = 0; i < posts.value.length; i++) {
            const postingId = posts.value[i].postId;
            const title = posts.value[i].title;
            const hits = posts.value[i].hits;
            const postedDate = posts.value[i].postedDate;
            const categoryId = posts.value[i].categoryId;
            // const content = posts.value[i].content;
            // const lastModifiedDate = posts.value[i].LAST_MODIFIED_DATE;
            const memberId = posts.value[i].memberId;
            // const language = posts.value[i].LANGUAGE;
            // const locationId = posts.value[i].LOCATION_ID;

            copyPosts.value[i] = {
                postingId: postingId,
                title: title,
                postedDate: postedDate,
                hits: hits,
                categoryId: categoryId,
                memberId: memberId
                // , content: content,
                // image: image,
                // isDeleted: isDeleted,
                // language: language,
                // locationId: locationId
            };
        }

    } catch (error) {
        console.error("Error fetching posts:", error);
    }
});

</script>

<style scoped>
.tooltip {
    position: absolute;
    /* 부모 요소(container)를 기준으로 위치 지정 */
    bottom: 0;
    /* 하단에 표시 */
    left: 50%;
    /* 가운데 정렬을 위해 왼쪽 여백을 50%로 설정 */
    transform: translateX(-50%);
    /* 가운데 정렬 */
    padding: 5px 10px;
    /* 내부 여백 설정 */
    background-color: #333;
    /* 배경색 지정 */
    color: #fff;
    /* 글자색 지정 */
    border-radius: 5px;
    /* 테두리를 둥글게 만듦 */
    display: none;
    /* 초기에는 툴팁 숨김 */
}

* {
    font-family: 'NanumBarunGothic' !important;

}

.d-flex {
    gap: 10px;
}

.list-container {
    display: block;
    unicode-bidi: isolate;
    width: 100%;
    height: 100%;
    margin-top: 40px;
}

.list-header {
    display: flex;
    justify-content: space-between;
    align-items: center;
    padding: 10px 0;
    border-bottom: 1px solid #ccc;
}

.btn-light {
    border: 1px solid #ccc;
    margin-right: 10px;
}

#category-name {
    font-size: 25px;
    font-weight: bold;
    margin-left: 15px;
}

#table-container {
    display: flex;
    justify-content: center;
}

#pagenation-container {
    display: flex;
    justify-content: center;
}

.col-number {
    width: 5%;
    text-align: center;
}

.col-title {
    width: 20%;
    text-align: center;
}

.col-writer {
    width: 10%;
    text-align: center;
}

.col-hits {
    width: 10%;
    text-align: center;
}

.col-like {
    width: 10%;
    text-align: center;
}

.col-dislike {
    width: 10%;
    text-align: center;
}

.col-date {
    width: 15%;
    text-align: center;
}
</style>
