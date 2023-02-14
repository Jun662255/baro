<template>
  <div class="mainWrap">
  <br>  <br>  <br>  <br>  <br>
    <div id="loginWrap">
      <p style="fontSize:30px;" class="formName">로그인</p>
      <div>
        <div id="loginFormDiv">
          <form action="" id="loginForm">
            <div class="loginInputDiv">
              <input type="text" class="loginInput"  placeholder="ID" required v-model="id" @keyup.enter="login()">
            </div>
            <div class="loginInputDiv">
              <input type="password" class="loginInput"  placeholder="PASSWORD" required v-model="pwd" @keyup.enter="login()">
            </div>
            <br>
            <div>
              <button type="button" id="loginBtn" class="btn btn-dark" @click="login()">Login</button>
            </div>
          </form>
        </div>
        <br><br>
      </div>
        <router-link to="/SingUp" class="loginSingUp">회원가입</router-link>
    </div>
  </div>
</template>

<script>
import axios from 'axios'
// import router from '../router'
export default {
  name: 'App',
  data () {
    return {
      id: null,
      pwd: null,
      USER_NO: null
      // ,
      // phone: null,
      // user_name: null
    }
  },
  components: {
  },
  methods: {
    login () {
      if (this.id === null) {
        alert('아이디를 입력해주세요')
      } else if (this.pwd === null) {
        alert('비밀번호를 입력해주세요')
      } else {
        axios({
          method: 'post',
          url: 'api/login',
          data: {
            user_id: this.id,
            user_pwd: this.pwd
          }
        }).then(data => {
          console.log([0].USER_ID)
          if (data.data.length !== 0) {
            console.log(data.data)
            localStorage.setItem('user_no', data.data[0].USER_NO)
            localStorage.setItem('phone', data.data[0].PHONE)
            localStorage.setItem('user_name', data.data[0].USER_NAME)
            localStorage.setItem('user_id', data.data[0].USER_ID)
            localStorage.setItem('loginCheck', 'Y')
            // this.$store.state.loginCheck = 'Y'
            location.replace('/main')
          } else {
            alert('올바르지않은 아이디, 비밀번호입니다')
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
#loginWrap{
  width: 600px;
  margin: auto;
  border: solid black 1px;
  padding: 30px;
}
.loginSingUp{
  float: right;
  margin-right: 44%;
}
.loginSingUp:hover{
  color: gray;
}
#loginFormDiv{
width: 300px;
margin: auto;
}
.loginInputDiv{
  width: 300px;
  height: 50px;
}
.loginInput{
  width: 100%;
  height: 70%;
  border: none;
  border-bottom: 2px solid black;
  font-size: 20px;
}
input:focus {outline:none;}
#loginBtn{
  width: 300px;
  height: 48px;
  font-size: 20px;
}

</style>
