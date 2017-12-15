<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>状态更改</title>
</head>
<body>
	<div
		style="width: 700px; padding-top: 5px; position: relative; left: 200px;">
		<div
			style="padding-left: 30px; background-color: #ccccff; font-size: 15px; padding-top: 5px">
			<strong>订单状态</strong>&nbsp;&nbsp;&nbsp;&nbsp; <a
				href="javascript:onclick=back('../order/orderInquiry','订单查询','orderInquiry')"
				class="easyui-linkbutton" iconCls="icon-arrow-rotate-clockwise"
				id="soui">返回</a>
		</div>
		<div style="padding-left: 30px; background-color: #ccccff;">
			订单状态，可以编辑它</div>
		<div
			style="padding-left: 30px; font-size: 15px; padding-top: 5px; background-color: lightyellow;">
			<strong>基本信息</strong>
		</div>
		<div id="user_message" style="padding-left: 30px; height: 115px">
			<div style="padding-right: 200px; width: 300px">
				<p>收货人姓名：${list.c_cname }</p>
				<p>商品名称：${list.g_gname}</p>
				<p>订单编号：${list.o_onum}</p>
				<p>订单类型：${list.o_otype}</p>
			</div>
			<div
				style="position: relative; left: 250px; top: -110px; width: 300px">
				<p>订单金额：${list.order_money}</p>
				<p>邮政编码：431000</p>
			</div>
		</div>



		<div
			style="padding-left: 30px; font-size: 15px; padding-top: 5px; background-color: lightyellow;">

		</div>
	</div>

</body>
</html>