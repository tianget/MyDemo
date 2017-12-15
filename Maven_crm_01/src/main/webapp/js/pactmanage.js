/**
 * 
 */
$(function(){
	$("#pactmanage_datagrid").datagrid({
		url:"../pact/getpactpage",
		method:"POST",
		width:650,
		fit:true,
		total:5,
		fitColumns:true,
		straiped:true,
		rownumbers:true,
		pagination:true,
		pageSize:2,
		pageList:[2,5,10,15,20],
		pageNumber:2,
		sortName:'slastTime',
		sortOrder:'asc',
		toolbar:'#pactmanage_tool',
		columns:[[
				{
					field:'pid',
					title:'自动编号',
					width:80,
					checkbox:true,
				},
				{
					field:'pname',
					title:'合同名称',
					width:100,
				},
				{
					field:'ptype',
					title:'合同类型',
					width:80,
				},	
				{
					field:'pstate',
					title:'状态',
					width:80,
				},
				{
					field:'plasttime',
					title:'最后操作时间',
					width:100,
				},
				{
					field:'ppeople',
					title:'待处理人',
					width:80,
				},
		]],
		loadFilter:function(data){
				return data;
		} 
	});
	
	$('#pactmanagequery').dialog({
		width : 630,
		height : 730,
		top : 10,
		title : '合同查看',
		href : '../pact/pactmanagequery',
		modal : true,// 后面加一个不可编辑
		closed : true,// 默认情况下是关闭状态
		buttons : [ {
			text : '提交',
			handler : function() {
				if ($('#pactmanagequery').form('validate')) {
					$.ajax({
						url : "../pact/pmanagequery",
						type : "post",
						data : $('#pactmanagequery').serialize(),
						beforeSend : function() {
							$.messager.progress({
								text : '查询中-------',
							});
						},
						success : function(result) {
							$.messager.progress('close');
							if (result.state == true) {
								$, messager.show({
									title : '温馨提示',
									msg : '合同查询完毕',
								})
							} else {
								$.messager.alert({
									title : '合同查询失败o_o',
								});
							}
							;
						}
					});
					// 关闭窗口
					$('#pactmanagequery').dialog('close').form('reset');
					// 刷新数据表格
					$('#pactmanage_datagrid').datagrid('reload');
				}
			}
		}, {
			text : '取消',
			handler : function() {
				$('#pactmanagequery').dialog('close').form('reset');
			}
		}]
	});
	
	$('#pactexecute').dialog({
		width : 630,
		height : 730,
		top : 10,
		title : '合同查看',
		href : '../pact/pactmanageexecute',
		modal : true,// 后面加一个不可编辑
		closed : true,// 默认情况下是关闭状态
		buttons : [ {
			text : '提交',
			handler : function() {
				if ($('#pactexecute').form('validate')) {
					$.ajax({
						url : "../pact/pmanageexecute",
						type : "post",
						data : $('pactexecute').serialize(),
						beforeSend : function() {
							$.messager.progress({
								text : '查询中-------',
							});
						},
						success : function(result) {
							$.messager.progress('close');
							if (result.state == true) {
								$, messager.show({
									title : '温馨提示',
									msg : '合同查询完毕',
								})
							} else {
								$.messager.alert({
									title : '合同查询失败o_o',
								});
							}
							;
						}
					});
					// 关闭窗口
					$('#pactexecute').dialog('close').form('reset');
					// 刷新数据表格
					$('#pactmanage_datagrid').datagrid('reload');
				}
			}
		}, {
			text : '取消',
			handler : function() {
				$('#pactexecute').dialog('close').form('reset');
			}
		} ]
	});
	
	$('#pactchange').dialog({
		width : 630,
		height : 730,
		top : 10,
		title : '合同查看',
		href : '../pact/pactmanagechange',
		modal : true,// 后面加一个不可编辑
		closed : true,// 默认情况下是关闭状态
		buttons : [ {
			text : '提交',
			handler : function() {
				if ($('#pactchange').form('validate')) {
					$.ajax({
						url : "../pact/pmanagechange",
						type : "post",
						data : $('pactchange').serialize(),
						beforeSend : function() {
							$.messager.progress({
								text : '查询中-------',
							});
						},
						success : function(result) {
							$.messager.progress('close');
							if (result.state == true) {
								$, messager.show({
									title : '温馨提示',
									msg : '合同查询完毕',
								})
							} else {
								$.messager.alert({
									title : '合同查询失败o_o',
								});
							};
						}
					});
					// 关闭窗口
					$('#pactchange').dialog('close').form('reset');
					// 刷新数据表格
					$('#pactmanage_datagrid').datagrid('reload');
				}
			}
		}, {
			text : '取消',
			handler : function() {
				$('#pactchange').dialog('close').form('reset');
			}
		} ]
	});
	
	$('#pactassignment').dialog({
		width : 630,
		height : 730,
		top : 10,
		title : '合同查看',
		href : '../pact/pactmanageassignment',
		modal : true,// 后面加一个不可编辑
		closed : true,// 默认情况下是关闭状态
		buttons : [ {
			text : '提交',
			handler : function() {
				if ($('#pactassignment').form('validate')) {
					$.ajax({
						url : "../pact/pmanageassignment",
						type : "post",
						data : $('pactchange').serialize(),
						beforeSend : function() {
							$.messager.progress({
								text : '查询中-------',
							});
						},
						success : function(result) {
							$.messager.progress('close');
							if (result.state == true) {
								$, messager.show({
									title : '温馨提示',
									msg : '合同查询完毕',
								})
							} else {
								$.messager.alert({
									title : '合同查询失败o_o',
								});
							}
							;
						}
					});
					// 关闭窗口
					$('#pactassignment').dialog('close').form('reset');
					// 刷新数据表格
					$('#pactmanage_datagrid').datagrid('reload');
				}
			}
		}, {
			text : '取消',
			handler : function() {
				$('#pactassignment').dialog('close').form('reset');
			}
		} ]
	});
	
	$('#pactremove').dialog({
		width : 630,
		height : 730,
		top : 10,
		title : '合同查看',
		href : '../pact/pactmanageremove',
		modal : true,// 后面加一个不可编辑
		closed : true,// 默认情况下是关闭状态
		buttons : [ {
			text : '提交',
			handler : function() {
				if ($('#pactremove').form('validate')) {
					$.ajax({
						url : "../pact/pmanageremove",
						type : "post",
						data : $('pactremove').serialize(),
						beforeSend : function() {
							$.messager.progress({
								text : '查询中-------',
							});
						},
						success : function(result) {
							$.messager.progress('close');
							if (result.state == true) {
								$, messager.show({
									title : '温馨提示',
									msg : '合同查询完毕',
								})
							} else {
								$.messager.alert({
									title : '合同查询失败o_o',
								});
							}
							;
						}
					});
					// 关闭窗口
					$('#pactremove').dialog('close').form('reset');
					// 刷新数据表格
					$('#pactmanage_datagrid').datagrid('reload');
				}
			}
		}, {
			text : '取消',
			handler : function() {
				$('#pactremove').dialog('close').form('reset');
			}
		} ]
	});
	
	//点击图标进行操作
	pact_onclick={
			search:function(){
				var name=$("#manage_pname").val();
				var type=$("#manage_ptype").val();
				$('#pactmanage_datagrid').datagrid('load',{
					pname:name,
					ptype:type,
				})
			},	
			query : function() {
				var query = $("#pactmanage_datagrid").datagrid('getSelected');
				if(query){
					$.ajax({
						url : "../pact/pmanagequery",
						type : "post",
						data : {pid:query.pid},
						beforeSend : function(){
							$.messager.progress({
								text : '加载中--------',
							});
						},
						success : function(result){
							$.messager.progress('close');
							$("#pactmanagequery").dialog('open')
						}
					});
				}else{
					alert("请选择一条数据进行查看！！！")
				}
			},
			execute : function() {
				$("#pactexecute").dialog('open')
			},
			change : function() {
				$("#pactchange").dialog('open')
			},
			remove : function() {
				$("#pactremove").dialog('open')
			}
		};
});