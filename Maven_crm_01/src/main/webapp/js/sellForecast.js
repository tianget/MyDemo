$(function(){
	
	$('#sellForecastTb').datagrid({    
	    url:'../sellForecast/getPageDate',    
	    columns:[[ 
            {field:'id',checkbox:true}, 
	        {field:'subject',title:'预测标题',width:250}, 
	        {field:'month',title:'月份',width:150},    
	        {field:'type',title:'类型',width:150},  
	        {field:'generateDate',title:'生成时间',width:250},	           
	        {field:'operationManName',title:'操作人',width:250},	           
	    ]],
	    rownumbers:true,
	    fitColumns:true,
	    toolbar:'#sellForecastCrud',
	    pagination:true,
	    pageSize:5,
	    pageList:[1,5,10,15,20],
	    singleSelect:true,
	});
	
	
	
	
});

function likeQueryForecast(){
	$('#sellForecastTb').datagrid('load',{
		like:$("#forecastLikeQuery").val()
	});
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
function queryForecast(){
	var select = $('#sellForecastTb').datagrid('getSelected');
	if(select==null){
		$.messager.alert('警告','请选择一条数据！');    
		
	}else{
		redirect('各部门分析统治','../sellForecast/goSellForecastQuery?id='+select.id);
		
	}
}

function return1Forecast(){
	redirect('销售预测','../sellForecast/goSellForecast');
}


function forecast(){
	$('#forecastDd').dialog('open'); 
	
	
	//redirect('新建预测','../sellForecast/goAddSellForecast');
}

function redio(obj){
	var id;
	$("[name='typeId']").each(function(){
		if(this.checked==true){
			id = $(this).val();
		}
	})
	$('#forecastDd').dialog('close'); 
	redirect('新建预测','../sellForecast/goAddSellForecast?id='+id);
   
}

function subForecast(){
	
	var id;
	if($("#staffId").val()!=undefined){
		id=$("#staffId").val();
	}else if($("#deptId").val()!=undefined){
		id=$("#deptId").val();
	}else{
		id=0;
	}
	$('#sellForecast').form({    
	    url:'../sellForecast/addSellForecastPost?id='+id,    
	    onSubmit: function(){ 
	    	var isValid = $(this).form('validate');
			if (!isValid){
				return false;
			}
	    },
	    success:function(result){
	    	return1Forecast();
	    }
	});    
	
}



/*function addChance(){
	redirect('录入销售机会','../sellChance/addSellChanceAU?id=0');
}

function updateChance(){
	var select = $('#sellChanceTb').datagrid('getSelected');
	if(select==null){
		$.messager.alert('警告','请选择一条数据！');    
		
	}else if(select.state==1){
		$.messager.alert('警告','该机会已分配不能修改！');    
	}else{
		redirect('修改销售机会','../sellChance/addSellChanceAU?id='+select.id+"&operation=update");
	}
	
}

function return1Chance(){
	redirect('机会管理','../sellChance/goSellChance');
}


function subChance($url){
	
	$('#sellChanceForm').form({    
	    url:'../sellChance/addSellChancePost',    
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
	    	return1Chance();
	    }
	});    
	
}




function queryChance(){
	var select = $('#sellChanceTb').datagrid('getSelected');
	if(select==null){
		$.messager.alert('警告','请选择一条数据！');    
		
	}else{
		redirect('查看销售机会','../sellChance/addSellChanceAU?id='+select.id+"&operation=query");
	}

}


function allotChance(){
	
	var select = $('#sellChanceTb').datagrid('getSelected');
	if(select==null){
		$.messager.alert('警告','请选择一条数据！');    
		
	}else if(select.state==1){
		$.messager.alert('警告','该机会已分配！');    
	}else{
		redirect('分配销售机会','../sellChance/addSellChanceAU?id='+select.id+"&operation=allot");
	}
}


function allotPostChance($id){
	
	$.ajax({
		url:"../sellChance/allotSellChance",
		type:"get",
		cache:false,
		data:{
			id:$id,
			sid:$("#staffName").val()
		},
		success:function(result){
			alert(result)
				$.messager.alert('提示','分配成功！');
				return1Chance();
		}
			
	})
	
}
function likeQueryChance(){
	$('#sellChanceTb').datagrid('load',{
		like:$("#chanceLikeQuery").val()
	});
	
}*/


