<template>
    <svg xmlns="http://www.w3.org/2000/svg" class="d-none">
        <symbol id="check2" viewBox="0 0 16 16">
            <path
                d="M13.854 3.646a.5.5 0 0 1 0 .708l-7 7a.5.5 0 0 1-.708 0l-3.5-3.5a.5.5 0 1 1 .708-.708L6.5 10.293l6.646-6.647a.5.5 0 0 1 .708 0z" />
        </symbol>
        <symbol id="circle-half" viewBox="0 0 16 16">
            <path d="M8 15A7 7 0 1 0 8 1v14zm0 1A8 8 0 1 1 8 0a8 8 0 0 1 0 16z" />
        </symbol>
        <symbol id="moon-stars-fill" viewBox="0 0 16 16">
            <path
                d="M6 .278a.768.768 0 0 1 .08.858 7.208 7.208 0 0 0-.878 3.46c0 4.021 3.278 7.277 7.318 7.277.527 0 1.04-.055 1.533-.16a.787.787 0 0 1 .81.316.733.733 0 0 1-.031.893A8.349 8.349 0 0 1 8.344 16C3.734 16 0 12.286 0 7.71 0 4.266 2.114 1.312 5.124.06A.752.752 0 0 1 6 .278z" />
            <path
                d="M10.794 3.148a.217.217 0 0 1 .412 0l.387 1.162c.173.518.579.924 1.097 1.097l1.162.387a.217.217 0 0 1 0 .412l-1.162.387a1.734 1.734 0 0 0-1.097 1.097l-.387 1.162a.217.217 0 0 1-.412 0l-.387-1.162A1.734 1.734 0 0 0 9.31 6.593l-1.162-.387a.217.217 0 0 1 0-.412l1.162-.387a1.734 1.734 0 0 0 1.097-1.097l.387-1.162zM13.863.099a.145.145 0 0 1 .274 0l.258.774c.115.346.386.617.732.732l.774.258a.145.145 0 0 1 0 .274l-.774.258a1.156 1.156 0 0 0-.732.732l-.258.774a.145.145 0 0 1-.274 0l-.258-.774a1.156 1.156 0 0 0-.732-.732l-.774-.258a.145.145 0 0 1 0-.274l.774-.258c.346-.115.617-.386.732-.732L13.863.1z" />
        </symbol>
        <symbol id="sun-fill" viewBox="0 0 16 16">
            <path
                d="M8 12a4 4 0 1 0 0-8 4 4 0 0 0 0 8zM8 0a.5.5 0 0 1 .5.5v2a.5.5 0 0 1-1 0v-2A.5.5 0 0 1 8 0zm0 13a.5.5 0 0 1 .5.5v2a.5.5 0 0 1-1 0v-2A.5.5 0 0 1 8 13zm8-5a.5.5 0 0 1-.5.5h-2a.5.5 0 0 1 0-1h2a.5.5 0 0 1 .5.5zM3 8a.5.5 0 0 1-.5.5h-2a.5.5 0 0 1 0-1h2A.5.5 0 0 1 3 8zm10.657-5.657a.5.5 0 0 1 0 .707l-1.414 1.415a.5.5 0 1 1-.707-.708l1.414-1.414a.5.5 0 0 1 .707 0zm-9.193 9.193a.5.5 0 0 1 0 .707L3.05 13.657a.5.5 0 0 1-.707-.707l1.414-1.414a.5.5 0 0 1 .707 0zm9.193 2.121a.5.5 0 0 1-.707 0l-1.414-1.414a.5.5 0 0 1 .707-.707l1.414 1.414a.5.5 0 0 1 0 .707zM4.464 4.465a.5.5 0 0 1-.707 0L2.343 3.05a.5.5 0 1 1 .707-.707l1.414 1.414a.5.5 0 0 1 0 .708z" />
        </symbol>
    </svg>

    <div class="container">
        <main>
            <div class="py-5 text-center">
                <img class="signup-title" src="@/assets/image/OnionHotSayYo.png" alt="" width="80" height="67">
                <h2>회원 가입</h2>
                <p class="lead">OnionHotSayYo 이용을 위한 회원가입 페이지입니다.</p>
            </div>


            <div class="row g-5 row justify-content-center">
                <div class="col-md-7 col-lg-8" style="">
                    <form class="needs-validation" novalidate>
                        <div class="row g-3">


                            <div class="col-12">
                                <label for="id" class="form-label">아이디</label>
                                <input type="text" class="form-control" id="id" v-model="id"
                                    placeholder=" 5~20자의 영문 소문자, 숫자와 특수기호(_),(-)만 사용 가능합니다.">
                                <div class="invalid-feedback"></div>
                            </div>

                            <div class="col-12">
                                <label for="password" class="form-label">비밀번호</label>
                                <input type="password" class="form-control" id="password" v-model="password"
                                    placeholder="8 ~ 16자 영문, 숫자, 특수문자를 최소 한가지씩 조합이어야 합니다.">
                                <div class="invalid-feedback"></div>
                            </div>

                            <div class="col-12">
                                <label for="email" class="form-label">Email</label>
                                <input type="email" class="form-control" id="email" v-model="email"
                                    placeholder="you@example.com">
                                <div class="invalid-feedback">
                                    Please enter a valid email address for shipping updates.
                                </div>
                            </div>


                            <div class="col-12">
                                <label for="nickname" class="form-label">닉네임</label>
                                <input type="text" class="form-control" id="nickname" v-model="nickname"
                                    placeholder="닉네임을 입력하세요.">
                            </div>

                            <div class="col-md-5">
                                <label for="country" class="form-label">국가</label>
                                <select class="form-select" id="country" v-model="selectedNationality">
                                    <option v-for="nationality in nationalities" :value="nationality"
                                        :key="nationality.id">{{ nationality["country"] }}</option>
                                </select>
                                <div class="invalid-feedback">
                                </div>
                            </div>

                            <!-- <div class="col-md-4">
                                <label for="language" class="form-label">언어</label>
                                <select class="form-select" id="state" required>
                                    <option value="">선택하세요.</option>
                                    <option>Korea</option>
                                    <option>English</option>
                                </select>
                                <div class="invalid-feedback">
                                </div>
                            </div> -->
                        </div>

                        <hr class="my-4">

                        <div class="form-check">
                            <label class="form-check-label" for="save-info">위 이용약관에 모두 동의합니다.</label>
                            <input type="checkbox" class="form-check-input" id="save-info" v-model="termsCheck">
                        </div>

                        <hr class="my-4">

                        <button class="w-100 btn btn-primary btn-lg" type="submit" @click="signUp">회원 가입</button>
                    </form>
                </div>
            </div>
        </main>
    </div>
