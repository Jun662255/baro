<template>
  <div class="mainWrap">
    <h2>배송 신청</h2><hr><br>
    <div id="transportForm"><br>
      <h3 style="text-align:center"> 배송 정보</h3><br>
      <div class="transportFormDetail">
        <form action="/success">
          <div>
            회원명 :
            <input type="text" class="tInput" required v-model="userName" readonly><br>
          </div>
          <div>
            연락처 :
            <input type="text" class="tInput" required v-model="phone" readonly><br>
          </div>
          <div>
            출발지 :
            <input type="text" id="postcode" placeholder="우편번호" class="tInputH" v-model="add1" required readonly>
            <input type="button" value="주소찾기" class="tBtn btn btn-dark" @click="search()"><br><br>
            <input type="text" id="roadAddress" placeholder="도로명주소" class="tInput" v-model="add2" required readonly><br><br>
            <input type="text" id="detailAddress" placeholder="상세주소" class="tInput" v-model="add3" required maxlength="20"><br>
          </div>
          <div>
            받는분 :
            <input type="text" class="tInput" v-model="name" required maxlength="5"><br>
          </div>
          <div>
            도착지 :
            <input type="text" id="postcode1" placeholder="우편번호" class="tInputH" v-model="add4" required readonly>
            <input type="button" value="주소찾기" class="tBtn btn btn-dark" @click="search1()"><br><br>
            <input type="text" id="roadAddress1" placeholder="도로명주소" class="tInput" v-model="add5" required readonly><br><br>
            <input type="text" id="detailAddress1" placeholder="상세주소" class="tInput" v-model="add6" required maxlength="20"><br>
          </div>
          <div>
            운임 가격 :
            <select name="" id="price" class="tSelect" v-model="price" required>
              <option value="10000">1kg이하 &emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;10,000원</option>
              <option value="12000">1kg이상 2kg이하 &emsp;&emsp;&emsp;&emsp;12,000원</option>
              <option value="13000">2kg이상 3kg이하 &emsp;&emsp;&emsp;&emsp;13,000원</option>
              <option value="14000">3kg이상 4kg이하 &emsp;&emsp;&emsp;&emsp;14,000원</option>
              <option value="15000">4kg이상 5kg이하 &emsp;&emsp;&emsp;&emsp;15,000원</option>
            </select>
            <br>
          </div>
          <div>
            <br>
            <button class="tSubmit btn btn-dark" type="submit" @click="setTransport()">배송신청</button>
          </div>
        </form>
      </div>
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
      userName: localStorage.getItem('user_name'),
      phone: localStorage.getItem('phone'),
      user_no: null,
      add1: this.add1,
      add2: this.add2,
      add3: this.add3,
      name: this.name,
      add4: this.add4,
      add5: this.add5,
      add6: this.add6,
      price: '10000'
    }
  },
  components: {
  },
  mounted () {
    if (this.$store.state.loginCheck == null) {
      alert('로그인후 이용 바랍니다')
      router.push('/login')
    }
  },
  methods: {
    // if(add1 != null && add2 != null && add3 != null && name != null && add4 != null && add5 != null && add6 != null) {

    setTransport () {
      if (this.add1 != null && this.add2 != null && this.add3 != null && this.name != null && this.add4 != null && this.add5 != null && this.add6 != null) {
        axios({
          method: 'post',
          url: '/api/setTransport',
          data: {
            user_no: localStorage.getItem('user_no'),
            add1: this.add1,
            add2: this.add2,
            add3: this.add3,
            recipient: this.name,
            add4: this.add4,
            add5: this.add5,
            add6: this.add6,
            price: this.price
          }
        }).then(data => {
          console.log(data)
          // location.replace('/success')
        }).catch(err => {
          console.log(err)
        })
      }
    },
    search () {
      new window.daum.Postcode({
        oncomplete: (data) => {
          var roadAddr = data.roadAddress
          this.add1 = data.zonecode
          this.add2 = roadAddr
        }
      }).open()
    },
    search1 () {
      new window.daum.Postcode({
        oncomplete: (data) => {
          var roadAddr = data.roadAddress
          this.add4 = data.zonecode
          this.add5 = roadAddr
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
  height: 850px;
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
