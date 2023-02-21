<template>
  <div>
    <nav>
        <div class="header">
          <div class="blank"></div>
            <div class="logoDiv" >
              <router-link to="/main" >BARO</router-link>
            </div>
            <div class="navMenu">
              <div class="loginDiv"  v-if="this.$store.state.loginCheck === 'N'">
                <router-link to="/login"> Login </router-link> &nbsp;
              </div>
              <div class="mynOut" v-else>
                <div class="headerMy">
                  <router-link to="/mypage">
                    <img src="../assets/myP.png" id="myPImg">
                  </router-link> &nbsp;
                </div>
                <div class="logout" @click="logout()">
                  <img src="../assets/logout.png" id="logoutImg">
                </div>
              </div>
            </div>
        </div>
    </nav>
  </div>
</template>

<script>
import router from '../router'
export default {
  name: 'App',
  data () {
    return {
      loginCheck: 'N'
    }
  },
  components: {
  },
  methods: {
    logout () {
      this.$store.commit('setLogOut', null)
      router.push('/main')
    }
  },
  mounted () {
  }
}
</script>

<style>
.header{
  width: 100%;
  height: 50px;
  display: flex;
  flex-direction: row;
  margin: auto;
  background: black;
}
.header a{
  color: white;
}
.navMenu{
  float: right;
  margin-right: 30px;
  width: 100px;
  font-size: 20px;
  text-align: center;
  height: 40px;
}
.loginDiv{
  margin-top: 7px;
}
.logoDiv{
  font-size: 30px;
  margin: auto;
  width: 200px;
  height: 100%;
  margin-left: 43%;
  text-align: center;
}
.logoDiv:hover{
cursor: pointer;
}
.mynOut{
 display: flex;
 flex-direction: row;
}
#myPImg{
  width: 50px;
  height: 50px;
}
#logoutImg{
  margin-top: 8px;
   width: 35px;
  height: 35px;
}
.logout{
  cursor: pointer;
}
</style>
