<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ListPage</title>
    <style type="text/css">
        .pager {
            position: fixed;
            left: 0; bottom: 0;
            padding: 30px;
            width: 100%;
        }
    </style>
</head>
<body>
    <ul class="pager">
        <li><html:link action="/reservation">Reservation</html:link></li>
        <li><html:link action="/customer">Customer</html:link></li>
        <li><html:link action="/farefamily">FareFamily</html:link></li>
    </ul>
</body>
</html>
