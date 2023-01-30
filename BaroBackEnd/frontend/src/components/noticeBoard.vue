<template>
    <div class="boardWrap">
        <h2>&nbsp;&nbsp;공지 게시판</h2><hr>
        <br>
        <div class="contentWrap">
            <table class="table">
                <thead>
                    <tr>
                        <th style="width: 10%;">번호</th>
                        <th>제목</th>
                        <th style="width: 20%;">작성자</th>
                        <th style="width: 20%;">작성일</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>1</td>
                        <td>제목</td>
                        <td>admin</td>
                        <td>22.22.22</td>
                    </tr>
                </tbody>
            </table>
            <div class="pageWrap">
                <button class="btn btn-dark paging">&lt;</button>
                <button class="btn btn-dark paging">1</button>
                <button class="btn btn-dark paging">&gt;</button>
            </div>
        </div>
        <button @click="test1()" style="white:200px; height:200px;">test11</button>
        <button @click="test2()" style="white:200px; height:200px;">test22</button>
    </div>

</template>

<script>
import axios from 'axios'

export default {
  data () {
    return {
      contents: null
    }
  },
  mounted () {
  },
  methods: {
    test2 () {
      axios.get('api/noticeCount').then(res => {
        console.log(res.data)
      }).catch(err => {
        console.log(err)
      })
    },
    test1 () {
      axios.get('api/noticeList').then(res => {
        console.log(res.data)
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
        width: 80px;
        height: 30px;
        margin-left: 90%;

    }
    .crateWrap button{
        width: 100%;
        height: 100%;
    }
</style>
