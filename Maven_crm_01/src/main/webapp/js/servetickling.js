/**
 * 
 */
$(function(){
	$("#servetickling_datagrid").datagrid({
		url:"../serve/getServePage",
		method:"POST",
		queryParams: {          
	          status: '已处理'            
	        },
		width:650,
		fit:true,
//		total:2,
		fitColumns:true,
		straiped:true,
		singleSelect:true,
		rownumbers:true,
		pagination:true,
		pageSize:5,
		pageList:[1,5,10,15,20],
		pageNumber:1, 
		sortName:'slastTime',
		sortOrder:'desc',
		toolbar:'#servetickling_tool',
		columns:[[
			    {
			    	field:'sid',
			    	title:'自动编号',
			    	width:80,
			    	/*singleSelect:true,*/
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
			    },
			    {
			    	field:'sallot',
			    	title:'待处理人',
			    	width:70,
			    }
		]],
		emptyMsg:'<h2>无数据</h2>',
		loadFilter:function(data){
			return data;
		} 
	});
	
	$('textarea[name="ticklingExplain"]').validatebox({
		required : true,
		missingMessage : '请务必输入反馈说明',
	});
	
	$("#servetickling_look_form").dialog({
		width:740,
		height:460,
		title:'服务单据信息',
		modal:true,//后面加一个不可编辑
		closed:true,//默认情况下是关闭状态
	});
	
	$('#servetickling_tickling_form').dialog({
		width:740,
		title:'我要反馈',
		modal:true,//后面加一个不可编辑
		closed:true,//默认情况下是关闭状态
		iconCls:'icon-serve-edit',
		buttons:[{
			text:'提交',
			iconCls:'icon-add',
			handler:function(){
				if($('#servetickling_tickling_form').form('validate')){		
					//alert($('#sid').val());
					var data={
						sid:$('#sid').val(),
						ticklingResult:$('select[name="ticklingResult"]').val(),
						ticklingExplain:$('#ticklingExplain').val(),
					};
					$.ajax({
						url:'../serve/serveTickling',
						type:"POST",
						data:data,
						success:function(result){
							if(result==true){
								$.messager.show({
									title:'提示',
									msg:'反馈成功',
								})
							}else{
								$.messager.alert({
									title:'反馈失败',
									msg:'<h3 style="color: red;">未知错误导致失败，请重试！</h3>',
									icon:'warning',
								})
							}
						},
						complete:function(){
							//刷新数据表格
							$('#servetickling_datagrid').datagrid('load');
							//关闭窗口
							$('#servetickling_tickling_form').dialog('close').form('reset');							
						}
					});	
				}
			}
		},{
			text:'取消',
			iconCls:'icon-redo',
			handler:function(){
				$('#servetickling_tickling_form').dialog('close').form('reset');
			}
		}]
	});
	
	
	servetickling_onclick={
			search:function(){
				var name=$("#tname").val();
				var type=$("#tstype").val();
				var status=$("#tsstatus").val();
				$('#servetickling_datagrid').datagrid('load',{
					sname: name,
					stype: type,
					sstatus:status,
					status: '已处理'
	 		    });
				$("#tname").val('');
			},
			look:function(){
				var rows=$('#servetickling_datagrid').datagrid('getSelections');
				if(rows.length==0){
					$.messager.alert({
						title:'警告操作',
						msg:'<h3 style="color: red;">请先选择要查看的单据！</h3>',
						icon:'warning',
					})
				}else if(rows.length==1){
					var sid=rows[0].sid;
					servelookinfo(sid);
				}
			},
			tickling:function(){
				var rows=$('#servetickling_datagrid').datagrid('getSelections');
				if(rows.length==0){
					$.messager.alert({
						title:'警告操作',
						msg:'<h3 style="color: red;">请先选择要反馈的服务！</h3>',
						icon:'warning',
					})
				}else if(rows.length==1){
					var sid=rows[0].sid;
					servetickling(sid);
				}
			}
		}
});

function servetickling(sid){
	$.ajax({
		url:"../serve/serveLookInfo",
		type:"post",
		data:{
			sid:sid
		},
		success:function(data){
		},
		complete:function(XMLHttpRequest, textStatus){
			if(XMLHttpRequest.readyState==4&&XMLHttpRequest.status==200){
				var result=JSON.parse(XMLHttpRequest.responseText).data;
				$("#servetickling_tickling_form").form('load',{
					sid:result.serve.sid,
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
				}).dialog('open');
			}
		}
	});
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
				$('#servetickling_look_form').form('load',{
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
