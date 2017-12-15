<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录</title>
<LINK rel="stylesheet" type="text/css" href="../css/style.css">
</head>
<body>
	<DIV id="regLogin" class="wrap">
		<DIV class="dialog">
			<DIV class="box">
				<H4>用户登录</H4>
				<FORM id="user" action="../role/loginPost" method="post" validate="true">
					<DIV class="infos">
						<TABLE class="field">
							<TBODY>
								<TR>
									<TD colSpan=2></TD>
								</TR>
								<TR>
									<TD class="field">用 户 名：</TD>
									<TD><INPUT id="nusername" class="text" type="text"
										name="nusername" required="true"></TD>
								</TR>
								<TR>
									<TD class=field>密 码：</TD>
									<TD><INPUT id="password" class="text" type="password"
										name="password" required="true"></TD>
								</TR>
							</TBODY>
						</TABLE>
						<DIV class="buttons">
							<INPUT value="登陆" type="submit">
						</DIV>
					</DIV>
				</FORM>
			</DIV>
		</DIV>
	</DIV>
	<DIV id="footer" class="wrap">
		<DL>
			<DT>客户管理系统 2017理想IT 京ICP证1000001号</DT>
			<DD>关于我们 · 联系方式 · 意见反馈 · 帮助中心</DD>
		</DL>
	</DIV>
</body>
</html>