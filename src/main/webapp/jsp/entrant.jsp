<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Entrant</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
</head>
<body>
<c:import url="header.jsp"/>

<c:if test="${exist == true}">
    <div class="container">
        <h2 class="mb-3">You are already registered, your data:</h2>

        <c:if test = "${entrant.photo == null}">
            <td>
                <img class="photo" src="https://clipartart.com/images250_/default-profile-picture-clipart-6.png" width="200px">
            </td>
        </c:if>
        <c:if test = "${entrant.photo != null}">
            <td>
                <img class="photo" src="download_photo?id=${entrant.entrantId}" width="200px">
            </td>
        </c:if>
        <br>
        <p>First name: ${entrant.firstName}</p>
        <p>Last name: ${entrant.lastName}</p>
        <p>Phone number: ${entrant.phoneNumber}</p>
        <p>Email: ${entrant.email}</p>
        <p>Score for special achievements: ${entrant.scoreForSpecialAchievements}</p>
        <p>GPAofCertificate: ${entrant.GPAofCertificate}</p>
        <p>Rating point: ${entrant.ratingPoint}</p>
    </div>
</c:if>

<c:if test="${exist != true}">
    <div class = "container mt-3">
        <h1 class="mb-3">Enter your data</h1>
        <form action="/add_entrant" enctype="multipart/form-data" method="post">
            <label>Your photo:</label>
            <input type="file" name="photo"><br>
            <label>First name:</label>
            <input type="text" name = "firstName" value="${user.firstName}" placeholder="Input your first name" class="form-control"><br>
            <label>Last name:</label>
            <input type="text" name = "lastName" value="${user.lastName}" placeholder="Input your last name" class="form-control"><br>
            <label>Phone number:</label>
            <input type="text" name = "phoneNumber" placeholder="Input your phone number" class="form-control"><br>
            <label>Email:</label>
            <input type="email" readonly name="email" value="${user.email}" class="form-control"><br>
            <label>Score for special achievements:</label>
            <input type="number" step="any" name = "scoreForSpecialAchievements" placeholder="Input your score for special achievements" class="form-control"><br>
            <label>GPA of certificate:</label>
            <input type="number" step="any" name = "GPAofCertificate" placeholder="Input your GPA of certificate" class="form-control"><br>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            <button type="submit" class="btn btn-dark">Fill</button><br>
        </form>
    </div>
</c:if>


</body>
</html>