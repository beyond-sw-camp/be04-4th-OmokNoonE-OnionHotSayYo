<template>
    <form class="d-flex" role="search">
        <select class="form-select" id="category" required="" v-model="routeType">
            <option value="작성글">작성글</option>
            <option value="댓글">댓글</option>
            <option value="북마크">북마크</option>
            <option value="좋아요">좋아요</option>
            <option value="팔로우">팔로우</option>
            <option value="팔로워">팔로워</option>
        </select>
        <select class="form-select" id="search-type" required="">
            <option value="title">제목</option>
            <option>내용</option>
            <option>제목+내용</option>
        </select>
        <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
        <button class="btn btn-outline-secondary" type="submit">
            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-search"
                viewBox="0 0 16 16">
                <path
                    d="M11.742 10.344a6.5 6.5 0 1 0-1.397 1.398h-.001q.044.06.098.115l3.85 3.85a1 1 0 0 0 1.415-1.414l-3.85-3.85a1 1 0 0 0-.115-.1zM12 6.5a5.5 5.5 0 1 1-11 0 5.5 5.5 0 0 1 11 0" />
            </svg>
        </button>
    </form>

    <div class="list-container">
        <div class="list-header">
            <h5 id="category-name">{{ routeType }}</h5>
        </div>
        <div id="table-container">
            <table class="table table-hover">
                <thead>
                    <tr v-if="['북마크', '좋아요', '작성글', '댓글'].includes(routeType)">
                        <th class="col-number" scope="col">번호</th>
                        <th class="col-title" scope="col">
                            제목
                            <p class="comment" v-if="routeType == '댓글'">(댓글 내용)</p>
                        </th>
                        <th class="col-hits" scope="col">조회</th>
                        <th class="col-like" scope="col">좋아요</th>
                        <th class="col-dislike" scope="col">싫어요</th>
                        <th class="col-date" scope="col">날짜</th>
                    </tr>
                    <tr v-if="['팔로우', '팔로워'].includes(routeType)">
                        <th class="col-number" scope="col">번호</th>
                        <th class="col-title" scope="col">
                            ID
                            <p class="comment">(닉네임)</p>
                        </th>
                        <th class="col-like" scope="col">팔로우</th>
                        <th class="col-dislike" scope="col">팔로워</th>
                        <th class="col-date" scope="col">삭제</th>
                    </tr>
                </thead>
                <tbody class="table-group-divider">
                    <tr v-if="['북마크', '좋아요', '작성글', '댓글'].includes(routeType)">
                        <td class="col-number" scope="row">1</td>
                        <td class="col-title">
                            단기 알바 구해요
                            <p class="comment" v-if="routeType == '댓글'">(정말 유익)</p>
                        </td>
                        <td class="col-hits">55</td>
                        <td class="col-like">0</td>
                        <td class="col-dislike">0</td>
                        <td class="col-date">23-01-22</td>
                    </tr>
                    <tr v-if="['팔로우', '팔로워'].includes(routeType)">
                        <td class="col-number" scope="col">1</td>
                        <td class="col-title" scope="col">
                            mem01
                            <p class="comment">omoknoone1</p>
                        </td>
                        <td class="col-like" scope="col">100</td>
                        <td class="col-dislike" scope="col">25</td>
                        <td class="col-close" scope="col">
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
        <div id="pagenation-container">
            <ul class="pagination">
                <li class="page-item">
                    <a class="page-link" href="#" aria-label="Previous">
                        <span aria-hidden="true">&laquo;</span>
                    </a>
                </li>
                <li class="page-item"><a class="page-link" href="#">1</a></li>
                <li class="page-item"><a class="page-link" href="#">2</a></li>
                <li class="page-item"><a class="page-link" href="#">3</a></li>
                <li class="page-item">
                    <a class="page-link" href="#" aria-label="Next">
                        <span aria-hidden="true">&raquo;</span>
                    </a>
                </li>
            </ul>
        </div>
    </div>
</template>

<script setup>
import { provide, ref, readonly, onMounted } from 'vue';
import { useRoute } from 'vue-router';

const routeMemberId = useRoute().params.memberid;
const routeType = useRoute().params.type;

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

.comment {
    display: inline;
    color: #777;
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


.col-close {
    display: flex;
    align-items: center;
    justify-content: center;
    color: #bebebe;
    cursor: pointer;
}

.col-close:hover {
    color: #202020;
    cursor: pointer;
}

</style>
