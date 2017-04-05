<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" type="text/css" href="../../css/style.css">

<html>
<head>
    <title>DepEdit</title>
</head>
<body>
<div class="titleTable">Edit Department</div>
<div>
    <c:out value="Department Name:"/>
    <span class="my-text">
            * ${errorMap.name}
        </span>
</div>
<form action="DepSave" method="post">
    <div>
        <label>
            <input type="text" name="DepName" pattern="[A-Za-z]{3,}" value="<c:out value="${param['DepName'] eq null ? department.name : param['DepName']}"/>"/>
            <input type="hidden" name="DepID" value="${depId}"/>

        </label>
    </div>
    <div>
        <input type="submit" value="OK">
    </div>
</form>
<div>
    <span class="my-text"> * Required Fields</span>
</div>
Return to <a href="DepartmentsList"> Departments</a>
</body>
</html>