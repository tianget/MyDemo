<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>公告详细信息</title>
</head>
<body>
	<div
		style="width: 800px; height: 300px; padding-top: 50px; position: relative; left: 200px;">
		<div id="title"
			style="padding-left: 20px; padding-top: 15px; position: relative; left: -180px; top: -40px;">系统设置>>公告管理>>查看公告信息</div>
		<div
			style="padding-left: 30px; background-color: #ccccff; font-size: 15px; padding-top: 5px">
		</div>
		<div
			style="padding-left: 30px; font-size: 15px; padding-top: 5px; background-color: lightyellow;">
			<strong>基本信息</strong>
		</div>
		<div id="user_message" style="padding-left: 60px; height: 115px;">
			<div style="padding-right: 250px; width: 300px; font-size: 18px;">
				<p>编号：${notice.noticeCoding}</p>
				<p>标题：${notice.noticeTitle}</p>
				<p>类型：${notice.noticeTypeText}</p>
				
			</div>
			<div
				style="padding-left: 100px; position: relative; left: 250px; top: -120px; width: 300px; font-size: 18px;">
				<p>时间：${notice.noticeTime}</p>
				<p>内容：${notice.noticeContent}</p>
				<p>发布人：${notice.name}</p>
			</div>
		</div>
		<a href="javascript:onclick=back('../system/noticeManager','公告管理','notice_dataBack')" class="easyui-linkbutton"
				iconCls="icon-arrow-rotate-clockwise" style="position: relative;left: 300px;top: 80px" >返回</a>
	</div>
</body>
</html>