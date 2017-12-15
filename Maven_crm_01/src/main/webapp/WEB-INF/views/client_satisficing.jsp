<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
	<table style="padding-left: 20px;top:50px;left:40px;width:1222px">
      <tr style="height:25px;">
       <th>客户管理>> 客户满意度管理</th>
      </tr>
	  <tr style="height:40px;">
	   <!--  <th align="center">
	        客户姓名：<input id="satisficing_yf" type="text"></input> 
	           <input id="satisficing_cx" type="button" style="width:40px" value="查询">
	    </th> -->
	  </tr>
	  
	  <tr style="height:10px;">
	    <th>
	      <div style="width:1222px;border:1px solid black;"></div>
	    </th>
	  </tr>
	  
	  <tr style="height:30px;float:right">
	   <th>
	    <span style="position:absolute;top:115px;left:24px">客户发展计划信息列表</span>
	    <a id="satisficing_add" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-add'">增加</a> 
	    <a id="satisficing_update" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-cut'">修改</a>  
	    <a id="satisficing_delete" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-remove'">删除</a>  
	    <a id="satisficing_query" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search'">查看</a>   
   	   </th>
	  </tr>
	  
	  <tr>
	    <th>
		    <table id="satisficing_bg">
		    </table>
	   </th>
	  </tr>
	</table>  
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
<link rel="stylesheet" type="text/css" href="../css/client_satisficing.css" />
<script type="text/javascript" src="../js/client_satisficing.js"></script>