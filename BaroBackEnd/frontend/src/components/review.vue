<template>
  <div class="mainWrap">
    <div class="boardWrap">
      <h2> 리뷰 게시판</h2>
      <div class="reviewTable" >
        <div style="display:flex">
        <div class="review">
          <div class="reviewImg">
            <img src="../../assets/2.png"/>
          </div>
          <div style="display:flex">
            <div class="reviewNo">
              No. 10
            </div>
            <div class="reviewName">
              제목목목
            </div>
          </div>
        </div>
        <div class="review">
          <div class="reviewImg">
            <img src="../../assets/2.png"/>
          </div>
          <div style="display:flex">
            <div class="reviewNo">
              No. 10
            </div>
            <div class="reviewName">
              제목목목
            </div>
          </div>
        </div>
        <div class="review">
          <div class="reviewImg">
            <img src="../../assets/2.png"/>
          </div>
          <div style="display:flex">
            <div class="reviewNo">
              No. 10
            </div>
            <div class="reviewName">
              제목목목
            </div>
          </div>
        </div>
        </div>        <div style="display:flex">
        <div class="review">
          <div class="reviewImg">
            <img src="../../assets/2.png"/>
          </div>
          <div style="display:flex">
            <div class="reviewNo">
              No. 10
            </div>
            <div class="reviewName">
              제목목목
            </div>
          </div>
        </div>
        <div class="review">
          <div class="reviewImg">
            <img src="../../assets/2.png"/>
          </div>
          <div style="display:flex">
            <div class="reviewNo">
              No. 10
            </div>
            <div class="reviewName">
              제목목목
            </div>
          </div>
        </div>
        <div class="review">
          <div class="reviewImg">
            <img src="../../assets/2.png"/>
          </div>
          <div style="display:flex">
            <div class="reviewNo">
              No. 10
            </div>
            <div class="reviewName">
              제목목목
            </div>
          </div>
        </div>
        </div>
        <div class="reviewBtn">btn</div>
      </div>
      <!--<table class="reviewTable" border="1px solid red">
         <tr class="reviewTr1">
          <td colspan="2">
            <img src="../../assets/2.png"/>
          </td>
        </tr>
        <tr class="reviewTr2">
          <td>No : </td>
          <td>제목asdasdasd</td>
        </tr>
        <tr class="reviewTr1">
          <td colspan="2">
            <img src="../../assets/2.png"/>
          </td>
        </tr>
        <tr class="reviewTr2">
          <td>No : </td>
          <td>제목asdasdasd</td>
        </tr>
        <tr class="reviewTr1">
          <td colspan="2">
            <img src="../../assets/2.png"/>
          </td>
        </tr>
        <tr class="reviewTr2">
          <td>No : </td>
          <td>제목asdasdasd</td>
        </tr>
      </table> -->
      <div class="pageBtn">
        <button></button><button></button><button></button>
      </div>
    </div>
    <br><br><br><br><br>
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
.reviewTable{
  width: 1200px;
  height: 1000px;
  border: 1px solid rgb(0, 0, 0);
  display: flex;
  flex-direction: column;
}

.review{
  border: 1px solid rgb(0, 0, 0);
  width: 300px;
  height: 300px;
  margin-top: 100px;
  margin-left: 50px;
  margin-right: 50px;
}
.reviewNo{
  border: 1px solid rgb(0, 0, 0);
  width: 100px;
}
.reviewName{
   border: 1px solid rgb(0, 0, 0);
   width: 200px;
}
.reviewTr1{
  width: 300px;
  height: 200px;
}
.reviewTr2{
  width: 300px;
  height: 200px;
}
.reviewBtn{
  margin: auto;
}

</style>
