<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>代下订单</title>
</head>
<body>
	<div style="padding-left: 20px; padding-top: 15px">订单管理>>代下订单</div>
	<div id="div_toolOne"
		style="padding-left: 100px; padding-top: 15px; text-align: left;">
		<!-- <select id="select_id" class="easyui-combobox" name="dept"
			style="width: 80px;">
			<option value="客户姓名">客户姓名</option>			
		</select>  -->
		<strong>客户姓名：</strong> <input type="text" class="textbox" value=""
			name="votem" id="votem" style="width: 220px; height: 22px;" /> <a
			href="javascript:onclick=manager_search()" class="easyui-linkbutton"
			iconCls="icon-search" id="soui">搜索</a>
	</div>

	<hr />
	<div style="padding-left: 20px;">
		<strong>客户信息列表</strong>&nbsp;&nbsp; <a
			href="javascript:onclick=reload()" id="rebutton"
			class="easyui-linkbutton" iconCls="icon-reload">刷新</a>&nbsp; <a
			href="javascript:onclick=lookUp('../order/orderMember','查看信息','reload')" class="easyui-linkbutton"
			iconCls="icon-search" id="soui">查看</a> &nbsp;<a
			href="javascript:onclick=place()" class="easyui-linkbutton"
			iconCls="icon-cart-put" id="soui">下单</a>
	</div>

	<table id="orderOf">

	</table>

	<script type="text/javascript" src="../js/orderOf.js"></script>
</body>
</html>