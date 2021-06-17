<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Request for entry</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
    <link href="<c:url value="/resources/css/entrant.css"/>" rel="stylesheet">
</head>
<body>
<c:import url="header.jsp"/>

<div class = "container mt-3">
    <c:if test="${exist == false}">
        <h2 class="mb-3">At first you must register and add your marks if you want to choose the department</h2>
    </c:if>

    <c:if test="${exist == true}">
        <h1 class="mb-3">Choose the department</h1>
        <table class="table table-striped">
            <thead>
            <tr>
                <th>Department code</th>
                <th>Faculty name</th>
                <th>Department name</th>
                <th>Request</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="elem" items="${depDescription}">
                <tr>
                    <td>${elem.departmentsCode}</td>
                    <td>${elem.facultyName}</td>
                    <td>${elem.departmentName}</td>
                    <td><a href="add_req_for_entry?depCode=${elem.departmentsCode}">Choose</a></td>
                </tr>
            </c:forEach>
            <c:forEach var="elem" items="${nonActive}">
                <tr>
                    <td class="non">${elem.departmentsCode}</td>
                    <td class="non">${elem.facultyName}</td>
                    <td class="non">${elem.departmentName}</td>
                    <td class="non"><a class="non" href="add_req_for_entry?depCode=${elem.departmentsCode}">Choose</a></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </c:if>
</div>


</body>
</html>