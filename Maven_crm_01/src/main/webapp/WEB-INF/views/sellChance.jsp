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
       <table id="sellChanceTb">
          
       </table>
 <div id="sellChanceCrud">
     <a href="javascript:onclick=addChance()" class="easyui-linkbutton" data-options="iconCls:'icon-add',text:'添加',plain:true"></a>&nbsp;&nbsp;
     <a href="javascript:onclick=updateChance()" class="easyui-linkbutton" data-options="iconCls:'icon-edit',text:'修改',plain:true"></a>&nbsp;&nbsp;
     <a href="javascript:onclick=queryChance()" class="easyui-linkbutton" data-options="iconCls:'icon-search',text:'查看',plain:true"></a>&nbsp;&nbsp;
     
	<c:if test="${sessionScope.staff.role.rid==3}">
	   <a href="javascript:onclick=allotChance()" class="easyui-linkbutton" data-options="iconCls:'icon-ok',text:'分配',plain:true"></a>&nbsp;&nbsp;
	 </c:if>
	<span style="float:right"> 机会名称&nbsp;:&nbsp;<input id="chanceLikeQuery" class="easyui-textbox"  type="text"  />
	 
	<a href="javascript:onclick=likeQueryChance()" class="easyui-linkbutton"  data-options="iconCls:'icon-search',text:'搜索'"></a>
	</span>
	
</div>
       
   <script type="text/javascript" src="../js/sellChance.js"></script>    
</body>
</html>