<template>

    <div class="AddWrap">
        <form>
            <tr>
                <th>제목</th>
                <td style="padding: 10px;">여기가 제목들어가는 부분</td>
            </tr>
            <table class="tbAdd">
                <colgroup>
                    <col width="1000px" />
                </colgroup>
                <tr>
                    <td>여기가 내용 들어가는 부분</td>
                </tr>
            </table>
        </form>
    </div>
    <div class="container">
        <div class="button-container">
            <div class="like">
                <span>좋아요: {{ likeCount }}</span>
                <button @click="likePost" class="btn_like">좋아요</button>
            </div>
            <div class="dislike">
                <span>싫어요: {{ dislikeCount }}</span>
                <button @click="dislikePost" class="btn_dislike">싫어요</button>
            </div>
        </div>
        <div class="report">
            <button @click="commentPost" class="btn_comment">신고하기</button>
        </div>
    </div>
    <div class="comment">
        <span class="text">댓글</span>
        <hr>
        <p>{{ message }}</p>
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
        <button type="change" id="btn_change" class="btn_change">목록으로</button>
    </div>
    <br>
</template>

<script setup>
import { ref } from 'vue';

const message = ref('');
const likeCount = ref(0);
const dislikeCount = ref(0);


function likePost() {
    likeCount.value++;
}
function dislikePost() {
    dislikeCount.value++;
}
</script>

<style scoped>
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