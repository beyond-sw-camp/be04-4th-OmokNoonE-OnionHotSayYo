<template>
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
            <button type="button" data-bs-toggle="modal" data-bs-target="#exampleModal">신고하기</button>

            <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel"
                aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h1 class="modal-title fs-5" id="exampleModalLabel">신고하기</h1>
                            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                        </div>
                        <div class="modal-body">
                            <form>
                                <div class="mb-3">
                                    <label for="recipient-name" class="col-form-label">신고 제목</label>
                                    <input type="text" class="form-control" id="recipient-name">
                                </div>
                                <div class="mb-3">
                                    <label for="message-text" class="col-form-label">신고 내용:</label>
                                    <textarea class="form-control" id="message-text"></textarea>
                                </div>
                            </form>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">닫기</button>
                            <button type="button" class="btn btn-primary">제출</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</template>

<script setup>
import { ref } from 'vue';
import { useRouter } from "vue-router";

const likeCount = ref(0);
const dislikeCount = ref(0);
const router = useRouter();


function likePost() {
    likeCount.value++;
}
function dislikePost() {
    dislikeCount.value++;
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
    border: 2px solid red; /* 2px 두께의 빨간색 테두리 추가 */
    border-radius: 5px; /* 테두리의 모서리를 둥글게 만듦 */
    padding: 5px 10px; 
  }

  .btn-like{
    background-color: #007bff;
  }

  .btn-dislike{

  }

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