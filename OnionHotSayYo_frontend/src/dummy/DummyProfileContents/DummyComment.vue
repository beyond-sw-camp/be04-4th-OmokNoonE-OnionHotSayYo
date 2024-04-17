<template>
    <div class="card card-body">
        <h3 class="category-title">{{ type }}</h3>
        <div @click="goDetailList(injectMemberId, type)" class="card-link">더보기</div>
        <table class="table table-hover">
            <tbody class="table-group-divider">
                <tr v-for="comment in comments" :key="comment">
                    <td class="col-number" scope="row">{{ comment.postingId }}</td>
                    <td @click="goPostDetailPage(comment.postingId)" class="col-title">
                        {{ comment.title }}
                    </td>
                    <td class="col-date">{{ comment.lastModifiedDate }}</td>
                    <td @click="disappear(comment)">
                        &nbsp;
                        <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor"
                            class="bi bi-x-circle col-close" viewBox="0 0 16 16">
                            <path d="M8 15A7 7 0 1 1 8 1a7 7 0 0 1 0 14m0 1A8 8 0 1 0 8 0a8 8 0 0 0 0 16" />
                            <path
                                d="M4.646 4.646a.5.5 0 0 1 .708 0L8 7.293l2.646-2.647a.5.5 0 0 1 .708.708L8.707 8l2.647 2.646a.5.5 0 0 1-.708.708L8 8.707l-2.646 2.647a.5.5 0 0 1-.708-.708L7.293 8 4.646 5.354a.5.5 0 0 1 0-.708" />
                        </svg>
                        &nbsp;
                    </td>
                </tr>
            </tbody>
        </table>
    </div>
</template>

<script setup>
import { inject, ref, onMounted } from 'vue';
import { format } from 'date-fns';
import { useRouter } from 'vue-router';
import axios from 'axios';
import { useStore } from 'vuex';

const store = useStore();
const memberId = store.getters.memberInfo.memberId;

const injectMemberId = inject("memberId");

const type = "댓글";

const posts = [];

const comments = ref([
    {
        postingId: 1,
        title: "감사합니다. 선생님 많은 도움이 되었습니다.",
        lastModifiedDate: "2024-01-21"
    },
    {
        postingId: 2,
        title: "ㅋㅋㅋㅋㅋㅋㅋㅋ",
        lastModifiedDate: "2024-01-28"
    },
    {
        postingId: 3,
        title: "댓글 어떻게 삭제하나요? ㅠㅠ",
        lastModifiedDate: "2024-02-22"
    },
    {
        postingId: 4,
        title: "정말 좋은 정보! 좋아요 드립니다!",
        lastModifiedDate: "2024-02-24"
    },
    {
        postingId: 5,
        title: "나도 줘잉",
        lastModifiedDate: "2024-03-22"
    }
]);
const loadingState = ref(true);



const router = useRouter();

function goDetailList(injectMemberId, type) {
    router.push(`/list/${type}/${injectMemberId}`);
}

function goPostDetailPage(postid) {
    router.push(`/posts/view/${postid}`);
}

function disappear(comment) {
    const index = comments.value.indexOf(comment);
    if (index !== -1) {
        comments.value.splice(index, 1);
    }
}
</script>

<style scoped>
* {
    font-family: 'NanumBarunGothic' !important;

}

.card-body {
    margin-bottom: 10px;
}

.card-link {
    align-items: right;
    box-sizing: border-box;
    margin: 0;
    text-decoration: none;
    transition: all .4s;
    font-weight: 800;
    position: absolute;
    display: block;
    right: 15px;
    top: 20px;
    padding: 2px 8px;
    border: 1px solid #e0e0e0;
    line-height: 22px;
    font-size: 13px;
    color: #777;
    border-radius: 15px;
}

.card-link:hover {
    background-color: #e3e3e3;
    cursor: pointer;
}

.profile-details {
    display: flex;
    align-items: center;
    justify-content: center;
    margin: 10px;
    gap: 10px;
    padding: 0px 0px;
}


.col-number {
    text-align: center;
}

.col-title {
    display: flex;
    align-items: center;
    justify-content: center;
    cursor: pointer;
}

.col-link {
    text-decoration: none;
    color: black;
}

[data-bs-theme=dark] .col-link {
    color: white;
}

.col-image {
    cursor: pointer;
}

.col-close {
    color: #bebebe;
    cursor: pointer;
}

.col-close:hover {
    color: #202020;
    cursor: pointer;
}

.col-date {
    text-align: center;
}

.col-hits {
    background-color: red;
    color: white;
    border: 1px #777;
    border-radius: 45%;
}
</style>