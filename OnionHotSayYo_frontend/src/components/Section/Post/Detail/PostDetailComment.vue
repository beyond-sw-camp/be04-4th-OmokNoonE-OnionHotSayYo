<template>
    <div class="comment">
        <span class="text">댓글</span>
        <hr>
        <p>{{ message }}</p>
        <div class="comment-list">
            <div class="comment-item">
                <div class="comment-content">
                    <span class="nickname">이순신</span>
                    <span class="timestamp">2 hours ago</span>
                    <p class="content">좋은 정보 공유 감사합니다!!</p>
                </div>
                <div class="comment-actions">
                    <button @click="likePost" class="btn-like"><i class="fas fa-thumbs-up"></i></button>
                    <button @click="dislikePost" class="btn-dislike"><i class="fas fa-thumbs-down"></i></button>
                    <button class="btn-report">
                        <i class="fas fa-exclamation-triangle" style="color: red;"></i>
                    </button>
                </div>
            </div>
        </div>
        <br>
        <br>
        <br>
        <br>
        <br>
        <br>
        <br>
        <br>
        <textarea v-model="message" placeholder="댓글을 입력하세요" style="width: 100%;"></textarea>
        <div style="display: flex; justify-content: flex-end;">
            <button type="submit" id="btn_submit" class="btn_submit">댓글등록</button>
        </div>
    </div>

    <div style="display: flex; justify-content: center;">

        <button @click="goPostListPage" type="change" id="btn_change" class="btn_change">목록으로</button>

    </div>
    <br>
</template>

<script setup>
import '@fortawesome/fontawesome-free/css/all.css';
import { ref } from 'vue';
import { useRouter } from "vue-router";

const message = ref('');
const router = useRouter();

function goPostListPage(){
        router.push(`/list/1`);
    }

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