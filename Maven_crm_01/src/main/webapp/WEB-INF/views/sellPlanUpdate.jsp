<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>创建计划</title>
</head>
<body>
    
    <form:form id="sellForm"  action="javascript:void(0)"  commandName="sellPlan"  method="post">
       <table id="sellTable">
             <tr>
                  <td></td>
                  <td><h2>修改销售计划</h2><form:hidden  path="planId"  /></td>
             </tr>
             <tr>
                  <td>计划编码：</td>
                  <td><form:input  path="coding" class="easyui-textbox" data-options="required:true,editable:false" /></td>
             </tr>
              <tr>
                  <td>计划月份：</td>
                  <td><form:input path="planMonth" class="easyui-datebox" data-options="required:true,editable:false"  /></td>
             </tr>
             <tr>
                  <td>状态：</td>
                  <td><form:input path="state" class="easyui-textbox" data-options="required:true,editable:false"  /></td>
             </tr>
              <tr>
                  <td>计划内容：</td>
                  <td><form:textarea path="planContent" class="easyui-validatebox" data-options="required:true" style="height:80px;width:270px" /></td>
             </tr>
             <tr>
                  <td>计划销售额：</td>
                  <td><form:input id="planSaleroom" path="planSaleroom" class="easyui-validatebox" data-options="required:true" /><strong>(万元)</strong><span id="sellMoney"></span></td>
             </tr>
             <tr>
                  <td></td>
                  <td><input  type="image" onclick="return1Plan()"  src="../easyui/themes/icons/arrow-left.png"   />&nbsp;&nbsp;&nbsp;&nbsp;<input type="image" onclick="updatePostPlan()" src="../easyui/themes/icons/button-white-check.png"   /></td>
             </tr>
       </table>
     </form:form>
     <link rel="stylesheet" type="text/css" href="../css/sellPlan.css" />
</body>
</html>