<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Setting mail page</title>
</head>
<body>
<h3>Setting your email</h3>
<hr>
<form:form method="post" action="savesetting" modelAttribute="settingmail">
    <table>
        <tr>
            <td>Language: </td>
            <td>
                <form:select path="language" multiple="${false}">
                    <form:options items="${listlanguage}">
                    </form:options>
                </form:select>
            </td>
        </tr>
        <tr>
            <td>Page size:</td>
            <td>
                Show <form:select path= "pageSize" multiple="${false}">
                <form:options items="${listsize}"></form:options>
            </form:select>
            </td>
        </tr>
        <tr>
            <td>Spams filter:</td>
            <td><form:checkbox path="spamsFilter">
                Enable spams filter</e>
            </form:checkbox></td>
        </tr>
        <tr>
            <td>Signature: </td>
            <td>
                <textarea></textarea>
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
