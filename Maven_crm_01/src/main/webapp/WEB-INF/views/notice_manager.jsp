<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>公告管理</title>
<style type="text/css">
#notice_fm {
	margin: 0;
	padding: 10px 30px;
}

.notice_ftitle {
	font-size: 14px;
	font-weight: bold;
	padding: 5px 0;
	margin-bottom: 10px;
	border-bottom: 1px solid #ccc;
}

.notice_fitem {
	margin-bottom: 5px;
}

.notice_fitem label {
	display: inline-block;
	width: 80px;
}

.notice_fitem input {
	width: 160px;
}

#notice_fm2 {
	margin: 0;
	padding: 10px 30px;
}

.notice_ftitle2 {
	font-size: 14px;
	font-weight: bold;
	padding: 5px 0;
	margin-bottom: 10px;
	border-bottom: 1px solid #ccc;
}

.notice_fitem2 {
	margin-bottom: 5px;
}

.notice_fitem2 label {
	display: inline-block;
	width: 80px;
}

.notice_fitem2 input {
	width: 160px;
}
</style>
</head>
<body>
	<div style="padding-left: 20px; padding-top: 15px">系统设置>>公告管理</div>
	<div id="div_toolOne"
		style="padding-left: 100px; padding-top: 15px; text-align: left;">
		<select id="select_name" class="easyui-combobox" name="dept"
			style="width: 80px;">
			<option value="aa">公告名称</option>
		</select> <input type="text" id="notice_searchTitle" class="textbox"
			name="votem" style="width: 220px; height: 22px;" /> <a href="#"
			onclick="notice_search()" class="easyui-linkbutton"
			iconCls="icon-search">搜索</a>
	</div>

	<hr />
	<div style="padding-left: 20px;">
		<strong>公告信息列表</strong>&nbsp;&nbsp;
	<a href="javascript:onclick=refresh()" class="easyui-linkbutton" iconCls="icon-reload">刷新</a>
		&nbsp;&nbsp;
	 <a href="javascript:onclick=notice_save()" class="easyui-linkbutton" iconCls="icon-add">发布公告</a>
	  &nbsp;
	 <a href="javascript:onclick=notice_update()" class="easyui-linkbutton" iconCls="icon-edit">修改</a>
	  &nbsp;
	 <a href="javascript:onclick=delete_notice()" class="easyui-linkbutton" iconCls="icon-remove">删除</a>
	   &nbsp;
	 <a href="javascript:onclick=notice_see('../system/notice_de','公告详细信息查看','refresh')" class="easyui-linkbutton" iconCls="icon-search">查看</a>
	</div>
	<table id="notice_manager">
	</table>
	<div id="notice_dlg" class="easyui-dialog"
		style="width: 300px; height: 300px; padding: 10px 20px" closed="true"
		buttons="#notice-dlg-buttons1">
		<form id="notice_fm" method="post">
			<div class="notice_fitem">
				<label>公告编码:</label> <input name="noticeCoding" id="noticeCoding2"
					type="text" class="easyui-textbox" required="true">
			</div>
			<p></p>
			<div class="notice_fitem">
				<label>公告标题:</label> <input name="noticeTitle" id="noticeTitle2" type="text"
					class="easyui-textbox" required="true">
			</div>
			<p></p>
			<div class="notice_fitem">
				<label>公告类型:</label> <select id="option" name="type_id">
					<option value="无">无</option>
				</select>
			</div>
			<p></p>
			<div class="notice_fitem">
				<label>公告内容:</label> <input id="noticeContent2" name="noticeContent" type="text"
					class="easyui-textbox" required="true" />
			</div>
		</form>
	</div>
	<div id="notice-dlg-buttons1">
		<a href="#" class="easyui-linkbutton" iconCls="icon-ok"
			style="width: 90px" onclick="start_notice_save()">保存</a> <a href="#"
			class="easyui-linkbutton" iconCls="icon-cancel" style="width: 90px"
			onclick="javascript:$('#notice_dlg').dialog('close')">取消</a>
	</div>
	<div id="notice_dlg2" class="easyui-dialog"
		style="width: 300px; height: 350px; padding: 10px 20px" closed="true"
		buttons="#notice-dlg-buttons2">
		<form id="notice_fm2" method="post">
			<div class="notice_fitem2">
				<label>公告编码:</label>
				<input id="id3" name="noticeId" type="hidden">
				<input name="noticeCoding"  id="noticeCoding3" type="text" readonly="true" />
			</div>
			<p></p>
			<div class="notice_fitem2">
				<label>公告标题:</label> <input name="noticeTitle" id="noticeTitle3" type="text" />
			</div>
			<p></p>
			<div class="notice_fitem2">
				<label>发布人:</label>&nbsp;&nbsp;&nbsp;<input name="name" id="name3" type="text" readonly="true"/>
			</div>
			<p></p>
			<div class="notice_fitem2">
				<label>公告类型:</label> <select id="option2" name="noticeType">
					<option value="无">无</option>
				</select>
			</div>
			<p></p>
			<div class="notice_fitem2">
				<label>公告内容:</label> <input name="noticeContent" id="noticeContent3" type="text" />
			</div>
		</form>
	</div>
	<div id="notice-dlg-buttons2">
		<a href="#" class="easyui-linkbutton" iconCls="icon-ok"
			style="width: 90px" onclick="notice_update_start()">修改</a> <a href="#"
			class="easyui-linkbutton" iconCls="icon-cancel" style="width: 90px"
			onclick="javascript:$('#notice_dlg2').dialog('close')">取消</a>
	</div>
	<script type="text/javascript" src="../js/notice_manager.js"></script>
</body>
</html>