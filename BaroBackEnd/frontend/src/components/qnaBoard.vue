<template>
    <div class="boardWrap">
        <h2>&nbsp;&nbsp;문의 게시판</h2><hr>
        <br>
        <div class="contentWrap">
            <table class="table">
                <thead>
                    <tr>
                        <th style="width: 10%;">번호</th>
                        <th>제목</th>
                        <th style="width: 15%;">작성자</th>
                        <th style="width: 15%;">답변</th>
                        <th style="width: 20%;">작성일</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <th scope="row">1</th>
                        <td>제목</td>
                        <td>admin</td>
                        <td style="color:blue">답변완료</td>
                        <td>22.22.22</td>
                    </tr>
                    <tr>
                        <th scope="row">1</th>
                        <td>제목</td>
                        <td>admin</td>
                        <td style="color:red">답변미완</td>
                        <td>22.22.22</td>
                    </tr>
                </tbody>
            </table>
            <div class="pageWrap">
                <button class="btn btn-dark paging" >&lt;</button>
                <button class="btn btn-dark paging">1</button>
                <button class="btn btn-dark paging">&gt;</button>
            </div>
            <div class="crateWrap">
                <router-link to="/qnaCreate" class="btn btn-dark">작성</router-link>
            </div>
        </div>
    </div>

</template>

<script>
export default {

}
</script>

<style>
    table{
        text-align: center;
        width: 100%;

    }
    .boardWrap{
        width: 1200px;
        margin: auto;
    }
    .contentWrap{
        display: flex;
        flex-direction: column;
    }
    .pageWrap{
        margin: auto;
        margin-top:30px;
    }
    .crateWrap{
        width: 80px;
        height: 30px;
        margin-left: 90%;

    }
    .crateWrap button{
        width: 100%;
        height: 100%;
    }
</style>