</template>

<script setup>
// import {useRouter} from 'vue-router';
import axios from 'axios';
import { onMounted, ref } from 'vue';

const selectedNationality = ref('');
const id = ref('');
const password = ref('');
const email = ref('');
const nickname = ref('');
const nationalities = ref('[]');
const termsCheck = ref(false);

/* 국가 목록을 가져온다 */
onMounted(async () => {
    try {
        const response = await axios.get('http://localhost:8080/nationalities/view');
        nationalities.value = response.data;
    } catch (error) {
        console.log(`Error fetching nationalities: ${error}`);
    }
});

/* 회원가입 */
async function signUp() {
    /* 유효성 검사 */
    let checkError = [];

    let flag = false;

    if (!checkId(id)) {
        checkError.push("아이디");
        flag = true;
    }
    if (!checkPassword(password)) {
        checkError.push("비밀번호");
        flag = true;
    }
    if (!checkEmail(email)) {
        checkError.push("이메일");
        flag = true;
    }
    if (!checkNickname(nickname)) {
        checkError.push("닉네임");
        flag = true;
    }
    if (!selectedNationality.value) {
        checkError.push("국가")
        flag = true;
    }
    if (!termsCheck.value) {
        checkError.push("약관동의");
        flag = true;
    }

    if (flag) {
        const result = checkError.join(', ');
        alert(`올바른 회원 정보를 입력해주세요.\n[${result}]\n확인해주세요.`);
        checkError.length = 0;
    }

    const nationalityId = nationalities.value.find(
        item => item.country == selectedNationality.value["country"])?.nationalityId;

    /* 회원가입 요청 */
    const newMember = {
        memberId: id.value,
        nickname: nickname.value,
        password: password.value,
        email: email.value,
        nationalityId: nationalityId
    };

    const url = 'http://localhost:8080/members/signup'; // 회원가입 요청 URL

    const config = {
        headers: {
            'Content-Type': 'application/json'
        }
    };

    try {
        const response = await axios.post(url, newMember, config);
        console.log(response.data);
        /* TODO router 설정 추가 해야함 */
    } catch (error) {
        console.error("Error SignUp Post:", error);
    }
}

// ID
function checkId(id) {
    var regExp = /^[a-z]+[a-z0-9-_]{4,19}$/g;

    return regExp.test(id.value);
}

// Password
function checkPassword(password) {
    var regExp = /^(?=.*[a-zA-Z])(?=.*[!@#$%^*+=-])(?=.*[0-9]).{8,15}$/;

    return regExp.test(password.value);
}

// 이메일
function checkEmail(email) {
    var regExp = /^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/i;

    return regExp.test(email.value);
}

// 닉네임
function checkNickname(nickname) {
    var regExp = /^[0-9a-zA-Zㄱ-힣][0-9a-zA-Zㄱ-힣-_]{1,19}$/g;

    return regExp.test(nickname.value);
}

</script>

<style scoped>
@import url(@/assets/checkout.css);


.bd-placeholder-img {
    font-size: 1.125rem;
    text-anchor: middle;
    -webkit-user-select: none;
    -moz-user-select: none;
    user-select: none;
}

@media (min-width: 768px) {
    .bd-placeholder-img-lg {
        font-size: 3.5rem;
    }
}

.b-example-divider {
    width: 100%;
    height: 3rem;
    background-color: rgba(0, 0, 0, .1);
    border: solid rgba(0, 0, 0, .15);
    border-width: 1px 0;
    box-shadow: inset 0 .5em 1.5em rgba(0, 0, 0, .1), inset 0 .125em .5em rgba(0, 0, 0, .15);
}

.b-example-vr {
    flex-shrink: 0;
    width: 1.5rem;
    height: 100vh;
}

.bi {
    vertical-align: -.125em;
    fill: currentColor;
}

.nav-scroller {
    position: relative;
    z-index: 2;
    height: 2.75rem;
    overflow-y: hidden;
}

.nav-scroller .nav {
    display: flex;
    flex-wrap: nowrap;
    padding-bottom: 1rem;
    margin-top: -1px;
    overflow-x: auto;
    text-align: center;
    white-space: nowrap;
    -webkit-overflow-scrolling: touch;
}
</style>