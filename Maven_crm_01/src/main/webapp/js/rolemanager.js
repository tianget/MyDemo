$(function() {
	$('#roleManager').datagrid({
		// fit:true,
		url : "../system/getAllRole",
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
function manager_search() {
	$("#roleManager").datagrid('reload', {
		conteTitle : $("#searchTitle").val()
	});
}
function refresh() {
	$("#roleManager").datagrid("reload");
};
function newEqument() {
	$('#dlg').dialog('open').dialog('center').dialog('setTitle', '增加角色');
	$('#fm').form('clear');
};
function newUpdate() {
	var row = $('#roleManager').datagrid('getSelections');
	if (row.length == 0) {
		$.messager.alert({
			title : '警告操作',
			msg : '<h3 style="color: red;">请先选择一条记录进行修改!</h3>',
			icon : 'warning',
		})
	} else if (row.length > 1) {
		$.messager.alert({
			title : '警告操作',
			msg : '<h3 style="color: red;">只能选中一条记录据修改！</h3>',
			icon : 'warning',
		})
	} else {

		var rid = row[0].rid;
		$.ajax({
			url : "../system/updateRoleById?rid=" + rid,
			type : "post",
			success : function(data) {
				console.log(data);
				$("#rid2").val(data.rid);
				$("#rcoding2").val(data.rcoding);
				$("#rname2").val(data.rname);
				$("#option2").val(data.departmentName);
				$("#rremark2").val(data.rremark);

			}
		});
		$('#role_dlg2').dialog('open').dialog('center').dialog('setTitle',
				'修改角色');
		$('#role_fm2').form('clear');

		/*
		 * * $('#dlg2').dialog({ title:"修改角色", closed:true, modal:true,
		 * center:none, buttons:[{ text:'修改', iconCls:'icon-edit',
		 * handler:function(){ $.ajax({ url : '../system/getDepartment',
		 * type="post", data:{"rid":rid}, success:function(){ } }) } }] });
		 */
	}
}
function newImpower() {
	var row = $('#roleManager').datagrid('getSelections');
	if (row.length == 0) {
		$.messager.alert({
			title : '警告操作',
			msg : '<h3 style="color: red;">请先选择一条记录进行授权!</h3>',
			icon : 'warning',
		})
	} else if (row.length > 1) {
		$.messager.alert({
			title : '警告操作',
			msg : '<h3 style="color: red;">只能选中一条记录修改！</h3>',
			icon : 'warning',
		})
	} else {
		var rid = row[0].rid;
		$.ajax({
			url : "../system/newInpower?rid=" + rid,
			type : "post",
			success : function(data) {

			}
		})
		$("#navDiv").dialog('open').dialog('center').dialog('setTitle', '授权角色');
		// var nodes=$("#impowerNav").tree().getChecked();

		$('#fm3').form('clear');
	}
}
$(function() {
	$.ajax({
		url : "../system/getDepartment",
		type : "post",
		success : function(data) {
			// console.log(data);
			$("#role_option").html("");
			$("#role_option2").html("");
			var str = "";
			if (data) {
				for (var i = 0; i < data.length; i++) {
					str += "<option value='" + data[i].did
							+ "' name='options'>" + data[i].dshortname
							+ "</option>"
				}
			}
			$("#role_option").append(str);
			$("#role_option2").append(str);
		}
	});

});
function save() {
	$('#fm').form('submit', {
		url : "../system/insertRole",
		type : "post",
		onSubmit : function() {
			return $(this).form('validate');
		},
		success : function(result) {
			console.log(result);
			if (result) {
				$('#dlg').dialog('close');
				$.messager.alert("提示", "添加成功", "info");
				$('#roleManager').datagrid('reload');
			} else {
				$.messager.alert("提示", "添加失败", "info");
				$('#fm').form('clear');
			}
		}

	});
};
function updatRole() {
	$('#role_fm2').form('submit', {
		url : "../system/update",
		type : "post",
		onSubmit : function() {
			return $(this).form('validate');
		},
		success : function(result) {
			console.log(result);
			if (result) {
				$('#role_dlg2').dialog('close');
				$.messager.alert("提示", "修改成功", "info");
				$('#roleManager').datagrid('reload');
			} else {
				$.messager.alert("提示", "修改失败", "info");
				$('#role_fm2').form('clear');
			}
		}

	});
}
// 授权之前查询树形菜单
$(function() {
	$("#impowerNav").tree({
		url : '../system/powerImpowerList',
		animate : true,
		lines : true,
		checkbox : true,
		cascadeCheck : true,
		onlyLeafCheck : false,
		onLoadSuccess : function(node, data) {
			console.log(data);
			if (data) {
				$(data).each(function(index, value) {
					if (this.state == "closed" && this.nid == 0) {
						$("#impowerNav").tree("expandAll");
					}
				});
			}
		},
	});
	$("#tabs").tabs({
		fit : true,
		border : false,
	});
});
// 授权
function impower() {
	var nodes = $('#impowerNav').tree('getChecked',
			[ 'indeterminate', 'checked' ]);
	// alert(nodes.id);
	
	var str = "";
	for (var i = 0; i < nodes.length; i++) {
		// console.log(nodes[i].id);
		str += "," + nodes[i].id
	}
	$.ajax({
		url : "../system/impowerStart",
		type : "post",
		data : {
			"str" : "1" + str
		},
		success : function(result) {
			if (result) {
				$('#navDiv').dialog('close');
				$.messager.alert("提示", "授权成功", "info");
				$('#roleManager').datagrid('reload');
			} else {
				$.messager.alert("提示", "授权失败", "info");
				$('#fm3').form('clear');
			}
		}
	});
	/*
	 * $('#fm3').form('submit', { url : "../system/impowerStart", type : "post",
	 * onSubmit : function() { return $(this).form('validate'); }, success :
	 * function(result) { if (result) { $('#dlg2').dialog('close');
	 * $.messager.alert("提示", "修改成功", "info");
	 * $('#roleManager').datagrid('reload'); } else { $.messager.alert("提示",
	 * "修改失败", "info"); $('#fm2').form('clear'); } }
	 * 
	 * });
	 */
	/*
	 * console.log(str); console.log(nodes);
	 */
};

function deletes() {
	var row = $('#roleManager').datagrid('getSelected');
	if (row == null) {
		$.messager.alert({
			title : '警告操作',
			msg : '<h3 style="color: red;">请先选择一条记录进行删除!</h3>',
			icon : 'warning',
		})
	}
	if (row.length > 1) {
		$.messager.alert({
			title : '警告操作',
			msg : '<h3 style="color: red;">只能选中一条记录删除！</h3>',
			icon : 'warning',
		})
	}
	if (row) {
		$.messager.confirm('Confirm', '确定删除该角色吗?', function(r) {
			if (r) {
				$.post('../system/deleteRole', {
					rid : row.rid
				}, function(result) {
					if (result != "") {
						$.messager.alert("提示", "删除成功", "info");
						$('#roleManager').datagrid('reload');
					} else {
						$.messager.alert("提示", "删除失败", "info");
					}
				});
			}
		});
	}
};

/*
 * function place(){ //更新选择的面板的新标题和内容 var tab = $('#tabs').tabs('getSelected');
 * var row = $('#roleManager').datagrid('getSelected'); var rid = row.rid; //
 * 获取选择的面板 alert(rid); $('#tabs').tabs('update', { tab: tab, options: { title:
 * '修改角色', href: '../system/updateRoleById', // 新内容的URL } }); // 调用 'refresh'
 * 方法更新选项卡面板的内容 var tab = $('#tabs').tabs('getSelected'); // 获取选择的面板
 * tab.panel('refresh', '../system/updateRoleById');
 * 
 *  }
 */

/*
 * function update(){ var row = $('#roleManager').datagrid('getSelected');
 * alert(row.rid); if (row) { $.messager.confirm('Confirm', '确定修改该角色吗?',
 * function(r) { if (r) { $.post('../system/updateRoleById', { rid : row.rid },
 * function(result) { console.log(result); if (result !="") { } else { } }); }
 * }); } };
 */
/*
 * function place(){ //更新选择的面板的新标题和内容 var tab = $('#tabs').tabs('getSelected'); //
 * 获取选择的面板 $('#tabs').tabs('update', { tab: tab, options: { title: '角色增加', href:
 * '../system/role_add' // 新内容的URL } }); // 调用 'refresh' 方法更新选项卡面板的内容 var tab =
 * $('#tabs').tabs('getSelected'); // 获取选择的面板 tab.panel('refresh',
 * '../system/role_add'); }
 */

