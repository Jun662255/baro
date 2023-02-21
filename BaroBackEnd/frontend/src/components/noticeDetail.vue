<template>
    <div class="wrap">
        <h2>공지 상세</h2><hr><br>
        <div class="boardDetailWrap">
            <h2>{{$store.state.noticeDetail[0].NOTICE_TITLE}}</h2>
            <div class="boardInfo">
                {{$store.state.noticeDetail[0].NOTICE_WRITER}} &nbsp;/&nbsp;{{$store.state.noticeDetail[0].NOTICE_DATE}}
            </div>
            <hr>
            <br>
            <div class="boardDetilContent">
                <p>{{$store.state.noticeDetail[0].NOTICE_CONTENT}}</p>
            </div>
            <div class="asd">
            <button class="btnBackDiv btn btn-dark" @click="noticeList()"> 공지목록</button>
            </div>
        </div>
    </div>
</template>

<script>
import router from '../router'
export default {
  methods: {
    noticeList () {
      router.push('/notice')
    }
  }
}
</script>

<style>
    .wrap{
        width: 1200px;
        margin: auto;
    }
    .boardDetailWrap{
        width: 1200px;
        margin:auto;
        border: 1px solid black;
        padding: 30px;
    }
    .boardTitle , .boardContent{
        width: 99%;
        margin-bottom: 15px;
    }
    .boardTitle{
        font-size: 20px;
    }
    .boardDetilContent{
        min-height: 400px;
        padding: 5px;
        word-wrap: break-word;
        white-space: pre-line;
    }
    .boardInfo{
        width: 200px;
        font-size: 13px;
        white-space: nowrap;
    }
    .btnBackDiv{
        margin: auto;
        display: block;
        margin-top: 10px;
    }
</style>
