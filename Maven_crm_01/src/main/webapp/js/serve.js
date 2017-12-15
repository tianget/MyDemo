/**
 * 
 */
$(function(){
	$("#serve_datagrid").datagrid({
		url:"../serve/getServePage",
		method:"POST",
	    queryParams: {          
          status: '不限'            
        },
		width:650,
		fit:true,
		fitColumns:true,
		straiped:true,
		rownumbers:true,
		pagination:true,
		pageSize:5,
		pageList:[1,5,10,15,20],
		pageNumber:1, 
		sortName:'slastTime',
		sortOrder:'desc',
		toolbar:'#serve_tool',
		columns:[[
			    {
			    	field:'sid',
			    	title:'自动编号',
			    	width:80,
			    	checkbox:true,
			    },
			    {
			    	field:'sname',
			    	title:'服务名称',
			    	width:200,
			    },
			    {
			    	field:'stype',
			    	title:'类型',
			    	width:70,
			    },	
			    {
			    	field:'sstatus',
			    	title:'状态',
			    	width:70,
			    },
			    {
			    	field:'slastTime',
			    	title:'最后操作时间',
			    	width:100,
			    },
			    {
			    	field:'screater',
			    	title:'创建人',
			    	width:70,
			    },
			    {
			    	field:'shandler',
			    	title:'操作人',
			    	width:70,
			    	formatter:function(value,row,index){
			    		if(value==null){
			    			return "无";
			    		}
			    		return value;
			    	},
			    },
			    {
			    	field:'sallot',
			    	title:'待处理人',
			    	width:70,
			    	formatter:function(value,row,index){
			    		if(value==null){
			    			return "无";
			    		}
			    		return value;
			    	},
			    }
		]],
		emptyMsg:'<h2>无数据</h2>',
		loadFilter:function(data){
			return data;
		} 
	});
	
	$('#serve_create_form').dialog({
		width:845,
		height:460,
		top:100,
		title:'新增管理',
		href:'../serve/serveCreate',
		modal:true,//后面加一个不可编辑
		closed:true,//默认情况下是关闭状态
		iconCls:'icon-serve-add',
		buttons:[{
			text:'提交',
			iconCls:'icon-add',
			handler:function(){
				if($('#serve_create_form').form('validate')){
					$.ajax({
						url:"../serve/saveServeCreate",
						type:"post",
						data:$('#serve_create_form').serialize(),
						beforeSend:function(){
							$.messager.progress({
								text:'正在新增中.......',	
							});
						},
						success:function(result){
							$.messager.progress('close');
							if(result.status == true){
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
						}
					});
					//刷新数据表格
					$('#serve_datagrid').datagrid('load');
					//关闭窗口
					$('#serve_create_form').dialog('close').form('reset');	
				}
			}
		},{
			text:'取消',
			iconCls:'icon-redo',
			handler:function(){
				$('#serve_create_form').dialog('close').form('reset');
			}
		}]
	});
	
	$("#serve_look_form").dialog({
		width:740,
		height:666,
		title:'服务单据信息',
		modal:true,//后面加一个不可编辑
		closed:true,//默认情况下是关闭状态
		iconCls:'icon-serve-look',
	});
	
	$('#serve_modified_form').dialog({
		width:845,
		title:'修改管理',
		modal:true,//后面加一个不可编辑
		closed:true,//默认情况下是关闭状态
		iconCls:'icon-edit',
		buttons:[{
			text:'提交',
			iconCls:'icon-add',
			handler:function(){
				if($('#serve_modified_form').form('validate')){					
					$.ajax({
						url:'../serve/updateServe',
						type:"POST",
						data:$("#serve_modified_form").serialize(),
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
					$('#serve_modified_form').dialog('close').form('reset');
					//刷新数据表格
					$('#serve_datagrid').datagrid('reload');
				}
			}
		},{
			text:'取消',
			iconCls:'icon-redo',
			handler:function(){
				$('#serve_modified_form').dialog('close').form('reset');
			}
		}]
	});
	
	//点击图标进行操作
	serve_onclick={
		search:function(){
			var name=$("#name").val();
			var type=$("#stype").val();
			var status=$("#sstatus").val();
			$('#serve_datagrid').datagrid('load',{
				sname: name,
				stype: type,
				sstatus:status,
				status: '不限' 
 		    });
			$("#name").val('');
		},
		add:function(){
			//location.href="http://localhost:8080/crm/servecreate"
			$("#serve_create_form").dialog('open');
		},
		look:function(){
			//首先判断有没有选中或者选中多个
			var rows=$('#serve_datagrid').datagrid('getSelections');
			if(rows.length>1){
				$.messager.alert({
					title:'警告操作',
					msg:'<h3 style="color: red;">只能选中一条单据查看！</h3>',
					icon:'warning',
				})
			}else if(rows.length==1){
				var sid=rows[0].sid;
				servelookinfo(sid);
			}else{
				$.messager.alert({
					title:'警告操作',
					msg:'<h3 style="color: red;">请先选择要查看的单据！</h3>',
					icon:'warning',
				})
			}
		},
		remove:function(){
			var rows=$('#serve_datagrid').datagrid('getSelections');
			if(rows.length==0){
				$.messager.alert({
					title:'警告操作',
					msg:'<h3 style="color: red;">请先选择要删除的单据！</h3>',
					icon:'warning',
				})
			}else{
				delselectedserve();
			}
		},
		submit:function(){
			var rows=$('#serve_datagrid').datagrid('getSelections');
			if(rows.length==0){
				$.messager.alert({
					title:'警告操作',
					msg:'<h3 style="color: red;">请先选择要提交的单据！</h3>',
					icon:'warning',
				})
			}else{
				submitserve(rows);
			}
		},
		modified:function(){
			var rows=$('#serve_datagrid').datagrid('getSelections');
			if(rows.length>1){
				$.messager.alert({
					title:'警告操作',
					msg:'<h3 style="color: red;">只能选中一条单据修改！</h3>',
					icon:'warning',
				})
			}else if(rows.length==1){
				var sid=rows[0].sid;
				if(rows[0].sstatus == '已归档'){
					$.messager.alert({
						title:'修改失败',
						msg:'<h3 style="color: red;">[已归档]状态下无法进行修改！</h3>',
						icon:'warning',
					})
				}else{
					serveModified(sid);
				}
			}else{
				$.messager.alert({
					title:'警告操作',
					msg:'<h3 style="color: red;">请先选择要修改的单据！</h3>',
					icon:'warning',
				})
			}
		}
	};
});

function serveModified(sid){
	$.ajax({
		url:'../serve/serveLookInfo',
		type:"post",
		data:{
			sid:sid
		},
		success:function(data){
		},
		complete:function(XMLHttpRequest, textStatus){
			if(XMLHttpRequest.readyState==4&&XMLHttpRequest.status==200){
				var result=JSON.parse(XMLHttpRequest.responseText).data;
				$('#serve_modified_form').form('load',{
					sid:result.serve.sid,
					sname:result.serve.sname,
					stype:result.serve.stype,
					sstatus:result.serve.sstatus,
					sclient:result.sclient,
					clientPhone:result.clientPhone,
					scontent:result.scontent,
					sremark:result.sremark,
				}).dialog('open');
			}
		}
	});				
}

function submitserve(rows){
	/* 在js里判断提交的服务单据状态的新创建  */
		var flag=true;
		var ids=[];
		for(var i=0;i<rows.length;i++){
			ids.push(rows[i].sid);
			if(rows[i].sstatus!="新创建" || rows[i].sstatus=="已归档"){
				flag=false;
			}
		}
		if(flag==true){
			$.messager.confirm('确定','您确定要提交所选的<strong>'+rows.length+'</Strong>条数据吗？',function(f){
				if(f){
					$.ajax({
						url:'../serve/submitServe',
						type:"POST",
						data:{
							ids:ids.join(','),
						},
						beforeSend:function(){
							$.messager.progress({
								text:'正在提交.......',	
							});
							$('#serve_datagrid').datagrid('loading');
						},
						success:function(result){
							$.messager.progress('close');
							if(result){
								$('#serve_datagrid').datagrid('loaded');
								$('#serve_datagrid').datagrid('load');
								$('#serve_datagrid').datagrid('unselectAll');
								$.messager.show({
									title:'提示',
									msg:'成功提交 <strong>'+ids.length+'</strong> 条服务单据',
								})
							}else{
								$.messager.alert({
									title:'提交失败',
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
				title:'提交失败',
				msg:'<h3 style="color: red;">只能选择[新创建]状态进行提交！</h3>',
				icon:'warning',
			})
		}
}

function delselectedserve(){
	var rows=$('#serve_datagrid').datagrid('getSelections');
	if(rows.length>0){
		$.messager.confirm('确定','您要永久性的删除所选的<strong>'+rows.length+'</Strong>条记录吗？',function(flag){
			if(flag){
				var ids=[];
				for(var i=0;i<rows.length;i++){
					ids.push(rows[i].sid);
				}
				$.ajax({
					url:'../serve/deleteServe',
					type:"POST",
					data:{
						ids:ids.join(','),
					},
					beforeSend:function(){
						/*$.messager.progress({
							text:'正在删除中.......',	
						});*/
						$('#serve_datagrid').datagrid('loading');
					},
					success:function(result){
						$.messager.progress('close');
						if(result.status){
							$('#serve_datagrid').datagrid('loaded');
							$('#serve_datagrid').datagrid('load');
							$('#serve_datagrid').datagrid('unselectAll');
							$.messager.show({
								title:'提示',
								msg:'成功删除 <strong>'+result.num+'</strong> 条服务单据',
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

function servelookinfo(sid){
	$.ajax({
		url:'../serve/serveLookInfo',
		type:"post",
		data:{
			sid:sid
		},
		success:function(data){
		},
		complete:function(XMLHttpRequest, textStatus){
			if(XMLHttpRequest.readyState==4&&XMLHttpRequest.status==200){
				var result=JSON.parse(XMLHttpRequest.responseText).data;
				$('#serve_look_form').form('load',{
					sname:result.serve.sname,
					stype:result.serve.stype,
					sstatus:result.serve.sstatus,
					sclient:result.sclient,
					clientPhone:result.clientPhone,
					scontent:result.scontent,
					screater:result.serve.screater,
					screateTime:result.serve.screateTime,
					sallot:result.serve.sallot,
					sremark:result.sremark,
					shandler:result.serve.shandler,
					slastTime:result.serve.slastTime,
					handleResult:result.handleResult,
					handleExplain:result.handleExplain,
					ticklingResult:result.ticklingResult,
					ticklingExplain:result.ticklingExplain
				}).dialog('open');
			}
		}
	});				
}

