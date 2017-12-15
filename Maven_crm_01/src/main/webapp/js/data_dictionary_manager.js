$(function() {
	$('#data_dictionary_manager').datagrid({
		// fit:true,
		url : "../system/getAllDataDictionary",
		height : 570,
		pagination : true,
		pageNumber : 1,
		pageSize : 5,
		rownumbers : true,
		pagination : true,
		/*
		 * checkOnSelect : false, singleSelect : true, scrollOnSelect : false,
		 */
		pageList : [ 5, 10, 15, 20 ],
		columns : [ [ {
			field : 'dataid',
			title : '自动编号',
			width : 100,
			checkbox : true,
		}, {
			field : 'dataname',
			title : '名称',
			width : 200,
			align : 'center',
		}, {
			field : 'datacoding',
			title : '参数代码',
			width : 200,
			align : 'center',
		}, {
			field : 'datavalue',
			title : '数据值',
			width : 200,
			align : 'center',
		}, {
			field : 'dataremark',
			title : '备注信息',
			width : 200,
			align : 'center',
		}, {
			field : 'datatime',
			title : '最后修改时间',
			width : 190,
			align : 'center',
		}, {
			field : 'sname',
			title : '操作人',
			width : 190,
			align : 'center',
		} ] ],
	});

});
function data_dictionary_search() {
	$("#data_dictionary_manager").datagrid('reload', {
		conteTitle : $("#data_dictionary_searchTitle").val()
	});
}
function data_dictionary_save() {
	$('#data_dictionary_dlg').dialog('open').dialog('center').dialog(
			'setTitle', '增加数据字典');
	$('#data_dictionary_fm').form('clear');
}
function start_data_dictionary_save() {
	$('#data_dictionary_fm').form('submit', {
		url : "../system/insertData",
		type : "post",
		onSubmit : function() {
			return $(this).form('validate');
		},
		success : function(result) {
			console.log(result);
			if (result) {
				$('#data_dictionary_dlg').dialog('close');
				$.messager.alert("提示", "添加成功", "info");
				$('#data_dictionary_manager').datagrid('reload');
			} else {
				$.messager.alert("提示", "添加失败", "info");
				$('#data_dictionary_fm').form('clear');
			}
		}

	});
}
function delete_data_dictionary() {
	var row = $('#data_dictionary_manager').datagrid('getSelected');
	if (row == null) {
		$.messager.alert({
			title : '警告操作',
			msg : '<h3 style="color: red;">请先选择一条记录进行删除!</h3>',
			icon : 'warning',
		})
	}
	if (row == null) {
		$.messager.alert({
			title : '警告操作',
			msg : '<h3 style="color: red;">请先选择一条记录进行删除!</h3>',
			icon : 'warning',
		})
	}
	if (row) {
		$.messager.confirm('Confirm', '确定删除该数据吗?', function(r) {
			if (r) {
				$.post('../system/deleteData', {
					dataid : row.dataid
				}, function(result) {
					if (result != "") {
						$.messager.alert("提示", "删除成功", "info");
						$('#data_dictionary_manager').datagrid('reload');
					} else {
						$.messager.alert("提示", "删除失败", "info");
					}
				});
			}
		});
	}
}
function data_dictionary_update() {
	var row = $('#data_dictionary_manager').datagrid('getSelections');
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
		var dataid = row[0].dataid;
		$.ajax({
			url : "../system/updateDataById?dataid=" + dataid,
			type : "post",
			success : function(data) {
				$("#dataid2").val(data.dataid);
				$("#dataname2").val(data.dataname);
				$("#datacoding2").val(data.datacoding);
				$("#datavalue2").val(data.datavalue);
				$("#dataremark2").val(data.dataremark);
			}
		});
		$('#data_dictionary_dlg2').dialog('open').dialog('center').dialog(
				'setTitle', '修改基础信息');
		$('#data_dictionary_fm2').form('clear');
	}
}
function data_dictionary_update_start() {
	$('#data_dictionary_fm2').form('submit', {
		url : "../system/updateDataStart",
		type : "post",
		onSubmit : function() {
			return $(this).form('validate');
		},
		success : function(result) {
			console.log(result);
			if (result) {
				$('#data_dictionary_dlg2').dialog('close');
				$.messager.alert("提示", "修改成功", "info");
				$('#data_dictionary_manager').datagrid('reload');
			} else {
				$.messager.alert("提示", "修改失败", "info");
				$('#data_dictionary_fm2').form('clear');
			}
		}

	});
}
