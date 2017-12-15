<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>服务分配</title>
<link rel="stylesheet" type="text/css" href="easyui/themes/default/easyui.css" />
<link rel="stylesheet" type="text/css" href="easyui/themes/icon.css" />
<script type="text/javascript" src="easyui/jquery.min.js"></script>
<script type="text/javascript" src="easyui/jquery.easyui.min.js"></script>
<script type="text/javascript"	src="easyui/locale/easyui-lang-zh_CN.js"></script>
</head>
<body>
		<div id="content" style="padding:10px;height:350px;">
		<div id="servehandle_tool" style="padding-left:25px;">
			<p>服务名称：<input type="text" id="hname">&nbsp;&nbsp;
			       类型：<select id="hstype" class="easyui-combobox" data-options="editable : false,panelHeight:'auto'" style="width:110px;">
			       		<option value="不限" selected="selected">不限</option>
			       		<option value="投诉服务">投诉服务</option>
			       		<option value="售前服务">售前服务</option>
			       		<option value="售后服务">售后服务</option>
			       		<option value="咨询服务">咨询服务</option>
			       </select>&nbsp;&nbsp; 
			       状态：<select id="hsstatus" class="easyui-combobox" data-options="editable : false,panelHeight:'auto'" style="width:110px;">
			       		<option value="已分配" selected="selected">已分配</option>
			       </select> 
			   <a href="#" class="easyui-linkbutton" iconCls="icon-search" onclick="servehandle_onclick.search()">查询</a>
			</p>
			<hr/>
			
			<p>服务信息列表：
			<c:choose>
				<c:when test="${serverole == '销售代表' }">
					<a href="#" class="easyui-linkbutton" iconCls="icon-serve-handle" plain="true" onclick="servehandle_onclick.handle()">处理</a>
					<a href="#" class="easyui-linkbutton" iconCls="icon-serve-look" plain="true" onclick="servehandle_onclick.look()">查看</a>
				</c:when>
				<c:otherwise>
					<a href="#" class="easyui-linkbutton" iconCls="icon-serve-look" plain="true" onclick="servehandle_onclick.look()">查看</a>
				</c:otherwise>
			</c:choose>
						
			</p>
		</div>
		<table id="servehandle_datagrid" style="height:auto;"></table>
	</div>
	
	<form id="servehandle_look_form" style="height:auto">
		<jsp:include page="serveLook.jsp"></jsp:include>
	</form>
	
	<form id="servehandle_handle_form" style="height:auto">
		<jsp:include page="serveUpdate.jsp"></jsp:include>
		<input type="hidden" id="sid">
		<table id="serve_operate" style="display:block;">
			<tr>
				<td style="font-weight: normal;vertical-align:buttom;font-size:14px;padding:10px;">操作</td>
				<td></td>
			</tr>
			<tr>
				<td colspan="2"><hr style="height:1px;border:none;border-top:1px solid black;"></td>
			</tr>
			<tr>
				<td>处理结果：</td>
				<td><select name="handleResult">
				       		<option value="已处理" selected="selected">已处理</option>
				       </select> </td>
			</tr>
			<tr>
				<td>处理说明：</td>
				<td><textarea cols="51" rows="5" maxlength="250" name="handleExplain" id="handleExplain"></textarea></td>
			</tr>
		</table>
	</form>
	
	<script type="text/javascript" src="../js/servehandle.js"></script>
	<link rel="stylesheet" type="text/css" href="../css/servecreate.css">
</body>
</html>