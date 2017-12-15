<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>客户信息</title>
</head>
<body>
       
       <table id="sellTable">
             <tr id="tt">
                  <td colspan="2">客户管理>> 客户价值管理>> 查看</td>
                 
             </tr>
             <tr>
                  <td>客户编码：${members.encode }</td>
                  <td>客户类型：${members.type }</td>
             </tr>
             <tr>
                  <td>客户姓名：${members.name }</td>
                  <td>生日：${members.birth }</td>
             </tr>
              <tr>
                  <td>性别：${members.sex }</td>
                  <td>手机：${members.phone }</td>
             </tr>
              <tr>
                  <td>办公电话：${members.workPhone }</td>
                  <td>电子邮箱：${members.email }</td>
             </tr>
             <tr>
                  <td>联系地址：${members.address }</td>
                  <td></td>
             </tr>
             <tr>
                  <td colspan="2">备注信息：${members.remarks }</td>
             </tr>
             	
             <tr>
                  <td stype='width:80px'></td>
                  <td><input  type="image" onclick="return1()"  src="../easyui/themes/icons/arrow-left.png"   /></td>
             </tr>
       </table>
       <div style="position: absolute;left:200px;top:400px">
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

     <link rel="stylesheet" type="text/css" href="../css/client_costInformation.css" />
	 <script type="text/javascript" src="../js/client_costInformation.js"></script>
</body>
</html>
