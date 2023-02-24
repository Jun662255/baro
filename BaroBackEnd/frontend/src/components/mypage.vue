<template>
  <div class="mainWrap">
    <div id="myPageWrap">

    <h2>마이 페이지</h2><hr><br>
      <div id="myPagedisplay" class="contentWrap">
        <div id="changeInfo">
          <h3>회원 정보 변경</h3>
            <div class="infoInput">
              <form action="">
                <input type="text" placeholder="이름" v-model="myInfo.my_name" readonly id="my_name">
                <input type="text" placeholder="아이디" v-model="myInfo.my_id" readonly>
                <input type="password" placeholder="현재 비밀번호" v-model="myInfo.now_pwd">
                <input type="password" placeholder="새 비밀번호" v-model="myInfo.new_pwd"  @change="new_pwd()" id="new_pwd">
                <input type="password" placeholder="새 비밀번호 확인" v-model="myInfo.new_pwdC" @change="new_pwdC()" id="new_pwdC">
                <input type="text" placeholder="번호"  v-model="myInfo.phone" @change="my_phone()" id="my_phone">
                <br>
                <button id="infoBtn" type="button" class="btn btn-dark" @click="infoChange()">변경:)</button>
              </form>
            </div>
        </div>

        <div id="myQna">
          <h3 style="margin-left:20px">나의 문의 내역</h3><br>
          <table class="table">
              <thead>
                  <tr>
                      <th style="width: 13%; border-left: none">번호</th>
                      <th style="width: 55%;">제목</th>
                      <th style="width: 15%;">답변</th>
                      <th style="width: 17%;">작성일</th>
                  </tr>
              </thead>
              <tbody v-if="this.qnaList != null" >
                  <tr v-for="qnaList in qnaList" v-bind:key="qnaList.QNA_NO" @click="qnaDetail(qnaList.QNA_NO)">
                      <td>{{qnaList.QNA_NO_ROW}}</td>
                      <td class="leftAlign line_limit_my2">{{qnaList.QNA_TITLE}}</td>
                      <td v-if="qnaList.CHECK_COMMENT ==='Y'" style="color:blue">답변완료</td>
                      <td v-else-if="qnaList.CHECK_COMMENT ==='N'" style="color:red">답변미완</td>
                      <td>{{qnaList.QNA_DATE}}</td>
                  </tr>
              </tbody>
              <tbody v-else>
                <tr>
                  <td colspan="5">게시물이 존재하지 않습니다.</td>
                </tr>
              </tbody>
              <tr>
                <td colspan="4" style="margin:auto;">
                  <div class="pageWrap" v-if="this.qPi.listCount != 0" style="margin:auto; display:flex; justify-content:center; margin-top:15px">
                    <div v-if="this.qPi.currentPage != 1">
                      <button class="btn btn-dark paging" @click="previousPageQ()">&lt;</button>
                    </div>
                    <div id="pagingDiv" v-for="(item, pageLimit) in range(this.qPi.startPage, this.qPi.endPage)" :key="pageLimit">
                      <button class="btn btnPaging" :class="{'btn-dark': item != this.qPi.currentPage, 'btn-secondary': item === this.qPi.currentPage}"
                        @click="getMyQnaListQ(item)">
                        {{item}}
                      </button>
                    </div>
                    <div v-if="this.qPi.currentPage != this.qPi.maxPage " @click="nextPageQ()">
                      <button class="btn btn-dark paging" >&gt;</button>
                    </div>
                  </div>
                </td>
              </tr>
          </table>
        </div>
      </div>
      <br><br>
      <h4 style="margin-left: 10px;margin-top: 10px;" >&nbsp;나의 배송정보&nbsp;</h4>
      <div id="myTransport" style="border: 2px solid black;">
        <table class="table">
            <thead>
                <tr>
                  <th width="5%" style="border-left: none">번호</th>
                  <th width="8.3%" >보내시는 분</th>
                  <th width="29.5%" >출발지</th>
                  <th width="8.3%" >받는분</th>
                  <th width="30%" >도착지</th>
                  <th width="5.9%" >가격</th>
                  <th width="6.5%" >배송상태</th>
                </tr>
            </thead>
            <tbody v-if="this.myTransport != null">
                <tr class="FontSize14" v-for="myTransport in myTransport" v-bind:key="myTransport" >
                  <th>{{myTransport.TRANSPORT_NO}}</th>
                  <td>{{myTransport.USER_NAME}}</td>
                  <td class="leftAlign line_limit_my">{{myTransport.DEPARTURE}}</td>
                  <td>{{myTransport.RECIPIENT}}</td>
                  <td class="leftAlign line_limit_my">{{myTransport.DESTINATION}}</td>
                  <td >{{priceComma(myTransport.PRICE)}}</td>
                  <td>{{myTransport.CD_NM}}</td>
                </tr>
            </tbody>
            <tbody v-else>
              <tr>
                <td colspan="7">배송정보가 존재하지 않습니다.</td>
              </tr>
            </tbody>
        </table>
      </div>
          <div id="pageDiv">
            <div class="pageWrap" v-if="this.pi.listCount != 0">
              <div v-if="this.pi.currentPage != 1">
                <button class="btn btn-dark paging" @click="previousPage()">&lt;</button>
              </div>
              <div id="pagingDiv" v-for="(item, pageLimit) in range(this.pi.startPage, this.pi.endPage)" :key="pageLimit">
                <button class="btn btnPaging" :class="{'btn-dark': item != this.pi.currentPage, 'btn-secondary': item === this.pi.currentPage}"
                  @click="getTransportList(item)">
                  {{item}}
                </button>
              </div>
              <div v-if="this.pi.currentPage != this.pi.maxPage " @click="nextPage()">
                <button class="btn btn-dark paging" >&gt;</button>
              </div>
            </div>
          </div>
    </div>
  </div>
