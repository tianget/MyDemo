$(function(){  
	//增修查改
    $('#loving_query').bind('click', function(){  
    	var cost=$('#loving_bg').datagrid('getSelected');   //获取当前行数据   
    	if(cost==null){
    		alert("请选择一行");
    	}else{
    		var data={mid:cost.mid,name:cost.name,sex:cost.sex,type:cost.type,count:cost.count,overall:cost.overall,abcd:cost.abcd};
        	$.ajax({
        		url:'../clientLoving/getMid',
        		data:data,
    		    type:"post",
    		    success:function(result){
    		    	var tab = $('#tabs').tabs('getSelected');  // 获取选择的面板
    	        	tab.panel('refresh', '../client/client_lovings');
    		    }
        	})
    	}
    }); 
    $('#loving_details').bind('click', function(){  
    	var cost=$('#loving_bg').datagrid('getSelected');   //获取当前行数据   
    	if(cost==null){
    		alert("请选择一行");
    	}else{
    		var data={mid:cost.mid,name:cost.name,sex:cost.sex,type:cost.type,count:cost.count,overall:cost.overall,abcd:cost.abcd};
        	$.ajax({
        		url:'../clientLoving/getMid',
        		data:data,
    		    type:"post",
    		    success:function(result){
    		    	var tab = $('#tabs').tabs('getSelected');  // 获取选择的面板
    		    	tab.panel('refresh', '../client/client_lovingd');
    		    }
        	})
    	}
    	
    }); 
    
    //数据表格
    $('#loving_bg').datagrid({    
    	url:'../clientLoving/getLoving',
	    height:450,
	    striped:true,
	    columns:[[
	            {field:'mid',checkbox:true},
	            {field:'name',title:'客户姓名',width:120,align:'center'},
	            {field:'sex',title:'性别',width:120,align:'center'},
	            {field:'type',title:'客户类型',width:120,align:'center'},
	            {field:'count',title:'价值等级',width:120,align:'center'},
	            {field:'overall',title:'满意度',width:120,align:'center'},
	            {field:'abcd',title:'信誉等级',width:120,align:'center'},
	            {field:'scheme',title:'建议关怀方案',width:120,align:'center'}
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

