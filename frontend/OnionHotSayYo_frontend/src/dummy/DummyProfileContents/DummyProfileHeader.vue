<template>
    <div class="container card text-left profile-header">
        <div class="row container-fluid">
            <div class="col-sm-4 text-center profile-img-container">
                <img src="@/assets/image/OmokNoonEProfile.jpg" alt="프로필 이미지" width="140" height="140"
                    class="rounded-circle profile-img">
            </div>
            <div class="col-sm-8 profile-intro">
                <h2 class="fw-normal"> 오목눈이(OmokNoonE)</h2>
                <p>
                <div>
                    안녕하세요! 오목 오목, 오목눈이입니다!! <br>
                    이곳은 테스트 페이지입니다. 확인해주세요! <br>
                    <br>
                    Github: https://github.com/OmokNoonE <br>
                    Notion: https://www.notion.so/4-5-436274409e674f44b183b8475ec51df5
                </div>
                </p>
            </div>
            <button class="btn-profile-edit" type="button" data-bs-toggle="modal"
                data-bs-target="#editPersonalInfo">개인정보수정 »</button>

            <div class="modal fade" id="editPersonalInfo" tabindex="-1" aria-labelledby="exampleModalLabel"
                aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h1 class="modal-title fs-5" id="exampleModalLabel">개인정보수정</h1>
                            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                        </div>
                        <div class="modal-body">
                            <form>
                                <div class="col-12">
                                    <label for="password" class="form-label">비밀번호</label>
                                    <input type="password"  class="form-control" id="before_password"
                                        placeholder="영어 소문자, 숫자, 특수기호 포함 10글자 이상이어야 합니다.">
                                    <div class="invalid-feedback"></div>
                                </div>
                                <div class="col-12">
                                    <label for="password" class="form-label">변경 비밀번호</label>
                                    <input type="password" class="form-control" id="change_password"
                                        placeholder="영어 소문자, 숫자, 특수기호 포함 10글자 이상이어야 합니다.">
                                    <div class="invalid-feedback"></div>
                                </div>
                                <div class="col-12">
                                    <label for="password" class="form-label">변경 이메일</label>
                                    <input type="email" class="form-control" id="change_email"
                                        placeholder="변경할 이메일을 입력하세요.">
                                    <div class="invalid-feedback"></div>
                                </div>
                                <div class="col-md-5">
                                    <label for="country" class="form-label">관심항목</label>
                                    <select class="form-select" id="favorite_category" required>
                                        <option value="">선택하세요.</option>
                                        <option>질문글</option>
                                        <option>정보글</option>
                                        <option>여행글</option>
                                        <option>맛집글</option>
                                        <option>동호회글</option>
                                        <option>일상글</option>
                                        <option>직장글</option>
                                        <option>구인구직글</option>
                                        <option>중거거래글</option>
                                    </select>
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

            <div class="btn-profile-edit" @click="goMyReports(memberId)" style="top: 62px">나의 신고목록 »</div>

            <div class="modal fade" id="myReports" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h1 class="modal-title fs-5" id="exampleModalLabel">신고목록</h1>
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

            <div class="btn-profile-edit" @click="goMyLetter(memberId)" style="top: 95px">쪽지함 »</div>
        </div>
    </div>
</template>

<script setup>
import { onMounted, ref, watchEffect } from 'vue';
import { useRouter } from 'vue-router';
import { useStore } from 'vuex';
import axios from "axios";

const store = useStore();


const loadingState = ref(true);

const router = useRouter();

router.afterEach(() => {
    window.location.reload();
});

const memberId = "member1";


function goMyLetter(memberId) {
    // router.push(`/notfound`);
    router.push(`/letter/${memberId}`)
}


function goMyReports(memberId) {
    router.push(`/ReportsView`);
    // router.push(`/reports/${memberId}`)
}


</script>

<style scoped>
* {
    font-family: 'NanumBarunGothic' !important;

}

.profile-header {
    display: flex;
    align-items: center;
    justify-content: left;
    position: relative;
    border: 1px solid lightgray;
    margin-top: 20px;
    padding: 30px 10px 10px 10px;
}

.profile-img-container {
    width: fit-content;
    margin: 0px 10px;
}

.profile-img {
    border: 1px solid lightgray;
}

.profile-intro {
    width: 60%;
}

.btn-profile-edit {
    width: fit-content;
    box-sizing: border-box;
    margin: 0;
    text-decoration: none;
    transition: all .4s;
    font-weight: 800;
    position: absolute;
    top: 30px;
    right: 35px;
    padding: 2px 8px;
    border: 1px solid #e0e0e0;
    line-height: 22px;
    font-size: 13px;
    color: #777;
    border-radius: 15px;
    background-color: white;
}

.btn-profile-edit:hover {
    background-color: #e3e3e3;
    cursor: pointer;
}
</style>