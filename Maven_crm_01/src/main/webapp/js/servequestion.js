/**
 * 
 */
$(function(){
	$("#question_datagrid").datagrid({
		url:"../serve/getQuestionPage",
		method:"POST",
		width:650,
		fit:true,
		fitColumns:true,
		straiped:true,
		rownumbers:true,
		pagination:true,
		pageSize:5,
		pageList:[1,5,10,15,20],
		pageNumber:1, 
		sortName:'qlastTime',
		sortOrder:'desc',
		toolbar:'#question_tool',
		columns:[[
			    {
			    	field:'qid',
			    	title:'自动编号',
			    	width:80,
			    	checkbox:true,
			    },
			    {
			    	field:'qtitle',
			    	title:'标题',
			    	width:200,
			    },
			    {
			    	field:'qtype',
			    	title:'类型',
			    	width:70,
			    },	
			    {
			    	field:'qcreater',
			    	title:'创建人',
			    	width:70,
			    },
			    {
			    	field:'qcreateTime',
			    	title:'创建时间',
			    	width:100,
			    },
			    {
			    	field:'qlastTime',
			    	title:'最后操作时间',
			    	width:100,
			    },
		]],
		emptyMsg:'<h2>无数据</h2>',
		loadFilter:function(data){
			return data;
		} 
	});
	
	$('#question_create_form').dialog({
		width:845,
		height:460,
		top:100,
		title:'新增问题',
		href:'../serve/serveQuestionCreate',
		modal:true,//后面加一个不可编辑
		closed:true,//默认情况下是关闭状态
		iconCls:'icon-serve-add',
		buttons:[{
			text:'提交',
			iconCls:'icon-add',
			handler:function(){
				if($('#question_create_form').form('validate')){
					$.ajax({
						url:"../serve/saveServeQuestion",
						type:"post",
						data:$('#question_create_form').serialize(),
						beforeSend:function(){
							$.messager.progress({
								text:'正在新增中.......',	
							});
						},
						success:function(result){
							$.messager.progress('close');
							if(result){
								$.messager.show({
									title:'提示',
									msg:'服务单据创建成功',
								});
							}else{
								$.messager.alert({
									title:'新增失败',
									msg:'<h3 style="color: red;">未知错误导致失败，请重试！</h3>',
									icon:'warning',
								});
							};
						},
						complete:function(XMLHttpRequest, textStatus){
							//关闭窗口
							$('#question_create_form').dialog('close').form('reset');
							//刷新数据表格
							$('#question_datagrid').datagrid('reload');
						}
					});
				}
			}
		},{
			text:'取消',
			iconCls:'icon-redo',
			handler:function(){
				$('#question_create_form').dialog('close').form('reset');
			}
		}]
	});	
	
	$('#question_modified_form').dialog({
		width:845,
		title:'修改管理',
		modal:true,//后面加一个不可编辑
		closed:true,//默认情况下是关闭状态
		iconCls:'icon-serve-edit',
		buttons:[{
			text:'提交',
			iconCls:'icon-add',
			handler:function(){
				if($('#question_modified_form').form('validate')){					
					var data={
						ptype:$('#qtype').val(),
						replyPoint:$('textarea[name="replyPoint"]').val(),
						qremark:$('textarea[name="qremark"]').val(),
					};
					$.ajax({
						url:'../serve/updateQuestion',
						type:"POST",
						data:$("#question_modified_form").serialize(),
						beforeSend:function(){
							$.messager.progress({
								text:'正在修改中.......',	
							});
						},
						success:function(result){
							$.messager.progress('close');
							if(result==true){
								$.messager.show({
									title:'提示',
									msg:'修改管理成功',
								})
							}else{
								$.messager.alert({
									title:'修改失败',
									msg:'<h3 style="color: red;">未知错误导致失败，请重试！</h3>',
									icon:'warning',
								})
							}
						}
					});
					//关闭窗口
					$('#question_modified_form').dialog('close').form('reset');
					//刷新数据表格
					$('#question_datagrid').datagrid('reload');
				}
			}
		},{
			text:'取消',
			iconCls:'icon-redo',
			handler:function(){
				$('#question_modified_form').dialog('close').form('reset');
			}
		}]
	});
	
	$("#question_look_form").dialog({
		width:730,
		height:500,
		/*top:100,*/
		title:'问题详细信息',
		modal:true,//后面加一个不可编辑
		closed:true,//默认情况下是关闭状态
	});
	
	question_onclick={
		search:function(){
			var title=$("#title").val();
			var type=$("#qtype").val();
			$("#question_datagrid").datagrid('load',{
				qtitle:title,
				qtype:type
			});
		},
		add:function(){
			$("#question_create_form").dialog('open');
		},
		update:function(){
			//首先判断有没有选中或者选中多个
			var rows=$('#question_datagrid').datagrid('getSelections');
			if(rows.length>1){
				$.messager.alert({
					title:'警告操作',
					msg:'<h3 style="color: red;">只能选中一条问题修改！</h3>',
					icon:'warning',
				})
			}else if(rows.length==1){
				var qid=rows[0].qid;
				updateQuestion(qid);
			}else{
				$.messager.alert({
					title:'警告操作',
					msg:'<h3 style="color: red;">请先选择要修改的问题！</h3>',
					icon:'warning',
				})
			}
		},
		remove:function(){
			delselectedquestion();
		},
		look:function(){
			var rows=$('#question_datagrid').datagrid('getSelections');
			if(rows.length>1){
				$.messager.alert({
					title:'警告操作',
					msg:'<h3 style="color: red;">只能选中一条问题查看！</h3>',
					icon:'warning',
				})
			}else if(rows.length==1){
				var qid=rows[0].qid;
				lookquestion(qid);
			}else{
				$.messager.alert({
					title:'警告操作',
					msg:'<h3 style="color: red;">请先选择要查看的问题！</h3>',
					icon:'warning',
				})
			}
		}
	}
});


