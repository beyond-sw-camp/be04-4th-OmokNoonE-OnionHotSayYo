import axios from 'axios';

// Axios 인스턴스 생성
const instance = axios.create({
    baseURL: `http://localhost:8080`,
    withCredentials: true
});

// Request 인터셉터 - 모든 요청에 대해 실행됨
// header에 토큰 담아서 요청 보내기
instance.interceptors.request.use(config => {
    const tokenString = localStorage.getItem('accessToken');
    const cookieString = document.cookie;
    const cookies = cookieString.split('; ');

    if (tokenString) {
        const accessToken = JSON.parse(tokenString);

        // 현재시간과 만료시간 비교
        if (Date.now() > accessToken.expireTime) {      // 토큰 시간 만료

            // 쿠키에서 refreshTokenId 가져와 Header에 담기
            cookies.forEach(cookie => {
                const [cookieName, cookieValue] = cookie.split('=');
                if(cookieName === "refreshTokenId") {
                    config.headers.Authorization = `Bearer ${accessToken.accessToken}`;
                    config.headers.Authorization = cookieValue.trim();
                }
            });

            // TODO. refresh token 만료된 경우 재로그인 해야 함 
        } else {
            config.headers.Authorization = `Bearer ${accessToken.accessToken}`;
        }
    }

    return config;
}, error => {
    return Promise.reject(error);
});


// Response 인터셉터 - 모든 응답에 대해 실행됨
// 응답 시 access token 갱신하기
instance.interceptors.response.use(async response => {

    if(response.headers["accesstoken"]) {
        const newAccessToken = response.headers["accesstoken"];
        localStorage.removeItem("accessToken");
        saveToken(newAccessToken);
        response.config.headers = {
            accesstoken: `${newAccessToken}`
        };
    }
    return response;
}, error => {
    if(error.response) {
        // 토큰 만료 확인 및 처리
        if (error.response.status === 401) {
            // 토큰 만료되었으므로 로그아웃하거나 새로운 토큰을 요청합니다.
            // 로그아웃하는 메서드를 호출하거나 토큰 갱신 요청을 보내는 등의 작업을 수행합니다.
        }
    } else {
        console.error("서버 통신 불가.")
    }
    return Promise.reject(error);
});

function saveToken(accessToken) {
    if (accessToken) {
        const expireTime = Date.now() + 12 * 60 * 60 * 1000;             // 1 Hour
        const data = {
            accessToken: accessToken,
            expireTime: expireTime
        };

        localStorage.setItem("accessToken", JSON.stringify(data));
    }
}

export default instance;