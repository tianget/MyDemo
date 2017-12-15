$(function() {
	
	var flag;
	$('#Goods').datagrid({
		url : '../goods/pageGoodsList',
		rownumbers : true,
		fitColumns : true,
		toolbar : '#go',
		pagination : true,
		pageNumber : 1,
		pageSize : 3,
		pageList : [ 3, 5, 7, 9 ],	
		
		columns : [ [ {
			field : 'gid',
			width : 50,
			checkbox : true,
		}, {
			field : 'gname',
			title : '商品名称',
			width : 150,
			align : 'center',
		}, {
			field : 'gtype',
			title : '商品型号',
			width : 150,
			align : 'center',
		}, {
			field : 'gprice',
			title : '单价（元）',
			width : 150,
			align : 'center',
		}, {
			field : 'gstock',
			title : '商品库存',
			width : 300,
			align : 'center',
		}, ] ],
		
	});
});

function refresh() {
	$('#Goods').datagrid('reload');
}

function newEqument() {
	$('#dlg').dialog('open').dialog('center').dialog('setTitle', '增加商品');
	$('#fm').form('clear');
}

function destroyEqument() {
	var row = $('#Goods').datagrid('getSelected');
	if (row) {
		$.messager.confirm('Confirm', '确定删除设备吗?', function(r) {			
			if (r) {
				$.post('../goods/deleteGoods', {
					gid : row.gid
				}, function(result) {					
					if (result !="") {
						$.messager.alert("提示", "删除成功", "info");
						$('#Goods').datagrid('reload');
					} else {
						$.messager.alert("提示", "删除失败", "info");
					}
				});
			}
		});
	}
}

function saveEqument() {
	$('#fm').form('submit', {
		url : "../goods/insertGoods",
		type : "post",

		onSubmit : function() {
			return $(this).form('validate');
		},
		success : function(result) {
			if (result) {
				$('#dlg').dialog('close');
				$.messager.alert("提示", "添加成功", "info");
				$('#Goods').datagrid('reload');

			} else {
				$.messager.alert("提示", "添加失败", "info");
				$('#fm').form('clear');
			}
		}
	});
}
