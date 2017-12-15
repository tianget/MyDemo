<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>订单查询</title>
</head>
<body>
	<div style="padding-left: 20px; padding-top: 15px">订单管理>>订单查询</div>
	
	<div id="div_toolOne"
		style="padding-left: 100px; padding-top: 15px; text-align: left;">
		<div>所在区域：${asd}</div>		
		<div>${wen}</div>
		<p></p>
		关键字： <input type="text" class="textbox" name="votems" id="votems"
			style="width: 220px; height: 22px;" /> <a
			href="javascript:onclick=manager_searcht()" class="easyui-linkbutton"
			iconCls="icon-search" id="soui">搜索</a>&nbsp;&nbsp; 时间：<input
			id="begin" type="text" class="easyui-datebox"> &nbsp;&nbsp;
		状态：<select id="zhuangtai_id" class="easyui-combobox" name="zhuangtai"
			style="width: 80px;">
			<option value="">不限</option>
			<option value="1">等待付款</option>
			<option value="2">等待自提</option>
			<option value="3">等待收货</option>
			<option value="4">已完成</option>
			<option value="5">已取消</option>
		</select>
		
	</div>

	<hr />
	<div style="padding-left: 20px;">
		<strong>订单信息列表</strong>&nbsp;&nbsp; <a
			href="javascript:onclick=refresh()" class="easyui-linkbutton"
			data-options="iconCls:'icon-reload',text:'刷新',plain:true"></a>&nbsp;&nbsp;
		<a
			href="javascript:onclick=places('../order/orderSelect','订单详情','refresh')"
			class="easyui-linkbutton"
			data-options="iconCls:'icon-search',text:'查看',plain:true"></a>
		&nbsp;&nbsp; <a href="javascript:onclick=plaSta()"
			class="easyui-linkbutton"
			data-options="iconCls:'icon-search',text:'付款',plain:true"></a>
		&nbsp;&nbsp;

		<!-- <a
			href="javascript:onclick=plaSta()"
			class="easyui-linkbutton"
			data-options="iconCls:'icon-search',text:'收货',plain:true"></a>
			
		&nbsp;&nbsp;
		<a
			href="javascript:onclick=plaSta()"
			class="easyui-linkbutton"
			data-options="iconCls:'icon-search',text:'自提',plain:true"></a>
		&nbsp;&nbsp;
		<a
			href="javascript:onclick=plaSta()"
			class="easyui-linkbutton"
			data-options="iconCls:'icon-search',text:'取消',plain:true"></a> -->
	</div>

	<table id="orderInquiry">

	</table>

</body>
</html>