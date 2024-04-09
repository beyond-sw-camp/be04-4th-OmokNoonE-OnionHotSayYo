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
            <div @click="goMemberDetail(memberId)" class="btn-profile-edit" href="#">개인정보수정 »</div>
            <div @click="goReports(memberId)" class="btn-profile-edit" href="#" style="top: 63px">내
                신고내역 »</div>
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

function goReports(memberId) {
    router.push(`/notfound`);
    // router.push(`/reports/${memberId}`)
}

function goMemberDetail(memberId) {
    router.push(`/notfound`);
    // router.push(`/member/modify/${memberId}`)
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
}
</style>