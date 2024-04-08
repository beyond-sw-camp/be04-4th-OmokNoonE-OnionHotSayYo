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
                <button class="MyPage">MyPage</button>    
                <button class="LogOut">Log Out</button>   
                <hr>
                <span class="Notification">Notification</span>
                <hr>
                <div class="card text-center">
                    <div class="card-header d-flex justify-content-between align-items-center">
                      <span class="text-center">맛집글</span>
                      <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <div class="card-body">
                      <h5 class="card-title">신대방삼거리역 맛집 공유합니다!</h5>
                      <p class="card-text">이순신님이 회원님의 게시물에 좋아요를 눌렀습니다.</p>
                      <a href="#" class="btn">자세히 보기</a>
                    </div>
                    <div class="card-footer text-body-secondary">
                      2 hours ago
                    </div>
                  </div>
                  <div class="card text-center">
                    <div class="card-header d-flex justify-content-between align-items-center">
                      <span class="text-center">구인구직글</span>
                      <button type="button" class="btn-close"></button>
                    </div>
                    <div class="card-body">
                      <h5 class="card-title">신대방삼거리역 식당 알바 급구합니다!</h5>
                      <p class="card-text">유관순님이 회원님의 게시글에 댓글을 남겼습니다.</p>
                      <a href="#" class="btn">자세히 보기</a>
                    </div>
                    <div class="card-footer text-body-secondary">
                      3 hours ago
                    </div>
                  </div>
            </div>
    </div>
</template>

<script setup>

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