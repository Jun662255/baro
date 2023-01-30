<template>
  <div>
        <tr>
      <th>아이디</th>
      <td>
        <input v-model="signup.id" type="text" maxlength="20" @blur="idValid">
        <div v-if="!idValid">
          유효하지 않은 아이디 입니다.
        </div>
      </td>
    </tr>
        <tr>
      <th>비밀번호</th>
      <td>
        <input v-model="signup.password" type="text" maxlength="10" @blur="passwordValid">
        <div v-if="!passwordValidFlag">
          유효하지 않은 비밀번호 입니다.
        </div>
      </td>
    </tr>
       <tr>
      <th>비밀번호 확인</th>
      <td>
        <input v-model="passwordCheck" type="text" maxlength="10" @blur="passwordCheckValid">
        <div v-if="!passwordCheckFlag">
          비밀번호가 동일하지 않습니다.
        </div>
      </td>
    </tr>
    <tr>
      <th>아이디</th>
      <input type="text" @keyup="idFales()" id="idInput">
      <div id="idF"></div>
    </tr>
  </div>

</template>

<script>

export default {

  name: 'App',
  components: {
  },
  data () {
    return {
      signup: {
        id: null,
        password: null,
        pwhint: '',
        pwhintans: null
      },
      passwordValidFlag: true
    }
  },
  methods: {
    idValid () {
      return /^[A-Za-z0-9]+$/.test(this.signup.id)
    },
    passwordValid () {
      if (/^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9]).{6,10}$/.test(this.signup.password)) {
        this.passwordValidFlag = true
      } else {
        this.passwordValidFlag = false
      }
    },
    passwordCheckValid () {
      if (this.signup.password === this.passwordCheck) {
        this.passwordCheckFlag = true
      } else {
        this.passwordCheckFlag = false
      }
    },

    idFales () {
      var idInput1 = document.getElementById('idInput').value
      var regExpId = /^(?=.*[a-z])(?=.*[0-9])[a-z0-9]{4,8}$/
      if (!regExpId.test(idInput1)) {
        console.log('asd')
      }
    }

  }
}

</script>

<style>

</style>
