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
                                <input type="email" class="form-control" id="floatingInput"
                                    placeholder="name@example.com">
                                <label for="floatingInput">Email address</label>
                            </div>
                            <div class="form-floating">
                                <input type="password" class="form-control" id="floatingPassword"
                                    placeholder="Password">
                                <label for="floatingPassword">Password</label>
                            </div>

                            <div class="form-check text-start my-3">
                                <input class="form-check-input" type="checkbox" value="remember-me"
                                    id="flexCheckDefault">
                                <label class="form-check-label" for="flexCheckDefault">
                                    Remember me
                                </label>
                            </div>
                            <button class="btn btn-primary w-100 py-2" type="submit">Sign In</button>
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