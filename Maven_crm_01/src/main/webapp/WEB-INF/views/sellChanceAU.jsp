<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>录入机会</title>
</head>
<body>
    
    <form:form id="sellChanceForm"  action="javascript:void(0)"  commandName="sellChance"  method="post">
       <table id="sellTable">
             <tr>
                  <td><form:hidden  path="id"   /></td>
                  <td><h2>录入机会</h2></td>
             </tr>
             <tr>
                  <td>机会名称：</td>
                  <td><form:input  path="chanceName" class="easyui-validatebox"  data-options="required:true"  /></td>
             </tr>          
              <tr>
                  <td>机会类型：</td>
                  <td>
	                  <form:select path="chanceType"   >
	                     <form:option value="官方流量">官方流量</form:option>
	                     <form:option value="转介绍">转介绍</form:option>
	                     <form:option value="客户来访">客户来访</form:option>
	                     <form:option value="电话询问">电话询问</form:option>
	                     <form:option value="媒体进线">媒体进线</form:option>
	                  </form:select>
                  </td>
             </tr>
             <tr>
                  <td>机会来源：</td>
                  <td><form:input  path="chanceOrigin" class="easyui-validatebox"  data-options="required:true"  /></td>
             </tr>
              <tr>
                  <td>机会内容：</td>
                  <td><form:textarea path="chanceContent" class="easyui-validatebox" data-options="required:true" style="height:80px;width:270px" /></td>
             </tr>
             <tr>
                  <td>备注信息：</td>
                  <td><form:textarea path="remark" class="easyui-validatebox"  style="height:80px;width:270px" /></td>
             </tr>
             <tr>
                  <td></td>
                  <td><input  type="image" onclick="return1Chance()"  src="../easyui/themes/icons/arrow-left.png"   />&nbsp;&nbsp;&nbsp;&nbsp;<input type="image" onclick="subChance()" src="../easyui/themes/icons/button-white-check.png"   /></td>
             </tr>
       </table>
     </form:form>
     <link rel="stylesheet" type="text/css" href="../css/sellPlan.css" />
</body>
</html>