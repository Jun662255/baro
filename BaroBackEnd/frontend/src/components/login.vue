<template>
  <div class="mainWrap">
    <div id="loginWrap">
      <p style="fontSize:30px;" class="formName">Login</p>
      <div>
        <div id="loginFormDiv">
          <form action="" id="loginForm">
            <div class="loginInputDiv">
              <input type="text" class="loginInput"  placeholder="ID">
            </div>
            <div class="loginInputDiv">
              <input type="text" class="loginInput"  placeholder="PASSWORD" >
            </div>
            <br>
            <div>
              <button id="loginBtn">Login</button>
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

export default {
  name: 'App',
  components: {
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
  height: 40px;
  font-size: 20px;
}

</style>
