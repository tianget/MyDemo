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
		<div id="servefile_tool" style="padding-left:25px;">
			<p>服务名称：<input type="text" id="fname">&nbsp;&nbsp;
			       类型：<select id="fstype" class="easyui-combobox" data-options="editable : false,panelHeight:'auto'" style="width:110px;">
			       		<option value="不限" selected="selected">不限</option>
			       		<option value="投诉服务">投诉服务</option>
			       		<option value="售前服务">售前服务</option>
			       		<option value="售后服务">售后服务</option>
			       		<option value="咨询服务">咨询服务</option>
			       </select>&nbsp;&nbsp; 
			       状态：<select id="fsstatus" class="easyui-combobox" data-options="editable : false,panelHeight:'auto'" style="width:110px;">
			       		<option value="已反馈" selected="selected">已反馈</option>
			       </select> 
			   <a href="#" class="easyui-linkbutton" iconCls="icon-search" onclick="servefile_onclick.search()">查询</a>
			</p>
			<hr/>
			
			<p>服务信息列表：
			<c:choose>
				<c:when test="${serverole == '销售代表' }">
					<a href="#" class="easyui-linkbutton" iconCls="icon-serve-file" plain="true" onclick="servefile_onclick.file()">归档</a>
						<a href="#" class="easyui-linkbutton" iconCls="icon-serve-look" plain="true" onclick="servefile_onclick.look()">查看</a>
				</c:when>
				<c:otherwise>
					<a href="#" class="easyui-linkbutton" iconCls="icon-serve-look" plain="true" onclick="servefile_onclick.look()">查看</a>
				</c:otherwise>
			</c:choose>
			</p>
		</div>
		<table id="servefile_datagrid" style="height:auto;"></table>
	</div>
	<form id="servefile_look_form" style="height:auto">
		<jsp:include page="serveLook.jsp"></jsp:include>
	</form>
	<script type="text/javascript" src="../js/servefile.js"></script>
	<link rel="stylesheet" type="text/css" href="../css/servecreate.css">
</body>
</html>