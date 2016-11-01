<%--
  Created by IntelliJ IDEA.
  User: cloudma
  Date: 16/10/30
  Time: 下午6:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title></title>
</head>
<body>

<c:choose>
  <c:when test="${user!=null}">
  当前登录的用户基本信息:<br/>

  ${user.realname}<br/>
  ${user.mobile}

  </c:when>
  <c:otherwise>
    当前没有登录用户！
  </c:otherwise>
</c:choose>

</body>
</html>
