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
       <table id="sellPerTb">
          
       </table>
 <div id="sellPerCrud">
     <!-- <a href="javascript:onclick=addPer()" class="easyui-linkbutton" data-options="iconCls:'icon-add',text:'添加',plain:true"></a>&nbsp;&nbsp;
     <a href="javascript:onclick=delPer()" class="easyui-linkbutton" data-options="iconCls:'icon-remove',text:'删除',plain:true"></a>&nbsp;&nbsp;
     <a href="javascript:onclick=updatePer()" class="easyui-linkbutton" data-options="iconCls:'icon-edit',text:'修改',plain:true"></a>&nbsp;&nbsp;
     <a href="javascript:onclick=queryPer()" class="easyui-linkbutton" data-options="iconCls:'icon-search',text:'查看',plain:true"></a>&nbsp;&nbsp; -->
	<span> 月份&nbsp;:&nbsp;<input id="perLikeQuery" class="easyui-textbox"  type="text"  />
	<a href="javascript:onclick=likeQueryPer()" class="easyui-linkbutton"  data-options="iconCls:'icon-search',text:'搜索'"></a>
	</span>
	
</div>
       
   <script type="text/javascript" src="../js/sellPer.js"></script>    
</body>
</html>