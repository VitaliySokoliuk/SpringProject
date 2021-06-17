<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="en">
<head>
    <title>Admin</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
    <link href="<c:url value="/resources/css/f_d_menu.css"/>" rel="stylesheet">
</head>
<body>

<c:import url="header.jsp"/>

<div class="container">

    <c:choose>

        <c:when test="${mode == 'ADMIN_CHOOSE'}">
            <div class="item">
                <a href="add_f">Add faculty</a>
            </div>

            <div class="item">
                <a href="add_d">Add department</a>
            </div>
        </c:when>

        <c:when test="${mode == 'ADD_FACULTY'}">

            <form method="post">
                <input type="text" name = "name" placeholder="Input a faculty name" class="form-control"><br>
                <input type="text" name = "description" placeholder="Input a faculty description" class="form-control"><br>
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                <button type="submit" class="btn btn-dark">Create</button><br>
            </form>
            <br>

            <table class="table table-striped">
                <thead>
                <tr>
                    <th>Id</th>
                    <th>Name</th>
                    <th>Description</th>
                    <th>Edit</th>
                    <th>Delete</th>
                    <th>Add departments</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="elem" items="${faculties}">
                    <tr>
                        <td>${elem.facultyId}</td>
                        <td>${elem.facultyName}</td>
                        <td>${elem.description}</td>
                        <td><a href="fac_update?id=${elem.facultyId}">edit</a></td>
                        <td><a href="fac_delete?id=${elem.facultyId}">delete</a></td>
                        <td><a href="fac_add_dep?id=${elem.facultyId}">add departments</a></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>

        </c:when>

        <c:when test="${mode == 'UPDATE_FACULTY'}">
            <div class = "container mt-3">
                <h1 class="mb-3">Edit faculty</h1>
                <div>
                    <form method="post">
                        <input type="text" value="${fac.facultyName}" name = "name" placeholder="Input a faculty name" class="form-control"><br>
                        <input type="text" value="${fac.description}" name = "description" placeholder="Input a faculty description" class="form-control"><br>
                        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                        <button type="submit" class="btn btn-dark">Edit</button><br>
                    </form>
                </div>
            </div>
            <br>
            <table class="table table-striped">
                <thead>
                <tr>
                    <th>Id</th>
                    <th>Name</th>
                    <th>Max number of students</th>
                    <th>Delete</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="elem" items="${used_dep}">
                    <tr>
                        <td>${elem.departmentId}</td>
                        <td>${elem.departmentName}</td>
                        <td>${elem.maxNumberOfStudents}</td>
                        <td><a href="del_dep_from_fac?dep_id=${elem.departmentId}">Delete department from faculty</a></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </c:when>

        <c:when test="${mode == 'ADD_DEPARTMENT_TO_FACULTY'}">

            <table class="table table-striped">
                <thead>
                <tr>
                    <th>Id</th>
                    <th>Name</th>
                    <th>Max number of students</th>
                    <th>Add</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="elem" items="${freeDepartments}">
                    <tr>
                        <td>${elem.departmentId}</td>
                        <td>${elem.departmentName}</td>
                        <td>${elem.maxNumberOfStudents}</td>
                        <td><a href="add_dep_to_fac?dep_id=${elem.departmentId}">Add department</a></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>

        </c:when>


        <c:when test="${mode == 'ADD_DEPARTMENT'}">

            <form method="post">
                <input type="text" name = "name" placeholder="Input a department name" class="form-control"><br>
                <input type="number" name = "number" min="1" max="250" placeholder="Input max number of students" class="form-control"><br>
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                <button type="submit" class="btn btn-dark">Create</button><br>
            </form>
            <br>

            <table class="table table-striped">
                <thead>
                <tr>
                    <th>Id</th>
                    <th>Name</th>
                    <th>Max number of students</th>
                    <th>Edit</th>
                    <th>Delete</th>
                    <th>Statistics</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="elem" items="${departments}">
                    <tr>
                        <td>${elem.departmentId}</td>
                        <td>${elem.departmentName}</td>
                        <td>${elem.maxNumberOfStudents}</td>
                        <td><a href="dep_update?id=${elem.departmentId}">edit</a></td>
                        <td><a href="dep_delete?id=${elem.departmentId}">delete</a></td>
                        <td><a href="dep_stat?id=${elem.departmentId}">statistics</a></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </c:when>

        <c:when test="${mode == 'UPDATE_DEPARTMENT'}">
            <div class = "container mt-3">
                <h1 class="mb-3">Edit department</h1>
                <div>
                    <form method="post">
                        <input type="text" value="${dep.departmentName}" name = "name" placeholder="Input a department name" class="form-control"><br>
                        <input type="number" value="${dep.maxNumberOfStudents}" min="1" max="250" name = "number" placeholder="Input max number of students" class="form-control"><br>
                        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                        <button type="submit" class="btn btn-dark">Edit</button><br>
                    </form>
                </div>
            </div>
        </c:when>

        <c:when test="${mode == 'STATISTICS_DEPARTMENT'}">
            <h1 class="mb-3">Department statistics</h1>
            <c:if test="${facList == []}">
                 <br> <h3 class="mb-3">Department has not statistics</h3>
            </c:if>
            <c:if test="${facList != []}">
            <table class="table table-striped">
                <thead>
                <tr>
                    <th>Id</th>
                    <th>Name</th>
                    <th>Description</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="elem" items="${facList}">
                    <tr>
                        <td>${elem.facultyId}</td>
                        <td>${elem.facultyName}</td>
                        <td>${elem.description}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            </c:if>

        </c:when>

    </c:choose>

</div>


</body>
</html>