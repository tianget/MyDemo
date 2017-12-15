<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<table style="padding-left: 20px;top:50px;left:40px;width:1222px">
      <tr style="height:25px;">
       <th>客户管理>> 客户关怀</th>
      </tr>
	  <tr style="height:40px;">
	    <th>
	    <table style="width:750px;height: 280px">
				<tr>
					<td>客户姓名：${lovName }</td>
					<td>性别：${lovSex }</span></td>
				</tr>
				<tr>
					<td>客户类型：${lovType }
					</td>
					<td>满意度：${lovOverall }</td>
				</tr>
				<tr>
					<td>信誉等级：${lovAbcd }</span>
					</td>
					<td>价值等级：${lovCount }
			        </td>
				</tr>
			</table>
	    </th>
	  </tr>
	  
	  <tr style="height:10px;">
	    <th>
	      <div style="width:1222px;border:1px solid black;"></div>
	    </th>
	  </tr>
	  
	  <tr style="height:30px;float:right">
	   <th>
		<a onclick="add()" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-add'">增加</a> 
	    <a onclick="update()" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-cut'">修改</a>  
	    <a onclick="del()" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search'">删除</a>  
	    <a href="#" onclick="fanhui()" class="easyui-linkbutton" data-options="iconCls:'icon-search'">返回</a>  
  
   	   </th>
	  </tr>
	  
	  <tr>
	    <th>
		    <table id="client_lovd">
		    </table>
	   </th>
	  </tr>
	</table>
	<from id="option">
	   关怀名称：<input id="name" type="text" /><span style="color:red">&nbsp;*</span></br>
	   执行时间：<input type="text" id="time" class="easyui-datebox"  value="${plan.name }"><span style="color:red">&nbsp;*</span></br>
	   执行方案： <select id="fa">		
	   <option id="A" value="A">A方案</option>
	   <option id="B" value="B">B方案</option>
	   <option id="C" value="C">C方案</option>
	   <option id="D" value="D">D方案</option>
	   </select><span style="color:red">&nbsp;*</span></br>
	   执行结果：<select id="jg">		
	   <option id="已" value="已执行">已执行</option>
	   <option id="未" value="未执行">未执行</option>
	   </select></br>
	   备注信息：<input id="xx" type="text" /></br>
	 
	</from>
    <div id="session" style="display: none;">${lovMid}</div>
	<script type="text/javascript">
	function add(){
		$('#option').dialog({
			width:300,
			height:440,
			inline:true,
			title:'添加关怀',
			buttons:[
				{
					text:'取消',
					width:60,
					handler:function(){
					},	
				},
				{
					text:'确定',
					width:60,
					handler:function(){		
						var data={mid:$('#session').html(),name:$('#name').val(),time:$('#time').val(),fa:$('#fa').val(),jg:$('#jg').val(),xx:$('#xx').val()};
			        	$.ajax({
			        		url:'../clientLoving/addLovd',
			        		data:data,
			    		    type:"post",
			    		    success:function(result){	
			    		    	if(result.msg=="增加成功！"){
			    		    		alert(result.msg);
			    		    	}
			    		    }
			        	})
				},		
				}
			]
	  })
	}
	function update(){
		var cost=$('#client_lovd').datagrid('getSelected');   //获取当前行数据   
    	if(cost==null){
    		alert("请选择一行");
    	}else{
    		$('#option').dialog({
    			width:300,
    			height:440,
    			inline:true,
    			title:'修改关怀',
    			buttons:[
    				{
    					text:'取消',
    					width:60,
    					handler:function(){
    					},	
    				},
    				{
    					text:'确定',
    					width:60,
    					handler:function(){		
    						var data={mid:$('#session').html(),scid:cost.scid,name:$('#name').val(),time:$('#time').val(),fa:$('#fa').val(),jg:$('#jg').val(),xx:$('#xx').val()};
    			        	$.ajax({
    			        		url:'../clientLoving/update',
    			        		data:data,
    			    		    type:"post",
    			    		    success:function(result){	
    			    		    	if(result.msg=="修改成功！"){
    			    		    		alert(result.msg);
    			    		    	}
    			    		    }
    			        	})
    				},		
    				}
    			]
    	  })
    	}
	}
	function del(){
		var cost=$('#client_lovd').datagrid('getSelected');   //获取当前行数据   
    	if(cost==null){
    		alert("请选择一行");
    	}else{
    		var data={scid:cost.scid};
    		$.ajax({
        		url:'../clientLoving/del',
        		data:data,
    		    type:"post",
    		    success:function(result){	
    		    	if(result.msg=="删除成功！"){
    		    		alert(result.msg);
    		    	}
    		    }
        	})
    	}
	}
       
	$(function(){
		$('#client_lovd').datagrid({    
	    	url:'../clientLoving/getLovd',
		    height:450,
		    striped:true,
		    columns:[[
		            {field:'scid',checkbox:true},
		            {field:'name',title:'关怀名称',width:120,align:'center'},
		            {field:'date',title:'执行时间',width:120,align:'center'},
		            {field:'scheme',title:'执行方案',width:120,align:'center'},
		            {field:'finallys',title:'执行结果',width:120,align:'center'},   
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

	})
    function fanhui(){
    	var tab = $('#tabs').tabs('getSelected');  // 获取选择的面板
    	tab.panel('refresh', '../client/client_loving');
    }