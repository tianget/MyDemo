$(function(){
	
	$('#sellLxr').datagrid({    
	    url:'../sellLinkMan/getPageData',    
	    columns:[[ 
            {field:'id',checkbox:true}, 
	        {field:'name',title:'姓名',width:150}, 
	        {field:'sex',title:'性别',width:150},    
	        {field:'phone',title:'电话',width:150}, 
	        {field:'enteringDate',title:'录入时间',width:250},  
	        {field:'address',title:'住址',width:150},
	        {field:'remark',title:'备注',width:150}, 
	           
	    ]],
	    rownumbers:true,
	    fitColumns:true,
	    toolbar:'#lxrCrud',
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

function addLinkMan(){
	redirect('录入联系人','../sellLinkMan/addSellLinkMan?id=0');
}

function updateLinkMan(){
	var select = $('#sellLxr').datagrid('getSelected');
	if(select==null){
		$.messager.alert('警告','请选择一条数据！');    
		
	}else{
		redirect('修改联系人','../sellLinkMan/addSellLinkMan?id='+select.id+"&operation=update");
	}
	
}


function subLinkMan($url){
	
	$('#sellLxrForm').form({    
	    url:$url,    
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
	    	return1LinkMan();
	    }
	});    
	
}

function return1LinkMan(){
	redirect('联系人管理','../sellLinkMan/goSellLinkMan');
}

function addPostLinkMan(){
	
	subLinkMan('../sellLinkMan/addSellLinkManPost');
}

function delLinkMan(){
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
		    	return1LinkMan();
		    } 
		}); 
	}

}


function queryLinkMan(){
	var select = $('#sellLxr').datagrid('getSelected');
	if(select==null){
		$.messager.alert('警告','请选择一条数据！');    
		
	}else{
		redirect('查看联系人','../sellLinkMan/addSellLinkMan?id='+select.id+"&operation=query");
	}

}

function likeQueryLinkMan(){
	$('#sellLxr').datagrid('load',{
		like:$("#linkManLikeQuery").val()
	});
	
}
