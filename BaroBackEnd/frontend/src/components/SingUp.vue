<template>
  <div class="mainWrap">
  <br><br><br><br>
    <div id="singUpWrap">
      <p class="formName">회원가입</p>
      <form action="">
        <div id="singUpForm">
          <div id="singUpInputDiv">
            <div style="float:left;">
              <p class="p" id="idP">아이디</p>
              <input type="text" class="singUpInput1" placeholder="영문, 숫자조합 4-10자" id="idInput"  @change="idCheck()" v-model="id">
            </div>
            <div style="float:right;"><br>
              <button disabled id="idCheckBtn" class="btn btn-dark" @click="duplicateCheck()" type="button">중복확인</button>
            </div>
          </div>
          <br><br><br>
          <div class="singUpInputDiv">
            <p class="p" id="pwdP1">비밀번호</p>
            <input type="password" class="singUpInput1" placeholder="영문, 숫자조합 6-10자"  id="pwdInput1" @change="pwdCheck1()" v-model="pwd">
          </div><br>
          <div class="singUpInputDiv">
            <p class="p" id="pwdP2">비밀번호 확인</p>
            <input type="password" class="singUpInput1" placeholder="영문, 숫자조합 6-10자"  id="pwdInput2" @change="pwdCheck2()" v-model="pwdCheck">
          </div><br>
          <div class="singUpInputDiv">
            <p class="p" id="nameP">이름</p>
            <input type="text" class="singUpInput1" placeholder="한글 5글자 이하"  id="nameInput" @change="nameCheck()" v-model="name">
          </div><br>
          <div class="singUpInputDiv">
            <p class="p" id="phoneP">전화번호</p>
            <input type="text" class="singUpInput1" placeholder="숫자만 입력"  id="phoneInput" @change="phoneCheck()" v-model="phone">
          </div>
          <br><br>
           <button type="button" id="singUpBtn" class="btn btn-dark" @click="singUp()" disabled> 회원가입</button>
           <!-- <button type="button" id="singUpBtn" class="btn btn-dark" @click="singUp()"> 회원가입</button> -->
           <!-- <button type="button" @click="a3()">확인</button> -->
        </div>
      </form>
    </div>
  </div>
</template>

