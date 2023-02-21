<template>
<div>
  <div id="imgWrap" @click="goTranport()">
    <div id="imgDiv">
      <img src="../assets/banner.png" alt="" id="mainImg">
    </div>
    <div id="imgDivText">
      <p>BARO 배송신청</p>
    </div>
  </div>
  <div class="mainWrap">
  <br><br>
    <div id="boardWrap">
      <div id="mainNotice">
        <div class="mainBoardTitle">
          <h3 class="boardName">공지</h3>
        </div>
        <div style="width:526; height:155px">
          <table class="table">
            <thead>
              <tr class="tabelHead" >
                <th style="border-left: none; " width="15%">번호</th>
                <th width="50%">제목</th>
                <th width="20%">작성자</th>
                <th width="15%">작성일</th>
              </tr>
            </thead>
            <tbody v-if="this.noticeList != null">
              <tr v-for="noticelist in noticeList" v-bind:key="noticelist" class="FontSize14"  @click="noticeDetail(noticelist.NOTICE_NO)">
                <th scope="row">{{noticelist.NOTICE_NO}}</th>
                <td class="leftAlign line_limit_main">{{noticelist.NOTICE_TITLE}}</td>
                <td>{{noticelist.NOTICE_WRITER}}</td>
                <td>{{noticelist.NOTICE_DATE}}</td>
              </tr>
            </tbody>
            <tbody v-else>
              <tr>
                <td colspan="4">게시물이 존재하지 않습니다.</td>
              </tr>
            </tbody>
          </table>
        </div>
        <router-link to="/notice" class="more">더보기 +</router-link>
      </div>
      <div id="mainQna">
        <div class="mainBoardTitle">
          <h3 class="boardName">문의</h3>
        </div>
        <div style="width:526; height:155px">
          <table class="table">
            <thead>
              <tr class="tabelHead">
                <th style="border-left: none">번호</th>
                <th>제목</th>
                <th>작성자</th>
                <th>작성일</th>
              </tr>
            </thead>
            <tbody v-if="this.qnaList != null">
              <tr v-for="qnalist in qnaList" v-bind:key="qnalist" class="FontSize14"  @click="qnaDetail(qnalist.QNA_NO)">
                <th scope="row" width="15%">{{qnalist.QNA_NO}}</th>
                <td class="leftAlign line_limit_main" width="50%">{{qnalist.QNA_TITLE}}</td>
                <td width="15%">{{qnalist.USER_ID}}</td>
                <td width="15%">{{qnalist.QNA_DATE}}</td>
              </tr>
            </tbody>
            <tbody v-else>
              <tr>
                <td colspan="4">게시물이 존재하지 않습니다.</td>
              </tr>
            </tbody>
          </table>
        </div>
        <router-link to="/qna" class="more">더보기 +</router-link>
      </div>
    </div>
  </div>
</div>
</template>

<script>
import router from '../router'

export default {
  name: 'App',
  data () {
    return {
      noticeList: null,
      qnaList: null
    }
  },
  components: {
  },
  mounted () {
    this.axios.get('api/mainNoticeList').then(res => {
      if (res.data.length === 0) {
        this.qnaList = null
      } else {
        this.noticeList = res.data
      }
    }).catch(err => {
      console.log(err)
    })
    this.axios.get('api/mainQnaList').then(res => {
      if (res.data.length === 0) {
        this.qnaList = null
      } else {
        this.qnaList = res.data
      }
    }).catch(err => {
      console.log(err)
    })
  },
  methods: {
    goTranport () {
      if (this.$store.state.loginCheck === 'N') {
        alert('로그인 후 이용해주세요.')
        router.push('/login')
      } else {
        router.push('/transport')
      }
    },
    noticeDetail (nno) {
      this.axios.get('api/noticeDetail?nno=' + nno).then(res => {
        this.$store.commit('setNoticeDetail', res.data)
        router.push('/noticeDetail')
      }).catch(err => {
        console.log(err)
      })
    },
    qnaDetail (qno) {
      if (this.$store.state.loginCheck === 'N') {
        alert('로그인 후 이용해주세요.')
        router.push('/login')
      } else {
        this.axios.get('api/qnaDetail?qno=' + qno).then(res => {
          this.$store.commit('setQnaDetail', res.data)
          router.push('/qnaDetail')
        }).catch(err => {
          console.log(err)
        })
      }
    }
  },
  el: '#app'

}
</script>

<style>
table {
  text-align: center;
}
a{
  color: black;
  text-decoration: none;
}
a:hover{
  color: white;
}
#imgDiv{
  height: 500px;
  width: 1000px;
  margin: auto;
  margin-left: 27%;

}
#imgWrap{
  cursor: pointer;
  width: 100%;
  position: relative;
  background: rgb(21, 26, 33);
}
#imgDivText{
  position: absolute;
  bottom: 45%;
  left:3%;
  width: 100%;
  color: white;
  font-size: 50px;
  text-shadow: 5px 5px 0 rgb(3, 71, 95);
  width: 400px;
  height: 80px;
  border-radius: 0.5rem;
}
#imgDivText p{
  margin-left: 23px;
}
#imgDivText2{
  text-align: center;
  background-color: rgb(0, 137, 188);
  width: 200px;
}
#mainImg{
  height: 100%;
  width: 100%;
}
#boardWrap{
  display: flex;
}
.mainBoardTitle{
  position:absolute;
  background: white;
  top: -10%;
  left: 3%;
  width: 75px;
}
#mainNotice{
margin-right: 6%;
}
#mainQna{
margin-left: 6%;
}
.boardName{
  margin: 10px;
  margin-bottom: 1px;
  float: left;
  width: 200px;
}
#mainNotice,#mainQna{
  border: 1px black solid;
  width: 600px;
  height: 250px;
  position: relative;
  padding-top: 30px;
}
#mainNotice tbody tr:hover,#mainQna tbody tr:hover{
cursor: pointer;
background-color:rgba(0, 0, 0, 0.1);
}

#mainNotice table,#mainQna table{
  width: 95%;
  margin: auto;
}
.more{
  float: right;
  color: gray;
  font-size: 18px;
  margin-bottom: 10px;
  margin-right: 8px;
  margin-top: 10px;
}
.more:hover{
  color: rgb(40, 39, 39);
  cursor: pointer;
}
.line_limit_main {
      width:245px;
      overflow:hidden;
      text-overflow:ellipsis;
      white-space:nowrap;
      display:inline-block;
  }
</style>
