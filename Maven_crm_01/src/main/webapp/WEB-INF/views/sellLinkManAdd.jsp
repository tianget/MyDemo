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
    
    <form:form id="sellLxrForm"  action="javascript:void(0)"  commandName="linkMan"  method="post">
       <table id="sellTable">
             <tr>
                  <td colspan="2"><h2>填写联系人信息</h2></td>
                  <td><form:hidden id="linkManId"  path="id" /></td>
             </tr>
             <tr>
                  <td>联系人姓名：<form:input  path="name" class="easyui-validatebox"  data-options="required:true"  /></td>
                  <td>生日：<form:input  path="birthday" class="easyui-datebox"  data-options="required:true,editable:false"   /></td>
             </tr>
              <tr>
                  <td>性别：<input type="radio" name="sex" value="男" checked="true"  />男<input type="radio" name="sex" value="女"   />女</td>
                  <td>手机：<form:input  path="phone" class="easyui-validatebox"  data-options="required:true"  /></td>
             </tr>
              <tr>
                  <td>办公电话：<form:input  path="workPhone" class="easyui-validatebox"  data-options="required:true"  /></td>
                  <td>电子邮箱：<form:input  path="email" class="easyui-validatebox"  data-options="required:true"  /></td>
             </tr>
             <tr>
                  <td>联系地址：</td>
                  <td><form:textarea id="address" path="address" class="easyui-validatebox" data-options="required:true" /></td>
             </tr>
             <tr>
                  <td>备注信息：</td>
                  <td><form:textarea id="remark" path="remark" class="easyui-validatebox" data-options="required:true" /></td>
             </tr>
             <tr>
                  <td></td>
                  <td><input  type="image" onclick="return1LinkMan()"  src="../easyui/themes/icons/arrow-left.png"   />&nbsp;&nbsp;&nbsp;&nbsp;<input type="image" onclick="addPostLinkMan()" src="../easyui/themes/icons/button-white-check.png"   /></td>
             </tr>
       </table>
     </form:form>
     <link rel="stylesheet" type="text/css" href="../css/sellPlan.css" />
</body>
</html>