<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>详细信息</title>

</head>
<body>
	<div
		style="width: 700px; padding-top: 60px; position: relative; left: 200px;">
		<div
			style="padding-left: 30px; background-color: #ccccff; font-size: 15px; padding-top: 5px">
			<strong>查看用户信息</strong>&nbsp;&nbsp;&nbsp;&nbsp; <a
				href="javascript:onclick=back('../order/orderOf','代下订单','reload')"
				class="easyui-linkbutton" iconCls="icon-arrow-rotate-clockwise"
				id="soui">返回</a>
		</div>
		<div style="padding-left: 30px; background-color: #ccccff;">
			您正在查看用户信息，这是用户的基本信息属于用户个人，您只能查看，不能编辑它</div>
		<div
			style="padding-left: 30px; font-size: 15px; padding-top: 5px; background-color: lightyellow;">
			<strong>基本信息</strong>
		</div>
		<div id="user_message" style="padding-left: 30px; height: 115px;">
			<div style="padding-right: 200px; width: 300px">
				<p>客户姓名：${list.name}</p>
				<p>生日：${list.birth }</p>
				<p>邮政编码：425000</p>
				<p>手机号码：${list.phone}</p>
				<p>备注：${list.remarks }</p>
			</div>
			<div
				style="position: relative; left: 250px; top: -137px; width: 300px">
				<p>性别：${list.sex }</p>
				<p>电子邮件：${list.email }</p>
				<p>详细地址：${list.address }</p>
				<p>家庭电话：${list.familyPhone }</p>
				<p>办公电话：${list.workPhone }</p>

			</div>
		</div>
	</div>

	<!-- <script type="text/javascript" src="../js/orderSelect.js"></script>  -->
</body>
</html>