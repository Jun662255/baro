<template>
  <div class="mainWrap">
    <div id="singUpWrap">
      <p class="formName">회원가입</p>
      <form action="">
        <div id="singUpForm">
          <div id="singUpInputDiv">
            <div style="float:left;">
              <p class="p" id="idP">아이디</p>
              <input type="text" class="singUpInput1" placeholder="영문, 숫자조합 4-10자" id="idInput" @keyup="idCheck()">
            </div>
            <div style="float:right;"><br>
              <button id="idCheckBtn">중복확인</button>
            </div>
          </div>
          <br><br><br>
          <div class="singUpInputDiv">
            <p class="p" id="pwdP1">비밀번호</p>
            <input type="text" class="singUpInput1" placeholder="영문, 숫자조합 6-10자"  id="pwdInput1" @keyup="pwdCheck1()">
          </div><br>
          <div class="singUpInputDiv">
            <p class="p" id="pwdP2">비밀번호 확인</p>
            <input type="text" class="singUpInput1" placeholder="영문, 숫자조합 6-10자"  id="pwdInput2" @keyup="pwdCheck2()">
          </div><br>
          <div class="singUpInputDiv">
            <p class="p" id="nameP">이름</p>
            <input type="text" class="singUpInput1" placeholder="한글 5글자 이하"  id="nameInput" @keyup="nameCheck()">
          </div><br>
          <div class="singUpInputDiv">
            <p class="p" id="phoneP">전화번호</p>
            <input type="text" class="singUpInput1" placeholder="숫자만 입력"  id="phoneInput" @keyup="phoneCheck()">
          </div>
          <br><br>
           <button type="submit" id="singUpBtn" @click="singUp()"> 회원가입</button>
        </div>
      </form>
    </div>
  </div>
</template>

<script>

export default {
  name: 'App',
  components: {
  },
  methods: {
    idCheck () {
      var idInput1 = document.getElementById('idInput').value
      var regExpId = /^(?=.*[a-z])(?=.*[0-9])[a-z0-9]{4,10}$/
      var idP1 = document.getElementById('idP')
      if (!regExpId.test(idInput1)) {
        idP1.innerHTML = '  <p class="p" id="idP" style="color:red">아이디</p>'
      } else {
        idP1.innerHTML = '  <p class="p" id="idP">아이디</p>'
      }
    },
    pwdCheck1 () {
      var pwdInput1 = document.getElementById('pwdInput1').value
      var regExpPwd = /^(?=.*[a-z])(?=.*[0-9])[a-z0-9]{6,10}$/
      var pwdP11 = document.getElementById('pwdP1')
      if (!regExpPwd.test(pwdInput1)) {
        pwdP11.innerHTML = '  <p class="p" id="idP" style="color:red">비밀번호</p>'
      } else {
        pwdP11.innerHTML = '  <p class="p" id="idP">비밀번호</p>'
      }
    },
    pwdCheck2 () {
      var pwdInput1 = document.getElementById('pwdInput1').value
      var pwdInput2 = document.getElementById('pwdInput2').value
      var pwdP12 = document.getElementById('pwdP2')
      if (pwdInput1 !== pwdInput2) {
        pwdP12.innerHTML = '  <p class="p" id="idP" style="color:red">비밀번호 확인</p>'
      } else {
        pwdP12.innerHTML = '  <p class="p" id="idP">비밀번호 확인</p>'
      }
    },
    nameCheck () {
      var nameInput1 = document.getElementById('nameInput').value
      var regExpName = /^[가-힣]{2,5}$/
      var nameP1 = document.getElementById('nameP')
      if (!regExpName.test(nameInput1)) {
        nameP1.innerHTML = '  <p class="p" id="idP" style="color:red">이름</p>'
      } else {
        nameP1.innerHTML = '  <p class="p" id="idP">이름</p>'
      }
    },
    phoneCheck () {
      var phoneInput1 = document.getElementById('phoneInput').value
      var regExpPhone = /^[\d]{11}$/
      var phoneP1 = document.getElementById('phoneP')
      if (!regExpPhone.test(phoneInput1)) {
        phoneP1.innerHTML = '  <p class="p" id="idP" style="color:red">전화번호</p>'
      } else {
        phoneP1.innerHTML = '  <p class="p" id="idP">전화번호</p>'
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
  width: 80px;
  height: 30px;
}
input:focus {outline:none;}

#singUpBtn{
  width: 300px;
  height: 40px;
  font-size: 20px;
  margin: auto;

}

</style>
