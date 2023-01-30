<template>
  <div id="app">
  <nav>
    <div class="header">
      <div class="blank"></div>
        <div class="logoDiv" >
          <router-link to="/main">BARO</router-link>
        </div>
        <div class="navMenu">
          <div class="loginDiv"  v-if="false">
            <router-link to="/login" class=""> Login </router-link> &nbsp;
          </div>
          <div class="mynOut" >
            <div class="headerMy">
              <router-link to="/mypage">
                <img src="./assets/myP.png" alt="" id="myPImg">
              </router-link> &nbsp;
            </div>
            <div class="logout">
              <img src="./assets/logout.png" alt="" id="logoutImg">
            </div>
          </div>
        </div>
    </div>
  </nav>
    <router-view/>
    <br><br><br><br>
    <footer>
    <div class="footer">
    <p>Copyright © 2022 JUN All rights reserved.</p>
          <address>Contact webmaster for more information. 000-0000-0000</address>
    </div>
  </footer>
  </div>
</template>

<script>
export default {
  name: 'App'
}
</script>

<style>

.footer{
  text-align: center;;
  font-size: 10px;
  border-top: 1px solid black;
  width: 1200px;
  margin: auto;
}
.mainWrap{
 width: 1200px;
 margin: auto;
}
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

.boardWrap{
  width: 100%;
  height: 100%;
}

.boardTable{
  width: 100%;
  text-align: center;
  border: 1px solid black;
}

.pageBtn{
  width: 100%;
  margin: auto;
}
.thName{
  width: 400px;
}
a {
  text-decoration: none;
}

.formName{
  font-size: 30px;
  text-align: center;
}
.paging{
  margin-left: 3px;
  margin-right: 3px;
}
.contentWrap tbody tr:hover{
background-color:rgba(0, 0, 0, 0.1);
cursor: pointer;
}
</style>
