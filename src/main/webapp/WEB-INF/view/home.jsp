<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<html>

<head>
    <title>NGA Company Home Page</title>
</head>

<body>
    <h2>NGA Company Home Page</h2>
    <hr>
    <p>
        Welcome to the NGA Company Home Page!
    </p>

    <hr>
    <!-- Display user name and role -->
    <p>
        User: <security:authentication property="principal.username" />
        <br><br>
        Role(s): <security:authentication property="principal.authorities" />
        <br><br>
        First name: ${user.firstName}, Last name: ${user.lastName}, Email: ${user.email}
    </p>

    <security:authorize access="hasRole('MANAGER')">
    <!-- Add link to point to /leaders ... this is for managers -->
        <hr>
    <p>
        <a href="${pageContext.request.contextPath}/leaders">Leadership Meeting</a>
        (Only for Manager peeps)
    </p>
    </security:authorize>

    <security:authorize access="hasRole('ADMIN')">
    <!-- Add a link to point to /systems ... this is for the admins -->
        <hr>
    <p>
        <a href="${pageContext.request.contextPath}/systems">IT Systems Meeting</a>
        (Only for Admin peeps)
    </p>
    </security:authorize>

    <hr>

    <!-- Add a logout button -->
    <form:form action="${pageContext.request.contextPath}/logout" method="post">
        <input type="submit" value="Logout" />
    </form:form>

</body>

</html>