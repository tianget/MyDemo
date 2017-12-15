<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>订单结算</title>
<link rel="stylesheet" type="text/css" href="../css/sellPlan.css" />
</head>
<body>
	<div style="padding-left: 20px; padding-top: 15px">订单管理>>代下订单>>下单操作>>订单结算</div>
	<p></p>
	<div
		style="width: 700px; padding-top: 5px; position: relative; left: 200px;">
		<div
			style="padding-left: 30px; background-color: #ccccff; font-size: 15px; padding-top: 5px">
			<strong>填写并核对订单信息</strong>&nbsp;&nbsp;&nbsp;&nbsp; <a
				href="javascript:onclick=backFinal('../order/orderPlace','下单操作','refreshre')"
				class="easyui-linkbutton" iconCls="icon-arrow-rotate-clockwise"
				id="fan">返回</a>
		</div>
		<div
			style="padding-left: 30px; font-size: 15px; padding-top: 5px; background-color: lightyellow;">
			<strong>收货人信息</strong>&nbsp;&nbsp;&nbsp;&nbsp;
		</div>
		<div id="zhi" style="padding-left: 30px; height: 80px;">
			<div style="padding-right: 200px; width: 300px">
					<input id="lid" value="${list.m_id }" type="hidden" />
				姓名：<input id='liname' value="${list.userName }"
					style="border-bottom: 0px; border-top: 0px; border-left: 0px; border-right: 0px"></input><br />
				<p></p>
				地址：<input id='liaddress' value="${list.m_address}"
					style="border-bottom: 0px; border-top: 0px; border-left: 0px; border-right: 0px"></input>
					<br />
				<p></p>
				联系方式：
				<input id='liphone' value="${list.m_phone }"
					style="border-bottom: 0px; border-top: 0px; border-left: 0px; border-right: 0px"></input>
			</div>
		</div>
		<div
			style="padding-left: 30px; font-size: 15px; padding-top: 5px; background-color: lightyellow;">
			<strong>支付及配送方式</strong>
		</div>
		<div id="smessage" style="padding-left: 30px; height: 40px">
			<div style="padding-right: 200px; width: 300px">
				支付方式：<select id="o">
					<option id="1">货到付款</option>
					<option id="2">在线支付</option>
					
					
				</select> <br /> 配送方式：<input id='lihuo' value="送货上门"
					style="border-bottom: 0px; border-top: 0px; border-left: 0px; border-right: 0px"></input>
			</div>
		</div>
		<div
			style="padding-left: 30px; font-size: 15px; padding-top: 5px; background-color: lightyellow;">
			<strong>发票信息</strong>&nbsp;&nbsp;&nbsp;&nbsp;
		</div>
		<div id="ussage" style="padding-left: 30px; height: 50px">
			<div style="padding-right: 200px; width: 300px">
				<br /> <input id='lizhi' value="公司 明细"
					style="border-bottom: 0px; border-top: 0px; border-left: 0px; border-right: 0px"></input><br />
			</div>
			订单类型：<select id="e">
				<option id="3">普通订单</option>
				<option id="5">特急加快</option>
			</select>

		</div>
		<div
			style="padding-left: 30px; font-size: 15px; padding-top: 5px; background-color: lightyellow;">
			<strong>商品清单</strong>
		</div>
		<div style="position: relative">
			<div id="sr_message" style="padding-left: 30px;">
				<div id="orderPlacere">
					<%-- <table id="s_tsb" style="padding-left: 50px">
						<tr>
							<td>商品名称</td>
							<td style="padding-left: 50px">商品类型</td>
							<td style="padding-left: 50px">单价（单位：万元）</td>
							<td style="padding-left: 50px">数量</td>
						</tr>
						<c:forEach items="${good}" var="ts">
							<tr>
								<td id="tss">${ts.gname}</td>
								<td style="padding-left: 50px">${ts.gtype}</td>
								<td style="padding-left: 50px">${ts.gprice }</td>
								<td style="padding-left: 50px">${ts.peopleNum }</td>
							</tr>
						</c:forEach>
					</table> --%>
					<c:forEach items="${good}" var="ts">
					<input id="is" value="${ts.gid }" type="hidden" />
					商品名称：<input id="sname" value="${ts.gname}"style="width:90px;border-bottom: 0px; border-top: 0px; border-left: 0px; border-right: 0px" />
					类型：<input id="stype" value="${ts.gtype}" style="width:90px;border-bottom: 0px; border-top: 0px; border-left: 0px; border-right: 0px"/>
					商品价格：<input id="sprice" value="${ts.gprice }"style="width:50px;border-bottom: 0px; border-top: 0px; border-left: 0px; border-right: 0px" />
					数量：<input id="snum" value="${ts.peopleNum }"style="width:50px;border-bottom: 0px; border-top: 0px; border-left: 0px; border-right: 0px" /></br>
					</c:forEach>
				</div>
			</div>
		</div>
		<div
			style="padding-left: 30px; font-size: 15px; padding-top: 5px; background-color: lightyellow;">
			<strong>费用信息</strong>
		</div>
		<div id="user_message" style="padding-left: 199px; height: 110px;">
			<div style="width: 490px; float: right;">

				<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					运费：￥0.00元</p>
				<p>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<span>应付总额：￥${to}元</span>
				</p>
				<hr />
				<p>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<strong><span>应付总额：￥${to}元</span></strong>&nbsp;&nbsp;&nbsp;&nbsp;<input
						onclick="buttonS()" type="button" value="提交订单" />
				</p>
			</div>
		</div>

		<div
			style="padding-left: 30px; font-size: 15px; padding-top: 5px; background-color: lightyellow;">

		</div>
	</div>

	<script type="text/javascript" src="../js/orderFinal.js"></script>
</body>
</html>