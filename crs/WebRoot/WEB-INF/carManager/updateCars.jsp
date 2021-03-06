<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'updateCar.jsp' starting page</title>
    
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
     <form action="updateCar" method="post" enctype="multipart/form-data">
   <table width="100%" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td width="17" valign="top" background="images/mail_leftbg.gif"><img src="images/left-top-right.gif" width="17" height="29" /></td>
    <td valign="top" background="images/content-bg.gif"><table width="100%" height="31" border="0" cellpadding="0" cellspacing="0" class="left_topbg" id="table2">
      <tr>
        <td height="31"><div class="titlebt">更新汽车</div></td>
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
           <table class="maintable" width="97%" border="0" cellspacing="0">
    <tr>
      <td width="14%"><div align="center">车号</div></td>
      <td width="23%"><input type="text" name="carnumber" id="carNumber" value="${requestScope.car.carnumber }" readonly></td>
      <td width="15%"><div align="center">型号</div></td>
      <td width="48%"><input type="text" name="cartype" id="carType" value="${requestScope.car.cartype }"></td>
    </tr>
    <tr>
      <td><div align="center">颜色</div></td>
      <td><input type="text" name="color" id="color"  value="${requestScope.car.color }"></td>
       <td><div align="center">价值</div></td>
      <td><input type="text" name="price" id="price" value="${requestScope.car.price }"></td>
      
    </tr>
    <tr>
      <td><div align="center">租金</div></td>
      <td><input type="text" name="rentprice" id="rentPrice" value="${requestScope.car.rentprice }"></td>
     <td><div align="center">押金</div></td>
      <td><input type="text" name="deposit" id="deposit" value="${requestScope.car.deposit }"></td>
    </tr>
    <tr>
      <td><div align="center">租用情况 </div></td>
      <td>
     <select name="isrenting" id="isRenting" style="width: 80px;">
     <c:choose>
     	<c:when test="${requestScope.car.isrenting eq 0 }">
     	<option value="0" selected>未出租</option>
			<option value="1">已出租</option>
     	</c:when>
     	<c:otherwise>
     	    <option value="0" >未出租</option>
			<option value="1" selected>已出租</option>
     	</c:otherwise>
     </c:choose>
	</select>
      </td>
    </tr>
    <tr>
    	<td><div align="center">图片预览 </div></td>
    	<td><img src="upload/${requestScope.car.imgpath}" height="300px" alt="没有图片" /></td>
    	<td><div align="center">更改汽车图片</div></td>
      <td>
      <input type="file" name="file" id="file"/>
      </td>
    </tr>
     <tr>
		<td colspan="6">
		<hr color="#99CCFF"></td>
	</tr>
     <tr align="center" bgcolor="#99CCFF">
      <td height="26" colspan="4" class="titleLine"><div align="left"> 简介：<span class="style2"></span></div></td>
    </tr>
    <tr>
      <td height="121" colspan="4" align="center"><textarea name="description" id="cardesc" cols="140" rows="5">${requestScope.car.description }</textarea></td>
    </tr>
  </table>
      
    <table align="left" width="100%">
	<tr>
		<td height="107">
		<div align="center">
		<img  src="<%=basePath%>images/carimg/ok.gif" onclick="subForm()" style="cursor: hand;">
		 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		 <img  src="<%=basePath%>images/carimg/reset.gif" onclick="reset()" style="cursor: hand;">
		</div>
	  </td>
	</tr>
	<tr>
		<td height="30" background="<%=basePath%>images/bg.gif"></td>
	</tr>
</table>
</span>
	</td>
      </tr>
     
      <tr>
        
        <td valign="top"><table width="100%" height="144" border="0" cellpadding="0" cellspacing="0" class="line_table">
        </table></td>
      </tr>
    </table></td>
    <td background="images/mail_rightbg.gif">&nbsp;</td>
  </tr>
  <tr>
    <td valign="bottom" background="images/mail_leftbg.gif"><img src="images/buttom_left2.gif" width="17" height="17" /></td>
    <td background="images/buttom_bgs.gif"><img src="images/buttom_bgs.gif" width="17" height="17"></td>
    <td valign="bottom" background="images/mail_rightbg.gif"><img src="images/buttom_right2.gif" width="16" height="17" /></td>
  </tr>
</table>
  </form>
  </body>
</html>
