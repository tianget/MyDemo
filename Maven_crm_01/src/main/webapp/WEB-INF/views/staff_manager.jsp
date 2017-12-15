<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>员工管理</title>
<style type="text/css">
#staff_fm {
	margin: 0;
	padding: 10px 30px;
}

.staff_ftitle {
	font-size: 14px;
	font-weight: bold;
	padding: 5px 0;
	margin-bottom: 10px;
	border-bottom: 1px solid #ccc;
}

.staff_fitem {
	margin-bottom: 5px;
}

.staff_fitem label {
	display: inline-block;
	width: 80px;
}

.staff_fitem input {
	width: 160px;
}

#staff_fm2 {
	margin: 0;
	padding: 10px 30px;
}

.staff_ftitle2 {
	font-size: 14px;
	font-weight: bold;
	padding: 5px 0;
	margin-bottom: 10px;
	border-bottom: 1px solid #ccc;
}

.staff_fitem2 {
	margin-bottom: 5px;
}

.staff_fitem2 label {
	display: inline-block;
	width: 80px;
}

.staff_fitem2 input {
	width: 160px;
}
</style>
</head>
<body>
	<div style="padding-left: 20px; padding-top: 15px">系统设置>>员工管理</div>
	<div id="div_toolOne"
		style="padding-left: 100px; padding-top: 15px; text-align: left;">
		<select id="select_name" class="easyui-combobox" name="dept"
			style="width: 80px;">
			<option value="aa">员工姓名</option>
		</select> <input type="text" id="staff_searchTitle" class="textbox"
			name="votem" style="width: 220px; height: 22px;" /> <a href="#"
			onclick="staff_search()" class="easyui-linkbutton"
			iconCls="icon-search">搜索</a>
	</div>

	<hr />
	<div style="padding-left: 20px;">
		<strong>角色信息列表</strong>&nbsp;&nbsp; <a class="easyui-linkbutton"
			iconCls="icon-reload" onclick="javascript:onclick=refresh()"> 刷新</a>
		&nbsp;&nbsp;
	 <a href="javascript:onclick=newSave()" class="easyui-linkbutton" iconCls="icon-add">添加</a>
	  &nbsp;
	 <a href="javascript:onclick=staff_newUpdate()" class="easyui-linkbutton" iconCls="icon-edit">修改</a>
	  &nbsp;
	 <!-- <a href="javascript:onclick=deletes()" class="easyui-linkbutton" iconCls="icon-login">启用/禁用</a> -->
	  &nbsp;
	 <a href="javascript:onclick=delete_staff()" class="easyui-linkbutton" iconCls="icon-remove">删除</a>
	   &nbsp;
	 <a href="javascript:onclick=see('../system/staffDDD','员工个人信息查看','refresh')" class="easyui-linkbutton" iconCls="icon-search">查看</a>
	  &nbsp;
	  <a href="javascript:onclick=impowerRole('../system/staff_impower','员工授权','refresh')" class="easyui-linkbutton" iconCls="icon-cart-put">授权</a>
	</div>
	<table id="staff_manager">
	</table>
	<div id="staff_dlg" class="easyui-dialog"
		style="width: 300px; height: 350px; padding: 10px 20px" closed="true"
		buttons="#staff-dlg-buttons1">
		<form id="staff_fm" method="post">
			<div class="staff_fitem">
				<label>登录名:&nbsp;&nbsp;&nbsp;</label> <input name="nusername" id="nusername"
					type="text" class="easyui-textbox" required="true">
			</div>
			<p></p>
			<div class="staff_fitem">
				<label>员工姓名:</label> <input name="name" id="name" type="text"
					class="easyui-textbox" required="true">
			</div>
			<p></p>
			<div class="staff_fitem">
				性别：<input type="radio" value="男" name="sex" checked="checked">男 
				<input type="radio" value="女" name="sex">女
			</div>
			<p></p>
			<div class="staff_fitem">
				状态：<input type="radio" value="正常" name="sstate" checked="checked">启用
				<input type="radio" value="禁用" name="sstate">禁用
			</div>
			<p></p>
			<div class="staff_fitem">
				<label>所属部门:</label> <select id="staff_option" name="did">
					<option value="无">无</option>
				</select>
			</div>
			<p></p>
			<div class="staff_fitem">
				<label>电话号码:</label> <input id="iphonenumber" name="iphonenumber" type="text"
					class="easyui-textbox" required="true" />
			</div>
			<p></p>
			<div class="staff_fitem">
				<label>备注信息:</label> <input id="sremark" name="sremark" type="text"
					class="easyui-textbox" required="true" />
			</div>
		</form>
	</div>
	<div id="staff-dlg-buttons1">
		<a href="#" class="easyui-linkbutton" iconCls="icon-ok"
			style="width: 90px" onclick="save()">保存</a> <a href="#"
			class="easyui-linkbutton" iconCls="icon-cancel" style="width: 90px"
			onclick="javascript:$('#staff_dlg').dialog('close')">取消</a>
	</div>
	<div id="staff_dlg2" class="easyui-dialog"
		style="width: 300px; height: 350px; padding: 10px 20px" closed="true"
		buttons="#staff-dlg-buttons2">
		<form id="staff_fm2" method="post">
			<div class="staff_fitem2">
				<label>员工编码:</label>
				<input name="sid" id="sid2" type="text" readonly="true">
			</div>
			<p></p>
			<div class="staff_fitem2">
				<label>员工姓名:</label> <input name="name" id="name2" type="text" >
			</div>
			<p></p>
			<div class="staff_fitem2">
				性别：<input type="radio" value="男" name="sex" checked="checked"/>男 
				<input type="radio" value="女" name="sex" />女
			</div>
			<p></p>
			<div class="staff_fitem2">
				状态：<input type="radio" value="启用" name="sstate"/>启用
				<input type="radio" value="禁用" name="sstate" />禁用
			</div>
			<p></p>
			<div class="staff_fitem2">
				<label>所属部门:</label> <select id="staff_option2" name="did">
					<option value="无">无</option>
				</select>
			</div>
			<p></p>
			<div class="staff_fitem2">
				<label>电话号码:</label> <input id="iphonenumber2" name="iphonenumber" type="text" />
			</div>
			<p></p>
			<div class="staff_fitem2">
				<label>备注信息:</label> <input id="sremark2" name="sremark" type="text" />
			</div>
		</form>
	</div>
	<div id="staff-dlg-buttons2">
		<a href="#" class="easyui-linkbutton" iconCls="icon-ok"
			style="width: 90px" onclick="staff_update()">修改</a> <a href="#"
			class="easyui-linkbutton" iconCls="icon-cancel" style="width: 90px"
			onclick="javascript:$('#staff_dlg2').dialog('close')">取消</a>
	</div>
	<script type="text/javascript" src="../js/staff_manager.js"></script>
</body>
</html>