</template>

<script>
import axios from 'axios'
import router from '../router'
export default {
  name: 'App',
  components: {
  },
  data () {
    return {
      myTransport: null,
      myInfo: {
        my_name: this.$store.state.userInfo[0].USER_NAME,
        my_id: this.$store.state.userInfo[0].USER_ID,
        now_pwd: null,
        new_pwd: null,
        new_pwdC: null,
        phone: this.$store.state.userInfo[0].PHONE
      },
      regExpNew_pwd: 'Y',
      regExpNew_pwdC: 'Y',
      regExpPhone: 'Y',
      pi: {
        currentPage: 1,
        endPage: 0,
        maxPage: 0,
        pageLimit: 0,
        startPage: 0,
        listCount: 0
      },
      user_no: this.$store.state.userInfo[0].USER_NO,
      qnaList: null,
      qPi: {
        currentPage: 1,
        endPage: 0,
        maxPage: 0,
        pageLimit: 0,
        startPage: 0,
        listCount: 0
      }
    }
  },
  mounted () {
    if (this.$store.state.loginCheck === 'N') {
      alert('로그인후 이용 바랍니다')
      router.push('/login')
    }
    axios({
      method: 'Post',
      url: 'api/myTransport?cPage=' + this.pi.currentPage,
      data: {
        user_no: this.$store.state.userInfo[0].USER_NO
      }
    }).then(data => {
      if (data.data.list.length === 0) {
        this.myTransport = null
      } else {
        this.myTransport = data.data.list
      }
      this.pi = data.data.pi
    }).catch(err => {
      console.log(err)
    })
    axios({
      method: 'Post',
      url: 'api/myQnaList?cPage=' + this.qPi.currentPage,
      data: {
        user_no: this.user_no
      }
    }).then(data => {
      if (data.data.list.length === 0) {
        this.qnaList = null
      } else {
        this.qnaList = data.data.list
      }
      this.qPi = data.data.pi
    }).catch(err => {
      console.log(err)
    })
  },
  methods: {
    qnaDetail (qno) {
      if (this.$store.state.loginCheck === 'N') {
        alert('로그인후 가능합니다')
        router.push('/login')
      } else {
        this.axios.get('api/qnaDetail?qno=' + qno).then(res => {
          this.$store.commit('setQnaDetail', res.data)
          router.push('/qnaDetail')
        }).catch(err => {
          console.log(err)
        })
      }
    },
    priceComma (val) {
      return String(val).replace(/\B(?=(\d{3})+(?!\d))/g, ',') + '원'
    },
    infoChange () {
      if (this.myInfo.now_pwd === null || this.myInfo.now_pwd === '') {
        alert('비밀번호를 작성해주세요')
      } else if (this.regExpNew_pwd === 'Y' && this.regExpNew_pwdC === 'Y' && this.regExpPhone === 'Y') {
        axios({
          method: 'post',
          url: 'api/infoChange',
          data: {
            user_no: this.$store.state.userInfo[0].USER_NO,
            user_pwd: this.myInfo.now_pwd,
            new_pwd: this.myInfo.new_pwd,
            phone: this.myInfo.phone
          }
        }).then(data => {
          if (data.data === 1) {
            this.$store.commit('setLogOut', null)
            alert('회원정보가 변경되었습니다 다시 로그인 해주세요')
            location.replace('/login')
          } else {
            alert('비밀번호를 확인해 주세요')
          }
        }).catch(err => {
          console.log(err)
        })
      } else {
        alert('다시 시도해주세요')
      }
    },
    my_phone () {
      var myPhone = document.getElementById('my_phone').value
      var regExpPwd = /^[\d]{11}$/
      var myPhoneC = document.getElementById('my_phone')
      if (!regExpPwd.test(myPhone)) {
        myPhoneC.style.borderBottomColor = 'red'
        this.regExpPhone = 'N'
        alert('전화번호를 확인해 주세요 -미포함')
      } else {
        myPhoneC.style.borderBottomColor = 'black'
        this.regExpPhone = 'Y'
      }
    },
    new_pwd () {
      var newPwd = document.getElementById('new_pwd').value
      var regExpPwd = /^(?=.*[a-zA-Z])(?=.*[0-9])[a-zA-Z0-9]{6,10}$/
      var pwdP1 = document.getElementById('new_pwd')
      if (!regExpPwd.test(newPwd)) {
        pwdP1.style.borderBottomColor = 'red'
        this.regExpNew_pwd = 'N'
        alert('새 비밀번호를 확인해 주세요 영문자,숫자조합 6-10')
      } else {
        pwdP1.style.borderBottomColor = 'black'
        this.regExpNew_pwd = 'Y'
      }
    },
    new_pwdC () {
      var newPwd = document.getElementById('new_pwd').value
      var newPwdC = document.getElementById('new_pwdC').value
      var newPwdC1 = document.getElementById('new_pwdC')
      if (newPwd !== newPwdC) {
        newPwdC1.style.borderBottomColor = 'red'
        this.regExpNew_pwdC = 'N'
        alert('새 비밀번호와 동일하게 작성해주세요')
      } else {
        newPwdC1.style.borderBottomColor = 'black'
        this.regExpNew_pwdC = 'Y'
      }
    },
    range: function (start, end) {
      return Array(end - start + 1).fill().map((_, idx) => start + idx)
    },
    previousPage () {
      this.pi.currentPage = this.pi.currentPage - 1
      this.getTransportList(this.pi.currentPage)
    },
    nextPage () {
      this.pi.currentPage = this.pi.currentPage + 1
      this.getTransportList(this.pi.currentPage)
    },
    getTransportList (cPage) {
      axios({
        method: 'Post',
        url: 'api/myTransport?cPage=' + cPage,
        data: {
          user_no: this.$store.state.userInfo[0].USER_NO
        }
      }).then(data => {
        if (data.data.list.length === 0) {
          this.myTransport = null
        } else {
          this.myTransport = data.data.list
        }
        this.pi = data.data.pi
      }).catch(err => {
        console.log(err)
      })
    },
    previousPageQ () {
      this.qPi.currentPage = this.qPi.currentPage - 1
      this.getMyQnaListQ(this.qPi.currentPage)
    },
    nextPageQ () {
      this.qPi.currentPage = this.qPi.currentPage + 1
      this.getMyQnaListQ(this.qPi.currentPage)
    },
    getMyQnaListQ (cPage) {
      axios({
        method: 'Post',
        url: 'api/myQnaList?cPage=' + cPage,
        data: {
          user_no: this.$store.state.userInfo[0].USER_NO
        }
      }).then(data => {
        if (data.data.list.length === 0) {
          this.qnaList = null
        } else {
          this.qnaList = data.data.list
        }
        this.qPi = data.data.pi
      }).catch(err => {
        console.log(err)
      })
    }
  }
}
</script>

