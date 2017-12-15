
$(function(){
	$('#myPlan').linkbutton({    
	    iconCls:'icon-suppliers',
	    text:'我的计划',
	    plain:true
	});
	var flag;
	$('#dg').datagrid({    
	    url:'../sell/getPageData',    
	    columns:[[ 
            {field:'planId',checkbox:true}, 
	        {field:'planName',title:'姓名',width:150}, 
	        {field:'coding',title:'编码',width:150},    
	        {field:'planMonth',title:'月份',width:150},  
	        {field:'state',title:'状态',width:150},
	        {field:'planSaleroom',title:'计划销售额(万元)',width:200}, 
	        {field:'lastOperationDate',title:'最后操作时间',width:300},
	        {field:'operationName',title:'操作人',width:200},    
	        {field:'handlerName',title:'待处理人',width:200},    
	    ]],
	    rownumbers:true,
	    fitColumns:true,
	    toolbar:'#planCrud',
	    pagination:true,
	    pageSize:5,
	    pageList:[1,5,10,15,20],
	    singleSelect:true,
    	
	   


	}); 
});

function refreshPlan(){
	$('#dg').datagrid('reload');
}

function addPlan(){
	redirect('创建销售计划','../sell/addSellPlan');
}

function redirect($title,$url){
	
	var tab = $('#tabs').tabs('getSelected');  // 获取选择的面板
	console.log(tab)
	$('#tabs').tabs('update', {
		tab: tab,
		options: {
			title: $title,
			href: $url  // 新内容的URL
		}
	});
	var tab = $('#tabs').tabs('getSelected');  // 获取选择的面板
	tab.panel('refresh',$url);

}



function checkCoding(coding){
	$("#sellMsg").empty();
		$.ajax({
			url:"../sell/checkCoding",
			type:"get",
			data:{coding:$(coding).val()},
			success:function(data){
				flag = data;
				if(data=="true"){
					$("#sellMsg").html("计划编码可用");
					$("#sellMsg").css({
						"font-size":"12px",
						"color":"green"
					})
				}else{
					$("#sellMsg").html("计划编码已存在");
					$("#sellMsg").css({
						"font-size":"12px",
						"color":"red"
					})
				}
			}
			
		})
	
}


function subPlan($url){
	
	$('#sellForm').form({    
	    url:$url,    
	    onSubmit: function(){ 
	    	var isValid = $(this).form('validate');
			if (!isValid){
				return false;
			}
			
			var result = $("#planSaleroom").val().match('^[0-9]*$')
			
			if(result==null){
				$("#sellMoney").html("你的输入不合法");
				$("#sellMoney").css({
					"font-size":"12px",
					"color":"red"
				})
				return false;
			}
	    },
	    success:function(result){
	    	return1Plan();
	    }
	});    
	
}

function addPostPlan(){
	if(flag=="false"){
		return false;
	}

	subPlan('../sell/addSellPlanPost');
}

function return1Plan(){
	redirect('销售计划','../sell/goSellPlan');
}


function delPlan(){
	var select = $('#dg').datagrid('getSelected');
	if(select==null){
		$.messager.alert('警告','请选择一条数据！');    
		
	}else if(select.state!="已创建"){
		$.messager.alert('警告','不能操作已提交的数据！');    
	}else{
		$.messager.confirm('确认','确定要删除吗！',function(r){    
		    if (r){    
		        
		    	$.ajax({
					url:"../sell/delSellPlan",
					type:"get",
					data:{id:select.planId},
					success:function(data){
						if(data=="false"){
							$.messager.alert('警告','删除失败！'); 
						}
						
					}
					
				});
		    	return1Plan();
		    } 
		}); 
	}

}

function updatePlan(){
	var select = $('#dg').datagrid('getSelected');
	if(select==null){
		$.messager.alert('警告','请选择一条数据！');    
		
	}else if(select.state=="已提交"){
		$.messager.alert('警告','不能操作已提交的数据！');    
	}else{
		redirect('修改销售计划','../sell/goUpdateSellPlan?coding='+select.coding+"&oparation=update");
	}

}

function updatePostPlan(){
	subPlan('../sell/updateSellPlanPost');
}


function queryPlan(){
	var select = $('#dg').datagrid('getSelected');
	if(select==null){
		$.messager.alert('警告','请选择一条数据！');    
		
	}else{
		redirect('查询销售计划','../sell/goUpdateSellPlan?coding='+select.coding+"&oparation=query");
	}

}


function submitPlan(){
	var select = $('#dg').datagrid('getSelected');
	console.log(select)
	if(select==null){
		$.messager.alert('警告','请选择一条数据！');    
		
	}else if(select.state!="已创建"){
		$.messager.alert('警告','只能操作还未提交的数据！');    
	}else{
		$.messager.confirm('确认','确定要提交吗！',function(r){    
		    if (r){    
		        
		    	$.ajax({
					url:"../sell/submitSellPlan",
					type:"post",
					data:{id:select.planId},
					
				});
		    	
		    	$.messager.alert('提示','提交计划成功！');
		    	refreshPlan();
		    } 
		});
	}
}

function myPlan(){
	
	var name = $("#myPlan").attr("name");
	if(name=="myPlan"){
		$('#myPlan').linkbutton({    
		    iconCls:'icon-undo',
		    text:'返回',
		    plain:true
		});
		$("#myPlan").attr("name","all")
		$('#dg').datagrid('load',{
			myPlan:"true"
		});


	}else{
		$('#myPlan').linkbutton({    
		    iconCls:'icon-suppliers',
		    text:'我的计划',
		    plain:true
		});
		$("#myPlan").attr("name","myPlan")
		$('#dg').datagrid('load',{
			myPlan:"false"
		});
	}	
	
	
}



function examinePlan(planId){
	$.messager.confirm('确认','确定要审批该计划吗！',function(r){    
	    if (r){    
	    		$.ajax({
					url:"../sell/examineSellPlan",
					type:"post",
					data:{id:planId},
				});
	    		
		    	$.messager.alert('提示','审批计划成功！');
		    	return1Plan();
		    		    	    	
	    } 
	});
	
}


function playReturn(planId){
	
	$.messager.confirm('确认','确定要打回该计划吗！',function(r){    
	    if (r){        
	    	$.ajax({
				url:"../sell/playReturnSellPlan",
				type:"post",
				data:{id:planId},
			});
	    	
	    	$.messager.alert('提示','打回计划成功！');     
	    	return1Plan();
	    } 
	});
}


function likeQueryPlan(){
	$('#dg').datagrid('load',{
		like:$("#likeQuery").val()
	});
	
}
