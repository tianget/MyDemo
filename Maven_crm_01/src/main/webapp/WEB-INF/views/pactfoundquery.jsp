<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>合同查看</title>
<link rel="stylesheet" type="text/css" href="easyui/themes/default/easyui.css" />
<link rel="stylesheet" type="text/css" href="easyui/themes/icon.css" />
<script type="text/javascript" src="easyui/jquery.min.js"></script>
<script type="text/javascript" src="easyui/jquery.easyui.min.js"></script>
<script type="text/javascript"	src="easyui/locale/easyui-lang-zh_CN.js"></script>

</head>
<body>
	<div>
		<table id="pact_script">
			<tr id="pact_input">
				<td colspan="2" ><h5>合同管理>>合同查看</h5></td>
				<td colspan="2"><h3>查看合同</h3></td>
			</tr>
			<tr>
				<td>合同名称：</td>
				<td colspan="3" id="pact_input"><input style="width:470px" value="${pact.pname}" id="pname"/></td>
			</tr>
			<tr>
				<td>合同类型：</td>
				<td id="pact_input">
					<input id="ptype" value="${pact.ptype}" id="ptype" name="ptype"/>
				<td>合同金额：</td>
				<td id="pact_input"><input style="width:115px" value="${pact.pmoney}" id="pmoney"/>元</td>
			</tr>
			<tr>
				<td>甲方：</td>
				<td id="pact_input"><input style="width:135px" value="${pact.pjia}" id="pjia"/></td>
				<td>乙方：</td>
				<td id="pact_input"><input style="width:135px" value="${pact.pyi}" id="pyi"/></td>
			</tr>
			<tr>
				<td>企业经营许可号：</td>
				<td id="pact_input"><input style="width:135px" value="${pact.poperatejia}" id="poperatejia"/></td>
				<td>企业经营许可号：</td>
				<td id="pact_input"><input style="width:135px" value="${pact.poperateyi}" id="poperateyi"/></td>
			</tr>
			<tr>
				<td>合同内容：</td>
				<td colspan="3" id="pact_input"></td>
			</tr>
			<tr>
				<td colspan="4" class="pactLeft">
					<textarea cols="75" rows="15"  maxlength="250" name="pcontent" id="pcontent">${pact.pcontent}</textarea>
				</td>
			</tr>
			<tr>
				<td>备注信息：
				</td>
				<td rowspan="6" colspan="3" id="pact_input">
					<textarea cols="67" rows="14"  maxlength="250" name="premarks" id="premarks">${pact.premarks}</textarea>
				</td>
			</tr>
			<tr>
				<td style="height:200px"></td>
			</tr>
		</table>
	</div>
	<script type="text/javascript" src="../js/pactfoundupdate.js"></script>
	<link rel="stylesheet" type="text/css" href="../css/pact.css">
</body>
</html>