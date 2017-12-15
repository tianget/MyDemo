<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查看销售机会</title>
</head>
<body>
    
    <form:form   action="javascript:void(0)"  commandName="sellChance"  method="post">
       <table id="sellTable">
             <tr>
                  <td colspan="2"><h2>查看销售机会</h2></td>
                  <td></td>
             </tr>
             <tr>
                  <td>机会名称：<form:input  path="chanceName" class="easyui-validatebox"  data-options="editable:false"  /></td>
                  <td>机会类型：<form:input  path="chanceType" class="easyui-validatebox"  data-options="editable:false"   /></td>
             </tr>
              <tr>
                  <td>机会来源 ：<form:input  path="chanceOrigin" class="easyui-validatebox"  data-options="editable:false"  /></td>
                  <td>录入人：<form:input  path="enteringManName" class="easyui-validatebox"  data-options="editable:false"  /></td>
             </tr>
              <tr>
                  <td>录入时间：<form:input  path="enteringDate" class="easyui-validatebox"  data-options="editable:false"  /></td>
                  <td>最后操作人：<form:input  path="lastUpdateManName" class="easyui-validatebox"  data-options="editable:false"  /></td>
             </tr>
             <tr>
                  <td>最后修改时间：</td>
                  <td><form:input id="lastUpdateDate" path="lastUpdateDate" class="easyui-validatebox" data-options="editable:false" /></td>
             </tr>
             <tr>
                  <td>机会内容：</td>
                  <td><form:textarea id="chanceContent" path="chanceContent" class="easyui-validatebox" data-options="editable:false" /></td>
             </tr>
             <tr>
                  <td>备注信息：</td>
                  <td><form:textarea id="remark" path="remark" class="easyui-validatebox" data-options="editable:false" /></td>
             </tr>
             <c:if test="${! empty requestScope.staffs}">
             <tr>
                  <td><hr></td>
                  <td><hr></td>
             </tr>
	              <tr>
	                  <td>
	                      <strong>分配给：</strong>
	                  </td>
	                  <td>
	                    <select id="staffName">
		                      <c:forEach items="${staffs}" var="s">
		                      
	                               <option value="${s.sid}">${s.name}</option>
	                          </c:forEach>
		                  </select>
	                  </td>
	             </tr>
             </c:if>
             <tr>
                  <td><a  href="javascript:onclick=return1Chance()" class="easyui-linkbutton" data-options="iconCls:'icon-undo'">返回</a></td>
                  <td>
                   <c:if test="${! empty requestScope.staffs}">
                  <a  href="javascript:onclick=allotPostChance(${requestScope.sellChance.id})" class="easyui-linkbutton" data-options="iconCls:'icon-ok'">分配</a> 
                  </c:if>
                  </td>
             </tr>
       </table>
       
     </form:form>
     <link rel="stylesheet" type="text/css" href="../css/sellPlan.css" />
</body>
</html>