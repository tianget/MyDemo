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
    
    <form:form   action="javascript:void(0)"   commandName="competeManager"  method="post">
       <table id="sellTable">
             <tr>
                  <td></td>
                  <td><h2>查看竞争</h2></td>
             </tr>
             <tr>
                  <td>分析结果标题：</td>
                  <td><form:input  path="subject" class="easyui-validatebox"  data-options="editable:false"  /></td>
             </tr>
              <tr>
                  <td>目标预测时间:</td>
                  <td><form:input  path="analysisDate" class="easyui-validatebox" data-options="editable:false"  /></td>
             </tr>
             <tr>
                  <td>类型：</td>
                  <td><form:input path="type"   class="easyui-validatebox"  data-options="editable:false" /></td>
             </tr> 
              <tr>
                  <td>状态：</td>
                  <td><form:input path="state"   class="easyui-validatebox"  data-options="editable:false" /></td>
             </tr>   
              <tr>
                  <td>分析结果:</td>
                  <td><form:textarea rows="5"  path="analysisResult"  style="width:250px;height:80px:" class="easyui-validatebox" data-options="editable:false"  /></td>
             </tr>
             <tr>
                  <td></td>
                  <td><input  type="image" onclick="return1Compete()"  src="../easyui/themes/icons/arrow-left.png"   /></td>
             </tr>
       </table>
     </form:form>
     <link rel="stylesheet" type="text/css" href="../css/sellPlan.css" />
        
</body>
</html>