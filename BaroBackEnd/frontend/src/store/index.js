import { createStore } from 'vuex'
// import createPersistedState from 'vuex-persistedstate'
export default createStore({
  state: {
    count: 1,
    test: 'N',
    loginCheck: localStorage.getItem('loginCheck'),
    noticeDetail: null,
    qnaDetail: null,
    userNo: localStorage.getItem('user_no')
  },
  getters: {
  },
  mutations: {
  },
  actions: {
  },
  modules: {
  }

})
