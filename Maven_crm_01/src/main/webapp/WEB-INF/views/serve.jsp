<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>服务管理</title>
<link rel="stylesheet" type="text/css" href="easyui/themes/default/easyui.css" />
<link rel="stylesheet" type="text/css" href="easyui/themes/icon.css" />
<script type="text/javascript" src="easyui/jquery.min.js"></script>
<script type="text/javascript" src="easyui/jquery.easyui.min.js"></script>
<script type="text/javascript"	src="easyui/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="../js/serve.js"></script>
</head>
<body>
	<div id="content" style="padding:10px;height:350px;">
		<div id="serve_tool" style="padding-left:25px;">
			<p>服务名称：<input type="text" id="name">&nbsp;&nbsp;
			       类型：<select id="stype" class="easyui-combobox" data-options="editable : false,panelHeight:'auto'" style="width:110px;">   
					    <option value="不限" selected="selected">不限</option>
					    <option value="投诉服务">投诉服务</option>   
					    <option value="售前服务">售前服务</option>   
					    <option value="售后服务">售后服务</option>   
					    <option value="咨询服务">咨询服务</option>     
					</select>  
					&nbsp;&nbsp; 
			       状态：<select id="sstatus" class="easyui-combobox" data-options="editable : false,panelHeight:'auto'" style="width:110px;">
			       		<option value="不限" selected="selected">不限</option>
			       		<option value="新创建">新创建</option>
			       		<option value="已提交">已提交</option>
			       		<option value="已分配">已分配</option>
			       		<option value="已处理">已处理</option>
			       		<option value="已反馈">已反馈</option>
			       		<option value="已归档">已归档</option>
			       </select> 
			       &nbsp;&nbsp;
			   <a href="#" class="easyui-linkbutton" iconCls="icon-search" onclick="serve_onclick.search()">查询</a>
			</p>
			<hr/>
			<p class="serve_listing">服务信息列表：
			<c:choose>
				<c:when test="${serverole == '销售用户' }">
					<a href="#" class="easyui-linkbutton" iconCls="icon-serve-add" plain="true" onclick="serve_onclick.add()">添加</a>
					<a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="serve_onclick.modified()">修改</a>
					<a href="#" class="easyui-linkbutton" iconCls="icon-delete" plain="true" onclick="serve_onclick.remove()">删除</a>
					<a href="#" class="easyui-linkbutton" iconCls="icon-serve-submit" plain="true" onclick="serve_onclick.submit()">提交</a>
					<a href="#" class="easyui-linkbutton" iconCls="icon-serve-look" plain="true" onclick="serve_onclick.look()">查看</a>
				</c:when>
				<c:otherwise>
					<a href="#" class="easyui-linkbutton" iconCls="icon-serve-look" plain="true" onclick="serve_onclick.look()">查看</a>
				</c:otherwise>
			</c:choose>
			</p>
			
		</div>
		<table id="serve_datagrid" style="height:auto;"></table>
	</div>
	<form id="serve_create_form"></form>
	
	<form id="serve_look_form" style="height:auto">
		<jsp:include page="serveLook.jsp"></jsp:include>
	</form>
	
	<form id="serve_modified_form" style="height:auto;">
		<div id="serve_create">
				<p style="font-weight: normal;font-size:12px;margin-top:20px;margin-bottom: 0;">&nbsp;&nbsp;&nbsp;服务管理>> 服务创建>> 修改服务</p>
		<input type="hidden" name="sid">
			<table id="serve_create_table">
				<tr>
					<td>服务名称：</td>
					<td>
					<input type="text" style="width: 375px;color:#c7c7cd;" readonly="readonly" id="sname" name="sname"><span class="point_red">*</span>
					</td>
				</tr>
				<tr>
					<td>服务类型：</td>
					<td>
						<select id="stype" name="stype" class="easyui-combobox" data-options="panelHeight:'auto'" style="width:110px;">
				       		<option value="投诉服务">投诉服务</option>
				       		<option value="售前服务">售前服务</option>
				       		<option value="售后服务">售后服务</option>
				       		<option value="咨询服务" selected="selected">咨询服务</option>
			      		 </select>
					<span class="point_red">*</span></td>
				</tr>
				<tr>
					<td>服务客户：</td>
					<td>
						<input type="text" class="two_input" style="color:#c7c7cd;" readonly="readonly" id="sclient" name="sclient"><span class="point_red">*</span>
						<span style="padding: 24px;"></span>联系电话：&nbsp;&nbsp;<input type="text" class="two_input" style="color:#c7c7cd;" readonly="readonly" id="clientPhone" name="clientPhone"><span class="point_red">*</span>
					</td>
				</tr>
				<tr>
					<td>服务内容：</td>
					<td>
						<textarea cols="51" rows="5"  maxlength="250" name="scontent"></textarea>
					</td>
				</tr>
				<tr>
					<td>备注信息：</td>
					<td>
						<textarea cols="51" rows="5" maxlength="250" name="sremark"></textarea>
					</td>
				</tr>
			</table>
		</div>
	</form>
	
	<script type="text/javascript" src="../js/serve.js"></script>
	<link rel="stylesheet" type="text/css" href="../css/servecreate.css">
</body>
</html>