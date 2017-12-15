<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改角色</title>
<style type="text/css">
#fm2 {
	margin: 0;
	padding: 10px 30px;
}

.ftitle2 {
	font-size: 14px;
	font-weight: bold;
	padding: 5px 0;
	margin-bottom: 10px;
	border-bottom: 1px solid #ccc;
}

.fitem2 {
	margin-bottom: 5px;
}

.fitem2 label {
	display: inline-block;
	width: 80px;
}

.fitem2 input {
	width: 160px;
}
</style>
</head>
<body>
	<div id="dlg2" class="easyui-dialog"
		style="width: 300px; height: 250px; padding: 10px 20px" closed="true"
		buttons="#dlg-buttons">
		<form id="fm2" method="post">
			<div class="fitem2">
				<input name="rid" >
				<label>角色编码:</label> <input name="rcoding" value="${rcoding}"
					id="rcoding" type="text" class="easyui-textbox" disabled="false">
				</div>
			<p></p>
			<div class="fitem2">
				<label>角色名称:</label> <input name="rname" id="rname" type="text"
					class="easyui-textbox">
			</div>
			<p></p>
			<div class="fitem2">
				<label>所属部门:</label> <select id="option" name="did">
				</select>
			</div>
			<p></p>
			<div class="fitem2">
				<label>备注信息:</label> <input id="rremark" name="rremark" type="text"
					class="easyui-textbox" />
			</div>
		</form>
	</div>
	<div id="dlg-buttons">
		<a href="#" class="easyui-linkbutton" iconCls="icon-ok"
			style="width: 90px" onclick="save()">修改</a> <a href="#"
			class="easyui-linkbutton" iconCls="icon-cancel" style="width: 90px"
			onclick="javascript:$('#dlg2').dialog('close')">取消</a>
	</div>
	<script type="text/javascript" src="../js/rolemanager.js"></script>
</body>
</html>