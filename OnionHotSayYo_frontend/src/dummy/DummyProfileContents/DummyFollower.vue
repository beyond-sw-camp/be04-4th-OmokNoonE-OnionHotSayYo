<template>
    <div class="card card-body">
        <h3 class="category-title">{{ type }}</h3>
        <div @click="goDetailList(injectMemberId, type)" class="card-link">더보기</div>
        <table class="table table-hover">
            <tbody class="table-group-divider">
                <tr v-for="(follow, index) in follows" :key="index">
                    <td class="col-number" scope="row">{{ index + 1 }}</td>
                    <td @click="goMemberPage(follow.memberId)" class="col-title">
                        <img :src="follow.image" width="25" height="25" class="col-img rounded-circle" alt="profile 사진">
                        <div>&nbsp; {{ follow.nickname }}</div>
                        <div>&nbsp; ({{ follow.memberId }})</div>
                    </td>
                    <td @click="disappear(follow)">
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
import { format } from 'date-fns';
import { useRouter } from 'vue-router';
import axios from 'axios';
import Iot from "@/assets/image/1ot.png"
import p2 from "@/assets/svg/파2조.svg"
import CodingJo from "@/assets/svg/삼시세끼.svg"
import HighFives from "@/assets/svg/HighFives.svg"
import CINEBUS from "@/assets/svg/CINEBUS.svg"

const injectMemberId = inject("memberId");

const type = "팔로워";

const members = [];

const follows = ref([
    {
        memberId: "1ot",
        nickname: "일오티",
        image: Iot
    },{
        memberId: "pi3dot14159two",
        nickname: "3.141592(π)",
        image: p2
    },{
        memberId: "ThreeMealsADay",
        nickname: "삼시세끼",
        image: CodingJo
    },{
        memberId: "HighFives",
        nickname: "하이파이브즈",
        image: HighFives
    },{
        memberId: "CINEBUS",
        nickname: "시네버스",
        image: CINEBUS
    }
]);

const loadingState = ref(true);

const router = useRouter();

function goDetailList(injectMemberId, type) {
    router.push(`/list/${type}/${injectMemberId}`);
}

function goMemberPage(memberid) {
    router.push(`/mypage/${memberid}`);
}

function disappear(follow) {
    const index = follows.value.indexOf(follow);
    if (index !== -1) {
        follows.value.splice(index, 1);
    }
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