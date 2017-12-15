<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <table style="padding-left: 20px;top:50px;left:40px;width:1222px">
      <tr style="height:25px;">
       <th>客户管理>> 客户资源管理</th>
      </tr>
	  <tr style="height:40px;">
	    <th>
	        <!-- <select id="client_cc" class="easyui-combobox" name="dept" style="width:70px;" data-options="panelMaxHeight:'70px'">   
			    <option value="不限">不限</option>   
			    <option value="未分配">未分配</option>   
			    <option value="已分配">已分配</option>     
			</select>   
	        
	        搜索框
	       <script type="text/javascript"> 
			function qq(value,name){ 
	
			$('#client_bg').datagrid('reload',{
					op:value,
					name:name,
					value:value
				})
			} 
				
			</script> 

			<input id="client_ss" class="easyui-searchbox" style="width:300px" 
			data-options="searcher:qq,prompt:'请选择搜索的方式',menu:'#client_mm'"></input> 
			
			<div id="client_mm" style="width:140px"> 
			<div data-options="name:'客户姓名'">客户姓名</div> 
			<div data-options="name:'客户电话'">客户电话</div> 
			</div>    -->
	    </th>
	  </tr>
	  
	  <tr style="height:10px;">
	    <th>
	      <div style="width:1222px;border:1px solid black;"></div>
	    </th>
	  </tr>
	  
	  <tr style="height:30px;float:right">
	   <th>
	    <span style="position:absolute;top:115px;left:24px">角色信息列表</span>
	    <a id="client_add" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-add'">增加</a> 
	    <a id="client_update" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-cut'">修改</a>  
	    <a id="client_query" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search'">查看</a>  
	    <a id="client_allot" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-customers'">分配</a>   
   	   </th>
	  </tr>
	  
	  <tr>
	    <th>
		    <table id="client_bg">
		    </table>
	   </th>
	  </tr>
	</table>

	  

<link rel="stylesheet" type="text/css" href="../css/client_allot.css" />
<script type="text/javascript" src="../js/client_allot.js"></script>
