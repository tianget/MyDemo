/**
 * 
 */
$(function(){
	$("#serveallot_datagrid").datagrid({
		url:"../serve/getServePage",
		method:"POST",
		queryParams: {          
	          status: '已提交'            
	    },
		width:650,
		fit:true,
		/*total:2,*/
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
		toolbar:'#serveallot_tool',
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
	
	$("#serveallot_look_form").dialog({
		width:740,
		height:666,
		title:'服务单据信息',
		modal:true,//后面加一个不可编辑
		closed:true,//默认情况下是关闭状态
	});
	
	$('#serveallot_allot_form').dialog({
		width:740,
		title:'我要分配',
		modal:true,//后面加一个不可编辑
		closed:true,//默认情况下是关闭状态
		iconCls:'icon-serve-allot',
		buttons:[{
			text:'提交',
			iconCls:'icon-add',
			handler:function(){
				if($('#servehandle_handle_form').form('validate')){		
						var data={
								sid:$('#sid').val(),
								sallot:$("#sallot").combobox('getValue'),
						};
							$.ajax({
								url:'../serve/serveAllot',
								type:"POST",
								data:data,
								success:function(result){
									if(result==true){
										$.messager.show({
											title:'提示',
											msg:'分配成功',
										})
									}else{
										$.messager.alert({
											title:'反馈失败',
											msg:'<h3 style="color: red;">未知错误导致失败，请重试！</h3>',
											icon:'warning',
										})
									}
								}
							});
						}
					//刷新数据表格
					$('#serveallot_datagrid').datagrid('load');
					//关闭窗口
					$('#serveallot_allot_form').dialog('close').form('reset');	
				}
			
		},{
			text:'取消',
			iconCls:'icon-redo',
			handler:function(){
				$('#serveallot_allot_form').dialog('close').form('reset');
			}
		}]
	});
	
	$("#sallot").combobox({
		url:'../serve/getAllStand',    
	    valueField:'sid',    
	    textField:'name',
	    required : true,
        missingMessage : '请选择待处理人',
	    editable : false,// 不可编辑，只能选择
        panelHeight:'auto'
	});
	
	serveallot_onclick={
		search:function(){
			var name=$("#aname").val();
			var type=$("#astype").val();
			var status=$("#asstatus").val();
			$('#serveallot_datagrid').datagrid('load',{
				sname: name,
				stype: type,
				sstatus:status,
				status: '已提交'
 		    });
			$("#aname").val('');
		},
		allot:function(){
			var rows=$('#serveallot_datagrid').datagrid('getSelections');
			if(rows.length==0){
				$.messager.alert({
					title:'警告操作',
					msg:'<h3 style="color: red;">请先选择再分配！</h3>',
					icon:'warning',
				})
			}else if(rows.length==1){
				var sid=rows[0].sid;
				serveallot(sid);
			}
		}
		,look:function(){
			var rows=$('#serveallot_datagrid').datagrid('getSelections');
			if(rows==0){
				$.messager.alert({
					title:'警告操作',
					msg:'<h3 style="color: red;">请先选择要查看的单据！</h3>',
					icon:'warning',
				})
			}else if(rows.length==1){
				var sid=rows[0].sid;
				servelookinfo(sid);
			}
		}
	}
});

function serveallot(sid){
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
				$("#serveallot_allot_form").form('load',{
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
				$('#serveallot_look_form').form('load',{
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

