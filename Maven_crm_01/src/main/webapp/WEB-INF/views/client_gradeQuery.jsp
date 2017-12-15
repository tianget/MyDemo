<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="scripts/jquery.min.js"></script>
<title>Insert title here</title>

</head>
<body>
	<div style="position: absolute;left:22px;">
	    	 <p>客户管理>> 客户资源管理>>增加客户资源</p>
	    </div>
		<div style="position: absolute;left:170px;top:80px">
			<!-- <form action="../clientAllot/setMember" method="post"> -->
			<table style="width:600px;height: 280px">
				<tr>
					<td>客户姓名：</td>
					<td>${cost.name}</td>
					<td>性别：</td>
					<td>${cost.sex}</td>
				</tr>
				<tr>
					<td>客户类型：</td>
					<td>
						${cost.type}
					</td>
					<td>负责人：</td>
					<td>${cost.sid}</td>
				</tr>
				<tr>
					<td>消费次数：</td>
					<td>
			            ${cost.number}
					</td>
					<td>消费总额：</td>
					<td>
			           ${cost.sum}
			        </td>
				</tr>
				<tr>
					<td colspan="4"><div style="width:630px;border:1px solid black;"></div></td>
				</tr>
			</table>
	</div>
	<div style="position: absolute;left:80px;top:340px">
	  <table style="width:800px;height: 280px">
		<tr>
		  <td align="center">订单id</td>
		  <td align="center">订单号</td>
		  <td align="center">订单类型</td>
		  <td align="center">支付方式</td>
		  <td align="center">金额</td>
		  <td align="center">下单时间</td>
		  <td align="center">发票信息</td>
		  <td align="center">订单状态</td>
		  <td align="center">收货人</td>
		</tr>
		<c:forEach  items="${orders }" var="o">
			<tr>
			  <td align="center">${o.oid }</td>
			  <td align="center">${o.onum }</td>
			  <td align="center">${o.otype }</td>
			  <td align="center">${o.opayment }</td>
			  <td align="center">${o.oprice }</td>
			  <td align="center">${o.otime }</td>
			  <td align="center">${o.oinvoice }</td>
			  <td align="center">${o.ostatus }</td>
			  <td align="center">${o.mname }</td>
			</tr>
	    </c:forEach>
	  </table>
	</div>
	<div style="position: absolute;left:1000px;top:40px">
					<input type="button" value="返回" onclick="fanhui()">
				</div>
	
	<script type="text/javascript">
		function fanhui(){
	    	var tab = $('#tabs').tabs('getSelected');  // 获取选择的面板
	    	tab.panel('refresh', '../client/client_grade');
	    }
	</script>	
</body>
</html>