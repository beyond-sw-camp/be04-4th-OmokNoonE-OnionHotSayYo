<template>
    <div class="my-3 p-3 bg-body rounded shadow-sm">
        <div>
            <h6 class="border-bottom pb-2 mb-0">송신 목록</h6>
        </div>
        <div v-for="(letter, index) in letterProps" :key="index">
            <div v-show="!letter.isHidden">
                <div class="d-flex text-body-secondary border-bottom pt-3">
                    <img class="bd-placeholder-img flex-shrink-0 me-2 rounded" :src="letter.senderImage" width="32"
                        height="32" focusable="false">
                    <p class="pb-3 mb-0 small lh-sm  flex-grow-1">
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
import { inject, ref, readonly, onMounted } from 'vue';
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
            isChecked: 0,
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
            isChecked: 0,
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

const router = useRouter();

function goMemberPage(memberid) {
    router.push(`/mypage/${memberid}`);
}

function hideText(index) {
    letterProps.value[index].isHidden = true;
}
</script>

<style scoped>
* {
    font-family: 'NanumBarunGothic' !important;
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
</style>