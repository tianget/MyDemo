<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查看销售机会</title>
</head>
<body>
    
  <div id="sellAnalysisDeptCrud">
     <a href="javascript:onclick=return1Chance()" class="easyui-linkbutton" data-options="iconCls:'icon-undo',text:'返回',plain:true"></a>&nbsp;&nbsp;
	
</div>
      <div>
        <table id="sellAnalysisDeptTb">
             
       </table>
      </div>
      
       
       
     
     <link rel="stylesheet" type="text/css" href="../css/sellPlan.css" />
     <script type="text/javascript">
           $(function(){
        	   
        	   
        	   $('#sellAnalysisDeptTb').datagrid({    
       		    url:'../sellAnalysis/getDeptData?month=${month}',    
       		    columns:[[ 
       	            {field:'id',checkbox:true},
       	            {field:'${field}',title:'${cfield}',width:150},
       		        {field:'sumMoney',title:'销售金额(单位：万元)',width:150}, 	           
       		        {field:'thisMonth',title:'月份',width:150},
       		        {field:'withThan',title:'同比',width:150},  
       		        {field:'loopThan',title:'环比',width:150},	           
       		    ]],
       		    rownumbers:true,
       		    fitColumns:true,
       		    toolbar:'#sellAnalysisDeptCrud',
       		    singleSelect:true,
       		});
           })
     </script>
</body>
</html>