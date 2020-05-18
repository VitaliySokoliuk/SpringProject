<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="en">
<head>
    <title>Finish Entry</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<%--    <link href="<c:url value="/resources/css/admin_page.css"/>" rel="stylesheet">--%>
</head>
<body>

<c:import url="header.jsp"/>

<div class="container">

    <a href="finish">Finish entry</a>
    <br>
    <br>
    <c:if test="${students != []}">
        <div>
            <table class="table table-striped">
                <thead>
                <tr align = "center">
                    <th>First name</th>
                    <th>Last name</th>
                    <th>Email</th>
                    <th>Rating score</th>
                    <th>Department name</th>
                    <th>Faculty name</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="elem" items="${students}">
                    <tr align = "center">
                        <td>${elem.requestId.entrant.firstName}</td>
                        <td>${elem.requestId.entrant.lastName}</td>
                        <td>${elem.requestId.entrant.email}</td>
                        <td>${elem.requestId.ratingScore}</td>
                        <td>${elem.requestId.department.department.departmentName}</td>
                        <td>${elem.requestId.department.faculty.facultyName}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </c:if>
</div>


</body>
</html>