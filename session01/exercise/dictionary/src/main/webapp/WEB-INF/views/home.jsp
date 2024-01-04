<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Google translate</title>
</head>
<body style="background:lightblue;">
<h2>Google translate</h2>
<hr>
<form action="translate" method="post">
    <p><label for="english">English:</label>
        <input type="text" placeholder="Type some text..." name="english" id="english"></p>

    <p>Vietnamese: ${vietnamese}</p>
    <input type="submit" value="Translate">
</form>
</body>
</html>
