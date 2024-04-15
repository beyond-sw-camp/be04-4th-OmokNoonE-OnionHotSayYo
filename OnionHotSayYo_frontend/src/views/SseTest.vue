<template>
    <div>
        <input type="text" id="id"/>
        <button type="button" id="butWithFun" @click="login">로그인</button>
        <button type="button" id="testFollow" @click="sendFollowRequest">테스트용 팔로우 전송 버튼</button>
    </div>
</template>

<script>
export default {
    methods: {
        async login() {
            const id = document.getElementById('id').value;
            const eventSource = new EventSource(`/api/notifications/subscribe?memberName=` + id);

            eventSource.addEventListener("sse", async function (event) {
                console.log(event.data);

                const data = JSON.parse(event.data);

                // 브라우저 알림
                const showNotification = () => {
                    const notification = new Notification('코드 봐줘', {
                        body: data.content
                    });

                    setTimeout(() => {
                        notification.close();
                    }, 10 * 1000);

                    notification.addEventListener('click', () => {
                        window.open(data.url, '_blank');
                    });
                };

                // 브라우저 알림 허용 권한
                let granted = false;

                if (Notification.permission === 'granted') {
                    granted = true;
                } else if (Notification.permission !== 'denied') {
                    let permission = await Notification.requestPermission();
                    granted = permission === 'granted';
                }

                // 알림 보여주기
                if (granted) {
                    showNotification();
                }
            });
        },

        async sendFollowRequest() {
            const followData = {
                fromMemberId: "member4",
                toMemberId: "member2"
            };

            try {
                const response = await fetch('/api/follows/follow', {
                    method: 'POST',
                    headers: {
                        'Content-Type': 'application/json'
                    },
                    body: JSON.stringify(followData)
                });

                if (response.ok) {
                    console.log('팔로우 요청이 성공적으로 전송되었습니다.');
                } else {
                    console.error('팔로우 요청 실패:', response.statusText);
                }
            } catch (error) {
                console.error('팔로우 요청 중 오류 발생:', error);
            }
        }
    }
}
</script>
