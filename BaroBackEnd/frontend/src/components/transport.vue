<template>
  <div class="mainWrap">
    <h2>배송 신청</h2><hr><br>
    <div id="transportForm"><br>
      <h3 style="text-align:center"> 배송 정보</h3><br>
      <div class="transportFormDetail">
        <form action="">

          <div>
            회원명 :
            <input type="text" class="tInput"><br>
          </div>
          <div>
            연락처 :
            <input type="text" class="tInput"><br>
          </div>
          <div>
            출발지 :
            <input type="text" id="postcode" placeholder="우편번호" class="tInputH">
            <input type="button" value="주소찾기" class="tBtn btn btn-dark" @click="search()"><br><br>
            <input type="text" id="roadAddress" placeholder="도로명주소" class="tInput"><br><br>
            <input type="text" id="detailAddress" placeholder="상세주소" class="tInput"><br>
          </div>
          <div>
            받는분 :
            <input type="text" class="tInput"><br>
          </div>
          <div>
            받는분 연락처 :
            <input type="text" class="tInput"><br>
          </div>
          <div>
            도착지 :
            <input type="text" id="postcode1" placeholder="우편번호" class="tInputH">
            <input type="button" value="주소찾기" class="tBtn btn btn-dark" @click="search1()"><br><br>
            <input type="text" id="roadAddress1" placeholder="도로명주소" class="tInput"><br><br>
            <input type="text" id="detailAddress1" placeholder="상세주소" class="tInput"><br>
          </div>
          <div>
            운임 가격 :
            <select name="" id="" class="tSelect">
              <option value="1">1</option>
              <option value="2">2</option>
              <option value="3">3</option>
              <option value="4">4</option>
              <option value="5">5</option>
            </select>
            <br>
          </div>
          <div>
            <br>
            <button class="tSubmit btn btn-dark" type="submit">배송신청</button>
          </div>
        </form>
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
    search () {
      new window.daum.Postcode({
        oncomplete: (data) => {
          var roadAddr = data.roadAddress
          var extraRoadAddr = ''
          if (data.bname !== '' && /[동|로|가]$/g.test(data.bname)) {
            extraRoadAddr += data.bname
          }
          if (data.buildingName !== '' && data.apartment === 'Y') {
            extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName)
          }
          if (extraRoadAddr !== '') {
            extraRoadAddr = ' (' + extraRoadAddr + ')'
          }
          document.getElementById('postcode').value = data.zonecode
          document.getElementById('roadAddress').value = roadAddr
          document.getElementById('jibunAddress').value = data.jibunAddress
        }
      }).open()
    },
    search1 () {
      new window.daum.Postcode({
        oncomplete: (data) => {
          var roadAddr = data.roadAddress
          var extraRoadAddr = ''
          if (data.bname !== '' && /[동|로|가]$/g.test(data.bname)) {
            extraRoadAddr += data.bname
          }
          if (data.buildingName !== '' && data.apartment === 'Y') {
            extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName)
          }
          if (extraRoadAddr !== '') {
            extraRoadAddr = ' (' + extraRoadAddr + ')'
          }
          document.getElementById('postcode1').value = data.zonecode
          document.getElementById('roadAddress1').value = roadAddr
          document.getElementById('jibunAddress1').value = data.jibunAddress
        }
      }).open()
    }
  }
}

</script>

<style>
.mainWrap{
 width: 1200px;
 margin: auto;

}
#transportForm{
  width: 1000px;
  height: 950px;
  border: solid 1px black;
  margin:auto;
  font-size: 20px;
}
.transportFormDetail{
  margin: auto;
  width: 565px;
}
.transportFormDetail input{
  float: right;
}
.transportFormDetail div{
  margin: 20px;
}
.tInput{
  width: 350px;
}
.tSelect{
  width: 350px;
  float: right;
}
.tInputH{
  width: 250px;
  margin-left: 10px;
}
.tBtn{
  float: right;
  width: 90px;
  font-size: 16px;
}
.tSubmit{
  float: right;
  width: 150px;
  height: 50px;
}

</style>
