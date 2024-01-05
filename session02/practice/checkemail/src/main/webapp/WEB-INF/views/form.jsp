<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Check Email</title>
</head>
<body style="background:lightblue;">
<h2>Check Email:</h2>
<hr>
<h3 style="color:red;">${message}</h3>
<form action="check" method="post">
    <fieldset>
        <legend>Enter your email to check:</legend>
        <input type="text" name="email"> <br><br>
        <input type="submit" value="Check">
    </fieldset>
</form>
</body>
</html>