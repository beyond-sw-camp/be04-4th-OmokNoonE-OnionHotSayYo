<template>
    <DummyHeader/>
    <DummyBody/>
</template>

<script setup>
import DummyHeader from './DummyProfileContents/DummyProfileHeader.vue';
import DummyBody from './DummyProfileContents/DummyProfileContentsUnion.vue';
</script>

<style scoped>
* {
    font-family: 'NanumBarunGothic' !important;
}

.profile-header {
    display: flex;
    align-items: center;
    justify-content: left;
    position: relative;
    border: 1px solid lightgray;
    margin-top: 20px;
    padding: 30px 10px 10px 10px;
}

.profile-img-container {
    width: fit-content;
    margin: 0px 10px;
}

.profile-img {
    border: 1px solid lightgray;
}

.profile-intro {
    width: 60%;
}

.btn-profile-edit {
    width: fit-content;
    box-sizing: border-box;
    margin: 0;
    text-decoration: none;
    transition: all .4s;
    font-weight: 800;
    position: absolute;
    top: 30px;
    right: 35px;
    padding: 2px 8px;
    border: 1px solid #e0e0e0;
    line-height: 22px;
    font-size: 13px;
    color: #777;
    border-radius: 15px;
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
    top: 23px;
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

.col-close {}

.col-hits {
    background-color: red;
    color: white;
    border: 1px #777;
    border-radius: 45%;
}

#pagenation-container {
    display: flex;
    justify-content: center;
}
</style>