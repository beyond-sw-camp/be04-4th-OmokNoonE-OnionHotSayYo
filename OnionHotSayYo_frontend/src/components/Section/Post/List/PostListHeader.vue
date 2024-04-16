<template>
    <form class="d-flex" role="search">
        <input type="checkbox" class="btn-check" id="btncheck-list" autocomplete="off">
        <label class="btn btn-outline-primary" for="btncheck-list" @click="toggleTranslation">
            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-translate"
                viewBox="0 0 16 16">
                <path
                    d="M4.545 6.714 4.11 8H3l1.862-5h1.284L8 8H6.833l-.435-1.286zm1.634-.736L5.5 3.956h-.049l-.679 2.022z" />
                <path
                    d="M0 2a2 2 0 0 1 2-2h7a2 2 0 0 1 2 2v3h3a2 2 0 0 1 2 2v7a2 2 0 0 1-2 2H7a2 2 0 0 1-2-2v-3H2a2 2 0 0 1-2-2zm2-1a1 1 0 0 0-1 1v7a1 1 0 0 0 1 1h7a1 1 0 0 0 1-1V2a1 1 0 0 0-1-1zm7.138 9.995q.289.451.63.846c-.748.575-1.673 1.001-2.768 1.292.178.217.451.635.555.867 1.125-.359 2.08-.844 2.886-1.494.777.665 1.739 1.165 2.93 1.472.133-.254.414-.673.629-.89-1.125-.253-2.057-.694-2.82-1.284.681-.747 1.222-1.651 1.621-2.757H14V8h-3v1.047h.765c-.318.844-.74 1.546-1.272 2.13a6 6 0 0 1-.415-.492 2 2 0 0 1-.94.31" />
            </svg>
        </label><select class="form-select" id="location" required="" v-model="selectedLocation">
            <option value="0">전체(지역)</option>
            <option value="2">서울</option>
            <option value="31">경기</option>
            <option value="32">인천</option>
            <option value="33">강원</option>
            <option value="41">충남</option>
            <option value="42">대전</option>
            <option value="43">충북</option>
            <option value="44">세종</option>
            <option value="51">부산</option>
            <option value="52">울산</option>
            <option value="53">대구</option>
            <option value="54">경북</option>
            <option value="55">경남</option>
            <option value="61">전남</option>
            <option value="62">광주</option>
            <option value="63">전북</option>
            <option value="64">제주</option>
        </select>
        <select class="form-select" id="country" required="" v-model="selectedLanguage" :disabled="!translationChecked">
            <option value="선택">선택(언어)</option>
            <option value="KO">한국어</option>
            <option value="EN">English</option>
            <option value="ZH">中文</option>
        </select>
        <div class="alert alert-info position-absolute bottom-0 start-50 translate-notification" role="alert"
            v-if="showTranslationNotification">
            선택된 언어로 번역됩니다.
        </div>
        <select class="form-select" id="search-type" required="" v-model="selectedSearchType">
            <option value="title">제목</option>
            <option value="context">내용</option>
            <option value="title&context">제목+내용</option>
            <option value="writer">글쓴이</option>
        </select>
        <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search" v-model="searchValue">
        <button class="btn btn-outline-secondary" type="submit" @click.prevent="searchAndNavigate">
            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-search"
                viewBox="0 0 16 16">
                <path
                    d="M11.742 10.344a6.5 6.5 0 1 0-1.397 1.398h-.001q.044.06.098.115l3.85 3.85a1 1 0 0 0 1.415-1.414l-3.85-3.85a1 1 0 0 0-.115-.1zM12 6.5a5.5 5.5 0 1 1-11 0 5.5 5.5 0 0 1 11 0" />
            </svg>
        </button>
    </form>
</template>

<script setup>
import { ref, defineProps } from 'vue';
import { useRouter } from 'vue-router';


const searchValue = ref('');
const translationChecked = ref(false);
const selectedLocation = ref('0');
const selectedLanguage = ref('선택');
const selectedSearchType = ref('title');
const showTranslationNotification = ref(false);
const router = useRouter();

const props = defineProps({
    categoryId: String
})

function toggleTranslation() {
    translationChecked.value = !translationChecked.value;
    if (translationChecked.value) {
        showNotification();
    }
    else {
        selectedLanguage.value = '선택';
    }
};

function showNotification() {
    showTranslationNotification.value = true;
    setTimeout(() => {
        showTranslationNotification.value = false;
    }, 2000); // 2초 후에 알림창을 자동으로 숨깁니다.
};

function searchAndNavigate() {
    if (selectedLanguage.value === '선택') {
        router.push(`/search/${searchValue.value}&`);
    }
    else {
        router.push(`/search/${searchValue.value}&${selectedLanguage.value}`);
    }
};

</script>

<style scoped>
.tooltip {
    position: absolute;
    /* 부모 요소(container)를 기준으로 위치 지정 */
    bottom: 0;
    /* 하단에 표시 */
    left: 50%;
    /* 가운데 정렬을 위해 왼쪽 여백을 50%로 설정 */
    transform: translateX(-50%);
    /* 가운데 정렬 */
    padding: 5px 10px;
    /* 내부 여백 설정 */
    background-color: #333;
    /* 배경색 지정 */
    color: #fff;
    /* 글자색 지정 */
    border-radius: 5px;
    /* 테두리를 둥글게 만듦 */
    display: none;
    /* 초기에는 툴팁 숨김 */
}

* {
    font-family: 'NanumBarunGothic' !important;

}

.d-flex {
    gap: 10px;
}

.list-container {
    display: block;
    unicode-bidi: isolate;
    width: 100%;
    height: 100%;
    margin-top: 40px;
}

.list-header {
    display: flex;
    justify-content: space-between;
    align-items: center;
    padding: 10px 0;
    border-bottom: 1px solid #ccc;
}

.btn-light {
    border: 1px solid #ccc;
    margin-right: 10px;
}

#category-name {
    font-size: 25px;
    font-weight: bold;
    margin-left: 15px;
}

#table-container {
    display: flex;
    justify-content: center;
}

#pagenation-container {
    display: flex;
    justify-content: center;
}

.col-number {
    width: 5%;
    text-align: center;
}

.col-title {
    width: 20%;
    text-align: center;
}

.col-writer {
    width: 10%;
    text-align: center;
}

.col-hits {
    width: 10%;
    text-align: center;
}

.col-like {
    width: 10%;
    text-align: center;
}

.col-dislike {
    width: 10%;
    text-align: center;
}

.col-date {
    width: 15%;
    text-align: center;
}

.translate-notification {
    transition: all .4s;
    opacity: 80%;
    /* TODO 위치조정해야함 */
    transform: translate(-455px, -490px);
}
</style>