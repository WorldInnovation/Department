<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<link rel="stylesheet" type="text/css" href="../../css/style.css" >

<html>
<head>

    <title> Departments </title>
</head>

<body>

<div >
    <span class="titleTable"> Departments </span>
</div>

<form action="EditDepartment" method="get">
    <input type="submit" value="New Department">  </form>
<table >
    <caption >
        <span class="titleTable">Departments </span>
    </caption>
    <tr>
        <td>ID</td>
        <td>Name</td>
        <td>Select</td>
        <td>Edit</td>
        <td>Delete</td>
    </tr>
    <tr>
        <c:forEach items="${departments}" var="dep">
    <tr >
        <td >${dep.id}</td>
        <td>${dep.name}</td>
        <td> <form action="EmployeesList" method="get">
            <input type="hidden" name="DepID" value="${dep.id}" >
            <input type="submit" value="Select">
        </form>
        </td>

        <td>    <form action="EditDepartment" method="get">
            <input type="hidden" name="DepID" value="${dep.id}" >
            <input type="submit" value="Edit">  </form>
        </td>

        <td> <form  action="DepDelete" method="post">
            <input type="hidden" name="DepID" value="${dep.id}" >
            <input  type="submit"  value="Delete">  </form>
        </td>

    </tr>
    </c:forEach>

</table>

</body>
</html>