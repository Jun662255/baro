<template>
  <div class="mainWrap">
    <div id="myPageWrap">
    <h2>마이 페이지</h2><hr><br>
      <div id="changeInfo">
      <h3>회원 정보 변경</h3>
        <div class="infoInput">
          <form action="">
            <input type="text" placeholder="이름" value="">
            <input type="text" placeholder="아이디" value="">
            <input type="text" placeholder="현재 비밀번호">
            <input type="text" placeholder="새 비밀번호">
            <input type="text" placeholder="새 비밀번호 확인">
            <input type="text" placeholder="번호">
            <br><br>
            <button id="infoBtn" type="button" class="btn btn-dark">변경:)</button>
          </form>
        </div>
      </div>
      <br><br>
      <div id="myTransport" style="border: 1px solid black;">
        <div id="myTransportTitle">
          <h4 style="margin-left: 10px;margin-top: 10px;">배송정보</h4>
        </div>
        <table id="myPageTable" class="table">
          <thead>
            <tr>
              <th rowspan="2" id="tNo">배송번호</th>
              <th>보내시는 분</th>
              <th style="width:600px;">출발지</th>
              <th>가격</th>
            </tr>
            <tr>
              <th>받는분</th>
              <th>도착지</th>
              <th>배송상태</th>
            </tr>
          </thead>
          <tbody>
            <tr>
              <td rowspan="2"><br>1</td>
              <td>홍길동</td>
              <td>서울 강남구 선릉로 523 4층</td>
              <td>10000 원</td>
            </tr>
            <tr>
              <td>말동</td>
              <td>서울 강남구 선릉로 523 4층</td>
              <td>입금대기</td>
              <td></td>
            </tr>
          </tbody>
        </table>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: 'App',
  components: {
  },
  data () {
    return {
      name: 'foo'
    }
  }
}
</script>

<style>
#myTransport{
  position: relative;
}
#myTransportTitle{
  position: absolute;
  top: -13%;
  background: white;
  left: 2%;
}
.mainWrap{
 width: 1200px;
 margin: auto;
}
#changeInfo{
  width: 450px;
  height: 580px;
  text-align: left;
  border: black solid 2px;
  padding: 50px;
}

.infoInput input{
  width: 80%;
  height: 70%;
  border: none;
  border-bottom: 2px solid black;
  font-size: 20px;
  margin-top: 30px;
}
.infoInput input:focus {
  outline:none;
}
#infoBtn{
  float: right;
  width: 200px;
  height: 50px;
  margin-top: 20px;
}
#myPageTable{
  width: 100%;
  text-align: center;
}
#myPageTable tr{
  height: 50px;
}
#tNo{
 padding-bottom: 38px;
}
</style>
