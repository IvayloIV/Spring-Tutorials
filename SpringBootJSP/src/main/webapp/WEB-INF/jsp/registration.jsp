<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>

<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>Conference</title>
    </head>
    <body>
        <h2>Registration</h2>
        <f:form modelAttribute="person">
            <p>
                Name: <f:input path="name" />
                <f:errors path="name" cssStyle="color: red"/>
            </p>
            <input type="submit" value="Add" />
        </f:form>
    </body>
</html>