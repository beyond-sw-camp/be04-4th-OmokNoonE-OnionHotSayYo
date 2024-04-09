<template>
<div class="row justify-content-center">
        <div class="container text-center profile-details">
            <div class="col">
                <MyFollow/>
                <div class="card card-body">
                    <h3 class="category-title">내 북마크</h3>
                    <a href="#" class="card-link">더보기</a>
                    <table class="table table-hover">
                        <tbody class="table-group-divider">
                            <tr>
                                <td class="col-number" scope="row">1</td>
                                <td class="col-title"><a class="col-link" href="https://www.naver.com">단기 알바 구해요</a>
                                </td>
                                <td class="col-date">23-01-22</td>
                                <td>
                                    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor"
                                        class="bi bi-x-circle" viewBox="0 0 16 16">
                                        <path d="M8 15A7 7 0 1 1 8 1a7 7 0 0 1 0 14m0 1A8 8 0 1 0 8 0a8 8 0 0 0 0 16" />
                                        <path
                                            d="M4.646 4.646a.5.5 0 0 1 .708 0L8 7.293l2.646-2.647a.5.5 0 0 1 .708.708L8.707 8l2.647 2.646a.5.5 0 0 1-.708.708L8 8.707l-2.646 2.647a.5.5 0 0 1-.708-.708L7.293 8 4.646 5.354a.5.5 0 0 1 0-.708" />
                                    </svg>
                                    <!-- 북마크 -->
                                    <!-- <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor"
                                        class="bi bi-bookmark-dash" viewBox="0 0 16 16">
                                        <path fill-rule="evenodd"
                                            d="M5.5 6.5A.5.5 0 0 1 6 6h4a.5.5 0 0 1 0 1H6a.5.5 0 0 1-.5-.5" />
                                        <path
                                            d="M2 2a2 2 0 0 1 2-2h8a2 2 0 0 1 2 2v13.5a.5.5 0 0 1-.777.416L8 13.101l-5.223 2.815A.5.5 0 0 1 2 15.5zm2-1a1 1 0 0 0-1 1v12.566l4.723-2.482a.5.5 0 0 1 .554 0L13 14.566V2a1 1 0 0 0-1-1z" />
                                    </svg> -->
                                </td>
                            </tr>
                            <tr>
                                <td class="col-number" scope="row">1</td>
                                <td class="col-title"><a class="col-link" href="https://www.naver.com">단기 알바 구해요</a>
                                </td>
                                <td class="col-date">23-01-22</td>
                                <td>
                                    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor"
                                        class="bi bi-x-circle" viewBox="0 0 16 16">
                                        <path d="M8 15A7 7 0 1 1 8 1a7 7 0 0 1 0 14m0 1A8 8 0 1 0 8 0a8 8 0 0 0 0 16" />
                                        <path
                                            d="M4.646 4.646a.5.5 0 0 1 .708 0L8 7.293l2.646-2.647a.5.5 0 0 1 .708.708L8.707 8l2.647 2.646a.5.5 0 0 1-.708.708L8 8.707l-2.646 2.647a.5.5 0 0 1-.708-.708L7.293 8 4.646 5.354a.5.5 0 0 1 0-.708" />
                                    </svg>
                                </td>
                            </tr>
                            <tr>
                                <td class="col-number" scope="row">1</td>
                                <td class="col-title"><a class="col-link" href="https://www.naver.com">단기 알바 구해요</a>
                                </td>
                                <td class="col-date">23-01-22</td>
                                <td>
                                    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor"
                                        class="bi bi-x-circle" viewBox="0 0 16 16">
                                        <path d="M8 15A7 7 0 1 1 8 1a7 7 0 0 1 0 14m0 1A8 8 0 1 0 8 0a8 8 0 0 0 0 16" />
                                        <path
                                            d="M4.646 4.646a.5.5 0 0 1 .708 0L8 7.293l2.646-2.647a.5.5 0 0 1 .708.708L8.707 8l2.647 2.646a.5.5 0 0 1-.708.708L8 8.707l-2.646 2.647a.5.5 0 0 1-.708-.708L7.293 8 4.646 5.354a.5.5 0 0 1 0-.708" />
                                    </svg>
                                </td>
                            </tr>
                            <tr>
                                <td class="col-number" scope="row">1</td>
                                <td class="col-title"><a class="col-link" href="https://www.naver.com">단기 알바 구해요</a>
                                </td>
                                <td class="col-date">23-01-22</td>
                                <td>
                                    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor"
                                        class="bi bi-x-circle" viewBox="0 0 16 16">
                                        <path d="M8 15A7 7 0 1 1 8 1a7 7 0 0 1 0 14m0 1A8 8 0 1 0 8 0a8 8 0 0 0 0 16" />
                                        <path
                                            d="M4.646 4.646a.5.5 0 0 1 .708 0L8 7.293l2.646-2.647a.5.5 0 0 1 .708.708L8.707 8l2.647 2.646a.5.5 0 0 1-.708.708L8 8.707l-2.646 2.647a.5.5 0 0 1-.708-.708L7.293 8 4.646 5.354a.5.5 0 0 1 0-.708" />
                                    </svg>
                                </td>
                            </tr>
                            <tr>
                                <td class="col-number" scope="row">1</td>
                                <td class="col-title"><a class="col-link" href="https://www.naver.com">단기 알바 구해요</a>
                                </td>
                                <td class="col-date">23-01-22</td>
                                <td>
                                    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor"
                                        class="bi bi-x-circle" viewBox="0 0 16 16">
                                        <path d="M8 15A7 7 0 1 1 8 1a7 7 0 0 1 0 14m0 1A8 8 0 1 0 8 0a8 8 0 0 0 0 16" />
                                        <path
                                            d="M4.646 4.646a.5.5 0 0 1 .708 0L8 7.293l2.646-2.647a.5.5 0 0 1 .708.708L8.707 8l2.647 2.646a.5.5 0 0 1-.708.708L8 8.707l-2.646 2.647a.5.5 0 0 1-.708-.708L7.293 8 4.646 5.354a.5.5 0 0 1 0-.708" />
                                    </svg>
                                </td>
                            </tr>
                        </tbody>
                    </table>
                </div>
                <div class="card card-body">
                    <h3 class="category-title">내 작성글</h3>
                    <a href="#" class="card-link">더보기</a>
                    <table class="table table-hover">
                        <tbody class="table-group-divider">
                            <tr>
                                <td class="col-number" scope="row">1</td>
                                <td class="col-title"><a class="col-link" href="https://www.naver.com">단기 알바 구해요</a>
                                </td>
                                <td class="col-date">23-01-22</td>
                                <td>
                                    <div class="col-hits">3</div>
                                </td>
                            </tr>
                            <tr>
                                <td class="col-number" scope="row">1</td>
                                <td class="col-title"><a class="col-link" href="https://www.naver.com">단기 알바 구해요</a>
                                </td>
                                <td class="col-date">23-01-22</td>
                                <td>
                                    <div class="col-hits">3</div>
                                </td>
                            </tr>
                            <tr>
                                <td class="col-number" scope="row">1</td>
                                <td class="col-title"><a class="col-link" href="https://www.naver.com">단기 알바 구해요</a>
                                </td>
                                <td class="col-date">23-01-22</td>
                                <td>
                                    <div class="col-hits">3</div>
                                </td>
                            </tr>
                            <tr>
                                <td class="col-number" scope="row">1</td>
                                <td class="col-title"><a class="col-link" href="https://www.naver.com">단기 알바 구해요</a>
                                </td>
                                <td class="col-date">23-01-22</td>
                                <td>
                                    <div class="col-hits">3</div>
                                </td>
                            </tr>
                            <tr>
                                <td class="col-number" scope="row">1</td>
                                <td class="col-title"><a class="col-link" href="https://www.naver.com">단기 알바 구해요</a>
                                </td>
                                <td class="col-date">23-01-22</td>
                                <td>
                                    <div class="col-hits">3</div>
                                </td>
                            </tr>
                        </tbody>
                    </table>
                </div>
            </div>
            <div class="col">
                <div class="card card-body">
                    <h3 class="category-title">내 팔로워</h3>
                    <a href="#" class="card-link">더보기</a>
                    <table class="table table-hover">
                        <tbody class="table-group-divider">
                            <tr>
                                <td class="col-number" scope="row">1</td>
                                <td class="col">
                                    <img src="@/assets/image/OmokProfile.png" width="25" height="25"
                                        class="rounded-circle">
                                </td>
                                <td class="col-title"><a class="col-link"
                                        href="https://www.naver.com">profile-user-name</a>
                                </td>
                                <td>
                                    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor"
                                        class="bi bi-x-circle" viewBox="0 0 16 16">
                                        <path d="M8 15A7 7 0 1 1 8 1a7 7 0 0 1 0 14m0 1A8 8 0 1 0 8 0a8 8 0 0 0 0 16" />
                                        <path
                                            d="M4.646 4.646a.5.5 0 0 1 .708 0L8 7.293l2.646-2.647a.5.5 0 0 1 .708.708L8.707 8l2.647 2.646a.5.5 0 0 1-.708.708L8 8.707l-2.646 2.647a.5.5 0 0 1-.708-.708L7.293 8 4.646 5.354a.5.5 0 0 1 0-.708" />
                                    </svg>
                                </td>
                            </tr>
                            <tr>
                                <td class="col-number" scope="row">1</td>
                                <td class="col">
                                    <img src="@/assets/image/OmokProfile.png" width="25" height="25"
                                        class="rounded-circle">
                                </td>
                                <td class="col-title"><a class="col-link"
                                        href="https://www.naver.com">profile-user-name</a>
                                </td>
                                <td>
                                    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor"
                                        class="bi bi-x-circle" viewBox="0 0 16 16">
                                        <path d="M8 15A7 7 0 1 1 8 1a7 7 0 0 1 0 14m0 1A8 8 0 1 0 8 0a8 8 0 0 0 0 16" />
                                        <path
                                            d="M4.646 4.646a.5.5 0 0 1 .708 0L8 7.293l2.646-2.647a.5.5 0 0 1 .708.708L8.707 8l2.647 2.646a.5.5 0 0 1-.708.708L8 8.707l-2.646 2.647a.5.5 0 0 1-.708-.708L7.293 8 4.646 5.354a.5.5 0 0 1 0-.708" />
                                    </svg>
                                </td>
                            </tr>
                            <tr>
                                <td class="col-number" scope="row">1</td>
                                <td class="col">
                                    <img src="@/assets/image/OmokProfile.png" width="25" height="25"
                                        class="rounded-circle">
                                </td>
                                <td class="col-title"><a class="col-link"
                                        href="https://www.naver.com">profile-user-name</a>
                                </td>
                                <td>
                                    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor"
                                        class="bi bi-x-circle" viewBox="0 0 16 16">
                                        <path d="M8 15A7 7 0 1 1 8 1a7 7 0 0 1 0 14m0 1A8 8 0 1 0 8 0a8 8 0 0 0 0 16" />
                                        <path
                                            d="M4.646 4.646a.5.5 0 0 1 .708 0L8 7.293l2.646-2.647a.5.5 0 0 1 .708.708L8.707 8l2.647 2.646a.5.5 0 0 1-.708.708L8 8.707l-2.646 2.647a.5.5 0 0 1-.708-.708L7.293 8 4.646 5.354a.5.5 0 0 1 0-.708" />
                                    </svg>
                                </td>
                            </tr>
                            <tr>
                                <td class="col-number" scope="row">1</td>
                                <td class="col">
                                    <img src="@/assets/image/OmokProfile.png" width="25" height="25"
                                        class="rounded-circle">
                                </td>
                                <td class="col-title"><a class="col-link"
                                        href="https://www.naver.com">profile-user-name</a>
                                </td>
                                <td>
                                    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor"
                                        class="bi bi-x-circle" viewBox="0 0 16 16">
                                        <path d="M8 15A7 7 0 1 1 8 1a7 7 0 0 1 0 14m0 1A8 8 0 1 0 8 0a8 8 0 0 0 0 16" />
                                        <path
                                            d="M4.646 4.646a.5.5 0 0 1 .708 0L8 7.293l2.646-2.647a.5.5 0 0 1 .708.708L8.707 8l2.647 2.646a.5.5 0 0 1-.708.708L8 8.707l-2.646 2.647a.5.5 0 0 1-.708-.708L7.293 8 4.646 5.354a.5.5 0 0 1 0-.708" />
                                    </svg>
                                </td>
                            </tr>
                            <tr>
                                <td class="col-number" scope="row">1</td>
                                <td class="col">
                                    <img src="@/assets/image/OmokProfile.png" width="25" height="25"
                                        class="rounded-circle">
                                </td>
                                <td class="col-title"><a class="col-link"
                                        href="https://www.naver.com">profile-user-name</a>
                                </td>
                                <td>
                                    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor"
                                        class="bi bi-x-circle" viewBox="0 0 16 16">
                                        <path d="M8 15A7 7 0 1 1 8 1a7 7 0 0 1 0 14m0 1A8 8 0 1 0 8 0a8 8 0 0 0 0 16" />
                                        <path
                                            d="M4.646 4.646a.5.5 0 0 1 .708 0L8 7.293l2.646-2.647a.5.5 0 0 1 .708.708L8.707 8l2.647 2.646a.5.5 0 0 1-.708.708L8 8.707l-2.646 2.647a.5.5 0 0 1-.708-.708L7.293 8 4.646 5.354a.5.5 0 0 1 0-.708" />
                                    </svg>
                                </td>
                            </tr>
                        </tbody>
                    </table>
                </div>
                <div class="card card-body">
                    <h3 class="category-title">내 좋아요</h3>
                    <a href="#" class="card-link">더보기</a>
                    <table class="table table-hover">
                        <tbody class="table-group-divider">
                            <tr>
                                <td class="col-number" scope="row">1</td>
                                <td class="col-title"><a class="col-link" href="https://www.naver.com">단기 알바 구해요</a>
                                </td>
                                <td class="col-date">23-01-22</td>
                                <td>
                                    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor"
                                        class="bi bi-x-circle" viewBox="0 0 16 16">
                                        <path d="M8 15A7 7 0 1 1 8 1a7 7 0 0 1 0 14m0 1A8 8 0 1 0 8 0a8 8 0 0 0 0 16" />
                                        <path
                                            d="M4.646 4.646a.5.5 0 0 1 .708 0L8 7.293l2.646-2.647a.5.5 0 0 1 .708.708L8.707 8l2.647 2.646a.5.5 0 0 1-.708.708L8 8.707l-2.646 2.647a.5.5 0 0 1-.708-.708L7.293 8 4.646 5.354a.5.5 0 0 1 0-.708" />
                                    </svg>
                                    <!-- 북마크 -->
                                    <!-- <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor"
                                        class="bi bi-bookmark-dash" viewBox="0 0 16 16">
                                        <path fill-rule="evenodd"
                                            d="M5.5 6.5A.5.5 0 0 1 6 6h4a.5.5 0 0 1 0 1H6a.5.5 0 0 1-.5-.5" />
                                        <path
                                            d="M2 2a2 2 0 0 1 2-2h8a2 2 0 0 1 2 2v13.5a.5.5 0 0 1-.777.416L8 13.101l-5.223 2.815A.5.5 0 0 1 2 15.5zm2-1a1 1 0 0 0-1 1v12.566l4.723-2.482a.5.5 0 0 1 .554 0L13 14.566V2a1 1 0 0 0-1-1z" />
                                    </svg> -->
                                </td>
                            </tr>
                            <tr>
                                <td class="col-number" scope="row">1</td>
                                <td class="col-title"><a class="col-link" href="https://www.naver.com">단기 알바 구해요</a>
                                </td>
                                <td class="col-date">23-01-22</td>
                                <td>
                                    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor"
                                        class="bi bi-x-circle" viewBox="0 0 16 16">
                                        <path d="M8 15A7 7 0 1 1 8 1a7 7 0 0 1 0 14m0 1A8 8 0 1 0 8 0a8 8 0 0 0 0 16" />
                                        <path
                                            d="M4.646 4.646a.5.5 0 0 1 .708 0L8 7.293l2.646-2.647a.5.5 0 0 1 .708.708L8.707 8l2.647 2.646a.5.5 0 0 1-.708.708L8 8.707l-2.646 2.647a.5.5 0 0 1-.708-.708L7.293 8 4.646 5.354a.5.5 0 0 1 0-.708" />
                                    </svg>
                                </td>
                            </tr>
                            <tr>
                                <td class="col-number" scope="row">1</td>
                                <td class="col-title"><a class="col-link" href="https://www.naver.com">단기 알바 구해요</a>
                                </td>
                                <td class="col-date">23-01-22</td>
                                <td>
                                    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor"
                                        class="bi bi-x-circle" viewBox="0 0 16 16">
                                        <path d="M8 15A7 7 0 1 1 8 1a7 7 0 0 1 0 14m0 1A8 8 0 1 0 8 0a8 8 0 0 0 0 16" />
                                        <path
                                            d="M4.646 4.646a.5.5 0 0 1 .708 0L8 7.293l2.646-2.647a.5.5 0 0 1 .708.708L8.707 8l2.647 2.646a.5.5 0 0 1-.708.708L8 8.707l-2.646 2.647a.5.5 0 0 1-.708-.708L7.293 8 4.646 5.354a.5.5 0 0 1 0-.708" />
                                    </svg>
                                </td>
                            </tr>
                            <tr>
                                <td class="col-number" scope="row">1</td>
                                <td class="col-title"><a class="col-link" href="https://www.naver.com">단기 알바 구해요</a>
                                </td>
                                <td class="col-date">23-01-22</td>
                                <td>
                                    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor"
                                        class="bi bi-x-circle" viewBox="0 0 16 16">
                                        <path d="M8 15A7 7 0 1 1 8 1a7 7 0 0 1 0 14m0 1A8 8 0 1 0 8 0a8 8 0 0 0 0 16" />
                                        <path
                                            d="M4.646 4.646a.5.5 0 0 1 .708 0L8 7.293l2.646-2.647a.5.5 0 0 1 .708.708L8.707 8l2.647 2.646a.5.5 0 0 1-.708.708L8 8.707l-2.646 2.647a.5.5 0 0 1-.708-.708L7.293 8 4.646 5.354a.5.5 0 0 1 0-.708" />
                                    </svg>
                                </td>
                            </tr>
                            <tr>
                                <td class="col-number" scope="row">1</td>
                                <td class="col-title"><a class="col-link" href="https://www.naver.com">단기 알바 구해요</a>
                                </td>
                                <td class="col-date">23-01-22</td>
                                <td>
                                    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor"
                                        class="bi bi-x-circle" viewBox="0 0 16 16">
                                        <path d="M8 15A7 7 0 1 1 8 1a7 7 0 0 1 0 14m0 1A8 8 0 1 0 8 0a8 8 0 0 0 0 16" />
                                        <path
                                            d="M4.646 4.646a.5.5 0 0 1 .708 0L8 7.293l2.646-2.647a.5.5 0 0 1 .708.708L8.707 8l2.647 2.646a.5.5 0 0 1-.708.708L8 8.707l-2.646 2.647a.5.5 0 0 1-.708-.708L7.293 8 4.646 5.354a.5.5 0 0 1 0-.708" />
                                    </svg>
                                </td>
                            </tr>
                        </tbody>
                    </table>
                </div>
                <div class="card card-body">
                    <h3 class="category-title">내 댓글</h3>
                    <a href="#" class="card-link">더보기</a>
                    <table class="table table-hover">
                        <tbody class="table-group-divider">
                            <tr>
                                <td class="col-number" scope="row">1</td>
                                <td class="col-title"><a class="col-link" href="https://www.naver.com">단기 알바 구해요</a>
                                </td>
                                <td class="col-date">23-01-22</td>
                                <td>
                                    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor"
                                        class="bi bi-x-circle" viewBox="0 0 16 16">
                                        <path d="M8 15A7 7 0 1 1 8 1a7 7 0 0 1 0 14m0 1A8 8 0 1 0 8 0a8 8 0 0 0 0 16" />
                                        <path
                                            d="M4.646 4.646a.5.5 0 0 1 .708 0L8 7.293l2.646-2.647a.5.5 0 0 1 .708.708L8.707 8l2.647 2.646a.5.5 0 0 1-.708.708L8 8.707l-2.646 2.647a.5.5 0 0 1-.708-.708L7.293 8 4.646 5.354a.5.5 0 0 1 0-.708" />
                                    </svg>
                                    <!-- 북마크 -->
                                    <!-- <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor"
                                        class="bi bi-bookmark-dash" viewBox="0 0 16 16">
                                        <path fill-rule="evenodd"
                                            d="M5.5 6.5A.5.5 0 0 1 6 6h4a.5.5 0 0 1 0 1H6a.5.5 0 0 1-.5-.5" />
                                        <path
                                            d="M2 2a2 2 0 0 1 2-2h8a2 2 0 0 1 2 2v13.5a.5.5 0 0 1-.777.416L8 13.101l-5.223 2.815A.5.5 0 0 1 2 15.5zm2-1a1 1 0 0 0-1 1v12.566l4.723-2.482a.5.5 0 0 1 .554 0L13 14.566V2a1 1 0 0 0-1-1z" />
                                    </svg> -->
                                </td>
                            </tr>
                            <tr>
                                <td class="col-number" scope="row">1</td>
                                <td class="col-title"><a class="col-link" href="https://www.naver.com">단기 알바 구해요</a>
                                </td>
                                <td class="col-date">23-01-22</td>
                                <td>
                                    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor"
                                        class="bi bi-x-circle" viewBox="0 0 16 16">
                                        <path d="M8 15A7 7 0 1 1 8 1a7 7 0 0 1 0 14m0 1A8 8 0 1 0 8 0a8 8 0 0 0 0 16" />
                                        <path
                                            d="M4.646 4.646a.5.5 0 0 1 .708 0L8 7.293l2.646-2.647a.5.5 0 0 1 .708.708L8.707 8l2.647 2.646a.5.5 0 0 1-.708.708L8 8.707l-2.646 2.647a.5.5 0 0 1-.708-.708L7.293 8 4.646 5.354a.5.5 0 0 1 0-.708" />
                                    </svg>
                                </td>
                            </tr>
                            <tr>
                                <td class="col-number" scope="row">1</td>
                                <td class="col-title"><a class="col-link" href="https://www.naver.com">단기 알바 구해요</a>
                                </td>
                                <td class="col-date">23-01-22</td>
                                <td>
                                    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor"
                                        class="bi bi-x-circle" viewBox="0 0 16 16">
                                        <path d="M8 15A7 7 0 1 1 8 1a7 7 0 0 1 0 14m0 1A8 8 0 1 0 8 0a8 8 0 0 0 0 16" />
                                        <path
                                            d="M4.646 4.646a.5.5 0 0 1 .708 0L8 7.293l2.646-2.647a.5.5 0 0 1 .708.708L8.707 8l2.647 2.646a.5.5 0 0 1-.708.708L8 8.707l-2.646 2.647a.5.5 0 0 1-.708-.708L7.293 8 4.646 5.354a.5.5 0 0 1 0-.708" />
                                    </svg>
                                </td>
                            </tr>
                            <tr>
                                <td class="col-number" scope="row">1</td>
                                <td class="col-title"><a class="col-link" href="https://www.naver.com">단기 알바 구해요</a>
                                </td>
                                <td class="col-date">23-01-22</td>
                                <td>
                                    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor"
                                        class="bi bi-x-circle" viewBox="0 0 16 16">
                                        <path d="M8 15A7 7 0 1 1 8 1a7 7 0 0 1 0 14m0 1A8 8 0 1 0 8 0a8 8 0 0 0 0 16" />
                                        <path
                                            d="M4.646 4.646a.5.5 0 0 1 .708 0L8 7.293l2.646-2.647a.5.5 0 0 1 .708.708L8.707 8l2.647 2.646a.5.5 0 0 1-.708.708L8 8.707l-2.646 2.647a.5.5 0 0 1-.708-.708L7.293 8 4.646 5.354a.5.5 0 0 1 0-.708" />
                                    </svg>
                                </td>
                            </tr>
                            <tr>
                                <td class="col-number" scope="row">1</td>
                                <td class="col-title"><a class="col-link" href="https://www.naver.com">단기 알바 구해요</a>
                                </td>
                                <td class="col-date">23-01-22</td>
                                <td>
                                    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor"
                                        class="bi bi-x-circle" viewBox="0 0 16 16">
                                        <path d="M8 15A7 7 0 1 1 8 1a7 7 0 0 1 0 14m0 1A8 8 0 1 0 8 0a8 8 0 0 0 0 16" />
                                        <path
                                            d="M4.646 4.646a.5.5 0 0 1 .708 0L8 7.293l2.646-2.647a.5.5 0 0 1 .708.708L8.707 8l2.647 2.646a.5.5 0 0 1-.708.708L8 8.707l-2.646 2.647a.5.5 0 0 1-.708-.708L7.293 8 4.646 5.354a.5.5 0 0 1 0-.708" />
                                    </svg>
                                </td>
                            </tr>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</template>

