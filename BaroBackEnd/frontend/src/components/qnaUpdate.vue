<template>
    <div class="wrap">
    <form id="form" method="post" enctype="multipart/form-data">
        <h2>문의 작성</h2><hr><br>
        <div style="width: 1200px;" class="boardCreateWrap">
        <input type="hidden" v-model="user_no" name="user_no">
              <table class="table qnatable">
                  <tr>
                      <th style="width: 15%; background:rgb(230, 230, 230);" >제목</th>
                      <td><input type="text" class="qnaCrateInput" name="qna_title" required v-model="this.$store.state.qnaDetail[0].QNA_TITLE"></td>
                  </tr>
                  <tr>
                      <th style="width: 15%; background:rgb(230, 230, 230);" >내용</th>
                      <td>
                        <img src="" alt="">
                        <textarea name="qna_content" id="" cols="30" rows="10" maxlength="500" class="qnaCrateInput qnaCreateTextarea" v-model="this.$store.state.qnaDetail[0].QNA_CONTENT" required></textarea>
                      </td>
                  </tr>
              </table>
        </div>
        <br>
        <button class="createBtn btn btn-dark" @click="updateQna()" type="button">작성</button>
        </form>
    </div>
</template>

<script>
import router from '../router'
import axios from 'axios'
export default {
  data () {
    return {

    }
  },
  mounted () {
    if (this.$store.state.loginCheck == null) {
      alert('로그인후 이용 바랍니다')
      router.push('/login')
    }
  },
  methods: {
    updateQna () {
      if (this.$store.state.qnaDetail[0].QNA_TITLE == null || this.$store.state.qnaDetail[0].QNA_TITLE === '') {
        alert('제목을 작성해주세요')
      } else if (this.$store.state.qnaDetail[0].QNA_CONTENT === null || this.$store.state.qnaDetail[0].QNA_CONTENT === '') {
        alert('내용을 작성해주세요')
      } else {
        axios.post('api/updateQna').then(res => {
          console.log(res.data)
          if (res.data === 0) {
            alert('일시적인 오류입니다 다시 시도해주세요')
            router.push('/qnaUpdate')
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
