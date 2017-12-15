<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>基础信息</title>
<style type="text/css">
#base_fm {
	margin: 0;
	padding: 10px 30px;
}

.base_ftitle {
	font-size: 14px;
	font-weight: bold;
	padding: 5px 0;
	margin-bottom: 10px;
	border-bottom: 1px solid #ccc;
}

.base_fitem {
	margin-bottom: 5px;
}

.base_fitem label {
	display: inline-block;
	width: 80px;
}

.base_fitem input {
	width: 160px;
}

#base_fm2 {
	margin: 0;
	padding: 10px 30px;
}

.base_ftitle2 {
	font-size: 14px;
	font-weight: bold;
	padding: 5px 0;
	margin-bottom: 10px;
	border-bottom: 1px solid #ccc;
}

.base_fitem2 {
	margin-bottom: 5px;
}

.base_fitem2 label {
	display: inline-block;
	width: 80px;
}

.base_fitem2 input {
	width: 160px;
}
</style>
</head>
<body>
	<div style="padding-left: 20px; padding-top: 15px">系统设置>>基础信息</div>
	<div id="div_toolOne"
		style="padding-left: 100px; padding-top: 15px; text-align: left;">
		<select id="select_name" class="easyui-combobox" name="dept"
			style="width: 80px;">
			<option value="aa">关键字</option>
		</select> <input type="text" id="base_searchTitle" class="textbox"
			name="votem" style="width: 220px; height: 22px;" /> <a href="#"
			onclick="base_search()" class="easyui-linkbutton"
			iconCls="icon-search">搜索</a>
	</div>

	<hr />
	<div style="padding-left: 20px;">
		<strong>基础信息列表</strong>&nbsp;&nbsp;
	<a href="javascript:onclick=refresh()" class="easyui-linkbutton" iconCls="icon-reload">刷新</a>
		&nbsp;&nbsp;
	 <a href="javascript:onclick=base_save()" class="easyui-linkbutton" iconCls="icon-add">添加</a>
	  &nbsp;
	 <a href="javascript:onclick=base_update()" class="easyui-linkbutton" iconCls="icon-edit">修改</a>
	  &nbsp;
	 <a href="javascript:onclick=delete_base()" class="easyui-linkbutton" iconCls="icon-remove">删除</a>
	   &nbsp;
	</div>
	<table id="base_manager">
	</table>
	<div id="base_dlg" class="easyui-dialog"
		style="width: 300px; height: 300px; padding: 10px 20px" closed="true"
		buttons="#base-dlg-buttons1">
		<form id="base_fm" method="post">
			<div class="base_fitem">
				<label>关键字:</label>&nbsp;&nbsp;<input name="basecoding"
					type="text" class="easyui-textbox" required="true">
			</div>
			<p></p>
			<div class="base_fitem">
				<label>参数值:</label>&nbsp;&nbsp;<input name="basevalue"type="text"
					class="easyui-textbox" required="true">
			</div>
			<p></p>
			<div class="base_fitem">
				<label>参数描述:</label> <input name="basedesc" type="text"
					class="easyui-textbox" required="true" />
			</div>
			<p></p>
			<div class="base_fitem">
				<label>备注信息:</label> <input name="baseremark" type="text"
					class="easyui-textbox" required="true" />
			</div>
		</form>
	</div>
	<div id="base-dlg-buttons1">
		<a href="#" class="easyui-linkbutton" iconCls="icon-ok"
			style="width: 90px" onclick="start_base_save()">保存</a> <a href="#"
			class="easyui-linkbutton" iconCls="icon-cancel" style="width: 90px"
			onclick="javascript:$('#base_dlg').dialog('close')">取消</a>
	</div>
	<div id="base_dlg2" class="easyui-dialog"
		style="width: 300px; height: 250px; padding: 10px 20px" closed="true"
		buttons="#base-dlg-buttons2">
		<form id="base_fm2" method="post">
			<div class="base_fitem">
				<input name="baseid" id="baseid2" type="hidden">
				<label>关键字:</label>&nbsp;&nbsp;<input name="basecoding" id="basecoding2" type="text">
			</div>
			<p></p>
			<div class="base_fitem">
				<label>参数值:</label>&nbsp;&nbsp;<input name="basevalue" id="basevalue2" type="text" >
			</div>
			<p></p>
			<div class="base_fitem">
				<label>参数描述:</label> <input name="basedesc" id="basedesc2" type="text" />
			</div>
			<p></p>
			<div class="base_fitem">
				<label>备注信息:</label> <input name="baseremark" type="text" id="baseremark2" />
			</div>
		</form>
	</div>
	<div id="base-dlg-buttons2">
		<a href="#" class="easyui-linkbutton" iconCls="icon-ok"
			style="width: 90px" onclick="base_update_start()">修改</a> <a href="#"
			class="easyui-linkbutton" iconCls="icon-cancel" style="width: 90px"
			onclick="javascript:$('#base_dlg2').dialog('close')">取消</a>
	</div>
	<script type="text/javascript" src="../js/base_manager.js"></script>
</body>
</html>