<script setup>
import { ref, watchEffect } from 'vue';
import { useRoute, useRouter } from 'vue-router';

import MyFollow from './MyFollow.vue';

const memberIdProps = defineProps({
    memberId: String
});

watchEffect(memberIdProps);

const router = useRouter();

function goReports(memberId) {
    router.push(`/notfound`);
    // router.push(`/reports/${memberId}`)
}
</script>

<style scoped>
* {
    font-family: 'NanumBarunGothic' !important;

}

.card-body {
    margin-bottom: 10px;
}

.card-link {
    align-items: right;
    box-sizing: border-box;
    margin: 0;
    text-decoration: none;
    transition: all .4s;
    font-weight: 800;
    position: absolute;
    display: block;
    right: 15px;
    top: 20px;
    padding: 2px 8px;
    border: 1px solid #e0e0e0;
    line-height: 22px;
    font-size: 13px;
    color: #777;
    border-radius: 15px;
}

.profile-details {
    display: flex;
    align-items: center;
    justify-content: center;
    margin: 10px;
    gap: 10px;
    padding: 0px 0px;
}


.col-number {
    text-align: center;
}

.col-title {
    text-align: center;
}

.col-link {
    text-decoration: none;
    color: black;
}

[data-bs-theme=dark] .col-link {
    color: white;
}

.col-date {
    text-align: center;
}

.col-hits {
    background-color: red;
    color: white;
    border: 1px #777;
    border-radius: 45%;
}
</style>