function lookquestion(qid){
	$.ajax({
		url:"../serve/lookQuestion",
		type:"post",
		data:{
			qid:qid
		},
		success:function(data){
			console.log(data);
		},
		complete:function(XMLHttpRequest, textStatus){
			if(XMLHttpRequest.readyState==4&&XMLHttpRequest.status==200){
				var result=JSON.parse(XMLHttpRequest.responseText);
				$("#question_look_form").form('load',{
					qtitle:result.qtitle,
					qtype:result.qtype,
					replyPoint:result.replyPoint,
					qremark:result.qremark,
					qcreater:result.qcreater,
					qcreateTime:result.qcreateTime,
					qlastTime:result.qlastTime
				}).dialog('open');
			}
		}
	});
}

function delselectedquestion(){
	var rows=$('#question_datagrid').datagrid('getSelections');
	if(rows.length>0){
		$.messager.confirm('确定','您要永久性的删除所选的<strong>'+rows.length+'</Strong>条记录吗？',function(flag){
			if(flag){
				var ids=[];
				for(var i=0;i<rows.length;i++){
					ids.push(rows[i].qid);
				}
				$.ajax({
					url:'../serve/deleteQuestion',
					type:"POST",
					data:{
						ids:ids.join(','),
					},
					beforeSend:function(){
						$.messager.progress({
							text:'正在删除中.......',	
						});
						$('#question_datagrid').datagrid('loading');
					},
					success:function(result){
						$.messager.progress('close');
						if(result==true){
							$('#question_datagrid').datagrid('loaded');
							$('#question_datagrid').datagrid('load');
							$('#question_datagrid').datagrid('unselectAll');
							$.messager.show({
								title:'提示',
								msg:'成功删除 <strong>'+ids.length+'</strong> 条服务单据',
							})
						}else{
							$.messager.alert({
								title:'删除失败',
								msg:'<h3 style="color: red;">未知错误导致失败，请重试！</h3>',
								icon:'warning',
							})
						}
						//刷新数据表格
						$('#serve_datagrid').datagrid('reload');
					}
				})
			}
		})
	}else{
		$.messager.alert({
			title:'删除失败',
			msg:'<h3 style="color: red;">删除记录至少选一条！</h3>',
			icon:'warning',
		})
	}
}

function updateQuestion(qid){
	$.ajax({
		url:"../serve/getQuestionById",
		type:"post",
		data:{
			qid:qid
		},
		success:function(data){
			console.log(data);
		},
		complete:function(XMLHttpRequest, textStatus){
			if(XMLHttpRequest.readyState==4&&XMLHttpRequest.status==200){
				var result=JSON.parse(XMLHttpRequest.responseText);
				$("#question_modified_form").form('load',{
					qid:result.qid,
					qtitle:result.qtitle,
					qtype:result.qtype,
					replyPoint:result.replyPoint,
					qremark:result.qremark
				}).dialog('open');
			}
		}
	});
}

