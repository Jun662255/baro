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
                <img :src="imageSrc" id="qnaImg"/>
                <!-- <img :src="require(`../../../../../../aaa/${fileName}`)" id="qnaImg"/> -->
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
        <h3 v-if="$store.state.qnaDetail[0].COMMENT != null">답변</h3>
        <div class="commentDiv" v-if="$store.state.qnaDetail[0].COMMENT != null">
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
      userID: this.$store.state.userInfo[0].USER_ID,
      fileName: this.$store.state.qnaDetail[0].C_FILE_NAME
    }
  },
  computed: {
    imageSrc () {
      try {
        return require(`../../../../../../aaa/${this.fileName}`)
      } catch (error) {
        // 이미지 파일이 없는 경우 처리
        console.log(error)
        return require('../../../../../../aaa/noImg.png')
      }
    }
  },
  mounted () {
    this.fileImg = this.fileImg + this.$store.state.qnaDetail[0].C_FILE_NAME
    if (this.$store.state.loginCheck === 'N') {
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
      console.log(this.fileName)
      axios({
        method: 'get',
        url: 'api/qnaDelete?qno=' + qno + '&c_file_name=' + this.fileName
      }).then(data => {
        if (data.data === 1) {
          alert('삭제성공')
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
