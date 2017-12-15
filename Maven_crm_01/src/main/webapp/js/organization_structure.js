$(function() {
	$('#organizationManage').datagrid({
		// fit:true,
		url : "../system/getAllorganization",
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
			field : 'did',
			title : '自动编号',
			width : 100,
			checkbox : true,
		}, {
			field : 'dshortname',
			title : '名称',
			width : 300,
			align : 'center',
		}, {
			field : 'ddate',
			title : '最后修改时间',
			width : 300,
			align : 'center',
		}, {
			field : 'caoName',
			title : '操作人',
			width : 290,
			align : 'center',
		}, {
			field : 'dremark',
			title : '备注说明',
			width : 290,
			align : 'center',
		// formatter : formatOper,
		} ] ],
	});

});
function org_search() {
	$("#organizationManage").datagrid('reload', {
		conteTitle : $("#searchTitle").val()
	});
}
function orgaddFirst() {
	$('#dlgOrg').dialog('open').dialog('center').dialog('setTitle', '增加部门');
	$('#orgform').form('clear');
};
$(function() {
	$.ajax({
		url : "../system/getDepartment",
		type : "post",
		success : function(data) {
			// console.log(data);
			$("#optionOrg").html("");
			var str = "";
			if (data) {
				for (var i = 0; i < data.length; i++) {
					str += "<option value='" + data[i].dnid
							+ "' name='options'>" + data[i].dshortname
							+ "</option>"
				}
			}
			$("#optionOrg").append(str);
			$("#optionOrg2").append(str);
		}
	});

});

$(function() {
	$.ajax({
		url : "../system/getDepartment",
		type : "post",
		success : function(data) {
			// console.log(data);
			$("#optionOrg2").html("");
			var str = "";
			if (data) {
				for (var i = 0; i < data.length; i++) {
					str += "<option value='" + data[i].did
							+ "' name='options'>" + data[i].dshortname
							+ "</option>"
				}
			}
			$("#optionOrg2").append(str);
		}
	});

});
function saveOrg() {
	alert($("#optionOrg").val());
	$('#orgform').form('submit', {
		url : "../system/insertDepartment",
		type : "post",
		onSubmit : function() {
			return $(this).form('validate');
		},
		success : function(result) {
			console.log(result);
			if (result) {
				$('#dlgOrg').dialog('close');
				$.messager.alert("提示", "添加成功", "info");
				$('#organizationManage').datagrid('reload');
			} else {
				$.messager.alert("提示", "添加失败", "info");
				$('#orgform').form('clear');
			}
		}

	});
};
function deletesDepartment() {
	var row = $('#organizationManage').datagrid('getSelected');
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
				$.post('../system/deleteDepartment', {
					did : row.did
				}, function(result) {
					if (result != "") {
						$.messager.alert("提示", "删除成功", "info");
						$('#organizationManage').datagrid('reload');
					} else {
						$.messager.alert("提示", "删除失败", "info");
					}
				});
			}
		});
	}
};

function updateOne() {
	var row = $('#organizationManage').datagrid('getSelections');
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

		var did = row[0].did;
		$.ajax({
			url : "../system/updateDepartmentById?did=" + did,
			type : "post",
			success : function(data) {
				console.log(data);
				$("#did2").val(data.did);
				$("#dcoding2").val(data.dcoding);
				$("#dshortname2").val(data.dshortname);
				$("#dallname2").val(data.dallname);
				$("#dintro2").val(data.dintro);
				$("#dremark2").val(data.dremark);
			}
		});
		$('#dlgOrg2').dialog('open').dialog('center')
				.dialog('setTitle', '修改角色');
		$('#orgform2').form('clear');
	}
}
function updateDe() {
	$('#orgform2').form('submit', {
		url : "../system/updateDepartment",
		type : "post",
		onSubmit : function() {
			return $(this).form('validate');
		},
		success : function(result) {
			console.log(result);
			if (result) {
				$('#dlgOrg2').dialog('close');
				$.messager.alert("提示", "修改成功", "info");
				$('#organizationManage').datagrid('reload');
			} else {
				$.messager.alert("提示", "修改失败", "info");
				$('#orgform2').form('clear');
			}
		}

	});
}
