<template>
    <div class="section">
        <PostListHeader />
        <PostListBody :posts="posts" :categoryId="categoryId"/>
    </div>
    </template>
    
    <script setup>
    import PostListHeader from '@/components/Section/Post/List/PostListHeader.vue'
    import PostListBody from '@/components/Section/Post/List/PostListBody.vue'

    import { ref, onMounted } from 'vue';
    import { useRoute } from 'vue-router';
    import axios from 'axios';
    
    const categoryId = useRoute().params.categoryid;

    const posts = ref([]);
    const loadingstate = ref(true);

onMounted(async () => {
    try {
        const response = await axios.get(`http://localhost:8888/posts/list/${categoryId}`);
        loadingstate.value = false;
        console.log(response.status);
        posts.value = response.data; // posts 반응형 참조에 데이터 할당
        console.log('poist', posts.value); // 데이터 확인
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

.list-header{
    display: flex;
    justify-content: space-between;
    align-items: center;
    padding: 10px 0;
    border-bottom: 1px solid #ccc;
}

.btn-light{
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
