<template>
    <div class="card card-body">
        <h3 class="category-title">{{ categoryName }} Best</h3>
        <div @click="goCategoryList(props.categoryId)" class="card-link">더보기</div>
        <table class="table table-hover">
            <tbody v-if="!loadingState" class="table-group-divider">
                <tr v-for="post in copyPosts" :key="post">
                    <td class="col-number" scope="row"> {{ post.postingId }} </td>
                    <td @click="goPostDetailPage(post.postingId)" class="col-title">
                        {{ post.title }}
                    </td>
                    <td class="col-date">{{ post.postedDate }}</td> <!-- 변경된 부분 -->
                    <td>
                        <div class="col-hits">{{ post.hits }}</div>
                    </td>
                </tr>
            </tbody>
        </table>
    </div>
</template>

<script setup>
import { ref, defineProps, computed, onMounted } from 'vue';
import { useRouter } from 'vue-router';
import { format } from 'date-fns';
import axios from 'axios';


const posts = [];

const copyPosts = ref([{}]);

const loadingState = ref(true);

const props = defineProps({
    categoryId: String
})

const categoryName = computed(() => {
    if (props.categoryId === '1') {
        return '질문글';
    } else if (props.categoryId === '2') {
        return '정보글';
    } else if (props.categoryId === '3') {
        return '여행글';
    } else if (props.categoryId === '4') {
        return '맛집글';
    } else if (props.categoryId === '5') {
        return '동호회글';
    } else if (props.categoryId === '6') {
        return '일상글';
    } else if (props.categoryId === '7') {
        return '직장글';
    } else if (props.categoryId === '8') {
        return '구인구직글';
    } else {
        return '중고거래글';
    }
});

onMounted(async () => {
    try {
        const response = await axios.get(`/api/posts/list/${props.categoryId}`);
        loadingState.value = false;
        posts.value = response.data.categoryPosts;
        console.log('axios 요청', props.categoryId, '의 ', posts.value);
        for (let i = 0; i < posts.value.length; i++) {
            const postingId = 1;
            const title = posts.value[i].title;
            const hits = posts.value[i].hits;
            const postedDate = posts.value[i].postedDate;
            const categoryId = posts.value[i].categoryId;
            // const content = posts.value[i].content;
            // const lastModifiedDate = posts.value[i].LAST_MODIFIED_DATE;
            // const memberId = posts.value[i].MEMBER_ID;
            // const language = posts.value[i].LANGUAGE;
            // const locationId = posts.value[i].LOCATION_ID;

            copyPosts.value[i] = {
                postingId: postingId,
                title: title,
                hits: hits,
                postedDate: format(new Date(postedDate[0], postedDate[1] - 1, postedDate[2], postedDate[3], postedDate[4], postedDate[5]), 'yyyy-MM-dd HH:mm:ss'),
                categoryId: categoryId
                // , content: content,
                // image: image,
                // isDeleted: isDeleted,
                // memberId: memberId,
                // language: language,
                // locationId: locationId
            };

        }
    } catch (error) {
        console.error("Error fetching posts:", error);
    }
});

const router = useRouter();

function goCategoryList(categoryId) {
    router.push(`/list/${categoryId}`);
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
    color: red;
    border: 1px #777;
}
</style>