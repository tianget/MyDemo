$(function(){  
	plan();
    
});  
function plan(){
	//增修查改
    $('#plan_add').bind('click', function(){    
    	var tab = $('#tabs').tabs('getSelected');  // 获取选择的面板
    	tab.panel('refresh', '../client/client_planadd');
    }); 
    $('#plan_update').bind('click', function(){    
    	var cost=$('#plan_bg').datagrid('getSelected');   //获取当前行数据   
    	if(cost==null){
    		alert("请选择一行");
    	}else{
        	var data={id:cost.id};
        	$.ajax({
        		url:'../clientPlan/updatePlan',
        		data:data,
    		    type:"post",
    		    success:function(result){
    		    }
        	})
        	var tab = $('#tabs').tabs('getSelected');  // 获取选择的面板
        	tab.panel('refresh', '../client/client_planadd');
    	}  
    }); 
    $('#plan_delete').bind('click', function(){    
    	var cost=$('#plan_bg').datagrid('getSelected');   //获取当前行数据   
    	if(cost==null){
    		alert("请选择一行");
    	}else{
        	var data={id:cost.id};
        	$.ajax({
        		url:'../clientPlan/delete',
        		data:data,
    		    type:"post",
    		    success:function(result){
    		    	alert("删除成功!");
    		    	var tab = $('#tabs').tabs('getSelected');  // 获取选择的面板
    	        	tab.panel('refresh', '../client/client_plan');
    		    }
        	})
    	}
    }); 
    $('#plan_query').bind('click', function(){    
    	var cost=$('#plan_bg').datagrid('getSelected');   //获取当前行数据   
    	if(cost==null){
    		alert("请选择一行");
    	}else{
        	var data={id:cost.id};
        	$.ajax({
        		url:'../clientPlan/updatePlan',
        		data:data,
    		    type:"post",
    		    success:function(result){
    		    	var tab = $('#tabs').tabs('getSelected');  // 获取选择的面板
    	        	tab.panel('refresh', '../client/client_planQuery');
    		    }
        	})
        	
    	}   
    }); 
    
    //数据表格
    $('#plan_bg').datagrid({    
    	url:'../clientPlan/getPlans',
	    height:450,
	    striped:true,
	    columns:[[
	            /*{field:'id',width:60},*/
	            {field:'id',checkbox:true},
	            {field:'name',title:'姓名',width:120,align:'center'},
	            {field:'month',title:'月份',width:120,align:'center'},
	            {field:'initdate',title:'创建时间',width:200,align:'center'},
	            {field:'finishdate',title:'最后操作时间',width:200,align:'center'},
	            {field:'s_name',title:'操作人',width:120,align:'center'},
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

   /* //月份
    $('#plan_yf').datebox({    
        required:true,
        


    }); 
    $.fn.datebox.defaults.formatter = function(date){
    	var y = date.getFullYear();
    	var m = date.getMonth()+1;
    	var d = date.getDate();
    	return m+'-'+d+'-'+y;
    }*/

    
    //月份查询
    $('#plan_cx').click(function(){
    	$.ajax({
			url:"../clientPlan/getDate",
			type:"post",
			data:{month:$('#plan_yf').val()},
			success:function(result){
				alert("1");
				/*//数据表格
			    $('#plan_bg').datagrid({    
			    	url:'../clientPlan/getPlans',
				    height:450,
				    striped:true,
				    columns:[[
				            {field:'id',width:60},
				            {field:' s',checkbox:true},
				            {field:'name',title:'姓名',width:120,align:'center'},
				            {field:'month',title:'月份',width:120,align:'center'},
				            {field:'initdate',title:'创建时间',width:200,align:'center'},
				            {field:'finishdate',title:'最后操作时间',width:200,align:'center'},
				            {field:'s_name',title:'操作人',width:120,align:'center'},
				    ]],
				    rownumbers:'true',
				    multiSort:'true',
				    singleSelect:'true',
				    fitColumns:'true',
				    pagination:'true',
				    singleSelect:'true',
				    pagePosition:'bottom',
				    pageNumber:1,
				    pageSize:5,
				    pageList:[5,10,15],
				    onClickCell:function(){
				    	
				    }
			    });*/
			}
    	})
    })
}

