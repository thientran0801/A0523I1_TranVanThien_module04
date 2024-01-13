<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Setting mail page</title>
</head>
<style>
    td {
        padding: 20px;
    }
</style>
<body>
<h3>Setting your email</h3>
<hr>
<form:form method="post" action="savesetting" modelAttribute="settingmail">
    <table>
        <tr>
            <td>Language:</td>
            <td>
                <form:select path="language" multiple="${false}">
                    <form:options items="${listlanguage}"/>
                </form:select>
            </td>
        </tr>
        <tr>
            <td>Page size:</td>
            <td>
                Show <form:select path="pageSize" multiple="${false}">
                <form:options items="${listsize}"/>
            </form:select>
            </td>
        </tr>
        <tr>
            <td>Spams filter:</td>
            <td>
                <form:checkbox path="spamsFilter"/>
                    Enable spams filter
            </td>
        </tr>
        <tr>
            <td>Signature:</td>
            <td>
                <form:textarea path="signature"/>
            </td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" value="submit"> <input type="reset" value="cancel"></td>
        </tr>
    </table>
</form:form>
</body>
</html>
