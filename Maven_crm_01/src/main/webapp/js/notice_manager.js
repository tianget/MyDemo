$(function() {
	$('#notice_manager').datagrid({
		url : "../system/getAllnotice",
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
			field : 'noticeId',
			title : '自动编号',
			width : 100,
			checkbox : true,
		}, {
			field : 'noticeTitle',
			title : '标题',
			width : 280,
			align : 'center',
		}, {
			field : 'noticeTime',
			title : '发布时间',
			width : 300,
			align : 'center',
		}, {
			field : 'departmentName',
			title : '发布部门',
			width : 300,
			align : 'center',
		}, {
			field : 'noticeContent',
			title : '内容',
			width : 300,
			align : 'center',
		} ] ],
	});
});
function staff_search() {
	$("#notice_manager").datagrid('reload', {
		conteTitle : $("#notice_searchTitle").val()
	});
}
function refresh() {
	$('#notice_manager').datagrid('reload');
}
function notice_save() {
	$('#notice_dlg').dialog('open').dialog('center').dialog('setTitle', '发布公告');
	$('#notice_fm').form('clear');
};
$(function() {
	$.ajax({
		url : "../system/getNoticeType",
		type : "post",
		success : function(data) {
			console.log(data);
			$("#option").html("");
			$("#option2").html("");
			var str = "";
			if (data) {
				for (var i = 0; i < data.length; i++) {
					str += "<option value='" + data[i].type_id
							+ "' name='options'>" + data[i].type_text
							+ "</option>"
				}
			}
			$("#option").append(str);
			$("#option2").append(str);
		}
	});

});
function start_notice_save() {
	$('#notice_fm').form('submit', {
		url : "../system/insertNotice",
		type : "post",
		onSubmit : function() {
			return $(this).form('validate');
		},
		success : function(result) {
			console.log(result);
			if (result) {
				$('#notice_dlg').dialog('close');
				$.messager.alert("提示", "添加成功", "info");
				$('#notice_manager').datagrid('reload');
			} else {
				$.messager.alert("提示", "添加失败", "info");
				$('#notice_fm').form('clear');
			}
		}

	});
};
function delete_notice() {
	var row = $('#notice_manager').datagrid('getSelected');
	if (row == null) {
		$.messager.alert({
			title : '警告操作',
			msg : '<h3 style="color: red;">请先选择一条记录进行删除!</h3>',
			icon : 'warning',
		})
	}
	if (row) {
		$.messager.confirm('Confirm', '确定删除该公告吗?', function(r) {
			if (r) {
				$.post('../system/deleteNotice', {
					noticeId : row.noticeId
				}, function(result) {
					if (result != "") {
						$.messager.alert("提示", "删除成功", "info");
						$('#notice_manager').datagrid('reload');
					} else {
						$.messager.alert("提示", "删除失败", "info");
					}
				});
			}
		});
	}
};

function notice_dataBack() {
	$('#notice_manager').datagrid({
		// fit:true,
		url : "../system/getAllnotice",
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
			field : 'noticeId',
			title : '自动编号',
			width : 100,
			checkbox : true,
		}, {
			field : 'noticeTitle',
			title : '标题',
			width : 280,
			align : 'center',
		}, {
			field : 'noticeTime',
			title : '发布时间',
			width : 300,
			align : 'center',
		}, {
			field : 'departmentName',
			title : '发布部门',
			width : 300,
			align : 'center',
		}, {
			field : 'noticeContent',
			title : '内容',
			width : 300,
			align : 'center',
		} ] ],
	});
}
function notice_see(url, title, method) {
	var row = $('#notice_manager').datagrid('getSelections');
	if (row.length == 0) {
		$.messager.alert({
			title : '警告操作',
			msg : '<h3 style="color: red;">请先选择一条记录进行查看!</h3>',
			icon : 'warning',
		})
	} else if (row.length > 1) {
		$.messager.alert({
			title : '警告操作',
			msg : '<h3 style="color: red;">只能选中一条记录查看！</h3>',
			icon : 'warning',
		})
	} else {
		var noticeId = row[0].noticeId;
		$.ajax({
			url : "../system/noticeDetails",
			type : "post",
			data : {
				"noticeId" : noticeId
			},
		});
		var tab = $('#tabs').tabs('getSelected'); // 获取选择的面板
		$('#tabs').tabs('update', {
			tab : tab,
			options : {
				title : title,
				onLoad : function() {
					window[method]();
				}
			}
		});
		tab.panel('refresh', url);
	}
}
function back(url, title, method) {
	var tab = $('#tabs').tabs('getSelected'); // 获取选择的面板
	$('#tabs').tabs('update', {
		tab : tab,
		options : {
			title : title,
			onLoad : function() {
				window[method]();
			}
		}
	});
	tab.panel('refresh', url);
};

function notice_update() {
	var row = $('#notice_manager').datagrid('getSelections');
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
		var noticeId = row[0].noticeId;
		alert(noticeId);
		$.ajax({
			url : "../system/updateNoticeById?noticeId=" + noticeId,
			type : "post",
			success : function(data) {
				console.log(data);
				if (data) {
					$("#id3").val(data.noticeId);
					$("#name3").val(data.name);
					$("#noticeCoding3").val(data.noticeCoding);
					$("#noticeTitle3").val(data.noticeTitle);
					$("#noticeContent3").val(data.noticeContent);
				}
			}
		});
		$('#notice_dlg2').dialog('open').dialog('center').dialog('setTitle',
				'修改公告');
		$('#notice_fm2').form('clear');
	}
}
function notice_update_start() {
	$('#notice_fm2').form('submit', {
		url : "../system/updateNoticeStart",
		type : "post",
		onSubmit : function() {
			return $(this).form('validate');
		},
		success : function(result) {
			console.log(result);
			if (result) {
				$('#notice_dlg2').dialog('close');
				$.messager.alert("提示", "修改成功", "info");
				$('#notice_manager').datagrid('reload');
			} else {
				$.messager.alert("提示", "修改失败", "info");
				$('#notice_fm2').form('clear');
			}
		}

	});
}
