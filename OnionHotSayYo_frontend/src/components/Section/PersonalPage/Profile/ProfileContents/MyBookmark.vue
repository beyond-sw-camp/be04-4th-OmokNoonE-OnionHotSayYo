<template>
    <div class="card card-body">
        <h3 class="category-title">{{ type }}</h3>
        <div @click="goDetailList(injectMemberId, type)" class="card-link">더보기</div>
        <table class="table table-hover">
            <tbody v-if="!loadingState" class="table-group-divider">
                <tr v-for="bookmark in bookmarks" :key="bookmark">
                    <td class="col-number" scope="row">1</td>
                    <td @click="goPostDetailPage(bookmark.postingId)" class="col-title">
                        {{ bookmark.title }}
                    </td>
                    <td class="col-date">{{ bookmark.lastModifiedDate }}</td>
                    <td>
                        &nbsp;
                        <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor"
                            class="bi bi-bookmark-dash col-close" viewBox="0 0 16 16">
                            <path fill-rule="evenodd" d="M5.5 6.5A.5.5 0 0 1 6 6h4a.5.5 0 0 1 0 1H6a.5.5 0 0 1-.5-.5" />
                            <path
                                d="M2 2a2 2 0 0 1 2-2h8a2 2 0 0 1 2 2v13.5a.5.5 0 0 1-.777.416L8 13.101l-5.223 2.815A.5.5 0 0 1 2 15.5zm2-1a1 1 0 0 0-1 1v12.566l4.723-2.482a.5.5 0 0 1 .554 0L13 14.566V2a1 1 0 0 0-1-1z" />
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

const injectMemberId = inject("memberId");

const type = "북마크";

const posts = [];

const bookmarks = ref([{}]);

const loadingState = ref(true);

onMounted(async () => {
    try {
        const response = await axios.get("http://localhost:8081/post?_start=1&_limit=5");
        loadingState.value = false;
        posts.value = response.data;
        for (let i = 0; i < posts.value.length; i++) {
            const postingId = posts.value[i].POST_ID;
            const title = posts.value[i].TITLE;
            const content = posts.value[i].CONTENT;
            const image = posts.value[i].IMAGE;
            const isDeleted = posts.value[i].IS_DELETED;
            const lastModifiedDate = posts.value[i].LAST_MODIFIED_DATE;
            const categoryId = posts.value[i].CATEGORY_ID;
            const memberId = posts.value[i].MEMBER_ID;
            const language = posts.value[i].LANGUAGE;
            const locationId = posts.value[i].LOCATION_ID;

            bookmarks.value[i] = {
                postingId: postingId,
                title: title,
                content: content,
                image: image,
                isDeleted: isDeleted,
                lastModifiedDate: format(new Date(lastmodifiedDate[0], lastmodifiedDate[1] - 1, lastmodifiedDate[2], lastmodifiedDate[3], lastmodifiedDate[4], lastmodifiedDate[5]), 'yyyy-MM-dd HH:mm:ss'),
                categoryId: categoryId,
                memberId: memberId,
                language: language,
                locationId: locationId
            };

        }
    } catch (error) {
        console.error("Error fetching posts:", error);
    }
});



const router = useRouter();

function goDetailList(injectMemberId, type) {
    router.push(`/list/${type}/${injectMemberId}`);
}

function goPostDetailPage(postid) {
    router.push(`/view/${postid}`);
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