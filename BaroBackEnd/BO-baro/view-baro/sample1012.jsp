<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- 헤더파일 include -->
<%@ include file="/WEB-INF/views/pandora3/common/include/header.jsp"%>
<script
	src="https://fastly.jsdelivr.net/npm/echarts@5.4.1/dist/echarts.min.js"></script>
<link rel="stylesheet" href="./style.css">
<script type="text/javascript">
	var pgm_grid;

	$(document).ready(function() {

		var pgm_config = {
			gridid : 'pgm_grid', // 그리드 id
			pagerid : 'pgm_grid_pager', // 그리드 페이지 id
			gridBtnYn : 'Y',
			// column info
			columns : [ {
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
					value : '<%=CodeUtil.getGridComboList("T_STATUS") %>',
				},
				width : 70,
			} ],
			editmode : true, // 그리드 editable 여부
			gridtitle : '배송신청 목록', // 그리드명
			height : 200, // 그리드 높이
			shrinkToFit : true, // true인경우 column의 width 자동조정, false인경우 정해진 width대로 구현(가로스크롤바필요시 false)
			selecturl : '/baro/transport/geTransportList', // 그리드 조회 URL
			saveurl : '/baro/member/saveStatus',
			hightlight : true,
			rownumbers : false
		};

		pgm_grid = new UxGrid(pgm_config);
		pgm_grid.init();
		pgm_grid.setGridWidth($('.tblType1').width());

		$("#pgm_grid").jqGrid('setFrozenColumns');

		$("#btn_pgm_add").click(function() {
			pgm_grid.add({
				APLY_START_DATE : $.timestampToString(new Date())
			});
		});

		$("#btn_pgm_del").click(function() {
			pgm_grid.remove();
		});

		getChartData1();
		getChartData2();
		
		pgm_grid.retreive();
	});

	//grid resizing
	$(window).resize(function() {
		pgm_grid.setGridWidth($('.tblType1').width());
	});

	// 공통코드 조회 후 selectBox 및 checkBox 데이터 세팅
	function makeData(sysCdDtlMap) {
		var index = 1;
		var spnBtn = $('#btnInfo');
		for (i = 0; i < sysCdDtlMap.length; i++) {
			if ("SYS001" == sysCdDtlMap[i].MST_CD) {
				spnBtn
						.append('<div class="tableCheck"><label class="container typeInspect">'
								+ sysCdDtlMap[i].CD_NM
								+ '<input type="checkbox" name="btnInfo"  id=btnInfo'
								+ (index)
								+ ' value="'
								+ sysCdDtlMap[i].CD
								+ '"/><span class="checkmark"></span></label></div>');
				index++;
			}
		}
	}

	//조회: 내부 로직 사용자 정의
	function fn_Search() {
		$('#pgmInfoForm1').clearFormData();
		pgm_grid.retreive();
	}

	//저장: 내부 로직 사용자 정의
	function fn_Save() {
		pgm_grid.save();
		window.location.reload();
	}

	function getChartData1() {
		ajax({
			url : '/baro/transport/chart1',
			type : 'POST',
			dataType : "json",
			success : function(data) {
				var s0 = data.c1[0].s_cnt;
				var s1 = data.c1[1].s_cnt;
				var s2 = data.c1[2].s_cnt;
				var s3 = data.c1[3].s_cnt;
				var s4 = data.c1[4].s_cnt;
				
				var dom = document.getElementById('chart-container');
				var myChart = echarts.init(dom, null, {
					renderer : 'canvas',
					useDirtyRect : false
				});
				var app = {};

				var option;

				option = {
					title : {
						text : '배송상태표',
						left : 'center'
					},
					tooltip : {
						trigger : 'item'
					},
					legend : {
						orient : 'vertical',
						left : 'left'
					},
					series : [ {
						name : '상세정보',
						type : 'pie',
						radius : '40%',
						data : [ {
							value : s0,
							name : '입금대기'
						}, {
							value : s1,
							name : '입금완료'
						}, {
							value : s2,
							name : '배송중'
						}, {
							value : s3,
							name : '배송완료'
						}, {
							value : s4,
							name : '환불'
						} ],

					} ]
				};

				if (option && typeof option === 'object') {
					myChart.setOption(option);
				}

			},
			error : function() {

			}
		})
	}
	function getChartData2() {
		ajax({
			url : '/baro/transport/chart2',
			type : 'POST',
			dataType : "json",
			success : function(data) {
				var s0 = data.c2[0].p_sum;
				var s1 = data.c2[1].p_sum;
				var s2 = data.c2[2].p_sum;
				var s3 = data.c2[3].p_sum;
				var s4 = data.c2[4].p_sum;
				
				var ref0 = data.c2[0].ref_2;
				var ref1 = data.c2[1].ref_2;
				var ref2 = data.c2[2].ref_2;
				var ref3 = data.c2[3].ref_2;
				var ref4 = data.c2[4].ref_2;
				
				var chartDom = document.getElementById('todaySales');
				var myChart = echarts.init(chartDom);
				var option;
				option = {
					title : {
						text : '항목별 매출표'
					},
					xAxis : {
						type : 'category',
						data : [ref0, ref1, ref2, ref3, ref4]
					},
					yAxis : {
						type : 'value'
					},
					series : [ {
						itemStyle : {
							color : '#6669ff'
						},
						data : [ s0, s1, s2, s3, s4 ],
						type : 'bar'
					} ]
				};
				myChart.setOption(option);

			},
			error : function() {

			}
		})
	}
</script>
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
						</tbody>
					</table>
				</form>
			</div>

			<!-- search // -->
			<!-- Grid -->
			<table id="pgm_grid"></table>
			<div id="pgm_grid_pager"></div>

			<div class="bgBorder"></div>
			<!-- Grid // -->
			<div class="tableTop" style="border-bottom: 2px solid gray;">
				<h3 class="title">Today</h3>
			</div>
			<div style="display: flex; flex-direction: row;">
				<div id="chart-container" style="width: 35%; height: 400px; overflow: hidden; margin-right: 5%; margin-top: 30px;"></div>
				<div id="todaySales" style="width: 50%; height: 400px; float: right; margin-left: 5%; margin-top: 30px;"></div>
			</div>
		</div>
	</div>
</body>


<%@ include file="/WEB-INF/views/pandora3/common/include/footer.jsp"%>
