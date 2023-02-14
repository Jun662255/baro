<template>
  <div class="mainWrap">
  <br>
  <br>
  <br>
  <br>
    <div id="seccessWrap">
    <br><br>
      <h1>감사합니다 :)</h1>
        <br><br><br>
        <h2>입금 완료 후 입력하신 주소로 배송기사가 출발합니다.</h2>
        <h2>가격 : {{price}}원</h2>
        <h2>입금 계좌 : ㅇㅇ은행 0000-000-000000 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;홍길동</h2>
        <br><br><br>
          <router-link to="/main" id="btnMain" class="btn btn-dark"><p>메인으로</p></router-link>
    </div>
  </div>
</template>

<script>
import axios from 'axios'
export default {
  name: 'App',
  data () {
    return {
      price: null
    }
  },
  components: {
  },
  mounted () {
    axios({
      method: 'Post',
      url: 'api/price',
      data: {
        user_no: localStorage.getItem('user_no')
      }
    }).then(data => {
      this.price = data.data
    }).catch(err => {
      console.log(err)
    })
  }
}
</script>

<style>
#seccessWrap{
  border: 1px solid black;
  width: 1000px;
  height: 600px;
  margin: auto;
  text-align: center;
}
#btnMain{
  width: 150px;
  height: 50px;
}
#btnMain p{
  margin-top: 4px;
}
</style>
