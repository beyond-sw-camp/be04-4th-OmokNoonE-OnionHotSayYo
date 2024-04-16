<template>
    <div class="list-container">
        <div class="list-header">
            <h5 id="category-name">{{ categoryName }}</h5>
            <button type="button" class="btn btn-light" @click="goToWrite">글 작성</button>
        </div>
        <div id="table-container">
            <table class="table table-hover">
                <thead>
                    <tr>
                        <th class="POSTING_ID" scope="col">번호</th>
                        <th class="TITLE" scope="col">제목</th>
                        <th class="MEMBER_ID" scope="col">글쓴이</th>
                        <th class="HITS" scope="col">조회</th>
                        <!-- <th class="LANGUAGE" scope="col">좋아요</th>
                        <th class="LOCATION_ID" scope="col">싫어요</th> -->
                        <th class="POSTED_DATE" scope="col">게시 날짜</th>
                    </tr>
                </thead>
                <tbody class="table-group-divider" v-if="props.posts">
                    <tr v-for="post in pagePost" :key="posts.postingId">
                        <td class="POSTING_ID">{{ post.postingId }}</td>
                        <td class="TITLE" @click="goDetailPage(post.postingId)">{{ post.title }}</td>
                        <td class="MEMBER_ID">{{ post.memberId }}</td>
                        <td class="HITS">{{ post.hits }}</td>
                        <td class="LANGUAGE">{{ post.language }}</td>
                        <td class="LOCATION_ID">{{ post.locationId }}</td>
                        <td class="POSTED_DATE">{{ post.postedDate }}</td>
                    </tr>
                </tbody>
            </table>
        </div>
        <div id="pagenation-container">
            <ul class="pagination">
              <!-- 이전 페이지 버튼 -->
              <li class="page-item" @click="goToPage(currentPage - 1)" :disabled="currentPage === 1">
                <a class="page-link" href="#" aria-label="Previous">
                  <span aria-hidden="true">&laquo;</span>
                </a>
              </li>
              <!-- 페이지 버튼 -->
              <li class="page-item" v-for="page in totalPages" :key="page" :class="{ 'active': page === currentPage }">
                <a class="page-link" href="#" @click="goToPage(page)">{{ page }}</a>
            </li>
              <!-- 다음 페이지 버튼 -->
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
import { ref, watch, defineProps, computed } from 'vue';
import { useRouter } from 'vue-router';

const router = useRouter();

const props = defineProps({
    posts: [{}],
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
console.log(props.posts);

// 한 페이지에 보여질 게시글 수
const postsPerPage = 10;

// 전체 페이지 수 계산
const totalPages = computed(() => Math.ceil(props.posts.length / postsPerPage));

// 현재 페이지 상태 변수
const currentPage = ref(1);

// 현재 페이지에 해당하는 게시글 목록을 계산하는 계산된 속성
const currentPagePosts = computed(() => {
  const startIndex = (currentPage.value - 1) * postsPerPage;
  const endIndex = startIndex + postsPerPage;
  return props.posts.slice(startIndex, endIndex);
});

// 페이지를 변경하는 함수
function goToPage(pageNumber) {
    if (pageNumber >= 1 && pageNumber <= totalPages.value) {
        currentPage.value = pageNumber;
    }
}

function goDetailPage(postId) {
    router.push(`/view/${postId}`)
};

function goToWrite(){
    router.push(`/posts/creates`)
};

router.afterEach((to, next, from) => {
    if (to.path !== from.path) {
        window.location.reload();
    } else {
        next();
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