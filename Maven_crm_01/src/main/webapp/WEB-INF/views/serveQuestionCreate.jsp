<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>创建常见问题</title>
<link rel="stylesheet" type="text/css" href="easyui/themes/default/easyui.css" />
<link rel="stylesheet" type="text/css" href="easyui/themes/icon.css" />
<script type="text/javascript" src="easyui/jquery.min.js"></script>
<script type="text/javascript" src="easyui/jquery.easyui.min.js"></script>
<script type="text/javascript"	src="easyui/locale/easyui-lang-zh_CN.js"></script>
</head>
<body>
	<div id="serve_create">
	<p style="font-weight: normal;font-size:12px;margin-top:20px;margin-bottom: 0;">&nbsp;&nbsp;&nbsp;服务管理>> 常见问题管理>> 新增常见问题</p>
		<table id="serve_create_table" style="padding-left:40px;">
			<tr>
				<td>问题标题：</td>
				<td>
				<input type="text" style="width: 375px;" id="qtitle" name="qtitle"><span class="point_red">*</span>
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
	
    <script type="text/javascript" src="../js/servecreate.js"></script> 
	<link rel="stylesheet" type="text/css" href="../css/servecreate.css">
</body>
</html>