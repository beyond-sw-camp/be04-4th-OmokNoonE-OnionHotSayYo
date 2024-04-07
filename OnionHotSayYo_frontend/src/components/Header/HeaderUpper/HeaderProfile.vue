<template>
    <div>
      <button class="btn btn-primary" type="button" data-bs-toggle="offcanvas" data-bs-target="#offcanvasRight"
        aria-controls="offcanvasRight">
        <img src="@/assets/image/OmokProfile.png" alt="">
      </button>
  
      <div class="offcanvas offcanvas-end" tabindex="-1" id="offcanvasRight" aria-labelledby="offcanvasRightLabel">
        <div class="offcanvas-header">
          <h5 id="offcanvasRightLabel">홍길동님 환영합니다</h5>
          <button type="button" class="btn-close text-reset" data-bs-dismiss="offcanvas" aria-label="Close"></button>
        </div>
        <div class="offcanvas-body">
          <ul class="list-unstyled">
            <li><a class="dropdown-item" href="#">My Page</a></li>
            <li><a class="dropdown-item" href="#">Settings</a></li>
            <li><a class="dropdown-item" href="#">Profile</a></li>
            <li><hr class="dropdown-divider"></li>
            <li><a class="dropdown-item" href="#">Sign out</a></li>
          </ul>
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

  .btn {
    background-color: white;
    border: none;
    color: #fff;
    padding: 10px 20px;
    font-size: 0;
  }

  .btn img {
    width: 32px; /* 이미지 크기 조절 */
    height: 32px;
  }
  
  /* 버튼에 마우스 호버 시 효과 제거 */
  .btn:hover {
    background-color: white;
    color: #fff;
  }
  </style>