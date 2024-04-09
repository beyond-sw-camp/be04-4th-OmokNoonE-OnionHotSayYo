<template>
    <Loading v-if="loadingState" />
    <div v-if="!loadingState">
        <ProfileHeader :memberProps="memberProps" />
        <ProfileContents :memberId="memberProps.memberId"/>
    </div>

</template>

<script setup>
import { provide, ref, readonly, onMounted } from 'vue';
import { useRoute } from 'vue-router';
import axios from 'axios';
import Loading from '@/components/Section/Loading/Loading.vue';
import ProfileHeader from '@/components/Section/PersonalPage/Profile/ProfileHeader.vue';
import ProfileContents from '@/components/Section/PersonalPage/Profile/ProfileContents/ProfileContentsUnion.vue';

const routeMemberId = useRoute().params.memberid;

const members = [];

const memberProps = ref({});

const loadingState = ref(true);

provide( 'memberId', readonly(memberProps.memberId) );

onMounted(async () => {
    try {
        const response = await axios.get("http://localhost:8081/members");
        // const response = await axios.get(`http://localhost:8081/mypage?member_id=${routeMemberId}`);
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
</style>