<style>
#myTransport{
  position: relative;
  padding: 10px;
  padding-top: 15px;
  height: auto;
}
#myTransportTitle{
  position: absolute;
  top: -5.5%;
  background: white;
  left: 2.5%;
  width: 110;
}
.mainWrap{
 width: 1200px;
 margin: auto;
}
#changeInfo{
  width: 40%;
  height: 650px;
  text-align: left;
  border: black solid 2px;
  padding: 50px;
}

.infoInput input{
  width: 80%;
  height: 70%;
  border: none;
  border-bottom: 2px solid black;
  font-size: 20px;
  margin-top: 30px;
}
.infoInput input:focus {
  outline:none;
}
#infoBtn{
  float: right;
  width: 200px;
  height: 50px;
  margin-top: 20px;
}
#myPageTable{
  width: 1178px;
  height: 553px;
  text-align: center;
}
#myPageTable tr{
  height: 50px;
}
.redBorder{
  width: 80%;
  height: 70%;
  border: none;
  border-bottom: 2px solid red;
  font-size: 20px;
}
.pageWrap{
    margin: auto;
    margin-top:10px;
}
#pageDiv{
  width: 100%;
  display: flex;
  flex-direction: row;
}
.line_limit_my1 {
  width:350px;
  overflow:hidden;
  text-overflow:ellipsis;
  white-space:nowrap;
  display:inline-block;
}
.line_limit_my2 {
  width:305px;
  overflow:hidden;
  text-overflow:ellipsis;
  white-space:nowrap;
  display:inline-block;
}
#myQna{
  width: 55%;
  height: 650px;
  border: black solid 2px;
  float: right;
  margin-left: 5%;
  padding: 50px;
}
#myPagedisplay{
  display: flex;
  flex-direction: row
}
#myQnaList :hover{
  background-color: rgba(0, 0, 0, 0.1);
  cursor: pointer;
}
</style>
