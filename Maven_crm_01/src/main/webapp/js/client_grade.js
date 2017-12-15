$(function(){  
	//查
    $('#grade_query').bind('click', function(){    
    	var cost=$('#grade_bg').datagrid('getSelected');   //获取当前行数据   
    	if(cost==null){
    		alert("请选择一行");
    	}else{
        	var data={mid:cost.id};
        	$.ajax({
        		url:'../clientGrade/get',
        		data:data,
    		    type:"post",
    		    success:function(result){
    		    	var tab = $('#tabs').tabs('getSelected');  // 获取选择的面板
    	        	tab.panel('refresh', '../client/client_gradeQuery');
    		    }
        	})
        	
    	} 
    }); 

    
    //数据表格
    $('#grade_bg').datagrid({    
    	url:'../clientGrade/getGrades',
	    height:450,
	    striped:true,
	    columns:[[
	            /*{field:'id',width:60},*/
	            {field:'id',checkbox:true},
	            {field:'name',title:'客户姓名',width:120,align:'center'},
	            {field:'sex',title:'性别',width:120,align:'center'},
	            {field:'type',title:'客户类型',width:120,align:'center'},
	            {field:'number',title:'已消费次数',width:120,align:'center'},
	            {field:'grade',title:'信誉等级',width:120,align:'center'}
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
	    pageList:[1,2,4,6],
	    onClickCell:function(){
	    }
    });


    
});  

