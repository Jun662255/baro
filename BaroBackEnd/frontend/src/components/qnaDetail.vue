<template>
    <div class="wrap">
        <h2>문의 상세</h2><hr><br>
        <div class="boardDetailWrap">
            <h2> {{$store.state.qnaDetail[0].QNA_TITLE}}</h2>
            <div class="updateBtn" v-if="userID == this.$store.state.qnaDetail[0].USER_ID">
            <button  @click="qnaDelete()" >삭제하기</button>
            <button  @click="qnaUpdate()" >수정하기</button>
            </div>
            <div class="boardInfo">
                {{$store.state.qnaDetail[0].USER_ID}} &nbsp;/&nbsp;{{$store.state.qnaDetail[0].QNA_DATE}}
            </div>
            <hr>
            <div class="fileDown"  v-if="fileName != null ">
                <img :src="require(`../../../../../../aaa/${fileName}`)" id="qnaImg"/>
            </div>
            <div v-else>
            </div>
            <div class="createDate">
            </div><br>
            <div class="boardDetilContent">
                {{$store.state.qnaDetail[0].QNA_CONTENT}}
            </div>
            <div class="asd">
            <button class="btnBackDiv btn btn-dark" @click="getQnaList()"> 문의목록</button>
            </div>
        </div>
        <br><br>
        <div class="commentDiv" v-if="$store.state.qnaDetail[0].COMMENT != null">
            답변 <br>
            {{$store.state.qnaDetail[0].COMMENT}}
        </div>
    </div>
</template>

<script>
import router from '../router'
import axios from 'axios'
export default {
  data () {
    return {
      fileImg: '../../../../../../aaa/',
      userID: localStorage.getItem('user_id'),
      test: '../../../../../../aaa/20230209130156_1_pepe.jpg',
      fileName: this.$store.state.qnaDetail[0].C_FILE_NAME
    }
  },
  mounted () {
    // console.log(this.fileName + '"asdasasdasdd"')
    console.log(this.fileName + '"asdasasdasdd"')
    console.log('asdasasdasdd')
    console.log('asdasasdasdd')
    console.log('asdasasdasdd')
    console.log('asdasasdasdd')
    this.fileImg = this.fileImg + this.$store.state.qnaDetail[0].C_FILE_NAME
    if (this.$store.state.loginCheck == null) {
      alert('로그인후 이용 바랍니다')
      router.push('/login')
    }
  },
  methods: {
    getQnaList () {
      router.push('/qna')
    },
    qnaUpdate () {
      router.push('/qnaUpdate')
    },
    qnaDelete () {
      const qno = this.$store.state.qnaDetail[0].QNA_NO
      axios({
        method: 'get',
        url: 'api/qnaDelete?qno=' + qno
      }).then(data => {
        if (data.data === 1) {
          router.push('/qna')
        } else {
          alert('일시적인 오류입니다 다시 시도해주세요')
        }
      }).catch(err => {
        console.log(err)
      })
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
    .commentDiv{
        border: 1px solid black;
        padding: 30px;
    }
    .updateBtn button{
        float: right;
        border: none;
        background: none;
    }
    #qnaImg{
        max-width: 70%;
        height: auto;
    }
</style>
