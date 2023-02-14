<template>
  <div id="app">
  <header1/>

    <router-view/>
    <br><br><br><br>

  <footer1 />
  </div>
</template>

<script>
import footer1 from './components/footer1.vue'
import header1 from './components/hedaer1.vue'
export default {
  name: 'App',
  components: {
    footer1,
    header1
  }
}
</script>

<style>

.mainWrap{
 width: 1200px;
 margin: auto;
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
.rightAlign{
  text-align: right;
}
.leftAlign{
  text-align: left;
}
.tabelHead{
  background-color: rgb(250, 250, 250);
}
.tabelHead> th{
  border-left: 1px solid lightgray;
}

.FontSize14 th, .FontSize14 td{
  font-size: 14px;
}
#serch{
  width: 250px;
  height: 40px;
  border: none;
  border-bottom: 2px solid black;
  margin-right: 10px;
}
</style>
