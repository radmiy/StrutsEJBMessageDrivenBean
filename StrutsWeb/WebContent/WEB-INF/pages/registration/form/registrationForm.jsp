<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="by.epamlab.beans.user.User" %>
<%@ page import="by.epamlab.beans.user.Role" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="/WEB-INF/tld/c.tld" prefix="c"%>
<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean"%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF8">
		<title>Login</title></head>
		<link rel="stylesheet" href="./bootstrap/css/bootstrap.min.css">
		<script src="./bootstrap/js/bootstrap.min.js"></script>
	</head>
	<body>
		<div class="container"> <br />
    	<div class="row">
    		<div class="col-md-4 col-md-offset-4">
				<div class="panel panel-default">
					<div class="panel-heading"><strong><bean:message key="registration.title"/></strong> <small> </small></div>
					<div class="panel-body">
						<html:form method="POST" action="/reg">
    						<div class="form-group">
      							<label for="login"><bean:message key="registration.userNameReg"/></label>
      							<html:text property="userNameReg" styleClass="form-control" styleId="login"/>
    						</div>
							<div class="form-group" style="margin: 0; padding: 0 5px; color:red" >
								<html:errors property="userNameReg" />
							</div>
    						<div class="form-group">
      							<label for="passwordReg"><bean:message key="registration.passwordReg"/></label>
      							<html:password property="passwordReg" styleClass="form-control" styleId="passwordReg"/>
								<div class="form-group" style="margin: 0; padding: 0 5px; color:red">
									<html:errors property="passwordReg" />
								</div>
      							<label for="repeatPasswordReg"><bean:message key="registration.repeatPasswordReg"/></label>
      							<html:password property="repeatPasswordReg" styleClass="form-control" styleId="repeatPasswordReg"/>
								<div class="form-group" style="margin: 0; padding: 0 5px; color:red">
									<html:errors property="repeatPasswordReg" />
								</div>
    						</div>
    						<html:submit styleClass="btn btn-default"><bean:message key="registration.register"/></html:submit>
							<div class="form-group" style="margin: 0; padding: 0 5px; color:red">
								<html:errors property="passwordsMachReg" />
							</div>
  						</html:form>
					</div>
				</div>
			</div>
		</div>
		</div>
	</body>
</html> 
