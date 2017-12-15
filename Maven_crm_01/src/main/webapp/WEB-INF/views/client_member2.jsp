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
					<td><input type="text"  id="encode" value="${member.encode }s" readonly="readonly"></td>
					<td>客户姓名：</td>
					<td><input type="text"  id="name"  value="${member.name }"  readonly="readonly"><span style="color:red">&nbsp;*</span></td>
				</tr>
				<tr>
					<td>性别：</td>
					<td>
						${member.sex }<span style="color:red">&nbsp;*</span>
					</td>
					<td>生日：</td>
					<td><input type="text" id="birth" class="easyui-datebox"  value="${member.name }"  readonly="readonly"></td>
				</tr>
				<tr>
					<td>类型：</td>
					<td>
			            <input type="text" id="type"  value="${member.type }"  readonly="readonly"><span style="color:red">&nbsp;*</span>
					</td>
					<td>状态：</td>
					<td>
			            <input type="text" id="status"  value="${member.status }"  readonly="readonly"><span style="color:red">&nbsp;*</span><span style="color:red">&nbsp;*</span>
			        </td>
				</tr>
				<tr>
					<td>手机：</td>
					<td>
						<input type="text" id="phone"  value="${member.phone }"  readonly="readonly">
					</td>
					<td>办公电话 ：</td>
					<td>
						<input type="text" id="workPhone"  value="${member.workPhone }"  readonly="readonly">
			        </td>
				</tr>
				<tr>
					<td>电子邮箱：</td>
					<td>
						<input type="text" id="email"  value="${member.email }"  readonly="readonly">
					</td>
					<td>家庭电话 ：</td>
					<td>
						<input type="text" id="familyPhone"  value="${member.familyPhone }"  readonly="readonly">
			        </td>
				</tr>
			</table>
			<div style="height:300px;width:700px;">
				<div style="position: absolute;left:3px;top:320px">
					<p>联系地址：</p>
				</div>
				
				<div style="position: absolute;left:90px;top:300px">
					<textarea rows="5" cols="77" id="address"  readonly="readonly">${member.address }</textarea>
				</div>
				<div style="position: absolute;left:3px;top:420px">
					<p>备注信息：</p>
				</div>
				<div style="position: absolute;left:90px;top:400px">
					<textarea rows="5" cols="77" id="remarks" readonly="readonly">${member.remarks }</textarea>
				</div>
				<div style="position: absolute;left:300px;top:500px">
					<input type="button" value="返回" onclick="fanhui()">
				</div>
			</div>	
		<!-- </form> -->
	</div>
	<script type="text/javascript">
	$(function(){
		//月份
	    /* $('#birth').datebox({    
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
</script>	
</body>
</html>