<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'updateCheckTable.jsp' starting page</title>
    
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
		function subForm(){
			document.forms[0].submit();
		}
	</script>
  </head>
  
  <body>
     <form action="updateChecktable" method="post">
   <h5><font color="red">${error }</font></h5>
  	<input type="hidden" name="checkid" value="${requestScope.check.checkid }"/>
   <table width="100%" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td width="17" valign="top" background="images/mail_leftbg.gif"><img src="images/left-top-right.gif" width="17" height="29" /></td>
    <td valign="top" background="images/content-bg.gif"><table width="100%" height="31" border="0" cellpadding="0" cellspacing="0" class="left_topbg" id="table2">
      <tr>
        <td height="31"><div class="titlebt">汽车入库</div></td>
      </tr>
    </table></td>
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
	<table class="maintable" width="100%" border="0" cellspacing="0">
	<tr>
		<td width="12%" height="27">
	    <div align="center" class="left_txt">检查单号：</div></td>
		<td width="13%"> <div class="left_txt">${requestScope.check.checkid}</div></td>
		<td width="14%">&nbsp;</td>
		<td width="14%">&nbsp;</td>
		<td width="20%">
		  <div align="center" class="left_txt">检查时间：</div></td>
		<td width="27%"><div class="left_txt"><fmt:formatDate value="${requestScope.check.checkdate}" pattern="yyyy-MM-dd"/></div></td>
	</tr>
	<tr>
		<td width="12%" height="27">
	    <div align="center" class="left_txt">检查员：</div>		</td>
		<td width="13%"> <div class="left_txt">${requestScope.check.checkuser }</div></td>
		<td width="14%">&nbsp;</td>
		<td width="14%">&nbsp;</td>
		<td width="20%">
		  <div align="center" class="left_txt">属性：</div></td>
		<td width="27%"><input type="text" name="field" id="field" value="${requestScope.check.field}"></td>
	</tr>
	<tr>
		<td width="12%" height="27">
	    <div align="center" class="left_txt">问题：</div>		</td>
		<td width="13%"><input type="text" name="problem" id="problem" value="${requestScope.check.problem}"></td>
		<td width="14%">&nbsp;</td>
		<td width="14%">&nbsp;</td>
		<td width="20%">
		  <div align="center" class="left_txt">赔费：</div></td>
		<td width="27%"><input type="text" name="paying" id="paying" value="${requestScope.check.paying}"></td>
	</tr>
	<tr>
		<td colspan="6" align="center">
		<c:if test="${requestScope.rent.rentflag != 1}">
		 <img  src="<%=basePath%>images/carimg/ok.gif" onclick="subForm()">
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		</c:if>
			<img  src="<%=basePath%>images/carimg/return.gif" onclick="history.back()">
		</td>
	</tr>
	<tr>
		<td colspan="6">
		<hr color="#99CCFF">		</td>
	</tr>
	 <tr align="center" bgcolor="#EEF2FB">
		<td height="19" colspan="6" class="titleLine" bgcolor="#EEF2FB">
		<div align="left">
		  <p>&nbsp;</p>
		  <p>&nbsp;</p>
		</div>		</td>
	</tr>
	<tr>
		<td colspan="6">
		<hr color="#99CCFF">		</td>
	</tr>
	<tr>
		<td height="23" colspan="6" align="center">
	  <div align="center" class="left_txt">出租单信息</div>		</td>
	</tr>
	<tr>
		<td colspan="6">
		<hr color="#99CCFF">		</td>
	</tr>
	<tr>
      <td><div align="center" class="left_txt">出租单编号：</div></td>
	  <td><div align="center" class="left_txt"><font color="red">${requestScope.check.renttable.tableid }</font></div></td>
	  <td><div align="center" class="left_txt">预付金：</div></td>
	  <td><div align="center" class="left_txt"><font color="red"><fmt:formatNumber type="currency" value="${requestScope.check.renttable.imprest }"/></font></div></td>
	  <td><div align="center" class="left_txt">应付金：</div></td>
	  <td><div align="center" class="left_txt"><font color="red"><fmt:formatNumber type="currency" value="${requestScope.check.renttable.shouldpayprice }"/></font></div></td>
    </tr>
	<tr>
		<td colspan="6">
		<hr color="#99CCFF"></td>
	</tr>
	<tr>
      <td><div align="center" class="left_txt">实际交付金额：</div></td>
	  <td><div align="center" class="left_txt"><font color="red"><fmt:formatNumber type="currency" value="${requestScope.check.renttable.price }"/></font></div></td>
	  <td><div align="center" class="left_txt">起租日期：</div></td>
	  <td><div align="center" class="left_txt"><font color="red"><fmt:formatDate value="${requestScope.check.renttable.begindate }" pattern="yyyy-MM-dd"/></font></div></td>
	  <td><div align="center" class="left_txt">应归还日期：</div></td>
	  <td><div align="center" class="left_txt"><font color="red"><fmt:formatDate value="${requestScope.check.renttable.shouldreturndate }" pattern="yyyy-MM-dd"/></font></div></td>
    </tr>
	<tr>
		<td colspan="6">
		<hr color="#99CCFF">		</td>
	</tr>
	<tr>
      <td><div align="center" class="left_txt">归还日期：</div></td>
	  <td><div align="center" class="left_txt"><font color="red">
	  	<fmt:formatDate value="${requestScope.check.renttable.returndate }" pattern="yyyy-MM-dd"/>
	  	</font>
	  </div></td>
	  <td><div align="center" class="left_txt">出租单状态：</div></td>
	  <td><div align="center" class="left_txt"><font color="red">
	   <c:choose>
	  	<c:when test="${requestScope.check.renttable.rentflag eq 1}">
	  	已入库/已生成检查单
	  	</c:when>
	  	<c:otherwise>
	  		出租中
	  	</c:otherwise>
	  </c:choose>
	  </div></td>
	  <td><div align="center" class="left_txt">服务人员编号：</div></td>
	  <td><div align="center" class="left_txt"><font color="red">${requestScope.check.renttable.username }</font></div></td>
    </tr>
	<tr>
		<td colspan="6">
		<hr color="#99CCFF"></td>
	</tr>

	<tr align="center" bgcolor="#EEF2FB">
		<td height="19" colspan="6" class="titleLine" bgcolor="#EEF2FB">
		<div align="left">
		  <p>&nbsp;</p>
		  <p>&nbsp;</p>
		</div>		</td>
	</tr>
	<tr>
      <td colspan="6"><hr color="#99CCFF">      </td>
    </tr>
	<tr>
      <td height="23" colspan="6"><div align="center" class="left_txt">客户信息</div></td>
    </tr>
	<tr>
      <td colspan="6"><hr color="#99CCFF">      </td>
    </tr>
	<tr>
      <td><div align="center" class="left_txt">身份证：</div></td>
	  <td><div align="center" class="left_txt"><font color="red">${requestScope.check.renttable.cust.identity }</font></div></td>
	  <td><div align="center" class="left_txt">姓名：</div></td>
	  <td><div align="center" class="left_txt"><font color="red">${requestScope.check.renttable.cust.custname }</font></div></td>
	  <td><div align="center" class="left_txt">性别：</div></td>
	  <td><div align="center" class="left_txt"><font color="red">${requestScope.check.renttable.cust.sex }</font></div></td>
    </tr>
	<tr>
      <td colspan="6"><hr color="#99CCFF">      </td>
    </tr>
	<tr>
      <td><div align="center" class="left_txt">地址：</div></td>
	  <td><div align="center" class="left_txt"><font color="red">${requestScope.check.renttable.cust.address }</font></div></td>
	  <td><div align="center" class="left_txt">电话：</div></td>
	  <td><div align="center" class="left_txt"><font color="red">${requestScope.check.renttable.cust.phone }</font></div></td>
	  <td><div align="center" class="left_txt">职业：</div></td>
	  <td><div align="center" class="left_txt"><font color="red">${requestScope.check.renttable.cust.career }</font></div></td>
    </tr>
	<tr>
      <td colspan="6"><hr color="#99CCFF">      </td>
    </tr>
     <tr align="center" bgcolor="#EEF2FB">
		<td height="19" colspan="6" class="titleLine" bgcolor="#EEF2FB">
		<div align="left">
		  <p>&nbsp;</p>
		  <p>&nbsp;</p>
		</div>		</td>
	</tr>
	<tr>
      <td colspan="6"><hr color="#99CCFF">      </td>
    </tr>
	<tr>
     <td height="23" colspan="6"><div align="center" class="left_txt">车信息</div></td>
	 
    </tr>
    <tr>
      <td colspan="6"><hr color="#99CCFF">      </td>
    </tr>
    <tr>
      <td><div align="center" class="left_txt">车号：</div></td>
	  <td><div align="center" class="left_txt"><font color="red">${requestScope.check.renttable.car.carnumber }</font></div></td>
	  <td><div align="center" class="left_txt">型号：</div></td>
	  <td><div align="center" class="left_txt"><font color="red">${requestScope.check.renttable.car.cartype }</font></div></td>
	  <td><div align="center" class="left_txt">颜色：</div></td>
	  <td><div align="center" class="left_txt"><font color="red">${requestScope.check.renttable.car.color }</font></div></td>
    </tr>
    <tr>
      <td colspan="6"><hr color="#99CCFF">      </td>
    </tr>
    <tr>
      <td><div align="center" class="left_txt">价值：</div></td>
	  <td><div align="center" class="left_txt"> <font color="red"><fmt:formatNumber type="currency" value="${requestScope.check.renttable.car.price }"/></font></div></td>
	  <td><div align="center" class="left_txt">租金：</div></td>
	  <td><div align="center" class="left_txt"> <font color="red"><fmt:formatNumber type="currency" value="${requestScope.check.renttable.car.rentprice }"/></font></div></td>
	  <td><div align="center" class="left_txt">押金：</div></td>
	  <td><br><div align="center" class="left_txt"><font color="red"><fmt:formatNumber type="currency" value="${requestScope.check.renttable.car.deposit }"/> </font></div><br></td>
    </tr>
    <tr>
      <td colspan="6"><hr color="#99CCFF">      </td>
    </tr>
    <tr>
      <td><div align="center" class="left_txt">租用情况：</div></td>
	  <td><div align="center" class="left_txt"><font color="red">
	   <c:choose>
	  	<c:when test="${requestScope.check.renttable.car.isrenting eq 1 }">
	  		已出租
	  	</c:when>
	  	<c:otherwise>
	  		未出租
	  	</c:otherwise>
	  </c:choose>
	  </font>
	  </div></td>
	  <td><div align="center" class="left_txt">简介：</div></td>
	  <td><div align="center" class="left_txt"><font color="red">${requestScope.check.renttable.car.description }</font></div></td>
	 
    </tr>
    <tr>
		<td colspan="6">
		<hr color="#99CCFF"></td>
	</tr>
</table>
  </body>
</html>
