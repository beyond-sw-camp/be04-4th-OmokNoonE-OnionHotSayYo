<template>
    <div class="card card-body">
        <h3 class="category-title">{{ type }}</h3>
        <div @click="goDetailList(memberId, type)" class="card-link">더보기</div>
        <table class="table table-hover">
            <tbody v-if="!loadingState" class="table-group-divider">
                <tr v-for="like in likes" :key="like">
                    <td class="col-number" scope="row">{{ like.starId }}</td>
                    <td @click="goPostDetailPage(like.postId)" class="col-title">
                        {{ like.title }}
                    </td>
                    <td class="col-date">{{ like.postedDate }}</td>
                    <td>
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
import { inject, ref, readonly, onMounted } from 'vue';
import { format } from 'date-fns';
import { useRouter } from 'vue-router';
import axios from 'axios';
import { useStore } from 'vuex';

const store = useStore();
const memberId = store.getters.memberInfo.memberId;
console.log('좋아요에서의 멤버아이디', memberId);

const type = "좋아요";

const stars = [];

const likes = ref([{}]);

const loadingState = ref(false);

onMounted(async () => {
    try {
        loadingState.value = true;
        console.log('좋아요 통신 시작');
        const response = await axios.get(`http://localhost:8080/stars/list/mystar/${memberId}`);
        console.log('좋아요 상태', response.status)
        stars.value = response.data;
        for (let i = 0; i < stars.value.length; i++) {
            const starId = stars.value[i].starId;
            const postId = stars.value[i].postId;
            const title = stars.value[i].title;
            const postedDate = stars.value[i].postedDate;
            const hits = stars.value[i].hits;

            likes.value[i] = {
                starId: starId,
                postId: postId,
                title: title,
                postedDate: format(new Date(postedDate[0], postedDate[1] - 1, postedDate[2], postedDate[3], postedDate[4], postedDate[5]), 'yyyy-MM-dd HH:mm:ss'),
                hits: hits
            };

        }
    } catch (error) {
        console.error("Error fetching stars:", error);
    }
    loadingState.value = false;

});



const router = useRouter();

function goDetailList(injectMemberId, type) {
    router.push(`/list/${type}/${injectMemberId}`);
}

function goPostDetailPage(postid) {
    router.push(`/posts/view/${postid}`);
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