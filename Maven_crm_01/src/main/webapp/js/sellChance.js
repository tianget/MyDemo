$(function(){
	
	$('#sellChanceTb').datagrid({    
	    url:'../sellChance/getPageData',    
	    columns:[[ 
            {field:'id',checkbox:true}, 
	        {field:'chanceName',title:'机会名称',width:150}, 
	        {field:'chanceType',title:'机会类型',width:150},    
	        {field:'enteringDate',title:'录入时间',width:250},  
	        {field:'enteringManName',title:'录入人',width:150},	           
	    ]],
	    rownumbers:true,
	    fitColumns:true,
	    toolbar:'#sellChanceCrud',
	    pagination:true,
	    pageSize:5,
	    pageList:[1,5,10,15,20],
	    singleSelect:true,
	}); 
});

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

function addChance(){
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
			
			/*var result = $("#planSaleroom").val().match('^[0-9]*$')
			
			if(result==null){
				$("#sellMoney").html("你的输入不合法");
				$("#sellMoney").css({
					"font-size":"12px",
					"color":"red"
				})
				return false;
			}*/
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
	
}

/*

function add(){
	redirect('录入联系人','../sellLinkMan/addSellLinkMan?id=0');
}

function update(){
	var select = $('#sellLxr').datagrid('getSelected');
	if(select==null){
		$.messager.alert('警告','请选择一条数据！');    
		
	}else{
		redirect('修改联系人','../sellLinkMan/addSellLinkMan?id='+select.id+"&operation=update");
	}
	
}


function sub($url){
	
	$('#sellLxrForm').form({    
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
	    	return1();
	    }
	});    
	
}

function return1(){
	redirect('联系人管理','../sellLinkMan/goSellLinkMan');
}

function addPost(){
	
	sub('../sellLinkMan/addSellLinkManPost');
}

function del(){
	var select = $('#sellLxr').datagrid('getSelected');
	if(select==null){
		$.messager.alert('警告','请选择一条数据！');    
		
	}else{
		$.messager.confirm('确认','确定要删除吗！',function(r){    
		    if (r){    
		        
		    	$.ajax({
					url:"../sellLinkMan/delSellLinkMan",
					type:"get",
					data:{id:select.id},
					success:function(data){
						if(data=="false"){
							$.messager.alert('警告','删除失败！'); 
						}
						
					}
					
				});
		    	return1();
		    } 
		}); 
	}

}


function query(){
	var select = $('#sellLxr').datagrid('getSelected');
	if(select==null){
		$.messager.alert('警告','请选择一条数据！');    
		
	}else{
		redirect('查看联系人','../sellLinkMan/addSellLinkMan?id='+select.id+"&operation=query");
	}

}

function likeQuery(){
	$('#sellLxr').datagrid('load',{
		like:$("#linkManLikeQuery").val()
	});
	
}*/

