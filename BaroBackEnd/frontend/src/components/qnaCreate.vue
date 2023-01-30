<template>
    <div class="wrap">
        <h2>문의 작성</h2><hr><br>
        <div class="boardCreateWrap">
            <form action="">
                <input type="text" class="boardTitle" placeholder="제목을 작성해주세요">
                <input type="text" class="boardContent" placeholder="내용을 작성해주세요">
                <button class="createBtn">작성</button>
            </form>
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
    .boardCreateWrap{
        width: 1200px;
        margin:auto;
        border: 1px solid black;
        padding: 30px;
        min-height: 600px;

    }
    .boardTitle , .boardContent{
        width: 99%;
        margin-bottom: 15px;
    }
    .boardTitle{
        font-size: 20px;
    }
    .boardContent{
        margin-top: 15px;
        font-size: 18px;
        min-height: 400px;
    }
    .createBtn{
        float: right;
        margin-right: 10px;
        width: 90px;
        height: 40px;
    }
</style>
