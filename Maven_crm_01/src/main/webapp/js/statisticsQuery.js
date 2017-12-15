

/*function querySta(){
	
		redirect('统计tu','../statistics/clienteleFormation');
		
}*/
/*function likeQueryPer(){
	$('#sellPerTb').datagrid('load',{
		like:$("#perLikeQuery").val()
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
function queryPer(){
	var select = $('#sellAnalysisTb').datagrid('getSelected');
	if(select==null){
		$.messager.alert('警告','请选择一条数据！');    
		
	}else{
		redirect('各部门分析统治','../sellAnalysis/geSellAnalysisQuery?month='+select.thisMonth);
		
	}
}

function return1Per(){
	redirect('销售分析','../sellPer/goSellPer');
}
*/
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


