<template>
    <div class="wrap">
        <h2>문의 상세</h2><hr><br>
        <div class="boardDetailWrap">
            <h2> 제목</h2>
            <div class="boardInfo">
                작성자 &nbsp;/&nbsp;2022.22.22
            </div>
            <hr>
            <div class="fileDown">
                <a href=""> 올라간파일</a>
            </div>
            <div class="createDate">
            </div><br>
            <div class="boardDetilContent">
                컨텐츠
            </div>
            <div class="asd">
            <button class="btnBackDiv"> 뒤로가기</button>
            </div>
        </div>
        <br><br>
        <div class="answer">
            답변
        </div>

    </div>
</template>

<script>
export default {

}
</script>

<style>
    .wrap{
        width: 1200px;
        margin: auto;
    }
    .boardDetailWrap{
        width: 1200px;
        margin:auto;
        border: 1px solid black;
        padding: 30px;
    }
    .boardTitle , .boardContent{
        width: 99%;
        margin-bottom: 15px;
    }
    .boardTitle{
        font-size: 20px;
    }
    .boardDetilContent{
        min-height: 400px;
        padding: 5px;
    }
    .boardInfo{
        width: 200px;
        font-size: 13px;
        white-space: nowrap;
    }
    .btnBackDiv{
        margin: auto;
        display: block;
        margin-top: 10px;
    }
    .answer{
        border: 1px solid black;
        padding: 30px;
    }
</style>
