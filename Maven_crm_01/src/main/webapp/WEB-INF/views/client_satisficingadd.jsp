<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="scripts/jquery.min.js"></script>
<title>Insert title here</title>

</head>
<body>
	<div style="position: absolute;left:22px;">
	    	 <p>客户管理>> 客户满意度管理>> 增加</p>
	    </div>
		<div style="position: absolute;left:170px;top:80px">
			<!-- <form action="../clientAllot/setMember" method="post"> -->
			<table style="width:600px;height: 280px">
				<tr>
					<td>客户编码：</td>
					<td><span id="encode"></span></td>
					<td>客户姓名：</td>
					<td>
						<select id="name">
						<c:forEach items="${querymember}" var="m">
			        		<option id="names" value="${m.mid}">${m.name}
			        		<%-- <c:choose>
			        			<c:when test="${querymemberTwo!=null}">
			        			${querymemberTwo.name}
			        			</c:when>
			        			<c:otherwise>${m.name}</c:otherwise>
			        		</c:choose> --%>
			        		</option>
			        	</c:forEach>
			            </select>
			        </td>
				</tr>
				<tr>
					<td>性别：</td>
					<td>
						<span id="sex"></span>
					</td>
					<td>客户类型：</td>
					<td><span id="type"></span></td>
				</tr>
				<tr>
					<td>客户状态：</td>
					<td>
			            <span id="status"></span>
					</td>
					<td>消费次数：</td>
					<td>
			          <span id="number"></span> 
			        </td>
				</tr>
				<tr>
					<td colspan="4"><div style="width:630px;border:1px solid black;"></div></td>
				</tr>
				<tr>
					<td>质量满意度：</td>
					<td>
						<input type="text" id="quality"  value="">%
					</td>
					<td>服务满意度 ：</td>
					<td>
						<input type="text" id="serve"  value="">%
			        </td>
				</tr>
				<tr>
					<td>性价比满意度：</td>
					<td>
						<input type="text" id="benefit"  value="">%
					</td>
					<td>总体满意度 ：</td>
					<td>
						<input type="text" id="overall"  value="">%
			        </td>
				</tr>
			</table>
			<div style="height:300px;width:500px;">
				<div style="position: absolute;left:3px;top:320px">
					<p>客户反馈：</p>
				</div>
				
				<div style="position: absolute;left:90px;top:300px">
					<textarea rows="5" cols="77" id="feedback"></textarea>
				</div>
				<div style="position: absolute;left:300px;top:500px">
					<input type="button" value="确定" onclick="add()">
					<input type="button" value="返回" onclick="fanhui()">
				</div>
			</div>	
	</div>
	<div id="take"></div>
	<script type="text/javascript">
		function fanhui(){
	    	var tab = $('#tabs').tabs('getSelected');  // 获取选择的面板
	    	tab.panel('refresh', '../client/client_satisficing');
	    }
	    function add(){
			 if($('#take').html()=="增加"){
		    	  $.ajax({
					url:"../clientSatisficing/addSatisficing",
					type:"post",
					data:{
						quality:$("#quality").val(),
						serve:$("#serve").val(),
						benefit:$("#benefit").val(),
						overall:$("#overall").val(),
						feedback:$('#feedback').val(),
						mid:$('#name').val(),
					},
					success:function(result){
						 if(result.msg=="增加成功！"){
							 alert(result.msg);
							var tab = $('#tabs').tabs('getSelected');  // 获取选择的面板
				    		tab.panel('refresh', '../client/client_satisficing');
						}
				 	}
		    	})
		    	}else{
		    		$.ajax({
		    			url:"../clientSatisficing/update",
		    			type:"post",
		    			data:{
		    				mid:$('#name').val(),
		    				quality:$("#quality").val(),
							serve:$("#serve").val(),
							benefit:$("#benefit").val(),
							overall:$("#overall").val(),
							feedback:$('#feedback').val()
		    			},
		    			success:function(result){
		    				alert("修改成功!");
		    				var tab = $('#tabs').tabs('getSelected');  // 获取选择的面板
		    	        	tab.panel('refresh', '../client/client_satisficing');
		    			}
		    		})
		    	}
		    	
	    }
	    $(function(){
	    
	    	
	    $('#name').bind('blur', function(){ 
	    	 $.ajax({
    			url:"../clientSatisficing/queryMemberTwo",
    			type:"post",
    			data:{
    				mid:$('#name').val()
    			},
    			success:function(result){
    		    	$("#encode").html(result.encode);
    		    	$("#sex").html(result.sex);
    		    	$("#type").html(result.type);
    		    	$("#status").html(result.status);
    		    	$("#number").html(result.number);
    			}
	    	}) 
	    	
    	})
	    })
	</script>	
</body>
</html>