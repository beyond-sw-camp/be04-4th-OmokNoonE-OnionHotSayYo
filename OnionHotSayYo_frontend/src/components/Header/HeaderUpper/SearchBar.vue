<template>
    <div class="position-relative">
        <form class="d-flex" role="search">
            <input type="checkbox" class="btn-check" id="btncheck-header" autocomplete="off" />
            <label class="btn btn-outline-primary" for="btncheck-header" @click="toggleTranslation">
                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor"
                    class="bi bi-translate" viewBox="0 0 16 16">
                    <path
                        d="M4.545 6.714 4.11 8H3l1.862-5h1.284L8 8H6.833l-.435-1.286zm1.634-.736L5.5 3.956h-.049l-.679 2.022z" />
                    <path
                        d="M0 2a2 2 0 0 1 2-2h7a2 2 0 0 1 2 2v3h3a2 2 0 0 1 2 2v7a2 2 0 0 1-2 2H7a2 2 0 0 1-2-2v-3H2a2 2 0 0 1-2-2zm2-1a1 1 0 0 0-1 1v7a1 1 0 0 0 1 1h7a1 1 0 0 0 1-1V2a1 1 0 0 0-1-1zm7.138 9.995q.289.451.63.846c-.748.575-1.673 1.001-2.768 1.292.178.217.451.635.555.867 1.125-.359 2.08-.844 2.886-1.494.777.665 1.739 1.165 2.93 1.472.133-.254.414-.673.629-.89-1.125-.253-2.057-.694-2.82-1.284.681-.747 1.222-1.651 1.621-2.757H14V8h-3v1.047h.765c-.318.844-.74 1.546-1.272 2.13a6 6 0 0 1-.415-.492 2 2 0 0 1-.94.31" />
                </svg>
            </label>
            <select class="form-select" id="country" required="" v-if="translationChecked" v-model="selectedLanguage"
                :disabled="!translationChecked">
                <option value="EN">English</option>
                <option value="KO">한국어</option>
                <option value="ZH">中文</option>
            </select>
            <div class="alert alert-info position-absolute bottom-0 start-50 translate-notification" role="alert"
                v-if="showTranslationNotification">
                선택된 언어로 번역됩니다.
            </div>
            <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search"
                v-model="searchValue" />
            <button class="btn btn-outline-secondary" type="submit" @click.prevent="searchAndNavigate">
                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-search"
                    viewBox="0 0 16 16">
                    <path
                        d="M11.742 10.344a6.5 6.5 0 1 0-1.397 1.398h-.001q.044.06.098.115l3.85 3.85a1 1 0 0 0 1.415-1.414l-3.85-3.85a1 1 0 0 0-.115-.1zM12 6.5a5.5 5.5 0 1 1-11 0 5.5 5.5 0 0 1 11 0" />
                </svg>
            </button>
        </form>
    </div>
</template>

<script setup>
import { ref } from 'vue';
import { useRouter } from 'vue-router';


const searchValue = ref('');
const translationChecked = ref(false);
const selectedLanguage = ref('선택');
const showTranslationNotification = ref(false);
const router = useRouter();


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

function searchAndNavigate(){
    if (selectedLanguage.value === '선택') {
        router.push(`/search/${searchValue.value}&`);
    }
    else {
        router.push(`/search/${searchValue.value}&${selectedLanguage.value}`);
    }
};

</script>

<style scoped>
* {
    font-family: 'NanumBarunGothic' !important;
}

.dropdown {
    margin-right: 5px;
}

input {
    border-width: 1;
    background-color: white;
    min-width: 100px;
    color: gray;
}

.d-flex {
    margin-right: 10px;
    gap: 5px;
}

.form-select {
    min-width: 110px;
}

.form-control {
    min-width: 200px;
}

.translate-notification {
    transition: all .4s;
    opacity: 80%;
    transform: translate(-430px, 20px);
}
</style>