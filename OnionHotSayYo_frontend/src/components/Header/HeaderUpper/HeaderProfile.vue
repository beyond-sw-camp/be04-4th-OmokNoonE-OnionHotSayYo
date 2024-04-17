<template>
  <div>
    <button class="btn btn-primary position-relative" type="button" data-bs-toggle="offcanvas" data-bs-target="#offcanvasRight" aria-controls="offcanvasRight">
      <img src="@/assets/image/OmokProfile.png" alt="mdo" width="25" height="25">
      <span class="position-absolute top-0 end-50 translate-middle badge rounded-pill bg-danger">!</span>
    </button>
    <div class="offcanvas offcanvas-end" tabindex="-1" id="offcanvasRight" aria-labelledby="offcanvasRightLabel">
      <div class="offcanvas-header">
        <h5 id="offcanvasRightLabel">{{ memberId }}님 환영합니다.</h5>
        <button type="button" class="btn-close text-reset" data-bs-dismiss="offcanvas" aria-label="Close"></button>
      </div>
      <button class="MyPage" @click="goMyPage(memberId)">MyPage</button>    
      <button class="LogOut"  @click.prevent="logout">Log Out</button>
      <button class="followTest"  @click.prevent="follow">followTest</button>
      <hr>
      <span class="Notification" @click="showToast()">Notification</span>
      <hr>
      <div class="toast-container position-static">
        <div class="toast" role="alert" aria-live="assertive" aria-atomic="true" data-bs-autohide="false" style="margin-left: 25px ">
          <div class="toast-header">
            <img src="@/assets/image/github.png" class="rounded me-2" style="width: 50px; height: 50px;">
            <strong class="me-auto">mem02</strong>
            <small class="text-body-secondary">2 seconds ago</small>
            <button type="button" class="btn-close" data-bs-dismiss="toast" aria-label="Close"></button>
          </div>
          <div class="toast-body">
            회원님의 게시글에 답글을 달았습니다.
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script setup>
import { useRouter } from 'vue-router';
import { Toast } from 'bootstrap';
import { ref, onMounted } from "vue";
import { computed } from 'vue';
import { useStore } from 'vuex';
import axios from "axios";

const store = useStore();
const memberId = ref('');
// const memberId = store.getters.memberInfo.memberId;
const router = useRouter();

onMounted(async () => {
  await store.dispatch('fetchMemberId');
  memberId.value = store.getters.memberInfo.memberId;
});

function goMyPage(memberId) {
  router.push(`/mypage/${memberId.value}`);
}

function showToast() {
  const toasts = document.querySelectorAll('.toast');
  toasts.forEach(toast => new Toast(toast).show());
}

async function logout() {
  try {
    const response = await store.dispatch('logout')
    console.log(response)
  } catch (error) {
    console.error("Error Logout:", error);
  }
}

async function follow() {
  const followData = {
    fromMemberId: "member1",
    toMemberId: store.getters.memberInfo.memberId
  };

  const response = await axios.post('http://localhost:8080/follows/follow', followData);
  console.log(response)

  if (response.status === 201) {
    console.log('팔로우 요청이 성공적으로 전송되었습니다.');
  } else {
    console.error('팔로우 요청 실패:', response.statusText);
  }
}
</script>

<style scoped>
* {
  font-family: 'NanumBarunGothic' !important;
}

.btn {
  background-color: white;
  border-color: lightgray;
}

.Notification {
  font-weight: bold;
  font-size: 25px;
  margin-left: 33%;
}

.card {
  margin-left: 5%;
  margin-right: 5%;
  margin-bottom: 5%;
}
</style>