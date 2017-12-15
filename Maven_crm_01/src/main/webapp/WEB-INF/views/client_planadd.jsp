<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>创建计划</title>
</head>
<body>
       <table id="sellTable">
             <tr>
                  <td></td>
                  <td><h2>添加计划计划</h2></td>
             </tr>
             <tr>
                  <td>计划编码：</td>
                  <td><input type="text" id="encode"  value="${plan.name }" class="easyui-validatebox"  data-options="required:true"></td>
             </tr>
              <tr>
                  <td>计划人姓名：</td>
                  <td><input type="text" id="name"  value="${plan.name }"></td>
             </tr>
             <tr>
                  <td>计划月份：</td>
                  <td><input type="text" id="initDate" class="easyui-datebox"  value="${plan.name }"></input> </td>
             </tr>
              <%-- <tr>
                  <td>计划状态：</td>
                  <td><input type="text" id="birth"  value="${member.name }"></td>
             </tr> --%>
             <tr>
                  <td>计划内容：</td>
                  <td><input type="text" id="details"  value="${plan.name }" class="easyui-validatebox" data-options="required:true" style="height:80px;width:270px" ></td>
             </tr>
             <tr>
                  <td></td>
                  <td><input  type="image"  src="../easyui/themes/icons/arrow-left.png"  onclick="fanhui()"  />&nbsp;&nbsp;&nbsp;&nbsp;<input type="image" onclick="add()" src="../easyui/themes/icons/button-white-check.png"   /></td>
             </tr>
       </table>
       <div id="session" style="display: none;">${ plan}</div>
       <link rel="stylesheet" type="text/css" href="../css/client_planadd.css" />
       <script type="text/javascript">
       
	$(function(){
		/* //月份
		$('#initDate').datebox({    
	        required:true,
	    }); 
	    $.fn.datebox.defaults.formatter = function(date){
	    	var y = date.getFullYear();
	    	var m = date.getMonth()+1;
	    	var d = date.getDate();
	    	return m+'-'+d+'-'+y;
	    } */
	})
    function fanhui(){
    	var tab = $('#tabs').tabs('getSelected');  // 获取选择的面板
    	tab.panel('refresh', '../client/client_plan');
    }
	
	function add(){
		 if($('#session').html()==null||$('#session').html()==""){
	    	 $.ajax({
				url:"../clientPlan/setPlan",
				type:"post",
				data:{
					encode:$("#encode").val(),
					name:$("#name").val(),
					month:$("#initDate").val(),
					details:$("#details").val(),
				},
				success:function(result){
					if(result.msg=="增加成功！"){
					alert(result.msg);
					var tab = $('#tabs').tabs('getSelected');  // 获取选择的面板
			    	tab.panel('refresh', '../client/client_plan');
					}
			 	}
	    	})
	    	}else{
	    		$.ajax({
	    			url:"../clientPlan/updatePlan2",
	    			type:"post",
	    			data:{
	    				encode:$("#encode").val(),
						name:$("#name").val(),
						month:$("#initDate").val(),
						details:$("#details").val(),
	    			},
	    			success:function(result){
	    				alert("修改成功！");
	    				var tab = $('#tabs').tabs('getSelected');  // 获取选择的面板
	    	        	tab.panel('refresh', '../client/client_plan');
	    			}
	    		})
	    	} 
	}
	
</script> 
</body>
</html>