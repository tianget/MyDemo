<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="scripts/jquery.min.js"></script>
<title>Insert title here</title>

</head>
<body>
	<div style="position: absolute;left:22px;">
	    	 <p>客户管理>> 客户满意度管理>> 查看</p>
	    </div>
		<div style="position: absolute;left:170px;top:80px">
			<!-- <form action="../clientAllot/setMember" method="post"> -->
			<table style="width:600px;height: 280px">
				<!-- <tr>
					<td>机会名称：</td>
					<td colspan="3"><span id="chanceName"></span></td>
					
				</tr>
				<tr>
					<td>机会类型：</td>
					<td>
						<span id="chanceType"></span>
					</td>
					<td>机会来源：</td>
					<td><span id="chanceOrigin"></span></td>
				</tr>
				<tr>
					<td>录入人：</td>
					<td>
			            <span id="enteringManId"></span>
					</td>
					<td>录入时间：</td>
					<td>
			          <span id="enteringDate"></span> 
			        </td>
				</tr>
				<tr>
					<td>最后操作人：</td>
					<td>
			            <span id="lastUpdateManId"></span>
					</td>
					<td>最后修改时间：</td>
					<td>
			          <span id="lastUpdateDate"></span> 
			        </td>
				</tr>
				<tr>
					<td>机会内容：</td>
					<td colspan="4">
			            <span id="chanceContent"></span>
					</td>
				</tr> -->
				<tr>
					<td colspan="4"><div style="width:630px;border:1px solid black;"></div></td>
				</tr>
				<tr>
				
				</tr>
				<tr>
					<td colspan="4">
			            <span id="chanceContent"></span>
					</td>
				</tr>
				<div style="height:300px;width:500px;">
				<div style="position: absolute;left:290px;top:300px">
					<select id="name">      
					</select>
				</div>
				<div style="position: absolute;left:300px;top:400px">
					<input type="button" value="确定" onclick="add()">
					<input type="button" value="返回" onclick="fanhui()">
			</div>	
	</div>
	<script type="text/javascript">
		function fanhui(){
	    	var tab = $('#tabs').tabs('getSelected');  // 获取选择的面板
	    	tab.panel('refresh', '../client/client_allot');
	    }
		function add(){
			 $.ajax({
        		url:'../clientAllot/setAllotd',
    		    type:"post",
    		    data:{sid:$('#name').val()},
    		    success:function(result){	
    		    	 if(result!=0){
    		    		 alert("分配成功！");
    		    		 var tab = $('#tabs').tabs('getSelected');  // 获取选择的面板
    		 	    	 tab.panel('refresh', '../client/client_allot');
    		    	 }else{
    		    		 alert("分配失败！");
    		    	 }
    		    }
        	}) 
	    }
		$(function(){
			$.ajax({
        		url:'../clientAllot/getAllotd',
    		    type:"post",
    		    success:function(result){	
    		    	$op="";
    		    	for (var i = 0; i < result.length; i++) {
    		    		$op+="<option value='"+result[i].sid+"'>"+result[i].name+"</option>";
					}
   		    		$('#name').html($op); 
    		    }
        	})
		})
	</script>	
</body>
</html>