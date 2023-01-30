import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'
import main from '@/components/main'
import login from '@/components/login'
import transport from '@/components/transport'
import notice from '@/components/noticeBoard'
import qna from '@/components/qnaBoard'
import qnaCreate from '@/components/qnaCreate'
import qnaDetail from '@/components/qnaDetail'
import noticeDetail from '@/components/noticeDetail'
import SingUp from '@/components/SingUp'
import seccess from '@/components/seccess'
import mypage from '@/components/mypage'

const routes = [
  {
    path: '/',
    name: 'home',
    component: HomeView
  },
  {
    path: '/about',
    name: 'about',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import(/* webpackChunkName: "about" */ '../views/AboutView.vue')
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
    path: '/seccess',
    name: 'seccess',
    component: seccess
  },
  {
    path: '/mypage',
    name: 'mypage',
    component: mypage
  }
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router
