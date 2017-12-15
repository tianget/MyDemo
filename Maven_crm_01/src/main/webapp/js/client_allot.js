$(function(){  
	//增修查改
    $('#client_add').bind('click', function(){    

    	var tab = $('#tabs').tabs('getSelected');  // 获取选择的面板
    	tab.panel('refresh', '../client/client_member');
    });    
    
    $('#client_update').bind('click', function(){    
    	var cost=$('#client_bg').datagrid('getSelected');   //获取当前行数据   
    	if(cost==null){
    		alert("请选择一行");
    	}else{
        	var data={mid:cost.id};
        	$.ajax({
        		url:'../clientAllot/updateMember',
        		data:data,
    		    type:"post",
    		    success:function(result){
    		    }
        	})
        	var tab = $('#tabs').tabs('getSelected');  // 获取选择的面板
        	tab.panel('refresh', '../client/client_member');
    	}
    }); 
    $('#client_query').bind('click', function(){    
    	var cost=$('#client_bg').datagrid('getSelected');   //获取当前行数据   
    	if(cost==null){
    		alert("请选择一行");
    	}else{
        	var data={mid:cost.id};
        	$.ajax({
        		url:'../clientAllot/updateMember',
        		data:data,
    		    type:"post",
    		    success:function(result){	
    		    }
        	})
        	var tab = $('#tabs').tabs('getSelected');  // 获取选择的面板
        	tab.panel('refresh', '../client/client_member2');
    	}
    }); 
    $('#client_allot').bind('click', function(){    
    	var cost=$('#client_bg').datagrid('getSelected');   //获取当前行数据   
    	if(cost==null){
    		alert("请选择一行");
    	}else{
        	var data={mid:cost.id};
        	$.ajax({
        		url:'../clientAllot/allotd',
        		data:data,
    		    type:"post",
    		    success:function(result){	
    		    	if(result.msg=="权限不够！"){
    		    		alert(result.msg);
    		    	}else{
    		    		var tab = $('#tabs').tabs('getSelected');  // 获取选择的面板
    		        	tab.panel('refresh', '../client/client_allotD');
    		    	}
    		    }
        	})
    	}  
    }); 
    
    //数据表格
    $('#client_bg').datagrid({    
    	url:'../clientAllot/getAllots',
	    height:450,
	    striped:true,
	    columns:[[
	            
	            {field:'id',checkbox:true},
	            {field:'name',title:'客户姓名',width:120,align:'center'},
	            {field:'sex',title:'性别',width:120,align:'center'},
	            {field:'type',title:'类型',width:120,align:'center'},
	            {field:'condition',title:'状态',width:120,align:'center'},
	            {field:'allot',title:'分配状态',width:120,align:'center'},
	            {field:'date',title:'录入时间',width:120,align:'center'},
	            {field:'staff_id',title:'录入人',width:120,align:'center'}
	    ]],
	    rownumbers:'true',
	    multiSort:'true',
	    singleSelect:'true',
	    fitColumns:'true',
	    pagination:'true',
	    singleSelect:'true',
	    pagePosition:'bottom',
	    pageNumber:1,
	    pageSize:1,
	    pageList:[1,2,3,4,5],
	    onClickCell:function(){
	    }
    });

});  

