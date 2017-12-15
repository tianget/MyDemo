$(function() {
	$("#pact_datagrid").datagrid({
		url : '../pact/getpactpage',
		width : 650,
		fit : true,
		// total:5,
		fitColumns : true,
		striped : true,
		rownumbers : true,
		pagination : true,
		pageSize : 2,
		pageList : [ 2, 5, 10, 15, 20 ],
		pageNumber : 2,
		// sortName:'slastTime',
		// sortOrder:'asc',
		toolbar : "#pact_tool",
		columns : [ [ {
			field : 'pid',
			title : '自动编号',
			width : 80,
			checkbox : true,
		}, {
			field : 'pname',
			title : '合同名称',
			width : 100,
		}, {
			field : 'ptype',
			title : '合同类型',
			width : 80,
		}, {
			field : 'pstate',
			title : '状态',
			width : 80,
		}, {
			field : 'plasttime',
			title : '最后操作时间',
			width : 100,
		}, {
			field : 'ppeople',
			title : '待处理人',
			width : 80,
		}, ] ],
	/*
	 * loadFilter:function(data){ return data; }
	 */
	});
	
	$('#pactfoundadd').dialog({
		
		width : 630,
		height : 730,
		top : 10,
		title : '合同创建',
		href : '../pact/pactfoundadd',
		modal : true,// 后面加一个不可编辑
		closed : true,// 默认情况下是关闭状态
		buttons : [ {
			text : '提交',
			handler : function() {
				if ($('#pactfoundadd').form('validate')) {
					$.ajax({
						url:"../pact/pfoundadd",
						type :"post",
						data : $('#pactfoundadd').serialize(),
						/*beforeSend : function() {
							$.messager.progress({
								text : '增加中-------',
							});
						},*/
						success : function(result) {
							$.messager.progress('close');
							if (result== true) {
								$.messager.show({
									title : '温馨提示',
									msg : '合同创建完毕',
								})
							} else {
								$.messager.alert({
									title:'温馨提示',
									msg:'合同创建失败！！！！',
								});
							}
							;
						}
					});
					// 关闭窗口
					$('#pactfoundadd').dialog('close').form('reset');
					// 刷新数据表格
					$('#pact_datagrid').datagrid('reload');
				}
			}
		}, {
			text : '取消',
			handler : function() {
				$('#pactfoundadd').dialog('close').form('reset');
			}
		} ]
	});

	$('#pactfoundupdate').dialog({
		width : 630,
		height : 730,
		top : 10,
		title : '合同修改',
		href : '../pact/pactfoundupdate',
		modal : true,// 后面加一个不可编辑
		closed : true,// 默认情况下是关闭状态
		buttons : [ {
			text : '提交',
			handler : function() {
				if ($('#pactfoundupdate').form('validate')) {
					$.ajax({
						url : "../pact/pfoundupdate",
						type : "post",
						data : $('#pactfoundupdate').serialize(),
						beforeSend : function() {
							$.messager.progress({
								text : '修改中-------',
							});
						},
						success : function(result) {
							$.messager.progress('close');
							if (result.state == true) {
								$, messager.show({
									title : '温馨提示',
									msg : '合同修改完毕',
								})
							} else {
								$.messager.alert({
									title : '合同修改失败o_o',
								});
							}
							;
						}
					});
					// 关闭窗口
					$('#pactfoundupdate').dialog('close').form('reset');
					// 刷新数据表格
					$('#pact_datagrid').datagrid('reload');
				}
			}
		}, {
			text : '取消',
			handler : function() {
				$('#pactfoundupdate').dialog('close').form('reset');
			}
		} ]
	});
	
	$('#pactfoundquery').dialog({
		width : 630,
		height : 730,
		top : 10,
		title : '合同查看',
		href : '../pact/pactfoundquery',
		modal : true,// 后面加一个不可编辑
		closed : true,// 默认情况下是关闭状态
		buttons : [ {
			text : '提交',
			handler : function() {
				if ($('#pactfoundquery').form('validate')) {
					$.ajax({
						url : "../pact/pfoundquery",
						type : "post",
						data : $('#pactfoundquery').serialize(),
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
					$('#pactfoundquery').dialog('close').form('reset');
					// 刷新数据表格
					$('#pact_datagrid').datagrid('reload');
				}
			}
		}, {
			text : '取消',
			handler : function() {
				$('#pactfoundquery').dialog('close').form('reset');
			}
		}]
	});
	
	$('#pactfoundsubmit').dialog({
		width : 630,
		height : 730,
		top : 10,
		title : '合同查看',
		href : '../pact/pactfoundsubmit',
		modal : true,// 后面加一个不可编辑
		closed : true,// 默认情况下是关闭状态
		buttons : [ {
			text : '提交',
			handler : function() {
				if ($('#pactfoundsubmit').form('validate')) {
					$.ajax({
						url : "../pact/pfoundquery",
						type : "post",
						data : $('pactfoundsubmit').serialize(),
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
					$('#pactfoundsubmit').dialog('close').form('reset');
					// 刷新数据表格
					$('#pact_datagrid').datagrid('reload');
				}
			}
		}, {
			text : '取消',
			handler : function() {
				$('#pactfoundsubmit').dialog('close').form('reset');
			}
		} ]
	});

	// 点击图标进行操作
	pact_onclick = {
		/*search : function() {
			var name = $("#pname").val();
			var type = $("#ptype").val();
			var state = $("#pstate").val();
			$('#pact_datagrid').datagrid('load', {
				pname : name,
				ptype : type,
				pstate : state
			})
		},*/
		add : function() {
			$("#pactfoundadd").dialog('open')
		},
		update : function() {
			var update = $("#pact_datagrid").datagrid('getSelected');
			if(update){
				// 关闭窗口
				//$('#pactfoundadd').dialog('close').form('reset');
				$.ajax({
					url : "../pact/pfoundupdate",
					type : "post",
					data : {pid:update.pid},
					beforeSend : function() {
						$.messager.progress({
							text : '加载中-------',
						});
					},
					success : function(result) {
						$.messager.progress('close');
						
							$("#pactfoundupdate").dialog('open');
							console.log(result)
							 $("#uname").val(result.pname);
							alert($("#uname").val())
							 $("#utype").val(result.ptype);
							alert($("#utype").val())
							 $("#upmoney").val(result.pmoney)
							 alert($("#upmoney").val())
							 $("#ujia").val(result.pjia)
							 alert($("#ujia").val())
							 $("#uyi").val(result.pyi)
							 alert($("#uyi").val())
							 $("#uoperatejia").val(result.poperatejia)
							 alert($("#uoperatejia").val())
							 $("#uoperateyi").val(result.poperateyi)
							 alert($("#uoperateyi").val())
							 $("#ucontent").val(result.pcontent)
							 alert($("#ucontent").val())
							 $("#uremarks").val(result.premarks)
							 alert($("#uremarks").val())
							 //$("#pname").val(result.pname);
						
					}
				});
			}else{
				alert("请选择一条数据进行修改！！！")
			}
		},
		query : function() {
			/*var query = $("#pact_datagrid").datagrid('getSelected');
			if(query){
				$.ajax({
					url : "../pact/pfoundupdate",
					type : "post",
					data : {pid:query.pid},
					beforeSend : function(){
						$.messager.progress({
							text : '加载中--------',
						});
					},
					success : function(result){
						$.messager.progress('close');
						$("#pactfoundquery").dialog('open')
					}
				});
			}else{
				alert("请选择一条数据进行查看！！！")
			}*/
		},
		submit : function() {
			var submit = $("#pact_datagrid").datagrid('getSelected')
			if(submit){
				$("#pactfoundsubmit").dialog('open')
			}else{
				alert("请选择一条你要提交的数据！！！")
			}
		}
	};
	
	

});