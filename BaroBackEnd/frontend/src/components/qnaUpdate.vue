<template>
    <div class="wrap">
      <form id="form" method="post" enctype="multipart/form-data">
        <h2>문의 수정</h2><hr><br>
        <div style="width: 1200px;" class="boardCreateWrap">
        <input type="hidden" v-model="user_id" name="user_id">
        <input type="hidden" v-model="user_no" name="user_no">
        <input type="hidden" v-model="qna_no" name="qna_no">
        <input type="hidden" v-model="fileName" name="c_file_name">
            <table class="table qnatable">
                <tr>
                    <th style="width: 15%; background:rgb(230, 230, 230);" >제목</th>
                    <td><input type="text" class="qnaCrateInput" name="qna_title" required v-model="this.qnaTitle"></td>
                </tr>
                <tr>
                    <th style="width: 15%; background:rgb(230, 230, 230);" >이미지 업로드</th>
                    <td><input multiple type="file" class="qnaCrateInput" id="qnaUpFile" @change="chengeFile"  accept="image/gif, image/jpeg, image/png" name="upfile"/></td>
                </tr>
                <tr>
                    <th style="width: 15%; background:rgb(230, 230, 230);" >내용</th>
                    <td>
                        <input type="hidden" v-model="this.fileName">
                        <img :src="require(`../../../../../../aaa/${fileName}`)" id="qnaImg" v-if="fileName != null " style="float:left"/>
                      <textarea name="qna_content" id="" cols="30" rows="10" maxlength="500" class="qnaCrateInput qnaCreateTextarea" v-model="this.qnaContent" required></textarea>
                    </td>
                </tr>
            </table>
        </div>
        <br>
        <button class="createBtn btn btn-dark" @click="updateQna()" type="button">수정</button>
        </form>
    </div>
</template>

<script>
import router from '../router'
import axios from 'axios'
export default {
  data () {
    return {
      fileName: null,
      qnaTitle: this.$store.state.qnaDetail[0].QNA_TITLE,
      qnaContent: this.$store.state.qnaDetail[0].QNA_CONTENT,
      user_id: this.$store.state.userInfo[0].USER_ID,
      user_no: this.$store.state.userInfo[0].USER_NO,
      qna_no: this.$store.state.qnaDetail[0].QNA_NO
    }
  },
  mounted () {
    if (this.$store.state.loginCheck === 'N') {
      alert('로그인후 이용 바랍니다')
      router.push('/login')
    }
    axios({
      method: 'Get',
      url: 'api/fileUpload?upFile=' + this.$store.state.qnaDetail[0].C_FILE_NAME
    }).then(data => {
      console.log(data.data)
      if (data.data === 1) {
        this.fileName = this.$store.state.qnaDetail[0].C_FILE_NAME
      } else {
        this.fileName = null
      }
    }).catch(err => {
      console.log(err)
    })
  },
  methods: {
    updateQna () {
      const fd = new FormData(document.getElementById('form'))
      const qTitle = this.qnaTitle
      const qContent = this.qnaContent
      const regExp = /^[^<>&()]+$/
      fd.append('upfile', this.upfile)
      if (this.qnaTitle == null || this.qnaTitle === '') {
        alert('제목을 작성해주세요')
      } else if (this.qnaContent === null || this.qnaContent === '') {
        alert('내용을 작성해주세요')
      } else if (!regExp.test(qTitle)) {
        alert('제목에 < > & ( ) 는 사용할 수 없습니다')
      } else if (!regExp.test(qContent)) {
        alert('내용에 < > & ( ) 는 사용할 수 없습니다')
      } else {
        axios.post('api/updateQna', fd).then(res => {
          if (res.data === 0) {
            alert('일시적인 오류입니다 다시 시도해주세요')
            router.push('/qna')
          } else if (res.data === 9) {
            alert('올바른 이미지 첨부파일이 아닙니다.')
          } else {
            alert('수정 성공!')
            router.push('/qna')
          }
        }).catch(err => {
          console.log(err)
        })
      }
    }
  }
}
</script>

<style>
    .wrap{
        width: 1200px;
        margin: auto;
    }
    .createBtn{
        float: right;
        width: 100px;
        height: 50px;
        font-size: 25px;
    }
    .qnaCrateInput{
        width: 100%;
        border: none;
    }
    th p{
        margin-top: 100%;
    }
    .qnaCreateTextarea{
        font-size: 20px;
        resize: none;
        height: 400px;
    }
     .qnaCreateTextarea:focus{
        outline: none;
     }
    .qnatable tr{
        height: 30px;
    }
    .qnatable {
        border: black;
        margin-bottom: 0;

    }
    .boardCreateWrap{
        border: 1px solid black;
    }
</style>
