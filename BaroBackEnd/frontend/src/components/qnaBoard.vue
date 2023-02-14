<template>
    <div class="boardWrap">
        <h2>&nbsp;&nbsp;문의 게시판</h2><hr>
        <br>
        <div class="contentWrap">
          <div>
            <div style="float:right; margin-right:1%">
                <input type="text" id="serch" v-model="serchValue" placeholder="제목으로 검색하세요" @keyup.enter="getQnaList(1, this.serchValue)">
                <button @click="getQnaList(1, this.serchValue)" class="btn btn-dark">검색</button>
            </div>
          </div>
          <br>
          <div style="height:500px;">
            <table class="table">
                <thead>
                    <tr class="tabelHead">
                        <th style="width: 10%; border-left: none">번호</th>
                        <th style="width: 60%;">제목</th>
                        <th style="width: 10%;">작성자</th>
                        <th style="width: 10%;">답변</th>
                        <th style="width: 10%;">작성일</th>
                    </tr>
                </thead>
                <tbody v-if="this.pi.listCount !== 0">
                    <tr v-for="qnaList in qnaList" v-bind:key="qnaList.QNA_NO" @click="qnaDetail(qnaList.QNA_NO)">
                        <td>{{qnaList.QNA_NO}}</td>
                        <td class="leftAlign line_limit">{{qnaList.QNA_TITLE}}</td>
                        <td>{{qnaList.USER_ID}}</td>
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
            </table>
          </div>
          <div class="pageWrap" v-if="this.pi.listCount != 0">
              <div v-if="this.pi.currentPage != 1">
                <button class="btn btn-dark paging" @click="previousPage()">&lt;</button>
              </div>
              <div id="pagingDiv" v-for="(item, pageLimit) in range(this.pi.startPage, this.pi.endPage)" :key="pageLimit">
                <button class="btn btn-dark paging" @click="getQnaList(item, this.serchValue)">{{item}}</button>
              </div>
              <div v-if="this.pi.currentPage != this.pi.maxPage " @click="nextPage()">
                <button class="btn btn-dark paging" >&gt;</button>
              </div>
          </div>
          <div class="crateWrap">
            <div v-if="this.$store.state.loginCheck == null"></div>
            <router-link to="/qnaCreate" class="btn btn-dark" v-else>작성</router-link>
          </div>
        </div>
    </div>

</template>

<script>
import router from '../router'
export default {
  data () {
    return {
      qnaList: null,
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
  components: {
  },
  mounted () {
    this.axios.get('api/qnaList?cPage=' + this.pi.currentPage).then(res => {
      this.qnaList = res.data.list
      this.pi = res.data.pi
      console.log(res.data.list)
      console.log(this.qnaList)
    }).catch(err => {
      console.log(err)
    })
  },
  methods: {
    previousPage () {
      this.pi.currentPage = this.pi.currentPage - 1
      this.getQnaList(this.pi.currentPage, this.serchValue)
    },
    nextPage () {
      this.pi.currentPage = this.pi.currentPage + 1
      this.getQnaList(this.pi.currentPage, this.serchValue)
    },
    getQnaList (cPage, serch) {
      if (serch === undefined) {
        serch = null
      }
      this.axios.get('api/qnaList?cPage=' + cPage + '&serch=' + serch)
        .then(res => {
          this.qnaList = res.data.list
          console.log(res.data.list)
          console.log(this.qnaList)
          this.pi = res.data.pi
        }).catch(err => {
          console.log(err)
        })
    },
    range: function (start, end) {
      return Array(end - start + 1).fill().map((_, idx) => start + idx)
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
    }
    .pageWrap{
        margin: auto;
        margin-top:30px;
    }
    .crateWrap{
        width: 100px;
        height: 40px;
        margin-left: 94%;
    }
    .crateWrap button{
        width: 100%;
        height: 100%;
    }
    .line_limit {
      width:710px;
      overflow:hidden;
      text-overflow:ellipsis;
      white-space:nowrap;
      display:inline-block;
  }
</style>
