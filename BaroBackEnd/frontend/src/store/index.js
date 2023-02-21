import { createStore } from 'vuex'
import createPersistedState from 'vuex-persistedstate'
export default createStore({
  state: {
    count: 1,
    loginCheck: 'N',
    noticeDetail: '',
    qnaDetail: '',
    userInfo: ''
  },
  getters: {
    getQnaDetail: (state) => {
      return state.qnaDetail
    },
    getUserInfo: (state) => {
      return state.userInfo
    },
    getLoginCheck: (state) => {
      return state.userInfo
    }
  },
  mutations: {
    setNoticeDetail: (state, noticeDetail) => {
      state.noticeDetail = noticeDetail
    },
    setQnaDetail: (state, data) => {
      state.qnaDetail = data
    },
    setUserInfo: (state, data) => {
      state.userInfo = data
    },
    setLoginCheck: (state, data) => {
      state.loginCheck = data
    },
    setLogOut: (state, data) => {
      state.loginCheck = 'N'
      state.userInfo = data
    }
  },
  actions: {
  },
  modules: {
  },
  plugins: [createPersistedState({
    storage: window.sessionStorage
  })]
})
