<template>
    <div class="AddWrap">
        <form>
            <tr>
                <th>제목</th>
                <td style="padding: 10px;">{{ topProps.PostDetailTopProps.title }}</td>
                <td style="padding: 10px; text-align: right;"> 작성일자 : {{ topProps.PostDetailTopProps.postedDate }}</td>
                <td style="padding: 10px; text-align: right;"> 조회수 : {{ topProps.PostDetailTopProps.hits }}</td>
                <td style="padding: 10px; text-align: right;"> 작성자 : {{ topProps.PostDetailTopProps.memberId }}</td>
            </tr>
            <table class="tbAdd">
                <tr>
                    <td class="td1" style="height: 500px">
                        <img :src="topProps.PostDetailTopProps.image" alt="Post Image" style="width: 800px; height: 400px" />
                    </td>
                </tr>
                <tr>
                    <td>
                        <!-- <div v-embed="topProps.PostDetailTopProps.content"></div> -->
                        <div v-html="topProps.PostDetailTopProps.content"></div>
                    </td>
                </tr>
            </table>
        </form>
    </div>
</template>

<script setup>
import { useRouter } from "vue-router";

const router = useRouter();

const topProps = defineProps({
    PostDetailTopProps: [{}]
})

</script>

<style scoped>
/* 이미지가 테이블 셀 안에 꽉 차도록 하는 클래스 */
.full-width {
    width: 100%;
    height:auto;
}

/* 테이블 스타일링 */
.tbAdd {
    border-collapse: collapse;
    margin: 0 auto;
    /* 가운데 정렬을 위해 margin을 auto로 설정 */
}

.tbAdd th,
.tbAdd td {
    border: 1px solid #dee2e6;
    padding: 8px;
    text-align: left;
}

.tbAdd th {
    background-color: #f8f9fa;
    font-weight: bold;
}

.tbAdd td {
    border-bottom: 1px solid #d1d1d1;
}

.tbAdd td.txt_cont {
    height: 300px;
    vertical-align: top;
}


.comment-input textarea {
    width: 50%;
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
    text-align: left;
   
}

.tbAdd th {
    background-color: #f8f9fa;
    /* 테이블 헤더 배경색 설정 */
    font-weight: bold;
    /* 테이블 헤더 텍스트 굵게 설정 */
    text-align: left;
}

.tbAdd {
    align-content: left;
}

.tbAdd th,
.tbAdd td {
    border-bottom: 1px solid #d1d1d1;
    padding: 5px 0;
}

.tbAdd td {
    padding: 10px 10px;
    box-sizing: border-box;
    text-align: left;
    vertical-align: top;
}

.tbAdd td.txt_cont {
    height: 300px;
    vertical-align: top;
}

.btnWrap {
    text-align: left;
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