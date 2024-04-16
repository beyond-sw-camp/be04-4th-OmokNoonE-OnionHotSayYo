<template>
    <div class="card card-body">
        <h3 class="category-title">{{ type }}</h3>
        <div @click="goDetailList(injectMemberId, type)" class="card-link">더보기</div>
        <table class="table table-hover">
            <tbody v-if="!loadingState" class="table-group-divider">
                <tr v-for="follower in followers" :key="follower">
                    <td class="col-number" scope="row">1</td>
                    <td @click="goFollowerPage(follower.memberId)" class="col-title">
                        <img :src="follower.image" width="25" height="25" class="col-img rounded-circle">
                        <div>&nbsp; {{ follower.nickname }}</div>
                        <div>&nbsp; {{ follower.memberId }}</div>
                    </td>
                    <td>
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
</template>

<script setup>
import { inject, ref, readonly, onMounted } from 'vue';
import { useRouter } from 'vue-router';
import { format } from 'date-fns';
import axios from 'axios';

const injectMemberId = inject("memberId");

const type = "팔로워";

const members = [];

const followers = ref([{}]);

const loadingState = ref(true);

onMounted(async () => {
    try {
        const response = await axios.get("http://localhost:30001/members");
        loadingState.value = false;
        members.value = response.data;
        for (let i = 0; i < members.value.length; i++) {
            const memberId = members.value[i].MEMBER_ID;
            const password = members.value[i].PASSWORD;
            const nickname = members.value[i].NICKNAME;
            const image = members.value[i].IMAGE;
            const profile = members.value[i].PROFILE;
            const email = members.value[i].EMAIL;
            const signUpDate = members.value[i].SIGN_UP_DATE;
            const isWithdraw = members.value[i].IS_WITHDRAW;
            const nationalityId = members.value[i].NATIONALITY_ID;

            followers.value[i] = {
                memberId: memberId,
                password: password,
                nickname: nickname,
                image: image,
                profile: profile,
                email: email,
                signUpDate: format(new Date(signUpDate[0], signUpDate[1] - 1, signUpDate[2], signUpDate[3], signUpDate[4], signUpDate[5]), 'yyyy-MM-dd HH:mm:ss'),
                isWithdraw: isWithdraw,
                nationalityId: nationalityId
            };

        }
    } catch (error) {
        console.error("Error fetching members:", error);
    }
});



const router = useRouter();

function goDetailList(injectMemberId, type) {
    router.push(`/list/${type}/${injectMemberId}`);
}

function goFollowerPage(memberid) {
    router.push(`/mypage/${memberid}`);
}
</script>

<style scoped>
* {
    font-family: 'NanumBarunGothic' !important;

}

.card-body {
    margin-bottom: 10px;
}

.card-link {
    align-items: right;
    box-sizing: border-box;
    margin: 0;
    text-decoration: none;
    transition: all .4s;
    font-weight: 800;
    position: absolute;
    display: block;
    right: 15px;
    top: 20px;
    padding: 2px 8px;
    border: 1px solid #e0e0e0;
    line-height: 22px;
    font-size: 13px;
    color: #777;
    border-radius: 15px;
}

.card-link:hover {
    background-color: #e3e3e3;
    cursor: pointer;
}

.profile-details {
    display: flex;
    align-items: center;
    justify-content: center;
    margin: 10px;
    gap: 10px;
    padding: 0px 0px;
}


.col-number {
    text-align: center;
}

.col-title {
    display: flex;
    align-items: center;
    justify-content: center;
    cursor: pointer;
}

.col-link {
    text-decoration: none;
    color: black;
}

[data-bs-theme=dark] .col-link {
    color: white;
}

.col-image {
    cursor: pointer;
}

.col-close {
    color: #bebebe;
    cursor: pointer;
}

.col-close:hover {
    color: #202020;
    cursor: pointer;
}

.col-date {
    text-align: center;
}

.col-hits {
    background-color: red;
    color: white;
    border: 1px #777;
    border-radius: 45%;
}
</style>