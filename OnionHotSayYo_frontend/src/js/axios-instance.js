import axios from 'axios';

// Axios 인스턴스 생성
const instance = axios.create({
    baseURL: 'http://localhost:8080',
});

// Request 인터셉터 - 모든 요청에 대해 실행됨
instance.interceptors.request.use(config => {
    const tokenString = localStorage.getItem('accessToken');
    console.log(`[REQ interceptor]`);

    if (tokenString) {
        const accessToken = JSON.parse(tokenString);
        console.log(`[REQ interceptor] : ${accessToken}`);

        // 현재시간과 만료시간 비교
        if (Date.now() > accessToken.expireTime) {      // 토큰 시간 만료
            console.warn("토큰 만료!!!");

            // 만료시간이 지나면 삭제
            localStorage.removeItem('accessToken');

            /* TODO. 
                refresh token 있나 확인 후 있으면 서버에 재발급 요청
                refresh token 만료된 경우 재로그인 해야 함 
            */
        } else {
            config.headers.Authorization = `Bearer ${accessToken.accessToken}`;
        }
    }

    return config;
}, error => {
    return Promise.reject(error);
});

// Response 인터셉터 - 모든 응답에 대해 실행됨
instance.interceptors.response.use(response => {
    console.log(`[RES interceptor]`);
    return response;
}, error => {
    // 토큰 만료 확인 및 처리
    if (error.response.status === 401) {
        // 토큰 만료되었으므로 로그아웃하거나 새로운 토큰을 요청합니다.
        // 로그아웃하는 메서드를 호출하거나 토큰 갱신 요청을 보내는 등의 작업을 수행합니다.
    }
    return Promise.reject(error);
});

export default instance;