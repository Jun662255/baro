<template>
<div>
<router-link to="/transport">
  <div id="imgWrap">
    <div id="imgDiv">
      <img src="../assets/banner.png" alt="" id="mainImg">
    </div>
    <div id="imgDivText">
      <p>BARO 배송신청</p>
    </div>
  </div>
  </router-link>
  <div class="mainWrap">
  <br>
  <br>
  <div id="boardWrap">
    <div id="mainNotice">
      <div class="mainBoardTitle">
        <h3 class="boardName">공지</h3>
      </div>

      <table class="table">
        <thead>
          <tr>
            <th>번호</th>
            <th>제목</th>
            <th>작성자</th>
            <th>작성일</th>
          </tr>
        </thead>
        <tbody>
          <tr>
            <th scope="row">1</th>
            <td>제목ㄴㄴ</td>
            <td>작성자ㄴㄴ</td>
            <td>111111</td>
          </tr>
          <tr>
            <th scope="row">1</th>
            <td>제목ㄴㄴ</td>
            <td>작성자ㄴㄴ</td>
            <td>111111</td>
          </tr>
          <tr>
            <th scope="row">1</th>
            <td>제목ㄴㄴ</td>
            <td>작성자ㄴㄴ</td>
            <td>111111</td>
          </tr>
        </tbody>
      </table>
      <router-link to="/notice" class="more">더보기 +</router-link>
    </div>
    <div id="mainQna">
      <div class="mainBoardTitle">
        <h3 class="boardName">문의</h3>
      </div>
      <table class="table">
        <thead>
          <tr>
            <th>번호</th>
            <th>제목</th>
            <th>작성자</th>
            <th>작성일</th>
          </tr>
        </thead>
        <tbody>
          <tr>
            <th scope="row">1</th>
            <td>제목ㄴㄴ</td>
            <td>작성자ㄴㄴ</td>
            <td>111111</td>
          </tr>
          <tr>
            <th scope="row">1</th>
            <td>제목ㄴㄴ</td>
            <td>작성자ㄴㄴ</td>
            <td>111111</td>
          </tr>
          <tr>
            <th scope="row">1</th>
            <td>제목ㄴㄴ</td>
            <td>작성자ㄴㄴ</td>
            <td>111111</td>
          </tr>
        </tbody>
      </table>
      <router-link to="/qna" class="more">더보기 +</router-link>

    </div>
  </div>

  </div>
  </div>
</template>

<script>

export default {
  name: 'App',
  components: {
  },
  methods: {
    getData: function () {
      console.log('ss')
    }
  },
  el: '#app'

}

</script>

<style>
table {
  text-align: center;
}
a{
  color: black;
  text-decoration: none;
}
a:hover{
  color: white;
}
#imgDiv{
  height: 500px;
  width: 1000px;
  margin: auto;
  margin-left: 27%;

}
#imgWrap{
  width: 100%;
  position: relative;
  background: rgb(21, 26, 33);
}
#imgDivText{
  position: absolute;
  bottom: 45%;
  left:3%;
  width: 100%;
  color: white;
  font-size: 50px;
  text-shadow: 5px 5px 0 rgb(3, 71, 95);
  width: 400px;
  height: 80px;
  background-color: rgb(0, 137, 188);
  border-radius: 0.5rem;
}
#imgDivText p{
  margin-left: 23px;
}
#imgDivText2{
  text-align: center;
  background-color: rgb(0, 137, 188);
  width: 200px;
}
#mainImg{
  height: 100%;
  width: 100%;
}
#boardWrap{
  display: flex;
}
.mainBoardTitle{
  position:absolute;
  background: white;
  top: -10%;
  left: 3%;
  width: 75px;
}
#mainNotice{
margin-right: 6%;
}
#mainQna{
margin-left: 6%;
}
.boardName{
  margin: 10px;
  margin-bottom: 1px;
  float: left;
  width: 200px;

}
#mainNotice,#mainQna{
  border: 1px black solid;
  width: 600px;
  height: 250px;
  position: relative;
  padding-top: 30px;
}
#mainNotice tbody tr:hover,#mainQna tbody tr:hover{
cursor: pointer;
background-color:rgba(0, 0, 0, 0.1);
}

#mainNotice table,#mainQna table{
  width: 95%;
  margin: auto;
}
.more{
  float: right;
  color: gray;
  font-size: 18px;
  margin-bottom: 10px;
  margin-right: 8px;
  margin-top: 10px;
}
.more:hover{
  color: rgb(40, 39, 39);
  cursor: pointer;
}

</style>
