<template>
<div>
<!-- <router-link to="/transport"> -->
  <div id="imgWrap" @click="goTranport()">
    <div id="imgDiv">
      <img src="../assets/banner.png" alt="" id="mainImg">
    </div>
    <div id="imgDivText">
      <p>BARO 배송신청</p>
    </div>
  </div>
  <!-- </router-link> -->
  <div class="mainWrap">
  <br>
  <br>
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
          <!-- <tbody> -->
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
      <table class="table">
        <thead>
          <tr class="tabelHead">
            <th style="border-left: none">번호</th>
            <th>제목</th>
            <th>작성자</th>
            <th>작성일</th>
          </tr>
        </thead>
        <!-- <tbody v-if="this.qnaList != null"> -->
        <tbody>
         <tr v-for="qnalist in qnaList" v-bind:key="qnalist" class="FontSize14"  @click="qnaDetail(qnalist.QNA_NO)">
            <th scope="row" width="15%">{{qnalist.QNA_NO}}</th>
            <td class="leftAlign line_limit_main" width="50%">{{qnalist.QNA_TITLE}}</td>
            <td width="15%">{{qnalist.USER_ID}}</td>
            <td width="15%">{{qnalist.QNA_DATE}}</td>
          </tr>
        </tbody>
        <!-- <tbody v-else>
          <tr>
            <td colspan="4">게시물이 존재하지 않습니다.</td>
          </tr>
        </tbody> -->
      </table>
      <router-link to="/qna" class="more">더보기 +</router-link>
    </div>
  </div>
  <div>{{test}}</div>
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
      qnaList: null,
      test: null
    }
  },
  components: {
  },
  mounted () {
    this.axios.get('api/mainNoticeList').then(res => {
      console.log(res.data)
      this.noticeList = res.data
    }).catch(err => {
      console.log(err)
    })
    this.axios.get('api/mainQnaList').then(res => {
      this.qnaList = res.data
      // res.data.lenth
      for (let i = 0; i < res.data.lenth; i++) {
        this.test += res.data[i].QNA_TITLE
      }
    }).catch(err => {
      console.log(err)
    })
  },
  methods: {
    goTranport () {
      console.log(this.$store.state.loginCheck)
      if (this.$store.state.loginCheck == null) {
        alert('로그인후 가능합니다')
        router.push('/login')
      } else {
        router.push('/transport')
      }
    },
    noticeDetail (nno) {
      this.axios.get('api/noticeDetail?nno=' + nno).then(res => {
        this.$store.state.noticeDetail = res.data
        console.log(res.data)
        router.push('/noticeDetail')
      }).catch(err => {
        console.log(err)
      })
    },
    qnaDetail (qno) {
      this.axios.get('api/qnaDetail?qno=' + qno).then(res => {
        this.$store.state.qnaDetail = res.data
        console.log(res.data)
        router.push('/qnaDetail')
      }).catch(err => {
        console.log(err)
      })
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
  /* background-color: rgb(0, 137, 188);*/
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
      width:240px;
      overflow:hidden;
      text-overflow:ellipsis;
      white-space:nowrap;
      display:inline-block;
  }
</style>
