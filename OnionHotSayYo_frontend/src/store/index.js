import { useCookies } from 'vue3-cookies'
import { createStore } from "vuex";
const { cookies } = useCookies();

// import axios from '../../plugins/axios';

// export default createStore({
//   state: {
//     counter: 10
//   },
//   getters: {
//     time2(state) {
//       return state.counter * 2;
//     }
//   },
//   mutations: {
//     setCounter(state, value) {
//       state.counter = value;
//     }
//   }
// });
export default createStore({
  namespaced: true,
  state: {
    needLogin: true,
  },
  mutations: {
    needLogin(state, data) {
      state.needLogin = data;
    },
  },
  getters: {
    isNeedLogin(state) {
      return state.needLogin;
    },
  },
  actions: {
    login({ commit }, params) { //로그인 및 토큰 처리
      return new Promise(async (resolve, reject) => {
        try {
          const config = {
            headers: {
              'Content-Type': 'application/json',
            }
          };
          const rs = await this.axios.post('/api/auth/login', params, config);
          if (rs.data.ok) {
            const access = rs.data.result.accessToken;
            const refresh = rs.data.result.refreshToken;
            cookies.set('accessToken', access, import.meta.env.VITE_ACCESS_TIME);
            cookies.set('refreshToken', refresh, import.meta.env.VITE_REFRESH_TIME);
            commit('needLogin', false);
          }
          resolve(rs.data.msg);
        } catch (err) {
          console.error(err);
          reject(err);
        }
      })
    },
    verifyToken({ commit }) { //라우터 이동 시 토큰 검증
      return new Promise(async (resolve, reject) => {
        try {
          const rs = await this.axios.post('/api/auth/accessTokenCheck');
          if (rs.data.ok) {
            resolve(true);
          } else {
            console.error(rs.data.msg);
            alert(rs.data.result);
            commit('needLogin', true);
            resolve(false);
          }
        } catch (err) {
          console.error(err);
          reject(err);
        }
      })
    },
    refreshToken({ commit }) { //토큰 재발급
      return new Promise(async (resolve, reject) => {
        try {
          const rs = await this.axios.post('/api/auth/refreshToken');
          if (rs.data.ok) {
            const access = rs.data.result.accessToken;
            const refresh = rs.data.result.refreshToken;
            cookies.set('accessToken', access, import.meta.env.VITE_ACCESS_TIME);
            cookies.set('refreshToken', refresh, import.meta.env.VITE_REFRESH_TIME);
            commit('needLogin', false);
            resolve(true);
          } else {
            console.error(rs.data.msg);
            commit('needLogin', true);
            resolve(false);
          }
        } catch (err) {
          console.error(err);
          reject(err);
        }
      })
    },
  }
});