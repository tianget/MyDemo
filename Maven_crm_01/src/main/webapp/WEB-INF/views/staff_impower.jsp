<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>员工授权操作</title>
</head>
<body>
	<div style="padding-left: 20px; padding-top: 15px">系统设置>>员工管理>>员工授权</div>
	<div id="t_div" style="height: 5px;">
		<div id="user_message" style="padding-left: 260px; height: 140px;">
			<div style="padding-right: 200px; font-size: 15px; width: 300px">
				<p>员工姓名：${staffSee.name}</p>
				<p>入职时间：${staffSee.sdate}</p>
			</div>
		</div>
		<hr />
		<div style="padding-left: 20px;">
			<strong>角色信息列表</strong>&nbsp;&nbsp;
		</div>
		<table id="rolePlace_manager">
		</table>
		&nbsp;
		<hr/>
		<div style="padding-left:420px;">
		<a href="javascript:onclick=impowerPlace()" class="easyui-linkbutton" 
		iconCls="icon-arrow-redo">授权</a>&nbsp;&nbsp;
		<a href="javascript:onclick=back('../system/staff_manager','员工管理','dataBack')" class="easyui-linkbutton" 
		iconCls="icon-arrow-rotate-clockwise">返回</a>
		</div>
	</div>
	<script type="text/javascript" src="../js/staff_manager.js"></script>
</body>
</html>