<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>创建计划</title>
</head>
<body>
    
    <form:form id="sellForecast"  action="javascript:void(0)"  commandName="sellForecast"  method="post">
       <table id="sellTable">
             <tr>
                  <td></td>
                  <td><h2>查看预测</h2></td>
             </tr>
             <tr>
                  <td>预测结果标题：</td>
                  <td><form:input  path="subject" class="easyui-validatebox"  data-options="editable:false"  /></td>
             </tr>
              <tr>
                  <td>目标预测时间:</td>
                  <td><form:input  path="month" class="easyui-datebox" data-options="editable:false"  /></td>
             </tr>
             <c:if test="${!empty field}">
	              <tr>
	                  <td>预测的${field}：</td>
	                  <td>
	                  <c:if test="${field=='部门'}">
	                     <form:input  path="deptName" class="easyui-validatebox" data-options="editable:false"  />
	                  </c:if>
	                  <c:if test="${field=='员工'}">
	                     <form:input  path="empName" class="easyui-validatebox" data-options="editable:false"  />
	                  </c:if>
	                  </td>
	              </tr> 
              </c:if>         
              <tr>
                  <td>预测结果:</td>
                  <td><form:textarea rows="5"  path="forecastResult"  style="width:250px;height:80px:" class="easyui-validatebox" data-options="editable:false"  /></td>
             </tr>
             <tr>
                  <td></td>
                  <td><input  type="image" onclick="return1Forecast()"  src="../easyui/themes/icons/arrow-left.png"   /></td>
             </tr>
       </table>
     </form:form>
     <link rel="stylesheet" type="text/css" href="../css/sellPlan.css" />
        
</body>
</html>