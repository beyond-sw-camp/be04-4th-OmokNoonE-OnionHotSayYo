<template>
    <PostDetailTop :PostDetailTopProps="PostDetailTopProps" />
    <PostDetailMiddle />
    <PostDetailComment />
</template>

<script setup>
import PostDetailTop from '@/components/Section/Post/Detail/PostDetailTop.vue';
import PostDetailMiddle from '@/components/Section/Post/Detail/PostDetailMiddle.vue';
import PostDetailComment from '@/components/Section/Post/Detail/PostDetailComment.vue';
import { ref, onMounted } from 'vue';
import { format } from 'date-fns';
import { useRoute, useRouter } from "vue-router";
import axios from 'axios';

const routePostId = useRoute().params.postid;
const postId = ref(null);
const PostDetailTopProps = ref({});
onMounted(async () => {
    try {
        // postId 설정
        postId.value = routePostId;

        // postId를 사용하여 백엔드에서 데이터 가져오기
        const response = await axios.get(`http://localhost:8080/posts/view/${postId.value}`);
        const postData = response.data; // 받아온 데이터

        // PostDetailTopProps에 데이터 할당
        PostDetailTopProps.value = {
            title: postData.title,
            content: postData.content,
            image: postData.image,
            postedDate: format(new Date(postData.postedDate[0], postData.postedDate[1] - 1, postData.postedDate[2], postData.postedDate[3], postData.postedDate[4], postData.postedDate[5]), 'yyyy-MM-dd HH:mm:ss'),
            hits: postData.hits,
            categoryId: postData.categoryId,
            memberId: postData.memberId,
            language: postData.language,
            lastModifiedDate: postData.lastModifiedDate
        };

    } catch (error) {
        console.error("Error fetching posts:", error);
    }
});

</script>

<style scoped>
.comment-input textarea {
    width: 100%;
    margin-bottom: 10px;
    padding: 10px;
    border: 1px solid #ccc;
    border-radius: 5px;
    resize: none;
}

.comment-input .btn-submit {
    padding: 10px 20px;
    background-color: #007bff;
    color: #fff;
    border: none;
    border-radius: 5px;
    cursor: pointer;
}

.comment-list .comment-item {
    display: flex;
    justify-content: space-between;
    align-items: flex-start;
    margin-bottom: 15px;
}

.comment-content {
    flex: 1;
}

.nickname {
    font-weight: bold;
    margin-right: 5px;
}

.timestamp {
    color: #777;
    font-size: 0.8rem;
}

.content {
    margin-top: 5px;
}

.comment-actions {
    display: flex;
}

.comment-actions button {
    margin-right: 10px;
    padding: 5px 10px;
    border: none;
    border-radius: 5px;
    cursor: pointer;
}

.btn-report {
    background-color: #ffd4d4;
    border: 2px solid red;
    /* 2px 두께의 빨간색 테두리 추가 */
    border-radius: 5px;
    /* 테두리의 모서리를 둥글게 만듦 */
    padding: 5px 10px;
}

.btn-like {
    background-color: #007bff;
}

.btn-dislike {}

.container {
    display: flex;
    justify-content: center;
    align-items: center;
    height: 8vh;
}

.button-container {
    display: flex;
    justify-content: center;
    gap: 30px;
    /* 버튼 사이의 간격 조정 */
    padding-left: 300px;
}

.report {
    margin-left: auto;
}

.textarea {
    width: 1000px;
    height: 100px;
    border: 1px solid #ccc;
    padding: 10px;
}

.comment {
    margin-top: 10px;
    margin-bottom: 10px;
    padding: 10px;
    border: 1px solid #ccc;
    border-radius: 10px;
}

.tbAdd {
    justify-content: center;
    align-items: center;
    border-collapse: collapse;
    /* 테이블 셀 경계를 합침 */
    width: 100%;
    height: 100vh
}

.tbAdd th,
.tbAdd td {
    border: 1px solid #dee2e6;
    /* 테이블 셀 경계선 스타일 지정 */
    padding: 8px;
    /* 셀 안의 여백 설정 */
    text-align: center;
    /* 셀 안의 텍스트 가운데 정렬 */
}

.tbAdd th {
    background-color: #f8f9fa;
    /* 테이블 헤더 배경색 설정 */
    font-weight: bold;
    /* 테이블 헤더 텍스트 굵게 설정 */
    text-align: center;
}

.tbAdd {
    align-content: center;
}

.tbAdd th,
.tbAdd td {
    border-bottom: 1px solid #d1d1d1;
    padding: 5px 0;
}

.tbAdd td {
    padding: 10px 10px;
    box-sizing: border-box;
    text-align: center;
}

.tbAdd td.txt_cont {
    height: 300px;
    vertical-align: top;
}

.btnWrap {
    text-align: center;
    margin: 20 0 0 0;
    border: 1px solid;
    padding: 0 20%;
}

.btnWrap a {
    margin: 0 10px;
}

.btnAdd {
    background: #43b984
}

.btnDelete {
    background: #f00;
}
</style>