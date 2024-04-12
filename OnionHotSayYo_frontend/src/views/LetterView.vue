<template>
    <main class="card container letter-container ">
        <div class="d-flex align-items-center p-3 my-3 text-white bg-header rounded shadow-sm">
            <div class="member-info">
                <h3>&nbsp;쪽지</h3>
            </div>
            <button class="send-letter" type="button" data-bs-toggle="modal"
                data-bs-target="#send-letter">쪽지 쓰기 »</button>

            <div class="modal fade" id="send-letter" tabindex="-1" aria-labelledby="exampleModalLabel"
                aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h1 class="modal-title fs-5" id="exampleModalLabel">쪽지 쓰기</h1>
                            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                        </div>
                        <div class="modal-body">
                            <form>
                                <div class="mb-3">
                                    <label for="recipient-name" class="col-form-label">수신자</label>
                                    <input type="text" class="form-control" id="recipient-name">
                                </div>
                                <div class="mb-3">
                                    <label for="message-text" class="col-form-label">내용:</label>
                                    <textarea class="form-control" id="message-text"></textarea>
                                </div>
                            </form>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">취소</button>
                            <button type="button" class="btn btn-primary">발송</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <ReceiveList />
        <SendList />
    </main>
</template>

<script setup>
import ReceiveList from '@/components/Section/Letter/ReceiveList.vue';
import SendList from '@/components/Section/Letter/SendList.vue';

import { provide, ref, onMounted } from 'vue';
import { useRoute, useRouter } from 'vue-router';
import axios from 'axios';

const routeMemberId = useRoute().params.memberid;

const members = [];

const memberProps = ref({});

const loadingState = ref(true);

const router = useRouter();

router.afterEach(() => {
    window.location.reload();
});

provide('memberId', routeMemberId);

onMounted(async () => {
    try {
        const response = await axios.get("http://localhost:8080/members");
        loadingState.value = false;
        members.value = response.data;
        for (let i = 0; i < members.value.length; i++) {
            if (members.value[i].MEMBER_ID == routeMemberId) {
                const memberId = members.value[i].MEMBER_ID;
                const password = members.value[i].PASSWORD;
                const nickname = members.value[i].NICKNAME;
                const image = members.value[i].IMAGE;
                const profile = members.value[i].PROFILE;
                const email = members.value[i].EMAIL;
                const signUpDate = members.value[i].SIGN_UP_DATE;
                const isWithdraw = members.value[i].IS_WITHDRAW;
                const nationalityId = members.value[i].NATIONALITY_ID;

                memberProps.value = {
                    memberId: memberId,
                    password: password,
                    nickname: nickname,
                    image: image,
                    profile: profile,
                    email: email,
                    signUpDate: signUpDate,
                    isWithdraw: isWithdraw,
                    nationalityId: nationalityId
                };
            }
        }
    } catch (error) {
        console.error("Error fetching members:", error);
    }
});


</script>

<style scoped>
* {
    font-family: 'NanumBarunGothic' !important;

}

.bg-header {
    background-color: #652424;
}

.modal {
    color: black !important;
}

.letter-container {
    width: 85%;
}

.member-info {
    display: flex;
    align-items: center;
    justify-content: space-between;
    gap: 10px;
}

.send-letter {
    width: fit-content;
    box-sizing: border-box;
    margin: 0;
    text-decoration: none;
    transition: all .4s;
    font-weight: 800;
    position: absolute;
    top: 35px;
    right: 30px;
    padding: 2px 8px;
    border: 1px solid #e0e0e0;
    line-height: 22px;
    font-size: 13px;
    color: #777;
    border-radius: 15px;
    background-color: white;
}

.send-letter:hover {
    background-color: #e3e3e3;
    cursor: pointer;
}
</style>