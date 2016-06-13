<%@ page language="java" contentType="text/html;charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
</head>
<body>
    <tiles:insert attribute="header"/>
    <tiles:insert attribute="title"/>
    <tiles:insert attribute="body"/>
    <tiles:insert attribute="pages"/>
    <tiles:insert attribute="footer"/>
</body>
</html>