<template>
    <div class="list-container">
        <div class="list-header">
            <h5 id="category-name">'{{ searchTitle }}' {{ props.language }} 검색 결과</h5>
            <button type="button" class="btn btn-light" @click="goToWrite">글 작성</button>
        </div>
        <Loading v-if="loadingState" />

        <div id="table-container" v-if="!loadingState">
            <table class="table table-hover">
                <thead>
                    <tr>
                        <th class="POST_ID" scope="col">번호</th>
                        <th class="TITLE" scope="col">제목</th>
                        <th class="MEMBER_ID" scope="col">글쓴이</th>
                        <th class="POSTED_DATE" scope="col">날짜</th>
                        <th class="HITS" scope="col">조회수</th>
                    </tr>
                </thead>

                <tbody class="table-group-divider">
                    <tr v-for="post in resultValue" :key="post.postId">
                        <td class="POST_ID">{{ post.postId }}</td>
                        <td class="TITLE" @click="goDetailPage(post.postId)">{{ post.title }}</td>
                        <td class="MEMBER_ID">{{ props.posts.find(pPost => pPost.postingId === post.postId)?.memberId }}
                        </td>
                        <td class="POSTED_DATE">{{ props.posts.find(pPost => pPost.postingId ===
                            post.postId)?.postedDate }}</td>
                        <td class="HITS">{{ props.posts.find(pPost => pPost.postingId === post.postId)?.hits }}</td>
                    </tr>
                </tbody>
            </table>
        </div>
        <div id="pagenation-container">
            <ul class="pagination">
                <li class="page-item" @click="goToPage(currentPage - 1)" :disabled="currentPage === 1">
                    <a class="page-link" href="#" aria-label="Previous">
                        <span aria-hidden="true">&laquo;</span>
                    </a>
                </li>
                <li class="page-item" v-for="page in totalPages" :key="page"
                    :class="{ 'active': page === currentPage }">
                    <a class="page-link" href="#" @click="goToPage(page)">{{ page }}</a>
                </li>
                <li class="page-item" @click="goToPage(currentPage + 1)" :disabled="currentPage === totalPages">
                    <a class="page-link" href="#" aria-label="Next">
                        <span aria-hidden="true">&raquo;</span>
                    </a>
                </li>
            </ul>
        </div>
    </div>
</template>

<script setup>
import { ref, defineProps, computed, onMounted } from 'vue';
import { useRouter } from 'vue-router';
import axios from 'axios';
import Loading from '@/components/Section/Loading/Loading.vue';


const router = useRouter();

const props = defineProps({
    posts: [{}],
    language: String || null,
    searchTitle: String
});

const postsPerPage = 10;
const currentPage = ref(1);
const totalPages = computed(() => Math.ceil(props.posts.length / postsPerPage));
const loadingState = ref(false);
const resultValue = ref([]);

async function fetchPageData(pageNumber) {
    try {
        const data = props.posts.map(post => ({
            postId: post.postingId,
            language: props.language,
            title: post.title,
            content: post.content
        }));

        const response = await axios.post('http://localhost:8888/translators/translate', data);
        return response.data;
    } catch (error) {
        console.error('Error fetching page data:', error);
        return [];
    }
}

const currentPagePosts = ref([]);

async function goToPage(pageNumber) {
    loadingState.value = true;
    if (pageNumber >= 1 && pageNumber <= totalPages.value) {
        currentPage.value = pageNumber;
    }
    currentPagePosts.value = await fetchPageData(pageNumber);
    console.log("Current page:", currentPagePosts.value);
    resultValue.value = currentPagePosts.value.result.result;
    console.log("Current page:", currentPagePosts.value.result.result[0]);
    loadingState.value = false;
}

function goDetailPage(postId) {
    router.push(`/view/${postId}`)
}

function goToWrite() {
    router.push(`/posts/creates`)
}

router.afterEach((to, next, from) => {
    if (to.path !== from.path) {
        window.location.reload();
    } else {
        next();
    }
});

onMounted(async () => {
    try {
        loadingState.value = true;
        // props.posts가 완전히 로드될 때까지 기다립니다.
        await new Promise(resolve => setTimeout(resolve, 1000));

        await new Promise(resolve => {
            console.log('length: ' + props.posts.length);
            if (props.posts.length > 0) {
                resolve();
            }
        });

        // props.posts 배열이 비어 있는지 확인합니다.
        if (props.posts.length === 0) {
            console.error('props.posts 배열이 비어 있습니다.');
            return;
        }


        // props.posts의 데이터를 가공합니다.
        const data = props.posts.map(post => {
            // 속성에 접근하기 전에 해당 속성이 존재하는지 확인합니다.
            const postId = post.postingId || '';
            const title = post.title || '';
            const content = post.content || '';
            return {
                postId: postId,
                language: props.language,
                title: title,
                content: content
            };
        });

        // 데이터를 사용하여 원하는 작업을 수행합니다.
        console.log('가공된 데이터:', data);

        if (props.language) {
            const response = await axios.post('http://localhost:8888/translators/translate', data);
            console.log(response.status);
            currentPagePosts.value = response.data;
            console.log(currentPagePosts.value);
            resultValue.value = currentPagePosts.value.result.result;
        }
        else {
            resultValue.value = data;
        }
        console.log(resultValue.value);
        loadingState.value = false;


    } catch (error) {
        console.error('Error:', error);
    }
});

</script>

<style scoped>
.btn-group {
    margin-left: 0%;
}

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