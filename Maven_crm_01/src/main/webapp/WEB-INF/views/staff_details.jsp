<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>员工个人信息</title>
</head>
<body>
	<div
		style="width: 800px; height: 300px; padding-top: 50px; position: relative; left: 200px;">
		<div id="title"
			style="padding-left: 20px; padding-top: 15px; position: relative; left: -180px; top: -40px;">系统设置>>个人信息>>查看员工信息</div>
		<div
			style="padding-left: 30px; background-color: #ccccff; font-size: 15px; padding-top: 5px">
			<!-- <a href="javascript:onclick=place()" class="easyui-linkbutton"
				iconCls="icon-arrow-rotate-clockwise" id="soui">返回</a> -->
		</div>
		<div
			style="padding-left: 30px; font-size: 15px; padding-top: 5px; background-color: lightyellow;">
			<strong>基本信息</strong>
		</div>
		<div id="user_message" style="padding-left: 60px; height: 115px;">
			<div style="padding-right: 250px; width: 300px; font-size: 18px;">
				<p>员工姓名：${staffSee.name}</p>
				<p>性别：${staffSee.sex}</p>
				<p>就职状态：${staffSee.sstate}</p>
				<p>登录id：${staffSee.nusername}</p>
			</div>
			<div
				style="padding-left: 100px; position: relative; left: 250px; top: -170px; width: 300px; font-size: 18px;">
				<p>员工编号：${staffSee.sid}</p>
				<p>个人描述：${staffSee.sremark}</p>
				<p>就职时间：${staffSee.sdate}</p>
				<p>联系电话：${staffSee.iphonenumber}</p>
			</div>
		</div>
		<a href="javascript:onclick=back('../system/staff_manager','员工管理','dataBack')" class="easyui-linkbutton"
				iconCls="icon-arrow-rotate-clockwise" style="position: relative;left: 300px;top: 80px" >返回</a>
	</div>
</body>
</html>