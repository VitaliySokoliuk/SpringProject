<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Mark</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
</head>
<body>
<c:import url="header.jsp"/>

<div class = "container mt-3">

    <c:if test="${exist == false}">
        <h1 class="mb-3">At first you must register if you want to add your marks</h1>
    </c:if>

    <c:if test="${allow == false}">
        <h1 class="mb-3">You have already input marks for five subjects</h1>
    </c:if>

    <c:if test="${exist == true && allow == true}">
        <h1 class="mb-3">Enter your marks</h1>
        <h4 class="mb-3">Remember, you can add marks for five subjects</h4>
        <form action="/add_marks" method="post">
            <label>Choose subject</label>

            <select class="form-control" name="subject">
                <c:forEach var="sub" items="${subjects}">
                    <option value="${sub}">${sub}</option>
                </c:forEach>
            </select>

            <label>Score</label>
            <input type="number" step="any" min="100" max="200" name = "score" placeholder="Input your score" class="form-control"><br>

            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            <button type="submit" class="btn btn-dark">Fill</button><br>
        </form>
    </c:if>

    <c:if test="${allMarks != [] && allMarks != null}">
        <table class="table table-striped">
            <thead>
            <tr>
                <th>Subject</th>
                <th>Score</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="elem" items="${allMarks}">
                <tr>
                    <td>${elem.subject}</td>
                    <td>${elem.score}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </c:if>

</div>

</body>
</html>