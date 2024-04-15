import { useCookies } from 'vue3-cookies'
import { createStore } from "vuex";
const { cookies } = useCookies();
import axios from '../js/axios-instance.js';

export default createStore({
  namespaced: true,
  state: {
    isNeedLogin: true,
    // isNeedLogin: false,
  },
  mutations: {
    needLogin(state, data) {
      // state.needLogin = data;
      state.isNeedLogin = data;
    },
  },
  getters: {
    isNeedLogin(state) {
      // return state.needLogin;
      return state.isNeedLogin;
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
          const response = await axios.post('/login', params, config);

          const status = response.status;
          if(status === 200){
            commit('needLogin', false);
          }
          resolve(`로그인 성공 : ${status}`);
        } catch (err) {
          console.error(err);
          reject(err);
        }
      })
    },
    logout({ commit }, params) { //로그아웃 및 토큰 삭제
      return new Promise(async (resolve, reject) => {
        try {
          /* TODO. 토큰 삭제 처리 */
          localStorage.removeItem("accessToken");
          cookies.remove("refreshTokenId");
          commit('needLogin', true);
          resolve("로그아웃 성공");
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