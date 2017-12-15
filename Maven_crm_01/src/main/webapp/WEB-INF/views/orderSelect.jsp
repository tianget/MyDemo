<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查询订单详细信息</title>

</head>
<body>
	<div
		style="width: 700px; padding-top: 5px; position: relative; left: 200px;">
		<div
			style="padding-left: 30px; background-color: #ccccff; font-size: 15px; padding-top: 5px">
			<strong>查看订单详情</strong>&nbsp;&nbsp;&nbsp;&nbsp; <a
				href="javascript:onclick=back('../order/orderInquiry','订单查询','orderInquiry')"
				class="easyui-linkbutton" iconCls="icon-arrow-rotate-clockwise"
				id="soui">返回</a>
		</div>
		<div style="padding-left: 30px; background-color: #ccccff;">
			您正在查看订单详情，您只能查看，不能编辑它</div>
		<div
			style="padding-left: 30px; font-size: 15px; padding-top: 5px; background-color: lightyellow;">
			<strong>基本信息</strong>
		</div>
		<div id="user_message" style="padding-left: 30px; height: 115px;">
			<div style="padding-right: 200px; width: 300px">
				<p>订单号：${list.o_onum }</p>
				<p>订单类型：${list.o_otype }</p>
				<p>支付方式：${list.o_opayment }</p>
				<p>配送方式：送货上门</p>
			</div>
			<div
				style="position: relative; left: 250px; top: -110px; width: 300px">
				<p>订单状态：${list.o_ostatus}</p>
				<p>下单时间：${list.o_otime }</p>
				<p>支付时间：</p>
				<p>订单来源：本站</p>
			</div>
		</div>
		<div
			style="padding-left: 30px; font-size: 15px; padding-top: 5px; background-color: lightyellow;">
			<strong>收货人信息</strong>
		</div>
		<div id="user_message" style="padding-left: 30px; height: 115px">
			<div style="padding-right: 200px; width: 300px">
				<p>收货人姓名：${list.c_cname }</p>
				<p>详细地址：${list.c_address}</p>
				<p>家庭电话：${list.c_familyPhone}</p>
				<p>办公电话：${list.c_workPhone}</p>
			</div>
			<div
				style="position: relative; left: 250px; top: -110px; width: 300px">
				<p>电子邮件：${list.c_email}</p>
				<p>邮政编码：431000</p>
				<p>手机号码：${list.c_phone}</p>
				<p>最佳发货时间：仅在工作日送货</p>
			</div>
		</div>
		<div
			style="padding-left: 30px; font-size: 15px; padding-top: 5px; background-color: lightyellow;">
			<strong>商品信息</strong>
		</div>
		<div style="position: relative">
			<div id="user_message" style="padding-left: 30px;">
				<div id="te"></div>
			</div>

		</div>
		<div
			style="padding-left: 30px; font-size: 15px; padding-top: 5px; background-color: lightyellow;">
			<strong>其他信息</strong>
		</div>
		<div id="user_message" style="padding-left: 30px; height: 70px;">
			<div style="padding-right: 200px; width: 400px;">
				<p style="float: right;">发票内容：</p>
				<p>发票信息：公司明细</p>
				<p>客户给商家留言：</p>
			</div>

		</div>
		<div
			style="padding-left: 30px; font-size: 15px; padding-top: 5px; background-color: lightyellow;">
			<strong>费用信息</strong>
		</div>
		<div id="user_message" style="padding-left: 199px; height: 110px;">
			<div style="width: 490px; float: right;">
				<p>商品金融：￥${list.order_money}元
					+发票收费：￥0.00元+配送费用：￥0.00元+支付费用：￥0.00元</p>
				<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					=订单总金额：￥${list.order_money}元</p>
				<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					现金折扣：￥0.00元 - 已支付金额：￥${list.order_money}元 =
					您支付金额：￥${list.order_money}元</p>
			</div>
		</div>
		<div
			style="padding-left: 30px; font-size: 15px; padding-top: 5px; background-color: lightyellow;">

		</div>
	</div>

	<!-- <script type="text/javascript" src="../js/orderSelect.js"></script>  -->
</body>
</html>