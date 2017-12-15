<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>新增角色</title>
<!-- <link rel="stylesheet" type="text/css"
	href="../easyui/themes/default/easyui.css" />
<link rel="stylesheet" type="text/css" href="../easyui/themes/icon.css" />
<link rel="stylesheet" type="text/css" href="../css/home.css" />
<script type="text/javascript" src="../easyui/jquery.min.js"></script>
<script type="text/javascript" src="../easyui/jquery.easyui.min.js"></script>
<script type="text/javascript"
	src="../easyui/locale/easyui-lang-zh_CN.js"></script> -->
<!-- <script type="text/javascript" src="../js/jquery.min.js"></script> -->
<script type="text/javascript">
	$(function() {
		$.ajax({
			url : "../system/getDepartment",
			type : "post",
			success : function(data) {
				console.log(data);
				$("#option").html("");
				var str = "";
				if (data) {
					for (var i = 0; i < data.length; i++) {
						str += "<option value='"+data[i].did+"'>"
								+ data[i].dshortname + "</option>"
					}
				}
				$("#option").append(str);
			}
		});
	});
</script>
</head>
<style type="text/css">
.main {
	border-right-width: 1px;
	border-right-style: solid;
	border-right-color: #bebcbc;
	border-bottom-color: #bebcbc;
	border-bottom-style: solid;
	border-bottom-width: 1px;
}

.description {
	width: 110Px;
	height: 36px;
	background-color: #F1F6FF;
	border: 1px solid #bebcbc;
	border-bottom-width: 0px;
	border-right-width: 0px;
	line-height: 36px;
	padding-left: 12px;
	font-family: 微软雅黑;
	float: left;
}

.description.content {
	background-color: #FAFCFF;
	width: 160px;
}

.clearFix:after {
	clear: both; /*添加清除浮动属性*/
	display: block; /*将它设为块状元素*/
	content: "."; /*这个块状元素的内容为一个 . 其实也可以不设，因为下面要隐藏掉它*/
	visibility: hidden; /*将它隐藏掉*/
	height: 0; /*将它高度设为0px*/
	line-height: 0; /*将它行高设为0px;*/
}
</style>

</head>

<body>
	<table id="dg"></table>
	<div id="menu" class="easyui-menu">
		<div onclick="doAdd()">新增</div>
		<div onclick="doEdit()">编辑</div>
		<div onclick="doRemove()">删除</div>
	</div>
	<div id="DivAdd" class="easyui-dialog"
		style="width: 650px; height: 250px; padding: 10px 20px" closed="true"
		resizable="true" modal="true"
		data-options="iconCls: 'icon-add',buttons: '#dlg-buttons'">
		<form id="formAdd" method="post" novalidate="novalidate">
			<div class="main">
				<div class="clearFix">
					<div class="description">用户姓名：</div>
					<div class="description content">
						<input type="text" name="Name" style="height: 20px">
					</div>
					<div class="description">年龄：</div>
					<div class="description content">
						<input type="text" name="Age" style="height: 21px">
					</div>

				</div>
				<div class="clearFix">
					<div class="description">电话：</div>
					<div class="description content">
						<input type="text" name="Phone" style="height: 21px">
					</div>
					<div class="description">邮箱：</div>
					<div class="description content">
						<input type="text" name="Email" style="height: 21px">
					</div>
				</div>

				<div class="clearFix">

					<div class="description">更新时间：</div>
					<div class="description content">
						<input class="easyui-datebox" type="text" id="txtLastUpdated"
							name="txtLastUpdated" />
					</div>

					<div class="description">父节点：</div>
					<div class="description content">
						<select id="box" class="easyui-combobox" name="box"
							style="width: 150px;">
							<option value="aaaa">电子商务</option>
							<option value="bbbb">经济管理</option>
							<option value="cccc">软件技术</option>
						</select>
					</div>

				</div>
				<div class="clearFix">
					<div>
						<div class="description">性别：</div>
						<div class="description content">
							<span>男</span><span> 女</span>
						</div>

					</div>
					<div class="description">爱好：</div>
					<div class="description content">
						<span>篮球</span> <span>足球</span>
					</div>
				</div>
			</div>

			<div class="clearFix">
				<div style="text-align: right; padding-top: 10px">
					<a href="javascript:void(0)" class="easyui-linkbutton"
						id="btnAddOK" iconcls="icon-ok" onclick="btnAddOK()">确定</a> <a
						href="javascript:void(0)" class="easyui-linkbutton"
						iconcls="icon-cancel"
						onclick="javascript:$('#DivAdd').dialog('close')">关闭</a>
				</div>
			</div>

		</form>
	</div>

</body>
<!-- <body>
	<form action="../system/insertRole" method="post">
		<table id="role_add_table">
			<tr>
				<td></td>
				<td><h2>新增角色</h2></td>
			</tr>
			<tr>
				<td>角色编码：</td>
				<td><input name="rcoding" /></td>
			</tr>
			<tr>
				<td>角色名称：</td>
				<td><input name="rname"/></td>
			</tr>
			<tr>
				 <td>所属部门：</td>
				<td>
				<select name="department" id="option"></select></td> 
			</tr>
			<tr>
				<td>备注信息：</td>
				<td><input name="rremark" /></td>
			</tr>
			<tr>
				<td></td>
				<td> <input type="image"
					src="../easyui/themes/icons/arrow-left.png" />
					&nbsp;&nbsp;&nbsp;&nbsp;<input type="image"
					src="../easyui/themes/icons/button-white-check.png" />
					<input type="submit"
					 />
					</td>
			</tr>
		</table>
	</form>
	<form action="../system/insertRole" method="post">
	<table id="role_add_table">
		<tr>
		<td>角色编码</td>
		<td><input  name="rcoding" /></td>
		</tr>
		<input  name="rname"/>
		<tr>
		<td><input type="submit"/></td>
		</tr>
		</table>
	</form>
	<link rel="stylesheet" type="text/css" href="../css/role_add.css" />
</body> -->
</html>