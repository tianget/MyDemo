$(function() {
	$('#base_manager').datagrid({
		// fit:true,
		url : "../system/getAllbase",
		height : 570,
		pagination : true,
		pageNumber : 1,
		pageSize : 5,
		rownumbers : true,
		pagination : true,
		/*checkOnSelect : false,
		singleSelect : true,
		scrollOnSelect : false,*/
		pageList : [ 5, 10, 15, 20 ],
		columns : [ [ {
			field : 'baseid',
			title : '自动编号',
			width : 100,
			checkbox : true,
		}, {
			field : 'basecoding',
			title : '关键字',
			width : 200,
			align : 'center',
		}, {
			field : 'basevalue',
			title : '参数值',
			width : 200,
			align : 'center',
		}, {
			field : 'basedesc',
			title : '参数描述',
			width : 200,
			align : 'center',
		}, {
			field : 'baseremark',
			title : '备注信息',
			width : 200,
			align : 'center',
		}, {
			field : 'basetime',
			title : '添加时间',
			width : 190,
			align : 'center',
		}, {
			field : 'tname',
			title : '添加人',
			width : 190,
			align : 'center',
		} ] ],
	});

});
function base_search() {
	$("#base_manager").datagrid('reload', {
		conteTitle : $("#base_searchTitle").val()
	});
}
function base_save() {
	$('#base_dlg').dialog('open').dialog('center').dialog('setTitle', '增加信息');
	$('#base_fm').form('clear');
};
function start_base_save() {
	$('#base_fm').form('submit', {
		url : "../system/insertBase",
		type : "post",
		onSubmit : function() {
			return $(this).form('validate');
		},
		success : function(result) {
			console.log(result);
			if (result) {
				$('#base_dlg').dialog('close');
				$.messager.alert("提示", "添加成功", "info");
				$('#base_manager').datagrid('reload');
			} else {
				$.messager.alert("提示", "添加失败", "info");
				$('#base_fm').form('clear');
			}
		}

	});
}
function delete_base() {
	var row = $('#base_manager').datagrid('getSelected');
	if (row == null) {
		$.messager.alert({
			title : '警告操作',
			msg : '<h3 style="color: red;">请先选择一条记录进行删除!</h3>',
			icon : 'warning',
		})
	}
	
	if (row) {
		$.messager.confirm('Confirm', '确定删除该信息吗?', function(r) {
			if (r) {
				$.post('../system/deleteBase', {
					baseid : row.baseid
				}, function(result) {
					if (result != "") {
						$.messager.alert("提示", "删除成功", "info");
						$('#base_manager').datagrid('reload');
					} else {
						$.messager.alert("提示", "删除失败", "info");
					}
				});
			}
		});
	}
}
function base_update() {
	var row = $('#base_manager').datagrid('getSelections');
	if (row.length == 0) {
		$.messager.alert({
			title : '警告操作',
			msg : '<h3 style="color: red;">请先选择一条记录进行修改!</h3>',
			icon : 'warning',
		})
	} else if (row.length > 1) {
		$.messager.alert({
			title : '警告操作',
			msg : '<h3 style="color: red;">只能选中一条记录修改！</h3>',
			icon : 'warning',
		})
	} else {
		var baseid = row[0].baseid;
		$.ajax({
			url : "../system/updateBaseById?baseid=" + baseid,
			type : "post",
			success : function(data) {
				$("#baseid2").val(data.baseid);
				$("#basecoding2").val(data.basecoding);
				$("#basevalue2").val(data.basevalue);
				$("#basedesc2").val(data.basedesc);
				$("#baseremark2").val(data.baseremark);

			}
		});
		$('#base_dlg2').dialog('open').dialog('center').dialog('setTitle',
				'修改基础信息');
		$('#base_fm2').form('clear');
	}
}
function base_update_start() {
	$('#base_fm2').form('submit', {
		url : "../system/updateBaseStart",
		type : "post",
		onSubmit : function() {
			return $(this).form('validate');
		},
		success : function(result) {
			console.log(result);
			if (result) {
				$('#base_dlg2').dialog('close');
				$.messager.alert("提示", "修改成功", "info");
				$('#base_manager').datagrid('reload');
			} else {
				$.messager.alert("提示", "修改失败", "info");
				$('#base_fm2').form('clear');
			}
		}

	});
}
