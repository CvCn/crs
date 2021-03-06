<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>My JSP 'updateRole.jsp' starting page</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<link href="images/skin.css" rel="stylesheet" type="text/css" />
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
		<style type="text/css">
	body {
		margin-left: 0px;
		margin-top: 0px;
		margin-right: 0px;
		margin-bottom: 0px;
		background-color: #EEF2FB;
	}
</style>
	<script type="text/javascript">
		function modifyRoleOK(roleId){
			var flag = window.confirm("是否真的要修改？")
			if(flag){
			document.getElementById('roleId').value = roleId;
			document.forms[0].submit();
			}
		}
		
		function selectSub(fatherId){
			var elms = document.getElementsByName("s"+fatherId.name.substring(1,fatherId.name.length));
			var flag = fatherId.checked;
			for(var i=0;i<elms.length;i++){
				elms[i].checked = flag;
			}
  }
	function selectFather(sunId){
		var fatherId = document.getElementsByName("f"+sunId.name.substring(1,sunId.name.length));
		var elms = document.getElementsByName(sunId.name);
		var flag = false;
		for(var i=0;i<elms.length;i++){
			if(elms[i].checked){
				flag=true;
				break;
			}
	 }
	fatherId[0].checked=flag;
}
	</script>
	</head>
	
	<body>
		<form action="updateRole" method="post">
		<input type="hidden" name="roleid" id="roleId"/>
		 <table width="100%" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td width="17" valign="top" background="images/mail_leftbg.gif"><img src="images/left-top-right.gif" width="17" height="29" /></td>
    <td valign="top" background="images/content-bg.gif"><table width="100%" height="31" border="0" cellpadding="0" cellspacing="0" class="left_topbg" id="table2">
      <tr>
        <td height="31"><div class="titlebt">修改角色</div></td>
      </tr>
    </table>
     <td width="16" valign="top" background="images/mail_rightbg.gif"><img src="images/nav-right-bg.gif" width="16" height="29" /></td>
  </tr>
  <tr>
    <td valign="middle" background="images/mail_leftbg.gif">&nbsp;</td>
    <td valign="top" bgcolor="#F7F8F9"><table width="98%" border="0" align="center" cellpadding="0" cellspacing="0">
      <tr>
        <td colspan="2" valign="top">&nbsp;</td>
        <td>&nbsp;</td>
        <td valign="top">&nbsp;</td>
      </tr>
      <tr>
        <td colspan="2" valign="top"><span class="left_bt">
			<table align="center">
				<tr>
					<td align="center" class="left_txt">
						角色名称：
						<input type="text" name="rolename" value="${role.rolename }" />
						<br />
						<a style="color: blue; text-decoration: underline; cursor: hand" onclick="modifyRoleOK(${role.roleid })">确认</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<a style="color: blue; text-decoration: underline; cursor: hand" onclick="history.back()">返回</a>
					</td>
					<td>
					<c:forEach var="menus" items="${sessionScope.user.roles.menus}">
	         			<c:if test="${menus.fatherid==0}" var="father">
         					<li class="left_txt">
         						<input type="checkbox" name="menuid" id="f${menus.menuid }" onclick="selectSub(this)" value="${menus.menuid }" ${menus.checked } ${requestScope.disabled }/>${menus.name }        						
         					</li>
         					<ul class="left_txt">         		
         						<c:forEach var="sun" items="${menus.childrenmenus}">
         							<c:if test="${sun.fatherid==menus.menuid}">
         								<input type="checkbox" name="menuid" id="s${sun.fatherid }" onclick="selectFather(this)" value="${sun.menuid }" ${sun.checked } ${requestScope.disabled }/>${sun.name }<br/>
         							</c:if>
         						</c:forEach>         				
         					</ul>
	         			</c:if>	
         		    </c:forEach>
					</td>
				</tr>
			</table>
			</span>
			</td>
			</tr>
			</table>
			</td>
			</tr>
	        </table>
		</form>
	</body>
</html>
