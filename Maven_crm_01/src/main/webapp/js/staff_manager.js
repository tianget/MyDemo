$(function() {
	$('#staff_manager').datagrid({
		// fit:true,
		url : "../system/getAllStaff",
		height : 570,
		pagination : true,
		pageNumber : 1,
		pageSize : 10,
		rownumbers : true,
		pagination : true,
		/*
		 * checkOnSelect : false, singleSelect : true, scrollOnSelect : false,
		 */
		pageList : [ 10, 20, 30, 40 ],
		columns : [ [ {
			field : 'rid',
			title : '自动编号',
			width : 100,
			checkbox : true,
		}, {
			field : 'name',
			title : '员工姓名',
			width : 170,
			align : 'center',
		}, {
			field : 'sex',
			title : '性别',
			width : 170,
			align : 'center',
		}, {
			field : 'departmentName',
			title : '所在部门',
			width : 170,
			align : 'center',
		}, {
			field : 'jName',
			title : '角色',
			width : 170,
			align : 'center',
		}, {
			field : 'sstate',
			title : '状态',
			width : 160,
			align : 'center',
		// formatter : formatOper,
		}, {
			field : 'sdate',
			title : '最后修改时间',
			width : 160,
			align : 'center',

		}, {
			field : 'caoName',
			title : '操作人',
			width : 160,
			align : 'center',

		} ] ],
	});

});
function dataBack() {
	$('#staff_manager').datagrid({
		// fit:true,
		url : "../system/getAllStaff",
		height : 570,
		pagination : true,
		pageNumber : 1,
		pageSize : 5,
		rownumbers : true,
		pagination : true,
		checkOnSelect : false,
		singleSelect : true,
		scrollOnSelect : false,
		pageList : [ 5, 10, 15, 20 ],
		columns : [ [ {
			field : 'rid',
			title : '自动编号',
			width : 100,
			checkbox : true,
		}, {
			field : 'name',
			title : '员工姓名',
			width : 170,
			align : 'center',
		}, {
			field : 'sex',
			title : '性别',
			width : 170,
			align : 'center',
		}, {
			field : 'departmentName',
			title : '所在部门',
			width : 170,
			align : 'center',
		}, {
			field : 'jName',
			title : '角色',
			width : 170,
			align : 'center',
		}, {
			field : 'sstate',
			title : '状态',
			width : 160,
			align : 'center',
		// formatter : formatOper,
		}, {
			field : 'sdate',
			title : '最后修改时间',
			width : 160,
			align : 'center',

		}, {
			field : 'caoName',
			title : '操作人',
			width : 160,
			align : 'center',

		} ] ],
	});

};
$(function() {
	$.ajax({
		url : "../system/getDepartment",
		type : "post",
		success : function(data) {
			// console.log(data);
			$("#staff_option").html("");
			$("#staff_option2").html("");
			var str = "";
			if (data) {
				for (var i = 0; i < data.length; i++) {
					str += "<option value='" + data[i].did
							+ "' name='options'>" + data[i].dshortname
							+ "</option>"
				}
			}
			$("#staff_option").append(str);
			$("#staff_option2").append(str);
		}
	});

});
function staff_search() {
	$("#staff_manager").datagrid('reload', {
		conteTitle : $("#staff_searchTitle").val()
	});
}
function newSave() {
	$('#staff_dlg').dialog('open').dialog('center').dialog('setTitle', '增加员工');
	$('#staff_fm').form('clear');
};
function staff_newUpdate() {
	var row = $('#staff_manager').datagrid('getSelections');
	if (row.length==0) {
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
		var sid = row[0].sid;
		$.ajax({
			url : "../system/updateStaffById?sid=" + sid,
			type : "post",
			success : function(data) {
				console.log(data);
				$("#sid2").val(data.sid);
				$("#name2").val(data.name);
				$("#iphonenumber2").val(data.iphonenumber)
				$("#sremark2").val(data.sremark);
				if (data.sex == '男') {
					$("input[name='sex']").eq(0).attr("checked", "checked");
					// $("#sexFirst").attr("checked",true);
				} else {
					$("input[name='sex']").eq(1).attr("checked", "checked");
				}
				/*
				 * $("#rid2").val(data.rid); $("#rcoding2").val(data.rcoding);
				 * $("#rname2").val(data.rname);
				 * $("#option2").val(data.departmentName);
				 * $("#rremark2").val(data.rremark);
				 */
			}
		});
		$('#staff_dlg2').dialog('open').dialog('center').dialog('setTitle',
				'修改员工');
		$('#staff_fm2').form('clear');

		/*
		 * * $('#dlg2').dialog({ title:"修改角色", closed:true, modal:true,
		 * center:none, buttons:[{ text:'修改', iconCls:'icon-edit',
		 * handler:function(){ $.ajax({ url : '../system/getDepartment',
		 * type="post", data:{"rid":rid}, success:function(){ } }) } }] });
		 */
	}
}
function staff_update() {
	$('#staff_fm2').form('submit', {
		url : "../system/updateStaffStart",
		type : "post",
		onSubmit : function() {
			return $(this).form('validate');
		},
		success : function(result) {
			// console.log(result);
			if (result) {
				$('#staff_dlg2').dialog('close');
				$.messager.alert("提示", "修改成功", "info");
				$('#staff_manager').datagrid('reload');
			} else {
				$.messager.alert("提示", "修改失败", "info");
				$('#staff_fm2').form('clear');
			}
		}

	});
}
function save() {
	$('#staff_fm').form('submit', {
		url : "../system/insertAllStaff",
		type : "post",
		onSubmit : function() {
			return $(this).form('validate');
		},
		success : function(result) {
			// console.log(result);
			if (result) {
				$('#staff_dlg').dialog('close');
				$.messager.alert("提示", "添加成功", "info");
				$('#staff_manager').datagrid('reload');
			} else {
				$.messager.alert("提示", "添加失败", "info");
				$('#staff_fm').form('clear');
			}
		}

	});
};
function delete_staff() {
	var row = $('#staff_manager').datagrid('getSelected');
	if (row == null) {
		$.messager.alert({
			title : '警告操作',
			msg : '<h3 style="color: red;">请先选择一条记录进行删除!</h3>',
			icon : 'warning',
		})
	}

	if (row) {
		$.messager.confirm('Confirm', '确定删除该角色吗?', function(r) {
			if (r) {
				$.post('../system/deleteStaff', {
					sid : row.sid
				}, function(result) {
					if (result != "") {
						$.messager.alert("提示", "删除成功", "info");
						$('#staff_manager').datagrid('reload');
					} else {
						$.messager.alert("提示", "删除失败", "info");
					}
				});
			}
		});
	}
};
function refresh() {
	$('#staff_manager').datagrid('reload');
}

