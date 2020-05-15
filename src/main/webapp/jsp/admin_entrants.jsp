<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="en">
<head>
    <title>Admin</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
    <link href="<c:url value="/resources/css/admin_entrants.css"/>" rel="stylesheet">
</head>
<body>

<c:import url="header.jsp"/>

<c:choose>
    <c:when test="${mode == 'ALL_ENTRANTS'}">
        <div class="box">
            <table class="table table-striped">
                <thead>
                <tr align = "center">
                    <th>Entrant id</th>
                    <th>First name</th>
                    <th>Last name</th>
                    <th>Phone number</th>
                    <th>Email</th>
                    <th>Status</th>
                    <th>Rating point</th>
                    <th>Score for special achievements</th>
                    <th>GPA of certificate</th>
                    <th colspan="2">Refactor</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="elem" items="${allEntrant}">
                    <tr align = "center">
                        <td>${elem.entrantId}</td>
                        <td>${elem.firstName}</td>
                        <td>${elem.lastName}</td>
                        <td>${elem.phoneNumber}</td>
                        <td>${elem.email}</td>
                        <td>${elem.status}</td>
                        <td>${elem.ratingPoint}</td>
                        <td>${elem.scoreForSpecialAchievements}</td>
                        <td>${elem.GPAofCertificate}</td>
                        <td><a href="update_entrant?ent_id=${elem.entrantId}">Edit entrant</a></td>
                        <td><a href="update_requests?ent_id=${elem.entrantId}">Edit requests</a></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </c:when>

    <c:when test="${mode == 'UPDATE_ENTRANT'}">
        <div class = "container mt-3">
            <h1 class="mb-3">Edit entrant</h1>
            <div>
                <form method="post">
                    <input type="text" value="${entrant.firstName}" name = "firstName" placeholder="Input first name" class="form-control"><br>
                    <input type="text" value="${entrant.lastName}" name = "lastName" placeholder="Input last name" class="form-control"><br>
                    <input type="text" value="${entrant.phoneNumber}" name = "phoneNumber" placeholder="Input a phone number" class="form-control"><br>
                    <input type="hidden" value="${entrant.entrantId}" name="entrantId"/>
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                    <button type="submit" class="btn btn-dark">Edit</button><br>
                </form>
            </div>
        </div>
    </c:when>

    <c:when test="${mode == 'UPDATE_ENTRANT_REQUESTS'}">
        <div class="box">
            <table class="table table-striped">
                <thead>
                <tr align = "center">
                    <th>Request id</th>
                    <th>Department</th>
                    <th>Rating score</th>
                    <th>Request time</th>
                    <th>Delete</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="elem" items="${requests}">
                    <tr align = "center">
                        <td>${elem.requestId}</td>
                        <td>${elem.department.department.departmentName}</td>
                        <td>${elem.ratingScore}</td>
                        <td>${elem.requestTime}</td>
                        <td><a href="delete_requests?req_id=${elem.requestId}">Delete</a></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </c:when>

</c:choose>

</body>
</html>