<script>
import axios from 'axios'
import router from '../router'
export default {
  name: 'App',
  data () {
    return {
      id: null,
      pwd: null,
      pwdCheck: null,
      name: null,
      phone: null,
      idC: 'N',
      duplicateC: 'N',
      pwdC: 'N',
      pwdCC: 'N',
      nameC: 'N',
      phoneC: 'N'

    }
  },
  components: {
  },
  methods: {
    singUpBtn () {
      var singUpBtn = document.getElementById('singUpBtn')
      if (this.idC === 'Y' && this.duplicateC === 'Y' && this.pwdC === 'Y' &&
      this.pwdCC === 'Y' && this.nameC === 'Y' && this.phoneC === 'Y') {
        singUpBtn.disabled = false
      } else {
        singUpBtn.disabled = true
      }
    },
    singUp () {
      axios({
        method: 'post',
        url: '/api/singUp',
        data: {
          user_id: this.id,
          user_pwd: this.pwd,
          user_name: this.name,
          phone: this.phone
        }
      }).then(data => {
        if (data.data === 1) {
          alert('회원가입에 성공하셨습니다')
          router.push('/login')
        } else {
          alert('다시 시도해주세요')
        }
      }).catch(err => {
        console.log(err)
      })
    },
    duplicateCheck () {
      var idCheckBtn = document.getElementById('idCheckBtn')
      axios({
        method: 'post',
        url: 'api/duplicateCheck',
        data: {
          user_id: this.id
        }
      }).then(data => {
        if (data.data === 0) {
          alert('사용가능한 아이디 입니다')
          this.duplicateC = 'Y'
          idCheckBtn.disabled = true
          this.singUpBtn()
        } else {
          alert('중복된 아이디 입니다')
          this.duplicateC = 'N'
          idCheckBtn.disabled = false
          this.singUpBtn()
        }
      }).catch(err => {
        console.log(err)
      })
    },
    idCheck () {
      var idInput1 = document.getElementById('idInput').value
      var regExpId = /^(?=.*[a-zA-Z])(?=.*[0-9])[a-zA-Z0-9]{4,10}$/
      var idP1 = document.getElementById('idP')
      var idCheckBtn = document.getElementById('idCheckBtn')
      var singUpBtn = document.getElementById('singUpBtn')
      singUpBtn.disabled = true
      if (!regExpId.test(idInput1)) {
        idP1.innerHTML = '  <p class="p" id="idP" style="color:red">아이디</p>'
        this.idC = 'N'
        idCheckBtn.disabled = true
      } else {
        idP1.innerHTML = '  <p class="p" id="idP">아이디</p>'
        this.idC = 'Y'
        idCheckBtn.disabled = false
      }
    },
    pwdCheck1 () {
      var pwdInput1 = document.getElementById('pwdInput1').value
      var regExpPwd = /^(?=.*[a-zA-Z])(?=.*[0-9])[a-zA-Z0-9]{6,10}$/
      var pwdP11 = document.getElementById('pwdP1')
      if (!regExpPwd.test(pwdInput1)) {
        pwdP11.innerHTML = '  <p class="p" id="idP" style="color:red">비밀번호</p>'
        this.pwdC = 'N'
        this.singUpBtn()
        this.pwdCheck2()
      } else {
        pwdP11.innerHTML = '  <p class="p" id="idP">비밀번호</p>'
        this.pwdC = 'Y'
        this.singUpBtn()
        this.pwdCheck2()
      }
    },
    pwdCheck2 () {
      var pwdInput1 = document.getElementById('pwdInput1').value
      var pwdInput2 = document.getElementById('pwdInput2').value
      var pwdP12 = document.getElementById('pwdP2')
      if (pwdInput1 !== pwdInput2) {
        pwdP12.innerHTML = '  <p class="p" id="idP" style="color:red">비밀번호 확인</p>'
        this.pwdCC = 'N'
        this.singUpBtn()
      } else {
        pwdP12.innerHTML = '  <p class="p" id="idP">비밀번호 확인</p>'
        this.pwdCC = 'Y'
        this.singUpBtn()
      }
    },
    nameCheck () {
      var nameInput1 = document.getElementById('nameInput').value
      var regExpName = /^[가-힣]{2,5}$/
      var nameP1 = document.getElementById('nameP')
      if (!regExpName.test(nameInput1)) {
        nameP1.innerHTML = '  <p class="p" id="idP" style="color:red">이름</p>'
        this.nameC = 'N'
        this.singUpBtn()
      } else {
        nameP1.innerHTML = '  <p class="p" id="idP">이름</p>'
        this.nameC = 'Y'
        this.singUpBtn()
      }
    },
    phoneCheck () {
      var phoneInput1 = document.getElementById('phoneInput').value
      var regExpPhone = /^[\d]{11}$/
      var phoneP1 = document.getElementById('phoneP')
      if (!regExpPhone.test(phoneInput1)) {
        phoneP1.innerHTML = '  <p class="p" id="idP" style="color:red">전화번호</p>'
        this.phoneC = 'N'
        this.singUpBtn()
      } else {
        phoneP1.innerHTML = '  <p class="p" id="idP">전화번호</p>'
        this.phoneC = 'Y'
        this.singUpBtn()
      }
    }
  }
}
</script>

<style>
#singUpWrap{
  width: 600px;
  margin: auto;
  border: solid black 1px;
  padding: 30px;
}

#singUpForm{
width: 400px;
margin: auto;
margin-left: 120px;
height: 450px;
}
.singUpInputDiv{
  width: 300px;
  height: 50px;
}
.p{
  margin-bottom: 5px;
}
.singUpInput1{
  width: 300px;
  height: 60%;
  border: none;
  border-bottom: 2px solid black;
  font-size: 20px;
}
#idCheckBtn{
  width: 92px;
  height: 40px;
}
input:focus {outline:none;}

#singUpBtn{
  width: 300px;
  height: 40px;
  font-size: 20px;
  margin: auto;

}

</style>
