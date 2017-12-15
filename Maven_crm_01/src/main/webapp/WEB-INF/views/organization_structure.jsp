<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>组织结构</title>
<style type="text/css">
#orgform {
	margin: 0;
	padding: 10px 30px;
}


.smallDiv {
	margin-bottom: 5px;
}

.smallDiv label {
	display: inline-block;
	width: 80px;
}

.smallDiv input {
	width: 160px;
}

#orgform2 {
	margin: 0;
	padding: 10px 30px;
}

.smallDiv2 {
	margin-bottom: 5px;
}

.smallDiv2 label {
	display: inline-block;
	width: 80px;
}

.smallDiv2 input {
	width: 160px;
}
</style>
</head>
<body>
	<div style="padding-left: 20px; padding-top: 15px">系统设置>>组织结构</div>
	<div id="div_toolOne"
		style="padding-left: 100px; padding-top: 15px; text-align: left;">
		<select id="select_id" class="easyui-combobox" name="dept"
			style="width: 80px;">
			<option value="aa">名称</option>
		</select> <input type="text" id="searchTitle" class="textbox" name="votem" id="votem"
			style="width: 220px; height: 22px;" /> 
		<a href="#" onclick="org_search()" class="easyui-linkbutton" iconCls="icon-search">搜索</a>
	</div>

	<hr />
	<div style="padding-left: 20px;">
		<strong>角色信息列表</strong>&nbsp;&nbsp;
		 <a class="easyui-linkbutton" iconCls="icon-reload" onclick="javascript:onclick=refresh()">刷新</a>
		&nbsp;&nbsp;
		 <a href="javascript:onclick=orgaddFirst()" class="easyui-linkbutton" iconCls="icon-add">添加</a> 
		 &nbsp;
		 <a href="javascript:onclick=updateOne()" class="easyui-linkbutton" iconCls="icon-edit">修改</a> 
		 &nbsp;
		 <a href="javascript:onclick=deletesDepartment()" class="easyui-linkbutton" iconCls="icon-remove">删除</a>
		 &nbsp;
	</div>
	<table id="organizationManage">
	</table>
	<div id="dlgOrg" class="easyui-dialog"
		style="width: 300px; height: 350px; padding: 10px 20px" closed="true"
		buttons="#dlg-buttons">
		<form id="orgform" method="post">
			<div class="smallDiv">
				<label>组织编码:</label> <input name="dcoding" type="text"
					class="easyui-textbox" required="true">
			</div>
			<p></p>
			<div class="smallDiv">
				<label>组织简称:</label> <input name="dshortname" type="text"
					class="easyui-textbox" required="true">
			</div>
			<p></p>
			<div class="smallDiv">
				<label>组织全称:</label> <input name="dallname" type="text"
					class="easyui-textbox" required="true">
			</div>
			<p></p>
			<div class="smallDiv">
				<label>所属部门:</label>
				<select id="optionOrg" name="dnid">
				       <option value="0">无</option>
				</select>
			</div>
			<p></p>
			<div class="smallDiv">
				<label>部门简介:</label> <input name="dintro" type="text"
					class="easyui-textbox" required="true" />
			</div>
			<p></p>
			<div class="smallDiv">
				<label>备注信息:</label> <input name="dremark" type="text"
					class="easyui-textbox" required="true" />
			</div>
		</form>
	</div>
	<div id="dlg-buttons">
	<a href="#" class="easyui-linkbutton" iconCls="icon-ok" style="width: 90px" onclick="saveOrg()">保存</a>
	 <a href="#" class="easyui-linkbutton" iconCls="icon-cancel" 
	 style="width: 90px" onclick="javascript:$('#dlgOrg').dialog('close')">取消</a>
	</div>


	<div id="dlgOrg2" class="easyui-dialog"
		style="width: 300px; height: 350px; padding: 10px 20px" closed="true"
		buttons="#dlg-buttons">
		<form id="orgform2" method="post">
			<div class="smallDiv">
				<label>组织编码:</label> 
				<input type="hidden" name="did" id="did2">
				<input name="dcoding" type="text" id="dcoding2">
			</div>
			<p></p>
			<div class="smallDiv">
				<label>组织简称:</label>
				<input name="dshortname" type="text" id="dshortname2">
			</div>
			<p></p>
			<div class="smallDiv">
				<label>组织全称:</label> 
				<input name="dallname" type="text" id="dallname2">
			</div>
			<p></p>
			<div class="smallDiv">
				<label>所属部门:</label>
				<select id="optionOrg2" name="dnid">
				       <option value="0">无</option>
				</select>
			</div>
			<p></p>
			<div class="smallDiv">
				<label>部门简介:</label>
				<input name="dintro" type="text" id="dintro2"/>
			</div>
			<p></p>
			<div class="smallDiv">
				<label>备注信息:</label>
				<input name="dremark" type="text" id="dremark2"/>
			</div>
		</form>
	</div>
	<div id="dlg-buttons">
		<a href="javascript:onclick=updateDe()" class="easyui-linkbutton" iconCls="icon-ok"
			style="width: 90px">修改</a> <a href="#"
			class="easyui-linkbutton" iconCls="icon-cancel" style="width: 90px"
			onclick="javascript:$('#dlgOrg2').dialog('close')">取消</a>
	</div>
	<script type="text/javascript" src="../js/organization_structure.js"></script>
</body>
</html>