<%@ page import="by.epamlab.beans.user.Role" %>
<%@ page import="by.epamlab.beans.user.User" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/tld/c.tld" prefix="c"%>
<%@ page isELIgnored="false" %>
<html>
<head>
    <%
        User user = (User) request.getSession().getAttribute("user");
        if(user.getRole() != Role.VISITOR) {
    %>
    <META HTTP-EQUIV="Refresh" CONTENT="0; URL=/reservation.do" >
    <%
        }
    %>
</head>
<body>

</body>
</html>
