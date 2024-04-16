<template>
    <div class="my-3 p-3 bg-body rounded shadow-sm">
        <div class="border-bottom pb-2 col">
            <button type="button" class="btn btn-primary" @click="showIsNotChecked">{{ showText }}</button>
            <button type="button" class="btn btn-success" @click="showCheckedItems">선택 항목 확인</button>
            <h6>&nbsp; 수신 목록</h6>
        </div>
        <div v-for="(letter, index) in filteredLetters" :key="index">
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

const letterProps = ref(
    [
        {
            letterId: 1,
            message: "안녕하세용 뚱이에용",
            eventTime: "2024-03-06 15:10:19",
            isChecked: 0,
            sendId: "mem1",
            senderImage: "https://picsum.photos/100",
            senderNickname: "omoknoone1",
            receiveId: "mem2",
            receiverImage: "https://picsum.photos/100",
            receiverNickname: "omoknoone2"
        }, {
            letterId: 2,
            message: "안녕하세용 뚱이에용",
            eventTime: "2024-03-06 15:10:19",
            isChecked: 1,
            sendId: "mem1",
            senderImage: "https://picsum.photos/100",
            senderNickname: "omoknoone1",
            receiveId: "mem2",
            receiverImage: "https://picsum.photos/100",
            receiverNickname: "omoknoone2"
        }, {
            letterId: 3,
            message: "안녕하세용 뚱이에용",
            eventTime: "2024-03-06 15:10:19",
            isChecked: 1,
            sendId: "mem1",
            senderImage: "https://picsum.photos/100",
            senderNickname: "omoknoone1",
            receiveId: "mem2",
            receiverImage: "https://picsum.photos/100",
            receiverNickname: "omoknoone2"
        }, {
            letterId: 4,
            message: "안녕하세용 뚱이에용",
            eventTime: "2024-03-06 15:10:19",
            isChecked: 0,
            sendId: "mem1",
            senderImage: "https://picsum.photos/100",
            senderNickname: "omoknoone1",
            receiveId: "mem2",
            receiverImage: "https://picsum.photos/100",
            receiverNickname: "omoknoone2"
        }, {
            letterId: 5,
            message: "안녕하세용 뚱이에용",
            eventTime: "2024-03-06 15:10:19",
            isChecked: 0,
            sendId: "mem1",
            senderImage: "https://picsum.photos/100",
            senderNickname: "omoknoone1",
            receiveId: "mem2",
            receiverImage: "https://picsum.photos/100",
            receiverNickname: "omoknoone2"
        }
    ]
);

const checkedItems = ref([]);

const showIsNotCheckedStatus = ref(false);

const showText = ref("안읽은항목");


const router = useRouter();

function goMemberPage(memberid) {
    router.push(`/mypage/${memberid}`);
}

function hideText(index) {
    letterProps.value[index].isHidden = true;
}

function showCheckedItems() {
    console.log(checkedItems.value);
    checkedItems.value.forEach(letterId => {
        const foundLetter = letterProps.value.find(letter => letter.letterId === letterId);
        if (foundLetter) {
            foundLetter.isChecked = 1;
        }
    });
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
