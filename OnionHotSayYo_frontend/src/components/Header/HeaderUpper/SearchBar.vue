<template>
    <div class="view-wrapper">
        <div class="view">
            <div class="overlap-2">
                <div class="overlap-group-wrapper">
                    <div class="overlap-group-2">
                        <!-- <img class="image-2" src="@/assets/img/search.svg" /> -->
                        
                        <select class="rectangle-category" v-model="selectedCategory" @click="categoryDataSearch" >
                            <option v-for="category in categories" :value="category" :key="category.id">{{ category }}</option>
                        </select>
                    </div>
                </div>
                <div class="rectangle-2">
                    <div id="search" class="group-3">
                        <div class="text-wrapper-5">
                            <input @input="autoComplete" @blur="resetSearchResults" type="text" placeholder="내용을 입력하세요" v-model.trim="context">
                            <div class="rectangle-search-result" v-for="searchResult in searchResults" :value="searchResult" :key="searchResult.id">
                                <div class="text-wrapper-auto" >
                                    <!-- {{ searchResult }} -->
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</template>

<script setup>
// import {ref} from 'vue';
// import axios from 'axios';

// const categories = ref(['카테고리', '모집글', '프로젝트', '공지사항', '게시글']);
// const selectedCategory = ref('카테고리');
// const context = ref('');
// const contentResult = ref('');
// const searchResults = ref([]);

// async function categoryDataSearch() {
//     switch (selectedCategory.value) {
//         case '모집글':
//             /* JSON SERVER에서는 LIKE 조회가 되지 않아 추후에 서버 연결 후 적용 */
//             let responsePostDetail = await axios.get(`http://localhost:8080/seekingPostDetail`);
//             contentResult.value = responsePostDetail.data;
//             break;
//         case '프로젝트':

//             break;
//         case '공지사항':
//             let responseNotice = await axios.get(`http://localhost:8083/notice`);
//             contentResult.value = responseNotice.data;
//             break;
//         case '게시글':
//             const responsePost = await axios.get(`http://localhost:8082/post`);
//             contentResult.value = responsePost.data;
//             break;
//         default:
//             break;
//     }
// }

// function autoComplete() {
//     searchResults.value = [];
//     for (let i = 0; i < contentResult.value.length; i++) {
//         if(contentResult.value[i].TITLE.includes(context.value)){
//             if(searchResults.value.length > 4) break;
//             searchResults.value.push(contentResult.value[i].TITLE);
//         }
//     }
//     console.log(searchResults.value);
// }

// function resetSearchResults() {
//     searchResults.value = [];
// }

</script>

<style scoped>
@media screen and (max-width: 660px) {
.view-wrapper{
    margin-right: 10%;
    margin-left: 5%;
}
}
.view-wrapper {
    position: inline-flex;
    align-items: flex-start;
    width: 298px;
    height: 37px;
    top: 10px;
    left: 810px;
}

.view {
    height: 37px;
}

.overlap-2 {
    position: relative;
    width: 320px;
    height: 37px;
}

.overlap-group-wrapper {
    position: absolute;
    width: 320px;
    height: 37px;
    top: 0;
    left: 0;
}

.overlap-group-2 {
    position: relative;
    height: 37px;
}

.rectangle-2 {
    width: 200px;
    height: 40px;
    left: 70px;
    background-color: white;
    border-radius: 0px 8px 8px 0px;
    position: absolute;
    top: 0;
    border: 1px solid;

}

.rectangle-category {
    width: 70px;
    height: 40px;
    left: 0;
    background-color: rgb(180, 180, 180);
    border-radius: 8px 0px 0px 8px;
    position: absolute;
    top: 0;
    cursor: pointer;
    text-align: center;
}

.rectangle-search-result {
    width: 221px;
    top: 9px;
    left: -15px;
    background-color: #F3F7FB;
    /* border-radius: 0px 0px 8px 8px; */
    position: relative;
    padding-top: 1px;
    padding-bottom: 1px;
}

.image-2 {
    justify-content: flex-end;
    /* 요소들을 컨테이너의 오른쪽에 정렬 */
    position: relative;
    left: 90%;
    width: 20px;
    height: 20px;
    top: 8px;
    color: black;
}

.group-3 {
    position: absolute;
    width: 173px;
    height: 18px;
    top: 10px;
    left: 15px;
}

.text-wrapper-5 {
    position: absolute;
    width: 150px;
    top: 0;
    font-family: "Outfit", Helvetica;
    font-weight: 400;
    color: #1e1e1e;
    font-size: 14px;
    letter-spacing: 0;
    line-height: normal;
}

.text-wrapper-6 {
    position: absolute;
    top: 0;
    left: 0;
    font-family: "Outfit", Helvetica;
    font-weight: 400;
    color: #000000;
    font-size: 14px;
    letter-spacing: 0;
    line-height: normal;
    cursor: pointer;
}

.polygon-2 {
    position: absolute;
    width: 7px;
    height: 4px;
    top: 9px;
    left: 68px;
    cursor: pointer;
}

.text-wrapper-auto {
    margin: 0px 10px 5px 10px;
    color: dimgrey;
}

ul {
    position: relative;
    right: 23px;
    font-family: "Outfit", Helvetica;
    font-weight: 400;
    color: #000000;
    font-size: 14px;
    letter-spacing: 0;
    line-height: normal;
    text-align: left;
}

input {
    border-width: 0;
    background-color: white;
}
</style>