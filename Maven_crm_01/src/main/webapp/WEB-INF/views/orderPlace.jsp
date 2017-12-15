<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>下单操作</title>
</head>
<body>
	<div style="padding-left: 20px; padding-top: 15px">订单管理>>代下订单>>下单操作</div>
	<div id="t_div" style="height: 5px;">
		<div id="user_message" style="padding-left: 260px; height: 140px;">
			<div style="padding-right: 200px; font-size: 15px; width: 300px">
				<p>客户姓名：${list.userName}</p>
				<p>客户类型：${list.m_type}</p>
				<p>联系电话：13252512521</p>
				<p>已消费次数：${list.num }</p>
			</div>
			<div
				style="font-size: 15px; position: relative; left: 250px; top: -135px; width: 300px">
				<p>性别：${list.m_sex}</p>
				<p>客户状态：${list.m_status }</p>
				<p>服务代表：${list.sname }</p>
				<p>消费总额：${list.sum }</p>
			</div>
		</div>
		<hr />
		<div style="padding-left: 20px;">
			<strong>商品信息列表</strong>&nbsp;&nbsp;
		</div>
		<table id="orderPlace">

		</table>
		&nbsp;
		<hr/>
		<div style="padding-left:420px;">
		<a href="javascript:onclick=placeTwo()" class="easyui-linkbutton" 
		iconCls="icon-arrow-redo" id="soui">下一步</a>&nbsp;&nbsp;
		<a href="javascript:onclick=place()" class="easyui-linkbutton" 
		iconCls="icon-arrow-rotate-clockwise" id="soui">返回</a>
		</div>
	</div>
	<script type="text/javascript" src="../js/orderPlace.js"></script>
</body>
</html>