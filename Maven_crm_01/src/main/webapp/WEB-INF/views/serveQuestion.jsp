<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>创建单据</title>
<link rel="stylesheet" type="text/css" href="easyui/themes/default/easyui.css" />
<link rel="stylesheet" type="text/css" href="easyui/themes/icon.css" />
<script type="text/javascript" src="easyui/jquery.min.js"></script>
<script type="text/javascript" src="easyui/jquery.easyui.min.js"></script>
<script type="text/javascript"	src="easyui/locale/easyui-lang-zh_CN.js"></script>
<link rel="stylesheet" type="text/css" href="css/servecreate.css">
</head>
<body>
<div id="content" style="padding:10px;height:350px;">
		<div id="question_tool" style="padding-left:25px;">
			<p>服务名称：<input type="text" id="title">&nbsp;&nbsp;
			       类型：<select id="qtype" class="easyui-combobox" data-options="editable : false,panelHeight:'auto'" style="width:110px;">
			       		<option value="不限" selected="selected">不限</option>
			       		<option value="投诉问题">投诉问题</option>
			       		<option value="售前问题">售前问题</option>
			       		<option value="售后问题">售后问题</option>
			       		<option value="咨询问题">咨询问题</option>
			       </select>&nbsp;&nbsp; 
			   <a href="#" class="easyui-linkbutton" iconCls="icon-search" onclick="question_onclick.search()">查询</a>
			</p>
			<hr/>
			<p>服务信息列表：
				<a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="question_onclick.add()">添加</a>
				<a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="question_onclick.update()">修改</a>
				<a href="#" class="easyui-linkbutton" iconCls="icon-delete" plain="true" onclick="question_onclick.remove()">删除</a>
				<a href="#" class="easyui-linkbutton" iconCls="icon-serve-look" plain="true" onclick="question_onclick.look()">查看</a>
			</p>
		</div>
		<table id="question_datagrid" style="height:auto;"></table>
	</div>
	
	<form id="question_create_form"></form>	
	
	<form id="question_modified_form" >
		<div id="serve_create">
		<p style="font-weight: normal;font-size:12px;margin-top:20px;margin-bottom: 0;">&nbsp;&nbsp;&nbsp;服务管理>> 常见问题管理>> 修改常见问题</p>
			<input type="hidden" id="qid" name="qid" >
			<table id="serve_create_table" style="padding-left:40px;">
				<tr>
					<td>问题标题：</td>
					<td>
					<input type="text" style="width: 375px;color:#c7c7cd;" id="qtitle" name="qtitle" readonly="readonly"><span class="point_red">*</span>
					</td>
				</tr>
				<tr>
					<td>问题类型：</td>
					<td>
						<select id="qtype" name="qtype" class="easyui-combobox" data-options="editable : false,panelHeight:'auto'" style="width:110px;">
				       		<option value="投诉问题">投诉问题</option>
				       		<option value="售前问题">售前问题</option>
				       		<option value="售后问题">售后问题</option>
				       		<option value="咨询问题" selected="selected">咨询问题</option>
				       </select>
					<span class="point_red">*</span></td>
				</tr>
				<tr>
					<td>答复要点：</td>
					<td style="line-height: 50px;">
						<textarea cols="51" rows="5" maxlength="250" name="replyPoint"></textarea>
					</td>
				</tr>
				<tr>
					<td>备注信息：</td>
					<td>
						<textarea cols="51" rows="5" maxlength="250" name="qremark"></textarea>
					</td>
				</tr>
			</table>
		</div>
	</form>
	
	<form id="question_look_form" style="height:auto;">
		<div id="question_look">
		<p style="font-weight: normal;font-size:12px;margin-top:20px;margin-bottom: 0;">&nbsp;&nbsp;&nbsp;服务管理>> 常见问题管理>> 查看常见问题</p>
		<table id="question_look_table" style="padding-left:40px;">
			<tr>
				<td class="look_right">问题标题：</td>
				<td>
				<input type="text" style="width: 375px;" id="qtitle" name="qtitle">
				</td>
			</tr>
			<tr>
				<td class="look_right">问题类型：</td>
				<td>
					<input type="text" name="qtype" value="售后服务">
				</td>
			</tr>
			<tr>
				<td class="look_right">答复要点：</td>
				<td>
					<textarea cols="51" rows="5" maxlength="250" name="replyPoint"></textarea>
				</td>
			</tr>
			<tr>
				<td class="look_right">备注信息：</td>
				<td>
					<textarea cols="51" rows="5" maxlength="250" name="qremark"></textarea>
				</td>
			</tr>
			<tr>
				<td class="look_right">创建人：</td>
				<td>
					<input type="text" name="qcreater" >
				</td>
			</tr>
			<tr>
				<td class="look_right">创建时间：</td>
				<td>
					<input type="text" name="qcreateTime" >
				</td>
			</tr>
			<tr>
				<td class="look_right">更新时间：</td>
				<td>
					<input type="text" name="qlastTime" >
				</td>
			</tr>
		</table>
	</div>
	</form>
	
	<script type="text/javascript" src="../js/servequestion.js"></script>
	<link rel="stylesheet" type="text/css" href="../css/servecreate.css">
	<link rel="stylesheet" type="text/css" href="../css/questionlook.css">
</body>
</html>