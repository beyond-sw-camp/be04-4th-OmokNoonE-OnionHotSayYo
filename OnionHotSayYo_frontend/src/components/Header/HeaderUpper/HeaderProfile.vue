<template>
    <div> 
        <button class="btn btn-primary position-relative" type="button" data-bs-toggle="offcanvas" data-bs-target="#offcanvasRight" aria-controls="offcanvasRight">
            <img src="@/assets/image/OmokProfile.png" alt="mdo" width="25" height="25">
            <span class="position-absolute top-0 end-50 translate-middle badge rounded-pill bg-danger">!</span>
        </button>
            <div class="offcanvas offcanvas-end" tabindex="-1" id="offcanvasRight" aria-labelledby="offcanvasRightLabel">
                <div class="offcanvas-header">
                    <h5 id="offcanvasRightLabel">홍길동님 환영합니다.</h5>
                    <button type="button" class="btn-close text-reset" data-bs-dismiss="offcanvas"
                        aria-label="Close">
                    </button>
                </div>
                <button class="MyPage" @click="goMyPage(memberId)">MyPage</button>    
                <button class="LogOut">Log Out</button>   
                <hr>
                <span class="Notification">Notification</span>
                <hr>
                <div class="toast-container position-static" autohide="false">
                  <div class="toast" role="alert" aria-live="assertive" aria-atomic="true">
                    <div class="toast-header">
                      <img src="@/assets/image/github.png" class="rounded me-2" alt="...">
                      <strong class="me-auto">Bootstrap</strong>
                      <small class="text-body-secondary">just now</small>
                      <button type="button" class="btn-close" data-bs-dismiss="toast" aria-label="Close"></button>
                    </div>
                    <div class="toast-body">
                      See? Just like this.
                    </div>
                  </div>
                
                  <div class="toast" role="alert" aria-live="assertive" aria-atomic="true" autohide="false">
                    <div class="toast-header">
                      <img src="@/assets/image/github.png" class="rounded me-2" alt="...">
                      <strong class="me-auto">Bootstrap</strong>
                      <small class="text-body-secondary">2 seconds ago</small>
                      <button type="button" class="btn-close" data-bs-dismiss="toast" aria-label="Close"></button>
                    </div>
                    <div class="toast-body">
                      Heads up, toasts will stack automatically
                    </div>
                  </div>
                </div>
            </div>
    </div>
</template>

<script setup>
import { useRouter } from 'vue-router';

const router = useRouter();

const memberId = 'mem2';

function goMyPage(memberId){
  router.push(`/mypage/${memberId}`);
}
</script>

<style scoped>
* {
    font-family: 'NanumBarunGothic' !important;
}

.btn{
    background-color: white;
    border-color: lightgray;
}

.Notification{
    font-weight: bold;
    font-size: 25px;
    margin-left: 33%;
}

.card{
    margin-left: 5%;
    margin-right: 5%;
    margin-bottom: 5%;
}
</style>