<template>
  <div>
    <button class="btn btn-primary" type="button" data-bs-toggle="offcanvas" data-bs-target="#offcanvasRight"
            aria-controls="offcanvasRight">
      <img src="@/assets/image/OnionHotSayYo.png" width="17" height="17">
      LOGIN
    </button>

    <div class="offcanvas offcanvas-end" tabindex="-1" id="offcanvasRight" aria-labelledby="offcanvasRightLabel">
      <div class="offcanvas-header">
        <h5 id="offcanvasRightLabel">서비스를 이용하시려면 로그인하세요.</h5>
        <button type="button" class="btn-close text-reset" data-bs-dismiss="offcanvas"
                aria-label="Close"></button>
      </div>
      <form>
        <div class="container">
          <div class="row justify-content-center align-items-center">
            <div class="col-md-9">
              <img class="mb-4 mx-auto d-block" src="@/assets/image/OnionHotSayYo.png" alt="" width="72"
                   height="57">
              <h1 class="h3 mb-3 fw-normal text-center">Please Sign In</h1>

              <div class="form-floating">
                <input type="text" class="form-control" id="floatingInput"
                       placeholder="name@example.com" v-model="id">
                <label for="floatingInput">ID</label>
              </div>
              <div class="form-floating">
                <input type="password" class="form-control" id="floatingPassword" placeholder="Password"
                       v-model="password">
                <label for="floatingPassword">Password</label>
              </div>

              <div class="form-check text-start my-3">
                <input class="form-check-input" type="checkbox" value="remember-me"
                       id="flexCheckDefault">
                <label class="form-check-label" for="flexCheckDefault">
                  Remember me
                </label>
              </div>
              <button class="btn btn-primary w-100 py-2" type="submit" @click.prevent="login">Sign In</button>
              <div class="col-md-3 text-end">
                <div>
                  <span style="font-size: 12px;">계정이 없으신가요?</span>
                  <button class="sign-up-btn" type="button">회원가입</button>
                </div>
              </div>
            </div>
          </div>
        </div>
      </form>
    </div>
  </div>
</template>

<script setup>
import {ref} from 'vue';
import {useStore} from 'vuex';
import {useRouter} from "vue-router";
import axios from "axios";

const router = useRouter();

const id = ref('');
const password = ref('');

const store = useStore();

// 로그인 처리
async function login() {
  async function connectSSE(memberId) {
    const eventSource = new EventSource(`http://localhost:8080/notifications/subscribe?memberName=${memberId}`);

    eventSource.addEventListener("sse", async function (event) {
      const data = JSON.parse(event.data);

      // 브라우저 알림
      const showNotification = () => {
        const notification = new Notification("🔔OnionHotSayYo", {
          body: data.message
        });

        setTimeout(() => {
          notification.close();
        }, 10 * 1000);

        notification.addEventListener('click', () => {
          window.open(data.url, '_blank');
        });
      };

      // 브라우저 알림 허용 권한
      let granted = false;

      if (Notification.permission === 'granted') {
        granted = true;
      } else if (Notification.permission !== 'denied') {
        let permission = await Notification.requestPermission();
        granted = permission === 'granted';
      }

      // 알림 보여주기
      if (granted) {
        showNotification();
      }
    });
  }

  try {
    const response = await store.dispatch('login', {
      memberId: id.value,
      password: password.value
    })

    /* SSE 연결 (알림 기능) */
    await connectSSE(id.value);

    await router.push(`/`);
  } catch (error) {
    console.error("Error Login:", error);
  }
}
</script>

<style scoped>
* {
  font-family: 'NanumBarunGothic' !important;
}

.col-md-3 {
  width: 100%
}

.btn {
  background-color: rgb(234, 234, 234);
  border: 1px solid;
  color: black;
  padding: 6px 10px;
  /* 텍스트가 버튼 안에 맞게 들어가도록 padding 수정 */
  font-size: 10px;
  /* 폰트 크기 조정 */
  width: auto;
  /* 버튼의 너비를 자동으로 조정하여 텍스트에 맞게 크기 조절 */
  height: 28px;
  text-align: center;
  /* 텍스트를 가운데 정렬 */
  line-height: 1.6;
  /* 텍스트 세로 중앙 정렬 */
  white-space: nowrap;
}

.sign-up-btn {
  background-color: rgb(255, 255, 255);
  border: 0;
  color: black;
  padding: 6px 10px;
  /* 텍스트가 버튼 안에 맞게 들어가도록 padding 수정 */
  font-size: 10px;
  /* 폰트 크기 조정 */
  width: auto;
  /* 버튼의 너비를 자동으로 조정하여 텍스트에 맞게 크기 조절 */
  height: 28px;
  text-align: center;
  /* 텍스트를 가운데 정렬 */
  line-height: 1.6;
  /* 텍스트 세로 중앙 정렬 */
  white-space: nowrap;
}

.sign-up-btn:hover {
  color: #0026ff;
  /* 버튼에 호버 시 텍스트 색상 변경 */
}

.container {
  position: absolute;
  top: 25%;
}
</style>