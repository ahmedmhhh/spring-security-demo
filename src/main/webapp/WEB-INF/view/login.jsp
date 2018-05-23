<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Login Now</title>
    <STYLE>
        .error{
            color:red;
        }
    </STYLE>
</head>
<body>
<h3>My Custom Login Page</h3>
    <form:form action="${pageContext.request.contextPath}\authenticateTheUrl" method="post">
        <c:if test="${param.error!=null}">
            <i class="error">Sorry ! You entered invalid username / password </i>
        </c:if>
        <p>User Name : <input type="text" name="username"></p>
        <p>Password : <input type="password" name="password"></p>
        <input type="submit" value="login">
    </form:form>
</body>
</html>