function see(url, title, method) {
	var row = $('#staff_manager').datagrid('getSelections');
	if (row.length==0) {
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
		var sid = row[0].sid;
		$.ajax({
			url : "../system/staffDetails",
			type : "post",
			data : {
				"sid" : sid
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
function impowerRole(url, title, method) {
	var row = $('#staff_manager').datagrid('getSelections');
	if (row.length==0) {
		$.messager.alert({
			title : '警告操作',
			msg : '<h3 style="color: red;">请先选择一条记录进行授权看!</h3>',
			icon : 'warning',
		})
	} else if (row.length > 1) {
		$.messager.alert({
			title : '警告操作',
			msg : '<h3 style="color: red;">只能选中一条记录授权！</h3>',
			icon : 'warning',
		})
	}else{
	var sid = row[0].sid;
	// alert(sid);
	$.ajax({
		url : "../system/staffDetails",
		type : "post",
		data : {
			"sid" : sid
		}
	})
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
};
$(function() {
	$('#rolePlace_manager').datagrid({
		// fit:true,
		url : "../system/getAllRole",
		height : 330,
		pagination : true,
		pageNumber : 1,
		pageSize : 5,
		rownumbers : true,
		pagination : true,
		checkOnSelect : false,
		singleSelect : true,
		scrollOnSelect : false,
		pageList : [ 5, 10, 15, 20 ],
		columns : [ [ {
			field : 'rid',
			title : '自动编号',
			width : 100,
			checkbox : true,
		}, {
			field : 'rname',
			title : '角色名称',
			width : 240,
			align : 'center',
		}, {
			field : 'departmentName',
			title : '所属部门',
			width : 240,
			align : 'center',
		}, {
			field : 'rdate',
			title : '最后修改时间',
			width : 240,
			align : 'center',
		}, {
			field : 'caozuoName',
			title : '操作人',
			width : 240,
			align : 'center',
		}, {
			field : 'rremark',
			title : '备注说明',
			width : 220,
			align : 'center',
		// formatter : formatOper,
		} ] ],
	});

});
function impowerPlace() {
	var row = $('#rolePlace_manager').datagrid('getSelected');
	if (row == null) {
		$.messager.alert({
			title : '警告操作',
			msg : '<h3 style="color: red;">请先选择一条记录进行授权!</h3>',
			icon : 'warning',
		})
	}
	if (row.length > 1) {
		$.messager.alert({
			title : '警告操作',
			msg : '<h3 style="color: red;">只能选中一条记录授权！</h3>',
			icon : 'warning',
		})
	}
	var rid = row.rid;
	// alert(rid);
	$.ajax({
		url : "../system/staffImpowerPlace",
		type : "post",
		data : {
			"rid" : rid
		},
		success : function(data) {
			$.messager.alert('温馨提示', '授权成功!');
		}
	});

}
