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
       <table id="sellCompeteTb">
          
       </table>
 <div id="sellCompeteCrud">
    
      <a href="javascript:onclick=addCompete()" class="easyui-linkbutton" data-options="iconCls:'icon-add',text:'添加',plain:true"></a>&nbsp;&nbsp;
     <a href="javascript:onclick=fileCompete()" class="easyui-linkbutton" data-options="iconCls:'icon-ok',text:'归档',plain:true"></a>&nbsp;&nbsp;
     <a href="javascript:onclick=updateCompete()" class="easyui-linkbutton" data-options="iconCls:'icon-edit',text:'修改',plain:true"></a>&nbsp;&nbsp;
     <a href="javascript:onclick=queryCompete()" class="easyui-linkbutton" data-options="iconCls:'icon-search',text:'查看',plain:true"></a>&nbsp;&nbsp;
     
	<span style="float:right"> 月份&nbsp;:&nbsp;<input id="competeLikeQuery" class="easyui-textbox"  type="text"  />
	 
	<a href="javascript:onclick=likeQueryCompete()" class="easyui-linkbutton"  data-options="iconCls:'icon-search',text:'搜索'"></a>
	</span>
	
</div>

 

       
   <script type="text/javascript" src="../js/sellCompete.js"></script>    
</body>
</html>