<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>销售设计明细查询</title>
 
</head>
<body>
    <div id="sellPlanQuery" style="width:500px;
	height:450px;
	margin: 0 auto;
	margin-top: 80px;
	padding-top:10px;
	background-color: #ccccff;">
	      <h2 align="center">销售设计查看</h2>
	      <table  style="margin-left: 150px;line-height: 40px;">
             <tr>
                  <td>计划人姓名：</td>
                  <td ><strong>${requestScope.sellPlan.planName}</strong></td>
             </tr>
             <tr>
                  <td>计划编码：</td>
                  <td><strong>${requestScope.sellPlan.coding}</strong></td>
             </tr>
              <tr>
                  <td>计划月份：</td>
                  <td><strong>${requestScope.sellPlan.planMonth}</strong></td>
             </tr>
             <tr>
                  <td>状态：</td>
                  <td><strong>${requestScope.sellPlan.state}</strong></td>
             </tr>
              <tr>
                  <td>计划内容：</td>
                  <td><strong>${requestScope.sellPlan.planContent}</strong></td>
             </tr>
             <tr>
                  <td>计划销售额：</td>
                  <td><strong>${requestScope.sellPlan.planSaleroom}</strong></td>
             </tr>
             <tr>
                  <td>
                  <a  href="javascript:onclick=return1Plan()" class="easyui-linkbutton" data-options="iconCls:'icon-undo'">返回</a>  
                  </td>
                  
                  <c:if test="${sessionScope.staff.role.rid!=2 && sessionScope.staff.sid!=requestScope.sellPlan.planManId}">
                  <c:if test="${requestScope.sellPlan.state!='已通过'}"> 
                   <td>
                    <a  href="javascript:onclick=examinePlan(${requestScope.sellPlan.planId})" class="easyui-linkbutton" data-options="iconCls:'icon-ok'">审批</a>  
                  </td>
                  
                     <td>
	                   &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a  href="javascript:onclick=playReturn(${requestScope.sellPlan.planId})" class="easyui-linkbutton" data-options="iconCls:'icon-page-white-go'">打回</a>  
	                  </td>
                  </c:if>
                  
                  </c:if>
                  
                  
             </tr>
       </table>
       
    </div>
</body>
</html>