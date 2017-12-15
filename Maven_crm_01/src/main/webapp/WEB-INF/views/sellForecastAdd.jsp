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
                  <td><h2>新建预测</h2></td>
             </tr>
             <tr>
                  <td>预测结果标题：</td>
                  <td><form:input  path="subject" class="easyui-validatebox"  data-options="required:true"  /></td>
             </tr>
              <tr>
                  <td>目标预测时间:</td>
                  <td><form:input id="forecastMonth" path="month" class="easyui-datebox" data-options="required:true,editable:false"  /></td>
             </tr>
             
             <c:if test="${!empty field}">
            <tr>
                  <td>指定${field}：</td>
                  <td>
                   <c:if test="${!empty staffs}">
	                     <select id="staffId"> 
	                   <c:forEach items="${staffs}" var="obj">		                     
		                        <option value="${obj.sid}">${obj.name}</option>		            
		                 </c:forEach>
		                 </select>
                   </c:if>
                     <c:if test="${!empty depts}">
                     <select id="deptId">   
                      <c:forEach items="${depts}" var="obj">		                   
		                        <option value="${obj.did}">${obj.dshortname}</option>		                  
		                </c:forEach>
		             </select>
                     </c:if>
                  </td>
             </tr>
              </c:if>
               <tr>
               <c:if test="${field!='员工'}">
                  <td>员工人数:</td>
                  <td><input  name="empCount" class="easyui-textbox" data-options="required:true"  /></td>
              </c:if>
              
             </tr>
              <tr>
                  <td>客户人数:</td>
                  <td>
                  <c:if test="${field=='员工'}">
              <input type="hidden"  name="empCount" value="0" class="easyui-textbox" data-options="required:true"  />
              </c:if>
                  <input  name="clientCount" class="easyui-textbox" data-options="required:true"  />
                  </td>
             </tr>
             <tr>
                  <td></td>
                  <td><input  type="image" onclick="return1Forecast()"  src="../easyui/themes/icons/arrow-left.png"   />&nbsp;&nbsp;&nbsp;&nbsp;<input type="image" onclick="subForecast()" src="../easyui/themes/icons/button-white-check.png"   /></td>
             </tr>
       </table>
     </form:form>
     <link rel="stylesheet" type="text/css" href="../css/sellPlan.css" />
        
</body>
</html>