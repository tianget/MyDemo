/**
 * 
 */
$(function(){
	$("#servefile_datagrid").datagrid({
		url:"../serve/getServePage",
		method:"POST",
		queryParams: {          
	          status: '已反馈'            
	        },
		width:650,
		fit:true,
		/*total:2,*/
		fitColumns:true,
		straiped:true,
		rownumbers:true,
		pagination:true,
		pageSize:5,
		pageList:[1,5,10,15,20],
		pageNumber:1, 
		sortName:'slastTime',
		sortOrder:'desc',
		toolbar:'#servefile_tool',
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
	
	$("#servefile_look_form").dialog({
		width:740,
		height:666,
		title:'服务单据信息',
		modal:true,//后面加一个不可编辑
		closed:true,//默认情况下是关闭状态
	});
	
	servefile_onclick={
		search:function(){
			var name=$("#fname").val();
			var type=$("#fstype").val();
			var status=$("#fsstatus").val();
			$('#servefile_datagrid').datagrid('load',{
				sname: name,
				stype: type,
				sstatus:status,
				status: '已反馈'
 		    });
			$("#fname").val('');
		},
		file:function(){
			var rows=$('#servefile_datagrid').datagrid('getSelections');
			if(rows.length>0){
				$.messager.confirm('确定','您要永久归档所选的<strong>'+rows.length+'</Strong>条数据吗？',function(f){
					if(f){
						var ids=[];
						for(var i=0;i<rows.length;i++){
							ids.push(rows[i].sid);
						}
						$.ajax({
							url:"../serve/serveFile",
							type:"post",
							data:{
								ids:ids.join(','),
							},
							success:function(result){
								if(result){
									$('#servefile_datagrid').datagrid('loaded');
									$('#servefile_datagrid').datagrid('load');
									$('#servefile_datagrid').datagrid('unselectAll');
									$.messager.show({
										title:'提示',
										msg:'成功归档 <strong>'+ids.length+'</strong> 条服务单据',
									})
								}else{
									$.messager.alert({
										title:'归档失败',
										msg:'<h3 style="color: red;">未知错误导致失败，请重试！</h3>',
										icon:'warning',
									})
								}
								//刷新数据表格
								$('#servefile_datagrid').datagrid('reload');
							}
						});
					}
				})

			}else{
				$.messager.alert({
					title:'',
					msg:'<h3 style="color: red;">请先选择后操作！</h3>',
					icon:'warning',
				});
			}
		}
		,look:function(){
			var rows=$('#servefile_datagrid').datagrid('getSelections');
			if(rows.length==0){
				$.messager.alert({
					title:'警告操作',
					msg:'<h3 style="color: red;">请先选择要查看的单据！</h3>',
					icon:'warning',
				})
			}else if(rows.length==1){
				var sid=rows[0].sid;
				servelookinfo(sid);
			}else if(rows.length>1){
				$.messager.alert({
					title:'警告操作',
					msg:'<h3 style="color: red;">请先选择一条要查看的单据！</h3>',
					icon:'warning',
				})
			}
		}
	}
});

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
				$('#servefile_look_form').form('load',{
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
