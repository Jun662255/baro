<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- 헤더파일 include -->
<%@ include file="/WEB-INF/views/pandora3/common/include/header.jsp"%>

<link rel="stylesheet" href="./style.css">

<script type="text/javascript">
function insert() {
const nT = document.getElementById('nTitle')
const nC = document.getElementById('nContent')
const regExp = /^[^<>&()]+$/;
	if(!validChk($('#newForm'))) return false;
		// insert 
	if(!regExp.test(nT.value)) {
		alert('제목에 < > & ( ) 는 사용할 수 없습니다')
	} else if(!regExp.test(nC.value)) {
		alert('내용에 < > & ( ) 는 사용할 수 없습니다')
	} else {
		ajax({
				url : '/baro/board/notice/inserteNotice',
				data : $("form[name=pgmInfoForm1]").serialize(),
				async : false,
				contentType:false,
		     	cache:false,
		     	processData:false,
				success : function(data) {
					if (data.RESULT == "S") {
						alert(data.MSG);
						document.getElementById('nContent').value = null;
						document.getElementById('nTitle').value = null;
						return;
					} else {
						alert("일시적 오류입니다\n잠시후 다시 시도하세요.")
						e.preventDefault();
						return;
					}
				}
			});			
		}
    }
function update() {
	const nT = document.getElementById('nTitle')
	const nC = document.getElementById('nContent')
	const regExp = /^[^<>&()]+$/;
	    if(!validChk($('#newForm'))) return false;
        // update
	    if(!regExp.test(nT.value)) {
	        alert('제목에 < > & ( ) 는 사용할 수 없습니다')
	    } else if(!regExp.test(nC.value)) {
	        alert('내용에 < > & ( ) 는 사용할 수 없습니다')
	    } else {

			ajax({
					url : '/baro/board/notice/updateNotice',
					data : $("form[name=pgmInfoForm1]").serialize(),
					async : false,
					contentType:false,
			     	cache:false,
			     	processData:false,
					success : function(data) {
						if (data.RESULT == "S") {
							alert(data.MSG);
							return;
						} else {
							alert("일시적 오류입니다\n잠시후 다시 시도하세요.")
							e.preventDefault();
							return;
						}
					}
				});
			}
		 } 
let NOTICE_TITLE = '<%=parameterMap.getValue("_param")%>'
let NOTICE_NO = '<%=parameterMap.getValue("_param2")%>'
let NOTICE_CONTENT = '<%=parameterMap.getValue("_param3")%>'

	$(document).ready(function() {
		if (NOTICE_TITLE != '' && NOTICE_CONTENT != '' && NOTICE_NO != '') {
			$("#nTitle").val(NOTICE_TITLE)
			$("#nContent").val(NOTICE_CONTENT)
			$("#nNo").val(NOTICE_NO)
			$('#btnIn').attr('style', 'display:none')
		} else {
			$('#btnUp').attr('style', 'display:none')
		}

	});
</script>
</head>
<body>
	<div class="frameWrap">
		<form id="newForm" method="POST" name="pgmInfoForm1">
			<div class="subCon">
				<%@ include file="/WEB-INF/views/pandora3/common/include/btnList.jsp"%>
				<input type="hidden" id=nNo name="_NOTICE_NO">
				<table class="tblType1">
					<colgroup>
						<col style="width: 117px;">
						<col style="width:">
						<col style="width: 110px">
						<col style="width: 117px;">
						<col style="width: 110px">
						<col style="width:">
					</colgroup>
					<tr>
						<th>
						    <label for="nTitle" class="vv necessary">제목</label>
						</th>
						<td colspan="5">
						    <span class="txt_pw">
						        <input type="text" name=_NOTICE_TITLE id="nTitle" class="w100" data-byte="250" title="제목" maxlength="50" />
						    </span>
						</td>
					</tr>
					<tr>
						<th>
						    <label for="nContent" class="vv necessary">내용</label>
						</th>
						<td colspan="5">
						    <span class="txt_pw">
						        <textarea rows="30" cols="" class="w100" name="_NOTICE_CONTNET" id="nContent" maxlength="500"></textarea>
						    </span>
						</td>
					</tr>
				</table>
				<div class="bottomBtnWrap nonFloating">
					<button type="button" id="btnIn" class="btn_common btn_dark" onclick="insert()">작성</button>
					<button type="button" id="btnUp" class="btn_common btn_dark" onclick="update()">수정</button>
				</div>
			</div>
		</form>
	</div>
</body>


<%@ include file="/WEB-INF/views/pandora3/common/include/footer.jsp"%>
