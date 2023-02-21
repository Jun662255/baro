<template>
  <div class="mainWrap">
    <h2>배송 신청</h2><hr><br>
    <div id="transportForm"><br>
      <h3 style="text-align:center"> 배송 정보</h3><br>
      <div class="transportFormDetail">
        <form>
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
            <select name="" id="price" class="tSelect" v-model="this.price" required>
              <option :value="null">가격을 선택해주세요</option>
              <option :value="this.tcmn_cd_dtl.price1.cd_nm">{{tcmn_cd_dtl.price1.ref_1}}&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;{{comma.priceComma1}}</option>
              <option :value="this.tcmn_cd_dtl.price2.cd_nm">{{tcmn_cd_dtl.price2.ref_1}}&emsp;&emsp;&emsp;&emsp;{{comma.priceComma2}}</option>
              <option :value="this.tcmn_cd_dtl.price3.cd_nm">{{tcmn_cd_dtl.price3.ref_1}}&emsp;&emsp;&emsp;&emsp;{{comma.priceComma3}}</option>
              <option :value="this.tcmn_cd_dtl.price4.cd_nm">{{tcmn_cd_dtl.price4.ref_1}}&emsp;&emsp;&emsp;&emsp;{{comma.priceComma4}}</option>
              <option :value="this.tcmn_cd_dtl.price5.cd_nm">{{tcmn_cd_dtl.price5.ref_1}}&emsp;&emsp;&emsp;&emsp;{{comma.priceComma5}}</option>
            </select>
            <br>
          </div>
          <div>
            <br>
            <button class="tSubmit btn btn-dark" type="button" @click="setTransport()">배송신청</button>
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
      userName: this.$store.state.userInfo[0].USER_NAME,
      phone: this.$store.state.userInfo[0].PHONE,
      user_no: null,
      add1: '',
      add2: '',
      add3: '',
      name: '',
      add4: '',
      add5: '',
      add6: '',
      tcmn_cd_dtl: {
        price1: {
          cd_nm: null,
          ref_1: null
        },
        price2: {
          cd_nm: null,
          ref_1: null
        },
        price3: {
          cd_nm: null,
          ref_1: null
        },
        price4: {
          cd_nm: null,
          ref_1: null
        },
        price5: {
          cd_nm: null,
          ref_1: null
        }
      },
      price: null,
      comma: {
        priceComma1: null,
        priceComma2: null,
        priceComma3: null,
        priceComma4: null,
        priceComma5: null
      }
    }
  },
  components: {
  },
  mounted () {
    this.axios.get('api/getPrice').then(res => {
      this.tcmn_cd_dtl.price1.cd_nm = res.data[0].CD_NM
      this.tcmn_cd_dtl.price2.cd_nm = res.data[1].CD_NM
      this.tcmn_cd_dtl.price3.cd_nm = res.data[2].CD_NM
      this.tcmn_cd_dtl.price4.cd_nm = res.data[3].CD_NM
      this.tcmn_cd_dtl.price5.cd_nm = res.data[4].CD_NM
      this.tcmn_cd_dtl.price1.ref_1 = res.data[0].REF_1
      this.tcmn_cd_dtl.price2.ref_1 = res.data[1].REF_1
      this.tcmn_cd_dtl.price3.ref_1 = res.data[2].REF_1
      this.tcmn_cd_dtl.price4.ref_1 = res.data[3].REF_1
      this.tcmn_cd_dtl.price5.ref_1 = res.data[4].REF_1
      this.comma.priceComma1 = this.priceComma(this.tcmn_cd_dtl.price1.cd_nm)
      this.comma.priceComma2 = this.priceComma(this.tcmn_cd_dtl.price2.cd_nm)
      this.comma.priceComma3 = this.priceComma(this.tcmn_cd_dtl.price3.cd_nm)
      this.comma.priceComma4 = this.priceComma(this.tcmn_cd_dtl.price4.cd_nm)
      this.comma.priceComma5 = this.priceComma(this.tcmn_cd_dtl.price5.cd_nm)
    }).catch(err => {
      console.log(err)
    })
  },
  methods: {
    priceComma (val) {
      return String(val).replace(/\B(?=(\d{3})+(?!\d))/g, ',') + '원'
    },
    setTransport () {
      if (this.add1 === '' && this.add2 === '') {
        alert('보내시는 주소를 입력해 주세요')
      } else if (this.add3 === '') {
        alert('상세주소를 입력해 주세요')
      } else if (this.name === '') {
        alert('받으시는 분 이름을 입력해 주세요')
      } else if (this.add4 === '' && this.add5 === '') {
        alert('받으시는 주소를 입력해 주세요')
      } else if (this.add6 === '') {
        alert('상세주소를 입력해 주세요')
      } else if (this.price == null) {
        alert('가격을 선택해 주세요')
      } else {
        axios({
          method: 'post',
          url: '/api/setTransport',
          data: {
            user_no: this.$store.state.userInfo[0].USER_NO,
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
          router.push('/success')
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
