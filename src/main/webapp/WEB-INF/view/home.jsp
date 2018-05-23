<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<html>

<head>
	<title>luv2code Company Home Page</title>
</head>

<body>
	<h2>luv2code Company Home Page</h2>
	<hr>
	
	Welcome to the luv2code company home page!
	<br/><br/><hr/>
    <p>
        User : <security:authentication property="principal.username"/><br/>
        Role(s) : <security:authentication property="principal.authorities"/>
    </p>
    <hr/>

    <p>
        <security:authorize access="hasRole('ROLE_MANAGER')">
        <a href="${pageContext.request.contextPath}/leaders">Leadership Meeting</a>
        (Only for Manager)<br/>
        </security:authorize> <security:authorize access="hasRole('ROLE_ADMIN')">
        <a href="${pageContext.request.contextPath}/systems">Admin Systems Meeting</a>
        (Only for Manager)
        </security:authorize>
    </p>
    <br/><br/>

	<form:form method="post" action="${pageContext.request.contextPath}/logout">
		<input type="submit" value="Logout">
	</form:form>
</body>

</html>