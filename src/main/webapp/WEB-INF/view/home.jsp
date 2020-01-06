<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

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

    <!-- Add a logout button -->
    <form:form action="${pageContext.request.contextPath}/logout" method="post">
        <input type="submit" value="Logout" />
    </form:form>

</body>

</html>