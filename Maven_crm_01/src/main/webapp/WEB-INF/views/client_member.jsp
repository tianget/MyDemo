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
	    	 <p>客户管理>> 客户资源管理>>增加客户资源</p>
	    </div>
		<div style="position: absolute;left:100px;top:70px">
			<!-- <form action="../clientAllot/setMember" method="post"> -->
			<table style="width:750px;height: 280px">
				<tr>
					<td>客户编码：</td>
					<td><input type="text"  id="encode" value="${member.encode }"></td>
					<td>客户姓名：</td>
					<td><input type="text"  id="name"  value="${member.name }"><span style="color:red">&nbsp;*</span></td>
				</tr>
				<tr>
					<td>性别：</td>
					<td>
						<input type="radio" value="男" name="sex" checked="checked">男
						<input type="radio" value="女" name="sex">女
						<span style="color:red">&nbsp;*</span>
					</td>
					<td>生日：</td>
					<td><input type="text" id="birth" class="easyui-datebox" value="${member.name }"></td>
				</tr>
				<tr>
					<td>类型：</td>
					<td>
						<select id="type"  value="${member.type }">
			        		<option value="普通客户">普通客户
			        		<option value="银卡客户">银卡客户
			        		<option value="金卡客户">金卡客户
			        		<option value="vip客户">vip客户
			            </select><span style="color:red">&nbsp;*</span>
					</td>
					<td>状态：</td>
					<td>
						<select id="status"  value="${member.status }">
			        		<option value="启用">启用
			        		<option value="禁用">禁用
			        		<option value="流失">流失
			            </select><span style="color:red">&nbsp;*</span>
			        </td>
				</tr>
				<tr>
					<td>手机：</td>
					<td>
						<input type="text" id="phone"  value="${member.phone }">
					</td>
					<td>办公电话 ：</td>
					<td>
						<input type="text" id="workPhone"  value="${member.workPhone }">
			        </td>
				</tr>
				<tr>
					<td>电子邮箱：</td>
					<td>
						<input type="text" id="email"  value="${member.email }">
					</td>
					<td>家庭电话 ：</td>
					<td>
						<input type="text" id="familyPhone"  value="${member.familyPhone }">
			        </td>
				</tr>
			</table>
			<div style="height:300px;width:700px;">
				<div style="position: absolute;left:3px;top:320px">
					<p>联系地址：</p>
				</div>
				
				<div style="position: absolute;left:90px;top:300px">
					<textarea rows="5" cols="77" id="address">${member.address }</textarea>
				</div>
				<div style="position: absolute;left:3px;top:420px">
					<p>备注信息：</p>
				</div>
				<div style="position: absolute;left:90px;top:400px">
					<textarea rows="5" cols="77" id="remarks">${member.remarks }</textarea>
				</div>
				<div style="position: absolute;left:300px;top:500px">
					<input type="button" value="确定" onclick="add()">
					<input type="button" value="返回" onclick="fanhui()">
				</div>
			</div>	
		<!-- </form> -->
	</div>
	<div id="session" style="display: none;">${ member.mid}</div>
	<script type="text/javascript">
	$(function(){
		/* //月份
	    $('#birth').datebox({    
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
    	tab.panel('refresh', '../client/client_allot');
    }
    function add(){
    	if($('#session').html()==null||$('#session').html()==""){
    	 $.ajax({
			url:"../clientAllot/setMember",
			type:"post",
			data:{
				encode:$("#encode").val(),
				name:$("#name").val(),
				sex:$("input[name='sex']:checked").val(),
				birth:$("#birth").val(),
				type:$("#type").val(),
				status:$("#status").val(),
				phone:$("#phone").val(),
				workPhone:$("#workPhone").val(),
				email:$("#email").val(),
				familyPhone:$("#familyPhone").val(),
				address:$("#address").val(),
				remarks:$("#remarks").val(),
			},
			success:function(result){
				/* aler(result);
				if(data.msg=="增加成功"){
					alert("2");
				var tab = $('#tabs').tabs('getSelected');  // 获取选择的面板
		    	tab.panel('refresh', '../client/client_allot');
				} */
		 	}
    	})
    	alert("增加成功！");
    	var tab = $('#tabs').tabs('getSelected');  // 获取选择的面板
    	tab.panel('refresh', '../client/client_allot'); 
    	}else{
    		$.ajax({
    			url:"../clientAllot/updateMemberTwo",
    			type:"post",
    			data:{
    				mid:$('#session').html(),
    				encode:$("#encode").val(),
    				name:$("#name").val(),
    				sex:$("input[name='sex']:checked").val(),
    				birth:$("#birth").val(),
    				type:$("#type").val(),
    				status:$("#status").val(),
    				phone:$("#phone").val(),
    				workPhone:$("#workPhone").val(),
    				email:$("#email").val(),
    				familyPhone:$("#familyPhone").val(),
    				address:$("#address").val(),
    				remarks:$("#remarks").val(),
    			},
    			success:function(result){
    				
    			}
    		})
    		alert("修改成功！");
    		var tab = $('#tabs').tabs('getSelected');  // 获取选择的面板
        	tab.panel('refresh', '../client/client_allot'); 
    	}
    }
    
</script>	
</body>
</html>