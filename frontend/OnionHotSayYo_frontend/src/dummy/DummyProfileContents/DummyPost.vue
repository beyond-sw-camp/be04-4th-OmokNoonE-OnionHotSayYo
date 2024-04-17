<template>
    <div class="card card-body">
        <h3 class="category-title">{{ type }}</h3>
        <div @click="goDetailList(injectMemberId, type)" class="card-link">더보기</div>
        <table class="table table-hover">
            <tbody class="table-group-divider">
                <tr v-for="(post, index) in copyPosts" :key="post">
                    <td class="col-number" scope="row">{{ index + 1 }}</td>
                    <td @click="goPostDetailPage(post.postingId)" class="col-title">
                        {{ post.title }}
                    </td>
                    <td class="col-date">{{ post.lastModifiedDate }}</td>
                    <td>
                        <div class="col-hits">{{ post.hits }}</div>
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

const injectMemberId = inject("memberId");

const type = "작성글";

const posts = [];

const copyPosts = ref([
    {
        postingId: 1,
        title: "신대방 삼거리 맛집 추천",
        hits: 22,
        lastModifiedDate: "2024-01-24"
    },
    {
        postingId: 2,
        title: "구인구직, 당신도 할 수 있다!",
        hits: 252,
        lastModifiedDate: "2024-01-25"
    },
    {
        postingId: 3,
        title: "어제 다녀온 한강 후기",
        hits: 624,
        lastModifiedDate: "2024-02-21"
    },
    {
        postingId: 4,
        title: "라꾸라꾸 팝니다",
        hits: 44,
        lastModifiedDate: "2024-02-22"
    },
    {
        postingId: 5,
        title: "산악회 모집합니다.",
        hits: 42,
        lastModifiedDate: "2024-03-24"
    }
]);

const loadingState = ref(true);

// onMounted(async () => {
//     try {
//         const response = await axios.get("http://localhost:30001/post?_start=1&_limit=5");
//         loadingState.value = false;
//         posts.value = response.data;
//         for (let i = 0; i < posts.value.length; i++) {
//             const postingId = posts.value[i].POST_ID;
//             const title = posts.value[i].TITLE;
//             const content = posts.value[i].CONTENT;
//             const image = posts.value[i].IMAGE;
//             const hits = posts.value[i].HITS;
//             const isDeleted = posts.value[i].IS_DELETED;
//             const lastModifiedDate = posts.value[i].LAST_MODIFIED_DATE;
//             const categoryId = posts.value[i].CATEGORY_ID;
//             const memberId = posts.value[i].MEMBER_ID;
//             const language = posts.value[i].LANGUAGE;
//             const locationId = posts.value[i].LOCATION_ID;

//             copyPosts.value[i] = {
//                 postingId: postingId,
//                 title: title,
//                 content: content,
//                 image: image,
//                 hits: hits,
//                 isDeleted: isDeleted,
//                 lastModifiedDate: format(new Date(lastmodifiedDate[0], lastmodifiedDate[1] - 1, lastmodifiedDate[2], lastmodifiedDate[3], lastmodifiedDate[4], lastmodifiedDate[5]), 'yyyy-MM-dd HH:mm:ss'),
//                 categoryId: categoryId,
//                 memberId: memberId,
//                 language: language,
//                 locationId: locationId
//             };

//         }
//     } catch (error) {
//         console.error("Error fetching posts:", error);
//     }
// });



const router = useRouter();

function goDetailList(injectMemberId, type) {
    router.push(`/list/${type}/${injectMemberId}`);
}

function goPostDetailPage(postid) {
    router.push(`/posts/view/${postid}`);
}

function disappear(bookmark) {
    const index = bookmarks.value.indexOf(bookmark);
    if (index !== -1) {
        bookmarks.value.splice(index, 1);
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
    color: red;
    border: 1px #777;
}
</style>