<template>
    <div class="my-3 p-3 bg-body rounded shadow-sm">
        <div class="border-bottom pb-2 col">
            <button type="button" class="btn btn-primary" @click="showIsNotChecked">{{ showText }}</button>
            <button type="button" class="btn btn-success" @click="showCheckedItems">선택 항목 확인</button>
            <h6>&nbsp; 수신 목록</h6>
        </div>
        <div v-for="(letter, index) in filteredLetters" :key="index" v-if="!loadingState">
            <div v-show="!letter.isHidden">
                <div class="d-flex text-body-secondary border-bottom pt-3">
                    <input class="form-check-input" type="checkbox" :value="letter.letterId" v-model="checkedItems">
                    <img class="bd-placeholder-img flex-shrink-0 me-2 rounded" :src="letter.senderImage" width="32"
                        height="32" focusable="false">
                    <p class="pb-3 mb-0 small lh-sm flex-grow-1">
                        <strong class="d-block text-gray-dark" @click="goMemberPage(letter.sendId)">
                            @{{ letter.senderNickname }}({{ letter.sendId }})
                        </strong>
                    <div v-html="letter.message"></div>
                    </p>
                    <button class="btn-close" @click="hideText(index)"></button>
                </div>
            </div>
        </div>
        <div class="pagenation-container">
            <ul class="pagination">
                <li class="page-item">
                    <a class="page-link" href="#" aria-label="Previous">
                        <span aria-hidden="true">&laquo;</span>
                    </a>
                </li>
                <li class="page-item"><a class="page-link" href="#">1</a></li>
                <li class="page-item"><a class="page-link" href="#">2</a></li>
                <li class="page-item"><a class="page-link" href="#">3</a></li>
                <li class="page-item">
                    <a class="page-link" href="#" aria-label="Next">
                        <span aria-hidden="true">&raquo;</span>
                    </a>
                </li>
            </ul>
        </div>
    </div>
</template>

<script setup>
import { inject, ref, onMounted, computed } from 'vue';
import { useRouter } from 'vue-router';
import axios from 'axios';

const injectMemberId = inject("memberId");

const letters = [];

const letterProps = ref([{}]);

const loadingState = ref(true);

const checkedItems = ref([]);

const showIsNotCheckedStatus = ref(false);

const showText = ref("안읽은항목");

onMounted(async () => {
    try {
        const response = await axios.get("http://localhost:8083/letters");
        loadingState.value = false;
        letters.value = response.data;
        for (let i = 0; i < letters.value.length; i++) {
            if (letters.value[i].RECEIVE_ID == injectMemberId) {
                const letterId = letters.value[i].LETTER_ID;
                const message = letters.value[i].MESSAGE;
                const eventTime = letters.value[i].EVENTTIME;
                const isChecked = letters.value[i].IS_CHECKED;
                const sendId = letters.value[i].SEND_ID;
                const senderImage = letters.value[i].SENDER_IMAGE;
                const senderNickname = letters.value[i].SENDER_NICKNAME;
                const receiveId = letters.value[i].RECEIVE_ID;
                const receiverImage = letters.value[i].RECEIVER_IMAGE;
                const receiverNickname = letters.value[i].RECEIVER_NICKNAME;

                letterProps.value[i] = {
                    letterId: letterId,
                    message: message.replace(/\n/g, '<br>'),
                    eventTime: eventTime,
                    isChecked: isChecked,
                    sendId: sendId,
                    senderImage: senderImage,
                    senderNickname: senderNickname,
                    receiveId: receiveId,
                    receiverImage: receiverImage,
                    receiverNickname: receiverNickname,
                    isHidden: false // Add isHidden property to track visibility
                };
            }
        }
    } catch (error) {
        console.error("Error fetching letters:", error);
    }
});

const router = useRouter();

function goMemberPage(memberid) {
    router.push(`/mypage/${memberid}`);
}

function hideText(index) {
    letterProps.value[index].isHidden = true;
}

function showCheckedItems() {
    console.log(checkedItems.value);
}

function showIsNotChecked() {
    showIsNotCheckedStatus.value = !showIsNotCheckedStatus.value;

    if (showIsNotCheckedStatus.value) {
        showText.value = "전체항목";
    } else {
        showText.value = "안읽은항목";
    }
}

const filteredLetters = computed(() => {
    if (showIsNotCheckedStatus.value) {
        return letterProps.value.filter(letter => letter.isChecked === 0);
    } else {
        return letterProps.value;
    }
});
</script>

<style scoped>
* {
    font-family: 'NanumBarunGothic' !important;
}

.btn-primary {
    position: absolute;
    right: 150px;
    top: 125px;
}

.btn-success {
    position: absolute;
    right: 30px;
    top: 125px;
}

.form-check-input {
    width: 1.3em;
    height: 1.3em;
    margin: 5px 10px;
}

.text-gray-dark {
    width: fit-content;
}

.text-gray-dark:hover {
    cursor: pointer;
}

.pagenation-container {
    display: flex;
    justify-content: center;
    margin-top: 20px;
}

.check {
    width: fit-content;
    height: fit-content;
}
</style>
