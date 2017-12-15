<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>数据字典</title>
<style type="text/css">
#data_dictionary_fm {
	margin: 0;
	padding: 10px 30px;
}

.data_dictionary_ftitle {
	font-size: 14px;
	font-weight: bold;
	padding: 5px 0;
	margin-bottom: 10px;
	border-bottom: 1px solid #ccc;
}

.data_dictionary_fitem {
	margin-bottom: 5px;
}

.data_dictionary_fitem label {
	display: inline-block;
	width: 80px;
}

.data_dictionary_fitem input {
	width: 160px;
}

#data_dictionary_fm2 {
	margin: 0;
	padding: 10px 30px;
}

.data_dictionary_ftitle2 {
	font-size: 14px;
	font-weight: bold;
	padding: 5px 0;
	margin-bottom: 10px;
	border-bottom: 1px solid #ccc;
}

.data_dictionary_fitem2 {
	margin-bottom: 5px;
}

.data_dictionary_fitem2 label {
	display: inline-block;
	width: 80px;
}

.data_dictionary_fitem2 input {
	width: 160px;
}
</style>
</head>
<body>
	<div style="padding-left: 20px; padding-top: 15px">系统设置>>数据字典</div>
	<div id="div_toolOne"
		style="padding-left: 100px; padding-top: 15px; text-align: left;">
		<select id="select_name" class="easyui-combobox" name="dept"
			style="width: 80px;">
			<option value="aa">关键字</option>
		</select> <input type="text" id="data_dictionary_searchTitle" class="textbox"
			name="votem" style="width: 220px; height: 22px;" /> <a href="#"
			onclick="data_dictionary_search()" class="easyui-linkbutton"
			iconCls="icon-search">搜索</a>
	</div>

	<hr />
	<div style="padding-left: 20px;">
		<strong>数据字典列表</strong>&nbsp;&nbsp;
	<a href="javascript:onclick=refresh()" class="easyui-linkbutton" iconCls="icon-reload">刷新</a>
		&nbsp;&nbsp;
	 <a href="javascript:onclick=data_dictionary_save()" class="easyui-linkbutton" iconCls="icon-add">添加</a>
	  &nbsp;
	 <a href="javascript:onclick=data_dictionary_update()" class="easyui-linkbutton" iconCls="icon-edit">修改</a>
	  &nbsp;
	 <a href="javascript:onclick=delete_data_dictionary()" class="easyui-linkbutton" iconCls="icon-remove">删除</a>
	   &nbsp;
	</div>
	<table id="data_dictionary_manager">
	</table>
	<div id="data_dictionary_dlg" class="easyui-dialog"
		style="width: 300px; height: 300px; padding: 10px 20px" closed="true"
		buttons="#data_dictionary-dlg-buttons1">
		<form id="data_dictionary_fm" method="post">
			<div class="data_dictionary_fitem">
				<label>名称:</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<input name="dataname" type="text" class="easyui-textbox" required="true">
			</div>
			<p></p>
			<div class="data_dictionary_fitem">
				<label>参数代码:</label>&nbsp;&nbsp;<input name="datacoding" type="text"
					class="easyui-textbox" required="true">
			</div>
			<p></p>
			<div class="data_dictionary_fitem">
				<label>数据值:&nbsp;&nbsp;&nbsp;
				</label> <input name="datavalue" type="text" class="easyui-textbox" required="true" />
			</div>
			<p></p>
			<div class="data_dictionary_fitem">
				<label>备注信息:</label> <input name="dataremark" type="text"
					class="easyui-textbox" required="true" />
			</div>
		</form>
	</div>
	<div id="data_dictionary-dlg-buttons1">
		<a href="#" class="easyui-linkbutton" iconCls="icon-ok"
			style="width: 90px" onclick="start_data_dictionary_save()">保存</a> <a href="#"
			class="easyui-linkbutton" iconCls="icon-cancel" style="width: 90px"
			onclick="javascript:$('#data_dictionary_dlg').dialog('close')">取消</a>
	</div>
	<div id="data_dictionary_dlg2" class="easyui-dialog"
		style="width: 300px; height: 250px; padding: 10px 20px" closed="true"
		buttons="#data_dictionary-dlg-buttons2">
		<form id="data_dictionary_fm2" method="post">
			<div class="data_dictionary_fitem">
				<input name="dataid" id="dataid2" type="hidden">
				<label>名称:</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<input name="dataname" id="dataname2" type="text">
			</div>
			<p></p>
			<div class="data_dictionary_fitem">
				<label>参数代码:</label>&nbsp;&nbsp;
				<input name="datacoding" id="datacoding2" type="text" >
			</div>
			<p></p>
			<div class="data_dictionary_fitem">
				<label>数据值:</label>&nbsp;&nbsp;&nbsp;
				<input name="datavalue" id="datavalue2" type="text" />
			</div>
			<p></p>
			<div class="data_dictionary_fitem">
				<label>备注信息:</label>
				 <input name="dataremark" type="text" id="dataremark2" />
			</div>
		</form>
	</div>
	<div id="data_dictionary-dlg-buttons2">
		<a href="#" class="easyui-linkbutton" iconCls="icon-ok"
			style="width: 90px" onclick="data_dictionary_update_start()">修改</a> <a href="#"
			class="easyui-linkbutton" iconCls="icon-cancel" style="width: 90px"
			onclick="javascript:$('#data_dictionary_dlg2').dialog('close')">取消</a>
	</div>
	<script type="text/javascript" src="../js/data_dictionary_manager.js"></script>
</body>
</html>