<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- 헤더파일 include -->
<%@ include file="/WEB-INF/views/pandora3/common/include/header.jsp"%>
<script type="text/javascript">
	var code_master_grid;
	var code_detail_grid;
	var target_row = null;


	$(document).ready(
			function() {
				var up_config = {
					gridid : 'code_master_grid', // 그리드 id
					pagerid : 'code_master_grid_pager', // 그리드 페이지 id
					gridBtnYn : 'Y', // 상단 그리드 버튼 여부 ( 그리드 1개 일때 필수 'Y', 상/하단 그리드 일 경우 상단 그리드만 필수'Y' )
					// column info
					columns : [

					{
						name : 'USER_NO',
						label : '회원번호',
						align : 'center',
						width : 10
					}, {
						name : 'USER_ID',
						label : '아이디',
						align : 'center',
						width : 25
					}, {
						name : 'USER_NAME',
						label : '이름',
						align : 'center',
						width : 25
					}, {
						name : 'PHONE',
						label : '전화번호',
						align : 'center',
						width : 30
					}, {
                        name : 'USER_DATE',
                        label : '회원가입일',
                        align : 'center',
                        width : 20
                    }, {
                        name : 'USER_MODIFYDATE',
                        label : '회원정보 변경일',
                        align : 'center',
                        width : 20
                    } ],
					initval : {
						US_YN : 'N',
						SRT_SEQ : 999,
						MST_CD : 'A00'
					}, // 컬럼 add 시 초기값
					editmode : true, // 그리드 editable 여부
					gridtitle : '회원정보', // 그리드명
					formid : 'search', // 조회조건 form id
					height : 200, // 그리드 높이
					rownumbers : false,
					selecturl : '/baro/member/getmemberList', // 그리드 조회 URL
					events : {
						ondblClickRow : function(event, rowid) {
							var row = code_master_grid.getRowData(rowid);
							if (isNotEmpty(row.USER_NO)) {
								target_row = row;
								code_detail_grid.retreive({
									data : {
										user_no : row.USER_NO
									}
								});
							}
						},
						onCellSelect : function(event, rowid, icol) { // 해당 셀 선택시
							var row = code_master_grid.getRowData(rowid);


						},
						onSelectRow : function(event, rowid, status, e) {
							var row = code_master_grid.getRowData(rowid);

						}
					}
				};

				var down_config = {
					gridid : 'code_detail_grid', // 그리드 id
					pagerid : 'code_detail_grid_pager', // 그리드 페이지 id
					// column info
					columns : [
					{
						name : 'TRANSPORT_NO',
						label : '배송번호',
						align : 'center',
						width : 40
					}, {
						name : 'USER_NAME',
						label : '보내시는 분',
						align : 'center',
						width : 50
					}, {
						name : 'DEPARTURE',
						label : '출발지',
						align : 'left',
						width : 250
					}, {
						name : 'PRICE',
						label : '가격',
						align : 'center',
						width : 70,
		                formatter: function fu_price(cellValue, options, rowObject){
		                    let result = cellValue.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ',');
		                    return result +'원';
		                }
					}, {
						name : 'RECIPIENT',
						label : '받는 분',
						align : 'center',
						width : 40
					}, {
						name : 'DESTINATION',
						label : '도착지',
						align : 'left',
						width : 250
					}, {
						name : 'TRANSPORT_DATE',
						label : '신청일자',
						align : 'center',
						width : 80
					}, {
						name : 'CD',
						label : '배송상태',
						align : 'center',
						editable : true,
						edittype : 'select',
						formatter : 'select',
						editoptions : {
							value : '<%=CodeUtil.getGridComboList("T_STATUS")%>'
										},
										width : 70,
									} ],
							editmode : true, // 그리드 editable 여부
							gridtitle : '회원별 배송정보', // 그리드명
							height : 200, // 그리드 높이
							shrinkToFit : true, // true인경우 column의 width 자동조정, false인경우 정해진 width대로 구현(가로스크롤바필요시 false)
							selecturl : '/baro/member/memberTransport', // 그리드 조회 URL 
							saveurl : '/baro/member/saveStatus', // 그리드 입력/수정/삭제 URL
							rownumbers : false
						};

						code_master_grid = new UxGrid(up_config);
						code_master_grid.init();

						code_detail_grid = new UxGrid(down_config);
						code_detail_grid.init();

						code_master_grid.setGridWidth($('.tblType1').width());
						code_detail_grid.setGridWidth($('.tblType1').width());

						$("#cb_code_master_grid").css("display", "none");

						// 상세 저장 버튼 클릭 시
						$("#btn_code_detail_save").click(function() {
							var rowid = code_detail_grid.getSelectRowIDs();
							var row = code_detail_grid.getRowData(rowid);

							code_detail_grid.save();
						});

						$("#btn_bttn_menu_add").click(function() {
							// 현재 상위 그리드에서 선택된 값 확인
							var sels = code_detail_grid.getSelectRows();
							if (sels.length == 0) {
								alert('하위 메뉴를 선택하세요');
								return;
							} else if (sels.length > 1) {
								alert('하위 메뉴 하나만 선택하세요');
								return;
							}
							// default 값 세팅
							bttn_menu_grid.add({
								MST_CD : sels[0].MST_CD
							});
						});

						$("#btn_bttn_menu_del").click(function() {
							bttn_menu_grid.remove();
						});
					});

	//grid resizing
	$(window).resize(function() {
		code_master_grid.setGridWidth($('.tblType1').width());
		code_detail_grid.setGridWidth($('.tblType1').width());
	});

	//조회: 내부 로직 사용자 정의
	function fn_Search() {
		code_master_grid.retreive(); //{success:function(){alert('retreive success');}}
		code_detail_grid.clearGridData();
		$("#code_master_grid").jqGrid('setColProp', 'MST_CD', {
			editable : false
		});
		$("#code_detail_grid").jqGrid('setColProp', 'CD2', {
			editable : false
		});
	}

	function fn_Save() {
		//jqgrid grid 데이터 json 형태로 생성
		var masterdata = getSaveData("code_master_grid"); //grid_id
		var dtldata = getSaveData("code_detail_grid"); //grid_id
		if (isEmpty(masterdata)) {
			return false;
		}
		//입력폼데이터 파라미터형태로 변경
		var formdata = $("form[name=search]").serialize();
		var data = "masterdata=" + masterdata + "&dtldata=" + dtldata
				+ "&_pre_url=" + parent.preUrl.getPreUrl() + "&" + formdata;
		ajax({
			url : '/psys/savePsys1005',
			data : data,
			async : false,
			success : function(data) {
				if (data.RESULT == "S") {
					alert('저장되었습니다');
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
</head>
<body>
	<div class="frameWrap">
		<div class="subCon">
			<%@ include file="/WEB-INF/views/pandora3/common/include/btnList.jsp"%>
			<!-- search -->
			<div class="frameTopTable">
				<form id="search" name="search" onsubmit="return false">
					<table class="tblType1 typeShort">
						<colgroup>
							<col style="width: 117px;" />
							<col style="" />
							<col style="width: 117px;" />
							<col style="" />
						</colgroup>
						<tbody>
							<tr>
								<th>회원 ID</th>
								<td>
								    <span class="txt_pw"><input type="text" name="_user_id" id="_user_id" class="text" /></span>
								</td>
								<th>회원명</th>
								<td>
								    <span class="txt_pw"><input type="text" name="_user_name" id="_user_name" class="text" /></span>
								</td>
							</tr>
						</tbody>
					</table>
				</form>
			</div>
			<div class="bgBorder"></div>
			<!-- search // -->
			<table id="code_master_grid"></table>
			<div class="bgBorder"></div>
			<div id="code_master_grid_pager"></div>
			<!-- Detail Grid -->
<!-- 			<div class="grid_right_btn" style=" margin-right: 90%"> -->
			<div class="grid_right_btn">
				<div class="grid_right_btn_in" style=" position: relative; margin-left: 100px">
					<button id="btn_code_detail_save" class="btn_common btn_default">저장</button>
				</div>
			</div>
			<table id="code_detail_grid"></table>
			<div id="code_detail_grid_pager"></div>
			<!-- Detail Grid // -->
			<br />
		</div>
	</div>
</body>
<%@ include file="/WEB-INF/views/pandora3/common/include/footer.jsp"%>
