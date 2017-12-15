<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>销售计划</title>

</head>
<body>
       <table id="dg">
          
       </table>
 <div id="planCrud">
     <a href="javascript:onclick=refreshPlan()" class="easyui-linkbutton" data-options="iconCls:'icon-reload',text:'刷新',plain:true"></a>&nbsp;&nbsp;
     <a href="javascript:onclick=addPlan()" class="easyui-linkbutton" data-options="iconCls:'icon-add',text:'添加',plain:true"></a>&nbsp;&nbsp;
     <a href="javascript:onclick=delPlan()" class="easyui-linkbutton" data-options="iconCls:'icon-remove',text:'删除',plain:true"></a>&nbsp;&nbsp;
     <a href="javascript:onclick=updatePlan()" class="easyui-linkbutton" data-options="iconCls:'icon-edit',text:'修改',plain:true"></a>&nbsp;&nbsp;
     <a href="javascript:onclick=queryPlan()" class="easyui-linkbutton" data-options="iconCls:'icon-search',text:'查看',plain:true"></a>&nbsp;&nbsp;
     <a href="javascript:onclick=submitPlan()" class="easyui-linkbutton" data-options="iconCls:'icon-ok',text:'提交',plain:true"></a>&nbsp;&nbsp;
	<c:if test="${sessionScope.staff.role.rid==3}">
	   <a href="javascript:onclick=myPlan()" id="myPlan" name="myPlan" class="easyui-linkbutton" ></a>&nbsp;&nbsp;
	 </c:if>
	<span style="float:right"> 联系人&nbsp;:&nbsp;<input id="likeQuery" class="easyui-textbox"  type="text"  />
	 
	<a href="javascript:onclick=likeQueryPlan()" class="easyui-linkbutton"  data-options="iconCls:'icon-search',text:'搜索'"></a>
	</span>
	
</div>
       
   <script type="text/javascript" src="../js/sellPlan.js"></script>    
</body>
</html>