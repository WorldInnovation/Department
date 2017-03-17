<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" type="text/css" href="../../css/style.css" >
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<link rel="stylesheet" href="/resources/demos/style.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script>
    $( function() {
        $('#datepicker').datepicker({dateFormat: "yy-mm-dd"});
    } );
</script>
<html>
<head>
    <title> Employee </title>
</head>

<body>
<div class="titleTable">
    Employee
</div>
<form action="EmpSave" method="post">
    <input type="hidden" name="EmpID" value="${empID}"/>
    <input type="hidden" name="DepID" value="${depID}"/>
    <input type="hidden" name="employee" value="${employee}" />
    <table >
        <caption>
        <span class="titleTable">
            Employees
        </span>
        </caption>
        <tr>
            <td> <c:out value="First Name:" /> <span class="my-text"> * </span>
                <div>
                    <span class="my-text">
                        ${errorMap.firstName}
                    </span>
                </div>
            </td>
            <td>
                <label>
                    <input type="text" name="FirstName" pattern="[A-Za-z]{3,}" value="<c:out value="${param['firstName'] eq null ? employee.firstName : param['firstName']}"/>"/>
                </label>
            </td>
        </tr>
        <tr>
            <td>Second Name: <span class="my-text"> * </span>
                <div>
                    <span class="my-text">
                        ${errorMap.secondName}
                    </span>
                </div>
            </td>
            <td>
                <label>
                    <%-- <input type="text" name="SecondName" value="<c:out value="${employee.secondName}" />" >--%>
                    <input type="text" name="SecondName" pattern="[A-Za-z]{3,}"value="<c:out value="${param['secondName'] eq null ? employee.secondName : param['secondName']}"/>"/>
                </label>
            </td>
        </tr>
        <tr>
            <td>Grade: <span class="my-text"> * </span>
                <div>
                    <span class="my-text">
                        ${errorMap.grade}
                    </span>
                </div>
            </td>
            <td>
                <label>
                    <%-- <input type="text" name="Grade" value="<c:out value="${employee.grade}" />" >--%>
                    <input type="text" name="Grade" value="<c:out value="${param['grade'] eq null ? employee.grade : param['grade']}"/>"/>
                </label>
            </td>
        </tr>
        <tr>
            <td>Birthday: <span class="my-text">*</span>
                <div>
                    <span class="my-text">
                        ${errorMap.birthday}
                    </span>
                </div>
            </td>
            <td>
                <label>
                    <p><input type="text" id="datepicker" name="Birthday" placeholder="<fmt:formatDate pattern='yyyy-MM-dd' value='${employee.birthday}' />"
                              value="<fmt:formatDate pattern='yyyy-MM-dd' value='${employee.birthday}' />">
                    </p>

                </label>

            </td>
        </tr>
        <tr>
            <td>eMail : <span class="my-text">*</span>
                <div>
                    <span class="my-text">
                        ${errorMap.eMail}
                    </span>
                </div>
            </td>
            <td>
                <label>
                    <input type="text" name="EMail"  pattern="([A-z0-9_.-]{3,})@([A-z0-9_.-]{1,}).([A-z]{2,8})" value="<c:out value="${param['eMail'] eq null ? employee.eMail : param['eMail']}"/>"/>
                </label>

            </td>
        </tr>
        <tr>
            <td><span class="my-text"> * Required Fields</span></td>

        </tr>
        <tr>
            <td>
                <input type="submit"  value="Submit"/>
            </td>
        </tr>
    </table>
</form>
</body>
</html>



