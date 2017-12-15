$(function(){
	
	$('#sellCompeteTb').datagrid({    
	    url:'../sellCompete/getPageData',    
	    columns:[[ 
            {field:'id',checkbox:true}, 
	        {field:'subject',title:'预测标题',width:250}, 
	        {field:'analysisDate',title:'预测时间',width:150},    
	        {field:'type',title:'类型',width:150},  
	        {field:'generateDate',title:'生成时间',width:250},	           
	        {field:'operationManName',title:'操作人',width:150},
	        {field:'state',title:'状态',width:150},
	    ]],
	    rownumbers:true,
	    fitColumns:true,
	    toolbar:'#sellCompeteCrud',
	    pagination:true,
	    pageSize:5,
	    pageList:[1,5,10,15,20],
	    singleSelect:true,
	});
	
	
	
	
});

function likeQueryCompete(){
	$('#sellCompeteTb').datagrid('load',{
		like:$("#competeLikeQuery").val()
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
function queryCompete(){
	var select = $('#sellCompeteTb').datagrid('getSelected');
	if(select==null){
		$.messager.alert('警告','请选择一条数据！');    
		
	}else{
		redirect('查看竞争','../sellCompete/goSellCompeteAU?id='+select.id+"&operation=query");
		
	}
}

function fileCompete(){
	var select = $('#sellCompeteTb').datagrid('getSelected');
	if(select==null){
		$.messager.alert('警告','请选择一条数据！');    
		
	}else if(select.state=="已归档"){
		$.messager.alert('警告','该数据已归档！');    
	}else{
		$.ajax({
			url:"../sellCompete/fileSellCompete",
			type:"get",
			cache:false,
			data:{id:select.id},
			success:function(result){
				if(result=="true"){
					$.messager.alert('提示','归档成功！')
					return1Compete();
				}
			}
		})
	}
}


function addCompete(){
	redirect('添加竞争','../sellCompete/goSellCompeteAU?id=0');
}


function updateCompete(){
	var select = $('#sellCompeteTb').datagrid('getSelected');
	if(select==null){
		$.messager.alert('警告','请选择一条数据！');    
		
	}else if(select.state=="已归档"){
		$.messager.alert('警告','该数据已归档不能修改！');    
	}else{
		redirect('修改竞争','../sellCompete/goSellCompeteAU?id='+select.id+"&operation=update");
	}
	
}



function return1Compete(){
	redirect('销售预测','../sellCompete/goSellCompete');
}


function forecast(){
	$('#forecastDd').dialog('open'); 
	
	
	//redirect('新建预测','../sellForecast/goAddSellForecast');
}



function subCompete(){
	
	$('#sellCompeteForm').form({    
	    url:'../sellCompete/addSellCompetePost',    
	    onSubmit: function(){ 
	    	var isValid = $(this).form('validate');
			if (!isValid){
				return false;
			}
	    },
	    success:function(result){
	    	return1Compete();
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


