<template>
    <div class="section">
        <PostListHeader />
        <SearchListBody :posts="copyPosts" :language="language" :searchTitle="searchTitle" />
    </div>
</template>

<script setup>
import PostListHeader from '@/components/Section/Post/List/PostListHeader.vue'
import SearchListBody from '@/components/Section/Post/Search/SearchListBody.vue'

import { ref, onMounted } from 'vue';
import { format } from 'date-fns';
import { useRoute } from 'vue-router';
import axios from 'axios';


const searchTitle = useRoute().params.title;

const language = useRoute().params.language || null;

const posts = ref([]);
const copyPosts = ref([{}]);
const url = ref('');


console.log('copyPosts', copyPosts);

const loadingState = ref(true);

onMounted(async () => {
    try {
        if (language) {
            console.log('번역 검색')
            url.value = `http://localhost:30001/posts/search/${searchTitle}?${language}`;
        }
        else {
            console.log('기본 검색')
            url.value = `http://localhost:30001/posts/search/${searchTitle}`;
        }
        const response = await axios.get(url.value);
        console.log(response.status);
        loadingState.value = false;
        posts.value = response.data.myPosts;
        console.log('부모 post', posts.value);
        // console.log(posts.value);
        for (let i = 0; i < posts.value.length; i++) {
            const postingId = posts.value[i].postId;
            const title = posts.value[i].title;
            const memberId = posts.value[i].memberId;
            const postedDate = posts.value[i].postedDate;
            const hits = posts.value[i].hits;
            const content = posts.value[i].content;
            // const categoryId = posts.value[i].categoryId;
            // const lastModifiedDate = posts.value[i].LAST_MODIFIED_DATE;
            // const language = posts.value[i].LANGUAGE;
            // const locationId = posts.value[i].LOCATION_ID;

            copyPosts.value[i] = {
                postingId: postingId,
                title: title,
                memberId: memberId,
                postedDate: format(new Date(postedDate[0], postedDate[1] - 1, postedDate[2], postedDate[3], postedDate[4], postedDate[5]), 'yyyy-MM-dd HH:mm:ss'),
                hits: hits,
                content: content
                // categoryId: categoryId
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
