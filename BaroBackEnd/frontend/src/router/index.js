import { createRouter, createWebHistory } from 'vue-router'
import main from '@/components/main'
import login from '@/components/login'
import transport from '@/components/transport'
import notice from '@/components/noticeBoard'
import qna from '@/components/qnaBoard'
import qnaCreate from '@/components/qnaCreate'
import qnaDetail from '@/components/qnaDetail'
import noticeDetail from '@/components/noticeDetail'
import SingUp from '@/components/SingUp'
import success from '@/components/success'
import mypage from '@/components/mypage'
import qnaUpdate from '@/components/qnaUpdate'
import store from '@/store'
const routes = [
  {
    path: '/',
    name: 'main1',
    component: main
  },
  {
    path: '/main',
    name: 'main',
    component: main
  },
  {
    path: '/login',
    name: 'login',
    component: login
  },
  {
    path: '/transport',
    name: 'transport',
    component: transport
  },
  {
    path: '/qna',
    name: 'qna',
    component: qna
  },
  {
    path: '/notice',
    name: 'notice',
    component: notice
  },
  {
    path: '/qnaCreate',
    name: 'qnaCreate',
    component: qnaCreate
  },
  {
    path: '/qnaDetail',
    name: 'qnaDetail',
    component: qnaDetail
  },
  {
    path: '/noticeDetail',
    name: 'noticeDetail',
    component: noticeDetail
  },
  {
    path: '/SingUp',
    name: 'SingUp',
    component: SingUp
  },
  {
    path: '/success',
    name: 'success',
    component: success
  },
  {
    path: '/mypage',
    name: 'mypage',
    component: mypage
  },
  {
    path: '/qnaUpdate',
    name: 'qnaUpdate',
    component: qnaUpdate
  }

]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

router.beforeEach((to, from, next) => {
  const loginCheck = store.state.loginCheck
  if (loginCheck === 'N' && ['transport', 'qnaCreate', 'qnaDetail', 'success', 'mypage', 'qnaUpdate'].includes(to.name)) {
    alert('로그인 후 이용해주세요.')
    next('/login')
  } else if (loginCheck === 'Y' && to.name === 'login') {
    alert('이미 로그인된 상태입니다.')
    next('/main')
  } else {
    next()
  }
})

export default router
