<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/tld/c.tld" prefix="c"%>
<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean"%>
<%@ page isELIgnored="false" %>
<html>
	<head>
		<title>Main</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" href="./bootstrap/css/bootstrap.min.css">
        <script src="./bootstrap/js/bootstrap.min.js"></script>
	</head>
	<body>
        <tr>
			<td>
                <label class="control-label small center-block" style="padding: 0 5px;" for="userName"><bean:message key="login.language"/>
				<a href="changeLocale.do?method=english">English</a>
				<a href="changeLocale.do?method=russian">Русский</a>
                </label>
			</td>
		</tr><hr style="margin: 2px 0;">
		<jsp:useBean id="user" class="by.epamlab.beans.user.User" scope="session"/>
        <c:set var="visitor" value="<%=by.epamlab.beans.user.Role.VISITOR%>"/>

        <c:if test="${user.role != visitor}">
            <html:form action="/logout" method="POST" styleClass="form-inline" style="margin: 0; padding: 0;">
                <div class="form-group" style="margin: 0; padding: 0 5px;" >
                    <h4 style="margin: 0; padding: 0; height: 20px;">
                        <small><bean:message key="login.welcome"/></small>  <jsp:getProperty name="user" property="name"/>
                    </h4>
                </div>
                <div class="form-group" style="margin: 0; padding: 0 5px; float: right;" >
					<html:submit styleClass="btn btn-link btn-sm" style="height: 20px; padding: 0; padding-left: 10px;">
						<bean:message key="login.logout"/>
					</html:submit>
				</div>
			</html:form>
		</c:if>

		<c:if test="${user.role == visitor}">
            <html:form action="/login" method="POST" styleClass="form-inline" style="margin: 0; padding: 0;">
				<div class="form-group" style="margin: 0; padding: 0 5px;" >
                    <label class="control-label small" for="userName" style="padding: 0; width: 130px;"><bean:message key="login.userName"/></label>
                </div>
                <div class="form-group" style="margin: 0; padding: 0 5px;" >
                        <html:text property="userName" styleId="userName" styleClass="form-control input-sm" style="height: 25px;"/>
                </div>
                <div class="form-group" style="margin: 0; padding: 0 5px; color:red">
                    <html:errors property="userName" />
                </div>
                <div class="form-group" style="margin: 0; padding: 0 5px;" >
                        <label class="control-label small center-block" style="padding: 0;" for="password"><bean:message key="login.password"/></label>
                </div>
                <div class="form-group" style="margin: 0; padding: 0 5px;" >
                        <html:password property="password" styleId="password" styleClass="form-control input-sm" style="height: 25px;"/>
                </div>
                <div class="form-group" style="margin: 0; padding: 0 5px; color:red">
                    <html:errors property="password" />
                </div>
                <div class="form-group" style="margin: 0; padding: 0 5px;" >
                    <html:submit styleClass="btn btn-link btn-sm" style="height: 20px; padding: 0; padding-left: 10px;">
                        <bean:message key="login.login"/>
                    </html:submit>
                </div>
                <div class="form-group" style="margin: 0; padding: 0 5px; color:red">
                    <html:errors property="nouser" />
                </div>
                <div class="form-group" style="margin: 0; padding: 0 5px; float: right;">
                    <div class="form-inline col-lg-push-12">
                        <html:link action="/registration" styleClass="btn btn-link btn-sm" style="padding: 0;">
                            <bean:message key="login.registration"/>
                        </html:link>
                    </div>
                </div>
			</html:form>
		</c:if>
		<hr style="margin: 2px 0">

	</body>
</html>