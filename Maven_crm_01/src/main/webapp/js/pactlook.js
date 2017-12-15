/**
 * 
 */
$(function() {
	$("#pactlook_datagrid").datagrid({
		url : "../pact/getpactpage",
		method : "POST",
		width : 650,
		fit : true,
		total : 5,
		fitColumns : true,
		straiped : true,
		singleSelect:true,
		rownumbers : true,
		pagination : true,
		pageSize : 2,
		pageList : [ 2, 5, 10, 15, 20 ],
		pageNumber : 2,
		/*
		 * sortName:'slastTime', sortOrder:'asc',
		 */
		toolbar : '#pactlook_tool',
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
		loadFilter : function(data) {
			return data;
		}
	});
	
	$('#pactlookquery').dialog({
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
				if ($('#pactlookquery').form('validate')) {
					$.ajax({
						url : "../pact/pfoundquery",
						type : "post",
						data : $('pactlookquery').serialize(),
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
					$('#pactlookquery').dialog('close').form('reset');
					// 刷新数据表格
					$('#pactlook_datagrid').datagrid('reload');
				}
			}
		}, {
			text : '取消',
			handler : function() {
				$('#pactlookquery').dialog('close').form('reset');
			}
		} ]
	});
	
	$("#pact_insepect_form").dialog({
		width : 630,
		height : 530,
		top : 10,
		title : '合同审核',
		modal : true,// 后面加一个不可编辑
		closed : true,// 默认情况下是关闭状态
		buttons:[{
			text:'审核',
			iconCls:'icon-add',
			handler:function(){
				if($('#pact_insepect_form').form('validate')){		
						var data={
								pid:$("#pid").val(),
								pexamine:$('#insepectagruments').val(),
						};
							$.ajax({
								url:'../pact/pactInsepect',
								type:"POST",
								data:data,
								success:function(result){
									if(result==true){
										$.messager.show({
											title:'提示',
											msg:'审核成功',
										})
									}else{
										$.messager.alert({
											title:'审核失败',
											msg:'<h3 style="color: red;">未知错误导致失败，请重试！</h3>',
											icon:'warning',
										})
									}
								}
							});
						}
					//刷新数据表格
					$('#pactlook_datagrid').datagrid('load');
					//关闭窗口
					$('#pact_insepect_form').dialog('close').form('reset');	
				}
			
		},{
			text:'打回',
			iconCls:'icon-undo',
			handler:function(){
				$('#pact_insepect_form').dialog('close').form('reset');
			}
		},{
			text:'取消',
			iconCls:'icon-redo',
			handler:function(){
				$('#pact_insepect_form').dialog('close').form('reset');
			}
		}]
	});

	// 点击图标进行操作
	pact_onclick = {
		search : function() {
			var name = $("#look_pname").val();
			var type = $("#look_ptype").val();
			var state = $("#look_pstate").val();
			$('#pactlook_datagrid').datagrid('load', {
				pname : name,
				ptype : type,
				pstate : state
			})
		},
		query : function() {
			$("#pactlookquery").dialog('open')
		},
		inspect : function(){
			var rows = $("#pactlook_datagrid").datagrid("getSelections");
			if(rows==null){
				$.messager.alert({
					title:'警告',
					msg:'请先选择！',
				});
			}else{
				var pid = rows[0].pid;
				$.ajax({
					url:'../pact/getPactById',
					data:{
						pid:pid
					},
					success:function(data){
					},
					complete:function(XMLHttpRequest, textStatus){
						if(XMLHttpRequest.readyState==4&&XMLHttpRequest.status==200){
							var result=JSON.parse(XMLHttpRequest.responseText);
							$("#pact_insepect_form").form('load',{
								pid:result.pid,
								pname:result.pname,
								ptype:result.ptype,
								pmoney:result.pmoney,
								pstate:result.pstate,
								pyi:result.pyi,
								poperateyi:result.poperateyi,
								poperator:result.poperator,
								pcreateTime:result.pcreateTime,
								ppeople:result.ppeople
							}).dialog('open');
						}
					}
				});
			}
		}
	};
});