$(function(){  
	//查
    $('#cost_query').bind('click', function(){   
    	var cost=$('#cost_bg').datagrid('getSelected');   //获取当前行数据   
    	if(cost==null){
    		alert("请选择一行");
    	}else{
    	var data={mid:cost.mid};
    	$.ajax({
    		url:'../clientCost/getMember',
    		data:data,
		    type:"post",
		    success:function(result){

		    	var tab = $('#tabs').tabs('getSelected');  // 获取选择的面板
		    	tab.panel('refresh', '../client/client_costInformation');

		    }
    	})
    	}
    }); 
    
    //数据表格
    $('#cost_bg').datagrid({    
    	url:'../clientCost/getCosts',
	    height:450,
	    striped:true,
	    columns:[[
	            {field:'mid',checkbox:true},
	            {field:'name',title:'客户姓名',width:120,align:'center'},
	            {field:'sex',title:'性别',width:120,align:'center'},
	            {field:'type',title:'客户类型',width:120,align:'center'},
	            {field:'number',title:'已消费次数',width:120,align:'center'},
	            {field:'sum',title:'消费总额(单位:万元)',width:120,align:'center'},
	            {field:'sid',title:'服务代表',width:120,align:'center'}
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

