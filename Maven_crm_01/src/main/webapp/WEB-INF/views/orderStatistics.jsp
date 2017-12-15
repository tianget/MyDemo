<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>订单统计</title>
</head>
<body>
	<div style="padding-left: 20px; padding-top: 15px">订单管理>>统计订单</div>
	<div id="div_toolOne"
		style="padding-left: 100px; padding-top: 15px; text-align: left;">

		输入查询时间：<input id="begin_r" name="begin_r" type="text" class="easyui-datebox" /> <a
			href="javascript:onclick=manager_begin()" class="easyui-linkbutton" iconCls="icon-search" id="soui">查询</a>
	</div>

	<hr />
	<div style="padding-left: 20px;">
		<strong>订单信息列表</strong>&nbsp;&nbsp; <a id="rebutton"
			class="easyui-linkbutton" iconCls="icon-reload"
			href="javascript:onclick=reload()">刷新</a>&nbsp; <!-- <a href="#"
			class="easyui-linkbutton" iconCls="icon-search" id="soui">查看</a> -->
		&nbsp;
	</div>

	<table id="orderStatistics">

	</table>
	<script type="text/javascript" src="../js/orderStatistics.js"></script>
</body>
</html>