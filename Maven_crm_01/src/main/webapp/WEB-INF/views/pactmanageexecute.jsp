<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>合同执行</title>
<style type="text/css">
	#pact_script input{
		border:none;
	}
	#pact_script textarea{
		border:none;
	}
</style>
</head>
<body>
	<div>
		<input type="hidden" name="pid" id="pid" />
		<table id="pact_script">
			<tr id="pact_input">
				<!-- <td colspan="2" ><h5>合同管理>> 合同审核>> 审核操作</h5></td> -->
				<td colspan="2"><h3>执行合同</h3></td>
			</tr>
			<tr>
				<td>合同名称：</td>
				<td colspan="3" id="pact_input"><input style="width:470px" name="pname"/></td>
			</tr>
			<tr>
				<td>合同类型：</td>
				<td id="pact_input">
					<input type="text" id="ptype" name="ptype" />
				<span class="point_red">*</span></td>
				<td>合同金额：</td>
				<td id="pact_input"><input style="width:115px" name="pmoney"/>元</td>
			</tr>
			<tr>
				<td>合同状态：</td>
				<td id="pact_input"><input style="width:135px" name="pstate"/></td>
				<td>客户方：</td>
				<td id="pact_input"><input style="width:135px" name="pyi"/></td>
			</tr>
			<tr>
				<td>经营许可证号：</td>
				<td id="pact_input"><input style="width:135px" name="poperateyi"/></td>
				<td>创建人：</td>
				<td id="pact_input"><input style="width:135px" name="poperator"/></td>
			</tr>
			<tr>
				<td>创建时间：</td>
				<td id="pact_input"><input style="width:135px" name="pcreateTime"/></td>
				<td>待处理人：</td>
				<td id="pact_input"><input style="width:135px" name="ppeople"/></td>
			</tr>
			<tr>
				<td>合同内容：</td>
				<td colspan="3" id="pact_input"></td>
			</tr>
			<tr>
				<td colspan="3" class="pactLeft">
					<textarea cols="45" rows="3"  maxlength="250" name="pcontent"></textarea>
				</td>
			</tr>
		</table>
	</div>
	<link rel="stylesheet" type="text/css" href="../css/pact.css">
</body>
</html>