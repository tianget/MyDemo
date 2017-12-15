$(function() {
	$('#orderStatistics').datagrid({		
		height : 470,
		pagination : true,
		pageNumber : 1,
		pageSize : 5,
		rownumbers : true,
		pagination : true,
		checkOnSelect : false,
		singleSelect : true,
		scrollOnSelect : false,
		pageList : [ 5, 10, 15, 20],
		url : "../order/getBaseSta",

		columns : [ [ {
			field : 'tim',
			title : '月份',
			width : 120,
			align : 'center',
		},{
			field : 'count',
			title : '订单数量',
			width : 150,
			align : 'center',
		}, {
			field : 'sumr',
			title : '总金额(元)',
			width : 150,
			align : 'center',
		}, {
			field : 'bas',
			title : '本月目标(元)',
			width : 150,
			align : 'center',
		}, {
			field : 'finish',
			title : '完成率/%',
			width : 400,
			align : 'center',
			formatter : function(row,value,index){				
				return value.finish+ '%';
			}
		} ] ],
	});
	

});


function manager_begin(){
	$("#orderStatistics").datagrid('reload',{		
		conteTitle:$("#begin_r").val()
	});
	
}

function reload(){
	$("#orderStatistics").datagrid("reload");
}
