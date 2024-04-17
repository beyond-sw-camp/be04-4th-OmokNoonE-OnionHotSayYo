<template>
<div class="row justify-content-center">
        <div class="container text-center profile-details">
            <div class="col">
                <MyFollow/>
                <MyBookmark/>
                <MyPost/>
            </div>
            <div class="col">
                <MyFollower/>
                <MyLike/>
                <MyComment/>
            </div>
        </div>
    </div>
</template>

<script setup>
import { inject } from 'vue';
import { useRouter } from 'vue-router';

import MyFollow from './MyFollow.vue';
import MyBookmark from './MyBookmark.vue';
import MyPost from './MyPost.vue';
import MyFollower from './MyFollower.vue';
import MyLike from './MyLike.vue';
import MyComment from './MyComment.vue';


const router = useRouter();
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
    padding: 0px 10px 10px 10px;
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