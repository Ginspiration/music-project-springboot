<%--
  Created by IntelliJ IDEA.
  User: Ginpspiration
  Date: 2021/2/2
  Time: 12:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<div align="center">
    <%
        Cookie cookies[] = request.getCookies();
        for (Cookie cookie : cookies) {
            out.print("Cookie：" + cookie.getValue() + "<br/>");
            //out.print(cookie.getName());
        }
        out.print("Session:" + session.getAttribute("cname2"));
        //response.sendRedirect("/test/forward.jsp");
    %>
</div>
</body>
</html>
