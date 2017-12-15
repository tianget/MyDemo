<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <table style="padding-left: 20px;top:50px;left:40px;width:1222px">
      <tr style="height:25px;">
       <th>客户管理>> 客户价值管理</th>
      </tr>
	  <tr style="height:40px;">
	    <th>
	        <!-- <select id="cost_cc" class="easyui-combobox" name="dept" style="width:70px;" data-options="panelMaxHeight:'70px'">   
			    <option value="不限">不限</option>   
			    <option value="未分配">未分配</option>   
			    <option value="已分配">已分配</option>     
			</select>   
	        
	        搜索框
	       <script type="text/javascript"> 
			function qq(value,name){ 
			alert($('#cost_cc').val()+"+"+name+"+:"+value) 
			} 
			</script> 

			<input id="cost_ss" class="easyui-searchbox" style="width:300px" 
			data-options="searcher:qq,prompt:'请选择搜索的方式',menu:'#cost_mm'"></input> 
			
			<div id="cost_mm" style="width:140px"> 
			<div data-options="name:'客户姓名'">客户姓名</div> 
			</div>   --> 
	    </th>
	  </tr>
	  
	  <tr style="height:10px;">
	    <th>
	      <div style="width:1222px;border:1px solid black;"></div>
	    </th>
	  </tr>
	  
	  <tr style="height:30px;float:right">
	   <th>
	    <span style="position:absolute;top:115px;left:24px">客户价值信息列表</span> 
	    <a id="cost_query" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search'">查看</a>    
   	   </th>
	  </tr>
	  
	  <tr>
	    <th>
		    <table id="cost_bg">
		    </table>
	   </th>
	  </tr>
	</table>

	  

<link rel="stylesheet" type="text/css" href="../css/client_cost.css" />
<script type="text/javascript" src="../js/client_cost.js"></script>
