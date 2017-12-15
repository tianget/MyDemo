<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>角色管理</title>
<style type="text/css">
#fm {
	margin: 0;
	padding: 10px 30px;
}

.ftitle {
	font-size: 14px;
	font-weight: bold;
	padding: 5px 0;
	margin-bottom: 10px;
	border-bottom: 1px solid #ccc;
}

.fitem {
	margin-bottom: 5px;
}

.fitem label {
	display: inline-block;
	width: 80px;
}

.fitem input {
	width: 160px;
}

#role_fm2 {
	margin: 0;
	padding: 10px 30px;
}

.role_ftitle2 {
	font-size: 14px;
	font-weight: bold;
	padding: 5px 0;
	margin-bottom: 10px;
	border-bottom: 1px solid #ccc;
}

.role_fitem2 {
	margin-bottom: 5px;
}

.role_fitem2 label {
	display: inline-block;
	width: 80px;
}

.role_fitem2 input {
	width: 160px;
}
</style>
</head>
<body>
	<div style="padding-left: 20px; padding-top: 15px">系统设置>>角色管理</div>
	<div id="div_toolOne"
		style="padding-left: 100px; padding-top: 15px; text-align: left;">
		<select id="select_id" class="easyui-combobox" name="dept"
			style="width: 80px;">
			<option value="aa">角色名称</option>
			<option>联系电话</option>
		</select> <input type="text" id="searchTitle" class="textbox" name="votem"
			style="width: 220px; height: 22px;" /> 
			<a href="#" onclick="manager_search()" class="easyui-linkbutton" iconCls="icon-search" id="soui">搜索</a>
	</div>

	<hr />
	<div style="padding-left: 20px;">
		<strong>角色信息列表</strong>&nbsp;&nbsp; <a class="easyui-linkbutton"
			iconCls="icon-reload" onclick="javascript:onclick=refresh()"> 刷新</a>
		&nbsp;&nbsp; <a href="javascript:onclick=newEqument()"
			class="easyui-linkbutton" iconCls="icon-add" id="soui">添加</a> &nbsp;<a
			href="javascript:onclick=newUpdate()" class="easyui-linkbutton"
			iconCls="icon-edit" id="soui">修改</a> &nbsp; <a
			href="javascript:onclick=deletes()" class="easyui-linkbutton"
			iconCls="icon-remove" id="soui">删除</a> &nbsp;<a
			href="javascript:onclick=newImpower()" class="easyui-linkbutton"
			iconCls="icon-cart-put" id="soui">授权</a>
	</div>
	<table id="roleManager">
	</table>
	<div id="dlg" class="easyui-dialog"
		style="width: 300px; height: 250px; padding: 10px 20px" closed="true"
		buttons="#dlg-buttons">
		<form id="fm" method="post">
			<div class="fitem">
				<label>角色编码:</label> <input name="rcoding" id="rcoding" type="text"
					class="easyui-textbox" required="true">
			</div>
			<p></p>
			<div class="fitem">
				<label>角色名称:</label> <input name="rname" id="rname" type="text"
					class="easyui-textbox" required="true">
			</div>
			<p></p>
			<div class="fitem">
				<label>所属部门:</label> <select id="role_option" name="did">
				<option value="无">无</option>
				</select>
			</div>
			<p></p>
			<div class="fitem">
				<label>备注信息:</label> <input id="rremark" name="rremark" type="text"
					class="easyui-textbox" required="true" />
			</div>
		</form>
	</div>
	<div id="dlg-buttons">
		<a href="#" class="easyui-linkbutton" iconCls="icon-ok"
			style="width: 90px" onclick="save()">保存</a> <a href="#"
			class="easyui-linkbutton" iconCls="icon-cancel" style="width: 90px"
			onclick="javascript:$('#dlg').dialog('close')">取消</a>
	</div>


	<div id="role_dlg2" class="easyui-dialog"
		style="width: 300px; height: 250px; padding: 10px 20px" closed="true"
		buttons="#dlg-buttons">
		<form id="role_fm2" method="post">
			<div class="role_fitem2">
				<label>角色编码:</label> <input type="hidden" id="rid2" name="rid">
				<input name="rcoding" id="rcoding2" type="text" disabled="disabled">
			</div>
			<p></p>
			<div class="role_fitem2">
				<label>角色名称:</label> <input name="rname" id="rname2" type="text">
			</div>
			<p></p>
			<div class="role_fitem2">
				<label>所属部门:</label> <select id="role_option2" name="did">
				</select>
			</div>
			<p></p>
			<div class="role_fitem2">
				<label>备注信息:</label> <input id="rremark2" name="rremark" type="text" />
			</div>
		</form>
	</div>
	<div id="dlg-buttons">
		<a href="#" class="easyui-linkbutton" iconCls="icon-ok"
			style="width: 90px" onclick="roleManager()">修改</a> <a href="#"
			class="easyui-linkbutton" iconCls="icon-cancel" style="width: 90px"
			onclick="javascript:$('#dlg2').dialog('close')">取消</a>
	</div>

	<div id="navDiv" class="easyui-dialog"
		style="width: 300px; height: 350px; padding: 10px 20px" closed="true"
		buttons="#dlg-buttons">
		<form id="fm3" method="post">
			<ul id="impowerNav"></ul>
		</form>
	</div>
	<div id="dlg-buttons">
		<a href="javascript:onclick=impower()" class="easyui-linkbutton" iconCls="icon-ok"
			style="width: 90px">授权</a> <a href="#"
			class="easyui-linkbutton" iconCls="icon-cancel" style="width: 90px"
			onclick="javascript:$('#navDiv').dialog('close')">取消</a>
	</div>

	<script type="text/javascript" src="../js/rolemanager.js"></script>
</body>
</html>