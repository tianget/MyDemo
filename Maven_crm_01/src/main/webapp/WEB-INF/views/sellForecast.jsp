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
       <table id="sellForecastTb">
          
       </table>
 <div id="sellForecastCrud">
    
     <a href="javascript:onclick=forecast()" class="easyui-linkbutton" data-options="iconCls:'icon-search',text:'预测',plain:true"></a>&nbsp;&nbsp;
     <a href="javascript:onclick=queryForecast()" class="easyui-linkbutton" data-options="iconCls:'icon-search',text:'查看',plain:true"></a>&nbsp;&nbsp;
     
	<!-- <span style="float:right"> 月份&nbsp;:&nbsp;<input id="forecastLikeQuery" class="easyui-textbox"  type="text"  />
	 
	<a href="javascript:onclick=likeQueryForecast()" class="easyui-linkbutton"  data-options="iconCls:'icon-search',text:'搜索'"></a>
	</span> -->
	
</div>

   <div id="forecastDd"  class="easyui-dialog" title="指定预测类型:" style="width:200px;height:100px;"   
        data-options="iconCls:'icon-save',resizable:true,modal:true,closed:true">   
               <div>
                  <div>
	                     <c:if test="${sessionScope.staff.rid==4}">
	                         <input type="radio" name="typeId" checked="true" value="0"/>整体预测
	                       </c:if>
	                      <input type="radio" name="typeId"  value="1" />部门预测
	                      <c:if test="${sessionScope.staff.rid==3}">
	                         <input type="radio" name="typeId"  value="2" />个人预测
	                      </c:if>
	                        <input style="margin-left: 70px;margin-top: 20px;" type="button" onclick="redio()" value="确定" />
                  </div>
                 </div>
   </div>  

       
   <script type="text/javascript" src="../js/sellForecast.js"></script>    
</body>
</html>