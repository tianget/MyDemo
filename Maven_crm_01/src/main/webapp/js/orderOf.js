$(function() {
	$('#orderOf').datagrid({
		height : 470,
		pagination : true,
		pageNumber : 1,
		pageSize : 2,
		rownumbers : true,
		pagination : true,
		checkOnSelect : false,
		singleSelect : true,
		scrollOnSelect : false,

		pageList : [ 2, 4, 6, 8, 10 ],
		url : "../order/pageList",

		columns : [ [ {
			field : 'm_id',
			width : 50,
			checkbox : true,
		}, {
			field : 'userName',
			title : '客户姓名',
			width : 120,
			align : 'center',
		}, {
			field : 'm_sex',
			title : '性别',
			width : 150,
			align : 'center',
		}, {
			field : 'm_type',
			title : '类型',
			width : 150,
			align : 'center',
		}, {
			field : 'm_status',
			title : '状态',
			width : 150,
			align : 'center',
		}, {
			field : 'num',
			title : '已消费次数',
			width : 150,
			align : 'center',
		}, {
			field : 'sum',
			title : '消费总额（单位：元）',
			width : 150,
			align : 'center',
		}, {
			field : 'sname',
			title : '服务代表',
			width : 150,
			align : 'center',
		} ] ],
	});

	/*$.ajax({
		url : "../order/testJob",
		type : "post",
	});*/

});

function reload() {
	$("#orderOf").datagrid("reload");
}

function manager_search() {
	$("#orderOf").datagrid('reload', {
		conteTitle : $("#votem").val()
	});
}

// 查看
function lookUp(url, title, method) {
	// alert("-ttt");
	var id = $("#orderOf").datagrid('getSelected');
	// alert(id.m_id)
	if (id == null) {
		$.messager.alert({
			title : '警告操作',
			msg : '<h3 style="color: red;">请先选择一位用户查看!</h3>',
			icon : 'warning',
		})
	}
	$.ajax({
		url : "../order/getAllMember",
		type : 'post',
		data : {
			"m_id" : id.m_id
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

function place() {
	// alert("---");
	var id = $("#orderOf").datagrid('getSelected');
	// alert(id.m_id);
	if (id == null) {
		$.messager.alert({
			title : '警告操作',
			msg : '<h3 style="color: red;">请先选择需要代下单的用户!</h3>',
			icon : 'warning',
		})
	}
	if (id.m_status == "流失") {
		$.messager.alert("提示", "用户已流失，不能继续下单！", "info");
	} else {
		if (id) {
			$.ajax({
				url : "../order/getAllOr",
				type : "post",
				data : {
					"m_id" : id.m_id
				},
			});

			// 更新选择的面板的新标题和内容
			var tab = $('#tabs').tabs('getSelected'); // 获取选择的面板
			$('#tabs').tabs('update', {
				tab : tab,
				options : {
					title : '下单操作',
					href : '../order/orderPlace' // 新内容的URL
				}
			});
			// 调用 'refresh' 方法更新选项卡面板的内容
			var tab = $('#tabs').tabs('getSelected'); // 获取选择的面板
			tab.panel('refresh', '../order/orderPlace');
		}
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
}
