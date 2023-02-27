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
				name : 'SYS_CD',
				label : '시스템코드',
				editable : false,
				hidden : true
			}, {
				name : 'STATUS',
				label : '상태',
				align : 'center',
				hidden : true
			}, {
				name : '_NOTICE_NO',
				label : '공지번호',
				align : 'center',
				width : 50
			}, {
				name : '_NOTICE_TITLE',
				label : '제목',
				align : 'left',
				width : 220,
				   
			}, {
				name : '_NOTICE_DATE',
				label : '작성일',
				align : 'center',
				width : 70
			}, {
				name : 'NOTICE_WRITER',
				label : '작성자',
				align : 'center',
				width : 70
			}, {
				name : '_NOTICE_CONTENT',
				label : '내용',
				align : 'center',
				hidden : true

			} ],
			editmode : false, // 그리드 editable 여부
			gridtitle : '공지 목록', // 그리드명
			multiselect : false, // checkbox 여부
			formid : 'search', // 조회조건 form id
			height : 200, // 그리드 높이
			shrinkToFit : true, // true인경우 column의 width 자동조정, false인경우 정해진 width대로 구현(가로스크롤바필요시 false)
			rownumbers : false,
			caption : "Frozen Header",
			selecturl : '/baro/board/notice/getNoticeList', // 그리드 조회 URL
			saveurl : '/baro/board/notice/saveGridNotice', // 그리드 저장 URL
			hightlight : true,
			events : {
				onSelectRow : function(event, rowid) {
					var row = pgm_grid.getRowData(rowid);
				},
				onCellSelect : function(event, rowid, icol) { // 해당 셀 선택시
					const title = pgm_grid.getColName(icol)
					var row = pgm_grid.getRowData(rowid);
					fn_detailPgmInfo(row);
				},
				ondblClickRow : function(event, rowid) {
                    var rowTest = pgm_grid.getRowData(rowid);
                    parent.addTab('1721', '공지수정',"/baro/board/notice/forward.noticeCreate.adm", rowTest._NOTICE_TITLE, rowTest._NOTICE_NO ,rowTest._NOTICE_CONTENT);
                }
			}
		};
		pgm_grid = new UxGrid(pgm_config);
		pgm_grid.init();
		pgm_grid.setGridWidth($('.tblType1').width());
		$("#pgm_grid").jqGrid('setFrozenColumns');


	});
    function formatterA(cellValue, options, rowObject) {
        return cellValue;
    }
	//grid resizing
	$(window).resize(function() {
		pgm_grid.setGridWidth($('.tblType1').width());
	});

	function fn_DelRow() {
		deleteRow();
	}

	// 그리드 셀 클릭 시 하단 상세정보 세팅
	function fn_detailPgmInfo(rowInfo) {
		$("#nN").val(rowInfo._NOTICE_NO);
		$("#nT").val(rowInfo._NOTICE_TITLE);
		$("#nT1").val(rowInfo._NOTICE_TITLE);
		$("#nD").val(rowInfo._NOTICE_DATE);
		$("#nC").val(rowInfo._NOTICE_CONTENT);
		$("#nW").val(rowInfo.NOTICE_WRITER);

		var btnInf = rowInfo.BTN_INF;
	}

	//조회: 내부 로직 사용자 정의
	function fn_Search() {
		$('#pgmInfoForm1').clearFormData();
		pgm_grid.retreive();
	}

	//저장: 내부 로직 사용자 정의
	function fn_Save() {

		pgm_grid.save();
	}

	function deleteRow() {
		// 행삭제
		ajax({
			url : '/baro/board/notice/saveGridNotice',
			data : $("form[name=pgmInfoForm1]").serialize(),
			async : false,
			success : function(data) {

				if (data.RESULT == "S") {
					alert("삭제되었습니다.");
					$('#pgmInfoForm1').clearFormData();
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
.inputP{
    background: none;    
    border: none;
    padding: 0 6px 0 5px;
    font-size: 12px;
    color: #666;
    box-sizing: border-box;
    font-weight: nomal;
}


</style>
</head>
<body>
	<div class="frameWrap">
		<div class="subCon">
			<%@ include file="/WEB-INF/views/pandora3/common/include/btnList.jsp"%>
			<!-- search -->
			<div class="frameTopTable">
				<form name="search" id="search" name="search" onsubmit="return false">
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
                            <label for="nT" class="vv">제목</label>
                        </th>
                        <td colspan="5">
                            <input type="text" name="_notice_title" id="nT" value="" class="inputP" style="width: 100%" readonly="readonly"/>
                        </td>
                    </tr>
                     <tr>
						<th>
					       <label for="nW" class="vv">작성자</label>
					    </th>
						<td colspan="2">
						    <input type="text" name="notice_witer" id="nW" value="" class="inputP" style="width: 380px" readonly="readonly"/>
						</td>
						<th>
						    <label for="nD" class="vv">작성일</label>
						</th>
						<td colspan="2">
						    <input type="text" name="_notice_date" id="nD" value=""readonly="readonly" class="inputP" />
						</td>
					</tr>
					<tr>
						<th>
						    <label for="nC" class="vv">내용</label>
						</th>
						<td colspan="5">
						    <textarea name="_notice_content" id="nC" class="w100" style="height: 200px;" maxlength="500" class="inputP" readonly="readonly"></textarea>
						</td>
					</tr>
				</table>
			</form>
		</div>
		<form name="frm_sysCdDtl" id="frm_sysCdDtl" onsubmit="return false;">
			<input type="hidden" name="mst_cd_arr" id="mst_cd_arr" />
		</form>
		<form id="printForm">
			<input type="hidden" id="data" name="data" /> <input type="hidden" id="filenm" name="filenm" />
		</form>
	</div>
</body>
<%@ include file="/WEB-INF/views/pandora3/common/include/footer.jsp"%>
