<template>
  <div class="boardWrap">
      <h2>&nbsp;&nbsp;공지 게시판</h2><hr>
      <br><br>
      <div class="contentWrap">
        <div>
          <div style="float:right">
            <input type="text" id="serch" v-model="serchValue" placeholder="제목으로 검색하세요" @keyup.enter="getnoticeList(1, this.serchValue)">
            <button @click="getnoticeList(1, this.serchValue)" class="btn btn-dark">검색</button>
          </div>
        </div>
      <div style="width:1200px; height:448px;">
        <table class="table">
          <thead>
            <tr>
              <th style="width: 10%;">번호</th>
              <th style="width: 60%;">제목</th>
              <th style="width: 10%;">작성자</th>
              <th style="width: 10%;">작성일</th>
            </tr>
          </thead>
          <tbody v-if="this.noticeList !== null">
            <tr v-for="noticelist in noticeList" v-bind:key="noticelist.NOTICE_NO" @click="detail(noticelist.NOTICE_NO)" >
              <td>{{noticelist.NOTICE_NO}}</td>
              <td class="leftAlign">{{noticelist.NOTICE_TITLE}}</td>
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
      <br><br><br><br>
      <div class="pageWrap" v-if="this.pi.listCount != 0">
        <div v-if="this.pi.currentPage != 1">
          <button class="btn btn-dark paging" @click="previousPage()">&lt;</button>
        </div>
        <div id="pagingDiv" v-for="(item, pageLimit) in range(this.pi.startPage, this.pi.endPage)" :key="pageLimit">
          <button class="btn btnPaging" :class="{'btn-dark': item != this.pi.currentPage, 'btn-secondary': item === this.pi.currentPage}"
            @click="getnoticeList(item, this.serchValue)">
            {{item}}
          </button>
        </div>
        <div v-if="this.pi.currentPage != this.pi.maxPage " @click="nextPage()">
          <button class="btn btn-dark paging" >&gt;</button>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import router from '../router'
export default {
  data () {
    return {
      noticeList: null,
      pi: {
        currentPage: 1,
        endPage: 0,
        maxPage: 0,
        pageLimit: 0,
        startPage: 0,
        listCount: 0
      },
      serchValue: null
    }
  },
  mounted () {
    this.axios.get('api/noticeList?cPage=' + this.pi.currentPage).then(res => {
      if (res.data.list.length === 0) {
        this.noticeList = null
      } else {
        this.noticeList = res.data.list
      }
      this.pi = res.data.pi
    }).catch(err => {
      console.log(err)
    })
  },
  methods: {
    detail (nno) {
      this.axios.get('api/noticeDetail?nno=' + nno).then(res => {
        this.$store.commit('setNoticeDetail', res.data)
        router.push('/noticeDetail')
      }).catch(err => {
        console.log(err)
      })
    },
    previousPage () {
      this.pi.currentPage = this.pi.currentPage - 1
      this.getnoticeList(this.pi.currentPage)
    },
    nextPage () {
      this.pi.currentPage = this.pi.currentPage + 1
      this.getnoticeList(this.pi.currentPage)
    },
    getnoticeList (cPage, serch) {
      if (serch === undefined) {
        serch = null
      }
      this.axios.get('api/noticeList?cPage=' + cPage + '&serch=' + serch)
        .then(res => {
          if (res.data.list.length === 0) {
            this.noticeList = null
          } else {
            this.noticeList = res.data.list
          }
          this.pi = res.data.pi
        }).catch(err => {
          console.log(err)
        })
    },
    range: function (start, end) {
      return Array(end - start + 1).fill().map((_, idx) => start + idx)
    }
  }
}
</script>

<style>
    table{
        text-align: center;
        width: 100%;
    }
    .boardWrap{
        width: 1200px;
        margin: auto;
    }
    .contentWrap{
        display: flex;
        flex-direction: column;
        width: 1200px;
        margin: auto;
    }
    .pageWrap{
        margin: auto;
        margin-top:30px;
        display: flex;
        flex-direction: row;
    }

</style>
