<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <table style="padding-left: 20px;top:50px;left:40px;width:1222px">
      <tr style="height:25px;">
       <th>客户管理>> 客户关怀管理</th>
      </tr>
	  <tr style="height:40px;">
	    <!-- <th align="center">
	        客户姓名：<input id="loving_yf" type="text"></input> 
	           <input id="loving_cx" type="button" style="width:40px" value="查询">
	    </th> -->
	  </tr>
	  
	  <tr style="height:10px;">
	    <th>
	      <div style="width:1222px;border:1px solid black;"></div>
	    </th>
	  </tr>
	  
	  <tr style="height:30px;float:right">
	   <th>
	    <span style="position:absolute;top:115px;left:24px">客户关怀信息列表</span> 
	    <a id="loving_query" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-tip'">设置提醒</a> 
	    <a id="loving_details" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-heart'">关怀详情</a>    
   	   </th>
	  </tr>
	  
	  <tr>
	    <th>
		    <table id="loving_bg">
		    </table>
	   </th>
	  </tr>
	</table>

	  

<link rel="stylesheet" type="text/css" href="../css/client_loving.css" />
<script type="text/javascript" src="../js/client_loving.js"></script>
