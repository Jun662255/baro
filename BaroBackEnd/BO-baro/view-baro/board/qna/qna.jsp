<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- 헤더파일 include -->
<%@ include file="/WEB-INF/views/pandora3/common/include/header.jsp"%>
<script type="text/javascript">
	var pgm_grid;
	$(document).ready(function() {
		var pgm_config = {
			gridid : 'pgm_grid', // 그리드 id
			pagerid : 'pgm_grid_pager', // 그리드 페이지 id
			gridBtnYn : 'Y',
			// column info
			columns : [ {
				name : 'QNA_NO',
				label : '문의번호',
				align : 'center',
				width : 10
			}, {
				name : 'QNA_TITLE',
				label : '제목',
				align : 'left',
				width : 40
			}, {
				name : 'O_FILE_NAME',
				label : '첨부파일',
				align : 'center',
				hidden : false,
				formatter : fnFormatterAtt,
				width : 10
			}, {
				name : 'USER_ID',
				label : '작성자',
				align : 'center',
				width : 15,
			}, {
				name : 'QNA_DATE',
				label : '작성일',
				align : 'center',
				width : 15,
			}, {
				name : 'QNA_CONTENT',
				label : '내용',
				align : 'center',
				hidden : true
			}, {
				name : 'COMMENT',
				label : '답변',
				align : 'center',
				hidden : true,
			}, {
				name : 'CHECK_COMMENT',
				label : '답변상태',
				align : 'center',
				hidden : false,
				formatter : fnFormatterCommentCheck,
				width : 15
			}, {
				name : 'C_FILE_NAME',
				label : '첨부파일명',
				align : 'center',
				hidden : true,
			} ],
			editmode : false, // 그리드 editable 여부
			gridtitle : '문의 목록', // 그리드명
			multiselect : false, // checkbox 여부
			formid : 'search', // 조회조건 form id
			height : 200, // 그리드 높이
			shrinkToFit : true, // true인경우 column의 width 자동조정, false인경우 정해진 width대로 구현(가로스크롤바필요시 false)
			caption : "Frozen Header",
			selecturl : '/baro/board/qna/getQanList', // 그리드 조회 URL
			hightlight : true,
			rownumbers : false,
			events : {
				onSelectRow : function(event, rowid) {
					var row = pgm_grid.getRowData(rowid);
					$('#c_file_name_temp').css('display', '');
				},
				onCellSelect : function(event, rowid, icol) { // 해당 셀 선택시
					var row = pgm_grid.getRowData(rowid);

					fn_detailPgmInfo(row);
				}
			}
		};
		pgm_grid = new UxGrid(pgm_config);
		pgm_grid.init();
		pgm_grid.setGridWidth($('.tblType1').width());
		$("#pgm_grid").jqGrid('setFrozenColumns');

	});

	//  formatter
	function fnFormatterCommentCheck(cellValue, options, rowObject) {
		if (rowObject.CHECK_COMMENT == 'Y') {
			return '<p style="color:blue; text-align:center; margin:auto">답변완료</p>';

		} else {
			return '<p style="color:red; text-align:center; margin:auto;">답변미완</p>';
		}
	}
	function fnFormatterAtt(cellValue, options, rowObject) {
		if (rowObject.O_FILE_NAME != null) {
			return '<p style=" text-align:center; margin:auto">Y</p>';

		} else {
			return '<p style=" text-align:center; margin:auto;">N</p>';
		}
	}

	//grid resizing
	$(window).resize(function() {
		pgm_grid.setGridWidth($('.tblType1').width());
	});
	
	// 실제 이미지 파일 확인
	function fileExists(url) {
		  var http = new XMLHttpRequest();
		  http.open('HEAD', url, false);
		  http.send();
		  return http.status != 404;
		}
	
	// 그리드 셀 클릭 시 하단 상세정보 세팅
	function fn_detailPgmInfo(rowInfo) {

		$("#qna_no").val(rowInfo.QNA_NO);
		$("#qna_title").val(rowInfo.QNA_TITLE);
		$("#user_id").val(rowInfo.USER_ID);
		$("#qna_date").val(rowInfo.QNA_DATE);
		$("#Q1").val(rowInfo.QNA_CONTENT);
		$("#Q2").val(rowInfo.COMMENT);
		$("#c_file_name").val(rowInfo.C_FILE_NAME);
		if (rowInfo.C_FILE_NAME != "") {
		    var imagePath = "/baro/" + rowInfo.C_FILE_NAME;
		    if (fileExists(imagePath)) {
		        $("#c_file_name_temp").attr("src", imagePath);
		    } else {
		        $("#c_file_name_temp").attr("src", "/baro/noImg.png");
		    }
		} else {
		    $("#c_file_name_temp").attr("src", "");
		}
	}

	//조회: 내부 로직 사용자 정의
	function fn_Search() {
		$('#pgmInfoForm1 img').css('display', 'none');
		$('#pgmInfoForm1').clearFormData();
		pgm_grid.retreive();
	}

	//저장: 내부 로직 사용자 정의
	function fn_Save() {

		
		if (isEmpty($('#qna_title').val())) {
			alert('게시글을 선택해 주세요.')
			return false;
		}
		;
		if (!validChk($('#pgmInfoForm1')))
			return false;
		ajax({
			url : '/baro/board/qna/QanSava',
			data : $("form[name=pgmInfoForm1]").serialize(),
			async : false,
			success : function(data) {

				if (data.RESULT == "S") {
					alert(data.MSG);
					$('#pgmInfoForm1').clearFormData();
					// c_file_name_temp
					$('#c_file_name_temp').prop('src', '');
					fn_Search();
					return;
				} else {
					alert("일시적 오류입니다\n잠시후 다시 시도하세요.")
					e.preventDefault();
					return;
				}
			}
		});
	}


