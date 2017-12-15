$(function(){  
	//增修查改
    $('#satisficing_add').bind('click', function(){ 
    	var tab = $('#tabs').tabs('getSelected');  // 获取选择的面板
    	tab.panel('refresh', '../client/client_satisficingadd');
    	$.ajax({
    		url:'../clientSatisficing/queryMember',
		    type:"post",
		    data:{take:"增加"},
		    success:function(result){
		    	$("#take").html(result.take);
		    	if(("#take").html()!=null){
		    	}else{
		    		$("#take").html(result.take);
				}
		    }
    	})
    	
    }); 
    $('#satisficing_update').bind('click', function(){    
    	
    	var cost=$('#satisficing_bg').datagrid('getSelected');   //获取当前行数据   
    	if(cost==null){
    		alert("请选择一行");
    	}else{
    		var tab = $('#tabs').tabs('getSelected');  // 获取选择的面板
        	tab.panel('refresh', '../client/client_satisficingadd');
        	var data={id:cost.id,take:"修改"};
        	$.ajax({
        		url:'../clientSatisficing/updateSatisficing',
        		data:data,
    		    type:"post",
    		    success:function(result){
    		    	$("#name").html("<option value='"+result.satisficing.mid+"'>"+result.satisficing.name);
    		    	$("#encode").html(result.satisficing.encode);
    		    	$("#sex").html(result.satisficing.sex);
    		    	$("#type").html(result.satisficing.type);
    		    	$("#status").html(result.satisficing.status);
    		    	$("#number").html(result.satisficing.number);	
    		    	$("#quality").val(result.satisficing.quality);
    		    	$("#serve").val(result.satisficing.serve);
    		    	$("#benefit").val(result.satisficing.benefit);
    		    	$("#overall").val(result.satisficing.overall);
    		    	$("#feedback").html(result.satisficing.quality);
    		    	$("#take").html(result.take);
    		    	
    		    }/*,
        	    complete:function(XMLHttpRequest,textStatus){
        	    	if(XMLHttpRequest.readyState==4&&XMLHttpRequest.status==200){
        	    		
        	        	
        	        	var resultTwo=JSON.parse(XMLHttpRequest.responseText).satisficing;
        	        	
        	        	$("#name").html("<option value='"+resultTwo.mid+"'>"+resultTwo.name);
        		    	$("#encode").html(resultTwo.encode);
        		    	$("#sex").html(resultTwo.sex);
        		    	$("#type").html(resultTwo.type);
        		    	$("#status").html(resultTwo.status);
        		    	$("#number").html(resultTwo.number);	
        		    	$("#quality").val(resultTwo.quality);
        		    	$("#serve").val(resultTwo.serve);
        		    	$("#benefit").val(resultTwo.benefit);
        		    	$("#overall").val(resultTwo.overall);
        		    	$("#feedback").html(resultTwo.quality);
        		    	$("#take").html(resultTwo.take);
        	    	}
        	    }*/
        	})
    	}
    	
    }); 
    $('#satisficing_delete').bind('click', function(){    
    	var cost=$('#satisficing_bg').datagrid('getSelected');   //获取当前行数据   
    	if(cost==null){
    		alert("请选择一行");
    	}else{
        	var data={id:cost.id};
        	$.ajax({
        		url:'../clientSatisficing/deleteSatisficing',
        		data:data,
    		    type:"post",
    		    success:function(result){
    		    	 if(result.msg=="删除成功！"){
    		    		 alert(result.msg);
    		    		 var tab = $('#tabs').tabs('getSelected');  // 获取选择的面板
    		    		 tab.panel('refresh', '../client/client_satisficing');
    		    	 }
    		    }
        	})
    	}  
    }); 
    $('#satisficing_query').bind('click', function(){ 
    	var cost=$('#satisficing_bg').datagrid('getSelected');   //获取当前行数据   
    	if(cost==null){
    		alert("请选择一行");
    	}else{
    		var tab = $('#tabs').tabs('getSelected');  // 获取选择的面板
        	tab.panel('refresh', '../client/client_satisficingQuery');
        	var data={id:cost.id};
        	$.ajax({
        		url:'../clientSatisficing/updateSatisficing',
        		data:data,
    		    type:"post",
    		    success:function(result){
    		    	$("#name").html("<option value='"+result.satisficing.mid+"'>"+result.satisficing.name);
    		    	$("#encode").html(result.satisficing.encode);
    		    	$("#sex").html(result.satisficing.sex);
    		    	$("#type").html(result.satisficing.type);
    		    	$("#status").html(result.satisficing.status);
    		    	$("#number").html(result.satisficing.number);	
    		    	$("#quality").val(result.satisficing.quality);
    		    	$("#serve").val(result.satisficing.serve);
    		    	$("#benefit").val(result.satisficing.benefit);
    		    	$("#overall").val(result.satisficing.overall);
    		    	$("#feedback").html(result.satisficing.quality);
    		    	
    		    }
        	})
    	}
    }); 
    
    //数据表格
    $('#satisficing_bg').datagrid({    
    	url:'../clientSatisficing/getSatisficing',
	    height:450,
	    striped:true,
	    columns:[[
	            {field:'id',checkbox:true},
	            {field:'name',title:'客户姓名',width:120,align:'center'},
	            {field:'type',title:'客户类型',width:120,align:'center'},
	            {field:'time',title:'调查时间',width:120,align:'center'},
	            {field:'quality',title:'质量满意度',width:120,align:'center'},
	            {field:'serve',title:'服务满意度',width:120,align:'center'},
	            {field:'overall',title:'总体满意度',width:120,align:'center'}
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

