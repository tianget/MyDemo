<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>录入竞争</title>
</head>
<body>
    
    <form:form id="sellCompeteForm"  action="javascript:void(0)"  commandName="competeManager"  method="post">
       <table id="sellTable">
             <tr>
                  <td><form:hidden  path="id"   /></td>
                  <td><h2>录入竞争</h2></td>
             </tr>
             <tr>
                  <td>标题：</td>
                  <td><form:input  path="subject" class="easyui-validatebox"  data-options="required:true"  /></td>
             </tr>          
              <tr>
                  <td>类型：</td>
                  <td>
	                  <form:select path="type"   >
	                     <form:option value="0">行业竞争</form:option>
	                     <form:option value="1">公司竞争</form:option>
	                  </form:select>
                  </td>
             </tr>
             <tr>
                  <td>分析时间：</td>
                  <td><form:input  path="analysisDate" class="easyui-datebox"  data-options="required:true,editable:false"  /></td>
             </tr>            
             <tr>
                  <td>状态：</td>
                  <td><form:input path="state"  value="未归档" class="easyui-validatebox"  data-options="editable:false" /></td>
             </tr>
             <tr>
                  <td></td>
                  <td><input  type="image" onclick="return1Compete()"  src="../easyui/themes/icons/arrow-left.png"   />&nbsp;&nbsp;&nbsp;&nbsp;<input type="image" onclick="subCompete()" src="../easyui/themes/icons/button-white-check.png"   /></td>
             </tr>
       </table>
     </form:form>
     <link rel="stylesheet" type="text/css" href="../css/sellPlan.css" />
</body>
</html>