</script>
<style>
.hi200 {
	height: 200px
}

#c_file_name_temp {
	height: auto;
	max-width: 100%
}
</style>
</head>
<body>
	<div class="frameWrap">
		<div class="subCon">
			<%@ include file="/WEB-INF/views/pandora3/common/include/btnList.jsp"%>
			<!-- search -->
			<div class="frameTopTable">
				<form name="search" id="search" name="search"
					onsubmit="return false">
					<table class="tblType1">
						<colgroup>
							<col style="width: 117px;" />
							<col style="" />
							<col style="width: 117px;" />
							<col style="" />
						</colgroup>
						<tbody>
                            <tr>
                                <th>제목</th>
                                <td>
                                    <span class="txt_pw"><input type="text" name="keyword_title" id="keyword_title" class="text" /></span>
                                </td>
                                <th>작성자</th>
                                <td>
                                    <span class="txt_pw"><input type="text" name="keyword_id" id="keyword_id" class="text" /></span>
                                </td>
                                <th style="width: 100px">답변상태</th>
                                <td>
                                <div class=radio>
                                    <span class="txt_pw">
	                                  <label style="display: inline-block; text-align: center;"><input type="radio" name="keyword_comment" value="" checked> 전체</label>
                                      <label style="display: inline-block; text-align: center;"><input type="radio" name="keyword_comment" value="Y"> 답변완료</label>
                                      <label style="display: inline-block; text-align: center;"><input type="radio" name="keyword_comment" value="N"> 답변미완</label>
                                    </span>
                                </div>
                                </td>
                            </tr>
						</tbody>
					</table>
				</form>
			</div>
            <div class="bgBorder"></div>
			<!-- search // -->
			<!-- Grid -->
			<table id="pgm_grid"></table>
			<div id="pgm_grid_pager"></div>

			<div class="bgBorder"></div>
			<!-- Grid // -->
			<div class="tableTop">
				<h3 class="title">상세정보</h3>
			</div>
			<!-- form -->
			<form name="pgmInfoForm1" id="pgmInfoForm1" method="post">

				<table class="tblType1">
					<colgroup>
						<col style="width: 117px;">
						<col style="width:">
						<col style="width:">
						<col style="width: 117px;">
						<col style="width:">
						<col style="width:">
					</colgroup>
					<tr>
						<th>
						  <label for="qna_title" class="vv">제목</label>
						</th>
						<td colspan="5">
						    <span class="txt_pw">
						        <input type="text" name="qna_title" id="qna_title" value="" class="w100" readonly="readonly" />
						    </span>
						</td>
					</tr>
					<tr>
						<th>
						    <label for="user_id" class="vv">작성자</label>
						</th>
						<td colspan="2">
							<span class="txt_pw">
							    <input type="text" readonly="readonly" name="user_id" id="user_id" value="" class="w100" maxlength="300" />
							</span>
						</td>
						<th>
						    <label for="qna_date" class="vv">작성일</label>
						</th>
						<td colspan="2">
							<span class="txt_pw">
							    <input type="text" name="qna_date" id="qna_date" value="" class="w100" maxlength="500" readonly="readonly" />
							</span>
						</td>
					</tr>
					<tr>
						<th>
						    <label for="Q1" class="vv">내용</label>
						</th>
						<td colspan="5">
						    <span class="txt_pw">
						        <img id="c_file_name_temp" src="">
						        <textarea cols="" name="Q1" id="Q1" maxlength="500" class="w100" style="height: 200px;" readonly="readonly"></textarea>
						    </span>
						</td>
					</tr>
					<tr>
						<td style="display: none;">
							<span class="txt_pw" style="display: none;">
							    <input type="hidden" name="qna_no" id="qna_no" />
							</span>
						</td>
					</tr>
					<tr style="height: 200px">
						<th>
						    <label for="Q2" class="vv necessary">답변</label>
						</th>
						<td colspan="5">
						    <span class="txt_pw">
						        <textarea rows="" cols="" name="Q2" id="Q2" value="" class="w100 " maxlength="500" style="height: 200px;"></textarea> 
						    </span>
						</td>
					</tr>
				</table>
			</form>
			<!-- form// -->
		</div>
	</div>
</body>
<%@ include file="/WEB-INF/views/pandora3/common/include/footer.jsp"%>
