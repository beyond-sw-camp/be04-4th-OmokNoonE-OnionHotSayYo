<template>
    <div class="container card text-left profile-header">
        <div class="row container-fluid">
            <div class="col-sm-4 text-center profile-img-container">
                <img :src="image" alt="mdo" width="140" height="140" class="rounded-circle profile-img">
            </div>
            <div class="col-sm-8 profile-intro">
                <h2 class="fw-normal"> {{ nickname }}({{ memberId }})</h2>
                <p>
                <div v-html="profile"></div>
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

            <button class="btn-profile-edit" type="button" data-bs-toggle="modal" data-bs-target="#myReports"
            style="top: 63px"> 내 신고내역 »</button>
            
            <div class="modal fade" id="myReports" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h1 class="modal-title fs-5" id="exampleModalLabel">내 신고하기</h1>
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
import { ref, watchEffect } from 'vue';
import { useRouter } from 'vue-router';

const profileHeaderProps = defineProps({
    memberProps: [{}]
});

const memberId = ref('');
const image = ref('');
const nickname = ref('');
const profile = ref();

watchEffect((newValue, oldValue) => {
    memberId.value = profileHeaderProps.memberProps.memberId;
    image.value = profileHeaderProps.memberProps.image;
    nickname.value = profileHeaderProps.memberProps.nickname;
    profile.value = profileHeaderProps.memberProps.profile.replace(/\n/g, '<br>');

});

const router = useRouter();

function goMyLetter(memberId) {
    router.push(`/notfound`);
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