<template>
    <div>
        <button class="btn btn-primary" type="button" data-bs-toggle="offcanvas" data-bs-target="#offcanvasRight"
            aria-controls="offcanvasRight" @click.prevent="logout">
            <img src="@/assets/image/OnionHotSayYo.png" width="17" height="17">
            LOGOUT
        </button>

        
    </div>
</template>

<script setup>
import {useStore} from 'vuex';

const store = useStore();
async function logout() {
  try {
    const response = await store.dispatch('logout')
    console.log(response)
  } catch (error) {
    console.error("Error Logout:", error);
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