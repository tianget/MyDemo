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
       <table id="sellAnalysisTb">
          
       </table>
 <div id="sellAnalysisCrud">
    
     <a href="javascript:onclick=queryAnalysis()" class="easyui-linkbutton" data-options="iconCls:'icon-search',text:'查看',plain:true"></a>&nbsp;&nbsp;
     
	<span style="float:right"> 月份&nbsp;:&nbsp;<input id="analysisLikeQuery" class="easyui-textbox"  type="text"  />
	 
	<a href="javascript:onclick=likeQueryAnalysis()" class="easyui-linkbutton"  data-options="iconCls:'icon-search',text:'搜索'"></a>
	</span>
	
</div>
       
   <script type="text/javascript" src="../js/sellAnalysis.js"></script>    
</body>
</html>