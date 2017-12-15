<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>统计</title>

</head>
<body>
       <table id="${operation}">
          
       </table>
 <div id="statisticsQuery">
<%--  <a href="../statistics/clienteleFormation?operation=${operation}" class="easyui-linkbutton" data-options="iconCls:'icon-search',text:'查看',plain:true"></a> --%>
   <!-- <a href="javascript:onclick=addPer()" class="easyui-linkbutton" data-options="iconCls:'icon-add',text:'添加',plain:true"></a>&nbsp;&nbsp;
     <a href="javascript:onclick=delPer()" class="easyui-linkbutton" data-options="iconCls:'icon-remove',text:'删除',plain:true"></a>&nbsp;&nbsp;
     <a href="javascript:onclick=updatePer()" class="easyui-linkbutton" data-options="iconCls:'icon-edit',text:'修改',plain:true"></a>&nbsp;&nbsp; -->
       <!-- <a href="javascript:onclick=queryPer()" class="easyui-linkbutton" data-options="iconCls:'icon-search',text:'查看',plain:true"></a>&nbsp;&nbsp; -->
	<!-- <span> 月份&nbsp;:&nbsp;<input id="perLikeQuery" class="easyui-textbox"  type="text"  />
	<a href="javascript:onclick=likeQueryPer()" class="easyui-linkbutton"  data-options="iconCls:'icon-search',text:'搜索'"></a>
	</span> -->
	
</div>

     <script type="text/javascript">
     $(function(){
    		$('#${operation}').datagrid({    
    		    url:'../statistics/statisticsQuery?operation=${operation}',    
    		    columns:[[ 
    	            /*{field:'id',checkbox:true}, */
    		        {field:'${operation}',title:'${field}',width:150}, 
    		        {field:'month',title:'月份',width:150},    
    		        {field:'withThan',title:'同比',width:150},  
    		        {field:'loopThan',title:'环比',width:150}
    		    ]],
    		    rownumbers:true,
    		    fitColumns:true,
    		    toolbar:'#statisticsQuery',	  
    		    singleSelect:true,
    		});
    		
    	});
     /*  function redirect($title,$url){
    		
    		var tab = $('#tabs').tabs('getSelected');  // 获取选择的面板
    		console.log(tab)
    		$('#tabs').tabs('update', {
    			tab: tab,
    			options: {
    				title: $title,
    				href: $url  // 新内容的URL
    			}
    		});
    		var tab = $('#tabs').tabs('getSelected');  // 获取选择的面板
    		
    		tab.panel('refresh',$url);
    		
    	}
     function querySta(){
    		
 		redirect('统计图','../statistics/clienteleFormation?operation=${operation}');
 	}  */
     </script>  
</body>
</html>